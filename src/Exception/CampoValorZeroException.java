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
public class CampoValorZeroException extends RuntimeException{
    public CampoValorZeroException(String campo) {
        super("O campo [" + campo + "] deve ter valor maior que 0");
    }
}
