//Darmes Araujo Dias
//Obs.:Caso não esteja realizando o comando dê enter após digitar e dps aperte o botão
package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.Agenda;
import main.Pessoa;
import textFilesApps.CreateTextFile;
import textFilesApps.ReadTextFile;

public class JanelaAgenda extends JFrame implements ActionListener {
    private JPanel panelLabels;
    private JPanel panelTexts;
    private JPanel panelBotoes;
    private JPanel panelBanner;

    private JLabel banner;
    private JLabel lnome;
    private JLabel lendereco;
    private JLabel ltelefone;
    private JLabel lemail;

    private JTextField nome;
    private JTextField endereco;
    private JTextField telefone;
    private JTextField email;

    private JButton botaoLimpar;
    private JButton botaoInserir;
    private JButton botaoConsultar;
    private JButton botaoApagar;

    private Agenda agenda;
    private Pessoa contato;

    public JanelaAgenda() {
        super("Agenda de contatos");
        instanciaComponentesGui();
        inicializaContatos();
        defineLayoutPanels();
        insereComponentes();
        registraHandler();
    }

    public void instanciaComponentesGui() {
        agenda = new Agenda();

        panelLabels = new JPanel();
        panelTexts = new JPanel();
        panelBotoes = new JPanel();
        panelBanner = new JPanel();

        banner = new JLabel("Agenda");

        nome = new JTextField();
        endereco = new JTextField();
        telefone = new JTextField();
        email = new JTextField();

        lnome = new JLabel("Nome :");
        lendereco = new JLabel("Endereço: ");
        ltelefone = new JLabel("Telefone: ");
        lemail = new JLabel("Email: ");

        botaoLimpar = new JButton(" Limpar ");
        botaoInserir = new JButton(" Inserir ");
        botaoConsultar = new JButton(" Consultar ");
        botaoApagar = new JButton(" Apagar ");
    }

    public void defineLayoutPanels() {
        setLayout(new BorderLayout());

        panelLabels.setLayout(new GridLayout(4, 2));
        panelTexts.setLayout(new GridLayout(4, 2));
        panelBotoes.setLayout(new GridLayout(2,3));
       
        lnome.setHorizontalAlignment(SwingConstants.RIGHT);
        lendereco.setHorizontalAlignment(SwingConstants.RIGHT);
        ltelefone.setHorizontalAlignment(SwingConstants.RIGHT);
        lemail.setHorizontalAlignment(SwingConstants.RIGHT);

    }

    public void insereComponentes() {
        add(panelLabels, BorderLayout.WEST);
        add(panelTexts, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);
        add(panelBanner, BorderLayout.NORTH);

        panelBanner.add(banner);

        panelLabels.add(lnome);
        panelLabels.add(lendereco);
        panelLabels.add(ltelefone);
        panelLabels.add(lemail);

        panelTexts.add(nome);
        panelTexts.add(endereco);
        panelTexts.add(telefone);
        panelTexts.add(email);

        panelBotoes.add(botaoInserir);
        panelBotoes.add(botaoApagar);
        panelBotoes.add(botaoLimpar);
        
        panelBotoes.add(botaoConsultar);
        
    }

    public void registraHandler() {
        botaoLimpar.addActionListener(this);
        botaoInserir.addActionListener(this);
        botaoConsultar.addActionListener(this);
        botaoApagar.addActionListener(this);
    }
    
    public void inicializaContatos(){ 
        ReadTextFile.openFile();
        HashMap<String, Pessoa> hashAux = ReadTextFile.readRecords();
        agenda.setAgenda(hashAux);
    }

    public static void main(String[] args) {
        JanelaAgenda janela = new JanelaAgenda();
        janela.setSize(450, 220);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((JButton) e.getSource()).getText().equals(" Inserir ")) {
            contato = new Pessoa(nome.getText(), endereco.getText(), telefone.getText(), email.getText());
            if (agenda.inserirContato(contato)) {
                JOptionPane.showMessageDialog(this, "Contato incluido com sucesso!", "Adicionar", JOptionPane.INFORMATION_MESSAGE);
                limparTela();
                CreateTextFile.openFile();
                agenda.gravar();
                CreateTextFile.closeFile();
            }
            else{
                JOptionPane.showMessageDialog(this, "Faltam dados para a inclusão!", "Adicionar", JOptionPane.INFORMATION_MESSAGE);
                
            }
        }
        if (((JButton) e.getSource()).getText().equals(" Consultar ")) {
            Pessoa c = agenda.pesquisar(nome.getText());
            if(c.getNome().equals("")){
                JOptionPane.showMessageDialog(this, "Contato não encontrado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                nome.setText(c.getNome());
                endereco.setText(c.getEndereco());
                telefone.setText(c.getTelefone());
                email.setText(c.getEmail());
            }
        }
        if (((JButton) e.getSource()).getText().equals(" Limpar ")) {
            limparTela();
        }
        if (((JButton) e.getSource()).getText().equals(" Apagar ")) {
            Pessoa c = agenda.pesquisar(nome.getText());
            int input = JOptionPane.showConfirmDialog(null, "Deseja apagar esse contato?: "+c.getNome());
            if(input == 0){
                agenda.apagarContato(c);
                JOptionPane.showMessageDialog(this, "Contato excluído!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                limparTela();
            }
            if(input == 2){
                limparTela();
            }
        }
    }

    public void limparTela() {
        nome.setText("");
        endereco.setText("");
        telefone.setText("");
        email.setText("");
    }

}
