package github.com.loureiroeduarda.model;

import java.time.LocalDate;

public class Aluno extends Pessoa {
    private Double nota;

    public Aluno(String nome, String cpf, String telefone, LocalDate dataNascimento, LocalDate dataCadastro, LocalDate dataAlteracao, Double nota) {
        super(nome, cpf, telefone, dataNascimento, dataCadastro, dataAlteracao);
        this.nota = nota;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nota=" + nota +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", dataCadastro=" + dataCadastro +
                ", dataAlteracao=" + dataAlteracao +
                '}';
    }
}
