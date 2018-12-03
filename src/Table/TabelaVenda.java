package Table;

import Model.VendaTable;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TabelaVenda extends AbstractTableModel{

    private static final int ID_VENDA = 0;
    private static final int PESSOA = 1;
    private static final int VALOR_TOTAL = 2;
    private static final int DATA_CADASTRO = 3;
    private static final int DATA_VENDA = 4;
    private static final int DATA_CANCELAMENTO = 5;
    private static final int SITUACAO = 6;
    
    private final String [] colunas = {"Código","Pessoa","Valor total","Data de inserção","Data de venda", "Data de cancelamento", "Situação"};
    
    private List<VendaTable> linhas;
    
    public TabelaVenda(List<VendaTable> linhas){
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
        VendaTable vendaTable = linhas.get(linhaIndice);
        switch (colunaIndice) {
            case ID_VENDA:
                return vendaTable.getIdVenda();
            case PESSOA:
                return vendaTable.getPessoaRazao();
            case VALOR_TOTAL:
                return vendaTable.getValorTotal();
            case DATA_CADASTRO:
                return vendaTable.getDataCadastro();
            case DATA_VENDA:
                return vendaTable.getDataVenda();
            case DATA_CANCELAMENTO:
                return vendaTable.getDataCancelamento();
            case SITUACAO:
                return vendaTable.getSituacao();
            default:
                break;
        }
        return null;
    }
    
    public void adicionar (VendaTable vendaTable){
        linhas.add(vendaTable);
        int ultimaLinha = getRowCount()-1;
        fireTableRowsInserted(ultimaLinha, ultimaLinha);
    }
    
    public void excluir (int linhaIndice){
        linhas.remove(linhaIndice);
        fireTableRowsDeleted(linhaIndice, linhaIndice);
    }
    
    public VendaTable getItem(int linhaIndice){
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
