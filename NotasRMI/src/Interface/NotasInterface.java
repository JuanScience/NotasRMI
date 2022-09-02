package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

/**
 * @authors
 * Ormolgud Gonzalez Cardona
 * Juan Carlos Salazar Muñoz
 */
public interface NotasInterface extends Remote{
    public Map generate(int s, int n) throws RemoteException;
}
