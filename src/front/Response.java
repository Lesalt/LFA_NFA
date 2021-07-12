package front;

//Importamos a classe Verifica presente no pacote regras.
import regras.Verifica;

//Classe Response responsável por todas as respostas fornecidas ao usuário.
public class Response {

    //Método validação, ela irá informar se a cadeia fornecida pelo usuário é válida.
    public void validacao(int[] estadosFinal){

        //Instanciação do objeto verifica
        Verifica verifica = new Verifica();

        //Se o retorno do método aceita() presente na classe Verifica for true será informado ao usuário que a cadeia é válida.
        if(verifica.aceita(estadosFinal)){
            System.out.println("Cadeia Válida!!!");
         //Caso o retorno seja false será informado que a cadeia é inválida.
        }else{
            System.out.println("Cadeia Inválida!!!");
        }
    }

    //Método responsável por mostrar ao usuário passo a passo o processo de verificação do NFA.
    public void mostraProcess(String cadeia, int estadoAtual, int posi){

        //Para isso utilizamos o método substring(), que atráves das passagens de parâmetro conseguimos imprimir determinadas partes da nossa string
        //... separando ela de maneira análoga a um array.
        System.out.print(cadeia.substring(0, posi));
        System.out.print("[q" + estadoAtual + "]");
        System.out.println(cadeia.substring(posi));
    }

    //Método responsável por mostrar que se chegou ao fim da cadeia.
    public void end(){
        System.out.println("Fim da cadeia");
    }
    //Método responsável por informar que não houve mudança de estado.
    public void noChange(){
        System.out.println("Não houve mudança de estado!!!");
    }
}
