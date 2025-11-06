package javaHomework.hw1028;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class FlowLayoutWindows {
	
	private JFrame frame = new JFrame();
	private JLabel jScore = new JLabel("score: 0");
	
	private int numberOfButton = 50;
	private int nowNumber = 0;
	private int score = 0;
	
	public FlowLayoutWindows() {
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLayout(new FlowLayout());
		
		for(int i = 0; i < numberOfButton; ++i) {
			JButton button = new JButton("" + i);
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(button.getText().equals(String.valueOf(nowNumber))) {
						score++;
						jScore.setText("score: " + score);
					}
				}
			});
			
			Thread threadL = new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						while(true) {
							Thread.sleep(10);
							if(button.getText().equals(String.valueOf(nowNumber))) {
								button.setBackground(Color.yellow);
							} else {
								button.setBackground(Color.gray);
							}
						}
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			});
			frame.add(button);
			threadL.start();
		}
		
		frame.add(jScore);
		
		frame.setVisible(true);
		gameStart();
	}
	
	public void gameStart() {
		
		Thread mouse = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while(true) {
						nowNumber = new Random().nextInt(numberOfButton);
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		mouse.start();
	}

	public static void main(String[] args) {
		new FlowLayoutWindows();
	}

}