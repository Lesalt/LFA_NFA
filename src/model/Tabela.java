package model;

public class Tabela {

    //Método matriz(), ele irá retornar a matriz utilizada como base para a tabela de transição do NFA
    public int[][][] matriz() {
        //Atribuindo a tabela de transição à variável matriz
        int[][][] matriz = {{{0, 1}, {0}},
                           {{     }, {2}},
                           {{     }, { }}};
        //retorno da variável matriz/tabela de transição do NFA
        return matriz;
    }
}
