package MainBody;

import java.awt.event.KeyEvent;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import tools.PPTRobot;

public class Receive implements Runnable {
	
	private DatagramSocket ds;
	public Receive(DatagramSocket ds) {
		// TODO Auto-generated constructor stub
		this.ds = ds;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			int count = 0;
			float preX=0 , preY=0 , x=0 , y=0;
			float initX=0 , initY = 0;
			while(true)
			{
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				ds.receive(dp);
				String ip = dp.getAddress().getHostAddress();
				String data = new String(dp.getData(), 0 , dp.getLength());
				System.out.println(ip+":"+data);
				
				// after having received the data , change it to mouse data
				char flag = data.charAt(0);
				switch (flag)
				{
				case '1': // Left Single Click
					PPTRobot.mouseLeftSingleClick();
					break;
				case '2': // Right Single Click
					PPTRobot.mouseRightSingleClick();
					break;
				case '3': // Play PPT From The First Slide
					PPTRobot.keyOnePressed(KeyEvent.VK_F5);
					break;
				case '4': // Play PPT From Current Slide
					PPTRobot.keyTwoPressed(KeyEvent.VK_SHIFT, KeyEvent.VK_F5);
					break;
				case '5': // Next Slide
					PPTRobot.keyOnePressed(KeyEvent.VK_DOWN);
					break;
				case '6': // Previous Slide
					PPTRobot.keyOnePressed(KeyEvent.VK_UP);
					break;
				case '7': // Pen
					PPTRobot.keyTwoPressed(KeyEvent.VK_CONTROL, KeyEvent.VK_P);
					break;
				case '8': // Laser Pen
					PPTRobot.keyTwoPressed(KeyEvent.VK_CONTROL, KeyEvent.VK_L);
					break;
				
				case '9'://ESC
					PPTRobot.keyOnePressed(KeyEvent.VK_ESCAPE);
					break;
				
				case 'a': // Gravity control
//					if(count == 0)
//					{
//						String[] preAcc = data.split(",");
//						preX = new Float(preAcc[1]);
//						preY = new Float(preAcc[2]);
//						count ++;
//					}
//					else {
//						String[] acc = data.split(",");
//						x = new Float(acc[1]);
//						y = new Float(acc[2]);
//						PPTRobot.mouseMoveRelatively((int)(x-preX)*5, (int)(y-preY)*5);
//						System.out.println((int)(x-preX)+"-----"+(int)(y-preY));
//						count = 0;
//					}
					
					String[] acc = data.split(",");
					x = new Float(acc[1]);
					y = new Float(acc[2]);
					PPTRobot.mouseMoveRelatively(
							(int)((x-initX)*0.9 ), 
							(int)((y-initY)*0.9 )
							);
				//	System.out.println((int)(x-initX)+"---"+ (int)(y-initY));
					break;
					
				case 'b':
					String[] angle = data.split(",");
					initX = new Float(angle[1]);
					initY = new Float(angle[2]);
					break;
					
				case 'c':
					String[] v = data.split(",");
					float vX = new Float(v[1]);
					float vY = new Float(v[2]);
					System.out.println("vX="+vX+",vY="+vY);
					PPTRobot.mouseMoveRelatively((int)vX, (int)vY);
					
					break;
				
				default : System.out.println("Information can't be decoded");
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getClass().toString());
			throw new RuntimeException("接收异常");
		}

	}

}
