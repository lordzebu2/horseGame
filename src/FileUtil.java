import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.table.DefaultTableModel;

public class FileUtil {
	static int rowCount(String file){
		
		FileReader fr = null;
		BufferedReader br = null;
		String num = null;
		
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				String line = null;
				while((line = br.readLine())!=null){
					String[] str = line.split("/");
					num = str[0];
				}
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try{
					if(br!=null){
						br.close();
					}
				}catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
			return Integer.parseInt(num);
	}
	
	static void OpenFile(DefaultTableModel model, String find) {
		model.setNumRows(0);
		File f1 = new File("./HorseList/Horse.txt");
		FileReader fr = null;
		BufferedReader br = null;
		String[] str = null;

		try {
			fr = new FileReader(f1);
			br = new BufferedReader(fr);
			String l = null;
			while ((l = br.readLine()) != null) {
				str = l.split("/");
				if (find.equals("전체")) {
					model.addRow(str);
				} else if (find.equals(str[3])) {
					model.addRow(str);
				}
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	
	static void fileSave(DefaultTableModel model, String find) {
		String header[] = { "번호", "이름", "나이", "신장(cm)", "무게(kg)", "배당률" };
		String contents[][] = {};
		DefaultTableModel modelAll = new DefaultTableModel(contents, header);
		File f1 = new File("./HorseList/Horse.txt");
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		PrintWriter pw = null;
		String[] str = null;

		try {
			fr = new FileReader(f1);
			br = new BufferedReader(fr);
			String l = null;
			while ((l = br.readLine()) != null) {
				str = l.split("/");
				modelAll.addRow(str);
			}
			fw = new FileWriter(f1);
			pw = new PrintWriter(fw);
			if(find.equals("전체")) {
				for (int i = 0; i < model.getRowCount(); i++) {
					for (int j = 0; j < model.getColumnCount(); j++) {
						pw.print(model.getValueAt(i, j));
						if(j < model.getColumnCount()-1) {
							pw.print("/");
						}
					}
					pw.println();
				}
			}else {
				for (int i = 0; i < modelAll.getRowCount(); i++) {
					for (int j = 0; j < model.getRowCount(); j++) {
						if(model.getValueAt(j, 0).equals(modelAll.getValueAt(i, 0))) {
							for (int j2 = 0; j2 < model.getColumnCount(); j2++) {
								pw.print(model.getValueAt(j, j2));
								if(j2 < model.getColumnCount()-1) {
									pw.print("/");
								}
							}
							pw.println();
							break;
						}else if(!model.getValueAt(j, 3).equals(modelAll.getValueAt(i, 3))) {
							for (int j2 = 0; j2 < modelAll.getColumnCount(); j2++) {
								pw.print(modelAll.getValueAt(i, j2));
								if(j2 < modelAll.getColumnCount()-1) {
									pw.print("/");
								}
							}
							pw.println();
							break;
						}
					}
				}
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if(pw != null) {
					pw.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	} 
	
}