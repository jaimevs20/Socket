package novochat;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static novochat.Cliente.txtAreaTexto;

/**
 *
    * @author Marcos e Jaime
 */
public class View extends JFrame implements ActionListener {

    static JTextArea txtAreaTexto = new JTextArea();
    JTextField txtMsg;
    JButton buttonEnviar;
    JButton buttonSair;
    JLabel lblHistorico;
    JLabel lblMsg;
    JPanel painel;
    JTextField textFieldIp;
    JTextField textFieldPorta;
    JTextField textFieldNome;
    String msg;

    Socket socket;
    OutputStream ou;
    Writer ouw;

    PrintWriter pw;

    public View() {
        
        textFieldNome = new JTextField("Marcos/Jaime");
        painel = new JPanel();
        txtAreaTexto = new JTextArea(15, 23);
        txtAreaTexto.setEditable(false);
        txtAreaTexto.setBackground(new Color(240, 240, 240));
        txtMsg = new JTextField(20);
        lblHistorico = new JLabel();
        lblMsg = new JLabel("Digite sua mensagem:");
        buttonEnviar = new JButton("Enviar");
        buttonEnviar.addActionListener(this);
        buttonSair = new JButton("Sair");
        buttonSair.addActionListener(this);
        JScrollPane scroll = new JScrollPane(txtAreaTexto);
        txtAreaTexto.setLineWrap(true);
        painel.add(lblHistorico);
        painel.add(scroll);
        painel.add(lblMsg);
        painel.add(txtMsg);
        painel.add(buttonSair);
        painel.add(buttonEnviar);
        painel.setBackground(Color.GREEN);
        setTitle(textFieldNome.getText());
        setContentPane(painel);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(296, 352);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonEnviar) {

            new Thread() {
                @Override
                public void run() {
                    msg = txtMsg.getText();
                    txtMsg.setText("");
                    txtAreaTexto.append("Marcos/Jaime: " + msg + "\n");
                    try {
                        Servidor.enviarParaTodos(msg);
                    } catch (IOException e) {
                    }
                }
            }.start();
        }
        
        else if (e.getSource() == buttonSair) {
            try {
                sair();
            } catch (IOException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void sair() throws IOException {
        View.this.dispose();
    }
}
