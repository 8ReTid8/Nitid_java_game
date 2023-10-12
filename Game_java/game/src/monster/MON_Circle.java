package monster;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import entity.Entity;
import entity.Player;
import main.GamePanel;

public class MON_Circle extends Entity {
    GamePanel gp;
    Player player;
    double angle = Math.toRadians(45);
    double radiusX = 10; // Adjust this value to control the width of the oval
    double radiusY = 10;  // Adjust this value to control the height of the oval
    int speedx = 20;
    int speedy = 20;
    public MON_Circle(GamePanel gp, Player player) {
        this.gp = gp;
        this.player = player;
        solidArea = new Rectangle();
        solidArea.x = 12;
		solidArea.y = 12;
        solidArea.width = 40;
        solidArea.height = 40;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        getImage();
        setDefaultValues();
    }

    private void drawHitbox(Graphics2D g) {
        g.setColor(Color.RED);
        g.drawOval(x + (int) solidArea.x, y + (int) solidArea.y, (int) solidArea.width, (int) solidArea.height);
    }

    public void setDefaultValues() {
        x = (gp.getWidth()*0);
        y = (gp.getHeight()*0);
        imagedirection = "move";
    }

    public void getImage() {
        try {
            walkL1 = ImageIO.read(getClass().getResourceAsStream("/monster/enemyC1.png"));
            walkL2 = ImageIO.read(getClass().getResourceAsStream("/monster/enemyC2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
    	 int newX = (int) (x + Math.cos(Math.PI/4)*speedx);
    	 int newY = (int) (y + Math.sin(Math.PI/4)*speedy);

    	    // Update the angle for the next frame
    	 angle += Math.toRadians(5); // Adjust this value to control the speed of the oval path

    	    // Check if the new position would go beyond the screen boundaries and adjust it
    	 if (newX < 0 || newX + solidArea.width > gp.getWidth()) {
    	     speedx = -speedx; // Reverse the x-direction when hitting left or right boundary
    	 }

    	 if (newY < 0 || newY + solidArea.height > gp.getHeight()) {
    	     speedy = -speedy; // Reverse the y-direction when hitting top or bottom boundary
    	 }

    	    // Update the monster's position
    	    x = newX;
    	    y = newY;

    	    // Ensure the monster stays within the screen boundaries
    	    x = Math.max(0, Math.min(x, gp.getWidth() - (int) solidArea.width));
            y = Math.max(0, Math.min(y, gp.getHeight() - (int) solidArea.height));

        collisionOn = false;
        // gp.cChecker.checkTile(this);
        boolean objmon = gp.cChecker.checkEntity(this, true);
        if (objmon) {
            gp.gamestate = gp.deadstate;
            System.out.println("oh");
        }

        spriteCounter++;
        if (spriteCounter > 10) {
            if (spriteNum == 1) {
                spriteNum++;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (imagedirection) {
            case "move":
                if (spriteNum == 1) {
                    image = walkL1;
                }
                if (spriteNum == 2) {
                    image = walkL2;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tilesize, gp.tilesize, null);
        drawHitbox(g2);
    }
}
