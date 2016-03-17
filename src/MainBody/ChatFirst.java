package MainBody;

import java.net.DatagramSocket;

import tools.GetBroadcastAddress;

public class ChatFirst {
	public static void main(String[] args)throws Exception 
	{
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receiveSocket = new DatagramSocket(11111);
		
		String[] broadcastIP = GetBroadcastAddress.getBroadcastIP();
		System.out.println("BroadcastIP: "+ broadcastIP[0]);
		
		new Thread(new Send(sendSocket , broadcastIP[0])).start();
		new Thread(new Receive(receiveSocket)).start();
		
		
		UserInterface UI = new UserInterface();
		UI.ui();
			
		
	}
}
