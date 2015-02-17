package Controller;

import java.util.Scanner;

/**
 *
 * @author Adriano
 */
public class CreateTipoRestaurante {
    public static TipoRestaurante novoRestaurante(){
        FactoryTipoRestaurante fabrica = new FactoryTipoRestaurante();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tipos possíveis: Portugues, Italiano, Japones");
        String tipo = scanner.nextLine();
        return fabrica.createRestaurante(tipo);
    }
}
