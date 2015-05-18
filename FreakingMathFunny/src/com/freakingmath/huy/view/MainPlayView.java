package com.freakingmath.huy.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class MainPlayView extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JButton trueBtn, falseBtn;
	public static ImageIcon trueImg, falseImg;
	public static String text = "";
	public static String scores = "0";
	public static JProgressBar progressBar;
	public static JLabel time;
	private final int MAX = 30;
	private final int MIN = 0;

	public MainPlayView() {
		// TODO Auto-generated constructor stub

		setLayout(null);
		setFocusable(true);
		progressBar = new JProgressBar();
		progressBar.setMaximum(MAX);
		progressBar.setMinimum(MIN);
		progressBar.setValue(MAX);
		progressBar.setBackground(Color.RED);
		progressBar.setBounds(67, 100, 300, 10);

		time = new JLabel();
		time.setForeground(Color.RED);
		time.setBounds(200, 70, 300, 10);

		trueImg = new ImageIcon("true.PNG");
	//	trueImg = new ImageIcon(MainPlayView.class.getResource("/true.PNG"));
		trueBtn = new JButton(trueImg);
		trueBtn.setBounds(30, 430, trueImg.getIconWidth(),
				trueImg.getIconHeight());
		trueBtn.addActionListener(this);

		falseImg = new ImageIcon("false.PNG");
	//	falseImg = new ImageIcon(MainPlayView.class.getResource("/false.PNG"));
		falseBtn = new JButton(falseImg);
		falseBtn.setBounds(230, 430, falseImg.getIconWidth(),
				falseImg.getIconHeight());
		falseBtn.addActionListener(this);

		add(trueBtn);
		add(falseBtn);
		add(time);
		add(progressBar);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.setFont(new Font("VNI-times", Font.BOLD, 71));
		g.drawString(text, 31, 300);
		g.setFont(new Font("VNI-times", Font.BOLD, 41));
		g.drawString(scores, 170, 170);
		g.setFont(new Font("VNI-times", Font.BOLD, 23));
		g.drawString("Scores :", 20, 170);
	}

	public void addTrueButton(ActionListener event) {
		// TODO Auto-generated method stub
		trueBtn.addActionListener(event);
	}

	public void addFalseButton(ActionListener event) {
		// TODO Auto-generated method stub
		falseBtn.addActionListener(event);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
