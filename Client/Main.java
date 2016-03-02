package Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import Server.ServerRemoteInterface;

public class Main
{
   private static Scanner keyboard = new Scanner(System.in);

   public static void main(String[] args) throws MalformedURLException,
         RemoteException, NotBoundException
   {
      ServerRemoteInterface server = (ServerRemoteInterface) Naming
            .lookup("rmi://localhost:1099/localServer");

      System.out.print("Type in nickname: ");
      new Thread(new Client(keyboard.nextLine(), server)).start();
   }
}
