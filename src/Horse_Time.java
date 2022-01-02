import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class Horse_Time extends JLabel implements Runnable {   

	boolean checkGame = true;
	boolean checkStop = true;
	Horse_Time(){

		this.setHorizontalAlignment(JLabel.CENTER);
		Font font = new Font("맑은 고딕",Font.BOLD,25);
		this.setFont(font);
		this.setForeground(Color.WHITE);      

	}
	int ms1=0;
	int ms2=0;//밀리초
	int s1=0;
	int s2=0;//초


	public void start(boolean checkgame){
		checkGame = checkgame;
	}

	public void stop(boolean checkstop){
		checkStop = checkstop;
	}

	@Override
	public void run() {  

		while(checkStop){
			if(checkGame == true){
				try {            
					Thread.sleep(10);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}            

				ms2++;
				if(ms2==8){
					ms1++;
					ms2=0;
					if(ms1==9){
						s2++;
						ms1=0;
						if(s2==9){
							s1++;
							s2=0;
						}
					}
				}
				this.setText(s1+""+s2+"."+ms1+""+ms2);

			}else if(checkGame == false){
				checkStop = false;				
					break;
			}
		}
	}
}