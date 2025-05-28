public class Fila {
    Documento[] dados;
    int primeiro, ultimo, ocupacao;
    public Fila (int capacidade) {
        dados = new Documento[capacidade];
        //por clareza
        primeiro = 0;
        ultimo = 0;
        ocupacao = 0;
    }
    public Fila () {
        this(10);
    }
    public boolean filaVazia() {
        return ocupacao == 0;
    }
    public boolean filaCheia() {
        return ocupacao == dados.length;
    }
    private int proxima (int pos) {
        return (pos + 1) % dados.length;
    }
    public void enfileira (Documento e) {
        if (filaCheia()) throw new RuntimeException("falha no enfileiramento");
        dados[ultimo] = e;
        ultimo = proxima(ultimo);
        ocupacao++;
    }
    public Documento desenfileira () {
        if (filaVazia()) throw new RuntimeException("falha no desenfileiramento");
        Documento temp = dados[primeiro];
        primeiro = proxima(primeiro);
        temp.setHorarioImpressao();
        ocupacao--;
        return temp;
    }
    @Override
    public String toString () {
        if (filaVazia()) return "fila vazia";
        String s = "";
        for (int i=primeiro, cont=0; cont < ocupacao; cont++) {
            s += dados[i] + "\n";
            i = proxima(i);
        }
        return s;
    }
}