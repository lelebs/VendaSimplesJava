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
public class ConverterCamposDoubleException extends RuntimeException
{
    public ConverterCamposDoubleException (String campo)
    {
        super("O campo [" + campo + "] requer preenchimento númerico");
    }
}
