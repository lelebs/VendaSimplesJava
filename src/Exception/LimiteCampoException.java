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
public class LimiteCampoException extends RuntimeException 
{
    public LimiteCampoException(double limite, String campo) {
        super("O campo [" + campo + "] deve ter tamanho máximo de " + limite + " carácteres");
    }
}
