import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JPanel implements ActionListener{
	
	JPanel pnl, pnlAlign;
	JLabel lblPsw;
	JTextField tfPsw;
	JButton btnLogin, btnCancel;
	HorseManager horseManager;
	int au;
	Main main;
	
	public Login(Main main) {
		this.main=main;
		this.setLayout(null);
		
		pnl = new JPanel();
		pnl.setBounds(150, 180, 280, 100);
		
		pnlAlign = new JPanel();
		pnlAlign.setBorder(BorderFactory.createEmptyBorder(20,0, 0, 0));
		
		lblPsw = new JLabel("비밀번호");
		tfPsw= new JTextField(13);
		pnlAlign.add(lblPsw);
		pnlAlign.add(tfPsw);
		
				
		btnLogin = new JButton("로그인");
		btnLogin.setPreferredSize(new Dimension(100,40));
		btnLogin.setBackground(Color.white);
		btnLogin.addActionListener(this);
		
		btnCancel = new JButton("취소");
		btnCancel.setPreferredSize(new Dimension(100,40));
		btnCancel.setBackground(Color.white);
		btnCancel.addActionListener(this);
		
		pnl.add(pnlAlign);
		
		pnl.add(btnLogin);
		pnl.add(btnCancel);
		
		
		this.add(pnl);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean isLogin=false;
		if (e.getSource() == btnLogin) {
			File f = new File("account/account.txt");
			FileReader fr = null;
			BufferedReader br = null;
			try {
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				String l = null;
				while((l=br.readLine())!=null){
					String tmp[] = l.split("/");
					if(tfPsw.getText().equals(tmp[0])){
						isLogin=true;
						au = Integer.parseInt(tmp[1]);
						break;
					}				
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if(e.getSource()==btnCancel) {
			main.change("startmenu");
		}
		
		if(isLogin==false){
			JOptionPane.showMessageDialog(this, "로그인에 실패하였습니다.");
		} else {
			main.change("horseManager");	
		}
	}

}

