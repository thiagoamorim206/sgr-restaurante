package View;

import ControllerBean.CardapioBean;
import ControllerBean.ClienteBean;
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

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        int opMenuPrincipal;
        Scanner var = new Scanner(System.in);
        String nome, sexo, telefone, celular, email;

        do {
            opMenuPrincipal = menuInicial();

            switch (opMenuPrincipal) {
                case 1:

                    Scanner scan = new Scanner(System.in);
                    boolean flag = false;
                    int optNumberSubMenu = 0;

                    do {

                        System.out.println("-----------Menu de Cadastro-----------");
                        System.out.println("1 - Cadastrar Cliente.");
                        System.out.println("2 - Cadastrar Empregado.");
                        System.out.println("3 - Cadastrar Fornecedor.");
                        System.out.println("4 - Cadastrar Produto.");
                        System.out.println("5 - Cadastrar Compra Produto.");
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

                    switch (optNumberSubMenu) {
                        case 1:
                            System.out.println("------------------Cadastrar Cliente------------------");

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

                                    MesaBean mesaBean = new MesaBean();
                                    mesaBean.ListarMesa();
                                    System.out.println("Digite o codigo da mesa: ");
                                    int mesa = var.nextInt();

                                    ClienteBean clienteBean = new ClienteBean(mesa, pessoaBean.listaUltimo());
                                    clienteBean.CadastroCliente();
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Ocoreu um erro digite Novamente! ");
                                    flag = false;
                                } finally {
                                    var.nextLine();

                                }
                            } while (!flag);
                            break;

                    }
                    while (optNumberSubMenu != 13);

                    break;

                case 2:

                    break;
            }
        } while (opMenuPrincipal != 19);

//        TipoRestauranteBean tipoRestauranteBean = new TipoRestauranteBean();
//        tipoRestauranteBean.ListarTipoRestaurante();
//        CardapioBean cardapioBean = new CardapioBean();
//        cardapioBean.ListarCardapio();
//
////        String tipo = "thiago";
////
//        TipoRestauranteBean teste = new TipoRestauranteBean(tipo);
//
//        
//        String resul = teste.CadastroTipoRestaurante();
//        String tipo2 = "amorim";
//        TipoRestauranteBean teste2 = new TipoRestauranteBean(tipo2);
//      
//        teste2.CadastroTipoRestaurante();
//
//        String tipo4 = "Bebidas";
//        TipoCardapioBean cardapioBean = new TipoCardapioBean(tipo4);
//        cardapioBean.CadastroTipoCardapio();
//        
//        
//        String nome = "Coca cola";
//        
//        double valor = 5.10;
//        
//        
//        CardapioBean cardapio = new CardapioBean(1, 1, nome, valor);
//        cardapio.CadastroCardapio();
//        
//        System.out.println("Resultado " + resul);
    }
}
