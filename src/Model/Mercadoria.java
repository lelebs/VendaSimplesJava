package Model;

import java.util.ArrayList;

public class Mercadoria {
    private int idMercadoria;
    private String codigo;
    private String descricao;
    private double valor;
    private String ativo;

    public int getIdMercadoria() {
        return idMercadoria;
    }

    public void setIdMercadoria(int idMercadoria) {
        this.idMercadoria = idMercadoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String isAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    
    public static Mercadoria inserirMercadoria(Mercadoria mercadoria)
    {
        return Controller.MercadoriasDao.inserir(mercadoria);
    }
    
    public static Mercadoria listarUma(int idMercadoria)
    {
        return Controller.MercadoriasDao.listarUma(idMercadoria);
    }
    
    public static ArrayList listarTodas(String campo, String valor)
    {
        return Controller.MercadoriasDao.listarTodas(campo, valor);
    }
    
    public static boolean deletarMercadoria(int idMercadoria)
    {
        return Controller.MercadoriasDao.deletarMercadoria(idMercadoria);
    }
    
    public static Mercadoria alterarMercadoria(Mercadoria mercadoria)
    {
        return Controller.MercadoriasDao.alterarMercadoria(mercadoria);
    }
    
    public static boolean validarSeCodigoExiste(String codigo)
    {
        return Controller.MercadoriasDao.validarSeCodigoExiste(codigo);
    }
    
    public static boolean permitirAlteracao(int idMercadoria, String codigo)
    {
        return Controller.MercadoriasDao.validarAlteracao(idMercadoria, codigo);
    }
}
