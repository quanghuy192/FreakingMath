package com.freakingmath.huy.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.freakingmath.huy.control.PlaySoundFile;

@SuppressWarnings("serial")
public class FreakingMathView extends JPanel implements ActionListener {

	private JButton play, rate, top, register;
	private Image img;
	private ImageIcon playImg, rateImg, topImg, logoImg, registerImg;
	private JLabel logo;
	private static JFrame myFrame;

	public FreakingMathView() {
		// TODO Auto-generated constructor stub

		logoImg = new ImageIcon("logo.PNG");
	//	logoImg = new ImageIcon(FreakingMathView.class.getResource("/logo.PNG"));
		logo = new JLabel(logoImg);
		logo.setBounds(12, 100, logoImg.getIconWidth(), logoImg.getIconHeight());

		playImg = new ImageIcon("play.PNG");
	//	playImg = new ImageIcon(FreakingMathView.class.getResource("/play.PNG"));
		play = new JButton(playImg);
		setLayout(null);
		play.setBounds(92, 315, playImg.getIconWidth(), playImg.getIconHeight());
		play.addActionListener(this);

		rateImg = new ImageIcon("highscore.PNG");
	//	rateImg = new ImageIcon(FreakingMathView.class.getResource("/highscore.PNG")); 
		rate = new JButton(rateImg);
		setLayout(null);
		rate.setBounds(66, 440, rateImg.getIconWidth(), rateImg.getIconHeight());
		rate.addActionListener(this);

		topImg = new ImageIcon("rate.PNG");
	//	topImg = new ImageIcon(FreakingMathView.class.getResource("/rate.PNG"));
		top = new JButton(topImg);
		setLayout(null);
		top.setBounds(226, 440, topImg.getIconWidth(), topImg.getIconHeight());
		top.addActionListener(this);

		registerImg = new ImageIcon("login-64.PNG");
	//	registerImg = new ImageIcon(FreakingMathView.class.getResource("/login-64.PNG"));
		register = new JButton(registerImg);
		register.setBounds(350, 10, registerImg.getIconWidth(),
				registerImg.getIconHeight());
		register.addActionListener(this);

		add(logo);
		add(play);
		add(top);
		add(rate);
		add(register);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	//	PlaySoundFile.playSoundButton();

		if (e.getSource().equals(register)) {
			new UserRegisterView();
			myFrame.setVisible(false);
		}
		if (e.getSource().equals(play)) {

			MainActivity view = new MainActivity();

			JFrame myFrame = new JFrame("Freaking Math");
			myFrame.setSize(515, 435);
			myFrame.setVisible(true);
			myFrame.setResizable(false);
			myFrame.setLocationRelativeTo(null);
			myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			myFrame.getContentPane().add(view);
		}
		if (e.getSource().equals(rate)) {
			JOptionPane.showMessageDialog(this, "Coming soon !!!! =)) ");
			myFrame.setVisible(false);
		}
		if (e.getSource().equals(top)) {
			JOptionPane.showMessageDialog(this, "Coming soon !!!! =)) ");
			myFrame.setVisible(false);
		}

	}

	public static void main(String[] args) {

		// Thay doi giao dien voi lookandfeel

		try {
			UIManager
					.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		FreakingMathView fkMath = new FreakingMathView();

		myFrame = new JFrame("Freaking Math");
		myFrame.setSize(435, 680);
		myFrame.setVisible(true);
		myFrame.setResizable(false);
		myFrame.setLocationRelativeTo(null);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.getContentPane().add(fkMath);

	}

}
