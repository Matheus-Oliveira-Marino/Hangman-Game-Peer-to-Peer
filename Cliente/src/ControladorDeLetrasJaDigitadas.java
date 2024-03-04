import java.io.Serializable;

/**
 * A classe {@code ControladorDeLetrasJaDigitadas} gerencia o registro e verificação de letras já digitadas.
 */
@SuppressWarnings("unused")
public class ControladorDeLetrasJaDigitadas extends Comunicado implements Cloneable, Serializable
{
    /** String que armazena as letras já digitadas. */
    private  String letrasJaDigitadas;

    /**
     * Constrói um {@code ControladorDeLetrasJaDigitadas} inicializando a string de letras já digitadas.
     */
    public ControladorDeLetrasJaDigitadas () 
    {this.letrasJaDigitadas = "";}


    /**
     * Verifica se uma letra já foi digitada.
     *
     * @param letra A letra a ser verificada.
     * @return {@code true} se a letra já foi digitada, caso contrário {@code false}.
     */
    public  boolean isJaDigitada (char numero)
    {
        for(int a = 0; a <this.letrasJaDigitadas.length();a++)
        {
            if (this.letrasJaDigitadas.charAt(a) == numero) return true;
        }
        return false;
    }


    /**
     * Registra uma letra como digitada.
     *
     * @param letra A letra a ser registrada.
     * @throws Exception Se a letra já tiver sido digitada.
     */
    public void registre (char numero) throws Exception 
    {
        if(this.isJaDigitada(numero))
        {
            throw new Exception("número já digitado!");

        }
        this.letrasJaDigitadas += numero;
    }


    /**
     * Retorna uma representação em {@code String} das letras já digitadas.
     *
     * @return Uma 'string' contendo as letras já digitadas, separadas por vírgula.
     */
    public String toString ()
    {
        String letras = "";
        for(int b = 0;b <this.letrasJaDigitadas.length();b++)
        {
            letras += this.letrasJaDigitadas.charAt(b) + ",";
        }
        return letras;
    }


    /**
     * Verifica se o objeto chamante do método é igual a outro objeto de comparação.
     *
     * @param obj O objeto a ser comparado.
     * @return {@code true} se os objetos forem iguais, caso contrário {@code false}.
     */
    public boolean equals (Object obj) 
    {
        if(this == obj) return false;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;

        if(this.letrasJaDigitadas == ((ControladorDeLetrasJaDigitadas)obj).letrasJaDigitadas) return true;

        return false;
    }

    /**
     * Retorna o código de hash para este objeto.
     *
     * @return O código de hash calculado.
     */
    public int hashCode () 
    {
        int a = 28;

        a = 13 * a + String.valueOf(this.letrasJaDigitadas).hashCode();
        return a;
    }


    /**
     * Constrói uma cópia do 'ControladorDeLetrasJaDigitadas' especificado.
     *
     * @param c Um objeto da classe {@code ControladorDeLetrasJaDigitadas} a ser copiado.
     * @throws Exception Se o {@code ControladorDeLetrasJaDigitadas} especificado for nulo.
     */
    public ControladorDeLetrasJaDigitadas(ControladorDeLetrasJaDigitadas c) throws Exception
    {
        if(c == null)
        {
            throw new Exception("Objeto nulo!");
        }
        this.letrasJaDigitadas = c.letrasJaDigitadas;
        // copiando 'c.letrasJaDigitadas' em 'this.letrasJaDigitadas'.
    }


    /**
     * Cria e retorna uma cópia deste objeto.
     *
     * @return Uma cópia deste objeto.
     */
    public Object clone ()
    {
        ControladorDeLetrasJaDigitadas controla = null;
        try
        {
            controla = new ControladorDeLetrasJaDigitadas(this);
        }
        catch (Exception erro)
        {
            System.out.println(erro.getMessage());
        }
        return controla;

    }
}

