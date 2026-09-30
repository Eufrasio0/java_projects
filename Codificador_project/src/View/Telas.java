package View;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import Services.Criptografo;

public class Telas {
    private JFrame frame;
    private JPanel painel;
    private Criptografo criptografo = new Criptografo();


    public Telas() {
       
        frame = new JFrame("Criptógrafo por Dízimas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);

        ImageIcon icone = new ImageIcon("src/Imagens/enigma.jpeg");
        frame.setIconImage(icone.getImage());
        ImageIcon imagemOriginal = new ImageIcon("src/Imagens/nupose.png");

        Image imagemRedimensionada = imagemOriginal.getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH);

        JLabel fundo = new JLabel(new ImageIcon(imagemRedimensionada));
        fundo.setLayout(new GridBagLayout());

        painel = new JPanel();
        painel.setOpaque(false);

        fundo.add(painel);

        frame.setContentPane(fundo);

        TelaMenu();

        frame.setVisible(true);
    }

    public void TelaMenu() {

        painel.removeAll();

        painel.setLayout(new GridLayout(3, 1, 0, 15));
        painel.setPreferredSize(new Dimension(300, 170));

        JButton btnCodificar = new JButton("Codificar");
        JButton btnDecodificar = new JButton("Decodificar");
        JButton btnSair = new JButton("Sair do Programa");

        painel.add(btnCodificar);
        painel.add(btnDecodificar);
        painel.add(btnSair);

        btnCodificar.addActionListener(e -> telaCodificar());

        btnDecodificar.addActionListener(e -> telaDecodificar());

        btnSair.addActionListener(e -> System.exit(0));

        painel.revalidate();
        painel.repaint();
    }

    public void telaCodificar() {

        painel.removeAll();

        painel.setLayout(new GridLayout(9, 1, 0, 1));
        painel.setPreferredSize(new Dimension(350, 250));

        JLabel titulo = new JLabel("Codificar", SwingConstants.CENTER);
        titulo.setForeground(Color.BLACK);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));


        JLabel lblCodigo = new JLabel("Codigo da Mensagem");
        JTextField txtMensagem = new JTextField();

        JLabel lbltituloArq = new JLabel("titulo do arquivo");

        JTextField title = new JTextField();

        JLabel lblSenha = new JLabel("Senha");
        JButton btnExecutar = new JButton("Codificar");

        JTextField txtChave = new JTextField();

        JButton btnVoltar = new JButton("Voltar");

        painel.add(titulo);
        painel.add(lblCodigo);
        painel.add(txtMensagem);
        painel.add(lbltituloArq);
        painel.add(title);
        painel.add(lblSenha);
        painel.add(txtChave);
        painel.add(btnExecutar);
        painel.add(btnVoltar);

        btnVoltar.addActionListener(e -> TelaMenu());
        btnExecutar.addActionListener(e -> {
            String mensagem = txtMensagem.getText();
            String chave = txtChave.getText();
            JOptionPane.showMessageDialog(frame, "Mensagem codificada: " + mensagem);
            try {
                criptografo.codificar(mensagem, title.getText(), chave);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        painel.revalidate();
        painel.repaint();
    }

    public void telaDecodificar() {

        painel.removeAll();

        painel.setLayout(new GridLayout(6, 1, 0, 15));
        painel.setPreferredSize(new Dimension(350, 250));

        JLabel titulo = new JLabel("Decodificar", SwingConstants.CENTER);
        titulo.setForeground(Color.BLACK);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));

        JLabel lblSenha = new JLabel("Senha");
        JTextField txtChave = new JTextField();
        JButton btnEscolherArquivo = new JButton("Escolher Arquivo");

        JButton btnExecutar = new JButton("Decodificar");

        JButton btnVoltar = new JButton("Voltar");

        painel.add(titulo);
        painel.add(lblSenha);
        painel.add(txtChave);
        painel.add(btnEscolherArquivo);
        painel.add(btnExecutar);
        painel.add(btnVoltar);

        btnVoltar.addActionListener(e -> TelaMenu());
        btnEscolherArquivo.addActionListener(e -> {

    JFileChooser fileChooser = new JFileChooser();

    FileSystemView fsv = FileSystemView.getFileSystemView();

    for (File unidade : File.listRoots()) {

        String tipo = fsv.getSystemTypeDescription(unidade);

        if (tipo != null && tipo.toLowerCase().contains("remov")) {

            fileChooser.setCurrentDirectory(unidade);
            break;
        }
    }

    int result = fileChooser.showOpenDialog(frame);

    if (result == JFileChooser.APPROVE_OPTION) {

        File selectedFile = fileChooser.getSelectedFile();
        String caminho = selectedFile.getAbsolutePath();
        String chave = txtChave.getText();
        try {
            
            String descripto = criptografo.decodificar(caminho, chave);

            btnExecutar.addActionListener(e1 -> {
                JOptionPane.showMessageDialog(frame, "Mensagem decodificada: " + descripto);
            });
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

});

        painel.revalidate();
        painel.repaint();
    }

}