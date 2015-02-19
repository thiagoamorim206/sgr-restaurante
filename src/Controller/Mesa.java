package Controller;

public class Mesa {

    private int id_mesa, nr_lugares;
    private String nm_mesa;

    public Mesa(int id_mesa, int nr_lugares, String nm_mesa) {
        this.id_mesa = id_mesa;
        this.nr_lugares = nr_lugares;
        this.nm_mesa = nm_mesa;
    }

    public Mesa() {
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public int getNr_lugares() {
        return nr_lugares;
    }

    public String getNm_mesa() {
        return nm_mesa;
    }

   



}
