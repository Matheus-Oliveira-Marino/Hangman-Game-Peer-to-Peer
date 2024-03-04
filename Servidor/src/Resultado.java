import java.io.Serializable;


/**
 * A classe {@code Resultado} representa o resultado de uma operação ou ação esperada do servidor,
 * como a tentativa de adivinhar uma palavra em um jogo.
 */
@SuppressWarnings("unused")
public class Resultado extends Comunicado implements Serializable
{
    
    String message1, message2, message3; // Mensagens adicionais.
    ControladorDeErros controle; // Controlador de erros da partida.
    Palavra palavra; // Palavra associada ao resultado
    Tracos tracinhos;  // Tracos da palavra (como letras preenchidas e não preenchidas).
    ControladorDeLetrasJaDigitadas c; // Controlador de letras já digitadas.


    /**
     * Construtor da classe {@code Resultado}.
     *
     * @param controle O controlador de erros da partida.
     * @param palavra  A palavra associada ao resultado.
     * @param tracinhos Os traços da palavra (como letras preenchidas e não preenchidas).
     * @param c O controlador de letras já digitadas.
     */
    public Resultado (ControladorDeErros controle, Palavra palavra,
                      Tracos tracinhos, ControladorDeLetrasJaDigitadas c )
    {

        this.controle = controle;
        this.palavra = palavra;
        this.tracinhos = tracinhos;
        this.c = c;
    }


    /**
     * Obtém a palavra associada ao resultado.
     *
     * @return A palavra associada ao resultado.
     */
    public Palavra getPalavra()
    {
        return this.palavra;
    }


    /**
     * Obtém o controlador de erros da partida.
     *
     * @return O controlador de erros da partida.
     */
    public ControladorDeErros getControladorDeErros()
    {
        return this.controle;
    }


    /**
     * Obtém os traços da palavra (como letras preenchidas e não preenchidas).
     *
     * @return Os traços da palavra.
     */
    public Tracos getQtdeTracos()
    {
        return this.tracinhos;
    }


     /**
     * Obtém o controlador de letras já digitadas.
     *
     * @return O controlador de letras já digitadas.
     */
    public ControladorDeLetrasJaDigitadas getQtdeLetrasJaDigitadas()
    {
        return this.c;
    }
}




