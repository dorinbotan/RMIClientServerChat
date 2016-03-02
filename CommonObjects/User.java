package CommonObjects;

import java.io.Serializable;

import Client.ClientRemoteInterface;

public class User implements Serializable
{
   private String nickName;
   private ClientRemoteInterface remoteClient;

   public User(String nickName, ClientRemoteInterface client)
   {
      this.nickName = nickName;
      remoteClient = client;
   }

   public String getNickName()
   {
      return nickName;
   }

   public ClientRemoteInterface getInterface()
   {
      return remoteClient;
   }
}
