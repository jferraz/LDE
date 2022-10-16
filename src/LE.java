package src;
// FEITO 1) buscar um elemento na LDE. Retorne -1 caso não encontre o elemento ou a posição do elemento encontrado (int);
// FEITO 2) Remover do meio (5 elementos - deletar 3); {1,2,3,4,5} => removerMeio() => {1,2,4,5};
// 3) Verificar se a LDE tem elementos repetidos (fazer um método para retornar true ou false caso a lista tenha ou não elementos repetidos;
// 4) Supondo que a LDE tem elementos repetidos verificar qual é o elemento que mais se repete.
// 5) Implemente um método para inverter uma LDE;
// FEITO 6) Implemente um método para remover de qualquer posição da LDE;
public class LE {

    private Celula primeira = null;
    private Celula ultima = null;
    private int totalDeElementos = 0;

    public void adicionaInicio(Object elemento){
        if(this.totalDeElementos == 0){
            Celula nova = new Celula(elemento);
            this.primeira = nova;
            this.ultima = nova;
        } else {
            Celula nova = new Celula(this.primeira, elemento);
            this.primeira.setAnterior(nova);
            this.primeira = nova;
        }
        this.totalDeElementos++;
    }

    public void adicionaFinal(Object elemento){
        if(this.totalDeElementos == 0){
            adicionaInicio(elemento);
        } else {
            Celula nova = new Celula(elemento);
            this.ultima.setProximo(nova);
            nova.setAnterior(this.ultima);
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
            Celula proxima = anterior.getProximo();

            Celula nova = new Celula(anterior.getProximo(),elemento);
            nova.setAnterior(anterior);
            anterior.setProximo(nova);
            proxima.setAnterior(nova);
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

    public void removeFinal(){
        if(this.totalDeElementos == 1){
            this.removeInicio();
        } else {
            Celula penultima = this.ultima.getAnterior();
            penultima.setProximo(null);
            this.ultima = penultima;
            this.totalDeElementos--;
        }
    }

    public void removePosicao(int posicao){
        if(posicao == 0) {
            this.removeInicio();
        } else if (posicao == this.totalDeElementos - 1){
            this.removeFinal();
        } else {
            Celula anterior = this.retornaPosicao(posicao - 1);
            Celula atual = anterior.getProximo();
            Celula proxima = atual.getProximo();

            anterior.setProximo(proxima);
            proxima.setAnterior(anterior);

            this.totalDeElementos--;
        }
    }

    // 1) buscar um elemento na LDE. Retorne -1 caso não encontre o elemento ou a posição do elemento encontrado (int);
    public Object buscarElemento(Object elemento){
        Celula atual = this.primeira;
        for (int i = 0; i < totalDeElementos; i++) {
            if (atual.getElemento().equals(elemento)) {
                return "Elemento encontra-se na posição " + i;
            }
            atual = atual.getProximo();
        }
        return "-1";
    }

//    public void inverteLDE(){
//        Celula atual = this.ultima;
//
//    }


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
