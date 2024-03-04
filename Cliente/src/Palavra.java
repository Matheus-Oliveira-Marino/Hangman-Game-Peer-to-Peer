import java.io.Serializable;


/**
 * A classe Palavra representa uma palavra do jogo da forca.
 * Essa palavra representa uma palavra da classe {@code BancoDePalavras}.
 */
@SuppressWarnings("unused")
public class Palavra extends Comunicado implements Serializable
{

    /** A palavra representada pela classe. */
    private String senhaRecebida;


    /**
     * Constrói uma palavra com a string fornecida.
     *
     * @param senhaRecebida A palavra a ser representada.
     * @throws Exception Se a senha recebida for nula ou vazia.
     */
    public Palavra(String senhaRecebida) throws Exception 
    {
        if(senhaRecebida == "" || senhaRecebida == null)
        {
            throw new Exception("Texto está nulo!!");
        }

        this.senhaRecebida = senhaRecebida;

    }


    /**
     * Retorna a quantidade de ocorrências de uma letra na palavra.
     *
     * @param letra A letra a ser contada.
     * @return O número de ocorrências da letra na palavra.
     */
    public int getQuantidade (char letra) 
    {

        int qtd = 0;
        for (int i = 0; i < this.senhaRecebida.length();i++)
        {
            if(this.senhaRecebida.charAt(i) == letra)
            {

                qtd++;
            }
        }

        return qtd;
    }


    /**
     * Retorna a posição da i-ésima ocorrência de uma letra na palavra.
     *
     * @param i O índice da ocorrência desejada.
     * @param letra A letra a ser encontrada.
     * @return A posição da i-ésima ocorrência da letra.
     * @throws Exception Se não houver i ocorrências da letra na palavra.
     */
    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception 
    {
        byte posicao = 0;

        for(int a = 0; a <this.senhaRecebida.length();a++)
        {

            if (this.senhaRecebida.charAt(a) == letra) posicao++;

            if(posicao - 1 == i) return a;
        }
        throw new Exception("Erro na classe Palavra: não há repetição de letras maior que a palavra fornecida");
    }


    /**
     * Retorna o tamanho da palavra.
     *
     * @return O tamanho da palavra.
     */
    public int getTamanho() 
    {
        return this.senhaRecebida.length();
    }


    /**
     * Retorna a representação em 'String' da palavra.
     *
     * @return A palavra como uma 'String'.
     */
    @Override
    public String toString ()
    {
        return this.senhaRecebida;
    }


    /**
     * Verifica se duas palavras são iguais.
     *
     * @param obj O objeto a ser comparado.
     * @return true se as palavras forem iguais, caso contrário false.
     */
    @Override
    public boolean equals (Object obj) 
    {
        if(this == obj) return  true;

        if(obj == null) return false;

        for (int a = 0; a < this.senhaRecebida.length();a++)
            if(this.senhaRecebida.charAt(a) != ((Palavra)obj). senhaRecebida.charAt(a)) return false;

        return true;

    }


     
    /**
     * Retorna o código de hash da palavra.
     *
     * @return O código de hash da palavra.
     */
    @Override
    public int hashCode ()
    {
        int i = 26;
        i = 7 * i + String.valueOf(this.senhaRecebida).hashCode();
        if(i < 0) i = -i;
        return i;
    }

}
