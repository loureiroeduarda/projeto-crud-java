package github.com.loureiroeduarda.model;

import java.time.LocalDate;

public class Aluno extends Pessoa {
    private Double nota;

    public Aluno(String nome, String telefone, LocalDate dataNascimento, LocalDate dataCadastro, LocalDate dataAlteracao, Double nota) {
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
