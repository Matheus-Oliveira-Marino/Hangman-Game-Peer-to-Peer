import java.io.Serializable;


/**
 * A classe {@code PedidoDeOperacao} representa um pedido de operação enviado pelo cliente ao servidor.
 * Contém informações como a letra escolhida, os traços da palavra, os erros e as letras já digitadas.
 */
@SuppressWarnings("unused")
public class PedidoDeOperacao extends Comunicado implements Serializable 
{
    private char letrinha;  // A letra escolhida pelo cliente.
    Tracos tracinhos; // Os traços da palavra a ser adivinhada.
    Palavra palavra; // A palavra a ser adivinhada.
    ControladorDeLetrasJaDigitadas c; // O controlador das letras já digitadas.
    ControladorDeErros controle; // O controlador dos erros cometidos


    /**
     * Construtor da classe {@code PedidoDeOperacao}.
     *
     * @param letrinha  a letra escolhida pelo cliente.
     * @param tracinhos os traços da palavra a ser adivinhada.
     * @param c         o controlador das letras já digitadas.
     * @param controle  o controlador dos erros cometidos.
     * @param palavra   a palavra a ser adivinhada.
     */
    public PedidoDeOperacao(char letrinha, Tracos tracinhos, ControladorDeLetrasJaDigitadas c, ControladorDeErros controle,
                            Palavra palavra)
    {
        this.letrinha = letrinha;
        this.tracinhos = tracinhos;
        this.c = c;
        this.controle = controle;

        this.palavra = palavra;

    }


       /**
     * Obtém a letra escolhida pelo cliente.
     *
     * @return a letra escolhida.
     */
    public char getLetra()
    {
        return this.letrinha;
    }


    /**
     * Obtém os traços da palavra a ser adivinhada.
     *
     * @return os traços da palavra.
     */
    public Tracos getTracinhos() {return this.tracinhos;}


    /**
     * Obtém o controlador das letras já digitadas.
     *
     * @return o controlador das letras já digitadas
     */
    public ControladorDeLetrasJaDigitadas getLetrasJaDigitadas() {return this.c;}


     /**
     * Obtém o controlador dos erros cometidos.
     *
     * @return o controlador dos erros cometidos.
     */
    public ControladorDeErros getErros() {return this.controle;}
}


