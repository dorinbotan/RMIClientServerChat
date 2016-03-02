package Client;

import java.rmi.*;

public interface ClientRemoteInterface extends Remote
{
   public void retrieveMessage(String msg) throws RemoteException;
}
