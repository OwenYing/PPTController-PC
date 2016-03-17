package MainBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send implements Runnable{
	private DatagramSocket ds;
	private String IP;
	public Send(DatagramSocket ds,String IP)
	{
		this.ds = ds;
		this.IP = IP;
	}
	
	public void run()
	{
		
		try {
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			
			while((line = bufr.readLine())!=null)
			{
				if("exit".equals(line))
					break;
				byte[] buf = line.getBytes();
				DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName(IP),11111);
				ds.send(dp);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Send Fail!");
		}
	}
	
}
