package Helper;

import javax.swing.JOptionPane;

public class MostrarMensagem {
    
    public static void mostrarErroMensagem(String mensagem)
    {
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    public static void mostrarErroJanelaAberta(String valor)
    {
        mostrarErroMensagem("Já existe uma janela de [" + valor + "] aberta.");
    }
    
    public static void mostrarErroConverterDouble(String campo)
    {
        mostrarErroMensagem("O campo [" + campo +"] deve conter apenas números");
    }
    
    public static void mostrarSelecioneUmRegistro()
    {
        mostrarErroMensagem("É necessário selecionar um registro para essa operação!");
    }
}
