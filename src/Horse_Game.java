

import java.awt.Font;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Horse_Game extends JPanel implements Runnable, ActionListener {
	HorseRun num1, num2, num3, num4, num5; 
	Horse_Time time;	
	int ranline1, ranline2, ranline3, ranline4, ranline5;      
	int line1, line2, line3, line4, line5;
	JButton play;
	Main main;
	int betting_price,my_Money,betting_number,betting_multy,finish,mymoney;
	static String MONEY_FILE = "money/money.txt";
	static String BETTING_FILE = "money/game.txt";
	boolean check;
	boolean checkGame = true; 
	boolean checkStop = true;
	Horse_Game(Main main){
		this.main=main;		
		Image black_cheetah[]={new ImageIcon("./HorseImage/검마1.png").getImage(),new ImageIcon("./HorseImage/검마2.png").getImage(),new ImageIcon("./HorseImage/검마3.png").getImage(),new ImageIcon("./HorseImage/검마4.png").getImage(),new ImageIcon("./HorseImage/검마5.png").getImage(),new ImageIcon("./HorseImage/검마6.png").getImage()};
		Image thunder[]={new ImageIcon("./HorseImage/백마1.png").getImage(),new ImageIcon("./HorseImage/백마2.png").getImage(),new ImageIcon("./HorseImage/백마3.png").getImage(),new ImageIcon("./HorseImage/백마4.png").getImage(),new ImageIcon("./HorseImage/백마5.png").getImage(),new ImageIcon("./HorseImage/백마6.png").getImage()};
		Image roket_tom[]={new ImageIcon("./HorseImage/갈마1.png").getImage(),new ImageIcon("./HorseImage/갈마2.png").getImage(),new ImageIcon("./HorseImage/갈마3.png").getImage(),new ImageIcon("./HorseImage/갈마4.png").getImage(),new ImageIcon("./HorseImage/갈마5.png").getImage()};

		num1 = new HorseRun(black_cheetah);
		num2 = new HorseRun(black_cheetah);
		num3 = new HorseRun(roket_tom);
		num4 = new HorseRun(roket_tom);
		num5 = new HorseRun(thunder);

		time = new Horse_Time();
		time.setBounds(0, 0, 70, 25);


		play = new JButton("Race Start ~ !!");
		Font font = new Font("맑은 고딕",Font.BOLD,20);
		play.setFont(font);
		play.setBounds(0, 425, 585, 35);
		play.addActionListener(this);
		play.setBorderPainted(false);
		play.setContentAreaFilled(false);

		this.setLayout(null);

		num1.setBounds(0, 81, 80, 45);
		num2.setBounds(0, 142, 80, 45);
		num3.setBounds(0, 223, 80, 45);
		num4.setBounds(0, 285, 80, 45);
		num5.setBounds(0, 366, 80, 45);      


		add(num1);
		add(num2);
		add(num3);
		add(num4);
		add(num5);
		add(play);
		add(time);
	}
	void getBetting(){
		File f = new File(BETTING_FILE);
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String str = null;
			while((str=br.readLine())!=null){
				String s[] = str.split("/");
				this.betting_number = Integer.parseInt(s[0]);
				this.betting_price = Integer.parseInt(s[1]);
				this.betting_multy = Integer.parseInt(s[2]);
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
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		File f = null;
		Image img = null;  

		try {
			f = new File("./HorseImage/경기장.png");
			img = ImageIO.read(f);
			g.drawImage(img,0,0,null);         
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	void MoneySave(int my_Money){
		File f = new File(MONEY_FILE);
		//f.delete();
		FileWriter fw = null;
		PrintWriter pw = null;
		FileReader fr = null;
		BufferedReader br = null;	


		String str = null;		

		try {


			fr = new FileReader(f);
			br = new BufferedReader(fr);
			fw = new FileWriter(f,true);
			pw = new PrintWriter(fw);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {
			while((str=br.readLine()) != null){
				mymoney = Integer.parseInt(str.split("/")[0]);
				new FileOutputStream(MONEY_FILE).close();
				pw.print(mymoney + my_Money);			
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pw != null){
				pw.close();
			}
		}		


	}		

	//





	@Override
	public void run() {
		int x=495;
		int a=496;


		while(num1.getX()<=x&&num2.getX()<=x&&num3.getX()<=x&&num4.getX()<=x&&num5.getX()<=x&&checkStop==true){
			if(checkGame==true){
				line1++;
				line2++;
				line3++;
				line4++;
				line5++;
				try {
					Thread.sleep(130);

					ranline1 = (int)(Math.random()*11)+1;
					line1 = ranline1 + line1;            
					num1.setLocation(line1, 81);

					ranline2 = (int)(Math.random()*10);
					line2 = ranline2 + line2;            
					num2.setLocation(line2, 142);                     

					ranline3 = (int)(Math.random()*11);
					line3 = ranline3 + line3;         
					num3.setLocation(line3, 223);

					ranline4 = (int)(Math.random()*10);
					line4 = ranline4 + line4;            
					num4.setLocation(line4, 285);

					ranline5 = (int)(Math.random()*11);
					line5 = ranline5 + line5;            
					num5.setLocation(line5, 366);

					repaint();
					revalidate();


				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if(num1.getX()>=a){
					time.checkStop=false;
					time.ms2 -= 1;			
					check = true;				
					JOptionPane.showMessageDialog(null, "1번말 Black우승!!"+"\n기록은 "+time.getText()+"초");	
					getBetting();				
					if(check&&betting_number==1){
						System.out.println("확인");	
						//MoneySave(my_Money);
						my_Money = betting_price*betting_multy;
						JOptionPane.showMessageDialog(null, "축하합니다!"+betting_price*betting_multy+"원 획득");

						MoneySave(my_Money);

						main.change("startmenu");
						num1.stop(false);
						time.start(false);
						num1.setBounds(0, 81, 80, 45);					
						num2.setBounds(0, 142, 80, 45);					
						num3.setBounds(0, 223, 80, 45);					
						num4.setBounds(0, 285, 80, 45);					
						num5.setBounds(0, 366, 80, 45);

						num1.start(true);
						num1.stop(true);
//						if(num1.checkStop==false){
//							(new Thread(this)).start();
//						}
						checkGame = false;
						break;

					}else{
						JOptionPane.showMessageDialog(null, "다음기회에~");
						main.change("startmenu");
						break;

					}
				}else if(num2.getX()>=a){
					time.checkStop=false;
					time.ms2 -= 1;
					JOptionPane.showMessageDialog(null, "2번말 Cheetah우승!!"+"\n기록은 "+time.getText()+"초");	
					getBetting();
					check = true;
					if(check&&betting_number==2){
						my_Money += betting_price*betting_multy;
						JOptionPane.showMessageDialog(null, "축하합니다!"+betting_price*betting_multy+"원 획득");
						MoneySave(my_Money);
						main.change("startmenu");
						//num1.stop(true);
						break;
					}else{
						JOptionPane.showMessageDialog(null, "다음기회에~");
						main.change("startmenu");
						break;
					}
				}else if(num3.getX()>=a){
					time.checkStop=false;
					time.ms2 -= 1;
					JOptionPane.showMessageDialog(null, "3번말 Rocket우승!!"+"\n기록은 "+time.getText()+"초");	
					getBetting();
					check = true;
					if(check&&betting_number==3){
						my_Money += betting_price*betting_multy;
						JOptionPane.showMessageDialog(null, "축하합니다!"+betting_price*betting_multy+"원 획득");
						MoneySave(my_Money);
						main.change("startmenu");
						break;
					}else{
						JOptionPane.showMessageDialog(null, "다음기회에~");
						main.change("startmenu");
						break;
					}
				}else if(num4.getX()>=a){
					time.checkStop=false;
					time.ms2 -= 1;
					JOptionPane.showMessageDialog(null, "4번말 Tom우승!!"+"\n기록은 "+time.getText()+"초");	
					getBetting();
					check = true;
					if(check&&betting_number==4){
						my_Money += betting_price*betting_multy;
						JOptionPane.showMessageDialog(null, "축하합니다!"+betting_price*betting_multy+"원 획득");
						MoneySave(my_Money);
						main.change("startmenu");
						break;
					}else{
						JOptionPane.showMessageDialog(null, "다음기회에~");
						main.change("startmenu");
						break;
					}
				}else if(num5.getX()>=a){
					time.checkStop=false;
					time.ms2 -= 1;
					JOptionPane.showMessageDialog(null, "5번말 Thunder우승!!"+"\n기록은 "+time.getText()+"초");	
					getBetting();
					check = true;
					if(check&&betting_number==5){
						my_Money += betting_price*betting_multy;
						JOptionPane.showMessageDialog(null, "축하합니다!"+betting_price*betting_multy+"원 획득");
						MoneySave(my_Money);
						main.change("startmenu");
						break;
					}else{
						JOptionPane.showMessageDialog(null, "다음기회에~");
						main.change("startmenu");
						break;
					}
				}


			}else if(checkGame==false){
				checkStop = false;
				break;
			}
		}


	}
	@Override
	public void actionPerformed(ActionEvent e) {
		(new Thread(this)).start();
		time.checkStop=true;
		checkGame=true;
		(new Thread(time)).start();

	}   
}