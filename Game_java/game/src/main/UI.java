package main;

import java.awt.Color;
import java.io.File;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import object.OBJ_Key;
//import java.awt.GraphicsEnvironment;

public class UI {
	GamePanel gp;
	Graphics2D g2;
	Font font;
	int x;
	BufferedImage starImage;
	public int commandNum = 0;
//	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//	Font customFont = Font.createFont(Font.TRUETYPE_FONT, new java.io.File("/font/Silkscreen-Regular.ttf"));
	
	public UI(GamePanel gp) {
		this.gp = gp;
		font = new Font("Arial",Font.PLAIN,40);
		OBJ_Key star = new OBJ_Key(gp); 
		starImage = star.image ;
		try {
			Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/font/Silkscreen-Regular.ttf"));
			font = customFont.deriveFont(Font.PLAIN, 40);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		g2.setFont(font);
		g2.setColor(Color.white);
		if(gp.gamestate == gp.titlestate) {
			drawTitlescreen();
		}
		else {
			drawstarcout();
		}	
	}
	public void drawstarcout() {
		g2.drawImage(starImage, gp.tilesize/2, gp.tilesize/8, gp.tilesize-12, gp.tilesize-12, null);
		g2.drawString(":"+gp.player.hasStar,110-24,42);
	}
	public void drawTitlescreen() {
		g2.setFont(g2.getFont().deriveFont(64f));
		g2.setColor(Color.white);
		String text = "Endless Bound";
		x = getXcenter(text);
		g2.drawString(text, x, 70);
		
		
		g2.setFont(g2.getFont().deriveFont(40f));
		//start
		text = "start";
		x = getXcenter(text);
		g2.drawString(text,x, 150);
		if(commandNum == 0) {
			g2.drawString("?",x-gp.tilesize,150);
		}
		
		//exit
		text = "exit";
		x = getXcenter(text);
		g2.drawString(text,x, 200);
		if(commandNum == 1) {
			g2.drawString("?",x-gp.tilesize,200);
		}
	}
	public int getXcenter(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
		int x = gp.screenwidth/2-length/2;
		return x;
	}
}
