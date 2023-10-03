package util;

public class constant {
	public static class Confix {
		public static final int originaltilesize = 16;//32x32 
		public static final int scale = 4;
		public static final int tilesize = originaltilesize * scale;//64x64 tile
		public static final int maxscreencol = 16;
		public static final int maxscreenrow = 12;
		public static final int screenwidth = tilesize*maxscreencol;//768 pixel
		public static final int screenheight = tilesize*maxscreenrow;// 576 pixel
	}
}
