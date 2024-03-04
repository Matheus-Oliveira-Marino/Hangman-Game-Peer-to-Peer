import java.net.*;
import java.util.*;

/**
 * A classe {@code `AceitadoraDeConexao`} é responsável por aceitar conexões de entrada de clientes
 * em um servidor e iniciar uma nova thread `SupervisoraDeConexao` para cada conexão aceita.
 */
public class AceitadoraDeConexao extends Thread
{
    // O socket do servidor para aceitar conexões de entrada.
    private ServerSocket        pedido;
    private ArrayList<Parceiro> usuarios;


     /**
     * Construtor da classe {@code `AceitadoraDeConexao`}.
     * Aceita pedido de conexões.
     * @param porta A porta na qual o servidor vai aceitar conexões de entrada.
     * @param usuarios A lista de parceiros conectados ao servidor.
     * @throws Exception Se ocorrer um erro ao criar o `ServerSocket`.
     */
    public AceitadoraDeConexao 
    (String porta, ArrayList<Parceiro> usuarios)
            throws Exception
    {
        if (porta==null)
            throw new Exception ("Porta ausente");

        try
        {
            this.pedido =
                    new ServerSocket (Integer.parseInt(porta));
        }
        catch (Exception  erro)
        {
            throw new Exception ("Porta invalida");
        }

        if (usuarios==null)
            throw new Exception ("Usuarios ausentes");

        this.usuarios = usuarios;
    }


    /**
     * Método `run` da thread `AceitadoraDeConexao`. Este método fica em um loop infinito,
     * aceitando conexões de entrada e iniciando 
     * Uma nova thread `SupervisoraDeConexao` para cada conexão aceita.
     */
    public void run ()
    {
        for(;;)
        {
            Socket conexao=null;
            try
            {
                conexao = this.pedido.accept();

            }
            catch (Exception erro)
            {
                continue;
            }

             // Será instanciada para cada conexão, realizada simultaneamente com a main.
            SupervisoraDeConexao supervisoraDeConexao=null;  
            
            try
            {
                supervisoraDeConexao =
                        new SupervisoraDeConexao (conexao, usuarios);
            }
            catch (Exception erro)
            {} // Sei que passei parâmetros corretos para o construtor.


            supervisoraDeConexao.start();
        }
    }
}

