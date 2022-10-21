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
        System.out.println("Digite o CPF: ");
        String cpf = sc.nextLine();
        System.out.println("Digite o número de telefone: ");
        String telefone = sc.nextLine();
        System.out.println("Digite a data de nascimento (formato ano-mês-dia): ");
        LocalDate dataNascimento = LocalDate.parse(sc.nextLine());
        LocalDate dataCadastro = LocalDate.now();
        System.out.println("Deseja cadastrar a nota final do curso? Digite S para SIM e N para NÃO!");
        String resposta = sc.next();
        if (resposta.equals("N")) {
            Pessoa pessoa = new Pessoa(nome, cpf, telefone, dataNascimento, dataCadastro, null);
            repository.cadastrarPessoa(pessoa);
        } else {
            System.out.println("Digite a nota final do curso: ");
            Double nota = sc.nextDouble();

            Aluno aluno = new Aluno(nome, cpf, telefone, dataNascimento, dataCadastro, null, nota);
            repository.cadastrarAluno(aluno);
        }
        sc.nextLine();
    }

    public void imprimirTodos() {
        System.out.println("Lista de todos os cadastros efetuados: ");
        for (Pessoa pessoa : repository.listarTodos()) {
            System.out.println(pessoa);
        }
    }

    public void imprimirPessoas() {
        System.out.println("Lista de todas as pessoas cadastradas: ");
        repository.listarPessoas().forEach(System.out::println);
    }

    public void imprimirAlunos() {
        System.out.println("Lista de todos os alunos cadastrados: ");
        repository.listarAlunos().forEach(System.out::println);
    }

    public void atualizarCadastro() {
        System.out.println("Digite o CPF que deseja atualizar: ");
        String cpf = sc.nextLine();
        Pessoa pessoaOriginal = repository.buscarPorCpf(cpf);
        if (pessoaOriginal != null) {
            System.out.println("Digite o nome: ");
            String nome = sc.nextLine();
            System.out.println("Digite o número de telefone: ");
            String telefone = sc.nextLine();
            System.out.println("Digite a data de nascimento (formato ano-mês-dia): ");
            LocalDate dataNascimento = LocalDate.parse(sc.nextLine());
            LocalDate dataAlteracao = LocalDate.now();
            if (pessoaOriginal instanceof Aluno) {
                System.out.println("Digite a nota final do curso: ");
                Double nota = sc.nextDouble();
                sc.nextLine();

                Aluno aluno = new Aluno(nome, cpf, telefone, dataNascimento, pessoaOriginal.getDataCadastro(), dataAlteracao, nota);
                repository.atualizar(aluno);
            } else {
                Pessoa pessoa = new Pessoa(nome, cpf, telefone, dataNascimento, pessoaOriginal.getDataCadastro(), dataAlteracao);
                repository.atualizar(pessoa);
            }
        } else {
            System.out.println("CPF não cadastrado! Tente novamente!");
        }
    }

    public void deletarCadastro() {
        System.out.println("Digite o CPF que deseja excluir: ");
        String cpf = sc.nextLine();
        Pessoa pessoa = repository.buscarPorCpf(cpf);
        if (pessoa != null) {
            repository.deletar(pessoa);
        } else {
            System.out.println("CPF não cadastrado! Tente novamente!");
        }
    }
}
