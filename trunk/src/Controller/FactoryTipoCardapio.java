package Controller;

public class FactoryTipoCardapio {

    public TipoCardapio createCardapio(String nome) {
        TipoCardapio cardapio = null;
        if (nome.equals("Sobremesa")) {
            cardapio = new Sobremesa();
        } else if (nome.equals("Suco")) {
            cardapio = new Suco();
        } else if (nome.equals("Acompanhamento")) {
            cardapio = new Acompanhamento();
        } else if (nome.equals("Bebida")) {
            cardapio = new Bebida();
        }

        return cardapio;
    }
}
