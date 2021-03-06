package com.kh.이성욱;

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

public class ScoreFrame extends JFrame {

	private JPanel contentPane;
	private JTextField javaScore;
	private JTextField sqlScore;
	private JTextField total;
	private JTextField average;
	private final Action action = new ActionHandler();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreFrame frame = new ScoreFrame();
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
	public ScoreFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\이성욱\\Desktop\\계산기.png"));
		setTitle("이성욱");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		javaScore = new JTextField();
		javaScore.setBounds(69, 77, 96, 21);
		contentPane.add(javaScore);
		javaScore.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("점수를 입력하시오");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 36));
		lblNewLabel.setBounds(59, 10, 318, 71);
		contentPane.add(lblNewLabel);
		
		sqlScore = new JTextField();
		sqlScore.setColumns(10);
		sqlScore.setBounds(281, 77, 96, 21);
		contentPane.add(sqlScore);
		
		total = new JTextField();
		total.setColumns(10);
		total.setBounds(69, 196, 96, 21);
		contentPane.add(total);
		
		average = new JTextField();
		average.setColumns(10);
		average.setBounds(281, 196, 96, 21);
		contentPane.add(average);
		
		JLabel lblNewLabel_1 = new JLabel("자바 : ");
		lblNewLabel_1.setBounds(25, 80, 50, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("SQL : ");
		lblNewLabel_1_1.setBounds(239, 80, 50, 15);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("총점 : ");
		lblNewLabel_1_2.setBounds(25, 199, 50, 15);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("평균 : ");
		lblNewLabel_1_2_1.setBounds(239, 199, 50, 15);
		contentPane.add(lblNewLabel_1_2_1);
		
		JButton calcBtn = new JButton("계산하기");
		calcBtn.setAction(action);
		calcBtn.setBounds(146, 118, 130, 53);
		contentPane.add(calcBtn);
	}
	//내부 클래스
	private class ActionHandler extends AbstractAction {
		public ActionHandler() {
			putValue(NAME, "계산하기");			
		}
		public void actionPerformed(ActionEvent e) {
			String javaScoreStr = javaScore.getText();
			String sqlScoreStr = sqlScore.getText();
			
			int sum = Integer.parseInt(javaScoreStr)+Integer.parseInt(sqlScoreStr);
			String sumStr = Integer.toString(sum);
			total.setText(sumStr);
//			float sum = Float.parseFloat(javaScoreStr)+Float.parseFloat(sqlScoreStr);
//			String sumStr = Float.toString(sum);
//			total.setText(sumStr);
			
			float avg = (Float.parseFloat(javaScoreStr)+Float.parseFloat(sqlScoreStr)) / 2;
			String avgStr = Float.toString(avg);
			average.setText(avgStr);			
		}
	}
}
