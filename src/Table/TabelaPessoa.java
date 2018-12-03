package Table;

import Model.Pessoa;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaPessoa extends AbstractTableModel{
    
    private static final int IDPESSOA=0;
    private static final int RAZAOSOCIAL=1;
    private static final int TIPOPESSOA=2;
    private static final int DATANASCIMENTO=3;
    private static final int CPFCNPJ=4;
    private static final int ATIVO=5;
    
    private final String[] colunas={"ID","Razao Social","Pessoa","Data de nascimento","CPF/CNPJ","Ativo"};
    
    private List<Pessoa> linhas;
    
    public TabelaPessoa(List<Pessoa> linhas){
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
    public Object getValueAt(int linhaIndice, int colunaIndice) {
        Pessoa pessoa = linhas.get(linhaIndice);
        switch (colunaIndice) {
            case IDPESSOA:
                return pessoa.getIdPessoa();
            case RAZAOSOCIAL:
                return pessoa.getRazaoSocial();
            case TIPOPESSOA:
                return pessoa.getTipoPessoa();
            case DATANASCIMENTO:
                return pessoa.getDataNascimento();
            case CPFCNPJ:
                return pessoa.getCpfCnpj();
            case ATIVO:
                return pessoa.isAtivo();
            default:
                break;
        }
        return null;
    }
    
    public void adicionar(Pessoa pessoa){
        linhas.add(pessoa);
        int ultimaLinha = getRowCount()-1;
        fireTableRowsInserted(ultimaLinha, ultimaLinha);
    }
    
    public void excluir(int linhaIndice){
        linhas.remove(linhaIndice);
        fireTableRowsDeleted(linhaIndice, linhaIndice);
    }
    
    public Pessoa getItem(int linhaIndice){
        return linhas.get(linhaIndice);
    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna]; //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getNomeColuna(int colunaIndice){
        return colunas[colunaIndice];
    }
}
