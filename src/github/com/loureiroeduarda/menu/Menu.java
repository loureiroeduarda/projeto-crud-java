package github.com.loureiroeduarda.menu;

import github.com.loureiroeduarda.service.Service;

import java.util.Scanner;

public class Menu {
    private final Scanner sc;

    private final Service service;

    public Menu() {
        this.sc = new Scanner(System.in);
        this.service = new Service();
    }

    public void menu() {
        boolean continua = true;
        while (continua) {
            System.out.println("===============================================");
            System.out.println("Bem vindo ao sistema de cadastro de Pessoas e Alunos");
            System.out.println("Digite a opção desejada para: ");
            System.out.println("1 - Cadastrar uma Pessoa ou Aluno");
            System.out.println("2 - Listar todos os cadastros");
            System.out.println("3 - Listar apenas as Pessoas cadastradas");
            System.out.println("4 - Listar apenas os Alunos cadastrados");
            System.out.println("5 - Atualizar cadastros");
            System.out.println("6 - Excluir cadastros");
            System.out.println("0 - Encerrar o sistema");
            System.out.println("===============================================");
            int opcaoEscolhida = sc.nextInt();
            switch (opcaoEscolhida) {
                case 1:
                    service.cadastrar();
                    break;
                case 2:
                    service.imprimirTodos();
                    break;
                case 3:
                    service.imprimirPessoas();
                    break;
                case 4:
                    service.imprimirAlunos();
                    break;
                case 5:
                    service.atualizarCadastro();
                    break;
                case 6:
                    service.deletarCadastro();
                    break;
                case 0:
                    continua = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente Novamente!!");
            }
        }
    }
}
