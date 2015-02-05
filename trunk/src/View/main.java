package View;

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
            System.out.println("1 - Carregar arquivos com base de dados.");
            System.out.println("2 - Verificar status do aluno.");
            System.out.println("3 - Calcular salário do funcionário.");
            System.out.println("4- Cadastrar Funcionários.");
            System.out.println("5- Cadastrar Alunos.");
            System.out.println("6- Cadastrar Treinos.");
            System.out.println("7- Cadastrar Atividades.");
            System.out.println("8- Cadastrar Aparelhos.");
            System.out.println("9- Cadastrar Promoções.");
            System.out.println("10- Dar Promoção.");
            System.out.println("11- Realizar Manutenção.");
            System.out.println("12- Finalizar Manutenção.");
            System.out.println("13- Verificar situação do Aparelho.");
            System.out.println("14- Entrar com horas extras do Instrutor.");
            System.out.println("15- Pagar Mensalidade.");
            System.out.println("16- Excluir Dados.");
            System.out.println("17- Salvar dados da memória em arquivos.");
            System.out.println("18- Imprime dados da memória.");
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

        // teste.CadastroTipoRestauranteDados(tipo);
        String resul = teste.CadastroTipoRestaurante();
        String tipo2 = "amorim";
        TipoRestauranteBean teste2 = new TipoRestauranteBean(tipo2);
        // teste.CadastroTipoRestauranteDados(tipo2);
        teste2.CadastroTipoRestaurante();

        String tipo4 = "Bebidas";
        TipoCardapioBean cardapioBean = new TipoCardapioBean(tipo4);
        cardapioBean.CadastroTipoCardapio();
        
        System.out.println("Resultado " + resul);

    }
}
