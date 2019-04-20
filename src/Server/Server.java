package Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class Server 
{
	private static DatagramSocket dataGramSocket;

	private static boolean isServerRunning;
	
	private static ArrayList<ClientInfo> clientsList=new ArrayList<ClientInfo>();
	
	//WTF???
	private static int clientId;
	//initialize server
	public static void StartServer(int port)
	{
		try
		{
			dataGramSocket=new DatagramSocket(port);
			
			isServerRunning=true;
			//Socket do not receive!
			Listen();
			
			System.out.println("Server started In port "+port);
			
			
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
	}
	
	//Send messages to all client connected to this server
	public static void Broadcast(String message)
	{
		for(ClientInfo clientInfo :clientsList)
		{
			Send(message,clientInfo.GetInetAdress(),clientInfo.GetPort());
		}
	}
	
	//send message to client
	private static void Send(String message,InetAddress adressclient,int port)
	{
		try
		{
			message+="\\e";
			byte[] data=message.getBytes();
			DatagramPacket datagramPacket=new DatagramPacket(data, data.length,adressclient,port);
			dataGramSocket.send(datagramPacket);
			
			System.out.println("Send Message To "+adressclient.getHostAddress()+" "+port);
			
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
	}
	
	//running when server running (?)
	private static void Listen()
	{
		//Not Block Main Thread!
		Thread listenThread=new Thread("Chat Program Listener")
		{
			public void run()
			{
				try
				{
					while(isServerRunning)
					{
						byte[] data=new byte[1024];
						DatagramPacket packet = new DatagramPacket(data,data.length);
						
						dataGramSocket.receive(packet);
						
						String message=new String(data);
						message=message.substring(0, message.indexOf("\\e"));
						
						//e is end of message
						//MANAGE MESSAGE
						if(!IsComand(message,packet))
						{
							Broadcast(message);
						}
						
					}
				}
				catch(Exception exc)
				{
					exc.printStackTrace();
				}
			}
		};
		listenThread.start();
	}
	
	/*
	 * Server commands:
	 * 
	 * \\con:(name)
	 * connects client to server
	 * 
	 * \\dis:(id)
	 * disconect client from server
	 * 
	 * 
	 * 
	 */
	
	//WTF? Client start code in Is method?
	private static boolean IsComand(String message,DatagramPacket datagrampacket)
	{
		if(message.startsWith("\\con:"))
		{
			String _name=message.substring(message.indexOf(":")+1);
			clientsList.add(new ClientInfo(_name, clientId++, datagrampacket.getAddress(), datagrampacket.getPort()));
			
			Broadcast("User "+_name+" connected!");
			
			return true;
			
		}
			
		
		
		return false;
	}
	//shut down server method
	public static void StopServer()
	{
		isServerRunning=false;
	}

}
