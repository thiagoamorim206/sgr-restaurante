package Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static int menuInicial() {
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        int optNumberMenuPrincipal = 0;
        /**
         * Menu Principal do sistema
         */
        do {

            System.out.println("-----------Menu inicial Restaurante-----------");
            System.out.println("1 - Cadastrar Dados.");
            System.out.println("2 - Deletar Dados.");
            System.out.println("3 - Editar Dados.");
            System.out.println("4 - Listar Dados.");
            System.out.println("5 - Produzir os pedidos");
            System.out.println("6 - Mostrar itens com estoque baixo");
            System.out.println("7 - Atualizar Estoque (fazer baixa)");
            System.out.println("8 - Feichar caixa");
            System.out.println("9 - Sair.");
            System.out.print("Digite uma opção: ");

            try {
                optNumberMenuPrincipal = scan.nextInt();

                System.out.println("----------------------------------------------------------");
                flag = true;

            } catch (InputMismatchException entreComInt) {
                System.out.println("ERRO! Entre com um número inteiro.");

            } catch (Exception e) {
                System.out.println("Ocoreu um erro: " + e.getMessage());

            } finally {
                scan.nextLine();
            }

        } while ((optNumberMenuPrincipal < 1 || optNumberMenuPrincipal > 9) || !flag);
        return optNumberMenuPrincipal;
    }

    public static int Submenu() {
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        int optNumberSubMenu = 0;
        /**
         * Menu Principal do sistema
         */
        do {

            System.out.println("-----------Menu de Cadastro-----------");
            System.out.println("1 - Cadastrar Pessoa.");
            System.out.println("2 - Cadastrar Fornecedor.");
            System.out.println("3 - Cadastrar Produto.");
            System.out.println("4 - Cadastrar Compra Produto.");
            System.out.println("5 - Cadastrar Tipo Cardapio.");
            System.out.println("6 - Cadastrar Tipo Restaurante.");
            System.out.println("7 - Cadastrar Cardapio.");
            System.out.println("8 - Cadastrar Mesa.");
            System.out.println("9 - Cadastrar Pedido.");
            System.out.println("10- Cadastrar Reserva.");
            System.out.println("11- Cadastrar Pagamento.");
            System.out.println("12- Sair.");
            System.out.print("Digite uma opção: ");

            try {
                optNumberSubMenu = scan.nextInt();
                System.out.println("----------------------------------------------------------");
                flag = true;

            } catch (InputMismatchException entreComInt) {
                System.out.println("ERRO! Entre com um número inteiro.");

            } catch (Exception e) {
                System.out.println("Ocoreu um erro: " + e.getMessage());

            } finally {
                scan.nextLine();
            }

        } while ((optNumberSubMenu < 1 || optNumberSubMenu > 12) || !flag);
        return optNumberSubMenu;
    }

    public static int SubmenuDeletar() {
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        int optNumberSubMenuDeletar = 0;
        /**
         * Menu Principal do sistema
         */
        do {

            System.out.println("-----------Menu de Deletar Cadastro-----------");
            System.out.println("1 - Deletar Pessoa.");
            System.out.println("2 - Deletar Fornecedor.");
            System.out.println("3 - Deletar Produto.");
            System.out.println("4 - Deletar Compra Produto.");
            System.out.println("5 - Deletar Tipo Cardapio.");
            System.out.println("6 - Deletar Tipo Restaurante.");
            System.out.println("7 - Deletar Cardapio.");
            System.out.println("8 - Deletar Mesa.");
            System.out.println("9 - Deletar Pedido.");
            System.out.println("10- Deletar Reserva.");
            System.out.println("11- Deletar Pagamento.");
            System.out.println("12- Sair.");
            System.out.print("Digite uma opção: ");

            try {
                optNumberSubMenuDeletar = scan.nextInt();
                System.out.println("----------------------------------------------------------");
                flag = true;

            } catch (InputMismatchException entreComInt) {
                System.out.println("ERRO! Entre com um número inteiro.");

            } catch (Exception e) {
                System.out.println("Ocoreu um erro: " + e.getMessage());

            } finally {
                scan.nextLine();
            }

        } while ((optNumberSubMenuDeletar < 1 || optNumberSubMenuDeletar > 12) || !flag);
        return optNumberSubMenuDeletar;
    }

    public static int SubmenuEditar() {
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        int optNumberSubMenuEditar = 0;

        do {

            System.out.println("-----------Menu de Editar Cadastro-----------");
            System.out.println("1 - Editar Pessoa.");
            System.out.println("2 - Editar Fornecedor.");
            System.out.println("3 - Editar Produto.");
            System.out.println("4 - Editar Tipo Cardapio.");
            System.out.println("5 - Editar Tipo Restaurante.");
            System.out.println("6 - Editar Cardapio.");
            System.out.println("7 - Editar Mesa.");
            System.out.println("8 - Sair.");
            System.out.print("Digite uma opção: ");

            try {
                optNumberSubMenuEditar = scan.nextInt();
                System.out.println("----------------------------------------------------------");
                flag = true;

            } catch (InputMismatchException entreComInt) {
                System.out.println("ERRO! Entre com um número inteiro.");

            } catch (Exception e) {
                System.out.println("Ocoreu um erro: " + e.getMessage());

            } finally {
                scan.nextLine();
            }

        } while ((optNumberSubMenuEditar < 1 || optNumberSubMenuEditar > 8) || !flag);
        return optNumberSubMenuEditar;
    }

    public static int SubmenuListar() {
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        int optNumberSubMenuListar = 0;

        do {

            System.out.println("-----------Menu de Listar-----------");
            System.out.println("1 - Listar Cliente.");
            System.out.println("2 - Listar Empregado.");
            System.out.println("3 - Listar Fornecedor.");
            System.out.println("4 - Listar Produto.");
            System.out.println("5 - Listar Compra Produto.");
            System.out.println("6 - Listar Tipo Cardapio.");
            System.out.println("7 - Listar Tipo Restaurante.");
            System.out.println("8 - Listar Cardapio.");
            System.out.println("9 - Listar Mesa.");
            System.out.println("10- Listar Pagamento.");
            System.out.println("11- Listar Reserva.");
            System.out.println("12- Listar Pedido.");
            System.out.println("13- Listar Fila Pedido.");
            System.out.println("14- Sair.");
            System.out.print("Digite uma opção: ");

            try {
                optNumberSubMenuListar = scan.nextInt();
                System.out.println("----------------------------------------------------------");
                flag = true;

            } catch (InputMismatchException entreComInt) {
                System.out.println("ERRO! Entre com um número inteiro.");

            } catch (Exception e) {
                System.out.println("Ocoreu um erro: " + e.getMessage());

            } finally {
                scan.nextLine();
            }

        } while ((optNumberSubMenuListar < 1 || optNumberSubMenuListar > 14) || !flag);
        return optNumberSubMenuListar;
    }

}
