/**
  * A classe {@code TratadoraDeComunicadoDeDesligamento} é responsável por monitorar e tratar
  * os comunicados de desligamento recebidos do servidor.
  * 
  * Esta classe estende a classe {@code Thread} para permitir a execução contínua de tarefas.
  */
public class TratadoraDeComunicadoDeDesligamento extends Thread
{
    private Parceiro servidor; // O parceiro de comunicação com o servidor.


     /**
     * Cria uma nova instância de {@code TratadoraDeComunicadoDeDesligamento}.
     * Contém a porta,as conexões e o host.
     * @param servidor O parceiro de comunicação com o servidor.
     * @throws Exception Se o servidor fornecido for nulo.
     */
    public TratadoraDeComunicadoDeDesligamento (Parceiro servidor) throws Exception 
    {
        if (servidor==null)
            throw new Exception ("Porta invalida");

        this.servidor = servidor;
    }


    /**
     * Monitora os comunicados recebidos do servidor para identificar se o servidor
     * enviou um comunicado de desligamento. Em caso afirmativo, exibe uma mensagem
     * ao usuário e encerra o programa.
     */
    public void run ()
    {
        for(;;)
        {
            try
            {
                // Comunicação que vem do servidor.
                if (this.servidor.espie() instanceof ComunicadoDeDesligamento) 
                {
                    System.out.println ("\nO servidor vai ser desligado agora;");
                    System.err.println ("volte mais tarde!\n");
                    System.exit(0); // Encerra o programa.
                }
            }
            catch (Exception erro)
            {}
        }
    }
}