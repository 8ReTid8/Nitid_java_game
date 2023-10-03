package object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {
	
	public BufferedImage image;
	public String name;
	public boolean collision = true;
	public int worldX,worldY;
	public Rectangle solidArea = new Rectangle (worldX,worldY,48,48);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	
	public void draw(Graphics g2,GamePanel gp) {
		g2.drawImage(image,worldX,worldY,gp.tilesize,gp.tilesize,null);
	}
}
