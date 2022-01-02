import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;


public class Purchase extends JPanel implements ActionListener,MouseListener {
	int selectRow = -1;
	static String file_name = "./HorseList/Horse.txt"; 
	String[] header = {"번호","이름","나이","신장","무게","배당률"};
	String[][] contents = new String[5][6];
	JTable tbl;
	JScrollPane sp;
	Main hr;
	JLabel titleLbl;
	JButton cancelBtn,buyBtn;
	public Purchase(Main hr){
		this.hr = hr;
		this.setSize(600,500);
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		Header();
		Foot();
		this.setVisible(true);
		
	}
	void Header(){
		titleLbl = new JLabel("[ 경주마 명단 ]");
		titleLbl.setFont(new Font("맑은 고딕",Font.BOLD,20));
		titleLbl.setBounds(230, 1,150,50);
		this.add(titleLbl);
		File f = new File(file_name);
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String l = null;
			int i = 0;
			while((l=br.readLine())!=null){
				for(int j = 0; j<6;j++){
					contents[i][j] = l.split("/")[j];
				}
				
				i++;
			}
			tbl = new JTable(contents,header);
			sp = new JScrollPane(tbl);
			//테이블 가운데 정렬
			DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
			tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumnModel tcmSchedule = tbl.getColumnModel();
			for (int k = 0; k < tcmSchedule.getColumnCount(); k++) {
				tcmSchedule.getColumn(k).setCellRenderer(tScheduleCellRenderer);
			}
			//
			tbl.setBackground(Color.WHITE);
			tbl.addMouseListener(this);
			sp.setBounds(0,50,600,300);
			this.add(sp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	void Foot(){
		cancelBtn = new JButton("돌아가기");
		buyBtn = new JButton("구매하기");
		
		cancelBtn.setBounds(30,400,100,50);
		buyBtn.setBounds(470,400,100,50);
		
		cancelBtn.setBackground(Color.lightGray);
		buyBtn.setBackground(Color.lightGray);
		
		cancelBtn.addActionListener(this);
		buyBtn.addActionListener(this);
		
		this.add(cancelBtn);
		this.add(buyBtn);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buyBtn){
			if(selectRow == -1){
				JOptionPane jp = new JOptionPane();
				jp.showMessageDialog(null,"경마를 선택해주세요.");
			}else{
				BuyTicket bt = new BuyTicket(hr);
				bt.getNumber(contents[selectRow][0]);
				bt.getAge(contents[selectRow][2]);					
				bt.getMulty(contents[selectRow][5]);
				bt.getName(contents[selectRow][1]);
				bt.getHeight(contents[selectRow][3]);			
				bt.getWeight(contents[selectRow][4]);
			}
		}else if(e.getSource()==cancelBtn){
			hr.change("startmenu");
			selectRow = -1;
		}
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		selectRow = tbl.getSelectedRow();
		System.out.println(selectRow);
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
