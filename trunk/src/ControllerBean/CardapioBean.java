package ControllerBean;

import ControllerDAO.CardapioDAO;
import Model.TbCardapio;

public class CardapioBean {

    private TbCardapio cardapio = new TbCardapio();
    private final CardapioDAO cardapioDao = new CardapioDAO();

    public CardapioBean(int IdTipoRestaurante, int IdTipoCardapio, String nmItemCardapio, double vlItem) {
        cardapio.setIdTipoRestaurante(IdTipoRestaurante);
        cardapio.setIdTipoCardapio(IdTipoCardapio);
        cardapio.setNmItemCardapio(nmItemCardapio);
        cardapio.setVlItem(vlItem);
    }

    public CardapioBean() {
    }

    public TbCardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(TbCardapio cardapio) {
        this.cardapio = cardapio;
    }

    public String CadastroCardapio() {

        cardapioDao.inserirCardapio(cardapio);//salva
        return "Sucesso"; // Caso de Sucesso

    }

    public String ListarCardapio() {
        cardapioDao.listarCardapio();
        return "Sucesso";
    }

    public String DeletarCardapio(int idCardapio) {
        cardapioDao.deletarCardapio(idCardapio);
        return "Sucesso";
    }

    public String AtualizarCardapio(TbCardapio c, int x) {
        cardapioDao.AtualizarCardapio(c, x);
        return "Sucesso";
    }
}
