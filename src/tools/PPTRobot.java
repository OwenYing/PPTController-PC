package tools;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;

public class PPTRobot {
	
	private static int myX;
	private static int myY;

	{
		myX = MouseInfo.getPointerInfo().getLocation().x;
		myY = MouseInfo.getPointerInfo().getLocation().y;

	}
	
	//mouse Right Single click
	public static void mouseLeftSingleClick() throws AWTException
	{
		Robot robot = new Robot();
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(10);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	//mouse left Single click
	public static void mouseRightSingleClick() throws AWTException
	{
		Robot robot = new Robot();
		robot.mousePress(InputEvent.BUTTON3_MASK);
		robot.delay(10);
		robot.mouseRelease(InputEvent.BUTTON3_MASK);
	}
	
	//mouse Right Double click
	public static void mouseRightDoubleClick() throws AWTException
	{
		Robot robot = new Robot();
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(10);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(10);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(10);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	//mouse move to (x,y)
	public static void mouseMoveXY(int x,int y) throws AWTException
	{
		Robot robot = new Robot();
		robot.mouseMove(x, y);
	}
	
	//mouse increase (delta x , delta y)
	public static void mouseMoveRelatively(int deltaX , int deltaY) throws AWTException
	{
		myX = MouseInfo.getPointerInfo().getLocation().x;
		myY = MouseInfo.getPointerInfo().getLocation().y;
		
		Robot robot = new Robot();
//		robot.mouseMove(myX+deltaX, myY+deltaY);
		
		for(int i=0 ,j = 0 ; i<Math.abs(deltaX) || j<Math.abs(deltaY) ; i++,j++)
		{
			if(i<Math.abs(deltaX))
				if(deltaX>0)
					myX++;
				else
					myX--;
			if(j<Math.abs(deltaY))
				if(deltaY>0)
					myY++;
				else
					myY--;
			
			// if the move x,y is larger than screensize , then do not move
			Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
			int screenSizeX = (int)screensize.getWidth();
			int screenSizeY = (int)screensize.getHeight();
			
			if(myX>0 && myY>0 && myX < screenSizeX && myY<screenSizeY)
				mouseMoveXY(myX, myY);
			
			robot.delay(1);
		}
		
	}
	
	//one key pressed (keyCode)
	public static void keyOnePressed(int keyCode) throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(keyCode);
		robot.keyRelease(keyCode);
	}
	
	//two key pressed (keyCode,keyCode)
	public static void keyTwoPressed(int keyCode_1 , int keyCode_2) throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(keyCode_1);
		robot.keyPress(keyCode_2);
		robot.keyRelease(keyCode_1);
		robot.keyRelease(keyCode_2);
	}
	
}
