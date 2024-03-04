import java.io.*;

/**
 * A classe Teclado fornece métodos estáticos para entrada de dados do teclado.
 */
public class Teclado implements Serializable
{
    /** O leitor de entrada do teclado. */
    private static BufferedReader teclado =
            new BufferedReader (
                    new InputStreamReader (
                            System.in));

    /**
     * Lê uma linha de texto digitada no teclado.
     *
     * @return A linha de texto digitada.
     */
    public static String getUmString ()
    {
        String ret=null;

        try
        {
            ret = teclado.readLine ();
        }
        catch (IOException erro)
        {} // Se ocorrer um erro, não faz nada, pois sabe-se que não vai ocorrer.

        return ret;
    }


    /**
     * Lê um 'byte' digitado no teclado.
     *
     * @return O 'byte' digitado.
     * @throws Exception Se o 'byte' for inválido.
     */
    public static byte getUmByte () throws Exception
    {
        byte ret=(byte)0;

        try
        {
            ret = Byte.parseByte (teclado.readLine ());
        }
        catch (IOException erro)
        {} // sei que nao vai dar erro
        catch (NumberFormatException erro)
        {
            throw new Exception ("Byte invalido!");
        }

        return ret;
    }


    /**
     * Lê um 'short' digitado no teclado.
     *
     * @return O 'short' digitado.
     * @throws Exception Se o 'short' for inválido.
     */
    public static short getUmShort () throws Exception
    {
        short ret=(short)0;

        try
        {
            ret = Short.parseShort (teclado.readLine ());
        }
        catch (IOException erro)
        {}  // Se ocorrer um erro, não faz nada, pois sabe-se que não vai ocorrer.
        catch (NumberFormatException erro)
        {
            throw new Exception ("Short invalido!");
        }

        return ret;
    }


    /**
     * Lê um 'int' digitado no teclado.
     *
     * @return O 'int' digitado.
     * @throws Exception Se o 'int' for inválido.
     */
    public static int getUmInt () throws Exception
    {
        int ret=0;

        try
        {
            ret = Integer.parseInt (teclado.readLine ());
        }
        catch (IOException erro)
        {} // sei que nao vai dar erro
        catch (NumberFormatException erro)
        {
            throw new Exception ("Int invalido!");
        }

        return ret;
    }


    /**
     * Lê um 'long' digitado no teclado.
     *
     * @return O 'long' digitado.
     * @throws Exception Se o 'long' for inválido.
     */
    public static long getUmLong () throws Exception
    {
        //long ret=(long)0;
        //long ret=0;
        long ret=0L;

        try
        {
            ret = Long.parseLong (teclado.readLine ());
        }
        catch (IOException erro)
        {} // Se ocorrer um erro, não faz nada, pois sabe-se que não vai ocorrer.
        catch (NumberFormatException erro)
        {
            throw new Exception ("Long invalido!");
        }

        return ret;
    }


    /**
     * Lê um 'float' digitado no teclado.
     *
     * @return O 'float' digitado.
     * @throws Exception Se o 'float' for inválido.
     */
    public static float getUmFloat () throws Exception
    {
        float ret=0.0F;

        try
        {
            ret = Float.parseFloat (teclado.readLine ());
        }
        catch (IOException erro)
        {} // Se ocorrer um erro, não faz nada, pois sabe-se que não vai ocorrer.
        catch (NumberFormatException erro)
        {
            throw new Exception ("Float invalido!");
        }

        return ret;
    }


    /**
     * Lê um 'double' digitado no teclado.
     *
     * @return O 'double' digitado.
     * @throws Exception Se o 'double' for inválido.
     */
    public static double getUmDouble () throws Exception
    {
        double ret=0.0;

        try
        {
            ret = Double.parseDouble (teclado.readLine ());
        }
        catch (IOException erro)
        {}  // Se ocorrer um erro, não faz nada, pois sabe-se que não vai ocorrer.
        catch (NumberFormatException erro)
        {
            throw new Exception ("Double invalido!");
        }

        return ret;
    }


    /**
     * Lê um 'char' digitado no teclado.
     *
     * @return O 'char' digitado.
     * @throws Exception Se o 'char' for inválido.
     */
    public static char getUmChar () throws Exception
    {
        char ret=' ';

        try
        {
            String str = teclado.readLine ();

            if (str==null)
                throw new Exception ("Char invalido!");

            if (str.length() != 1)
                throw new Exception ("Char invalido!");

            ret = str.charAt(0);
        }
        catch (IOException erro)
        {} // Se ocorrer um erro, não faz nada, pois sabe-se que não vai ocorrer.
        return ret;
    }


    /**
     * Lê um 'boolean' digitado no teclado.
     *
     * @return O 'boolean' digitado.
     * @throws Exception Se o 'boolean' for inválido.
     */
    public static boolean getUmBoolean () throws Exception
    {
        boolean ret=false;

        try
        {
            String str = teclado.readLine ();

            if (str==null)
                throw new Exception ("Boolean invalido!");

            if (!str.equals("true") && !str.equals("false"))
                throw new Exception ("Boolean invalido!");

            ret = Boolean.parseBoolean (str);
        }
        catch (IOException erro)
        {}  // Se ocorrer um erro, não faz nada, pois sabe-se que não vai ocorrer.

        return ret;
    }
}