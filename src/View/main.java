package View;

import ControllerBean.CardapioBean;
import ControllerBean.TipoCardapioBean;
import ControllerBean.TipoRestauranteBean;
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

    public static void main(String[] args) {
        int opMenuPrincipal;

        do {
            opMenuPrincipal = menuInicial();

            switch (opMenuPrincipal) {
                case 1:

                    break;
                case 2:
                    
                    break;
            }
        } while (opMenuPrincipal != 19);

        String tipo = "thiago";

        TipoRestauranteBean teste = new TipoRestauranteBean(tipo);

        
        String resul = teste.CadastroTipoRestaurante();
        String tipo2 = "amorim";
        TipoRestauranteBean teste2 = new TipoRestauranteBean(tipo2);
      
        teste2.CadastroTipoRestaurante();

        String tipo4 = "Bebidas";
        TipoCardapioBean cardapioBean = new TipoCardapioBean(tipo4);
        cardapioBean.CadastroTipoCardapio();
        
        
        String nome = "Coca cola";
        
        double valor = 5.10;
        
        
        CardapioBean cardapio = new CardapioBean(1, 1, nome, valor);
        cardapio.CadastroCardapio();
        
        System.out.println("Resultado " + resul);

    }
}
