//Importação dos pacotes e respectivas classes que irá ser usada na main, explico cada uma nas suas classes.
import front.Request;
import process.Processo;
public class main {
    public static void main(String[] args) {
        //Instanciação do objeto request
        Request request = new Request();

        //Instanciação do objeto processo
        Processo processo = new Processo();

        //Variável cadeia recebe a cadeia fornecida pelo usuário
        String cadeia = request.informa();

        //Com a cadeia fornecida pelo usuário é realizado o processo do NFA
        processo.processa(cadeia);
    }

}
