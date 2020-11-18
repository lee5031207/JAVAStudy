package com.kh.qrcode.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Toolkit;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField firstNum;
	private JTextField secondNum;
	private JTextField result;
	private final Action plus = new Plus();
	private final Action minus = new Minus();
	private final Action multiplication = new Multiplication();
	private final Action division = new Division();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public Calculator() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\이성욱\\Desktop\\votelogo2.png"));
		setTitle("계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		firstNum = new JTextField();
		firstNum.setFont(new Font("210 맨발의청춘 L", Font.BOLD, 30));
		firstNum.setBounds(12, 10, 105, 59);
		contentPane.add(firstNum);
		firstNum.setColumns(10);
		
		secondNum = new JTextField();
		secondNum.setFont(new Font("210 맨발의청춘 L", Font.BOLD, 30));
		secondNum.setColumns(10);
		secondNum.setBounds(146, 10, 105, 59);
		contentPane.add(secondNum);
		
		result = new JTextField();
		result.setFont(new Font("210 맨발의청춘 L", Font.BOLD, 30));
		result.setColumns(10);
		result.setBounds(307, 10, 105, 59);
		contentPane.add(result);
		
		JLabel jsutText = new JLabel("=");
		jsutText.setFont(new Font("210 맨발의청춘 L", Font.BOLD, 26));
		jsutText.setBounds(263, 27, 32, 26);
		contentPane.add(jsutText);
		
		JButton plusBtn = new JButton("+");
		plusBtn.setAction(plus);
		plusBtn.setFont(new Font("210 맨발의청춘 L", Font.BOLD, 30));
		plusBtn.setBounds(53, 104, 125, 59);
		contentPane.add(plusBtn);
		
		JButton minusBtn = new JButton("-");
		minusBtn.setAction(minus);
		minusBtn.setFont(new Font("210 맨발의청춘 L", Font.BOLD, 30));
		minusBtn.setBounds(236, 104, 125, 59);
		contentPane.add(minusBtn);
		
		JButton multiplicationBtn = new JButton("x");
		multiplicationBtn.setAction(multiplication);
		multiplicationBtn.setFont(new Font("210 맨발의청춘 L", Font.BOLD, 30));
		multiplicationBtn.setBounds(53, 173, 125, 59);
		contentPane.add(multiplicationBtn);
		
		JButton divisionBtn = new JButton("÷");
		divisionBtn.setAction(division);
		divisionBtn.setFont(new Font("210 맨발의청춘 L", Font.BOLD, 30));
		divisionBtn.setBounds(236, 173, 125, 59);
		contentPane.add(divisionBtn);
	}
	
	private class Plus extends AbstractAction {
		
		public Plus() {
			putValue(NAME, "+");
		}
		public void actionPerformed(ActionEvent e) {
			String firstNumstr = firstNum.getText();
			int num1 = Integer.parseInt(firstNumstr);
			
			String secondNumstr = secondNum.getText();
			int num2 = Integer.parseInt(secondNumstr);
			
			int rseultNum = num1 + num2;
			String resultStr = Integer.toString(rseultNum);
			
			result.setText(resultStr);
		}
	}
	
	private class Minus extends AbstractAction {
		public Minus() {
			putValue(NAME, "-");
		}
		public void actionPerformed(ActionEvent e) {
			String firstNumstr = firstNum.getText();
			int num1 = Integer.parseInt(firstNumstr);
			
			String secondNumstr = secondNum.getText();
			int num2 = Integer.parseInt(secondNumstr);
			
			int rseultNum = num1 - num2;
			String resultStr = Integer.toString(rseultNum);
			
			result.setText(resultStr);
		}
	}
	
	private class Multiplication extends AbstractAction {
		public Multiplication() {
			putValue(NAME, "x");
		}
		public void actionPerformed(ActionEvent e) {
			String firstNumstr = firstNum.getText();
			int num1 = Integer.parseInt(firstNumstr);
			
			String secondNumstr = secondNum.getText();
			int num2 = Integer.parseInt(secondNumstr);
			
			int rseultNum = num1 * num2;
			String resultStr = Integer.toString(rseultNum);
			
			result.setText(resultStr);
		}
	}
	
	private class Division extends AbstractAction {
		public Division() {
			putValue(NAME, "÷");
		}
		public void actionPerformed(ActionEvent e) {
			String firstNumstr = firstNum.getText();
			//int num1 = Integer.parseInt(firstNumstr);
			float num1 = Float.parseFloat(firstNumstr);
			
			String secondNumstr = secondNum.getText();
			//int num2 = Integer.parseInt(secondNumstr);
			float num2 = Float.parseFloat(secondNumstr);
			
			float rseultNum = num1 / num2;
			//String resultStr = Integer.toString(rseultNum);
			String resultStr = Float.toString(rseultNum);
			result.setText(resultStr);
		}
	}
}
