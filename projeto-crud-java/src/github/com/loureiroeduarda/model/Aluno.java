package github.com.loureiroeduarda.model;

import java.util.Date;

public class Aluno extends Pessoa{
    private Double nota;

    public Aluno(String nome, String telefone, Date dataNascimento, Date dataCadastro, Date dataAlteracao, Double nota) {
        super(nome, telefone, dataNascimento, dataCadastro, dataAlteracao);
        this.nota = nota;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
