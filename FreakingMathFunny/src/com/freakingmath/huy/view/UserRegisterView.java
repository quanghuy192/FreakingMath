package com.freakingmath.huy.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.freakingmath.huy.model.User;

@SuppressWarnings("serial")
public class UserRegisterView extends JFrame implements ActionListener {

	private JLabel email, password, name, address, phoneNumber;
	private JTextField jtextEmail, jtextName, jtextAddress, jtextPhonenumber;
	private JPasswordField jtextPassword;
	private JCheckBox checkbox;
	private JButton submit, cancel;

	public UserRegisterView() {
		// TODO Auto-generated constructor stub

		email = new JLabel("Email");
		email.setBounds(30, 50, 70, 30);
		jtextEmail = new JTextField(20);
		jtextEmail.setBounds(30, 80, 170, 30);
		password = new JLabel("Password");
		password.setBounds(30, 110, 70, 30);
		jtextPassword = new JPasswordField(20);
		jtextPassword.setBounds(30, 140, 170, 30);
		name = new JLabel("Name");
		name.setBounds(30, 170, 170, 30);
		jtextName = new JTextField(20);
		jtextName.setBounds(30, 200, 170, 30);
		address = new JLabel("Address");
		address.setBounds(30, 230, 170, 30);
		jtextAddress = new JTextField(20);
		jtextAddress.setBounds(30, 270, 170, 30);
		phoneNumber = new JLabel("Phone number");
		phoneNumber.setBounds(30, 300, 170, 30);
		jtextPhonenumber = new JTextField(20);
		jtextPhonenumber.setBounds(30, 330, 170, 30);
		checkbox = new JCheckBox("Chấp nhận các điều khoản");
		checkbox.setBounds(30, 370, 200, 30);
		submit = new JButton("Sign in");
		submit.setBounds(30, 400, 70, 30);
		submit.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.setBounds(130, 400, 70, 30);
		cancel.addActionListener(this);

		setSize(250, 550);
		setVisible(true);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(email);
		add(jtextEmail);
		add(password);
		add(jtextPassword);
		add(name);
		add(jtextName);
		add(address);
		add(jtextAddress);
		add(phoneNumber);
		add(jtextPhonenumber);
		add(checkbox);
		add(submit);
		add(cancel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// Khi click vao nut submit , KHoi tao doi tuong controler
		// truyen doi tuong user vao .

		if (e.getSource().equals(submit)) {

			if (getuser() != null)

				JOptionPane.showMessageDialog(this, "Đăng ký tốt đấy =)) !!!");
		}
		if (e.getSource().equals(cancel)) {
			this.setVisible(false);
		}
	}

	@SuppressWarnings("deprecation")
	public User getuser() {

		if (!checkAcount()) {

			JOptionPane.showMessageDialog(this, "Error !!!");
			return null;

		} else {

			// JOptionPane.showMessageDialog(this, "Successful !!!");
			User user = new User();

			user.setEmail(jtextEmail.getText());
			System.out.println(jtextEmail.getText());
			user.setPassword(jtextPassword.getText());
			System.out.println(jtextPassword.getText());
			user.setName(jtextName.getText());
			System.out.println(jtextName.getText());
			user.setAddress(jtextAddress.getText());
			System.out.println(jtextAddress.getText());
			user.setPhoneNumber(Integer.parseInt(jtextPhonenumber.getText()));
			System.out.println(jtextPhonenumber.getText());

			return user;
		}

	}

	/**
	 * @return null Kiem tra neu nguoi dung nhap thieu thong tin hoac sai
	 */
	@SuppressWarnings("deprecation")
	private boolean checkAcount() {
		// TODO Auto-generated method stub
		if (jtextEmail.getText().equals("")
				|| jtextPassword.getText().equals("")
				|| jtextName.getText().equals("")
				|| jtextAddress.getText().equals("")
				|| jtextPhonenumber.getText().equals("")
				|| checkPhonenumber(jtextPhonenumber.getText())
				|| checkMail(jtextEmail.getText()))

			return false;
		else
			return true;
	}

	/**
	 * @param email
	 * @return Kiem tra tinh hop le cua email email phai co dang abc@xyz.com
	 */
	private boolean checkMail(String email) {
		// TODO Auto-generated method stub
		String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return false;
		}
		return true;

	}

	/**
	 * @param phoneNumber
	 * @return Hop le khi kiem tra so dien thoai Chi nhan so dien thoai 10 , 11
	 *         ki tu Chi nhan so duy nhat
	 */
	private boolean checkPhonenumber(String phoneNumber) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("\\d{10}");
		Pattern pattern2 = Pattern.compile("\\d{11}");
		Matcher matcher = pattern.matcher(phoneNumber);
		Matcher matcher2 = pattern2.matcher(phoneNumber);
		if (matcher.matches() || matcher2.matches()) {
			return false;
		}
		return true;
	}

}
