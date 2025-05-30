public class Pilha {
    Documento[] dados;
    int primeiro, ultimo, ocupacao;
    public Pilha (int capacidade) {
        dados = new Documento[capacidade];
        //por clareza
        primeiro = 0;
        ultimo = 0;
        ocupacao = 0;
    }
    public Pilha () {
        this(10);
    }
    public boolean pilhaVazia() {
        return ocupacao == 0;
    }
    public boolean pilhaCheia() {
        return ocupacao == dados.length;
    }
    private int proxima (int pos) {
        return (pos + 1) % dados.length;
    }

    private int anterior (int pos) {
        return (pos - 1 + dados.length) % dados.length;
    }

    public void solicita (Documento e) {
        if (pilhaCheia()) throw new RuntimeException("falha no enfileiramento");
        e.setHorarioSolicitacao();
        dados[ultimo] = e;
        ultimo = proxima(ultimo);
        ocupacao++;
    }
    public Documento reimprime() {
        if (pilhaVazia()) throw new RuntimeException("falha no desenfileiramento");
        Documento temp = dados[ultimo];
        ultimo = anterior(ultimo);
        temp.setHorarioReimpressao();
        long tempoReimpressao = temp.getHorarioReimpressao() - temp.getHorarioSolicitacao();
        System.out.println("Reimprimindo documento: " + temp.getNomeArquivo() + " demorou " + tempoReimpressao + " milisegundos");
        ocupacao--;
        return temp;
    }
    public void consulta(String nomeArquivo) {
        if (pilhaVazia()) throw new RuntimeException("pilha vazia");
        for (int i = primeiro, cont = ocupacao; cont >= 0; cont--) {
            if (dados[i].getNomeArquivo().equals(nomeArquivo)) {
                System.out.println("Documento foi encontrado, ele está na posição " + (ocupacao - cont) + " da pilha e foi solicidado à " + dados[i].getHorarioSolicitacao() + " milisegundos atrás");
                return;
            }
            i = proxima(i);
        }
        throw new RuntimeException("Documento não encontrado");

    }
    @Override
    public String toString () {
        if (pilhaVazia()) return "pilha vazia";
        String s = "";
        for (int i=primeiro, cont=0; cont < ocupacao; cont++) {
            s += dados[i] + "\n";
            i = proxima(i);
        }
        return s;
    }
}