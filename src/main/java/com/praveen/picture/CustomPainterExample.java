package com.praveen.picture;

import com.teamdev.jxcapture.CompressionQuality;
import com.teamdev.jxcapture.ImageCapture;
import com.teamdev.jxcapture.image.ImageFormat;
import com.teamdev.jxcapture.video.FullScreen;

import javax.swing.*;

import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.IplImage;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import org.bytedeco.javacv.Frame;

public class CustomPainterExample {
    public static void main(String[] args) throws Exception {
    	FrameGrabber grabber = new OpenCVFrameGrabber(0);
    	grabber.start();
    	Frame frame = grabber.grab();
    	OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
    	IplImage img = converter.convert(frame);
    	opencv_imgcodecs.cvSaveImage("/Users/praveenraturi/Desktop/screenshot/selfie.jpg", img);
    }
}
