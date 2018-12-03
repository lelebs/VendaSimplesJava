package Model;

import java.util.ArrayList;
import java.util.Date;

public class Venda {
    private int idVenda;
    private int idPessoa;
    private int idMercadoria;
    private double quantidade;
    private double valorUnitario;
    private double valorTotal;
    private String situacao;
    private Date dataCadastro;
    private Date dataVenda;
    private Date dataCancelamento;
    private String pessoaRazaoSocial;
    private String pessoaCpfCnpj;

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getIdMercadoria() {
        return idMercadoria;
    }

    public void setIdMercadoria(int idMercadoria) {
        this.idMercadoria = idMercadoria;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    public String getPessoaRazaoSocial() {
        return pessoaRazaoSocial;
    }

    public void setPessoaRazaoSocial(String pessoaRazaoSocial) {
        this.pessoaRazaoSocial = pessoaRazaoSocial;
    }

    public String getPessoaCpfCnpj() {
        return pessoaCpfCnpj;
    }

    public void setPessoaCpfCnpj(String pessoaCpfCnpj) {
        this.pessoaCpfCnpj = pessoaCpfCnpj;
    }
    
    public static VendaTable inserirVenda(Venda venda)
    {
        return Controller.VendasDao.inserir(venda);
    }
    
    public static Venda listarUma(int idVenda)
    {
        return Controller.VendasDao.listarUma(idVenda);
    }
    
    public static VendaTable cancelarVenda(int idVenda, Date dataCancelamento)
    {
        return Controller.VendasDao.cancelarVenda(idVenda, dataCancelamento);
    }
    
    public static ArrayList listarTodas(String campo, String valor)
    {
        return Controller.VendasDao.listarTodas(campo, valor);
    }
    public static VendaTable alterarVenda(Venda venda)
    {
        return Controller.VendasDao.alterarVenda(venda);
    }
    
    public static VendaTable concluirVenda(int idVenda, Date dataConclusao)
    {
        return Controller.VendasDao.concluirVenda(idVenda, dataConclusao);
    }
    
    public static VendaTable reabrirVendaConcluida(int idVenda, String situacao)
    {
        return Controller.VendasDao.reabrirVendaConcluida(idVenda, situacao);
    }
    
    public static VendaTable reabrirVendaCancelada(int idVenda)
    {
        return Controller.VendasDao.reabrirVendaCancelada(idVenda);
    }
    
    public static VendaTable listarUmaVendaTable(int idVenda)
    {
        return Controller.VendasDao.listarUmaVendaTable(idVenda);
    }
            
    public static String verificarSituacao(int idVenda)
    {
        return Controller.VendasDao.verificarSituacao(idVenda);
    }
}