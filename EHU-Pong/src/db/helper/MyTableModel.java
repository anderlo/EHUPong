package db.helper;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

import info.helper.RankingInfo;
import languages.*;
public class MyTableModel extends AbstractTableModel {

	private Vector<RankingInfo> data = new Vector<RankingInfo>();
	private Vector<String> columnNames = new Vector<String>();
	public MyTableModel(Vector<RankingInfo> a) {
		this.data = a;
		this.kargatu();
	}
	private void kargatu() {
		// TODO Auto-generated method stub
		this.hasieratuZutabeIzenak();
		
	
	}
	public int getRowCount() {
		return data.size();
	}
	public Class<?> getColumnClass(int col){
		if(col==0) {
			return String.class;
		}
		else if(col==1||col==2) {
			return Float.class;
		}else {
			return String.class;
		}
		
		
	}
	public boolean isCellEditable(int row, int col) { 
        //if(col==0||col==1||col==3||col==4) {
		//return true;
        //}else {
        	return false;
        	// }   
    }
	
	public int getColumnCount() {
		return columnNames.size(); //getColumNames
	}
	public String getColumnName(int i) {
		return columnNames.get(i);//getColumNames
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data.get(rowIndex).getBalioa(columnIndex) ;
	}


	public void hasieratuZutabeIzenak() {
		this.columnNames.add(0,	Textua.getT().textuaLortu("izena"));
		this.columnNames.add(1,	Textua.getT().textuaLortu("puntuak"));
		this.columnNames.add(2, 	Textua.getT().textuaLortu("irabazlea"));
		this.columnNames.add(3, 	Textua.getT().textuaLortu("denbora"));
	}
	
	public void gehitu(RankingInfo ri) {
		data.add(ri);
	}




}
