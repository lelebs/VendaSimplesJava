/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Exception.CampoValorZeroException;
import Exception.CampoVazioException;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import Exception.ConverterCamposDoubleException;
import Exception.LimiteCampoException;

/**
 *
 * @author Leandro
 */
public class ConverterCamposHelper {
    public static double converterDouble(String campo, String valorStr)
    {
        double valor = 0.0;
        try
        {
            valor = Double.parseDouble(valorStr.replace(',', '.'));
        }
        
        catch(NumberFormatException ex)
        {
            throw new ConverterCamposDoubleException(campo);
        }
        
        return valor;
    }
    
    public static void validarMaiorQue(String campo, String valor, double limite)
    {
        if (valor.length() > limite)
        {
            throw new LimiteCampoException(limite, campo);
        }
    }
    
    public static void validarCampoVazio(String campo, String valor)
    {
        if("".equals(valor))
        {
            throw new CampoVazioException(campo);
        }
    }
    
    public static void validarCampoValorZero(String campo, double valor, double limite)
    {
        if ( valor < limite)
        {
            throw new CampoValorZeroException(campo);
        }
    }
}
