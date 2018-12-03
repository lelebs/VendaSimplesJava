package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory 
{
    private static final String URL = "jdbc:postgresql://localhost/vendasimples";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";
    
    public static Connection connect() 
    {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (SQLException e)
        {
            Helper.MostrarMensagem.mostrarErroMensagem(e.getMessage());
        }
        return conn;
    }
}