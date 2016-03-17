package tools;

import java.util.List;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class GetBroadcastAddress {

	public static String[] getBroadcastIP() throws UnknownHostException, SocketException {
		// get local IP
		InetAddress addr = InetAddress.getLocalHost();
		// get NetworkInterface by IP
		NetworkInterface ni = NetworkInterface.getByInetAddress(addr);
		List<InterfaceAddress> listAddr = ni.getInterfaceAddresses();
		
		String[] broadcast = new String[10];
		int i=0;
		for (InterfaceAddress cur : listAddr) {
			InetAddress temp = cur.getBroadcast();
			if (temp != null)
			{
				broadcast[i++] = new String(temp.getHostAddress());
			}
		}
		return broadcast;
	}

}
