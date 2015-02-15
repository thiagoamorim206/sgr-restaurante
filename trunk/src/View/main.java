package View;

import ControllerBean.ClienteBean;
import ControllerBean.EmpregadoBean;
import ControllerBean.FornecedorBean;
import ControllerBean.MateriaPrimaBean;
import ControllerBean.MesaBean;
import ControllerBean.PessoaBean;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    private static int menuInicial() {
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        int optNumberMenuPrincipal = 0;
        /**
         * Menu Principal do sistema
         */
        do {

            System.out.println("-----------Menu inicial Restaurante-----------");
            System.out.println("1 - Cadastrar.");
            System.out.println("13- Verificar Reserva.");
            System.out.println("14- Fechar Mesa.");
            System.out.println("15- Mostrar Mesas Reservadas.");
            System.out.println("16- Mostrar Cardapio.");
            System.out.println("17- Mostrar Fila Pedidos.");
            System.out.println("18- .");
            System.out.println("19- Sair.");
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

        } while ((optNumberMenuPrincipal < 1 || optNumberMenuPrincipal > 19) || !flag);
        return optNumberMenuPrincipal;
    }

    private static int Submenu() {
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
            System.out.println("6 - Cadastrar Tipo Cardapio.");
            System.out.println("7 - Cadastrar Tipo Restaurante.");
            System.out.println("8 - Cadastrar Cardapio.");
            System.out.println("9 - Cadastrar Pedido.");
            System.out.println("10- Cadastrar Pagamento.");
            System.out.println("11- Cadastrar Mesa.");
            System.out.println("12- Cadastrar Reserva.");
            System.out.println("13- Sair.");
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

        } while ((optNumberSubMenu < 1 || optNumberSubMenu > 13) || !flag);
        return optNumberSubMenu;
    }

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        int opMenuPrincipal;
        int optNumberSubMenu;
        Scanner var = new Scanner(System.in);
        String nome, sexo, telefone, celular, email;
        boolean flag;
        int op = 0, tipo = 0;

        do {
            opMenuPrincipal = menuInicial();

            switch (opMenuPrincipal) {
                case 1:
                    do {
                        optNumberSubMenu = Submenu();

                        switch (optNumberSubMenu) {
                            case 1:
                                System.out.println("------------------Cadastrar Pessoa------------------");

                                do {
                                    flag = true;
                                    try {
                                        System.out.println("1-Cliente\n2-Empregado");
                                        op = var.nextInt();

                                    } catch (InputMismatchException entreComInt) {
                                        System.out.println("ERRO! Entre com um número inteiro.");
                                        flag = false;
                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                    } finally {
                                        var.nextLine();
                                    }
                                } while (op < 1 || op > 2 || !flag);

                                do {
                                    flag = true;
                                    try {
                                        System.out.println("Digite o Nome: ");
                                        nome = var.nextLine();
                                        System.out.println("Digite o Sexo(M ou F): ");
                                        sexo = var.nextLine();
                                        System.out.println("Digite o Telefone: ");
                                        telefone = var.nextLine();
                                        System.out.println("Digite o Celular: ");
                                        celular = var.nextLine();
                                        System.out.println("Digite o Email: ");
                                        email = var.nextLine();

                                        PessoaBean pessoaBean = new PessoaBean(nome, telefone, celular, sexo, email);
                                        pessoaBean.CadastroPessoa();

                                        if (op == 1) {
                                            MesaBean mesaBean = new MesaBean();
                                            mesaBean.ListarMesa();
                                            System.out.println("Digite o codigo da mesa: ");
                                            int mesa = var.nextInt();

                                            ClienteBean clienteBean = new ClienteBean(mesa, pessoaBean.listaUltimo());
                                            clienteBean.CadastroCliente();
                                        } else if (op == 2) {
                                            System.out.println("Digite a funçao do Empregado: ");

                                            String funcao = var.nextLine();

                                            EmpregadoBean empregadoBean = new EmpregadoBean(pessoaBean.listaUltimo(), funcao);
                                            empregadoBean.CadastroEmpregado();

                                        }
                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);
                                break;

                            case 2:

                                System.out.println("------------------Cadastrar Fornecedor------------------");

                                do {
                                    flag = true;
                                    try {
                                        System.out.println("Digite o Nome: ");
                                        nome = var.nextLine();
                                        System.out.println("Digite o Telefone: ");
                                        telefone = var.nextLine();
                                        System.out.println("Digite o Celular: ");
                                        celular = var.nextLine();
                                        System.out.println("Digite o Email: ");
                                        email = var.nextLine();
                                        System.out.println("Digite um Observação: ");
                                        String obs = var.nextLine();

                                        FornecedorBean fornecedorBean = new FornecedorBean(nome, celular, telefone, email, obs);
                                        fornecedorBean.CadastroFornecedor();

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;

                            case 3:
                                System.out.println("------------------Cadastrar Produto------------------");

                                do {
                                    flag = true;
                                    try {
                                        System.out.println("Digite o Nome: ");
                                        nome = var.nextLine();
                                        System.out.println("Digite a Quantidade Estoque: ");
                                        int estoque = var.nextInt();
                                        var.nextLine();
                                        System.out.println("Digite o valor Produto: ");
                                        double valor = var.nextDouble();
                                        var.nextLine();
                                        System.out.println("Digite um Observação: ");
                                        String obs = var.nextLine();

                                        MateriaPrimaBean materiaPrimaBean;
                                        materiaPrimaBean = new MateriaPrimaBean(nome, estoque, valor, obs);
                                        materiaPrimaBean.CadastroMateriaPrima();

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);
                                break;

                            case 4:

                                System.out.println("------------------Cadastrar Compra do Produto------------------");

                                EmpregadoBean empregadoBean = new EmpregadoBean();
                                empregadoBean.ListarEmpregado();
                                System.out.println("------------------listando fornecedores------------------");
                                FornecedorBean fornecedorBean = new FornecedorBean();
                                fornecedorBean.ListarFornecedor();
                                
                                
                                break;

                        }
                    } while (optNumberSubMenu != 13);

                case 2:

                    break;

            }

        } while (opMenuPrincipal
                != 19);

    }
}
