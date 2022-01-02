import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartMenu extends JPanel implements ActionListener {
	JButton btn1,btn2,btn3,btn4, btn5;
	JPanel pnlMenu;
	JLabel background;
	Purchase pc;
	Main hr;
	Login login;
	Horse_Game game;
	int my_Money;
	
	
	public StartMenu(Main hr){
		
		this.hr = hr;
		
		this.setSize(600,500);
		this.setLayout(new BorderLayout());
		background = new JLabel(new ImageIcon("HorseRacing.png"));
		
		btn1 = new JButton("마권 구매");
		btn2 = new JButton("말 보기");
		btn3 = new JButton("충전 하기");
		btn4 = new JButton("종료");
		btn5 = new JButton("관리자");
		
		btn1.setBackground(Color.white);
		btn2.setBackground(Color.white);
		btn3.setBackground(Color.white);
		btn4.setBackground(Color.white);
		btn5.setBackground(Color.white);
		
		btn1.setBounds(450, 50, 100, 40);
		btn2.setBounds(450, 130, 100, 40);
		btn3.setBounds(450, 210, 100, 40);
		btn4.setBounds(450, 290, 100, 40);
		btn5.setBounds(450, 370, 100, 40);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		
		background.add(btn1);
		background.add(btn2);
		background.add(btn3);
		background.add(btn4);
		background.add(btn5);		
				
		this.add(background);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1){
			hr.change("purchase");
		}else if(e.getSource()==btn2){
			hr.change("horseInfo");
			(new Thread(hr.horseInfo)).start();
		}else if(e.getSource()==btn3){			
			ChargeMoney cm = new ChargeMoney();;
		}else if(e.getSource()==btn4){
			//hr.dispose();
			System.exit(0);
		}else if(e.getSource()==btn5){
			hr.change("login");
		}
		
	}

}
