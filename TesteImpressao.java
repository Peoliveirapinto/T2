public class TesteImpressao {
    public static void main(String[] args) {
    Documento doc1 = new Documento("doc1.txt", "Alice");
    Documento doc2 = new Documento("doc2.txt", "Carlos");
    Documento doc3 = new Documento("doc3.txt", "Jonas");
    Documento doc4 = new Documento("doc4.txt", "Diana");
    Documento doc5 = new Documento("doc5.txt", "Eva");
    Documento doc6 = new Documento("doc6.txt", "Cleber");
    Fila fila = new Fila(5);

    fila.solicita(doc1);
    fila.solicita(doc2);
    fila.solicita(doc3);
    fila.solicita(doc4);
    fila.solicita(doc5);
    fila.solicita(doc6);

    fila.imprime();

    System.out.println("consulta doc4: ");
    fila.consulta("doc4.txt");


    }
}