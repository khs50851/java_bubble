package bubble.test.ex06;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame{
	
	private JLabel backgroundMap;
	private Player player;
	
	
	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}
	
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMapService.png"));
//		backgroundMap.setSize(100,100);
//		backgroundMap.setLocation(300,300);
//		backgroundMap.setSize(1000,600);
//		add(backgroundMap); // JFrame에 JLabel이 그려짐
		setContentPane(backgroundMap);
		
		player = new Player();
		add(player);		
	}
	
	private void initSetting() {
		setSize(1000,640);
		setLocationRelativeTo(null); // JFrame 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼으로 창을 끌 때 JVM도 같이 종료
	}
	
	private void initListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) { // 키보드 클릭 이벤트 핸들러
				// System.out.println(e.getKeyCode());
				
				switch(e.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						if(!player.isLeft()) {
							player.left();
						}
						break;
					case KeyEvent.VK_RIGHT:
						if(!player.isRight()) {
							player.right();
						}
						break;
					case KeyEvent.VK_UP:
						if(!player.isUp() && !player.isDown()) {
							player.up();
							
						}
						break;
				}
			}
			
			// 키보드 해제 이벤트 핸들러
			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				
				}
			}
			
		});
	}
	
	public static void main(String[] args) {
		
		new BubbleFrame();
		
		
	}
}
