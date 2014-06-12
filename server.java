import java.net.*;
import java.io.*;

public class server extends Thread
{
   private ServerSocket serverSocket;
   
   public server(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(5000);
   }

   public void run()
   {
      while(true)
      {
         try
         {
            System.out.println("Waiting for client on port " +
            serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
	        String message="";
	        DataInputStream in = new DataInputStream(server.getInputStream());
		DataOutputStream out =  new DataOutputStream(server.getOutputStream());
	System.out.println("connected\n\n");
	while(true)
	{ 
	  System.out.println(in.readUTF());
         

	InputStreamReader varName = new InputStreamReader(System.in);
	BufferedReader in1=new BufferedReader(varName);	
	message=in1.readLine();
         out.writeUTF(message);
	}
         }catch(SocketTimeoutException s)
         {
            System.out.println("Socket timed out!");
            break;
         }catch(IOException e)
         {
            e.printStackTrace();
            break;
         }
      }
   }
   public static void main(String [] args)
   {
      int port = 9000;
      try
      {
         Thread t = new server(port);
         t.start();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}

