import java.util.*;

public class Servidor
{

   /**
    * A classe  Servidor representa o servidor principal que aceita conexões de clientes
    * e gerencia as interações com os usuários.
    */

     /** Porta padrão para o servidor */
    public static String PORTA_PADRAO = "3000";


    /**
     * Método principal que inicia o servidor.
     * @param args Argumentos da linha de comando. O primeiro argumento pode ser a porta
     *             em que o servidor será executado.
     */
    public static void main (String[] args)
    {

        // Verifica se a porta foi fornecida como argumento da linha de comando.
        if (args.length>1)
        {
             // Especificação da porta pode ser opcional
            System.err.println ("Uso esperado: java Servidor [PORTA]\n");
            return; //faz o programa e a 'main' terminar.
        }

        String porta=Servidor.PORTA_PADRAO;

        // Verifica se foi fornecida uma porta como argumento.

        if (args.length==1) 
            porta = args[0]; // Pega a porta a armazena em 'porta', substituindo a porta 'padrão'.

        // Lista de usuários conectados ao servidor.
        ArrayList<Parceiro> usuarios =
                new ArrayList<Parceiro> ();

        // Objeto responsável por aceitar conexões de clientes.
        AceitadoraDeConexao aceitadoraDeConexao=null;
        try
        {
            aceitadoraDeConexao =
                    new AceitadoraDeConexao (porta, usuarios);
            aceitadoraDeConexao.start(); // Inicia a thread para aceitar conexões.
        }
        catch (Exception erro)
        {
            System.err.println ("Escolha uma porta apropriada e liberada para uso!\n");
            return;
        }


        // Loop principal do servidor;
        for(;;)
        {
            // Aguarda entrada de comando do usuário.
            System.out.println ("O servidor esta ativo! Para desativa-lo,");

            /* \" É para mostar que não é para ser fechada as a
            aspas da string naquele local.
            */
            System.out.println ("use o comando \"desativar\"\n"); 
            System.out.print   ("> "); // Programa está pronto para se elr a digtação de algum comando

            String comando=null;
            try
            {
                comando = Teclado.getUmString();
            }
            catch (Exception erro)
            {}


            // Verifica se o comando fornecido é para desativar o servidor.
            if (comando.toLowerCase().equals("desativar")) //Comando para verificar dois objetos.
            {
                synchronized (usuarios) //deseja-se acessara 'usuarios' sem que nenhuma thread esteja usando AO MESMO TEMPO.
                {

                     // Envia um comunicado de desligamento para cada usuário conectado
                    ComunicadoDeDesligamento comunicadoDeDesligamento =
                            new ComunicadoDeDesligamento ();


                    // Envia o comunicado de desligamento.        
                    //Foreach; lê - se: 'Para cada Parceiro usuario dentro dos 'usuários'.
                    for (Parceiro usuario:usuarios) 
                    {
                        try
                        {
                            usuario.receba (comunicadoDeDesligamento);
                            usuario.adeus  (); /* método adeus na classe 'Paceiro'; o método desconecta o
                             usuário(transmissor, receptor e conexão) */
                        }
                        catch (Exception erro)
                        {}
                    }
                }

                System.out.println ("O servidor foi desativado!\n");
                System.exit(0); // Termina o programa.
            }
            else
                System.err.println ("Comando invalido!\n");
        }
    }
}



