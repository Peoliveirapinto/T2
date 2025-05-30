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
    public void solicita (Documento e) {
        if (filaCheia()) throw new RuntimeException("falha no enfileiramento");
        e.setHorarioSolicitacao();
        dados[ultimo] = e;
        ultimo = proxima(ultimo);
        ocupacao++;
    }
    public Documento imprime() {
        if (filaVazia()) throw new RuntimeException("falha no desenfileiramento");
        Documento temp = dados[primeiro];
        primeiro = proxima(primeiro);
        temp.setHorarioImpressao();
        long tempoImpressao = temp.getHorarioImpressao() - temp.getHorarioSolicitacao();
        System.out.println("Imprimindo documento: " + temp.getNomeArquivo() + " demorou " + tempoImpressao + " milisegundos");
        ocupacao--;
        return temp;
    }
    public void consulta(String nomeArquivo) {
        if (filaVazia()) throw new RuntimeException("fila vazia");
        for (int i = primeiro, cont = 1; cont <= ocupacao; cont++) {
            if (dados[i].getNomeArquivo().equals(nomeArquivo)) {
                System.out.println("Documento foi encontrado, ele está na posição " + cont + " da fila e foi solicidado à " + dados[i].getHorarioSolicitacao() + " milisegundos atrás");
                return;
            }
            i = proxima(i);
        }
        throw new RuntimeException("Documento não encontrado");

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