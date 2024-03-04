import java.io.Serializable;


/**
 * A classe {@code PedidoDeOperacao} representa um pedido de operação enviado pelo cliente ao servidor.
 * Este pedido pode incluir uma letra escolhida pelo jogador, os traços atuais da palavra, 
 * o controle de letras já digitadas e o controle de erros.
 */
@SuppressWarnings("unused")
public class PedidoDeOperacao extends Comunicado implements Serializable 
{
    
    private char letrinha;

    Tracos tracinhos; // Objeto da classe 'Tracos'.

    Palavra palavra;  // Objeto da classe 'palavra'.

    ControladorDeLetrasJaDigitadas c; // Objeto da classe 'ControladorDeLetrasJaDigitadas'.

    ControladorDeErros controle; // Objeto da classe 'ControladorDeErros'.


    /**
     * Construtor da classe PedidoDeOperacao.
     *
     * @param letrinha  A letra escolhida pelo jogador.
     * @param tracinhos Os traços atuais da palavra.
     * @param c         O controle de letras já digitadas.
     * @param controle  O controle de erros.
     * @param palavra   A palavra sendo adivinhada.
     */
    public PedidoDeOperacao(char letrinha, Tracos tracinhos, ControladorDeLetrasJaDigitadas c, 
                                ControladorDeErros controle, Palavra palavra)
    {
        this.letrinha = letrinha;
        this.tracinhos = tracinhos;
        this.c = c;
        this.controle = controle;
        this.palavra = palavra;

    }

    /**
     * Obtém a letra escolhida pelo jogador.
     *
     * @return A letra escolhida.
     */
    public char getLetra() {return this.letrinha;}


    /**
     * Obtém os traços atuais da palavra.
     *
     * @return Os traços atuais.
     */
    public Tracos getTracinhos() {return this.tracinhos; }


    /**
     * Obtém o controle de letras já digitadas.
     *
     * @return O controle de letras já digitadas.
     */
    public ControladorDeLetrasJaDigitadas getLetrasJaDigitadas() {return this.c;}


    /**
     * Obtém o controle de erros.
     *
     * @return O controle de erros.
     */
    public ControladorDeErros getErros() {return this.controle;}
}


