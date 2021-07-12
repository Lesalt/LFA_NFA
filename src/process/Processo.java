package process;

//Importação do pacote front juntamente com a classe Response
import front.Response;
import regras.Testa;

//Classe Processo responsável pelo processo do nosso NFA.
public class Processo {
    //Instanciação dos objetos e de variável global  usados nessa classe
    private Testa testa = new Testa();
    private int estadoInicial = 0;
    private Response response = new Response();

    //Metodo processa(), ele é responsável processo do nosso NFA
    public void processa(String cadeia){

        //Nossa variável estadoAtual servirá como base para podermos executar as regras de um NFA, como
        //...um NFA pode "estar em mais de um estado" nós atribuimos a variavel como um array unidimencional
        //...e como padrão começamos em apenas um estado, o estado 0.
        int[] estadoAtual = {this.estadoInicial};

        //Como nosso estado final, diferente do estado inicial, pode ser mais de um tbm atribuímos como um array unidimencional.
        //Os nossos estados final será determinado pelas regras do NFA, as quais são trabalhadas no método testa() da classe Testa.
        int[] estadosFinal = this.testa.testa(cadeia, estadoAtual, 0);

        //chamamos o método validacao() presente na classe Response.
        response.validacao(estadosFinal);
    }
}
