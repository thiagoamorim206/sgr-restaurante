package ControllerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public ConnectionFactory() {
    }

    public static Connection getConnection() {
        Connection con = null;

        try {
            // carregando a classe que representa o driver de conexão com o
            // banco de dados
            try {
                Class.forName("org.postgresql.Driver");
                //obtendo a conexão com o banco de dados
                String url = "jdbc:postgresql://localhost:5432/Restaurante";

                //conexão com o banco de dados
                con = DriverManager.getConnection(url, "postgres", "thiago");
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Não encotrou o Driver!");
                cnfe.printStackTrace();
            }
            // retornando conexão
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void desconecta(Connection cn) {
        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
