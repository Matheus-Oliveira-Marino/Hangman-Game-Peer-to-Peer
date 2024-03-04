import java.io.Serializable;
import java.util.Arrays;


/**
 * A classe {@code Tracos} representa os traços('_') que indicam 
 * as letras ocultas em uma palavra do jogo da forca.
 */
@SuppressWarnings("unused")
public class Tracos extends Comunicado implements Cloneable, Serializable
{
    /** O array de caracteres que representa os traços. */
    private char texto[];


    /**
     * Constrói uma instância de 'Tracos' com uma quantidade máxima de traços.
     *
     * @param qtdMax A quantidade máxima de traços.
     * @throws Exception Se a quantidade máxima for negativa.
     */
    public Tracos (int qtdMax) throws Exception
    {
        if(qtdMax < 0)
        {
            throw new Exception("Quantidade inválida!");
        }
        else  this.texto = new char[qtdMax];

        int qtdeTracinhos;
        for(qtdeTracinhos = 0; qtdeTracinhos < qtdMax;qtdeTracinhos++)
        {
            this.texto[qtdeTracinhos] = '_';
        }
    }


    /**
     * Revela uma letra em uma posição específica dos traços.
     *
     * @param posicao A posição onde a letra será revelada.
     * @param senha A letra a ser revelada.
     * @throws Exception Se a posição for inválida.
     */
    public  void revele (int posicao, char senha) throws Exception 
    {
        if (posicao < 0 || posicao >= this.texto.length)
        {
            throw new Exception("Tamanho inválido");
        }
        else{
            this.texto[posicao]= senha;

        }
    }

    /**
     * Verifica se ainda há traços não revelados.
     *
     * @return {@code true} se ainda houver traços não revelados, caso contrário {@code false}.
     */
    public boolean isAindaComTracinhos () 
    {
        for(int i = 0;i <this.texto.length;i++)
        {
            if(this.texto[i] == '_')
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna uma representação em {@code String} dos traços.
     *
     * @return Os traços como uma String.
     */
    public String toString () 
    {
        String senha = "";

        for(int a =0; a < this.texto.length; a++)
        {
            senha += " " + (this.texto[a]) ;
        }
        return senha;
    }

    /**
     * Verifica se dois objetos 'tracos' são iguais.
     *
     * @param obj O objeto a ser comparado.
     * @return true se os objetos forem iguais, caso contrário false.
     */
    public boolean equals (Object obj) 
    {
        if(this == obj) return true;
        if(obj == null) return false;

        if(this.getClass() != obj.getClass()) return false;

        Tracos traco = (Tracos)(obj);
        for (int a = 0; a < texto.length;a++)
        {
            if(this.texto[a] != traco.texto[a]) return false;
        }
        return true;

    }

    /**
     * Retorna o código de hash dos traços.
     *
     * @return O código de hash dos traços.
     */
    public int hashCode () 
    {
        int ret = 26;
        ret = 13 * ret + Arrays.hashCode(this.texto);
        if(ret < 0 ) ret = -ret;
        return ret;
        // Calculando e retornando o hashcode de 'this'.
    }


    /**
     * Constrói uma cópia dos traços.
     *
     * @param t Os traços a serem copiados.
     * @throws Exception Se os traços forem nulos.
     */
    public Tracos (Tracos t) throws Exception // construtor de cópia.
    {

        if (t ==null)
        {
            throw new Exception("tracinho ausente");
        }
        this.texto = new char[t.texto.length];
        t.texto = this.texto;


        // intanciando 'this.texto' em um vetor com o mesmo tamanho de 't.texto'.
        // e copiando de 't.texto' para 'this.texto'
    }


    /**
     * Cria uma cópia dos traços.
     *
     * @return Uma cópia dos traços.
     */
    public Object clone ()
    {
        Tracos tzin = null;

        try
        {
            tzin = new Tracos(this);
        }
        catch(Exception e)
        {

        }
        return tzin;
        // retornando uma copia de 'this'.
    }
}
