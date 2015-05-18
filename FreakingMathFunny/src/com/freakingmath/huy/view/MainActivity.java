package com.freakingmath.huy.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.freakingmath.huy.control.MainPlayClient;
import com.freakingmath.huy.control.PlaySoundFile;

public class MainActivity extends JPanel implements ActionListener {

	private JButton fight, play, cancel;
	private JLabel fightLabel, playLabel, cancelLabel;
	private ImageIcon fightImg, playImg, cancelImg;

	public MainActivity() {
		// TODO Auto-generated constructor stub

		setLayout(null);

		fightImg = new ImageIcon("fight-64.PNG");
	//	fightImg = new ImageIcon(MainActivity.class.getResource("/fight-64.PNG"));
		fight = new JButton(fightImg);
		fight.setBounds(70, 100, fightImg.getIconWidth(),
				fightImg.getIconHeight());
		fight.addActionListener(this);
		fightLabel = new JLabel("Ngẫu nhiên thách đấu");
		fightLabel.setBounds(41, 190, 150, 50);

		playImg = new ImageIcon("play-64.PNG");
	//	playImg = new ImageIcon(MainActivity.class.getResource("/play-64.PNG"));
		play = new JButton(playImg);
		play.setBounds(230, 100, playImg.getIconWidth(),
				playImg.getIconHeight());
		play.addActionListener(this);
		playLabel = new JLabel("Chơi tự kỷ");
		playLabel.setBounds(219, 190, 150, 50);

		cancelImg = new ImageIcon("cancel-64.PNG");
	//	cancelImg = new ImageIcon(MainActivity.class.getResource("/cancel-64.PNG"));
		cancel = new JButton(cancelImg);
		cancel.setBounds(370, 100, cancelImg.getIconWidth(),
				cancelImg.getIconHeight());
		cancel.addActionListener(this);
		cancelLabel = new JLabel("Thoát game");
		cancelLabel.setBounds(370, 190, 150, 50);

		add(fight);
		add(fightLabel);
		add(play);
		add(playLabel);
		add(cancel);
		add(cancelLabel);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.drawLine(10, 10, 500, 10);
		g.drawLine(10, 10, 10, 395);
		g.drawLine(10, 395, 500, 395);
		g.drawLine(500, 395, 500, 10);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub

		PlaySoundFile.playSoundButton();

		if (event.getSource().equals(fight)) {

			JOptionPane.showMessageDialog(this, "Waiting friend .....!!");

		}
		if (event.getSource().equals(play)) {

			new MainPlayClient();
		}
		if (event.getSource().equals(cancel)) {
			System.exit(0);
		}

	}

}
