/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author leandro
 */
public class BancoException extends RuntimeException{
    public BancoException(String exception) {
        super("Ocorreu um erro ao inserir os registros \n"
        + "Exceção: " + exception );
        
    }
}
