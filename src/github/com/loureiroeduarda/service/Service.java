package github.com.loureiroeduarda.service;

import github.com.loureiroeduarda.model.Aluno;
import github.com.loureiroeduarda.model.Pessoa;
import github.com.loureiroeduarda.repository.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Service {
    private final Repository repository;

    public Service() {
        this.repository = new Repository();
    }

    public void cadastrar(Scanner sc) {
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite o CPF (formato xxx.xxx.xxx-xx): ");
        String cpf = sc.nextLine();
        if (repository.buscarPorCpf(cpf) != null) {
            System.out.println("O CPF inserido já está cadastrado! Tente novamente");
        } else {
            System.out.println("Digite o número de telefone (formato (DD) xxxxx-xxxx: ");
            String telefone = sc.nextLine();
            LocalDate dataNascimento = lerDataDeNascimento(sc);
            LocalDate dataCadastro = LocalDate.now();
            System.out.println("Deseja cadastrar a nota final do curso? Digite S para SIM e N para NÃO!");
            String resposta = sc.next().toUpperCase();
            while (!(resposta.equals("N") || resposta.equals("S"))) {
                System.out.println("Opção inválida! Tente Novamente!!");
                resposta = sc.next().toUpperCase();
            }
            if (resposta.equals("N")) {
                Pessoa pessoa = new Pessoa(nome, cpf, telefone, dataNascimento, dataCadastro, null);
                repository.cadastrarPessoa(pessoa);
                System.out.println("Pessoa cadastrada com sucesso!!");
            }
            if (resposta.equals("S")) {
                System.out.println("Digite a nota final do curso: ");
                sc.nextLine();
                String nt = sc.nextLine();
                Double nota = converterNota(nt);

                Aluno aluno = new Aluno(nome, cpf, telefone, dataNascimento, dataCadastro, null, nota);
                repository.cadastrarAluno(aluno);
                System.out.println("Aluno cadastrado com sucesso!!");
            }
        }
    }

    private Double converterNota(String nota) {
        return Double.parseDouble(nota.replaceAll(",", "."));
    }

    private LocalDate lerDataDeNascimento(Scanner sc) {
        System.out.println("Digite a data de nascimento (formato DD/MM/AAAA): ");
        String data = sc.nextLine();
        while (formatarData(data) == null) {
            System.out.println("Data de nascimento inválida! Digite novamente (formato DD/MM/AAAA):");
            data = sc.nextLine();
        }
        return formatarData(data);
    }

    private LocalDate formatarData(String data) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(data, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
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

    public void atualizarCadastro(Scanner sc) {
        System.out.println("Digite o CPF que deseja atualizar (formato xxx.xxx.xxx-xx): ");
        String cpf = sc.nextLine();
        Pessoa pessoaOriginal = repository.buscarPorCpf(cpf);
        if (pessoaOriginal != null) {
            System.out.println("Digite o nome: ");
            String nome = sc.nextLine();
            System.out.println("Digite o número de telefone (formato (DD) xxxxx-xxxx: ");
            String telefone = sc.nextLine();
            LocalDate dataNascimento = lerDataDeNascimento(sc);
            LocalDate dataAlteracao = LocalDate.now();
            if (pessoaOriginal instanceof Aluno) {
                System.out.println("Digite a nota final do curso: ");
                String nt = sc.nextLine();
                Double nota = converterNota(nt);

                Aluno aluno = new Aluno(nome, cpf, telefone, dataNascimento, pessoaOriginal.getDataCadastro(), dataAlteracao, nota);
                repository.atualizar(aluno);
            } else {
                Pessoa pessoa = new Pessoa(nome, cpf, telefone, dataNascimento, pessoaOriginal.getDataCadastro(), dataAlteracao);
                repository.atualizar(pessoa);
            }
            System.out.println("Cadastro atualizado com sucesso!!");
        } else {
            System.out.println("CPF não cadastrado! Tente novamente!");
        }
    }

    public void deletarCadastro(Scanner sc) {
        System.out.println("Digite o CPF que deseja excluir: ");
        String cpf = sc.nextLine();
        Pessoa pessoa = repository.buscarPorCpf(cpf);
        if (pessoa != null) {
            repository.deletar(pessoa);
            System.out.println("Cadastro excluído com sucesso!!");
        } else {
            System.out.println("CPF não cadastrado! Tente novamente!");
        }
    }
}
