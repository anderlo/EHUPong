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
		this.hasieratuZutabeIzenak();
		
	
	}
	public int getRowCount() {
		
		return data.size();
	}
	public Class<?> getColumnClass(int col){
		return RankingInfo.getColumnClass(col);	
		
	}
	public boolean isCellEditable(int row, int col) { 
        	return false;   
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
		this.columnNames.add(0,	Textua.getT().textuaLortu("column1"));
		this.columnNames.add(1,	Textua.getT().textuaLortu("column2"));
		this.columnNames.add(2, Textua.getT().textuaLortu("column3"));
		this.columnNames.add(3, Textua.getT().textuaLortu("column4"));
	}
	
	public void gehitu(RankingInfo ri) {
		data.add(ri);
	}




}
