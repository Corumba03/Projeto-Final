package interfaceGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public final class BotaoLogin extends JButton{
    public JButton botaoLogin = new JButton("Login");
    public static BotaoLogin instancia;
    private BotaoLogin(){
        botaoLogin.setBounds(Tela.largura/2 - 130, 450, 250, 70);
        botaoLogin.setForeground(new Color(239, 243, 239));
        botaoLogin.setBackground(new Color(78, 162, 204));
        botaoLogin.setFont(Fontes.arial);
    }

    public static BotaoLogin getInstance(Font fonte){
        if (instancia == null){
            instancia = new BotaoLogin();
        }
        return instancia;
    }

    public JButton getBotaoLogin() {
        return botaoLogin;
    }
}
