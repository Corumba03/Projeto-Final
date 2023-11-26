package view.interfaceGrafica;

import controller.exceptions.*;
import controller.usuarios.UsuarioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Tela extends JFrame{
    // Parâmetros básicos
    Font arialTitulo = new Font("Arial", Font.BOLD, 40);
    Font arial = new Font("Arial", Font.PLAIN, 20);
    private static Tela instancia;
    private final List<JComponent> componentes;
    private final int largura;
    private final JFrame tela;
    JButton botaoCadastro;
    BotaoLogin botaoLogin;
    BotaoRegistrar botaoRegistrar;
    JTextField email;
    JLabel emailLabel;
    JPasswordField senha;
    JLabel senhaLabel;
    JPasswordField confirmacaoSenha;
    JLabel confirmacaoSenhaLabel;
    JTextField nome;
    JLabel nomeLabel;
    JTextField CPF;
    JLabel CPFLabel;

    private Tela(int altura, int largura) {
        // Criando a tela
        tela = new JFrame();
        this.largura = largura;
        setSize(largura, altura);
        setTitle("Plataforma de Turismo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        this.componentes = new ArrayList<>();

        telaLogin();
    }

    public static Tela getInstance(int altura, int largura){
        if (instancia == null){
            instancia = new Tela(altura, largura);
        }
        return instancia;
    }
    private void telaLogin(){
        // Criando botão de login
        botaoLogin = BotaoLogin.getInstance(largura, arialTitulo);
        componentes.add(botaoLogin.getBotaoLogin());
        botaoLogin.getBotaoLogin().addActionListener(this::login);

        // Criando campo de email
        email = new JTextField();
        email.setBounds(largura/2 - 100, 250, 200, 40);
        componentes.add(email);


        emailLabel = new JLabel("E-mail:");
        emailLabel.setBounds(email.getX(), email.getY() - 40, 200, 50);
        componentes.add(emailLabel);

        // Criando um campo de senha
        senha = new JPasswordField();
        senha.setBounds(largura/2 - 100, 350, 200, 40);
        componentes.add(senha);


        senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(senha.getX(), senha.getY() - 40, 200, 30);
        componentes.add(senhaLabel);

        // Criando opção de se registrar
        JLabel cadastro = new JLabel("Ainda não se cadastrou?");
        cadastro.setBounds(largura/2 + 200, 270, 230, 50);
        componentes.add(cadastro);


        botaoCadastro = new JButton("Cadastre-se");
        botaoCadastro.setBounds(largura/2 + 210, 310, 210, 40);
        botaoCadastro.setForeground(new Color(239, 243, 239));
        botaoCadastro.setBackground(new Color(78, 162, 204));
        botaoCadastro.setFont(new Font("Arial", Font.BOLD, 30));
        componentes.add(botaoCadastro);
        botaoCadastro.addActionListener(this::telaCadastro);

        // Adicionando os componentes da tela
        pintarTela();

        setVisible(true);
    }

    private void login(ActionEvent actionEvent) {
        try {
            if (UsuarioController.verificaUsuario(email.getText(), Arrays.toString(senha.getPassword())) == null){
                throw new CredenciaisInvalidasException("E-mail ou senha incorretos");
            }
            JOptionPane.showMessageDialog(null, "Login realizado", "", JOptionPane.PLAIN_MESSAGE);
            tela.setVisible(false);
        } catch (CredenciaisInvalidasException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.PLAIN_MESSAGE);
            senha.setText("");
        }

    }

    private void telaCadastro(ActionEvent actionEvent) {
        this.getContentPane().removeAll();
        this.repaint();
        componentes.clear();

        // Criando campo de nome
        nome = new JTextField();
        nome.setBounds(largura/2 - 330, 200, 350, 40);
        componentes.add(nome);

        nomeLabel = new JLabel("Nome completo:");
        nomeLabel.setBounds(nome.getX(), nome.getY() - 30, 200, 30);
        componentes.add(nomeLabel);

        // Campo de CPF
        CPF = new JTextField();
        CPF.setBounds(largura/2 + 120, nome.getY(), 250, 40);
        componentes.add(CPF);

        CPFLabel = new JLabel("CPF (somente números):");
        CPFLabel.setBounds(CPF.getX(), CPF.getY() - 30, 300, 30);
        componentes.add(CPFLabel);


        // Criando campo de email
        email.setBounds(largura/2 - 330, 300, 350, 40);
        componentes.add(email);

        emailLabel.setText("Email:");
        emailLabel.setBounds(email.getX(), email.getY() - 40, 200, 50);
        componentes.add(emailLabel);

        // Campo de Login

        // Criando um campo de senha
        senha.setBounds(largura/2 - 330, 400, 250, 40);
        componentes.add(senha);

        senhaLabel.setBounds(senha.getX(), senha.getY() - 40, 200, 50);
        componentes.add(senhaLabel);

        // Criando um campo de confirmação de senha
        confirmacaoSenha = new JPasswordField();
        confirmacaoSenha.setBounds(CPF.getX(), senha.getY() , 250, 40);
        componentes.add(confirmacaoSenha);

        confirmacaoSenhaLabel = new JLabel("Confirmação de senha:");
        confirmacaoSenhaLabel.setBounds(confirmacaoSenha.getX(), confirmacaoSenha.getY() - 40, 300, 50);
        componentes.add(confirmacaoSenhaLabel);

        // Botão de criar registro
        botaoRegistrar = BotaoRegistrar.getInstance(largura, arialTitulo);
        componentes.add(botaoRegistrar.getBotaoRegistrar());
        botaoRegistrar.getBotaoRegistrar().addActionListener(this::criarRegistro);


        // Adicionando os componentes da tela
        pintarTela();
    }

    private void criarRegistro(ActionEvent actionEvent) {
        String[] usuarioEmail = email.getText().split("@");
        char[] senhaCarac = senha.getPassword();
        char[] confirmacaoSenhaCarac = confirmacaoSenha.getPassword();
        try {
            if (nome.getText().isBlank() ||
                email.getText().isBlank() ||
                CPF.getText().isBlank() ||
                senhaCarac.length == 0 ||
                confirmacaoSenhaCarac.length == 0){
                throw new CampoVazioException("Preencha todos os campos");
            }
            if (!nome.getText().contains(" ")){
                throw new NomeInvalidoException("Nome incompleto");
            }
            if(!email.getText().contains("@") || !usuarioEmail[1].equals("gmail.com")){
                throw new EmailInvalidoException("Email inválido");
            }
            if(CPF.getText().length() != 11 || !CPF.getText().matches("\\d+")){
                throw new CPFInvalidoException("CPF inválido");
            }
            if(senhaCarac.length < 8){
                throw new SenhaInvalidaException("A senha deve conter ao menos 8 caracteres");
            }
            if(!Arrays.equals(senhaCarac, confirmacaoSenhaCarac)){
                throw new SenhaIncorretaException("As senhas devem ser iguais");
            }

            UsuarioController novoUsuario = new UsuarioController(CPF.getText(), nome.getText(), senhaCarac, email.getText());
            // Criação de usuarios
            novoUsuario.cadastrarUsuario();
            JOptionPane.showMessageDialog(null, "Registro realizado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            componentes.clear();
            this.getContentPane().removeAll();
            this.repaint();
            telaLogin();
        }catch (EmailInvalidoException | CampoVazioException | CPFInvalidoException | NomeInvalidoException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
            senha.setText("");
            confirmacaoSenha.setText("");
        }catch (SenhaInvalidaException | SenhaIncorretaException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Senha inválida", JOptionPane.WARNING_MESSAGE);
            senha.setText("");
            confirmacaoSenha.setText("");
        }
    }

    private void pintarTela(){
        for (JComponent componente : componentes){
            if (!(componente instanceof JButton)){
                componente.setFont(arial);
            }
            add(componente);
        }
    }
}
