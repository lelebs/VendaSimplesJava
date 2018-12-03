/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Exception.BancoException;
import Model.Mercadoria;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MercadoriasDao 
{
    
    private static Connection CONN = ConnectionFactory.connect();
    private static final String INSERIR_MERCADORIA = "INSERT INTO mercadoria(codigo, descricao, valor, ativo)"
            + "VALUES(?,?,?,?)";
    private static final String SELECT_ID_MERCADORIA = "SELECT * FROM mercadoria WHERE id = ?";
    private static final String SELECT_ULTIMA_INSERIDA = "SELECT * FROM mercadoria ORDER BY id DESC LIMIT 1";
    private static final String EXCLUIR_MERCADORIA = "DELETE FROM mercadoria WHERE id = ?";
    private static final String ALTERAR_MERCADORIA = "UPDATE mercadoria SET codigo = ?, descricao = ?, valor = ?, ativo = ? WHERE id = ?";
    
    public static Mercadoria inserir(Mercadoria mercadoria)
    {
        CONN = ConnectionFactory.connect();
        try
        {
            //Cada parâmetro abaixo, é definido na constante INSERIR_MERCADORIA como uma "?"
            PreparedStatement pstmt = CONN.prepareCall(INSERIR_MERCADORIA); //Preparação do comando Inserir Mercadoria
            pstmt.setString(1, mercadoria.getCodigo()); //O Código do objeto mercadoria é passado ao primeiro parâmetro
            pstmt.setString(2, mercadoria.getDescricao()); //Descrição da mercadoria é passsada ao segundo parâmetro
            pstmt.setDouble(3, mercadoria.getValor()); //Valor da Mercadoria é passada ao tereiro parâmetro
            pstmt.setString(4, mercadoria.isAtivo()); //Situação da mercadoria é passada ao quarto parâmetro
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
    
    public static Mercadoria listarUma(int idMercadoria)
    {
        CONN = ConnectionFactory.connect();
        //Instanciamos uma mercadoria
        Mercadoria mercadoria = new Mercadoria();
        try
        {
            //Preparamos a chamada da constante SELECT_ID_MERCADORIA
            PreparedStatement pstmt = CONN.prepareStatement(SELECT_ID_MERCADORIA);
            //Adicionamos o id da mercadoria como parâmetro
            pstmt.setInt(1, idMercadoria);
            
            //Executamos a query e armazenos o retorno no ResultSet
            try(ResultSet rs = pstmt.executeQuery())
            {
                while(rs.next())
                {
                    //Armazenamos o retorno do banco no objeto mercadoria
                    mercadoria.setIdMercadoria(rs.getInt(1));
                    mercadoria.setCodigo(rs.getString(2));
                    mercadoria.setDescricao(rs.getString(3));
                    mercadoria.setValor(rs.getDouble(4));
                    mercadoria.setAtivo(rs.getString(5));
                }
            }
            
            CONN.close();
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());
        }
        
        //Retorno do objeto mercadoria preenchido
        return mercadoria;
    }
    
    public static Mercadoria listarUltimaInserida()
    {
        CONN = ConnectionFactory.connect();
        //Instanciamos uma mercadoria
        Mercadoria mercadoria = new Mercadoria();
        
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
                    mercadoria.setIdMercadoria(rs.getInt(1));
                    mercadoria.setCodigo(rs.getString(2));
                    mercadoria.setDescricao(rs.getString(3));
                    mercadoria.setValor(rs.getDouble(4));
                    mercadoria.setAtivo(rs.getString(5));
                }
            }
            
            CONN.close();
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());
        }
        
        //Retorno do objeto mercadoria preenchido
        return mercadoria;
    }
    
    public static boolean deletarMercadoria(int idMercadoria)  
    {
        CONN = ConnectionFactory.connect();
        try(PreparedStatement pstmt = CONN.prepareCall(EXCLUIR_MERCADORIA))
        {
            pstmt.setInt(1, idMercadoria);
            pstmt.executeUpdate();
            
            CONN.close();
            
            return true;
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());
        }
    }
    
    public static ArrayList<Mercadoria> listarTodas(String campo, String valor)
    {
        String sql = "";
        
        CONN = ConnectionFactory.connect();
        
        if("".equals(valor))
        {
            sql = "SELECT * FROM mercadoria";
        }
        
        else
        {
            switch(campo)
            {
                case "Código": campo = "WHERE codigo = '" + valor + "' AND ativo = 'Sim'"; break;
                case "Descrição(Ativos)": campo = "WHERE descricao = '" + valor + "' AND ativo = 'Sim'"; break;
                case "Descrição(Todos)": campo = "WHERE descricao = '?'"; break;
            }
            
            sql = "SELECT * FROM mercadoria " + campo;
        }
                    
        ArrayList<Mercadoria> todasMercadorias = new ArrayList();
        
        try
        {
            PreparedStatement pstmt = CONN.prepareStatement(sql);
            
            try(ResultSet rs = pstmt.executeQuery())
            {
                while(rs.next() == true)
                {
                    Mercadoria mercadoria = new Mercadoria();
                    mercadoria.setIdMercadoria(rs.getInt(1));
                    mercadoria.setCodigo(rs.getString(2));
                    mercadoria.setDescricao(rs.getString(3));
                    mercadoria.setValor(rs.getDouble(4));
                    mercadoria.setAtivo(rs.getString(5));
                    todasMercadorias.add(mercadoria);
                }
            }
            
            CONN.close();
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());
        }
        
        return todasMercadorias;
    }
    
    public static Mercadoria alterarMercadoria(Mercadoria mercadoria)
    {
        CONN = ConnectionFactory.connect();
        
        try(PreparedStatement pstmt = CONN.prepareCall(ALTERAR_MERCADORIA))
        {
            pstmt.setString(1, mercadoria.getCodigo());
            pstmt.setString(2, mercadoria.getDescricao());
            pstmt.setDouble(3, mercadoria.getValor());
            pstmt.setString(4, mercadoria.isAtivo());
            pstmt.setInt(5, mercadoria.getIdMercadoria());
            pstmt.executeUpdate();
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());     
        }
        
        return Mercadoria.listarUma(mercadoria.getIdMercadoria());
    }
    
    public static boolean validarSeCodigoExiste(String codigo)
    {
        CONN = ConnectionFactory.connect();
        
        try
        {
            String sql = "SELECT * FROM mercadoria WHERE codigo = '" + codigo + "'";
            //Preparamos a chamada da constante SELECT_ID_MERCADORIA
            PreparedStatement pstmt = CONN.prepareStatement(sql);
            
            //Executamos a query e armazenos o retorno no ResultSet
            try(ResultSet rs = pstmt.executeQuery())
            {
                if(rs.next() == true)
                {
                    return true;
                }
            }
            
            CONN.close();
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());
        }
        
        return false;
    }
}