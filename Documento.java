import java.util.Date;

public class Documento {
    String nomeArquivo;
    String nomeUsuario;
    long horarioSolicitacao;
    long horarioImpressao;
    long horarioReimpressao;
    
    public Documento(String nomeArquivo, String nomeUsuario) {
        this.nomeArquivo = nomeArquivo;
        this.nomeUsuario = nomeUsuario;
        this.horarioSolicitacao = 0;
        this.horarioImpressao = 0;
        this.horarioReimpressao = 0;
    }

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
    public long getHorarioImpressao() {
        return horarioImpressao;
    }
    public void setHorarioImpressao() {
        this.horarioImpressao = new Date().getTime();
    }
    public long getHorarioReimpressao() {
        return horarioReimpressao;
    }
    public void setHorarioReimpressao() {
        this.horarioReimpressao = new Date().getTime();
    }
    @Override
    public String toString() {
        return
                nomeArquivo + '\n' +
                "Nome do usuário = " + nomeUsuario + '\n' +
                "Horário solicitado = " + horarioSolicitacao + '\n' +
                "Horário impressão = " + horarioImpressao + '\n' +
                "Horário reimpressao = " + horarioReimpressao + '\n';
    }
}