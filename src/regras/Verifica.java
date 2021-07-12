package regras;

//Classe Verifica responsável pelo método de verificação dos estados final
public class Verifica {

    //Instanciação da nossa variável privada que possui o valor chave para nossa aceitação.
    private int[] aceitacao = {2};

    //Método aceita() responsável por dizer se algum dos elementos presente na variável estados é igual ao estado de aceitação
    public boolean aceita(int[] estados){

        //Caso a variável estados seja null significa que nosso NFA não chegou a aceitação, então retornamos false.
        if(estados == null){
            return false;
        }

        //Após verificar que a variável estados não é vazia agora temos que verificar se algum dos elementos presentes na variável estados, a variável
        //...com os estados após o final da análise da cadeia é igual a aceitacao.
        //Para isso, temos que percorrer todos os elementos presentes na variável estados e analisar todos os elementos dela com todos os elementos
        //...da variável aceitacao.
        for(int i:estados){
            for(int j:this.aceitacao){

                //Caso pelo menos um elemento da variável estados seja igual a algum elemento da variável aceitacao retornamos true
                if(i == j){
                    return true;
                }
            }
        }
        //Caso nenhum elemento presente na variável estados seja igual a pelo menos um da variável aceitacao, retornamos false.
        return false;
    }
}
