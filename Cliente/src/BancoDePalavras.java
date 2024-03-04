import java.io.Serializable;

/**
 * A classe {@code BancoDePalavras} representa um banco de palavras usado no jogo da forca.
 * Ela contém um conjunto de palavras pré-definidas que podem ser sorteadas.
 */
@SuppressWarnings("unused")
public class BancoDePalavras extends Comunicado implements Serializable
{
    /** Array de palavras disponíveis no banco de palavras. */
    private static String[] palavras =
            {
                    "JAVA",
                    "CLASSE",
                    "OBJETO",
                    "INSTANCIA",
                    "PUBLICO",
                    "PRIVATIVO",
                    "METODO",
                    "CONSTRUTOR",
                    "SETTER",
                    "GETTER",
                    "LUZ",
                    "PRAZER"
            };

     /**
     * Retorna uma palavra sorteada aleatoriamente do banco de palavras.
     *
     * @return A palavra sorteada.
     */        
    public static Palavra getPalavraSorteada ()
    {
        Palavra palavra = null;

        try
        {
            // Cria uma nova instância de Palavra com a palavra selecionada.
            // Sorteia um índice aleatório para selecionar uma palavra do array.
            palavra = new Palavra (BancoDePalavras.palavras[(int)(Math.random() * BancoDePalavras.palavras.length)]);
        }
        catch (Exception e)
        {
            // Imprime qualquer exceção ocorrida durante o processo de seleção da palavra.
            System.out.println(e.getMessage());
        }

        return palavra;
    }
}
