package Controller;

/**
 *
 * @author Adriano
 */
import ControllerBean.FilaPedidoBean;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Sincronizador implements Buffer {

    private Lock accessLock = new ReentrantLock();
    private Condition cozinhar = accessLock.newCondition();
    private Condition comer = accessLock.newCondition();

    private ArrayList<Produto> produtos;
    private ArrayList<Produto> feitos;
    private int count = 1;
    private FilaPedidoBean fila;

    public Sincronizador() {
        produtos = new ArrayList<Produto>();
        feitos = new ArrayList<Produto>();
        fila = new FilaPedidoBean();
        produtos = fila.PedidosaAtender();
    }

    public int getQuantidade() {
        return produtos.size();
    }

    public void cozinhar(int id) {
        accessLock.lock(); //bloqueando a mesa    
        int x = 0, contador = 0;
        boolean teste = false;
        try {
            while (teste) {
                cozinhar.await();
            }
            for (int i = 0; i < produtos.size(); i++) {
                if (produtos.get(i).getStatus().equals("FAZER")) {
                    x = i;
                    break;
                }
            }
            for (int i = 0; i < produtos.size(); i++) {
                if (produtos.get(i).getStatus().equals("FEITO")) {
                    contador++;
                }
            }
            if (contador < produtos.size()) {
                produtos.get(x).setStatus("FEITO");
                feitos.add(produtos.get(x));
                System.out.printf("O cozinheiro[%d], produziu o item %d\n", id, produtos.get(x).getId_pedido());
                produtos.remove(x);
                teste = true;
                comer.signalAll();//libera se alguem estiver esperando para comer 
            } else {
                comer.signalAll();//libera se alguem estiver esperando para comer 
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            accessLock.unlock(); //libera a mesa
        }
    }

    public void comer(int id) {
        accessLock.lock(); //bloqueia a mesa    
        int x = 0, contador = 0;
        boolean teste = false;
        try {
            do{
            for (int i = 0; i < feitos.size(); i++) {
                if (feitos.get(i).getId_cliente() == id) {
                    x = i;
                    teste=true;
                }
            }
            if (!produtos.isEmpty() && !teste) { // se não tiver itens feitos
                System.out.printf("Cliente[%d] aguardando\n", id);
                comer.await(); //bloqueia alguem comer
            }
            for (int i = 0; i < feitos.size(); i++) {
                if (feitos.get(i).getId_cliente() == id) {
                    x = i;
                    teste=true;
                }
            }
            }while(!teste && !produtos.isEmpty());
            if(teste){
            feitos.get(x).setStatus("CONSUMIDO");            
            System.out.printf("O Cliente[%d] consumiu o item[%d]\n", id, feitos.get(x).getId_pedido());
            feitos.remove(x);
            cozinhar.signalAll();//libera a producao de mais itens 
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            accessLock.unlock(); //libera  a mesa
        }
    }

}
