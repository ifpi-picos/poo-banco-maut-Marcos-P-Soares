import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu (Scanner scanner) {
        this.scanner = scanner;
    }
    public void menu1() {
        System.out.println("Bem vindo ao Banco MAUT \n \n");
        System.out.println("Se você deseja abrir uma conta - Insira 1 \n");
        System.out.println("Se você já tem uma conta e deseja acessar - Insira 2 \n");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                menuCadastro();
            case 2:
                menuAcesso();
            default:
                System.out.println("Valor inserido é invalido\n");
                menu1();
        }   
    }

    public void menuCadastro(){
        System.out.println("Para criar sua conta forneça os dados solicitados abaixo: \n");
        System.out.println("Informe seu Nome: \n");
        System.out.println("Informe seu CPF: \n");
        System.out.println("Informe sua Data de Nascimento: \n");
        System.out.println("Informe seu Pais: \n");
        System.out.println("Informe seu Estado: \n");
        System.out.println("Informe seu Cidade: \n");
        System.out.println("Informe seu Bairro: \n");
        System.out.println("Informe sua Rua: \n");
        System.out.println("Informe seu CEP: \n");
        System.out.println("Informe uma Referência para seu endereço: \n");

    }

    public void menuAcesso (){
        System.out.println("BANCO MAUT\n");
        
    }

}