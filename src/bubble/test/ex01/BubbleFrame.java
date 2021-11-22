package bubble.test.ex01;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;

public class BubbleFrame extends JFrame{
	private JTextField textField;

	public BubbleFrame() {
		
		setSize(1000,640);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(138, 131, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		setVisible(true); // 그림을 그림
	}
	
	public static void main(String[] args) {
		
		new BubbleFrame();
		
	}
}
