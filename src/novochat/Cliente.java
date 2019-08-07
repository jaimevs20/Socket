package novochat;

import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Marcos e Jaime
 */
public class Cliente extends View {

    public Cliente() throws IOException {
        super();
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        new View();
        
        Socket socketCleison;
        Socket socketCamilo;
        Socket socketJr;
        Socket socketMarlon;
        
        while (true) {
           try {
                socketCleison = new Socket("192.168.43.202", 5555);
                InputStream in = socketCleison.getInputStream();
                Scanner ler = new Scanner(in);
                View.txtAreaTexto.append("Cleison - " + socketCleison.getInetAddress().getHostAddress() + ": "
                        + ler.nextLine() + "\n");

                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                }    
            }
           catch (ConnectException e) {
            } catch (NoSuchElementException e) {
            }
            
            try {
                socketCamilo = new Socket("192.168.43.183", 5559);
                InputStream in = socketCamilo.getInputStream();
                Scanner ler = new Scanner(in);
                View.txtAreaTexto.append("Camilo - " + socketCamilo.getInetAddress().getHostAddress() + ": "
                        + ler.nextLine() + "\n");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            } catch (ConnectException e) {
            }catch (NoSuchElementException e) {
            }

            try {
                socketMarlon = new Socket("192.168.43.235", 5558);
                InputStream in = socketMarlon.getInputStream();
                Scanner ler = new Scanner(in);
                View.txtAreaTexto.append("Marlon - " + socketMarlon.getInetAddress().getHostAddress() + ": "
                        + ler.nextLine() + "\n");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            } catch (ConnectException e) {
            } catch (NoSuchElementException e) {
            }

            try {
                socketJr = new Socket("192.168.43.221", 5565);
                InputStream in = socketJr.getInputStream();
                Scanner ler = new Scanner(in);
                View.txtAreaTexto.append("Jr/Murilo - " + socketJr.getInetAddress().getHostAddress() + ": "
                        + ler.nextLine() + "\n");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            } catch (ConnectException e) {
            } catch (NoSuchElementException e) {
            }
        }
    }
}
