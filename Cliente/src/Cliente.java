import java.net.*;
import java.io.*;


/**
 * A classe {@code Cliente} é responsável por interagir com o servidor 
 * em um jogo de adivinhação de palavras.
 */
public class Cliente
{
    // Se o projeto estiver rodando local, utilize 'localhost'.
    public static final String HOST_PADRAO = "localhost";

    // Porta padrão usada para a conexão com o servidor. 
    // A porta do das classes 'Cliente' e 'Servidor' devem ser iguais!
    public static final int PORTA_PADRAO = 3000;




    /**
     * Método principal para iniciar o cliente e interagir com o servidor.
     * @param args Argumentos da linha de comando, opcionalmente, o host e a porta do servidor.
     * @throws Exception Se ocorrer um erro durante a execução do cliente.
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception
    {
        // Variáveis para armazenar a letra digitada pelo usuário e a resposta do servidor.
        char letrinha;
        char resposta;

        // Objetos para armazenar o estado do jogo.
        Resultado resultado;
        @SuppressWarnings("unused")
        boolean fim = false;
        Palavra palavra = null;

        // Inicialização dos objetos do jogo.
        try
        {
            palavra = BancoDePalavras.getPalavraSorteada();
        }
        catch (Exception e) {}

        ControladorDeLetrasJaDigitadas
                controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();
        Tracos tracinhos = null;
        try {
            tracinhos = new Tracos(palavra.getTamanho());
        } catch (Exception e) {
        }


        ControladorDeErros controladorDeErros = null;
        try {
            controladorDeErros = new ControladorDeErros((int) (palavra.getTamanho() * 0.6)); 
        } catch (Exception erro) {
        }

        // Verificação dos argumentos da linha de comando para obter o host e a porta do servidor.

        if (args.length > 2) 
        {
            // Especificar a porta que é opcional(colchetes).
            System.err.println("Uso esperado: java Cliente [HOST [PORTA]]\n"); 
            return;
        }

        // Conexão com o servidor. 
        Socket conexao;
        try 
        {   // Se não for passado nenhum argumento em 'args', 
            // Utiliza o host e a porta padrão pré-definidos.
            String host = Cliente.HOST_PADRAO;
            int porta = Cliente.PORTA_PADRAO;

            if (args.length > 0) // Ex: 'localhost' e '7000'(porta).
                host = args[0]; //Pega o 'localhost' e armazena na variável 'host'.

            // Se há dois argumentos em 'args',
            // pega o que está na primeira posição de args e converte para 'int',    
            // depois armazena na variável 'porta' (anteriormente, a porta 7000).
            if (args.length == 2)
                porta = Integer.parseInt(args[1]); 
            
            // Estabelece a conexão com o servidor utilizando o host e a porta obtidos.
            conexao = new Socket(host, porta);
        } 
        catch (Exception erro) 
        {
            // Exibe uma mensagem de erro caso ocorra algum problema na conexão.
            System.err.println("Indique o servidor e a porta corretos!\n");
            return;
        }

        // Cria um objeto para enviar dados para o servidor.
        ObjectOutputStream transmissor;
        try 
        {
            // Obtém o fluxo de saída da conexão e o utiliza para criar um objeto 'ObjectOutputStream'.
            transmissor =
                    new ObjectOutputStream(
                            conexao.getOutputStream());
        } 
        catch (Exception erro) 
        {
            // Exibe uma mensagem de erro caso ocorra algum problema na criação do 'ObjectOutputStream'.
            System.err.println("Indique o servidor e a porta corretos!\n");
            return;
        }

        // Cria um objeto para receber dados do servidor.
        ObjectInputStream receptor;

         // Obtém o fluxo de entrada da conexão e o utiliza para criar um objeto 'ObjectInputStream'.
        try {
            receptor =
                    new ObjectInputStream(
                            conexao.getInputStream());
        } catch (Exception erro) {
            System.err.println("Indique o servidor e a porta corretos!\n");
            return;
        }


        // Cria um objeto 'Parceiro' para lidar com a comunicação com o servidor.
        Parceiro servidor = null;
        try
        {
            // Cria um novo 'Parceiro' utilizando a conexão, o receptor e o transmissor.
            servidor =
                    new Parceiro(conexao, receptor, transmissor);
        }
         catch (Exception erro)
        {
            // Exibe uma mensagem de erro caso ocorra algum problema na criação do Parceiro.
            System.err.println("Indique o servidor e a porta corretos!\n");
            return;
        }

        // Cria um objeto 'TratadoraDeComunicadoDeDesligamento' para lidar com os comunicados do servidor.
        TratadoraDeComunicadoDeDesligamento tratadoraDeComunicadoDeDesligamento = null;
        try 
        {

            // Cria uma nova 'TratadoraDeComunicadoDeDesligamento' utilizando o Parceiro.
            tratadoraDeComunicadoDeDesligamento = new TratadoraDeComunicadoDeDesligamento(servidor);
        } 
        catch (Exception erro) {} // sei que servidor foi instanciado

        // Inicia a thread da 'TratadoraDeComunicadoDeDesligamento'.
        tratadoraDeComunicadoDeDesligamento.start();

        
        // Loop principal para interagir com o usuário e enviar/receber mensagens do servidor.
        
    do
    {
        do
        {
            // Exibe as opções para o usuário.
            System.out.println("Pressione [S] para jogar: ");
            System.out.println("Pressione [T] para terminar: ");
            System.out.println();
            resposta = Character.toUpperCase(Teclado.getUmChar());

            if (resposta != 'S' && resposta != 'T') 
            {
                // Se o usuário não inserir 'S' ou 'T', exibe uma mensagem de erro.
                System.err.println("Caractere incorreto! Por favor, digite 'S' para jogar ou 'T' para terminar.");
            } 
        }   while (resposta != 'S' && resposta != 'T');

            try
            {

                if (resposta == 'T')
                {
                    // Encerra o programa se o usuário escolher terminar.
                    System.out.println("Ok, volte sempre!");
                    System.out.println("Obrigado por usar este programa!");
                    System.exit(0);

                }
                if (resposta == 'S')
                {

                    // Interage com o usuário para obter uma letra e envia ao servidor.
                    System.out.println("A Palavra é ...: " + tracinhos);
                    System.out.print("Qual é a letra? ");
                    System.out.println();
                    System.out.println();


                    // Pega o que o usuário digitou no teclado.
                    letrinha = Character.toUpperCase(Teclado.getUmChar());


                    // Enviando ao servidor um conjunto de parâmetros do jogo da forca.
                    servidor.receba(new PedidoDeOperacao(letrinha, tracinhos, controladorDeLetrasJaDigitadas, controladorDeErros, palavra));

                    do
                    {
                        // Solicita ao servidor o resultado atual e espera pela resposta.
                        servidor.receba(new PedidoDeResultado());


                        // Aguarda até que um resultado seja recebido do servidor.
                        Comunicado comunicado;
                        do
                        {
                            comunicado = servidor.espie();
                        }
                        while (!(comunicado instanceof Resultado));

                        // Converte o comunicado recebido para um objeto Resultado.
                        resultado = (Resultado) servidor.envie();


                        // Verifica se o jogador atingiu o máximo de erros.
                        if (resultado.getControladorDeErros().isAtingidoMaximoDeErros())
                        {
                            System.out.println("Que pena! Você perdeu! A palavra era " + resultado.getPalavra() + "\n");
                            System.exit(0);
                        }

                        // Verifica se o jogador acertou todas as letras da palavra.
                        if(!resultado.getQtdeTracos().isAindaComTracinhos())
                        {
                            System.out.println("Parabéns! Você ganhou! A palavra era mesmo " + resultado.getPalavra() + "\n");
                            System.exit(0);
                            break;
                        }
                        else
                        {
                            // Exibe o estado atual do jogo.
                            System.out.println("Palavra...: "+ resultado.getQtdeTracos());
                            System.out.println("Digitadas...: "+ resultado.getQtdeLetrasJaDigitadas());
                            System.out.println("Erros...: "+ resultado.getControladorDeErros());


                            // Solicita ao usuário para digitar uma letra.
                            System.out.println("Qual a letra?");

                            // Obtém a letra correspondente à seleção do usuário.
                            char letrinha2 = Character.toUpperCase(Teclado.getUmChar());

                            // Verifica se a letra já foi digitada antes.
                            if (resultado.getQtdeLetrasJaDigitadas().isJaDigitada(letrinha2))
                            {
                                System.err.println ("A palavra não tem essa letra!\n");
                            }

                            else
                            {
                                // Envia a letra digitada ao servidor.
                                servidor.receba(new PedidoDeOperacao(letrinha2,resultado.getQtdeTracos(),resultado.getQtdeLetrasJaDigitadas(),
                                        resultado.getControladorDeErros(),resultado.getPalavra()));
                            }
                        }
                    }
                    while(resultado.getQtdeTracos().isAindaComTracinhos());
                }
            }
            catch (Exception erro)
            {
                // Exibe mensagens de erro caso ocorra algum problema na comunicação com o servidor.
                erro.printStackTrace();
                System.err.println("Erro de comunicação com o servidor;");
                System.err.println("Tente novamente!");
                System.err.println("Caso o erro persista, termine o programa");
                System.err.println("e volte a tentar mais tarde!\n");
            }
        }while (resposta != 'T');
        
        // Exibe uma mensagem de agradecimento e encerra o programa.
        System.out.println("Obrigado por usar este programa!");
        System.exit(0);
    }
}



