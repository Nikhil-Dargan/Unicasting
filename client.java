import java.net.*;
import java.io.*;

public class client
{
   public static void main(String [] args)
   {
      String serverName = args[0];
      int port = Integer.parseInt(args[1]);
    InputStreamReader varName = new InputStreamReader(System.in);
	BufferedReader in1=new BufferedReader(varName);	
	String message="";
	try
      {
        
	Socket client = new Socket(serverName, port);
	while(!(message.equals("quit")))
	{
	message=in1.readLine();
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out =
                       new DataOutputStream(outToServer);
	out.writeUTF("Client: "+message);
         InputStream inFromServer = client.getInputStream();
         DataInputStream in =
                        new DataInputStream(inFromServer);
         System.out.println("Server says " + in.readUTF());
        } 
	client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}
