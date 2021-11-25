package bubble.test.ex08;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// ��׶��忡�� ��� ����
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
			
			// ���� Ȯ��
			Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
			
			// -2�� ���´ٴ°� �ٴڿ� ������ ���� ���
			int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) 
					+ image.getRGB(player.getX() + 50 -10, player.getY() + 50 + 5);
			//System.out.println("���� �÷� : "+bottomColor);
			
			if(bottomColor != -2) {
				//System.out.println("���� �÷� : "+bottomColor);
				// System.out.println("�ٴڿ� �浹");
				
				player.setDown(false);
			}
			
			// �ܺ� �浹 Ȯ��
			if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				// System.out.println("���� ���� �浹��");
				player.setLeft(false);
				player.setLeftWallCrash(true);
			}else if(rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				// System.out.println("���� ���� �浹��");
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