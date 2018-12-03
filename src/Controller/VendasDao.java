/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Exception.BancoException;
import Model.Venda;
import Model.VendaTable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class VendasDao 
{
    
    private static Connection CONN = ConnectionFactory.connect();
    private static final String INSERIR_VENDA = "INSERT INTO venda(idPessoa, idMercadoria, quantidade, valorunitario,"
            +"valortotal, situacao, datacadastro) VALUES(?,?,?,?,?,?,?)";
    private static final String SELECT_TODAS = "SELECT v.id, p.razaoSocial, valorTotal, dataCadastro, dataVenda,"
            + " dataCancelamento, situacao FROM venda v INNER JOIN pessoa p ON v.idPessoa = p.id";
    private static final String SELECT_UMA_VENDA = "SELECT id, idPessoa, idMercadoria, quantidade, valorUnitario,"
            + " valorTotal, situacao FROM venda WHERE id = ?";
    private static final String SELECT_ULTIMA_INSERIDA = "SELECT v.id, p.razaoSocial, valorTotal, dataCadastro," 
            + " dataVenda, dataCancelamento, situacao FROM venda v INNER JOIN pessoa p ON v.idPessoa = p.id "
            + "ORDER BY v.id DESC limit 1";
    private static final String CANCELAR_VENDA = "UPDATE venda SET situacao = ?, datacancelamento = ? WHERE id = ?";
    private static final String CONCLUIR_VENDA = "UPDATE venda SET situacao = ?, datavenda = ? WHERE id = ?";
    private static final String REABRIR_VENDA_CONCLUIDA = "UPDATE venda SET situacao = ?, datavenda = null WHERE id = ?";
    private static final String REABRIR_VENDA_CANCELADA = "UPDATE venda SET situacao = ?, datacancelamento = null WHERE id = ?";
    private static final String ALTERAR_VENDA = "UPDATE venda SET idPessoa = ?, idMercadoria = ?, quantidade = ?,"
            + " valorUnitario = ?, valortotal = ? WHERE id = ?";
    private static final String SELECT_SITUACAO = "SELECT situacao FROM venda where id = ?";
    private static final String SELECT_VENDATABLE = "SELECT v.id, p.razaoSocial, valorTotal, dataCadastro, dataVenda, " 
            + " dataCancelamento, situacao FROM venda v INNER JOIN pessoa p ON v.idPessoa = p.id WHERE v.id = ?";
    
    public static VendaTable inserir(Venda venda)
    {
        CONN = ConnectionFactory.connect();
        try
        {
            //Cada parâmetro abaixo, é definido na constante INSERIR_MERCADORIA como uma "?"
            PreparedStatement pstmt = CONN.prepareCall(INSERIR_VENDA); //Preparação do comando Inserir Mercadoria
            pstmt.setInt(1, venda.getIdPessoa()); //O Código do objeto mercadoria é passado ao primeiro parâmetro
            pstmt.setInt(2, venda.getIdMercadoria()); //Descrição da mercadoria é passsada ao segundo parâmetro
            pstmt.setDouble(3, venda.getQuantidade());//Valor da Mercadoria é passada ao tereiro parâmetro
            pstmt.setDouble(4, venda.getValorUnitario()); //Situação da mercadoria é passada ao quarto parâmetro
            pstmt.setDouble(5, venda.getValorTotal());
            pstmt.setString(6, venda.getSituacao());
            pstmt.setDate(7, new java.sql.Date(venda.getDataCadastro().getTime()));
            pstmt.executeUpdate();
        
            CONN.close();
        }
        catch(SQLException ex)
        {
            //Aqui são mostradas as mensagens de exceção do SQL.
            throw new BancoException(ex.getMessage());
        }
        //Aqui chamamos o método de listar mercadoria, com a id da mercadoria inserida
        return listarUltimaInserida();
    }
    
    public static Venda listarUma(int idVenda)
    {
        CONN = ConnectionFactory.connect();
        //Instanciamos uma mercadoria
        Venda venda = new Venda();
        try
        {
            //Preparamos a chamada da constante SELECT_ID_MERCADORIA
            PreparedStatement pstmt = CONN.prepareStatement(SELECT_UMA_VENDA);
            //Adicionamos o id da mercadoria como parâmetro
            pstmt.setInt(1, idVenda);
            
            //Executamos a query e armazenos o retorno no ResultSet
            try(ResultSet rs = pstmt.executeQuery())
            {
                while(rs.next())
                {
                    //Armazenamos o retorno do banco no objeto mercadoria
                    venda.setIdVenda(rs.getInt(1));
                    venda.setIdPessoa(rs.getInt(2));
                    venda.setIdMercadoria(rs.getInt(3));
                    venda.setQuantidade(rs.getDouble(4));
                    venda.setValorUnitario(rs.getDouble(5));
                    venda.setValorTotal(rs.getDouble(6));
                    venda.setSituacao(rs.getString(7));
                }
            }
            
            CONN.close();
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());
        }
        
        //Retorno do objeto mercadoria preenchido
        return venda;
    }
    
    public static VendaTable listarUmaVendaTable(int idVenda)
    {
        CONN = ConnectionFactory.connect();
        //Instanciamos uma mercadoria
        VendaTable vendaTable = new VendaTable();

        try
        {
            //Preparamos a chamada da constante SELECT_ID_MERCADORIA
            PreparedStatement pstmt = CONN.prepareStatement(SELECT_VENDATABLE);
            //Adicionamos o id da mercadoria como parâmetro
            pstmt.setInt(1, idVenda);
            
            //Executamos a query e armazenos o retorno no ResultSet
            try(ResultSet rs = pstmt.executeQuery())
            {
                while(rs.next())
                {
                    //Armazenamos o retorno do banco no objeto mercadoria
                    //Armazenamos o retorno do banco no objeto mercadoria
                    vendaTable.setIdVenda(rs.getInt(1));
                    vendaTable.setPessoaRazao(rs.getString(2));
                    vendaTable.setValorTotal(rs.getDouble(3));
                    vendaTable.setDataCadastro(rs.getDate(4));
                    vendaTable.setDataVenda(rs.getDate(5));
                    vendaTable.setDataCancelamento(rs.getDate(6));
                    vendaTable.setSituacao(rs.getString(7));
                }
            }
            
            CONN.close();
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());
        }
        
        //Retorno do objeto mercadoria preenchido
        return vendaTable;
    }
    
    public static VendaTable listarUltimaInserida()
    {
        CONN = ConnectionFactory.connect();
        
        VendaTable vendaTable = new VendaTable();
        try
        {
            //Preparamos a chamada da constante SELECT_ID_MERCADORIA
            PreparedStatement pstmt = CONN.prepareStatement(SELECT_ULTIMA_INSERIDA);
            
            //Executamos a query e armazenos o retorno no ResultSet
            try(ResultSet rs = pstmt.executeQuery())
            {
                while(rs.next())
                {
                    //Armazenamos o retorno do banco no objeto mercadoria
                    vendaTable.setIdVenda(rs.getInt(1));
                    vendaTable.setPessoaRazao(rs.getString(2));
                    vendaTable.setValorTotal(rs.getDouble(3));
                    vendaTable.setDataCadastro(rs.getDate(4));
                    vendaTable.setDataVenda(rs.getDate(5));
                    vendaTable.setDataCancelamento(rs.getDate(6));
                    vendaTable.setSituacao(rs.getString(7));
                }
            }
            
            CONN.close();
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());
        }
        
        //Retorno do objeto mercadoria preenchido
        return vendaTable;
    }
    
    public static VendaTable cancelarVenda(int idVenda, Date dataCancelamento)  
    {
        CONN = ConnectionFactory.connect();
        try(PreparedStatement pstmt = CONN.prepareCall(CANCELAR_VENDA))
        {
            pstmt.setString(1, "CANCELADA");
            pstmt.setDate(2, new java.sql.Date(dataCancelamento.getTime()));
            pstmt.setInt(3, idVenda);
            pstmt.executeUpdate();
            
            CONN.close();
            
            return listarUmaVendaTable(idVenda);
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());      
        }
    }
    
    public static ArrayList<VendaTable> listarTodas(String campo, String valor)
    {
        String sql = "";
        int codigo = 0;
        
        CONN = ConnectionFactory.connect();
        
        if("".equals(valor))
        {
            sql = SELECT_TODAS;
        }
        
        else
        {
            switch(campo)
            {
                case "Código": 
                    sql = SELECT_VENDATABLE;
                    codigo = Integer.parseInt(valor);
                    break;
                    
                case "Pessoa": sql = "SELECT v.id, p.razaoSocial, valorTotal, dataCadastro, dataVenda, "
                        + "dataCancelamento, situacao FROM venda v INNER JOIN pessoa p ON v.idPessoa = p.id WHERE "
                        + "p.razaoSocial = '" + valor + "'";
            }
        }
                    
        ArrayList<VendaTable> todasVendas = new ArrayList();
        
        try
        {
            PreparedStatement pstmt = CONN.prepareStatement(sql);
            if(SELECT_VENDATABLE.equals(sql))
                pstmt.setInt(1, codigo);
            
            
            try(ResultSet rs = pstmt.executeQuery())
            {
                while(rs.next() == true)
                {
                    VendaTable vendaTable = new VendaTable();
                    vendaTable.setIdVenda(rs.getInt(1));
                    vendaTable.setPessoaRazao(rs.getString(2));
                    vendaTable.setValorTotal(rs.getDouble(3));
                    vendaTable.setDataCadastro(rs.getDate(4));
                    vendaTable.setDataVenda(rs.getDate(5));
                    vendaTable.setDataCancelamento(rs.getDate(6));
                    vendaTable.setSituacao(rs.getString(7));
                    todasVendas.add(vendaTable);
                }
            }
            
            CONN.close();
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());
        }
        
        return todasVendas;
    }
    
    public static VendaTable alterarVenda(Venda venda)
    {
        CONN = ConnectionFactory.connect();
        
        try(PreparedStatement pstmt = CONN.prepareCall(ALTERAR_VENDA))
        {
            pstmt.setInt(1, venda.getIdPessoa());
            pstmt.setInt(2, venda.getIdMercadoria());
            pstmt.setDouble(3, venda.getQuantidade());
            pstmt.setDouble(4, venda.getValorUnitario());
            pstmt.setDouble(5, venda.getValorTotal());
            pstmt.setDouble(6, venda.getIdVenda());

            pstmt.executeUpdate();
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());       
        }
        
        return Venda.listarUmaVendaTable(venda.getIdVenda());
    }
    
    public static VendaTable concluirVenda(int idVenda, Date dataConclusao)
    {
        CONN = ConnectionFactory.connect();
        
        try(PreparedStatement pstmt = CONN.prepareCall(CONCLUIR_VENDA))
        {
            pstmt.setString(1, "CONCLUÍDA");
            pstmt.setDate(2, new java.sql.Date(dataConclusao.getTime()));
            pstmt.setInt(3, idVenda);
            
            pstmt.executeUpdate();
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());      
        }
        
        return Venda.listarUmaVendaTable(idVenda);
    }
    
    public static VendaTable reabrirVendaConcluida(int idVenda, String situacao)
    {
        CONN = ConnectionFactory.connect();
        
        try(PreparedStatement pstmt = CONN.prepareCall(REABRIR_VENDA_CONCLUIDA))
        {
            pstmt.setString(1, situacao);
            pstmt.setInt(2, idVenda);
            
            pstmt.executeUpdate();
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());       
        }
        
        return Venda.listarUmaVendaTable(idVenda);
    }
    
    public static VendaTable reabrirVendaCancelada(int idVenda)
    {
        CONN = ConnectionFactory.connect();
        
        try(PreparedStatement pstmt = CONN.prepareCall(REABRIR_VENDA_CANCELADA))
        {
            pstmt.setString(1, "ABERTA");
            pstmt.setInt(2, idVenda);
            
            pstmt.executeUpdate();
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());        
        }
        
        return Venda.listarUmaVendaTable(idVenda);
    }
    
    public static String verificarSituacao(int idVenda)
    {
        CONN = ConnectionFactory.connect();
        String retorno = "";
        
        try
        {
            PreparedStatement pstmt = CONN.prepareStatement(SELECT_SITUACAO);
            pstmt.setInt(1, idVenda);
        
            try(ResultSet rs = pstmt.executeQuery())
            {
                rs.next();
                retorno = rs.getString(1);
            }
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());       
        }
        
        return retorno;
    }
}