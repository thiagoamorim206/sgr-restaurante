package ControllerBean;

import ControllerDAO.CardapioDAO;
import Model.TbCardapio;

public class CardapioBean {

    private TbCardapio cardapio = new TbCardapio();
    private final CardapioDAO cardapioDao = new CardapioDAO();

    public CardapioBean(int IdTipoRestaurante, int IdTipoCardapio,String nmItemCardapio, double vlItem) {
        cardapio.setIdTipoRestaurante(IdTipoRestaurante);
        cardapio.setIdTipoCardapio(IdTipoCardapio);
        cardapio.setNmItemCardapio(nmItemCardapio);
        cardapio.setVlItem(vlItem);
    }

    public TbCardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(TbCardapio cardapio) {
        this.cardapio = cardapio;
    }

    public String CadastroCardapio() {
        if (cardapio.getNmItemCardapio() != null) { // verifica se eh nulo
            cardapio = cardapioDao.inserirCardapio(cardapio);//salva
            return "Sucesso"; // Caso de Sucesso
        } else {
            return "Erro"; // CASO CONTRARIO MANDA UM ALERT DE ERRO
        }
    }

}
