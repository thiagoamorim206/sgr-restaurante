package Controller;

public class Mesa {

    private int id_mesa, nr_lugares;
    private String nm_mesa, nm_cliente, ds_obs;
    private boolean fl_ocupada;

    public Mesa(int id_mesa, int nr_lugares, String nm_mesa, String nm_cliente, String ds_obs, boolean fl_ocupada) {
        this.id_mesa = id_mesa;
        this.nr_lugares = nr_lugares;
        this.nm_mesa = nm_mesa;
        this.nm_cliente = nm_cliente;
        this.ds_obs = ds_obs;
        this.fl_ocupada = fl_ocupada;
    }

    public Mesa() {
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public int getNr_lugares() {
        return nr_lugares;
    }

    public void setNr_lugares(int nr_lugares) {
        this.nr_lugares = nr_lugares;
    }

    public String getNm_mesa() {
        return nm_mesa;
    }

    public void setNm_mesa(String nm_mesa) {
        this.nm_mesa = nm_mesa;
    }

    public String getNm_cliente() {
        return nm_cliente;
    }

    public void setNm_cliente(String nm_cliente) {
        this.nm_cliente = nm_cliente;
    }

    public String getDs_obs() {
        return ds_obs;
    }

    public void setDs_obs(String ds_obs) {
        this.ds_obs = ds_obs;
    }

    public boolean isFl_ocupada() {
        return fl_ocupada;
    }

    public void setFl_ocupada(boolean fl_ocupada) {
        this.fl_ocupada = fl_ocupada;
    }

}
