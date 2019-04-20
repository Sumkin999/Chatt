package Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client 
{
	private DatagramSocket dataGramSocket;
	private InetAddress inetAdress;
	private int port;
	
	
	public Client(String adres,int _port) 
	{
		try 
		{
			inetAdress=InetAddress.getByName(adres);
			port=_port;
			
			dataGramSocket=new DatagramSocket();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		Send("\\con:Me");
	}
	
	public void Send(String message)
	{
		message+="\\e";
		byte[] data=message.getBytes();
		DatagramPacket datagramPacket=new DatagramPacket(data, data.length,inetAdress,port);
		try 
		{
			dataGramSocket.send(datagramPacket);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Send Message To "+inetAdress.getHostAddress()+" "+port);
		
	}
}
