package Server;

import Implement.NotasImplement;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 * @authors
 * Ormolgud Gonzalez Cardona
 * Juan Carlos Salazar Muñoz
 */
public class NotasServer {
    public static void main (String []args) throws RemoteException{
        Registry reg = LocateRegistry.createRegistry(1099);
        NotasImplement notasImplement = new NotasImplement(0,0);
        reg.rebind("Notas", notasImplement); //Definición nombre del objeto
        System.out.println("servidor iniciado");
    }
}
