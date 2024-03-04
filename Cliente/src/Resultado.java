import java.io.Serializable;


/**
 * A classe {@code Resultado} representa o resultado de uma operação ou ação esperada do servidor,
 * como a tentativa de adivinhar uma palavra em um jogo.
 * 
 * Esta classe encapsula informações relevantes sobre o resultado de uma operação
 * realizada pelo servidor em resposta a uma solicitação do cliente, como o estado 
 * atual da palavra em um jogo de adivinhação, o controle de erros da partida e as 
 * letras já digitadas pelo cliente.
 */
@SuppressWarnings("unused")
public class Resultado extends Comunicado implements Serializable
{
    String message1, message2, message3; // Corresponde as mensagens.
    ControladorDeErros controle; // O controle de erros da partida.
    Palavra palavra; // A palavra associada ao resultado.
    Tracos tracinhos; // O estado atual da palavra em um jogo.
    ControladorDeLetrasJaDigitadas c; // O controle de letras já digitadas pelo cliente.


    /**
     * Cria um novo objeto 'Resultado' com as informações fornecidas.
     * 
     * @param controle O controle de erros da partida.
     * @param palavra A palavra associada ao resultado.
     * @param tracinhos O estado atual da palavra em um jogo.
     * @param c O controle de letras já digitadas pelo cliente.
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
     * Obtém o controle de erros da partida.
     * 
     * @return O controle de erros da partida.
     */
    public ControladorDeErros getControladorDeErros()
    {
        return this.controle;
    }


    /**
     * Obtém o estado atual da palavra em um jogo.
     * 
     * @return O estado atual da palavra em um jogo.
     */
    public Tracos getQtdeTracos()
    {
        return this.tracinhos;
    }


    /**
     * Obtém o controle de letras já digitadas pelo cliente.
     * 
     * @return O controle de letras já digitadas pelo cliente.
     */
    public ControladorDeLetrasJaDigitadas getQtdeLetrasJaDigitadas()
    {
        return this.c;
    }
}




