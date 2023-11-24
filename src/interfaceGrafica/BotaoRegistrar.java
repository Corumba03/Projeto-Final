package interfaceGrafica;

import javax.swing.*;
import java.awt.*;

public final class BotaoRegistrar extends JButton{
    public JButton botaoRegistrar = new JButton("Registre-se");
    public static BotaoRegistrar instancia;
    private BotaoRegistrar(){
        botaoRegistrar.setBounds(Tela.largura/2 - 130, 550, 280, 70);
        botaoRegistrar.setForeground(new Color(239, 243, 239));
        botaoRegistrar.setBackground(new Color(78, 162, 204));
        botaoRegistrar.setFont(Fontes.arial);
    }

    public static BotaoRegistrar getInstance(int larguraTela, Font fonte){
        if (instancia == null){
            instancia = new BotaoRegistrar();
        }
        return instancia;
    }

    public JButton getBotaoRegistrar() {
        return botaoRegistrar;
    }
}
