package Controller;

public class Produtor implements Runnable {

    private Buffer buffer;
    private int id, quantidade;

    public Produtor(Buffer b, int id) {
        this.buffer = b;
        this.id = id;
    }

    public void run() {
        int sum = 0;
        quantidade = buffer.getQuantidade();
        for (int i = 0; i < quantidade; i++) {
            try {
                Thread.sleep(1000); //espera de 1s
                buffer.cozinhar(id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }//fim do for
    }

}
