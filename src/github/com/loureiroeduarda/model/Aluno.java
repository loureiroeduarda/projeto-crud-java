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
        String objeto = "Nome: " + nome + " - " +
                "CPF: " + cpf + " - " +
                "Telefone: " + telefone + " - " +
                "Nota final do curso: " + nota + " - " +
                "Data de nascimento: " + dataNascimento + " - " +
                "Data de cadastro: " + dataCadastro;

        if (dataAlteracao == null) {
            return objeto;
        }
        return objeto + " - " + "Data da última alteração: " + dataAlteracao;
    }
}
