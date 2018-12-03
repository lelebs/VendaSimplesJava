package Table;

import Model.Mercadoria;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TabelaMercadoria extends AbstractTableModel{

    private static final int ID_MERCADORIA = 0;
    private static final int CODIGO = 1;
    private static final int DESCRICAO = 2;
    private static final int VALOR = 3;
    private static final int ATIVO = 4;
    
    private static String [] colunas = {"ID","Codigo","Descrição","Valor","Ativo"};
    
    private List<Mercadoria> linhas;
    
    public TabelaMercadoria(List<Mercadoria> linhas){
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
        Mercadoria mercadoria = linhas.get(linhaIndice);
        if(colunaIndice == ID_MERCADORIA){
            return mercadoria.getIdMercadoria();
        }
        else if(colunaIndice == CODIGO){
            return mercadoria.getCodigo();
        }
        else if(colunaIndice == DESCRICAO){
            return mercadoria.getDescricao();
        }
        else if(colunaIndice == VALOR){
            return mercadoria.getValor();
        }
        else if(colunaIndice == ATIVO){
            return mercadoria.isAtivo();
        }
        
        return null;
    }
    
    public void adicionar (Mercadoria mercadoria){
        linhas.add(mercadoria);
        int ultimaLinha = getRowCount()-1;
        fireTableRowsInserted(ultimaLinha, ultimaLinha);
    }
    
    public void excluir (int linhaIndice){
        linhas.remove(linhaIndice);
        fireTableRowsDeleted(linhaIndice, linhaIndice);
    }
    
    public Mercadoria getItem(int linhaIndice){
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
