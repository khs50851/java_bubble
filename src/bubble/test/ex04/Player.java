package bubble.test.ex04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player extends JLabel implements Moveable {
	// 위치
	private int x;
	private int y;
	
	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	private ImageIcon playerR, playerL;

	public Player() {

		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 55;
		y = 535;
		
		left = false;
		right = false;
		up = false;
		down = false;
		
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	@Override
	public void left() {
		System.out.println("left");
		left = true;
		new Thread(()->{
			while(left) {
				setIcon(playerL);
				x = x-1;
				setLocation(x,y);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
	}

	@Override
	public void right() {
		System.out.println("right 스레드 생성");
		right = true;
		new Thread(()->{
			while(right) {
				setIcon(playerR);
				x = x+1;
				setLocation(x,y);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
	}

	@Override
	public void up() {
		System.out.println("점프");
	}

	@Override
	public void down() {

	}

}
