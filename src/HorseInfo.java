import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HorseInfo extends JPanel implements Runnable,ActionListener {
	ImageIcon icon1,icon2,icon3,icon4,icon5;
	JLabel lblicon1,lblicon2,lblicon3,lblicon4,lblicon5,
	Black,Cheetah,Rocket,Tom,Thunder;
	JPanel pnl1,pnl2,pnl3,pnl4,pnl5,pnlBtn;
	JButton backBtn;
	Main main;
	
	public HorseInfo(Main main) {
		this.main = main;
		this.setSize(600,500);
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		
		pnl1 = new JPanel();		
		pnl1.setBounds(30, 5, 500, 420);
		pnl1.setBorder(BorderFactory.createEmptyBorder(30, 35, 0, 0));
		Black = new JLabel("** 이름:블랙  나이:3세  신장:250cm  무게:480kg **");
		Black.setFont(new Font("맑은 고딕",Font.BOLD , 15));
		icon1 = new ImageIcon("././HorseImage/Black.jpg");
		lblicon1 = new JLabel();
		lblicon1.setIcon(icon1);
		pnl1.setBackground(Color.white);
		pnl1.add(Black);
		pnl1.add(lblicon1);
		add(pnl1);

		pnl2 = new JPanel();		
		pnl2.setBounds(30, 5, 500, 420);
		pnl2.setBorder(BorderFactory.createEmptyBorder(30, 35, 0, 0));
		Cheetah = new JLabel("** 이름:치타  나이:3세  신장:250cm  무게:490kg **");
		Cheetah.setFont(new Font("맑은 고딕",Font.BOLD , 15));
		icon2 = new ImageIcon("././HorseImage/cheetah.jpg");
		lblicon2 = new JLabel();
		lblicon2.setIcon(icon2);
		pnl2.setBackground(Color.white);
		pnl2.add(Cheetah);
		pnl2.add(lblicon2);
		add(pnl2);

		pnl3 = new JPanel();		
		pnl3.setBounds(30, 5, 500, 420);
		pnl3.setBorder(BorderFactory.createEmptyBorder(30, 35, 0, 0));
		Rocket = new JLabel("** 이름:로켓  나이:1세  신장:250cm  무게:480kg **");
		Rocket.setFont(new Font("맑은 고딕",Font.BOLD , 15));
		icon3 = new ImageIcon("././HorseImage/Rocket.jpg");
		lblicon3 = new JLabel();
		lblicon3.setIcon(icon3);
		pnl3.setBackground(Color.white);
		pnl3.add(Rocket);
		pnl3.add(lblicon3);
		add(pnl3);

		pnl4 = new JPanel();
		pnl4.setBounds(30, 5, 500, 420);
		pnl4.setBorder(BorderFactory.createEmptyBorder(30, 35, 0, 0));
		Tom = new JLabel("** 이름:톰  나이:3세  신장:270cm  무게:490kg **");
		Tom.setFont(new Font("맑은 고딕",Font.BOLD , 15));
		icon4 = new ImageIcon("././HorseImage/Black.jpg");
		lblicon4 = new JLabel();
		lblicon4.setIcon(icon4);
		pnl4.setBackground(Color.white);
		pnl4.add(Tom);
		pnl4.add(lblicon4);
		add(pnl4);

		pnl5 = new JPanel();		
		pnl5.setBounds(30, 5, 500, 420);
		pnl5.setBorder(BorderFactory.createEmptyBorder(30, 35, 0, 0));
		Thunder = new JLabel("** 이름:썬더  나이:5세  신장:270cm  무게:490kg **");
		Thunder.setFont(new Font("맑은 고딕",Font.BOLD , 15));
		icon5 = new ImageIcon("././HorseImage/Thunder.jpg");
		lblicon5 = new JLabel();
		lblicon5.setIcon(icon5);
		pnl5.setBackground(Color.white);
		pnl5.add(Thunder);
		pnl5.add(lblicon5);
		add(pnl5);         
		
		backBtn = new JButton("돌아가기");
		backBtn.setBackground(Color.WHITE);
		backBtn.setBounds(30,430,100,30);
		backBtn.addActionListener(this);
		this.add(backBtn);
	

		this.setVisible(true);

	}
	@Override
	public void run() {
		while(true){
			for(int i=pnl1.getX();-400<i;i--){
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				pnl1.setLocation(pnl1.getX()-5, pnl1.getY());				
			}
			for(int i=pnl2.getX();-400<i;i--){
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				pnl2.setLocation(pnl2.getX()-5, pnl2.getY());	
			}
			for(int i=pnl3.getX();-400<i;i--){
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				pnl3.setLocation(pnl3.getX()-5, pnl3.getY());	
			}
			for(int i=pnl4.getX();-400<i;i--){
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				pnl4.setLocation(pnl4.getX()-5, pnl4.getY());	
			}
			for(int i=pnl5.getX();-400<i;i--){
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				pnl5.setLocation(pnl5.getX()-5, pnl5.getY());	
				pnl1.setLocation(30, 5);
			}
			pnl1.setLocation(30, 5);
			pnl2.setLocation(30, 5);
			pnl3.setLocation(30, 5);
			pnl4.setLocation(30, 5);
			pnl5.setLocation(30, 5);

		}	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backBtn){
			main.change("startmenu");
		}
		
	}
}