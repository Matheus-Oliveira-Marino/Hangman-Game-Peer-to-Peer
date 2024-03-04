import java.io.Serializable;


/**
 * A classe {@code 'ControladorDeErros'} mantém o controle do número de erros ocorridos em algum processo.
 * Ela permite registrar erros, verificar se o número máximo de erros foi atingido e fornece métodos para
 * cópia, comparação e representação em forma de string.
 */
@SuppressWarnings("unused")
public class ControladorDeErros extends Comunicado implements Cloneable, Serializable
{
    // Quantidade máxima de erros('qtdmax') e 
    // quantidade de erros atuais ('qtdErr').
    private int qtdMax, qtdErr=0;


    /**
     * Construtor da classe {@code ControladorDeErros}.
     *
     * @param qtdMax a quantidade máxima de erros permitida.
     * @throws Exception se a quantidade máxima for menor que zero.
     */
    public ControladorDeErros (int qtdMax) throws Exception 
    {
        if(qtdMax < 0) throw new Exception("Quantidade Inválida!");
        this.qtdMax = qtdMax;
    }


    /**
     * Registra um erro, incrementando o contador de erros.
     *
     * @throws Exception se o número máximo de erros já foi atingido.
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
     * Verifica se o número máximo de erros foi atingido.
     *
     * @return {@code 'true'} se o número máximo de erros foi atingido, {@code 'false'} caso contrário.
     */
    public boolean isAtingidoMaximoDeErros() 
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
     * Retorna uma representação em forma de string do estado atual do objeto.
     *
     * @return uma string contendo o número de erros e o número máximo de erros.
     */
    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
    }


    /**
     * Verifica se dois objetos {@code ControladorDeErros} são iguais.
     *
     * @param obj o objeto a ser comparado
     * @return {@code true} se os objetos são iguais, {@code false} caso contrário.
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
     * Calcula e retorna um código hash baseado no estado do objeto.
     *
     * @return o código hash calculado.
     */
    public int hashCode ()
    {
        int ret = 12;
        ret = 13 * ret + Integer.valueOf(this.qtdErr).hashCode();
        ret = 13 * ret + Integer.valueOf(this.qtdMax).hashCode();
        if(ret < 0 ) ret = -ret;
        return ret;
        // calculando e retornando o hashcode de 'this'.
    }


    /**
     * Construtor de cópia que cria um novo objeto {@code ControladorDeErros} com base em outro objeto existente.
     *
     * @param c o objeto a ser copiado.
     * @throws Exception se o objeto passado for nulo.
     */
    public ControladorDeErros (ControladorDeErros c) throws Exception
    {
        if(c == null)
        {
            throw new Exception("c está ausente!");
        }

        this.qtdErr = c.qtdErr;
        this.qtdMax = c.qtdMax;
    }


    /**
     * Cria e retorna uma cópia do objeto {@code ControladorDeErros}.
     *
     * @return uma cópia do objeto.
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
        return cE;  // retorna uma cópia de 'this'.
       
    }
}

