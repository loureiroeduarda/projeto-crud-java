package github.com.loureiroeduarda;

import github.com.loureiroeduarda.service.Service;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        service.cadastrar();
        service.imprimirTodos();
        service.imprimirPessoas();
        service.imprimirAlunos();
        service.atualizarCadastro();
        service.deletarCadastro();
        service.imprimirTodos();
    }
}