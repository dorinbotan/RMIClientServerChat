package Server;

import java.rmi.*;

import CommonObjects.User;

public interface ServerRemoteInterface extends Remote
{
   public void registerClient(User user) throws RemoteException;

   public void removeClient(User client) throws RemoteException;

   public void broadcastMessage(String msg) throws RemoteException;
}
