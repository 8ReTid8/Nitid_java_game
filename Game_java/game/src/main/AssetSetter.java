//package main;
//import java.util.Random;
//import object.OBJ_Key;
//public class AssetSetter {
//	
//	GamePanel gp;
//	Random random; 
//	public AssetSetter(GamePanel gp) {
//		this.gp = gp;
//		random = new Random();
//	}
//	
//	public void setObject() {
//		gp.obj[0] = new OBJ_Key();
////		gp.obj[0].worldX = random.nextInt((int)((gp.screenwidth)/gp.tilesize))*gp.tilesize;
////		gp.obj[0].worldY = random.nextInt((int)((gp.screenheight)/gp.tilesize))*gp.tilesize;
//		gp.obj[0].worldX = (1 + random.nextInt((int)(gp.maxscreencol - 2)))*gp.tilesize;  // Random x coordinate between 1 and gp.maxscreencol-2
//		gp.obj[0].worldY = (1 + random.nextInt((int)(gp.maxscreenrow - 2)))*gp.tilesize;	// Random y coordinate between 1 and gp.maxscreenrow-2
//	}
//	
//}
