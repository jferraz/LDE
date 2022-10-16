package src;

public class TestaLDE {
    public static void main(String[] args) {
        LE lista = new LE();

        lista.adicionaInicio("Mauricio");
        lista.adicionaInicio("Paulo");
        lista.adicionaInicio("Guilherme");

        System.out.println(lista);

        lista.adicionaFinal("Marcelo");

        System.out.println(lista);

        lista.inserePosicao(2,"Ulisses");

        System.out.println(lista);

        lista.removeInicio();

        System.out.println(lista);
    }

    

    
}
