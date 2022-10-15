package github.com.loureiroeduarda.repository;

import github.com.loureiroeduarda.model.Aluno;
import github.com.loureiroeduarda.model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Pessoa> listarPessoas() {
        return bancoDeDados.stream().filter(p -> !(p instanceof Aluno)).collect(Collectors.toList());
    }

    public List<Pessoa> listarAlunos() {
        return bancoDeDados.stream().filter(a -> a instanceof Aluno).collect(Collectors.toList());
    }
}
