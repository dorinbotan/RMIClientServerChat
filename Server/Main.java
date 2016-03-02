package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main
{
   public static void main(String[] args) throws RemoteException,
         MalformedURLException
   {
      Registry reg = LocateRegistry.createRegistry(1099);
      Naming.rebind("localServer", new Server());
   }
}
