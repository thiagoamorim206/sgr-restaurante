package View;

import ControllerBean.CardapioBean;
import ControllerBean.ClienteBean;
import ControllerBean.CompraProdutoBean;
import ControllerBean.EmpregadoBean;
import ControllerBean.FilaPedidoBean;
import ControllerBean.FornecedorBean;
import ControllerBean.MateriaPrimaBean;
import ControllerBean.MesaBean;
import ControllerBean.PagamentoBean;
import ControllerBean.PedidoBean;
import ControllerBean.PedidoCardapioBean;
import ControllerBean.PessoaBean;
import ControllerBean.ReservaBean;
import ControllerBean.TipoCardapioBean;
import ControllerBean.TipoRestauranteBean;
import Model.TbPessoa;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            System.out.println("1 - Cadastrar Dados.");
            System.out.println("2 - Deletar Dados.");
            System.out.println("3 - Editar Dados.");
            System.out.println("4 - Listar Dados.");

            System.out.println("3 - Verificar Reserva.");
            System.out.println("14- Fechar Mesa.");
            System.out.println("15- Mostrar Mesas Reservadas.");
            System.out.println("16- Mostrar Cardapio.");
            System.out.println("17- Mostrar Fila Pedidos.");
            System.out.println("18- Fechar pedido.");
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

    private static int SubmenuDeletar() {
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

    private static int SubmenuEditar() {
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        int optNumberSubMenuEditar = 0;

        do {

            System.out.println("-----------Menu de Editar Cadastro-----------");
            System.out.println("1 - Editar Pessoa.");
            System.out.println("2 - Editar Fornecedor.");
            System.out.println("3 - Editar Produto.");
            System.out.println("4 - Editar Compra Produto.");
            System.out.println("5 - Editar Tipo Cardapio.");
            System.out.println("6 - Editar Tipo Restaurante.");
            System.out.println("7 - Editar Cardapio.");
            System.out.println("8 - Editar Mesa.");
            System.out.println("9- Sair.");
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

        } while ((optNumberSubMenuEditar < 1 || optNumberSubMenuEditar > 9) || !flag);
        return optNumberSubMenuEditar;
    }

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

        int opMenuPrincipal;
        int optNumberSubMenu;
        Scanner var = new Scanner(System.in);
        String nome, sexo, telefone, celular, email;
        boolean flag;
        int op = 0, tipo = 0;
        boolean situacao;
        int optNumberSubMenuDeletar;
        int optNumberSubMenuEditar;

        do {
            opMenuPrincipal = menuInicial();

            switch (opMenuPrincipal) {

                case 1:

                    int pessoa = 0;
                    do {
                        optNumberSubMenu = Submenu();

                        switch (optNumberSubMenu) {
                            case 1:
                                System.out.println("------------------Cadastrar Pessoa------------------");

                                do {
                                    flag = true;
                                    try {
                                        System.out.println("1-Cliente\n2-Empregado");
                                        pessoa = var.nextInt();

                                    } catch (InputMismatchException entreComInt) {
                                        System.out.println("ERRO! Entre com um número inteiro.");
                                        flag = false;
                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                    } finally {
                                        var.nextLine();
                                    }
                                } while (pessoa < 1 || pessoa > 2 || !flag);

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

                                        if (pessoa == 1) {
                                            MesaBean mesaBean = new MesaBean();
                                            mesaBean.ListarMesa();

                                            System.out.println("Digite o codigo da mesa: ");
                                            int mesa = var.nextInt();

                                            ClienteBean clienteBean = new ClienteBean(mesa, pessoaBean.listaUltimo());
                                            clienteBean.CadastroCliente();

                                            boolean x = true;
                                            mesaBean.AtualizarMesa(x, mesa);

                                        } else if (pessoa == 2) {
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
                                do {
                                    flag = true;
                                    try {
                                        System.out.println("------------------Listando Empregados------------------");
                                        EmpregadoBean empregadoBean = new EmpregadoBean();
                                        empregadoBean.ListarEmpregado();

                                        System.out.println("Digite o codigo do empregado: ");
                                        int empregado = var.nextInt();
                                        var.nextLine();

                                        System.out.println("------------------Listando Fornecedores------------------");
                                        FornecedorBean fornecedorBean = new FornecedorBean();
                                        fornecedorBean.ListarFornecedor();

                                        System.out.println("Digite o codigo do fornecedor: ");
                                        int fornecedor = var.nextInt();
                                        var.nextLine();

                                        System.out.println("------------------Listando Produtos------------------");
                                        MateriaPrimaBean materiaPrimaBean = new MateriaPrimaBean();
                                        materiaPrimaBean.ListarProduto();

                                        System.out.println("Digite o codigo do produto: ");
                                        int produto = var.nextInt();
                                        var.nextLine();

                                        System.out.println("Digite a Data da Compra: ");
                                        String dataRecebida = var.nextLine();
                                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                        Date dt = df.parse(dataRecebida);

                                        System.out.println("Digite a quantidade comprada: ");
                                        int qtd = var.nextInt();
                                        var.nextLine();

                                        System.out.println("Digite um Observação: ");
                                        String obs = var.nextLine();

                                        CompraProdutoBean compraProdutoBean;
                                        compraProdutoBean = new CompraProdutoBean(empregado, fornecedor, produto, dt, qtd, obs);
                                        compraProdutoBean.CadastroCompraProduto();
                                        materiaPrimaBean.AtualizarEstoque(qtd, produto);

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;

                            case 5:
                                System.out.println("------------------Cadastrar Tipo Cardapio------------------");

                                do {
                                    flag = true;
                                    try {
                                        System.out.println("Digite o Tipo Cardapio: ");
                                        nome = var.nextLine();

                                        TipoCardapioBean tipoCardapioBean;
                                        tipoCardapioBean = new TipoCardapioBean(nome);
                                        tipoCardapioBean.CadastroTipoCardapio();

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;

                            case 6:
                                System.out.println("------------------Cadastrar Tipo Restaurante------------------");

                                do {
                                    flag = true;
                                    try {
                                        System.out.println("Digite o Tipo Restaurante: ");
                                        nome = var.nextLine();

                                        TipoRestauranteBean tipoRestauranteBean;
                                        tipoRestauranteBean = new TipoRestauranteBean(nome);
                                        tipoRestauranteBean.CadastroTipoRestaurante();

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;

                            case 7:
                                System.out.println("------------------Cadastrar Cardapio------------------");
                                System.out.println("------------------Listando Tipos Restaurantes------------------");

                                TipoRestauranteBean tipoRestauranteBean = new TipoRestauranteBean();
                                tipoRestauranteBean.ListarTipoRestaurante();

                                System.out.println("Digite o codigo do Restaurante: ");
                                int restaurante = var.nextInt();
                                var.nextLine();

                                System.out.println("------------------Listando Tipo Cardapio------------------");
                                TipoCardapioBean tipoCardapioBean = new TipoCardapioBean();
                                tipoCardapioBean.ListarTipoCardapio();

                                System.out.println("Digite o codigo do Tipo Cardapio: ");
                                int tipo_cardapio = var.nextInt();
                                var.nextLine();

                                System.out.println("Digite o nome Item: ");
                                nome = var.nextLine();

                                System.out.println("Digite o valor Item: ");
                                double valor = var.nextDouble();
                                var.nextLine();

                                CardapioBean cardapioBean = new CardapioBean(restaurante, tipo_cardapio, nome, valor);
                                cardapioBean.CadastroCardapio();
                                break;

                            case 8:
                                System.out.println("------------------Cadastrar Mesa------------------");

                                do {
                                    flag = true;
                                    try {
                                        System.out.println("Digite o nome Mesa: ");
                                        nome = var.nextLine();

                                        System.out.println("Digite a Quantidade de Lugares: ");
                                        int qtd = var.nextInt();
                                        var.nextLine();

                                        do {
                                            flag = true;
                                            try {
                                                System.out.println("1-Livre\n2-Ocupada");
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

                                        if (op == 1) {
                                            situacao = false;
                                        } else {
                                            situacao = true;
                                        }

                                        System.out.println("Digite um Observação: ");
                                        String obs = var.nextLine();

                                        MesaBean mesaBean;
                                        mesaBean = new MesaBean(qtd, situacao, obs, nome);
                                        mesaBean.CadastroMesa();

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;

                            case 9:
                                System.out.println("------------------Cadastrar Pedido------------------");

                                do {
                                    flag = true;
                                    try {
                                        System.out.println("------------------Listando Mesas------------------");
                                        MesaBean mesaBean = new MesaBean();
                                        mesaBean.ListarTodasMesaClientes();

                                        System.out.println("Digite o codigo da mesa: ");
                                        int mesa = var.nextInt();
                                        var.nextLine();

                                        Date dt = new Date(System.currentTimeMillis());

                                        situacao = false;

                                        PedidoBean pedidoBean;
                                        pedidoBean = new PedidoBean(mesa, dt, 0, situacao);
                                        pedidoBean.CadastroPedido();

                                        System.out.println("------------------Listando Empregados------------------");
                                        EmpregadoBean empregadoBean = new EmpregadoBean();
                                        empregadoBean.ListarEmpregadoFuncao();

                                        System.out.println("Digite o codigo do empregado: ");
                                        int empregado = var.nextInt();
                                        var.nextLine();

                                        System.out.println("------------------Listando o Cardapio------------------");
                                        cardapioBean = new CardapioBean();
                                        cardapioBean.ListarCardapio();

                                        System.out.println("Digite a quantidade de Itens: ");
                                        int itens = var.nextInt();
                                        var.nextLine();

                                        for (int i = 0; i < itens; i++) {
                                            System.out.println("Digite o codigo do cardapio: ");
                                            int cardapio = var.nextInt();
                                            var.nextLine();

                                            PedidoCardapioBean pedidoCardapioBean = new PedidoCardapioBean(cardapio, pedidoBean.listaUltimo());
                                            pedidoCardapioBean.CadastroPedidoCardapio();

                                            System.out.println("Digite uma obs para o Pedido: ");
                                            String obs = var.nextLine();

                                            FilaPedidoBean filaPedidoBean = new FilaPedidoBean(pedidoCardapioBean.listaUltimo(), empregado, obs);
                                            filaPedidoBean.CadastroFilaPedido();

                                        }

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;
                            case 10:
                                System.out.println("------------------Cadastrar Reserva------------------");

                                do {
                                    flag = true;
                                    try {
                                        System.out.println("------------------Listando Empregados------------------");
                                        EmpregadoBean empregadoBean = new EmpregadoBean();

                                        empregadoBean.ListarEmpregadoFuncao();

                                        System.out.println("Digite o codigo do empregado: ");
                                        int empregado = var.nextInt();
                                        var.nextLine();

                                        System.out.println("------------------Listando Mesas------------------");
                                        MesaBean mesaBean = new MesaBean();
                                        mesaBean.ListarTodasMesaClientes();

                                        System.out.println("Digite o codigo da mesa: ");
                                        int mesa = var.nextInt();
                                        var.nextLine();

                                        System.out.println("Digite o nome da Reserva: ");
                                        String nomeReserva = var.nextLine();

                                        System.out.println("Digite a Data da Reserva: ");
                                        String dataRecebida = var.nextLine();
                                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                        Date dt = df.parse(dataRecebida);

                                        System.out.println("Digite Situação da Reserva: ");
                                        String situacaoReserva = var.nextLine();

                                        System.out.println("Digite a quantidade de Lugares: ");
                                        int QtdLugar = var.nextInt();
                                        var.nextLine();

                                        ReservaBean reservaBean;
                                        reservaBean = new ReservaBean(empregado, mesa, nomeReserva, dt, situacaoReserva, QtdLugar);
                                        reservaBean.CadastroReserva();
                                        boolean x = true;
                                        mesaBean.AtualizarMesa(x, mesa);

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;

                            case 11:
                                System.out.println("------------------Cadastrar Pagamento------------------");
                                do {
                                    flag = true;
                                    try {
                                        System.out.println("------------------Listando Clientes------------------");
                                        ClienteBean clienteBean = new ClienteBean();
                                        PagamentoBean pagamentoBean = new PagamentoBean();
                                        clienteBean.ListarClientePagar();

                                        System.out.println("Digite o codigo do cliente: ");
                                        int cliente = var.nextInt();
                                        var.nextLine();

                                        Date dt = new Date(System.currentTimeMillis());

                                        double valorTotal = pagamentoBean.ValorTotalPagar(cliente);
                                        boolean pago = true;
                                        pagamentoBean = new PagamentoBean(cliente, dt, valorTotal, pago);
                                        pagamentoBean.CadastroPagamento();

                                        int aux = pagamentoBean.MostrarMesa(cliente);

                                        PedidoBean pedidoBean = new PedidoBean();
                                        pedidoBean.AtualizarPago(pago, aux);
                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);
                                break;

                        }
                    } while (optNumberSubMenu != 12);

                    break;
                case 2:

                    do {
                        optNumberSubMenuDeletar = SubmenuDeletar();

                        switch (optNumberSubMenuDeletar) {

                            case 1:
                                System.out.println("------------------Deletar Pessoa------------------");

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
                                        if (op == 1) {
                                            System.out.println("------------------Deletar Clientes------------------");
                                            System.out.println("------------------Listando Clientes------------------");
                                            ClienteBean clienteBean = new ClienteBean();
                                            clienteBean.ListarTodosClientes();

                                            System.out.println("Digite o codigo do cliente: ");
                                            int cliente = var.nextInt();
                                            var.nextLine();

                                            clienteBean.DeletarCliente(cliente);
                                        } else if (op == 2) {
                                            System.out.println("------------------Deletar Empregados------------------");
                                            System.out.println("------------------Listando Empregados------------------");
                                            EmpregadoBean empregadoBean = new EmpregadoBean();

                                            empregadoBean.ListarEmpregadoFuncao();

                                            System.out.println("Digite o codigo do empregado: ");
                                            int empregado = var.nextInt();
                                            var.nextLine();
                                            empregadoBean.DeletarEmpregado(empregado);

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
                                System.out.println("------------------Deletar Fornecedor------------------");
                                System.out.println("------------------Listando Fornecedores------------------");
                                FornecedorBean fornecedorBean = new FornecedorBean();
                                fornecedorBean.ListarFornecedor();

                                do {
                                    flag = true;
                                    try {

                                        System.out.println("Digite o codigo do fornecedor: ");
                                        int fornecedor = var.nextInt();
                                        var.nextLine();

                                        fornecedorBean.DeletarFornecedor(fornecedor);

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;
                            case 3:
                                System.out.println("------------------Deletar Produto------------------");
                                System.out.println("------------------Listando Produtos------------------");
                                MateriaPrimaBean materiaPrimaBean = new MateriaPrimaBean();
                                materiaPrimaBean.ListarProduto();

                                do {
                                    flag = true;
                                    try {

                                        System.out.println("Digite o codigo do produto: ");
                                        int produto = var.nextInt();
                                        var.nextLine();

                                        materiaPrimaBean.DeletarProduto(produto);

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);
                                break;
                            case 4:

                                System.out.println("------------------Deletar Compra Produto------------------");
                                System.out.println("------------------Listando Compras de Produtos------------------");

                                CompraProdutoBean compraProdutoBean = new CompraProdutoBean();
                                compraProdutoBean.ListarCompraProduto();

                                do {
                                    flag = true;
                                    try {

                                        System.out.println("Digite o codigo da Compra Produto: ");
                                        int Compra = var.nextInt();
                                        var.nextLine();

                                        compraProdutoBean.DeletarProduto(Compra);

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;
                            case 5:
                                System.out.println("------------------Deletar Tipo Cardapio------------------");
                                System.out.println("------------------Listando Tipos Cardapio------------------");
                                TipoCardapioBean tipoCardapioBean = new TipoCardapioBean();

                                tipoCardapioBean.ListarTipoCardapio();

                                do {
                                    flag = true;
                                    try {

                                        System.out.println("Digite o codigo do Tipo Cardapio: ");
                                        int tipo_cardapio = var.nextInt();
                                        var.nextLine();

                                        tipoCardapioBean.DeletarTipoCardapio(tipo_cardapio);

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;
                            case 6:
                                System.out.println("------------------Deletar Tipo de Restaurante------------------");
                                System.out.println("------------------Listando Tipos Restaurantes------------------");

                                TipoRestauranteBean tipoRestauranteBean = new TipoRestauranteBean();
                                tipoRestauranteBean.ListarTipoRestaurante();

                                do {
                                    flag = true;
                                    try {

                                        System.out.println("Digite o codigo do Restaurante: ");
                                        int restaurante = var.nextInt();
                                        var.nextLine();

                                        tipoRestauranteBean.DeletarTipoRestaurante(restaurante);
                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);
                                break;

                            case 7:
                                System.out.println("------------------Deletar Cardapio------------------");
                                System.out.println("------------------Listando o Cardapio------------------");
                                CardapioBean cardapioBean = new CardapioBean();
                                cardapioBean.ListarCardapio();

                                do {
                                    flag = true;
                                    try {

                                        System.out.println("Digite o codigo do cardapio: ");
                                        int cardapio = var.nextInt();
                                        var.nextLine();

                                        cardapioBean.DeletarCardapio(cardapio);
                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;
                            case 8:
                                System.out.println("------------------Deletar Mesa------------------");
                                System.out.println("------------------Listando Mesas------------------");
                                MesaBean mesaBean = new MesaBean();
                                mesaBean.ListarTodasMesaClientes();

                                do {
                                    flag = true;
                                    try {

                                        System.out.println("Digite o codigo da mesa: ");
                                        int mesa = var.nextInt();
                                        var.nextLine();

                                        mesaBean.DeletarMesa(mesa);
                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;
                            case 9:
                                System.out.println("------------------Deletar Pedido------------------");
                                System.out.println("------------------Listando Pedidos------------------");
                                PedidoBean pedidoBean = new PedidoBean();
                                pedidoBean.ListarPedidos();

                                do {
                                    flag = true;
                                    try {

                                        System.out.println("Digite o codigo do Pedido: ");
                                        int pedido = var.nextInt();
                                        var.nextLine();
                                        pedidoBean.DeletarPedido(pedido);
                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;
                            case 10:
                                System.out.println("------------------Deletar Reserva------------------");
                                System.out.println("------------------Listando Reserva------------------");
                                ReservaBean reservaBean = new ReservaBean();
                                reservaBean.ListarReservas();

                                do {
                                    flag = true;
                                    try {

                                        System.out.println("Digite o codigo do Pedido: ");
                                        int reserva = var.nextInt();
                                        var.nextLine();
                                        reservaBean.DeletarReserva(reserva);

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;
                            case 11:
                                System.out.println("------------------Deletar Pagamento------------------");
                                System.out.println("------------------Listando Pagamentos------------------");
                                PagamentoBean pagamentoBean = new PagamentoBean();
                                pagamentoBean.ListarPagamentos();

                                do {
                                    flag = true;
                                    try {

                                        System.out.println("Digite o codigo do Pedido: ");
                                        int reserva = var.nextInt();
                                        var.nextLine();
                                        pagamentoBean.DeletarPagamento(reserva);

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;

                        }
                    } while (optNumberSubMenuDeletar != 12);

                    break;
                case 3:

                    do {
                        optNumberSubMenuEditar = SubmenuEditar();

                        switch (optNumberSubMenuEditar) {

                            case 1:
                                System.out.println("------------------Editar Pessoa------------------");

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
                                        if (op == 1) {
                                            System.out.println("------------------Editar Cliente------------------");
                                            System.out.println("------------------Listando Clientes------------------");
                                            ClienteBean clienteBean = new ClienteBean();
                                            clienteBean.ListarTudoCliente();

                                            System.out.println("Digite o codigo do cliente: ");
                                            int cliente = var.nextInt();
                                            var.nextLine();

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

                                            TbPessoa tbPessoa = new TbPessoa(nome, telefone, celular, sexo, email);
                                            clienteBean.AtualizarPessoa(tbPessoa, cliente);

                                        } else if (op == 2) {
                                            System.out.println("------------------Editar Cliente------------------");
                                            System.out.println("------------------Listando Empregados------------------");
                                            EmpregadoBean empregadoBean = new EmpregadoBean();
                                            empregadoBean.ListarEmpregadoFuncao();

                                            System.out.println("Digite o codigo do empregado: ");
                                            int empregado = var.nextInt();
                                            var.nextLine();

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

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case 5:

                                break;
                            case 6:

                                break;
                            case 7:

                                break;
                            case 8:

                                break;

                        }

                    } while (optNumberSubMenuEditar != 9);
                    break;

            }

        } while (opMenuPrincipal
                != 19);

    }
}
