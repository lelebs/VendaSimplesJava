package Model;

import java.util.ArrayList;


public class Dashboard 
{
    private String codigo;
    private int quantidadeVendida;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
    
    public static ArrayList<Dashboard> recuperarDados()
    {
        return Controller.DashboardDao.recupararDados();
    }
}
