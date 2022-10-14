package github.com.loureiroeduarda.repository;

import github.com.loureiroeduarda.model.Aluno;
import github.com.loureiroeduarda.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private final ArrayList<Pessoa> bancoDeDados;

    public Repository() {
        this.bancoDeDados = new ArrayList<>();
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        this.bancoDeDados.add(pessoa);
    }

    public void cadastrarAluno(Aluno aluno) {
        this.bancoDeDados.add(aluno);
    }

    public List<Pessoa> listarTodos() {
        return this.bancoDeDados;
    }
}
