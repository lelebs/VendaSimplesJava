package Controller;

import Exception.BancoException;
import Model.Dashboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DashboardDao {
    
    private static Connection CONN = ConnectionFactory.connect();
    private static final String SELECT_DADOS = "select m.codigo, sum(quantidade) from venda v INNER JOIN "
            + "mercadoria m ON V.idMercadoria = m.id group by M.codigo";
    
    public static ArrayList<Dashboard> recupararDados()
    {
        ArrayList<Dashboard> todosDados = new ArrayList();
        CONN = ConnectionFactory.connect();
        
        try
        {
            PreparedStatement pstmt = CONN.prepareStatement(SELECT_DADOS);
            
            try(ResultSet rs = pstmt.executeQuery())
            {
                while(rs.next())
                {
                    Dashboard dashboard = new Dashboard();
                    dashboard.setCodigo(rs.getString(1));
                    dashboard.setQuantidadeVendida(rs.getInt(2));
                    todosDados.add(dashboard);
                }
            }
            
            CONN.close();
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());
        }
        
        return todosDados;
    }
}
