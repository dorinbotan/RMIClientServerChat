package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Client.ClientRemoteInterface;
import CommonObjects.User;

public class Server extends UnicastRemoteObject implements
      ServerRemoteInterface
{
   private static final long serialVersionUID = 1L;
   private ArrayList<ClientRemoteInterface> clients;

   protected Server() throws RemoteException
   {
      super();
      clients = new ArrayList<ClientRemoteInterface>();
   }

   @Override
   public void registerClient(User client) throws RemoteException
   {
      clients.add(client.getInterface());
      broadcastMessage(client.getNickName() + " connected");
   }

   @Override
   public void removeClient(User client) throws RemoteException
   {
      clients.remove(client.getInterface());
      broadcastMessage(client.getNickName() + " left.");
   }

   @Override
   public void broadcastMessage(String msg) throws RemoteException
   {
      for (int i = 0; i < clients.size(); i++)
         clients.get(i).retrieveMessage(msg);
   }

}
