package Controller;

public class Consumidor implements Runnable {

    private Buffer buffer;
    private int id, quantidade;

    public Consumidor(Buffer b, int id) {
        this.buffer = b;
        this.id = id;
    }

    public void run() {
        quantidade = buffer.getQuantidade();
        for (int i = 0; i < quantidade; i++) {
            try {
                Thread.sleep(1000); //espera de 3s
                buffer.comer(id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
