package monster;


import static util.constant.Confix.tilesize;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class MON_Piramid extends Entity{
	
	GamePanel gp;
	

	public MON_Piramid(GamePanel gp) {
		this.gp = gp;
		speed = 1;
		solidArea = new Rectangle();
		solidArea.x = 14;
		solidArea.y = 0;
		solidArea.width = 35;
		solidArea.height = 64;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		getImage();
		setDefaultValues();
	}
	private void drawHitbox(Graphics2D g) {
        g.setColor(Color.RED);
        g.drawRect(x + (int) solidArea.x, y + (int) solidArea.y, (int) solidArea.width, (int) solidArea.height);
    }
	public void setDefaultValues() {
		x = (1*gp.tilesize);
		y = (1*gp.tilesize);
		speed = 4;
		imagedirection = "move";
	}
	public void getImage() {
		try {
			walkL1 = ImageIO.read(getClass().getResourceAsStream("/monster/enemy1.png"));
			walkL2 = ImageIO.read(getClass().getResourceAsStream("/monster/enemy2.png"));
			walkL3 = ImageIO.read(getClass().getResourceAsStream("/monster/enemy3.png"));
			walkL4 = ImageIO.read(getClass().getResourceAsStream("/monster/enemy4.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void setAction() {
		actioncounter ++;
		if(actioncounter==120) {
			Random random = new Random();
			int i = random.nextInt(100)+1;
			if(i<=25) {
				direction = "up";
			}
			if(i >25 && i<=50) {
				direction = "down";
			}
			if(i >50 && i<=75) {
				direction = "down";
			}
			if(i >75 && i<=100) {
				direction = "down";
			}
		}
	}
	public void update() {
		int X=0;
		int Y=0;
//			if(keyH.upPressed == true) {
//				direction = "up";
//				Y -= speed;
//				if(imagedirection=="stayL") {
//					imagedirection = "left";
//				}
//				if(imagedirection=="stayR") {
//					imagedirection = "right";
//				}
//				
//			}
//			if(keyH.downPressed == true) {
//				direction = "down";
//				Y += speed;
//				if(imagedirection=="stayL") {
//					imagedirection = "left";
//				}
//				if(imagedirection=="stayR") {
//					imagedirection = "right";
//				}
//				
//			}
//			if(keyH.leftPressed == true) {
//				direction = "left";
//				X -= speed;
//				imagedirection = "left";
//				
//			}
//			if(keyH.rightPressed == true) {
//				direction = "right";
//				X += speed;
//				imagedirection = "right";
//				
//			}
			
			
//			collisionOn = false;
//			gp.cChecker.checkTile(this);
//			
//			//if collision is false can move
//			if(collisionOn == false) {
//				x += X;
//				y += Y;
//			}
			
			spriteCounter++;
			if(spriteCounter > 10) {
				if(spriteNum == 1) {
					spriteNum++;
				}
				else if(spriteNum == 2) {
					spriteNum++;
				}
				else if(spriteNum == 3) {
					spriteNum++;
				}
				else if(spriteNum == 4) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		
	}
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		
		switch(imagedirection) {
		case "move":
			if(spriteNum == 1) {
				image = walkL1;
			}
			if(spriteNum == 2) {
				image = walkL2;
			}
			if(spriteNum == 3) {
				image = walkL3;
			}
			if(spriteNum == 4) {
				image = walkL4;
			}
			break;
		}
		g2.drawImage(image,x,y,tilesize,tilesize,null);
		drawHitbox(g2);
	}
}
