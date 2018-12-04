/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Exception.BancoException;
import Model.Pessoa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PessoasDao 
{
    private static Connection CONN = ConnectionFactory.connect();
    private static final String INSERIR_PESSOA = "INSERT INTO pessoa(razaosocial, datanascimento, cpfcnpj"
            + ", tipopessoa, ativo) VALUES(?,?,?,?,?)";
    private static final String SELECT_ID_PESSOA = "SELECT * FROM pessoa WHERE id = ?";
    private static final String SELECT_ULTIMA_INSERIDA = "SELECT * FROM pessoa ORDER BY id DESC LIMIT 1";
    private static final String EXCLUIR_PESSOA = "DELETE FROM pessoa WHERE id = ?";
    private static final String ALTERAR_PESSOA = "UPDATE pessoa SET razaosocial = ?, datanascimento = ?, cpfcnpj = ?"
            + ", tipopessoa = ?, ativo = ? WHERE id = ?";
    private static final String VALIDAR_PESSOA_EXISTE = "SELECT * FROM pessoa WHERE cpfcnpj = ?";
    private static final String PERMITIR_ALTERACAO = "SELECT cpfCnpj FROM pessoa WHERE id <> ? AND cpfCnpj = ?";
    
    public static Pessoa inserir(Pessoa pessoa)
    {
        CONN = ConnectionFactory.connect();
        try
        {
            //Cada parâmetro abaixo, é definido na constante INSERIR_MERCADORIA como uma "?"
            PreparedStatement pstmt = CONN.prepareCall(INSERIR_PESSOA); //Preparação do comando Inserir Mercadoria
            pstmt.setString(1, pessoa.getRazaoSocial()); //O Código do objeto mercadoria é passado ao primeiro parâmetro
            pstmt.setDate(2, new java.sql.Date(pessoa.getDataNascimento().getTime()));
            pstmt.setString(3, pessoa.getCpfCnpj()); //Descrição da mercadoria é passsada ao segundo parâmetro
            pstmt.setString(4, pessoa.getTipoPessoa()); //Valor da Mercadoria é passada ao tereiro parâmetro
            pstmt.setString(5, pessoa.isAtivo()); //Situação da mercadoria é passada ao quarto parâmetro
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
    
    public static Pessoa listarUma(int idPessoa)
    {
        CONN = ConnectionFactory.connect();
        //Instanciamos uma mercadoria
        Pessoa pessoa = new Pessoa();
        try
        {
            //Preparamos a chamada da constante SELECT_ID_MERCADORIA
            PreparedStatement pstmt = CONN.prepareStatement(SELECT_ID_PESSOA);
            //Adicionamos o id da mercadoria como parâmetro
            pstmt.setInt(1, idPessoa);
            
            //Executamos a query e armazenos o retorno no ResultSet
            try(ResultSet rs = pstmt.executeQuery())
            {
                while(rs.next())
                {
                    //Armazenamos o retorno do banco no objeto mercadoria
                    pessoa.setIdPessoa(rs.getInt(1));
                    pessoa.setRazaoSocial(rs.getString(2));
                    pessoa.setDataNascimento(rs.getDate(3));
                    pessoa.setCpfCnpj(rs.getString(4));
                    pessoa.setTipoPessoa(rs.getString(5));
                    pessoa.setAtivo(rs.getString(6));
                }
            }
            
            CONN.close();
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());        
        }
        
        //Retorno do objeto mercadoria preenchido
        return pessoa;
    }
    
    public static Pessoa listarUltimaInserida()
    {
        CONN = ConnectionFactory.connect();
        //Instanciamos uma mercadoria
        Pessoa pessoa = new Pessoa();
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
                    pessoa.setIdPessoa(rs.getInt(1));
                    pessoa.setRazaoSocial(rs.getString(2));
                    pessoa.setDataNascimento(rs.getDate(3));
                    pessoa.setCpfCnpj(rs.getString(4));
                    pessoa.setTipoPessoa(rs.getString(5));
                    pessoa.setAtivo(rs.getString(6));
                }
            }
            
            CONN.close();
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());
        }
        
        //Retorno do objeto mercadoria preenchido
        return pessoa;
    }
    
    public static boolean deletarPessoa(int idPessoa)  
    {
        CONN = ConnectionFactory.connect();
        try(PreparedStatement pstmt = CONN.prepareCall(EXCLUIR_PESSOA))
        {
            pstmt.setInt(1, idPessoa);
            pstmt.executeUpdate();
            
            CONN.close();
            
            return true;
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());       
        }
    }
    
    public static ArrayList<Pessoa> listarTodas(String campo, String valor)
    {
        CONN = ConnectionFactory.connect();
        
        String sql = "";
        
        if("".equals(valor))
        {
            sql = "SELECT * FROM pessoa";
        }
        
        else
        {
            switch(campo)
            {
                case "CPF/CNPJ": campo = "WHERE cpfcnpj = '" + valor + "' AND ativo = 'Sim' "; break;
                case "Razão Social(Ativos)": campo = "where razaosocial = '" + valor + "' AND ativo = 'Sim'"; break;
                case "Razão Social(Todos)": campo = "where razaosocial = '" + valor + "'"; break;
            }
            
            sql = "SELECT * FROM pessoa " + campo;
        }
            
        ArrayList<Pessoa> todasPessoas = new ArrayList();
        
        try
        {
            PreparedStatement pstmt = CONN.prepareStatement(sql);
            
            try(ResultSet rs = pstmt.executeQuery())
            {
                while(rs.next())
                {
                    Pessoa pessoa = new Pessoa();
                    pessoa.setIdPessoa(rs.getInt(1));
                    pessoa.setRazaoSocial(rs.getString(2));
                    pessoa.setDataNascimento(rs.getDate(3));
                    pessoa.setCpfCnpj(rs.getString(4));
                    pessoa.setTipoPessoa(rs.getString(5));
                    pessoa.setAtivo(rs.getString(6));
                    todasPessoas.add(pessoa);
                }
            }
            
            CONN.close();
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());        
        }
        
        return todasPessoas;
    }
    
    public static Pessoa alterarPessoa(Pessoa pessoa)
    {
        CONN = ConnectionFactory.connect();
        
        try(PreparedStatement pstmt = CONN.prepareCall(ALTERAR_PESSOA))
        {
            pstmt.setString(1, pessoa.getRazaoSocial());
            pstmt.setDate(2, new java.sql.Date(pessoa.getDataNascimento().getTime()));
            pstmt.setString(3, pessoa.getCpfCnpj());
            pstmt.setString(4, pessoa.getTipoPessoa());
            pstmt.setString(5, pessoa.isAtivo());
            pstmt.setInt(6, pessoa.getIdPessoa());
            pstmt.executeUpdate();
        }
        
        catch(SQLException ex)
        {
            throw new BancoException(ex.getMessage());       
        }
        
        return Pessoa.listarUma(pessoa.getIdPessoa());
        //return Pessoa.listarUma(pessoa.getIdPessoa());
    }
    
    public static boolean validarSeCpfCnpjExiste(String cpfCnpj)
    {
        CONN = ConnectionFactory.connect();
        
        try
        {
            //Preparamos a chamada da constante SELECT_ID_MERCADORIA
            PreparedStatement pstmt = CONN.prepareStatement(VALIDAR_PESSOA_EXISTE);
            pstmt.setString(1, cpfCnpj);
            
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
    
    public static boolean permitirAlteracao(int idPessoa, String cpfCnpj)
    {
        CONN = ConnectionFactory.connect();
        
        try
        {
            //Preparamos a chamada da constante SELECT_ID_MERCADORIA
            PreparedStatement pstmt = CONN.prepareStatement(PERMITIR_ALTERACAO);
            pstmt.setInt(1, idPessoa);
            pstmt.setString(2, cpfCnpj);
            
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