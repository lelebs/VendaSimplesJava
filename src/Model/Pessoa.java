
package Model;

import java.util.ArrayList;
import java.util.Date;


public class Pessoa {
    private int idPessoa;
    private String razaoSocial;
    private String tipoPessoa;
    private Date dataNascimento;
    private String cpfCnpj;
    private String ativo;

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String isAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    
    public static Pessoa inserirPessoa(Pessoa pessoa)
    {
        return Controller.PessoasDao.inserir(pessoa);
    }
    
    public static Pessoa listarUma(int idPessoa)
    {
        return Controller.PessoasDao.listarUma(idPessoa);
    }
    
    public static ArrayList listarTodas(String campo, String valor)
    {
        return Controller.PessoasDao.listarTodas(campo, valor);
    }
    
    public static boolean deletarPessoa(int idPessoa)
    {
        return Controller.PessoasDao.deletarPessoa(idPessoa);
    }
    
    public static Pessoa alterarPessoa(Pessoa pessoa)
    {
        return Controller.PessoasDao.alterarPessoa(pessoa);
    }
    
    public static boolean validarSeCpfCnpjExiste(String cpfCnpj)
    {
        return Controller.PessoasDao.validarSeCpfCnpjExiste(cpfCnpj);
    }
    
    public static boolean permitirAlteracao(int idPessoa, String cpfCnpj)
    {
        return Controller.PessoasDao.permitirAlteracao(idPessoa, cpfCnpj);
    }
}
