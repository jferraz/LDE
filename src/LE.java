package src;

public class LE {

    private Celula primeira = null;
    private Celula ultima = null;
    private int totalDeElementos = 0;

    public void adicionaInicio(Object elemento){
        Celula nova = new Celula(elemento, primeira);
        this.primeira = nova;

        if(this.totalDeElementos == 0){
            this.ultima = this.primeira;

        }
        this.totalDeElementos++;
    }

    public void adicionaFinal(Object elemento){
        if(this.totalDeElementos == 0){
            adicionaInicio(elemento);
        } else {
            Celula nova = new Celula(elemento, null);
            this.ultima.setProximo(nova);
            this.ultima = nova;
            this.totalDeElementos++;
        }
    }









    @Override
    public String toString() {

        if(this.totalDeElementos == 0){
            return "[]";
        }

        Celula atual = primeira;

        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < totalDeElementos; i++) {
            builder.append(atual.getElemento());
            builder.append(" | ");
            
            atual = atual.getProximo();
        }

        builder.append("]");

        return builder.toString();
    }
    
}
