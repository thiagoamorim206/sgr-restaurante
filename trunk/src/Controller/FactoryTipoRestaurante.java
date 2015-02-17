package Controller;

/**
 *
 * @author Adriano
 */
public class FactoryTipoRestaurante {

    public TipoRestaurante createRestaurante(String nome) {
        TipoRestaurante restaurante = null;
        if (nome.equals("Portugues")) {
            restaurante = new RestaurantePortugues();
        } else if (nome.equals("Italiano")) {
            restaurante = new RestauranteItaliano();
        } else if (nome.equals("Japones")) {
            restaurante = new RestauranteJapones();
        }
        return restaurante;
    }
}
