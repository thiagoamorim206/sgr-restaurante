package Controller;

import java.util.ArrayList;

public class CalcTotal {

    public static <T extends Number> double calcularTotal(ArrayList<T> valores) {
        double total = 0;
        for (int i = 0; i < valores.size(); i++) {
            total += valores.get(i).doubleValue();
        }
        return total;
    }
}
