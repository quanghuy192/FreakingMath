package com.freakingmath.huy.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

import com.freakingmath.huy.model.Quiz;
import com.freakingmath.huy.view.FinishGame;
import com.freakingmath.huy.view.MainPlayView;

public class MainPlayClient implements Runnable {

	private Socket socket;
	private ObjectInputStream in;

	private MainPlayView mainPlay;
	private ArrayList<Quiz> listQuiz;
	private boolean isPause = false;
	private int count = 0;
	private JFrame thisFrame;
	private int bestScore;

	public MainPlayClient() {
		// TODO Auto-generated constructor stub

		mainPlay = new MainPlayView();
		mainPlay.trueBtn.addActionListener(new MyActionListenner());
		mainPlay.falseBtn.addActionListener(new MyActionListenner());

		thisFrame = new JFrame();
		thisFrame.setSize(435, 680);
		thisFrame.setVisible(true);
		thisFrame.setResizable(false);
		thisFrame.setLocationRelativeTo(null);
		thisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thisFrame.getContentPane().add(mainPlay);
		readData();
		ActionPlay();
	}

	private void ActionPlay() {
		// TODO Auto-generated method stub
		Thread threadPlay = new Thread(this);
		threadPlay.start();
		mainPlay.text = listQuiz.get(count).getQuestion();
		mainPlay.repaint();
	}

	private void readData() {
		// TODO Auto-generated method stub
		listQuiz = new ArrayList<Quiz>();
		Random rand = new Random();
		int number1, number2, number3;

		for (int i = 0; i < 100; i++) {
			Quiz newQuiz = new Quiz();
			number1 = rand.nextInt(40);
			number2 = rand.nextInt(37);
			number3 = rand.nextInt(4);

			System.out.println(number1 + "---" + number2 + "---" + number3);

			String[] resultNumber = getNewQuestion(number1, number2, number3);
			if (resultNumber != null) {
				System.out.println("not null");
				newQuiz.setQuestion(resultNumber[1]);
				newQuiz.setAnswer(getNewAnswer(resultNumber, number1, number2));
			}

			listQuiz.add(newQuiz);
		}

	}

	private String getNewAnswer(String[] string, int number1, int number2) {
		// TODO Auto-generated method stub
		switch (Integer.parseInt(string[2])) {
		case 0: {
			int resultToCheck = Integer.parseInt(string[0]);
			if (resultToCheck == (number1 + number2)) {
				return "true";
			} else {
				return "false";
			}
		}
		case 1: {
			int resultToCheck = Integer.parseInt(string[0]);
			if (resultToCheck == (number1 - number2)) {
				return "true";
			} else {
				return "false";
			}
		}
		case 2: {
			int resultToCheck = Integer.parseInt(string[0]);
			if (resultToCheck == ((number1 % 10) * (number2 % 10))) {
				return "true";
			} else {
				return "false";
			}
		}
		case 3: {
			int resultToCheck = Integer.parseInt(string[0]);
			if (number1 % (number2 % 10 + 1) == 0
					&& resultToCheck == (number1 / (number2 % 10 + 1))) {
				return "true";
			} else {
				return "false";
			}
		}
		}
		return null;
	}

