package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.sourceforge.htmlunit.corejs.javascript.ObjToIntMap.Iterator;

public class PrcXcal {

	
	static String Filename;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static Cell cell;
	 
	 public PrcXcal(String Filename) {
		  this.Filename=Filename;
		  try {
			FileInputStream fis=new FileInputStream(new File(Filename));
			 workbook=new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
		  e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	  }
	 public XSSFSheet getSheet(String Sheetname) {
		 sheet=workbook.getSheet(Sheetname);
		 return sheet;
		 
	 }
	 
	
		
		public static void gettotllaData(String sheetname) {
			sheet=workbook.getSheet(sheetname);
			
			java.util.Iterator<Row> rowiterator=sheet.rowIterator();
			while(rowiterator.hasNext()) {
				row=(XSSFRow) rowiterator.next();
				
				java.util.Iterator<Cell> celliterator=row.cellIterator();
				 while(celliterator.hasNext()) {
					 cell= celliterator.next();
					 switch(cell.getCellType()) {
					 
					 }
				 }
			}
			
			
		}
	
	
}
