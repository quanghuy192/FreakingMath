package com.freakingmath.huy.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.freakingmath.huy.control.MainPlayClient;

public class FinishGame extends JPanel {

	public static ImageIcon img;
	private String scores, best;

	public FinishGame(String scores, String best) {
		// TODO Auto-generated constructor stub
		setLayout(new CardLayout());
		this.scores = scores;
		this.best = best;
	//	img = new ImageIcon("gameover.PNG");
		img = new ImageIcon(FinishGame.class.getResource("/gameover.PNG"));
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(img.getImage(), -10, -13, null);
		g.setColor(Color.RED);
		g.setFont(new Font("VNI-times", Font.BOLD, 29));
		g.drawString(scores, 290, 140);
		g.drawString(best, 290, 190);

	}

/*	public static void main(String[] args) {

		// Thay doi giao dien voi lookandfeel

		FinishGame bookView = new FinishGame();

		JFrame myFrame = new JFrame("Freaking Math");
		myFrame.setSize(img.getIconWidth() - 15, img.getIconHeight());
		System.out.println(img.getIconWidth()-15 + "--"
				+ img.getIconHeight());
		myFrame.setVisible(true);
		myFrame.setResizable(false);
		myFrame.setLocationRelativeTo(null);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.getContentPane().add(bookView);

	}*/

}
