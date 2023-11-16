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
    private final List<JComponent> componentes;
    private final int altura;
    private final int largura;

    private Tela(int altura, int largura) {
        // Criando a tela
        JFrame jFrame = new JFrame();
        this.altura = altura;
        this.largura = largura;
        setSize(largura, altura);
        setTitle("Plataforma de Turismo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        this.componentes = new ArrayList<>();



        // Criando botão de login
        BotaoLogin botaoLogin = BotaoLogin.getInstance(largura, arialTitulo);
        componentes.add(botaoLogin.getBotaoLogin());
        botaoLogin.getBotaoLogin().addActionListener(this);

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

        // Criando opção de se registrar
        JLabel cadastro = new JLabel("Ainda não se cadastrou?");
        cadastro.setBounds(largura/2 + 200, 270, 230, 50);
        cadastro.setFont(arial);
        componentes.add(cadastro);


        JButton cadastroBotao = new JButton("Cadastre-se");
        cadastroBotao.setBounds(largura/2 + 230, 310, 150, 40);
        cadastroBotao.setForeground(new Color(239, 243, 239));
        cadastroBotao.setBackground(new Color(78, 162, 204));
        cadastroBotao.setFont(arial);
        componentes.add(cadastroBotao);
        cadastroBotao.addActionListener(this::cadastrar);

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
    // Botões
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "funciona!", "Titulo", JOptionPane.WARNING_MESSAGE);
        this.getContentPane().removeAll();
        this.repaint();
    }

    private void cadastrar(ActionEvent actionEvent) {
        this.getContentPane().removeAll();
        this.repaint();
        componentes.remove(0);
        componentes.remove(componentes.size()-1);
        componentes.remove(componentes.size()-1);

        // Criando um campo de confirmação de senha
        JLabel confirmacaoSenhaLabel = new JLabel("Confirmação de senha:");
        confirmacaoSenhaLabel.setBounds(largura/2 - 100, 410, 300, 50);
        confirmacaoSenhaLabel.setFont(arial);
        componentes.add(confirmacaoSenhaLabel);

        JTextField confirmacaoSenha = new JTextField();
        confirmacaoSenha.setBounds(largura/2 - 100, 450, 200, 30);
        confirmacaoSenha.setFont(arial);
        componentes.add(confirmacaoSenha);

        // Botão de criar registro
        BotaoRegistrar botaoRegistrar = BotaoRegistrar.getInstance(largura, arialTitulo);
        componentes.add(botaoRegistrar.getBotaoRegistrar());
        botaoRegistrar.getBotaoRegistrar().addActionListener(this::criarRegistro);



        // Adicionando os componentes da tela
        for (JComponent componente : componentes){
            System.out.println(componente);
            add(componente);
        }
    }

    private void criarRegistro(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null, "Registro realizado com sucesso!", "Titulo", JOptionPane.INFORMATION_MESSAGE);
    }
}
