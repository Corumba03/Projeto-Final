package interfaceGrafica;

import pacotesViagem.pacotes.PacoteViagem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public final class BotaoPacote extends JButton{
    private final JButton botaoPacote = new JButton();
    private PacoteViagem pacote;
    public BotaoPacote(int x, int y, PacoteViagem pacote){
        botaoPacote.setBounds(x, y, 200, 70);
        botaoPacote.setForeground(new Color(243, 242, 239));
        botaoPacote.setBackground(new Color(78, 162, 204));
        botaoPacote.setFont(Fontes.arial);

        botaoPacote.setText(pacote.getViagem().getDestino().getNome() + "   " + pacote.getPrecoBase());
        botaoPacote.addActionListener(this::paginaPacote);
    }

    private void paginaPacote(ActionEvent actionEvent) {
        Tela.telaPacote(pacote);
        JOptionPane.showMessageDialog(null, "Botão funciona", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
    }

    public JButton getBotaoPacote() {
        return botaoPacote;
    }

    public PacoteViagem getPacote() {
        return pacote;
    }

    public void setPacote(PacoteViagem pacote) {
        this.pacote = pacote;
    }
}
