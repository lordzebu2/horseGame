

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.*;
public class ChargeMoney extends JFrame implements ActionListener{
	
	Main main = new Main();
	JButton charge_btn,back_btn;
	JTextField input_money;
	JLabel title,mymoney,text;
	int my_Money;
	JPanel pnl;
	static String MONEY_FILE = "money/money.txt";
	public ChargeMoney(){
		
		this.setDefaultCloseOperation(3);
		this.setSize(300,400);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.white);
		title = new JLabel("[ 충전 하기 ]");
		title.setFont(new Font("맑은 고딕",Font.BOLD,20));
		title.setBounds(90, 1,150,50);
		//
		
		text = new JLabel("충전금액");
		text.setFont(new Font("맑은 고딕",Font.BOLD,10));
		input_money = new JTextField() {
		    @Override public void setBorder(Border border) {
		        // No!
		    }
		};
		input_money.setText("금액을 입력하세요");
		pnl = new JPanel();
		pnl.setLayout(null);
		pnl.setBorder(new LineBorder(Color.BLACK,1,true));
		pnl.setBackground(Color.white);
		text.setBounds(8,8,40,10);
		input_money.setBounds(8,20,200,55);
		pnl.add(text);
		pnl.add(input_money);
		pnl.setBounds(10, 45, 260, 80);
		
	
		mymoney = new JLabel();
		mymoney.setFont(new Font("맑은 고딕",Font.BOLD,15));
		mymoney.setBounds(10,130,70,50);
		getMoney();
		
		
		
		//버튼
		charge_btn = new JButton("충전 하기");
		back_btn = new JButton("뒤로 가기");
		
		back_btn.setBounds(10, 240, 130, 30);
		charge_btn.setBounds(140, 240, 130, 30);
		
		charge_btn.addActionListener(this);
		back_btn.addActionListener(this);
		
		charge_btn.setBackground(Color.lightGray);	
		back_btn.setBackground(Color.lightGray);
		//
		this.add(title);
		this.add(pnl);
		this.add(mymoney);
		this.add(charge_btn);
		this.add(back_btn);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	void getMoney(){
		File f = new File(MONEY_FILE);
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String str = null;
			while((str=br.readLine())!=null){
				this.my_Money = Integer.parseInt(str.split("/")[0]);
				mymoney.setText(my_Money+"원");
			}
			 	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==charge_btn){
			int i = Integer.parseInt(input_money.getText());
			if(i<=100000&&i>=0){
				JOptionPane jp = new JOptionPane();
				jp.showMessageDialog(null,"충전했습니다.");
				my_Money += i;
				mymoney.setText(my_Money+"원");
				
						
			}
		}else if(e.getSource()==back_btn){
			main.MoneySave(my_Money);				
			dispose();
		}
		
	}

}
