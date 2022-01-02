import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class HorseManager extends JPanel implements ActionListener, MouseListener{
	
	JTextField tfName, tfAge, tfHeight, tfWeight, tfOdds;
	DefaultTableModel model;
	JTable tableItem;
	JPanel pnlCenter, pnlSouth, pnlInput, pnlBtn;
	JButton btnAdd, btnDel, btnModify, btnSave, btnClose;
	String find;
	Main main;
	
	public HorseManager(Main main) {
		this.main = main;
		pnlCenter = new JPanel();
		String header[] = { "번호", "이름", "나이", "신장(cm)", "무게(kg)", "배당률" };
		String contents[][] = {};
		model = new DefaultTableModel(contents, header);
		tableItem = new JTable(model);
		JScrollPane sp = new JScrollPane(tableItem);
		sp.setPreferredSize(new Dimension(580, 350));
		
		pnlCenter.add(sp);
		this.add(pnlCenter, "Center");
		
		pnlSouth = new JPanel(new BorderLayout());
		
		pnlInput = new JPanel();
		
		tfName = new JTextField("이름",8);
		tfName.addMouseListener(this);
		
		tfAge = new JTextField("나이",8);
		tfAge.addMouseListener(this);
		
		tfHeight = new JTextField("신장",8);
		tfHeight.addMouseListener(this);
		
		tfWeight = new JTextField("몸무게",8);
		tfWeight.addMouseListener(this);
		
		tfOdds = new JTextField("배당률",8);
		tfOdds.addMouseListener(this);
		
		pnlInput.add(tfName);
		pnlInput.add(tfAge);
		pnlInput.add(tfHeight);
		pnlInput.add(tfWeight);
		pnlInput.add(tfOdds);
		
		pnlSouth.add(pnlInput,"North");
		
		pnlBtn = new JPanel();
		
		btnAdd = new JButton("등록");
		btnAdd.addActionListener(this);
		btnAdd.setBackground(Color.white);
		btnAdd.setPreferredSize(new Dimension(100,40));
		
		btnDel = new JButton("삭제");
		btnDel.addActionListener(this);
		btnDel.setBackground(Color.white);
		btnDel.setPreferredSize(new Dimension(100,40));
		
		btnModify = new JButton("수정");
		btnModify.addActionListener(this);
		btnModify.setBackground(Color.white);
		btnModify.setPreferredSize(new Dimension(100,40));
		
		btnSave = new JButton("저장");
		btnSave.addActionListener(this);
		btnSave.setBackground(Color.white);
		btnSave.setPreferredSize(new Dimension(100,40));
		
		btnClose = new JButton("종료");
		btnClose.addActionListener(this);
		btnClose.setBackground(Color.white);
		btnClose.setPreferredSize(new Dimension(100,40));
		
		pnlBtn.add(btnAdd);
		pnlBtn.add(btnDel);
		pnlBtn.add(btnModify);
		pnlBtn.add(btnSave);
		pnlBtn.add(btnClose);
		
		pnlSouth.add(pnlBtn);
		this.add(pnlSouth,"South");
		
		find = "전체";
		FileUtil.OpenFile(model, find);
		
		this.setVisible(true);
	}
	
	void addlist() {
		File itemf = null;
		FileWriter itemfw = null;
		PrintWriter itempw = null;
		
		try {
			int totalCnt = FileUtil.rowCount("././HorseList/Horse.txt");
			itemf = new File("././HorseList/Horse.txt");
			itemfw = new FileWriter(itemf, true);
			itempw = new PrintWriter(itemfw);
			
			String [] str = new String[6];
			str[0]=(totalCnt+1)+"";
			str[1]=tfName.getText();
			str[2]=tfAge.getText();
			str[3]=tfHeight.getText();
			str[4]=tfWeight.getText();
			str[5]=tfOdds.getText();
			
			for (int i = 0; i < str.length; i++) {
				itempw.print(str[i]);
				if(i < str.length-1) {
					itempw.print("/");
				}
			}
			itempw.println();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(itempw != null) {
				itempw.close();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnAdd) {
			this.addlist();
			FileUtil.OpenFile(model ,find);	
		} else if (e.getSource()==btnDel) {
			model.removeRow(tableItem.getSelectedRow());
		} else if(e.getSource()==btnModify) {
			if (tableItem.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "선택된 항목이 없습니다.");
			}
			new ModifyPopup(tableItem);
		} else if(e.getSource()==btnSave) {
			FileUtil.fileSave(model, find);
		} else if(e.getSource()==btnClose) {
			main.add(main.sm);
			main.remove(this);
			main.repaint();
			main.revalidate();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==tfName) {
			tfName.setText("");
		} else if (e.getSource()==tfAge) {
			tfAge.setText("");
		} else if (e.getSource()==tfHeight) {
			tfHeight.setText("");
		} else if (e.getSource()==tfWeight) {
			tfWeight.setText("");
		} else if (e.getSource()==tfOdds) {
			tfOdds.setText("");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}