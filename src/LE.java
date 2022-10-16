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

    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < this.totalDeElementos;
    }
    private Celula retornaPosicao(int posicao){
        if(!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posicao Inexistente");
        }

        Celula atual = primeira;

        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    public void inserePosicao(int posicao, Object elemento) {

        if (posicao == 0) {
            adicionaInicio(elemento);
        } else if (posicao == this.totalDeElementos) {
            adicionaFinal(elemento);
        } else {
            Celula anterior = this.retornaPosicao(posicao - 1);
            Celula nova = new Celula(elemento, anterior.getProximo());
            anterior.setProximo(nova);
            this.totalDeElementos++;
        }

    }

    public void removeInicio(){
        if(this.totalDeElementos == 0) {
            throw new IllegalArgumentException("Lista vazia");
        }
        this.primeira = this.primeira.getProximo();
        this.totalDeElementos--;

        if(this.totalDeElementos == 0) {
            this.ultima = null;
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
