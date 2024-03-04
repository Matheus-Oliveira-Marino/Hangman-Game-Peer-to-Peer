import java.io.Serializable;
import java.util.Arrays;


/**
 * A classe {@code Tracos} representa os traços que representam letras ocultas em uma palavra.
 * Cada traço pode ser revelado para exibir uma letra.
 */
@SuppressWarnings("unused")
public class Tracos extends Comunicado implements Cloneable, Serializable
{
        private char texto[]; // Array para cada traço da palavra.


        /**
         * Construtor da classe Tracos.
         * @param qtdMax O número máximo de traços a serem inicializados.
         * @throws Exception Se a quantidade máxima for menor que 0.
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
         * Revela um traço na posição especificada, substituindo-o pela letra fornecida.
         * @param posicao A posição do traço a ser revelado.
         * @param letra A letra que será exibida na posição especificada.
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
         * @return {@code true} se ainda houver traços não revelados, {@code false} caso contrário.
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
          * Retorna uma representação em forma de string dos traços.
          * @return Uma string representando os traços.
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
          * Verifica se dois objetos {@code Tracos} são iguais.
          * @param obj O objeto a ser comparado.
          * @return true se os objetos forem iguais, false caso contrário.
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
         * Retorna o código de hash para os traços.
         * @return O código de hash calculado.
         */
        public int hashCode () 
        {
            int ret = 26;
            ret = 13 * ret + Arrays.hashCode(this.texto);
            if(ret < 0 ) ret = -ret;
            return ret;
        }


         /**
          * Construtor de cópia para a classe {@code Tracos}.
          * @param t O objeto {@code Tracos} a ser copiado.
          * @throws Exception Se o objeto {@code Tracos} fornecido for nulo.
          */
        public Tracos (Tracos t) throws Exception 
        {
            if (t ==null)
            {
                throw new Exception("tracinho ausente");
            }
            this.texto = new char[t.texto.length];

            t.texto = this.texto;
        }


         /**
          * Cria e retorna uma cópia do objeto {@code Tracos}.
          * @return Uma cópia do objeto {@code Tracos}.
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
        }
    }


