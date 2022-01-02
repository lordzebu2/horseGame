import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ModifyPopup extends JDialog implements ActionListener{
	JTextField tfName, tfAge, tfHeight, tfWeight, tfOdds;
	JLabel name, age, height, weight, odds;
	JPanel pnl, pnlSouth;
	JButton btnConfirm, btnCancel;
	JTable tableItem;

	public ModifyPopup(JTable tableItem) {
		this.tableItem = tableItem;
		this.setSize(300,400);

		pnl = new JPanel(new GridLayout(0,2,10,30));
		pnl.setBorder(BorderFactory.createEmptyBorder(10,20,10, 50));

		tfName = new JTextField(tableItem.getValueAt(tableItem.getSelectedRow(), 1)+"",10);
		tfAge = new JTextField(tableItem.getValueAt(tableItem.getSelectedRow(), 2)+"",10);
		tfHeight = new JTextField(tableItem.getValueAt(tableItem.getSelectedRow(), 3)+"",10);
		tfWeight = new JTextField(tableItem.getValueAt(tableItem.getSelectedRow(), 4)+"",10);
		tfOdds = new JTextField(tableItem.getValueAt(tableItem.getSelectedRow(), 5)+"",10);

		name = new JLabel("이름 :");
		name.setHorizontalAlignment(JLabel.CENTER);
		age = new JLabel("나이 :");
		age.setHorizontalAlignment(JLabel.CENTER);
		height = new JLabel("신장(cm) :");
		height.setHorizontalAlignment(JLabel.CENTER);
		weight = new JLabel("무게(kg) :");
		weight.setHorizontalAlignment(JLabel.CENTER);
		odds = new JLabel("배당률 :");
		odds.setHorizontalAlignment(JLabel.CENTER);

		pnl.add(name);
		pnl.add(tfName);

		pnl.add(age);
		pnl.add(tfAge);

		pnl.add(height);
		pnl.add(tfHeight);

		pnl.add(weight);
		pnl.add(tfWeight);

		pnl.add(odds);
		pnl.add(tfOdds);		

		this.add(pnl);

		pnlSouth = new JPanel();

		btnConfirm = new JButton("확인");
		btnConfirm.setBackground(Color.white);
		btnConfirm.setPreferredSize(new Dimension(100,40));
		btnConfirm.addActionListener(this);

		btnCancel = new JButton("취소");
		btnCancel.setBackground(Color.white);
		btnCancel.setPreferredSize(new Dimension(100,40));
		btnCancel.addActionListener(this);

		pnlSouth.add(btnConfirm);
		pnlSouth.add(btnCancel);
		this.add(pnlSouth,"South");
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnConfirm) {
			tableItem.setValueAt(tfName.getText(), tableItem.getSelectedRow(), 1);
			tableItem.setValueAt(tfAge.getText(), tableItem.getSelectedRow(), 2);
			tableItem.setValueAt(tfHeight.getText(), tableItem.getSelectedRow(), 3);
			tableItem.setValueAt(tfWeight.getText(), tableItem.getSelectedRow(), 4);
			tableItem.setValueAt(tfOdds.getText(), tableItem.getSelectedRow(), 5);
			this.dispose();			
		} else if(e.getSource()==btnCancel) {
			this.dispose();
		}

	}
}
