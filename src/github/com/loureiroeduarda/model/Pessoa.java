package github.com.loureiroeduarda.model;

import java.time.LocalDate;

public class Pessoa {
    protected String nome;
    protected String cpf;
    protected String telefone;
    protected LocalDate dataNascimento;
    protected LocalDate dataCadastro;
    protected LocalDate dataAlteracao;

    public Pessoa(String nome, String cpf, String telefone, LocalDate dataNascimento, LocalDate dataCadastro, LocalDate dataAlteracao) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    @Override
    public String toString() {
        String objeto = "Nome: " + nome + " - " +
                "CPF: " + cpf + " - " +
                "Telefone: " + telefone + " - " +
                "Data de nascimento: " + dataNascimento + " - " +
                "Data de cadastro: " + dataCadastro;

        if (dataAlteracao == null) {
            return objeto;
        }
        return objeto + " - " + "Data da última alteração: " + dataAlteracao;
    }
}
