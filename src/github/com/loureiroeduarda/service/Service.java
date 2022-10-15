package github.com.loureiroeduarda.service;

import github.com.loureiroeduarda.model.Aluno;
import github.com.loureiroeduarda.model.Pessoa;
import github.com.loureiroeduarda.repository.Repository;

import java.time.LocalDate;
import java.util.Scanner;

public class Service {
    private final Scanner sc;
    private final Repository repository;

    public Service() {
        this.sc = new Scanner(System.in);
        this.repository = new Repository();
    }

    public void cadastrar() {
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite o número de telefone: ");
        String telefone = sc.nextLine();
        System.out.println("Digite a data de nascimento (formato ano-mês-dia): ");
        LocalDate dataNascimento = LocalDate.parse(sc.nextLine());
        LocalDate dataCadastro = LocalDate.now();
        System.out.println("Deseja cadastrar a nota final do curso? Digite S para SIM e N para NÃO!");
        String resposta = sc.next();
        if (resposta.equals("N")) {
            Pessoa pessoa = new Pessoa(nome, telefone, dataNascimento, dataCadastro, null);
            repository.cadastrarPessoa(pessoa);
        } else {
            System.out.println("Digite a nota final do curso: ");
            Double nota = sc.nextDouble();

            Aluno aluno = new Aluno(nome, telefone, dataNascimento, dataCadastro, null, nota);
            repository.cadastrarAluno(aluno);
        }
    }

    public void imprimirTodos() {
        for (Pessoa pessoa : repository.listarTodos()) {
            System.out.println(pessoa);
        }
    }

    public void imprimirPessoas() {
        System.out.println("Lista de pessoas cadastradas: ");
        repository.listarPessoas().forEach(System.out::println);
    }

    public void imprimirAlunos() {
        System.out.println("Lista de alunos cadastrados: ");
        repository.listarAlunos().forEach(System.out::println);
    }
}
