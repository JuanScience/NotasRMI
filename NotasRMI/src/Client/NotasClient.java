package Client;

import Interface.NotasInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotasClient {

    public static void main(String[] args) throws IOException {
        int n1, n2, choice = 10;
        Map<String, Float> res;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {        
            try {
                System.out.println("\n********Notas de estudiantes********");
                System.out.print("\nIngrese el n\u00famero de estudiantes: ");
                n1 = Integer.parseInt(br.readLine());
                System.out.print("Ingrese el n\u00famero de notas: ");
                n2 = Integer.parseInt(br.readLine()); 
                
                NotasInterface notasinterface = (NotasInterface)Naming.lookup("Notas");
                res = notasinterface.generate(n1, n2);
                System.out.println("\nResultado:\n");
                
                res.entrySet().stream().sorted(Map.Entry.<String, Float>comparingByKey()).forEach(System.out::println);
                
                System.out.print("\nIngrese cualquier n\u00famero o 0 para salir: ");
                choice = Integer.parseInt(br.readLine()); 
                
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(NotasClient.class.getName()).log(Level.SEVERE, null, ex);                   
            }
        } while (choice != 0);
    }
}
