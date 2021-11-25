package bubble.test.ex08;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// 백그라운드에서 계속 관찰
public class BackgroundPlayerService implements Runnable{
	
	private BufferedImage image;
	private Player player;
	
	public BackgroundPlayerService(Player player) {
		this.player = player;
		
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Override
	public void run() {
		while(true) {
			
			// 색상 확인
			Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
			
			// -2가 나온다는건 바닥에 색깔이 없이 흰색
			int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) 
					+ image.getRGB(player.getX() + 50 -10, player.getY() + 50 + 5);
			//System.out.println("바텀 컬러 : "+bottomColor);
			
			if(bottomColor != -2) {
				//System.out.println("바텀 컬러 : "+bottomColor);
				// System.out.println("바닥에 충돌");
				
				player.setDown(false);
			}
			
			// 외벽 충돌 확인
			if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				// System.out.println("왼쪽 벽에 충돌함");
				player.setLeft(false);
				player.setLeftWallCrash(true);
			}else if(rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				// System.out.println("오른 벽에 충돌함");
				player.setRight(false);
				player.setRightWallCrash(true);
			}else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
