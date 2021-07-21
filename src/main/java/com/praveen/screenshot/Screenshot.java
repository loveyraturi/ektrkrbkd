package com.praveen.screenshot;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Screenshot {
	public static void main(String[] args) {
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	    try {
	    	BufferedImage capture = new Robot().createScreenCapture(screenRect);
	    	ImageIO.write(capture, "bmp", new File("/Users/praveenraturi/Desktop/screenshot/abc.jpg"));
//			BufferedImage image = ImageIO.read(new File("/Users/al/some-picture.jpg"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
