import java.io.*;
import java.net.*;
import java.util.*;

public class SupervisoraDeConexao extends Thread
{

    Tracos tracinhos_Servidor;
    Palavra palavra_Servidor;
    String message1,message2,message3;
    ControladorDeLetrasJaDigitadas c_Servidor;
    ControladorDeErros controle_Servidor;

    private Parceiro usuario; // cliente que será supervisionada
    private Socket conexao;
    private ArrayList<Parceiro> usuarios;


    public SupervisoraDeConexao
            (Socket conexao, ArrayList<Parceiro> usuarios)
            throws Exception {
        if (conexao == null)
            throw new Exception("Conexao ausente");

        if (usuarios == null)
            throw new Exception("Usuarios ausentes");

        this.conexao = conexao;
        this.usuarios = usuarios;

    }

    public void run()
    {


        ObjectOutputStream transmissor;
        try {
            transmissor =
                    new ObjectOutputStream(
                            this.conexao.getOutputStream());
        } catch (Exception erro) {
            return;
        }

        ObjectInputStream receptor = null;
        try {
            receptor =
                    new ObjectInputStream(
                            this.conexao.getInputStream());
        } catch (Exception err0) {
            try {
                transmissor.close();
            } catch (Exception falha) {
            } // so tentando fechar antes de acabar a thread

            return;
        }

        try {
            this.usuario =
                    new Parceiro(this.conexao,
                            receptor,
                            transmissor);
        } catch (Exception erro) {
        } // sei que passei os parametros corretos
        try {
            synchronized (this.usuarios) {
                this.usuarios.add(this.usuario); //adicionando na estrutura de dados o novo cliente instanciado
            }

            for (;;)
            {
                Comunicado comunicado = this.usuario.envie();


                if (comunicado == null) return;

                if (comunicado instanceof PedidoDeOperacao)
                {

                    PedidoDeOperacao pedidoDeOperacao = (PedidoDeOperacao) comunicado; //comunicado visto como pedido de operação

                    c_Servidor = pedidoDeOperacao.c;
                    controle_Servidor = pedidoDeOperacao.controle;
                    palavra_Servidor = pedidoDeOperacao.palavra;
                    tracinhos_Servidor = pedidoDeOperacao.tracinhos;

                        c_Servidor.registre(pedidoDeOperacao.getLetra());

                        int qtd = palavra_Servidor.getQuantidade(pedidoDeOperacao.getLetra());
                        if (qtd == 0)
                        {
                             message1 = "A palavra não possui essa letra!\n";
                            controle_Servidor.registreUmErro();
                        }
                        else if (qtd != 0)
                        {

                            for (int i = 0; i < qtd; i++)
                            {
                                int posicao = palavra_Servidor.getPosicaoDaIezimaOcorrencia(i, pedidoDeOperacao.getLetra());
                                tracinhos_Servidor.revele(posicao, pedidoDeOperacao.getLetra());
                            }
                        }

                        if (controle_Servidor.isAtingidoMaximoDeErros())
                        {
                             message2 = "Que pena! Você perdeu! A palavra era " + palavra_Servidor + "\n";

                        }
                        else
                        {
                             message3 = "Parabens! Você ganhou! A palavra era mesmo " + palavra_Servidor + "\n";

                        }


                }
                 if (comunicado instanceof PedidoDeResultado) //verificando se o comunicado é um Pedido de Resultado
                {
                    this.usuario.receba (new Resultado(controle_Servidor, palavra_Servidor,
                            tracinhos_Servidor, c_Servidor));
                }
                if (comunicado instanceof PedidoParaSair)
                {
                    try {
                        synchronized (this.usuarios)
                        {
                            this.usuarios.remove(this.usuario);
                        }
                        this.usuario.adeus();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception erro) {
            try {
                transmissor.close();
                receptor.close();
            } catch (Exception falha) {
            } // so tentando fechar antes de acabar a thread

            return;
        }
    }
}














