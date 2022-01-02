import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HorseRun extends JLabel implements Runnable{   
	Image imgs[];
	ImageIcon icon;
	boolean checkGame = true; 
	boolean checkStop = true;
	public HorseRun(Image[] imgs) {
		this.imgs = imgs;
		icon = new ImageIcon(imgs[0]);
		this.setIcon(icon);
		(new Thread(this)).start();
	}

	public void stop(boolean checkgame){
		checkGame = checkgame;
	}
	
	public void start(boolean checkstop){
		checkStop = checkstop;
	}


	@Override
	public void run() {

		while(checkStop){
			if(checkGame==true){
				for(int i=0;i<imgs.length;i++){
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					icon.setImage(imgs[i]);
					this.repaint();
					this.revalidate();
				}
			}else if(checkGame==false){
				checkStop = false;
				(new Thread(this)).start();
					break;
			}

		}
		
	}

}   

