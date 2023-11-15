package interfaceGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public final class Tela extends JFrame implements ActionListener {
    // Parâmetros básicos
    Font arialTitulo = new Font("Arial", Font.BOLD, 40);
    Font arial = new Font("Arial", Font.PLAIN, 20);
    private static Tela instancia;

    private Tela(int altura, int largura) {
        // Criando a tela
        JFrame jFrame = new JFrame();
        setSize(largura, altura);
        setTitle("Plataforma de Turismo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        List<JComponent> componentes = new ArrayList<>();



        // Criando um botão
        JButton botaoLogin = new JButton("Login");
        botaoLogin.setBounds(largura/2 - 130, 450, 250, 70);
        botaoLogin.setForeground(new Color(239, 243, 239));
        botaoLogin.setBackground(new Color(78, 162, 204));
        botaoLogin.setFont(arialTitulo);
        componentes.add(botaoLogin);

        botaoLogin.addActionListener(this);

        // Criando campo de email
        JTextField email = new JTextField();
        email.setBounds(largura/2 - 100, 250, 200, 30);
        email.setFont(arial);
        componentes.add(email);


        JLabel emailLabel = new JLabel("E-mail:");
        emailLabel.setBounds(largura/2 - 100, 210, 200, 50);
        emailLabel.setFont(arial);
        componentes.add(emailLabel);

        // Criando um campo de senha
        JTextField senha = new JTextField();
        senha.setBounds(largura/2 - 100, 350, 200, 30);
        senha.setFont(arial);
        componentes.add(senha);


        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(largura/2 - 100, 310, 200, 50);
        senhaLabel.setFont(arial);
        componentes.add(senhaLabel);

        // Adicionando os componentes da tela
        for (JComponent componente : componentes){
            System.out.println(componente);
            add(componente);
        }

        setVisible(true);
    }

    public static Tela getInstance(int altura, int largura){
        if (instancia == null){
            instancia = new Tela(altura, largura);
        }
        return instancia;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "funciona!", "Titulo", JOptionPane.WARNING_MESSAGE);
        remove(this);
    }
}
