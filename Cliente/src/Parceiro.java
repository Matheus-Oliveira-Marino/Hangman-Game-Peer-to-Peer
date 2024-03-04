import java.io.*;
import java.net.*;
import java.util.concurrent.Semaphore;


/**
 * A classe {@code Parceiro} representa um parceiro de comunicação em uma conexão 'TCP'.
 */
public class Parceiro
{
    private Socket             conexao; // Representa a conexão TCP com o parceiro.
    private ObjectInputStream  receptor; // 'Stream' de entrada para receber dados do parceiro.
    private ObjectOutputStream transmissor; // 'Stream' de saída para enviar dados ao parceiro.

    private Comunicado proximoComunicado=null; // Próximo comunicado a ser enviado ou recebido.

    // Semáforo para garantir exclusão mútua na leitura e escrita
    private Semaphore mutEx = new Semaphore (1,true); 


    /**
     * Construtor da classe {@code Parceiro}.
     * 
     * @param conexao    A conexão 'TCP' com o parceiro.
     * @param receptor   O 'stream' de entrada para receber dados do parceiro.
     * @param transmissor O 'stream' de saída para enviar dados ao parceiro.
     * @throws Exception Se algum dos parâmetros for nulo.
     */
    public Parceiro (Socket             conexao,
                     ObjectInputStream  receptor,
                     ObjectOutputStream transmissor)
            throws Exception // se parâmetros nulos.
    {

         // Verifica se os parâmetros são nulos
        if (conexao==null)
            throw new Exception ("Conexao ausente");

        if (receptor==null)
            throw new Exception ("Receptor ausente");

        if (transmissor==null)
            throw new Exception ("Transmissor ausente");


        // Inicializa os atributos.    
        this.conexao     = conexao;
        this.receptor    = receptor;
        this.transmissor = transmissor;
    }


    /**
     * Envia um objeto 'comunicado' para o servidor.
     *
     * @param x O objeto 'comunicado' a ser enviado.
     * @throws Exception Se ocorrer um erro durante a transmissão.
     */
    public void receba (Comunicado x) throws Exception
    {
        try
        {
            this.transmissor.writeObject (x);
            this.transmissor.flush       ();
        }
        catch (IOException erro)
        {
            erro.printStackTrace();
            throw new Exception ("Erro de transmissao");
        }
    }


     /**
     * Espia o próximo 'comunicado' recebido do servidor sem consumi-lo.
     *
     * @return O próximo 'comunicado' recebido do servidor.
     * @throws Exception Se ocorrer um erro durante a recepção.
     */
    public Comunicado espie () throws Exception 
    {
        try
        {
            // Adquire o semáforo para garantir exclusão mútua.
            this.mutEx.acquireUninterruptibly();

            // Se não houver próximo comunicado, lê o próximo do 'stream' de entrada.
            if (this.proximoComunicado==null) this.proximoComunicado = (Comunicado)this.receptor.readObject();

            // Libera o semáforo.
            this.mutEx.release();

            // Retorna o próximo comunicado.
            return this.proximoComunicado;
        }
        catch (Exception erro)
        {
            throw new Exception ("Erro de recepcao");
        }
    }


    /**
     * Recebe o próximo comunicado do servidor.
     *
     * @return O próximo comunicado recebido do servidor.
     * @throws Exception Se ocorrer um erro durante a recepção.
     */
    public Comunicado envie () throws Exception 
    {
        try
        {
            // Se não houver próximo comunicado, lê o próximo do 'stream' de entrada.
            if (this.proximoComunicado==null) this.proximoComunicado = (Comunicado)this.receptor.readObject();

            // Salva o próximo comunicado em uma variável temporária.
            Comunicado ret         = this.proximoComunicado;
            
            // Limpa o próximo comunicado.
            this.proximoComunicado = null;

            // Retorna o próximo comunicado.
            return ret;
        }
        catch (Exception erro)
        {
            erro.printStackTrace();
            throw new Exception ("Erro de recepcao");

        }
    }


     /**
     * Fecha a conexão com o servidor.
     *
     * @throws Exception Se ocorrer um erro ao fechar a conexão.
     */
    public void adeus () throws Exception
    {
        try
        {
            // Fecha os streams e a conexão.
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


