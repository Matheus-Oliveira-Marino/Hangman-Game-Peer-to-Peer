import java.io.Serializable;

/**
 * A classe {@code ControladorDeErros} gerencia a contagem de erros em um determinado contexto.
 */
@SuppressWarnings("unused")
public class ControladorDeErros extends Comunicado implements Cloneable, Serializable
{

    /** Quantidade máxima de erros permitida('qtdMax'). 
     * Quantidade de erros a serem registrados('qtdErr'). 
    */
    private int qtdMax, qtdErr=0;


    /**
    * Constrói um {@code ControladorDeErros} com a quantidade máxima de erros especificada.
    *
    * @param qtdMax A quantidade máxima de erros permitida.
    * @throws Exception Se a quantidade máxima for negativa.
    */
    public ControladorDeErros (int qtdMax) throws Exception 
    {
        if(qtdMax < 0) throw new Exception("Quantidade Inválida!");
        this.qtdMax = qtdMax;
    }

   /**
    * Registra um erro.
    *
    * @throws Exception Se a quantidade máxima de erros já foi atingida.
    */
    public void registreUmErro () throws Exception
    {
        if(this.qtdErr == this.qtdMax)
        {
            throw new Exception("Você atingiu o limite de erros!");
        }
        this.qtdErr++;
    }


    /**
     * Verifica se a quantidade máxima de erros foi atingida.
     *
     * @return {@code true} se a quantidade máxima de erros foi atingida, caso contrário {@code false}.
     */
    public boolean isAtingidoMaximoDeErros  () 
    {
        if(this.qtdErr == this.qtdMax)
        {
            return true;
        }

        else
        {
            return false;
        }
    }


    /**
     * Retorna uma representação em {@code String} do objeto.
     *
     * @return Uma 'string' contendo a quantidade atual de erros e a quantidade máxima permitida.
     */
    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
    }


    /**
     * Verifica se este objeto é igual a outro objeto.
     *
     * @param obj O objeto a ser comparado.
     * @return {@code true} se os objetos forem iguais, caso contrário {@code false}.
     */
    public boolean equals (Object obj) 
    {
        if(this == obj) return true;
        if(obj == null) return false;

        if(this.getClass() != obj.getClass()) return false;
        if(this.qtdMax != ((ControladorDeErros)obj).qtdMax) return false;
        return true;
    }


   /**
    * Retorna o código de hash para este objeto.
    *
    * @return O código de hash calculado.
    */
    public int hashCode () 
    {
        int ret = 12;
        ret = 13 * ret + Integer.valueOf(this.qtdErr).hashCode(); // Nova maneira de escrita de 'hashCode'.
        ret = 13 * ret + Integer.valueOf(this.qtdMax).hashCode();
        if(ret < 0 ) ret = -ret;
        return ret;
        // calcular e retornar o 'hashcode' de 'this'.
    }

    /**
     * Constrói uma cópia do {@code ControladorDeErros} especificado.
     *
     * @param c O 'ControladorDeErros' a ser copiado.
     * @throws Exception Se o ControladorDeErros especificado for nulo.
     */

    public ControladorDeErros (ControladorDeErros c) throws Exception // construtor de cópia.
    {
        if(c == null)
        {
            throw new Exception("c está ausente!");
        }

        this.qtdErr = c.qtdErr;
        this.qtdMax = c.qtdMax;
    }


      /**
     * Cria e retorna uma cópia deste objeto.
     *
     * @return Uma cópia deste objeto.
     */
    public Object clone ()
    {

        ControladorDeErros cE = null;

        try
        {
            cE = new ControladorDeErros(this);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return cE;
        // returnar uma cópia de 'this'.
    }
}

