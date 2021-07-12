package front;
//Importação do pacote javax com a classe swing para podermos utilizar o showInputDialog()
import javax.swing.*;

//Classe Resquest responsável por todas as requisições ao usuário.
public class Request {

    //Método informa responsáve por obter qual a cadeia que o usuário quer trabalhar.
    public String informa(){

        //Atribuindo a variável cadeia, do tipo String, a cadeia que o usuário informou.
        String cadeia = JOptionPane.showInputDialog("Informe a cadeia: ");

        //Retorno da cadeia informada pelo usuário.
        return cadeia;
    }
}
