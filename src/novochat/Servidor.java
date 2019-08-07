package novochat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Marcos e Jaime
 */
public class Servidor {

    public static void enviarParaTodos(String msg) throws IOException {

        ArrayList<PrintWriter> clientes;
        ServerSocket server = new ServerSocket(2222);   //minha porta
        clientes = new ArrayList();
        Socket sok = null;
        PrintWriter pws = null;

        System.out.println("Aguardando conexão...");
        clientes.add(pws);

        //for (PrintWriter percorrePws : clientes) 
        for (int i = 1; i <= 4; i++) {
            sok = server.accept();
            //clientes.add(pws);
            System.out.println("Conectado : " + sok.getInetAddress().getHostAddress());

            //    pws = (PrintWriter) percorrePws;
//            pws = clientes.get(i);
            pws = new PrintWriter(sok.getOutputStream(), true);

            pws.println(msg);
        }
        server.close();
        sok.close();
    }
}
