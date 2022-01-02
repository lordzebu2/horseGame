

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;


public class Main extends JFrame{
	Purchase pc;
	StartMenu sm;
	Login login;
	HorseManager horseManager;
	HorseInfo horseInfo;
	Horse_Game game;
	ChargeMoney cm;
	BuyTicket bt;
	int my_Money;
	static String MONEY_FILE = "money/money.txt";
	public void change(String panelName){
		
		if(panelName.equals("purchase")){
			getContentPane().removeAll();
			getContentPane().add(pc); 
			revalidate();
			repaint();
		}else if(panelName.equals("startmenu")){
			getContentPane().removeAll();
			getContentPane().add(sm);
			revalidate();
			repaint();
		}else if(panelName.equals("login")){
			getContentPane().removeAll();
			getContentPane().add(login);
			revalidate();
			repaint();
		}else if(panelName.equals("horseManager")){
			getContentPane().removeAll();
			getContentPane().add(horseManager);
			revalidate();
			repaint();
		}else if(panelName.equals("horseInfo")){
			getContentPane().removeAll();
			getContentPane().add(horseInfo);
			revalidate();
			repaint();
		}else if(panelName.equals("horseGame")){
			getContentPane().removeAll();
			getContentPane().add(game);
			revalidate();
			repaint();
		}

		this.setResizable(false);
		
		this.setVisible(true);
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
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pw !=null){
				pw.close();
			}
		}
	}
	
	
	public static void main(String[] args) {
		Main hr = new Main();
		
		hr.setTitle("경마 게임");
		hr.pc = new Purchase(hr);
		hr.sm = new StartMenu(hr);
		hr.login = new Login(hr);
		hr.horseManager = new HorseManager(hr);
		hr.horseInfo = new HorseInfo(hr);
		hr.game = new Horse_Game(hr);
		//hr.bt = new BuyTicket(hr);
		hr.add(hr.sm);
		hr.setDefaultCloseOperation(3);
		hr.setSize(600,500);
		hr.setLocationRelativeTo(null);
		hr.setVisible(true);
	}
//	void getMoney(int my_Money){
//		this.my_Money = my_Money;		
//	}

	
		
	

}
