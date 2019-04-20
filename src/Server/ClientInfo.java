package Server;

import java.net.InetAddress;

//Stores client information, ping , last time responded
public class ClientInfo 
{
	private InetAddress inetAdress;
	private int port;
	
	private int iD;
	private String name;
	
	public ClientInfo(String _name,int _id,InetAddress _inetAdres,int _port)
	{
		name=_name;
		iD=_id;
		inetAdress=_inetAdres;
		port=_port;
	}
	
	public InetAddress GetInetAdress()
	{
		return inetAdress;
	}
	
	public int GetPort()
	{
		return port;
	}
	
}


