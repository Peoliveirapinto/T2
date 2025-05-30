public class Testes{
    public static void main(String[] args) {
        Documento doc1 = new Documento("doc1.txt", "Alice");
        Documento doc2 = new Documento("doc2.txt", "Carlos");
        Documento doc3 = new Documento("doc3.txt", "Jonas");
        Documento doc4 = new Documento("doc4.txt", "Diana");
        Documento doc5 = new Documento("doc5.txt", "Eva");
        Documento doc6 = new Documento("doc6.txt", "Cleber");
        Fila fila = new Fila(5);
        Pilha pilha = new Pilha(5);

        fila.solicita(doc1);
        fila.solicita(doc2);
        fila.solicita(doc3);
        fila.solicita(doc4);
        fila.solicita(doc5);

        pilha.solicita(fila.imprime());
        pilha.solicita(fila.imprime());

        System.out.println("consulta fila doc4: ");
        try {
            fila.consulta("doc4.txt");
        } catch (Exception e) {
            System.out.println("Erro ao consultar documento: " + e.getMessage());
        }

        fila.solicita(doc6);
        fila.solicita(doc1);
        try {
            fila.solicita(doc2);
        } catch (Exception e) {
            System.out.println("Erro ao solicitar documento: " + e.getMessage());
        }

        System.out.println("Fila após solicitações:");
        System.out.println(fila);

        pilha.solicita(doc3);
        pilha.solicita(doc4);
        pilha.solicita(doc5);
        pilha.reimprime();
        pilha.reimprime();

        System.out.println("consulta pilha doc2: ");
        try {
            pilha.consulta("doc2.txt");
        } catch (Exception e) {
            System.out.println("Erro ao consultar documento: " + e.getMessage());
        }

        pilha.solicita(doc6);
        pilha.solicita(doc4);
        try {
            pilha.solicita(doc5);
        } catch (Exception e) {
            System.out.println("Erro ao solicitar documento: " + e.getMessage());
        }

        System.out.println("Pilha após solicitações:");
        System.out.println(pilha);
    }
}