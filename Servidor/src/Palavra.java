import java.io.Serializable;


/**
 * A classe {@code Palavra} representa uma palavra no contexto do jogo.
 * Ela fornece métodos para obter informações sobre a palavra, como sua quantidade de caracteres,
 * a quantidade de ocorrências de uma determinada letra e a posição da i-ésima ocorrência de uma letra.
 */
@SuppressWarnings("unused")
public class Palavra extends Comunicado implements Serializable
{
    // letra recebida da classe 'Cliente'
    private String senhaRecebida;


     /**
     * Construtor da classe {@code Palavra}.
     *
     * @param senhaRecebida a palavra a ser armazenada.
     * @throws Exception se a palavra recebida for nula ou vazia.
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
     * Retorna a quantidade de ocorrências de uma determinada letra na palavra.
     *
     * @param letra a letra a ser contada.
     * @return a quantidade de ocorrências da letra na palavra.
     */
    public int getQuantidade (char letra) //Works
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
     * Retorna a posição da i-ésima ocorrência de uma determinada letra na palavra.
     *
     * @param i     o índice da ocorrência desejada.
     * @param letra a letra cuja ocorrência é buscada.
     * @return a posição da i-ésima ocorrência da letra na palavra.
     * @throws Exception se não houver uma repetição de letras maior que a palavra fornecida.
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
     * @return o tamanho da palavra.
     */
    public int getTamanho()
    {
        return this.senhaRecebida.length();
    }


    /**
     * Retorna a representação em forma de string da palavra.
     *
     * @return a palavra como uma string.
     */
    @Override
    public String toString () 
    {
        return this.senhaRecebida;
    }


     /**
     * Verifica se duas palavras são iguais.
     *
     * @param obj o objeto a ser comparado.
     * @return {@code true} se as palavras são iguais, ou {@code false} caso contrário.
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
     * Calcula e retorna um código hash baseado no estado da palavra.
     *
     * @return o código hash calculado.
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
