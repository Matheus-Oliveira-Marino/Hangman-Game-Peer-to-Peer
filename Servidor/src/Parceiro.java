import java.io.*;
import java.net.*;
import java.util.concurrent.Semaphore;


/**
 * A classe {@code Parceiro} representa um parceiro de comunicação em uma conexão socket.
 * Ele é responsável por enviar e receber objetos {@code Comunicado} pela conexão socket.
 */
public class Parceiro
{
    private Socket             conexao; // O 'socket' de conexão com o cliente.
    private ObjectInputStream  receptor; // O 'stream' de entrada de objetos.
    private ObjectOutputStream transmissor; // O 'stream' de saída de objetos.


    // O próximo comunicado a ser enviado ou recebido.
    private Comunicado proximoComunicado=null;

    // Um semáforo para controlar o acesso concorrente aos recursos compartilhados.
    private Semaphore mutEx = new Semaphore (1,true);


    /**
     * Construtor da classe {@code Parceiro}.
     *
     * @param conexao    o socket de conexão
     * @param receptor   o stream de entrada para receber objetos
     * @param transmissor o stream de saída para enviar objetos
     * @throws Exception se algum dos parâmetros for nulo
     */
    public Parceiro (Socket             conexao,
                     ObjectInputStream  receptor,
                     ObjectOutputStream transmissor)
            throws Exception // se parametro nulos
    {
        if (conexao==null)
            throw new Exception ("Conexao ausente");

        if (receptor==null)
            throw new Exception ("Receptor ausente");

        if (transmissor==null)
            throw new Exception ("Transmissor ausente");

        this.conexao     = conexao;
        this.receptor    = receptor;
        this.transmissor = transmissor;
    }


    /**
     * Envia um objeto {@code Comunicado} pela conexão 'socket'.
     *
     * @param x o comunicado a ser enviado.
     * @throws Exception se ocorrer um erro durante a transmissão.
     */
    public void receba (Comunicado x) throws Exception
    {
        try
        {
            this.transmissor.writeObject (x);
            System.out.println(x);
            this.transmissor.flush       ();
        }
        catch (IOException erro)
        {
            erro.printStackTrace();
            throw new Exception ("Erro de transmissao");
        }
    }


     /**
     * Espia o próximo comunicado disponível na conexão 'socket'.
     * Espia um comunicado oriundo do 'Cliente'.
     *
     * @return o próximo comunicado disponível.
     * @throws Exception se ocorrer um erro ao receber o comunicado.
     */
    public Comunicado espie () throws Exception 
    {
        try
        {
            this.mutEx.acquireUninterruptibly();
            if (this.proximoComunicado==null) this.proximoComunicado = (Comunicado)this.receptor.readObject();
            this.mutEx.release();
            return this.proximoComunicado;
        }
        catch (Exception erro)
        {
            throw new Exception ("Erro de recepcao");
        }
    }


     /**
     * Envia o próximo comunicado ao cliente.
     *
     * @return o próximo comunicado a ser enviado ao cliente.
     * @throws Exception se ocorrer um erro ao enviar o comunicado.
     */
    public Comunicado envie () throws Exception //Envie ao CLIENTE UMA RESPOSTA!
    {
        try
        {
            if (this.proximoComunicado==null) this.proximoComunicado = (Comunicado)this.receptor.readObject();
            Comunicado ret         = this.proximoComunicado;
            this.proximoComunicado = null;
            return ret;
        }
        catch (Exception erro)
        {
            erro.printStackTrace();
            throw new Exception ("Erro de recepcao");

        }
    }


    /**
     * Fecha os streams de entrada e saída e o socket de conexão.
     *
     * @throws Exception se ocorrer um erro ao fechar os recursos de comunicação.
     */
    public void adeus () throws Exception
    {
        try
        {
            this.transmissor.close();
            this.receptor   .close();
            this.conexao    .close();
        }
        catch (Exception erro)
        {
            throw new Exception ("Erro de desconexao");
        }
    }
}


