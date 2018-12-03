package Table;

import Model.Dashboard;
import java.util.List;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaDashboard extends AbstractTableModel
{
    private static final int CODIGO_MERCADORIA = 0;
    private static final int QUANTIDADE = 1;
    
    private static String [] colunas = {"Código Mercadoria","Quantidade vendida"};
    
    private List<Dashboard> linhas;
    
    public TabelaDashboard(List<Dashboard> linhas){
        this.linhas = linhas;
    }
    
    @Override
    public int getRowCount() {
       return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linhaIndice, int colunaIndice) 
    {
        Dashboard dashboard = linhas.get(linhaIndice);
        if(colunaIndice == CODIGO_MERCADORIA){
            return dashboard.getCodigo();
        }
        else if(colunaIndice == QUANTIDADE){
            return dashboard.getQuantidadeVendida();
        }
        
        return null;
    }
    
    public void adicionar (Dashboard dashboard){
        linhas.add(dashboard);
        int ultimaLinha = getRowCount()-1;
        fireTableRowsInserted(ultimaLinha, ultimaLinha);
    }
    
    public void excluir (int linhaIndice){
        linhas.remove(linhaIndice);
        fireTableRowsDeleted(linhaIndice, linhaIndice);
    }
    
    public Dashboard getItem(int linhaIndice){
        return linhas.get(linhaIndice);
    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }
    
    public String getNomeColuna(int colunaIndice){
        return colunas[colunaIndice];
    }
}