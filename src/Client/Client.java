package Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import Server.ClientInfo;
import Server.Server;

public class Client 
{
	private DatagramSocket dataGramSocket;
	private InetAddress inetAdress;
	private int port;
	
	private boolean isServerRunning;
	
	
	
	public Client(String name,String adres,int _port) 
	{
		try 
		{
			inetAdress=InetAddress.getByName(adres);
			port=_port;
			
			
			
			
			dataGramSocket=new DatagramSocket();
			Send("\\con:"+name);
			
			
			isServerRunning=true;
			Listen();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	
	private void Listen()
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
						//if(!IsComand(message,packet))
						{
							//PRINT MESSAGE
							VlientWindowAgain.PrintMessageToConsole(message);
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
	private boolean IsComand(String message,DatagramPacket datagrampacket)
	{
		if(message.startsWith("\\com:"))
		{
			
			
			return true;
			
		}
			
		
		
		return false;
	}
	
	
	
	
	public void Send(String message)
	{
		
		try 
		{
			message+="\\e";
			byte[] data=message.getBytes();
			DatagramPacket datagramPacket=new DatagramPacket(data, data.length,inetAdress,port);
			dataGramSocket.send(datagramPacket);
			System.out.println("Send Message To "+inetAdress.getHostAddress()+" "+port);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
