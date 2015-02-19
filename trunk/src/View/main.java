package View;

import Controller.Buffer;
import Controller.CalcTotal;
import Controller.Consumidor;
import Controller.CreateTipoCardapio;
import Controller.CreateTipoRestaurante;
import Controller.Item;
import Controller.Menu;
import Controller.Produto;
import Controller.Produtor;
import Controller.Sincronizador;
import Controller.TipoCardapio;
import Controller.TipoRestaurante;
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
import Model.TbCardapio;
import Model.TbEmpregado;
import Model.TbFornecedor;
import Model.TbMateriaPrima;
import Model.TbMesa;
import Model.TbPedido;
import Model.TbPessoa;
import Model.TbTipoCardapio;
import Model.TbTipoRestaurante;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {

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
        int optNumberSubMenuListar;

        do {
            opMenuPrincipal = Menu.menuInicial();

            switch (opMenuPrincipal) {

                case 1:

                    int pessoa = 0;
                    do {
                        optNumberSubMenu = Menu.Submenu();

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
                                            ArrayList lista = mesaBean.ListarMesa();
                                            if (lista.isEmpty()) {
                                                System.out.println("Todas as Mesas estão Ocupadas");
                                                break;
                                            }
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
                                        TipoCardapio cardapio = CreateTipoCardapio.novoTipoCardapio();
                                        String n = cardapio.getDescricao();
                                        TipoCardapioBean tipoCardapioBean;
                                        tipoCardapioBean = new TipoCardapioBean(n);
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
                                        TipoRestaurante restaurante = CreateTipoRestaurante.novoRestaurante();
                                        String n = restaurante.getDescricao();
                                        TipoRestauranteBean tipoRestauranteBean;
                                        tipoRestauranteBean = new TipoRestauranteBean(n);
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
                                double v = 0.0;
                                ArrayList<Integer> array_id_itens = new ArrayList<Integer>();
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

                                        System.out.println("------------------Listando Garçons------------------");
                                        EmpregadoBean empregadoBean = new EmpregadoBean();
                                        empregadoBean.verGarcons();

                                        System.out.println("Digite o codigo do garçom: ");
                                        int empregado = var.nextInt();
                                        var.nextLine();

                                        System.out.println("Digite a quantidade de Itens: ");
                                        int itens = var.nextInt();
                                        var.nextLine();

                                        System.out.println("------------------Listando o Cardapio------------------");
                                        cardapioBean = new CardapioBean();
                                        cardapioBean.ListarCardapio();

                                        for (int i = 0; i < itens; i++) {
                                            System.out.println("Digite o codigo do cardapio: ");
                                            int cardapio = var.nextInt();
                                            var.nextLine();

                                            //DECORATOR
                                            Integer a = new Integer(cardapio);
                                            array_id_itens.add(a); //salvando os itens escolhidos
                                            v = cardapioBean.verValor(cardapio);
                                            TbPedido pedido = pedidoBean.getPedido();
                                            pedido = new Item(pedidoBean.getPedido(), v);
                                            pedidoBean.setPedido(pedido);

                                            System.out.println("Digite uma obs para o Pedido: ");
                                            String obs = var.nextLine();
                                        }
                                      
                                        v = pedidoBean.getPedido().coust();
                                        pedidoBean.getPedido().setVlTotalConsumo(v);
                                        pedidoBean.CadastroPedido();// salva o pedido no banco
                               
                                        for (int i = 0; i < array_id_itens.size(); i++) {
                                            PedidoCardapioBean pedidoCardapioBean = new PedidoCardapioBean(array_id_itens.get(i), pedidoBean.listaUltimo());
                                            pedidoCardapioBean.CadastroPedidoCardapio();
                                            FilaPedidoBean filaPedidoBean = new FilaPedidoBean(pedidoCardapioBean.listaUltimo(), empregado, "FAZER");
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

                                      
                                        //ATUALIZANDO O STATUS DA MESA
                                        int mesa = clienteBean.mesadoCliente(cliente);
                                        MesaBean mesabean = new MesaBean();
                                        mesabean.AtualizarMesa(false, mesa);

                                        //MOSTRANDO O TOTAL A PAGAR
                                        PedidoBean pedidobean = new PedidoBean();
                                        double totalmesa = pedidobean.totaldaMesa(mesa);
                                        System.out.printf("Valor total a pagar:R$ %.2f ",totalmesa);                                         

                                        Date dt = new Date(System.currentTimeMillis());

                                        double valorTotal = pagamentoBean.ValorTotalPagar(cliente);
                                        boolean pago = true;
                                        pagamentoBean = new PagamentoBean(cliente, dt, valorTotal, pago);
                                        pagamentoBean.CadastroPagamento();

                                        int aux = pagamentoBean.MostrarMesa(cliente);

                                        PedidoBean pedidoBean = new PedidoBean();
                                        pedidoBean.AtualizarPago(pago, aux);
                                        System.out.printf("Mesa %d fechada.\n", mesa); 
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
                        optNumberSubMenuDeletar = Menu.SubmenuDeletar();

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
                        optNumberSubMenuEditar = Menu.SubmenuEditar();

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
                                            System.out.println("Digite a função: ");
                                            String funcao = var.nextLine();

                                            TbPessoa tbPessoa = new TbPessoa(nome, telefone, celular, sexo, email);

                                            TbEmpregado tbEmpregado = new TbEmpregado(funcao);

                                            empregadoBean.AtualizarPessoa(tbPessoa, tbEmpregado, empregado);

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
                                System.out.println("------------------Editar Fornecedor------------------");

                                do {
                                    flag = true;
                                    try {

                                        System.out.println("------------------Listando Fonecedores------------------");
                                        FornecedorBean fornecedorBean = new FornecedorBean();
                                        fornecedorBean.ListarTodosFornecedor();

                                        System.out.println("Digite o codigo do fornecedor: ");
                                        int fornecedor = var.nextInt();
                                        var.nextLine();

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

                                        TbFornecedor tbFornecedor = new TbFornecedor(fornecedor, nome, celular, telefone, email, obs);
                                        fornecedorBean.AtualizarFornecedor(tbFornecedor, fornecedor);

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;
                            case 3:
                                System.out.println("------------------Editar Produto------------------");

                                do {
                                    flag = true;
                                    try {

                                        System.out.println("------------------Listando Produtos------------------");
                                        MateriaPrimaBean materiaPrimaBean = new MateriaPrimaBean();
                                        materiaPrimaBean.ListarTodosProduto();

                                        System.out.println("Digite o codigo do produto: ");
                                        int produto = var.nextInt();
                                        var.nextLine();
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

                                        TbMateriaPrima tbProduto = new TbMateriaPrima(nome, estoque, valor, obs);
                                        materiaPrimaBean.AtualizarMateriaPrima(tbProduto, produto);

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;
                            case 4:
                                System.out.println("------------------Editar Tipo Cardapio------------------");

                                do {
                                    flag = true;
                                    try {

                                        System.out.println("------------------Listando Tipo Cardapio------------------");
                                        TipoCardapioBean tipoCardapioBean = new TipoCardapioBean();
                                        tipoCardapioBean.ListarTipoCardapio();

                                        System.out.println("Digite o codigo do Tipo Cardapio: ");
                                        int tipo_cardapio = var.nextInt();
                                        var.nextLine();

                                        System.out.println("Digite o Tipo Cardapio: ");
                                        nome = var.nextLine();

                                        TbTipoCardapio cardapio = new TbTipoCardapio(nome);
                                        tipoCardapioBean.AtualizarTipoCardapio(cardapio, tipo_cardapio);

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;
                            case 5:
                                System.out.println("------------------Editar Tipo Restaurante------------------");

                                do {
                                    flag = true;
                                    try {

                                        System.out.println("------------------Listando Tipos Restaurantes------------------");
                                        TipoRestauranteBean tipoRestauranteBean = new TipoRestauranteBean();
                                        tipoRestauranteBean.ListarTipoRestaurante();

                                        System.out.println("Digite o codigo do Restaurante: ");
                                        int restaurante = var.nextInt();
                                        var.nextLine();

                                        System.out.println("Digite o Tipo Restaurante: ");
                                        nome = var.nextLine();

                                        TbTipoRestaurante tbTipoRestaurante = new TbTipoRestaurante(nome);
                                        tipoRestauranteBean.AtualizarTipoRestaurante(tbTipoRestaurante, restaurante);

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);
                                break;
                            case 6:
                                System.out.println("------------------Editar Cardapio------------------");

                                do {
                                    flag = true;
                                    try {

                                        System.out.println("------------------Listando o Cardapio------------------");
                                        CardapioBean cardapioBean = new CardapioBean();
                                        cardapioBean.ListarCardapio();

                                        System.out.println("Digite o codigo do cardapio: ");
                                        int cardapio = var.nextInt();
                                        var.nextLine();

                                        System.out.println("Digite o nome Item: ");
                                        nome = var.nextLine();

                                        System.out.println("Digite o valor Item: ");
                                        double valor = var.nextDouble();
                                        var.nextLine();

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

                                        TbCardapio tbCardapio = new TbCardapio(nome, valor, tipo_cardapio, restaurante);

                                        cardapioBean.AtualizarCardapio(tbCardapio, cardapio);

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;
                            case 7:
                                System.out.println("------------------Editar Mesa------------------");

                                do {
                                    flag = true;
                                    try {

                                        System.out.println("------------------Listando Mesas------------------");
                                        MesaBean mesaBean = new MesaBean();
                                        mesaBean.ListarTodasMesaClientes();

                                        System.out.println("Digite o codigo da mesa: ");
                                        int mesa = var.nextInt();
                                        var.nextLine();

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

                                        TbMesa tTbMesa = new TbMesa(qtd, situacao, obs, nome);

                                        mesaBean.AtualizarMesa(tTbMesa, mesa);

                                    } catch (Exception e) {
                                        System.out.println("Ocoreu um erro digite Novamente! ");
                                        flag = false;
                                        var.nextLine();
                                    } finally {

                                    }
                                } while (!flag);

                                break;

                        }

                    } while (optNumberSubMenuEditar != 8);
                    break;

                case 4:
                    do {
                        optNumberSubMenuListar = Menu.SubmenuListar();

                        switch (optNumberSubMenuListar) {
                            case 1:

                                System.out.println("------------------Listando Clientes------------------");
                                ClienteBean clienteBean = new ClienteBean();
                                clienteBean.ListarTudoCliente();

                                break;
                            case 2:
                                System.out.println("------------------Listando Empregados------------------");
                                EmpregadoBean empregadoBean = new EmpregadoBean();
                                empregadoBean.ListarTudoEmpregado();

                                break;
                            case 3:
                                System.out.println("------------------Listando Fornecedores------------------");
                                FornecedorBean fornecedorBean = new FornecedorBean();
                                fornecedorBean.ListarTodosFornecedor();

                                break;
                            case 4:

                                System.out.println("------------------Listando Produtos------------------");
                                MateriaPrimaBean materiaPrimaBean = new MateriaPrimaBean();
                                materiaPrimaBean.ListarTodosProduto();

                                break;
                            case 5:

                                System.out.println("------------------Listando Compras de Produtos------------------");
                                CompraProdutoBean compraProdutoBean = new CompraProdutoBean();
                                compraProdutoBean.ListarCompraProduto();

                                break;
                            case 6:

                                System.out.println("------------------Listando Tipos Cardapio------------------");
                                TipoCardapioBean tipoCardapioBean = new TipoCardapioBean();
                                tipoCardapioBean.ListarTipoCardapio();

                                break;
                            case 7:

                                System.out.println("------------------Listando Tipos Restaurantes------------------");
                                TipoRestauranteBean tipoRestauranteBean = new TipoRestauranteBean();
                                tipoRestauranteBean.ListarTipoRestaurante();

                                break;
                            case 8:

                                System.out.println("------------------Listando o Cardapio------------------");
                                CardapioBean cardapioBean = new CardapioBean();
                                cardapioBean.ListarCardapio();

                                break;
                            case 9:
                                System.out.println("------------------Listando Mesas------------------");
                                MesaBean mesaBean = new MesaBean();
                                mesaBean.ListarTodasMesa();

                                break;
                            case 10:

                                System.out.println("------------------Listando Pagamentos------------------");
                                PagamentoBean pagamentoBean = new PagamentoBean();
                                pagamentoBean.ListarPagamentos();

                                break;
                            case 11:

                                System.out.println("------------------Listando Reserva------------------");
                                ReservaBean reservaBean = new ReservaBean();
                                reservaBean.ListarReservas();

                                break;
                            case 12:

                                System.out.println("------------------Listando Pedidos------------------");
                                PedidoBean pedidoBean = new PedidoBean();
                                pedidoBean.ListarPedidos();

                                break;
                            case 13:

                                System.out.println("------------------Listando Fila Pedidos------------------");
                                FilaPedidoBean filaPedidoBean = new FilaPedidoBean();
                                filaPedidoBean.ListarFIlaPedidos();

                                break;
                        }

                    } while (optNumberSubMenuListar != 14);
                    break;

                case 5:
                    System.out.println("------------------Produzir os pedidos------------------");
                    ClienteBean clientebean = new ClienteBean();
                    ArrayList<Integer> array_clientes = clientebean.verclientesAtender();
                    EmpregadoBean empregadobean = new EmpregadoBean();
                    ArrayList<Integer> array_cozinheiros = empregadobean.vercozinheiros();

                    if (array_clientes.isEmpty() || array_cozinheiros.isEmpty()) {
                        System.out.println("Não ha cozinheiros ou itens para fazer.");
                    } else {
                        int total = array_clientes.size() + array_cozinheiros.size();
                        ExecutorService executor = Executors.newFixedThreadPool(total);
                        Buffer buffer = new Sincronizador();

                        System.out.printf("Inicializando as threads\n");
                        FilaPedidoBean fila = new FilaPedidoBean();
                        ArrayList<Produto> produtos = new ArrayList<Produto>();
                        produtos = fila.PedidosaAtender();
                        for (int i = 0; i < produtos.size(); i++) {
                            fila.atualizaStatus(produtos.get(i).getId_pedido()); //mudando o status no banco
                        }
                        try {
                            for (int i = 0; i < array_cozinheiros.size(); i++) {
                                executor.execute(new Produtor(buffer, array_cozinheiros.get(i)));

                            }
                            for (int i = 0; i < array_clientes.size(); i++) {
                                executor.execute(new Consumidor(buffer, array_clientes.get(i)));

                            }
                        } catch (Exception e) {
                            e.printStackTrace();

                        } finally {

                            executor.shutdown();
                            var.nextLine();
                        }

                    }

                    break;

            
                case 6:
                    System.out.println("------------------Mostrar itens com estoque baixo------------------");
                    do {
                        flag = true;
                        try {
                            System.out.println("Digite a quantidade mínina em estoque");
                            int quantidade = var.nextInt();
                            var.nextLine();
                            MateriaPrimaBean materia = new MateriaPrimaBean();
                            materia.mostrarEstoquebaixo(quantidade);
                        } catch (Exception e) {
                            System.out.println("Ocoreu um erro digite Novamente! ");
                            flag = false;
                            var.nextLine();
                        } finally {

                        }
                    } while (!flag);
                    break;
            
                case 7:
                    System.out.println("------------------Atualizar Estoque (fazer baixa)------------------");
                    MateriaPrimaBean materia = new MateriaPrimaBean();
                    materia.ListarTodosProduto();
                    do {
                        flag = true;
                        try {
                            System.out.println("Digite a quantidade de itens que deseja atualizar:");
                            int quantidade = var.nextInt();
                            var.nextLine();
                            for (int i = 0; i < quantidade; i++) {
                                System.out.println("Digite o codigo do item:");
                                int codigo = var.nextInt();
                                var.nextLine();
                                System.out.println("Digite a quantidade que deseja abater:");
                                int abater = var.nextInt();
                                var.nextLine();
                                materia.abaterestoque(codigo, abater);
                            }
                        } catch (Exception e) {
                            System.out.println("Ocoreu um erro digite Novamente! ");
                            flag = false;
                            var.nextLine();
                        } finally {

                        }

                    } while (!flag);
                    break;

               
                case 8:
                    System.out.println("------------------Fechar caixa------------------");
                    do {
                        flag = true;
                        try {
                            System.out.println("Digite a Data de Inicio: ");
                            String datai = var.nextLine();
                            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                            Date dt = df.parse(datai);

                            System.out.println("Digite a Data de Termino: ");
                            String datat = var.nextLine();
                            DateFormat dg = new SimpleDateFormat("dd/MM/yyyy");
                            Date dr = dg.parse(datat);

                            PagamentoBean pagamento = new PagamentoBean();
                            ArrayList array = pagamento.fechar(datai, datat);
                            double total = CalcTotal.calcularTotal(array);
                            System.out.println("Total - R$" + total);

                        } catch (Exception e) {
                            System.out.println("Ocoreu um erro digite Novamente! ");
                            flag = false;
                            var.nextLine();
                        } finally {

                        }

                    } while (!flag);
                    break;

            }
        } while (opMenuPrincipal
                != 9);

    }
}
