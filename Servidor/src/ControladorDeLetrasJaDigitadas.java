import java.io.Serializable;


/**
 * A classe {@code ControladorDeLetrasJaDigitadas} mantém o controle das letras que já foram digitadas.
 * Ela permite verificar se uma letra já foi digitada, registrar uma nova letra digitada e fornece métodos
 * para cópia, comparação e representação em forma de string.
 */
@SuppressWarnings("unused")
public class ControladorDeLetrasJaDigitadas extends Comunicado implements Cloneable, Serializable
{
    // Objeto para representar letras já digitadas pelo usuário.
    private  String letrasJaDigitadas;


    /**
     * Construtor padrão da classe {@code ControladorDeLetrasJaDigitadas}.
     * Inicializa a string de letras digitadas como vazia.
     */
    public ControladorDeLetrasJaDigitadas () 
    {this.letrasJaDigitadas = "";}


    /**
     * Verifica se uma letra já foi digitada.
     *
     * @param letra a letra a ser verificada.
     * @return {@code true} se a letra já foi digitada, {@code false} caso contrário.
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
     * Registra uma nova letra digitada.
     *
     * @param letra a letra a ser registrada.
     * @throws Exception se a letra já foi digitada anteriormente.
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
     * Retorna uma representação em forma de string das letras digitadas.
     *
     * @return uma string contendo as letras digitadas separadas por vírgula.
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
     * Verifica se dois objetos {@code ControladorDeLetrasJaDigitadas} são iguais.
     *
     * @param obj o objeto a ser comparado
     * @return {@code true} se os objetos são iguais, {@code false} caso contrário.
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
     * Calcula e retorna um código hash baseado no estado do objeto.
     *
     * @return o código hash calculado.
     */
    public int hashCode () 
    {
        int a = 28;

        a = 13 * a + String.valueOf(this.letrasJaDigitadas).hashCode();
        return a;
    }


    /**
     * Construtor de cópia que cria um novo objeto {@code ControladorDeLetrasJaDigitadas} com base 
     * em outro objeto existente.
     * 
     * @param c o objeto a ser copiado.
     * @throws Exception se o objeto passado for nulo.
     */
    public ControladorDeLetrasJaDigitadas(
            ControladorDeLetrasJaDigitadas c)
            throws Exception
    {
        if(c == null)
        {
            throw new Exception("Objeto nulo!");
        }
        this.letrasJaDigitadas = c.letrasJaDigitadas;
        // copiarndo 'c.letrasJaDigitadas' em 'this.letrasJaDigitadas'.
    }


    /**
     * Cria e retorna uma cópia do objeto {@code ControladorDeLetrasJaDigitadas}.
     *
     * @return uma cópia do objeto
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

