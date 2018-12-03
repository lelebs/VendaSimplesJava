/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author Leandro
 */
public class CampoVazioException extends RuntimeException{
    public CampoVazioException(String campo)
    {
        super("O campo [" +campo + "] não pode ser vazio");
    }
}
