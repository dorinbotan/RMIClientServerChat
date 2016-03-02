package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import CommonObjects.User;
import Server.ServerRemoteInterface;

public class Client extends UnicastRemoteObject implements
      ClientRemoteInterface, Runnable
{
   private static final long serialVersionUID = 1L;
   private ServerRemoteInterface server;
   private User user;
   private String nick;

   protected Client(String nick, ServerRemoteInterface server)
         throws RemoteException
   {
      this.nick = nick;
      user = new User(this.nick, this);
      this.server = server;
      server.registerClient(user);
   }

   @Override
   public void retrieveMessage(String msg) throws RemoteException
   {
      System.out.println(msg);
   }

   @Override
   public void run()
   {
      Scanner keyboard = new Scanner(System.in);
      String message;

      while (true)
      {
         message = keyboard.nextLine();
         try
         {
            server.broadcastMessage(nick + " : " + message);
         }
         catch (RemoteException e)
         {
            System.out.println("Message was not sent.");
            e.printStackTrace();
         }
      }
   }

}
