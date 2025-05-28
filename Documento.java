import java.util.Date;

public class Documento {
    String nomeArquivo;
    String nomeUsuario;
    long horarioSolicitacao;
    public String getNomeArquivo() {
        return nomeArquivo;
    }
    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public long getHorarioSolicitacao() {
        return horarioSolicitacao;
    }
    public void setHorarioSolicitacao() {
        this.horarioSolicitacao = new Date().getTime();
    }
}