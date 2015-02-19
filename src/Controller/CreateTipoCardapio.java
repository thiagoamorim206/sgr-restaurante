package Controller;

import java.util.Scanner;

public class CreateTipoCardapio {

    public static TipoCardapio novoTipoCardapio() {
        FactoryTipoCardapio cardapio = new FactoryTipoCardapio();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tipos possíveis: Acompanhamento,Bebida, Prato, Sobremesa, Suco");
        String tipo = scanner.nextLine();
        return cardapio.createCardapio(tipo);
    }
}
