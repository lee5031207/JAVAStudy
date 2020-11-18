package com.kh.qrcode.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kh.qrcode.maker.QRCodeMaker;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URLConnection;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.ref.Cleaner;
import java.awt.Toolkit;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private final Action qrBtnClick = new QRBtnClick();

	private JTextArea urlContents = new JTextArea();
	private JTextArea titleContents = new JTextArea();
	private final Action reset = new Reset();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\QRCode\\Naver.png"));
		setTitle("QR Code Maker\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel appName = new JLabel("QRCodeMaker\r\n");
		appName.setFont(new Font("210 맨발의청춘 L", Font.BOLD, 16));
		appName.setBounds(170, 10, 121, 38);
		contentPane.add(appName);
		
		JLabel url = new JLabel("URL");
		url.setFont(new Font("210 맨발의청춘 L", Font.BOLD, 14));
		url.setBounds(102, 58, 48, 28);
		contentPane.add(url);
		
		JLabel title = new JLabel("TITLE");
		title.setFont(new Font("210 맨발의청춘 L", Font.BOLD, 14));
		title.setBounds(320, 58, 48, 28);
		contentPane.add(title);
		
		//JTextArea urlContents = new JTextArea();
		urlContents.setBounds(24, 92, 183, 223);
		contentPane.add(urlContents);
		
		//JTextArea titleContents = new JTextArea();
		titleContents.setBounds(248, 92, 183, 223);
		contentPane.add(titleContents);
		
		JButton QRBtn = new JButton("QR코드 만들기");
		
		//익명 클래스 QR버튼에 커서올라가면 HAND_CURSOR로 바꾸기
		QRBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = QRBtn.getCursor();
				QRBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		
		//클릭시 qrBtnClick 클래스 실행한다 
		QRBtn.setAction(qrBtnClick);
		QRBtn.setFont(new Font("210 맨발의청춘 L", Font.BOLD, 12));
		QRBtn.setBounds(156, 338, 148, 48);
		contentPane.add(QRBtn);
		
		JButton clearBtn = new JButton("초기화");
		clearBtn.setAction(reset);
		
		//익명 클래스 초기화에 커서올라가면 HAND_CURSOR로 바꾸기
		clearBtn.addMouseListener(new MouseAdapter() {
			//clearBtn에 마우스가 올라가면 hover
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = clearBtn.getCursor();
				clearBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				//JOptionPane.showMessageDialog(temporaryLostComponent, "클릭");
			}
		});
		
		clearBtn.setFont(new Font("210 맨발의청춘 L", Font.BOLD, 12));
		clearBtn.setBounds(156, 396, 148, 48);
		contentPane.add(clearBtn);
	}
	//내부 클래스
	private class QRBtnClick extends AbstractAction {
		public QRBtnClick() {
			putValue(NAME, "QR코드 만들기");
		}
		//버튼의 클릭되었을때 수행될 코드
		public void actionPerformed(ActionEvent e) {
			//new QRCodeMaker().makeQR(url, fileName);
			String urls = urlContents.getText();
			String titles = titleContents.getText();
			String urlArr[] = urls.split("\n");
			String titleArr[] = titles.split("\n");
			
			QRCodeMaker maker = new QRCodeMaker();
			
			if(urlArr.length < titleArr.length) {
				for(int i = 0; i< urlArr.length; i++) {
					urlArr[i] = urlArr[i].trim(); // trim(문자열의 공백 제거)
					titleArr[i] = titleArr[i].trim(); // trim(문자열의 공백 제거)
					maker.makeQR(urlArr[i], titleArr[i]);
				}
			}else {
				for(int i = 0; i< titleArr.length; i++) {
					urlArr[i] = urlArr[i].trim(); // trim(문자열의 공백 제거)
					titleArr[i] = titleArr[i].trim(); // trim(문자열의 공백 제거)
					maker.makeQR(urlArr[i], titleArr[i]);
				}
			}
			urlContents.setText(null);
			titleContents.setText("");
			JOptionPane.showMessageDialog(null,"파일생성이 완료되었습니다.");
		}
	}
	
	private class Reset extends AbstractAction {
		public Reset() {
			putValue(NAME, "초기화");
		}
		public void actionPerformed(ActionEvent e) {
			urlContents.setText(null);
			titleContents.setText("");
		}
	}
}
