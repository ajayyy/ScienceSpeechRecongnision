package com.ajayinkingston.speechrecongnision;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Main {
	
	ArrayList<Integer> oData = new ArrayList<>();
	ArrayList<Integer> mData = new ArrayList<>();
	ArrayList<Integer> sData = new ArrayList<>();
	ArrayList<Integer> gData = new ArrayList<>();
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		
		//O data
		for(int i=0;i<3;i++) {
			BufferedImage dataImage = null;
			try {
				dataImage = ImageIO.read(Main.class.getResourceAsStream("/data/O" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			int width = dataImage.getWidth();
			int height = dataImage.getHeight();
			
			for(int x = 0; x < width; x++) {
				//133 is the point where the screenshot contains UI elements
				for(int y = 133; y < height; y++) {
					if(dataImage.getRGB(x, y) == Color.WHITE.getRGB()) {
						oData.add(y);
						break;
					}
				}
			}
		}
		
		//M data
		for(int i=0;i<3;i++) {
			BufferedImage dataImage = null;
			try {
				dataImage = ImageIO.read(Main.class.getResourceAsStream("/data/M" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			int width = dataImage.getWidth();
			int height = dataImage.getHeight();
			
			for(int x = 0; x < width; x++) {
				//133 is the point where the screenshot contains UI elements
				for(int y = 133; y < height; y++) {
					if(dataImage.getRGB(x, y) == Color.WHITE.getRGB()) {
						mData.add(y);
						break;
					}
				}
			}
		}
		
		//S data
		for(int i=0;i<3;i++) {
			BufferedImage dataImage = null;
			try {
				dataImage = ImageIO.read(Main.class.getResourceAsStream("/data/S" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			int width = dataImage.getWidth();
			int height = dataImage.getHeight();
			
			for(int x = 0; x < width; x++) {
				//133 is the point where the screenshot contains UI elements
				for(int y = 133; y < height; y++) {
					if(dataImage.getRGB(x, y) == Color.WHITE.getRGB()) {
						sData.add(y);
						break;
					}
				}
			}
		}
				
		//G data
		for(int i=0;i<3;i++) {
			BufferedImage dataImage = null;
			try {
				dataImage = ImageIO.read(Main.class.getResourceAsStream("/data/G" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			int width = dataImage.getWidth();
			int height = dataImage.getHeight();
			
			for(int x = 0; x < width; x++) {
				//133 is the point where the screenshot contains UI elements
				for(int y = 133; y < height; y++) {
					if(dataImage.getRGB(x, y) == Color.WHITE.getRGB()) {
						gData.add(y);
						break;
					}
				}
			}
		}
		
		
		//Input data
		ArrayList<Integer> inputData = new ArrayList<>();
			
		BufferedImage dataImage = null;
		try {
			dataImage = ImageIO.read(new File("./data.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int width = dataImage.getWidth();
		int height = dataImage.getHeight();
		
		for(int x = 0; x < width; x++) {
			//133 is the point where the screenshot contains UI elements
			for(int y = 133; y < height; y++) {
				if(dataImage.getRGB(x, y) == Color.WHITE.getRGB()) {
					inputData.add(y);
					break;
				}
			}
		}
		
		int oDifference = 0;
		int mDifference = 0;
		int sDifference = 0;
		int gDifference = 0;
		
		for(int i=0;i<inputData.size();i++) {
			oDifference += Math.abs(oData.get(i) - inputData.get(i));
			mDifference += Math.abs(mData.get(i) - inputData.get(i));
			sDifference += Math.abs(sData.get(i) - inputData.get(i));
			gDifference += Math.abs(gData.get(i) - inputData.get(i));
		}
		
		System.out.println("Chances of this being for different letters (lower is better):\n");
		
		System.out.println("Chance of this being an O: " + oDifference);
		System.out.println("Chance of this being an M: " + mDifference);
		System.out.println("Chance of this being an S: " + sDifference);
		System.out.println("Chance of this being an G: " + gDifference);

		
	}
}
