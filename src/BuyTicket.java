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
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BuyTicket extends JFrame implements ActionListener{
	JLabel title,hasMoney,horseNumber,horseName,horseAge,horseHeight,horseWeight,horseMulty;

	String name,height,weight,age;
	int number,price,multy;
	JRadioButton rd1_f,rd2_f,rd3_f,rd4_f,rd1_s,rd2_s,rd3_s,rd4_s,rd5_s,rd1_t,rd2_t,rd3_t,rd4_t,rd5_t;
	JButton ccBtn,byBtn;
	int my_Money;
	Main main;
	static String MONEY_FILE = "money/money.txt";
	static String BETTING_FILE = "money/game.txt";
	public BuyTicket(Main main){
		this.main = main;
		this.setDefaultCloseOperation(3);
		this.setSize(300,400);
		this.getContentPane().setBackground(Color.WHITE);
		this.setLayout(null);
		getMoney();
		mainScreen();

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	void mainScreen(){
		title = new JLabel("[ 마권 구매 ]");
		title.setFont(new Font("맑은 고딕",Font.BOLD,20));
		title.setBounds(90, 1,150,50);

		horseNumber = new JLabel("");
		horseNumber.setFont(new Font("맑은 고딕",Font.BOLD,15));
		horseNumber.setBounds(10,35,70,50);

		horseName = new JLabel("");
		horseName.setFont(new Font("맑은 고딕",Font.BOLD,15));
		horseName.setBounds(10,55,100,50);

		horseAge = new JLabel("");
		horseAge.setFont(new Font("맑은 고딕",Font.BOLD,15));
		horseAge.setBounds(10,75,100,50);

		horseHeight = new JLabel("");
		horseHeight.setFont(new Font("맑은 고딕",Font.BOLD,15));
		horseHeight.setBounds(10,95,100,50);

		horseWeight = new JLabel("");
		horseWeight.setFont(new Font("맑은 고딕",Font.BOLD,15));
		horseWeight.setBounds(10,115,100,50);

		horseMulty = new JLabel("");
		horseMulty.setFont(new Font("맑은 고딕",Font.BOLD,15));
		horseMulty.setBounds(10,135,100,50);

		hasMoney = new JLabel("");
		hasMoney.setFont(new Font("맑은 고딕",Font.BOLD,15));
		hasMoney.setBounds(10,155,100,50);

		rd1_f = new JRadioButton("1백");
		rd2_f = new JRadioButton("2백");
		rd3_f = new JRadioButton("3백");
		rd4_f = new JRadioButton("5백");
		rd1_s = new JRadioButton("1천");
		rd2_s = new JRadioButton("2천");
		rd3_s = new JRadioButton("3천");
		rd4_s = new JRadioButton("4천");
		rd5_s = new JRadioButton("5천");
		rd1_t = new JRadioButton("1만");
		rd2_t = new JRadioButton("2만");
		rd3_t = new JRadioButton("3만");
		rd4_t = new JRadioButton("5만");
		rd5_t = new JRadioButton("10만");

		ButtonGroup bg = new ButtonGroup();
		bg.add(rd1_f);
		bg.add(rd2_f);
		bg.add(rd3_f);
		bg.add(rd4_f);
		bg.add(rd1_s);
		bg.add(rd2_s);
		bg.add(rd3_s);
		bg.add(rd4_s);
		bg.add(rd5_s);
		bg.add(rd1_t);
		bg.add(rd2_t);
		bg.add(rd3_t);
		bg.add(rd4_t);
		bg.add(rd5_t);

		rd1_f.setBounds(10,170,50,20);
		rd2_f.setBounds(65,170,50,20);
		rd3_f.setBounds(120,170,50,20);
		rd4_f.setBounds(175,170,50,20);

		rd1_f.setSelected(true);

		rd1_s.setBounds(10,190,50,20);
		rd2_s.setBounds(65,190,50,20);
		rd3_s.setBounds(120,190,50,20);
		rd4_s.setBounds(175,190,50,20);
		rd5_s.setBounds(230,190,50,20);

		rd1_t.setBounds(10,210,50,20);
		rd2_t.setBounds(65,210,50,20);
		rd3_t.setBounds(120,210,50,20);
		rd4_t.setBounds(175,210,50,20);
		rd5_t.setBounds(230,210,55,20);

		rd1_f.setBackground(Color.WHITE);
		rd2_f.setBackground(Color.WHITE);
		rd3_f.setBackground(Color.WHITE);
		rd4_f.setBackground(Color.WHITE);

		rd1_s.setBackground(Color.WHITE);
		rd2_s.setBackground(Color.WHITE);
		rd3_s.setBackground(Color.WHITE);
		rd4_s.setBackground(Color.WHITE);
		rd5_s.setBackground(Color.WHITE);

		rd1_t.setBackground(Color.WHITE);
		rd2_t.setBackground(Color.WHITE);
		rd3_t.setBackground(Color.WHITE);
		rd4_t.setBackground(Color.WHITE);
		rd5_t.setBackground(Color.WHITE);

		ccBtn = new JButton("돌아가기");
		byBtn = new JButton("구매하기");

		ccBtn.addActionListener(this);
		byBtn.addActionListener(this);

		ccBtn.setBounds(10, 240, 130, 30);
		byBtn.setBounds(140, 240, 130, 30);

		ccBtn.setBackground(Color.lightGray);
		byBtn.setBackground(Color.lightGray);
		this.add(ccBtn);
		this.add(byBtn);

		this.add(rd1_f);
		this.add(rd2_f);
		this.add(rd3_f);
		this.add(rd4_f);
		this.add(rd1_s);
		this.add(rd2_s);
		this.add(rd3_s);
		this.add(rd4_s);
		this.add(rd5_s);
		this.add(rd1_t);
		this.add(rd2_t);
		this.add(rd3_t);
		this.add(rd4_t);
		this.add(rd5_t);

		this.add(title);
		this.add(horseNumber);
		this.add(horseName);
		this.add(horseAge);
		this.add(horseHeight);
		this.add(horseWeight);
		this.add(horseMulty);
		this.add(hasMoney);
	}
	void getNumber(String number){
		this.number = Integer.parseInt(number);
		horseNumber.setText(number+"번");		
	}

	void getAge(String age){
		this.age = age;
		horseAge.setText("나이 : "+age);	
	}
	void getMulty(String multy){
		this.multy = Integer.parseInt(multy);
		horseMulty.setText("배율 : "+multy);
	}
	void getName(String name){
		this.name = name;
		horseName.setText("이름 : "+name);
	}
	void getHeight(String height){
		this.height = height;
		horseHeight.setText("신장 : "+height);
	}
	void getWeight(String weight){
		this.weight = weight;
		horseWeight.setText("무게 : "+weight);
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
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	void bettingGame(int number, int price , int multy){		
		File f = new File(BETTING_FILE);
		f.delete();
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(f);
			pw = new PrintWriter(fw);
			pw.print(number+"/"+price+"/"+multy);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pw !=null){
				pw.close();
			}
		}		
	}
	void MoneySave(int my_Money){
		File f = new File(MONEY_FILE);
		//f.delete();
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(f);
			pw = new PrintWriter(fw);
			pw.print(my_Money+"/");
			//pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pw !=null){
				pw.close();
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==byBtn){
			if(rd1_f.isSelected()){
				price = 100;


			}else if(rd2_f.isSelected()){
				price = 200;

			}else if(rd3_f.isSelected()){
				price = 300;

			}else if(rd4_f.isSelected()){
				price = 500;

			}else if(rd1_s.isSelected()){
				price = 1000;

			}else if(rd2_s.isSelected()){
				price = 2000;

			}else if(rd3_s.isSelected()){
				price = 3000;

			}else if(rd4_s.isSelected()){
				price = 4000;

			}else if(rd5_s.isSelected()){
				price = 5000;

			}else if(rd1_t.isSelected()){
				price = 10000;

			}else if(rd2_t.isSelected()){
				price = 20000;

			}else if(rd3_t.isSelected()){
				price = 30000;

			}else if(rd4_t.isSelected()){
				price = 50000;

			}else if(rd5_t.isSelected()){
				price = 100000;

			}			
			int result = JOptionPane.showConfirmDialog(null, "게임을 시작하겠습니까?(배팅금액 :"+price+"원","마권 구매",JOptionPane.YES_NO_OPTION);
			if(result ==JOptionPane.YES_OPTION){
				if(my_Money>=price){					
					JOptionPane jp = new JOptionPane();
					jp.showMessageDialog(null,"게임을 시작합니다.");
					this.my_Money -= price;
					MoneySave(my_Money);
					bettingGame(number,price,multy);
					this.dispose();
					//this.setVisible(false);
					main.change("horseGame");
				}else{
					JOptionPane jp = new JOptionPane();
					jp.showMessageDialog(null,"보유 잔액이 부족합니다.");
				}
			}

		}else if(e.getSource()==ccBtn){
			dispose();

		}

	}
}

