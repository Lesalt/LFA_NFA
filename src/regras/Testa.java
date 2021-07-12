package regras;

//Importamos o classe Response presente no pacote front
import front.Response;

//Importamos a classe Tabela presente no pacote model
import model.Tabela;

//Classe Testa onde possuí o método necessário para execução das regras de um NFA
public class Testa {

    //Instanciação dos objetos utilizados no método. Obs.: Como estamos utilizando POO, podemos acrescentar
    //...outros métodos nessa classe caso as regras de um NFA mude, porém, não é o caso e por isso só foi
    //...utilizado um método que é o suficiente.
    private Response response = new Response();
    private Verifica verifica = new Verifica();
    private Tabela tabela = new Tabela();

    //Método testa() responsável pelo cumprimento das regras de um NFA
    public int[] testa(String cadeia, int[] estadosAtuais, int posi) {

        //Atribuímos à variável tabela a nossa tabela de transição do NFA atrávez do nosso método matriz()
        int[][][] tabela = this.tabela.matriz();

        //Aqui fazemos uma verificação, caso a variável posi, que é uma variável do tipo inteiro passada como parâmetro no método testa(),
        //... for igual ao tamanho da cadeia irá ser mostrado a cadeia juntamente com seu estado ao final do processo. Lembrando que a variável
        //...posi serve como base para sabermos qual é o caractare da cadeia que está sendo analisado. Essa parte do método também é mt importante
        //...pois é nela que iremos determinar a parada da nossa recursão, que existe para trabalharmos a bifurcação existente na transição de estados
        //...de um NFA.
        if(posi == cadeia.length()){
            this.response.mostraProcess(cadeia,estadosAtuais[0], posi);

            //Caso ao chegar no final da cadeia e pelo menos um dos estados serem iguais a aceitação retorna esses estados.
            if(this.verifica.aceita(estadosAtuais)){
                return estadosAtuais;
            }
            //Após chegar ao final é mostrando ao usuário que se chegou ao fim da cadeia.
            response.end();
            return null;
        }

        //Aqui é feito o parse do caractere da cadeia e atribuido à variável elemento para podermos trabalhar com a transição dos estados.
        int elemento = Integer.parseInt(cadeia.substring(posi, posi + 1));

        //loop do tipo for responsável por percorrer todos estados presentes na variável estadosAtuais
        for(int i: estadosAtuais){

            //Mostra como está o processo do NFA após a verificação do caractare da posição i da cadeia
            this.response.mostraProcess(cadeia, i, posi);

            //Aqui é feita a mudança dos estados com base nas posições da nossa tabela de transição.
            int[] novosEstados = tabela[i][elemento];

            //Caso não houve mudanças, ou seja, caso nossa váriavel novosEstados seja vazia informamos para o usuário que não houve mudança de estado.
            if(novosEstados.length == 0){
                response.noChange();
                return null;
            }

            //Aqui trabalhamos os casos de bifurcação do nosso NFA, os casos onde com uma entrada ele pode ir para diferentes estados.
            //Para isso utilizamos uma recursão, chamando nosso método testa() dentro dele mesmo e atribuindo o retorno a variável novoProcesso,
            //...porém partindo dos novosEstados, para podermos verificar se após a bifurcação chega-se a aceitação.
            int[] novoProcesso = testa(cadeia, novosEstados, posi + 1);

            //Caso houve uma bifurcação retornaremos o resultado de novoProcesso, pois queremos o resultado final presente após a bifurcação.
            if(novoProcesso != null){

                return novoProcesso;
            }
        }
        return null;
    }
}