	private String[] getNewQuestion(int number1, int number2, int number3) {
		// TODO Auto-generated method stub
		String[] resultArray = new String[3];
		String result;
		Random random = new Random();
		int resultNumber;
		int randomResult = number1 + number2 - number3;
		switch (number3) {
		case 0: {
			if (randomResult % 2 == 0) {
				int resultFake = random.nextInt(50);
				result = String.valueOf(number1) + " + "
						+ String.valueOf(number2) + " = "
						+ String.valueOf(resultFake);
				resultArray[0] = String.valueOf(resultFake);

			} else {
				resultNumber = number1 + number2;
				result = String.valueOf(number1) + " + "
						+ String.valueOf(number2) + " = "
						+ String.valueOf(resultNumber);
				resultArray[0] = String.valueOf(resultNumber);
			}
			resultArray[1] = result;
			resultArray[2] = String.valueOf(0);
			System.out.println(result);
			return resultArray;
		}

		case 1:

			if (randomResult % 2 == 0) {
				int resultFake = random.nextInt(30);
				result = String.valueOf(number1) + " - "
						+ String.valueOf(number2) + " = "
						+ String.valueOf(resultFake);
				resultArray[0] = String.valueOf(resultFake);
			} else {
				resultNumber = number1 - number2;
				result = String.valueOf(number1) + " - "
						+ String.valueOf(number2) + " = "
						+ String.valueOf(resultNumber);
				resultArray[0] = String.valueOf(resultNumber);
			}
			resultArray[1] = result;
			resultArray[2] = String.valueOf(1);
			return resultArray;

		case 2:

			if (randomResult % 2 == 0) {
				int resultFake = random.nextInt(50);
				result = String.valueOf((number1 % 10)) + " x "
						+ String.valueOf((number2 % 10)) + " = "
						+ String.valueOf(resultFake);
				resultArray[0] = String.valueOf(resultFake);
			} else {
				resultNumber = (number1 % 10) * (number2 % 10);
				result = String.valueOf((number1 % 10)) + " x "
						+ String.valueOf((number2 % 10)) + " = "
						+ String.valueOf(resultNumber);
				resultArray[0] = String.valueOf(resultNumber);
			}
			resultArray[1] = result;
			resultArray[2] = String.valueOf(2);
			return resultArray;
		case 3:

			if (randomResult % 2 == 0) {
				int resultFake = random.nextInt(20);
				result = String.valueOf(number1) + " : "
						+ String.valueOf((number2 % 10)) + " = "
						+ String.valueOf(resultFake);
				resultArray[0] = String.valueOf(resultFake);
			} else {
				resultNumber = number1 / (number2 % 10 + 1);
				result = String.valueOf(number1) + " : "
						+ String.valueOf((number2 % 10 + 1)) + " = "
						+ String.valueOf(resultNumber);
				resultArray[0] = String.valueOf(resultNumber);
			}
			resultArray[1] = result;
			resultArray[2] = String.valueOf(3);
			return resultArray;

		default:
			break;
		}
		return null;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 29; i >= 0; i--) {
			if (isPause) {
				break;
			} else {
				mainPlay.time.setText(String.valueOf(i) + " s ");
				mainPlay.progressBar.setValue(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		if (isPause == false)
			new MyActionListenner().finish(mainPlay.scores);
	}

	private void stopGamePlay() {
		isPause = true;

	}

	public class MyActionListenner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			PlaySoundFile.playSoundButton();
			
			if (e.getSource() == mainPlay.trueBtn) {
				if (testQuiz(1)) {
					nextQuiz();
				} else {
					stopGamePlay();
					finish(mainPlay.scores);
					thisFrame.setVisible(false);
					return;
				}
			}
			if (e.getSource() == mainPlay.falseBtn) {
				if (testQuiz(0)) {
					nextQuiz();
				} else {
					stopGamePlay();
					finish(mainPlay.scores);
					thisFrame.setVisible(false);
					return;
				}
			}

		}

		public void finish(String scores) {
			// TODO Auto-generated method stub

			File file = new File("E:\\best.DAT");

			if (!file.exists()) {
				try {
					file.createNewFile();
					DataOutputStream out = new DataOutputStream(
							new FileOutputStream(file));
					out.writeUTF(String.valueOf(count));
					System.out.println(count);
					bestScore = count;
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					DataInputStream in = new DataInputStream(
							new FileInputStream(file));

					String best = in.readUTF();
					System.out.println(best);
					if (Integer.parseInt(best.trim()) <= count) {
						System.out.println("vao day");
						bestScore = count;
						file.delete();
						File newFile = new File("E:\\best.DAT");
						newFile.createNewFile();
						DataOutputStream out = new DataOutputStream(
								new FileOutputStream(newFile));
						out.writeUTF(String.valueOf(count));
						out.close();

					} else {
						bestScore = Integer.parseInt(best);
					}
					System.out.println(bestScore);
					in.close();

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			FinishGame fn = new FinishGame(scores, String.valueOf(bestScore));
			System.out.println(String.valueOf(bestScore));
			JFrame myFrame = new JFrame("Freaking Math");
			myFrame.setSize(396, 328);
			myFrame.setVisible(true);
			myFrame.setResizable(false);
			myFrame.setLocationRelativeTo(null);
			myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			myFrame.getContentPane().add(fn);
			thisFrame.setVisible(false);

		}

		private boolean testQuiz(int e) {
			// TODO Auto-generated method stub
			if ((e == 1 && listQuiz.get(count).isAnswer()
					.equalsIgnoreCase("true"))
					|| (e == 0 && listQuiz.get(count).isAnswer()
							.equalsIgnoreCase("false"))) {
				System.out.println(listQuiz.get(count).isAnswer());
				return true;
			} else {
				return false;
			}

		}

		private void nextQuiz() {
			// TODO Auto-generated method stub
			if (count >= listQuiz.size()) {
				finish(mainPlay.scores);
			} else {
				count++;
				mainPlay.text = listQuiz.get(count).getQuestion();
				mainPlay.scores = String.valueOf(count);
				mainPlay.repaint();
			}
		}

	}

	/*
	 * public static void main(String[] args) { new MainPlayClient(); }
	 */
}
