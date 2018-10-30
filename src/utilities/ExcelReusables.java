package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class ExcelReusables {


	static XSSFSheet sheet;
	static XSSFWorkbook workbook;
	static XSSFCell cell;
	static XSSFRow row;
	static String filename;
	XSSFFormulaEvaluator evaluator =null;
	int intCurrentRowNumber=1;
	public ExcelReusables(String filename) throws FileNotFoundException	

	{

		this.filename=filename;
		
		
	}

	public static  String getCellData(int rowNum,int cellNum,String sheetnmame) throws IOException
	{	
		workbook=new XSSFWorkbook(new FileInputStream(new File(filename)));
		sheet=workbook.getSheet(sheetnmame);
		cell=sheet.getRow(rowNum).getCell(cellNum);
		if(cell.getCellType()==cell.CELL_TYPE_STRING)
		{
			return cell.getStringCellValue();
		}
		else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
		{
			return String.valueOf(cell.getNumericCellValue());
		}

		return null;
	}

	public static String getCellData(String sheetnmame,String value) throws IOException
	{	
		workbook=new XSSFWorkbook(new FileInputStream(new File(filename)));
		sheet=workbook.getSheet(sheetnmame);
		String data=null;
		
		for(int i=0;i<sheet.getRow(0).getLastCellNum();i++)
		{
			cell=sheet.getRow(0).getCell(i);
		if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
		{
			data=cell.getStringCellValue();
		}
		else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
		{
			data= String.valueOf(cell.getNumericCellValue());
		}
		else if(cell.getCellType()==cell.CELL_TYPE_BOOLEAN)
		{
			data= String.valueOf(cell.getBooleanCellValue());
		}
		
		if(data.equalsIgnoreCase(value))
				{
			return sheet.getRow(1).getCell(i).getStringCellValue();
			
				}
		}
				
				

		return null;
	}
	
	public static void writeCellData(int rowNum,int cellNum,String sheetnmame,String value) throws IOException
	{	
		workbook=new XSSFWorkbook(new FileInputStream(new File(filename)));
	
		if(workbook.getSheet(sheetnmame)!=null)
		{
		sheet=workbook.getSheet(sheetnmame);
		}
		else{
			sheet=workbook.createSheet(sheetnmame);
		}
		
		 cell=sheet.createRow(rowNum).createCell(cellNum);
		 cell.setCellValue(value);
		 workbook.write(new FileOutputStream(new File(filename)));
		
		}
				
				

	public static void writeCellData(String sheetnmame,String value) throws IOException
	{	
		workbook=new XSSFWorkbook(new FileInputStream(new File(filename)));
		sheet=workbook.getSheet(sheetnmame);
		String data=null;
		
		if(workbook.getSheet(sheetnmame)!=null)
		{
		sheet=workbook.getSheet(sheetnmame);
		}
		else{
			sheet=workbook.createSheet(sheetnmame);
		}
		
		 row=sheet.createRow(sheet.getLastRowNum());
		
		cell=sheet.createRow(sheet.getLastRowNum()+1).createCell(row.getLastCellNum()+1);
		 cell.setCellValue(value);
		 workbook.write(new FileOutputStream(new File(filename)));
		
	}
	
	
	private int getColumnNumber(String ColumnName){
		int ColumnPosition=0;
		try{
			
			CellValue cellValue;
			do{
				 row=sheet.getRow(0);
				cell=row.getCell(ColumnPosition);
				cellValue=evaluator.evaluate(cell);
				if((cellValue.getStringValue().toString()).equalsIgnoreCase(ColumnName)){
					break;
					
				}
				ColumnPosition++;
				
			}
			while((cell!=null)&&!(cellValue.getStringValue().toString().equalsIgnoreCase(ColumnName)));
		}catch(Exception e){
			System.out.println("ColumnName"+ColumnName+"Doesn't Exist");
			System.exit(0);
		}
		return ColumnPosition; 
	}
	
	  // method get user data;gets the value from excel sheets cell from a given column
	//@param column name 
	//returnstring.cellvalue
	//throws Io exception  
/*	public String getuserData (String columnName)throws IOException
	{
		String cellFlag=null;
		try{
			Row row = sheet.getRow (intCurrentRowNumber);
			Cell cell=(Cell) row.getCell(getColumnNumber (columnName));
			CellValue cellvalue=evaluator.evaluate((org.apache.poi.ss.usermodel.Cell) cell);
			if (cell==null)
			cellFlag=" //";
			else {
			
				try {switch (cellvalue.getCellType())
				
			{
				case Cell.CELL_TYPE_STRING:
				cellFlag=cellvalue.getStringValue().trim().toString();
				break;
				case Cell.CELL_TYPE_FORMULA:
				break;
				case Cell.CELL_TYPE_NUMERIC:
					String[] tempflag;
					tempflag=Double.toString(cellvalue.getNumberValue()).split("\\.");
					cellFlag=tempflag[0].trim().toString();
					break;
				case Cell.CELL_TYPE_BLANK:
				cellFlag="";
				break; 
				case Cell.CELL_TYPE_BOOLEAN:
					cellFlag=Boolean.toString(cellvalue.getBooleanValue());
				break;
			}}catch (NullPointerException k){
					cellFlag="";
					evaluator=null;
				}}}
		
				 
			catch(Exception e)
			{
				//e.print stack trace();//
				System.out.println("reached end of the rows in test data sheet ");
				System.exit(0);
			}
		return cellFlag;
		}
	
	
/*	public boolean setCellData() {
	 try
     {
         int col_Num = -1;
         sheet = workbook.getSheet(String sheetName, String colName, int rowNum, String value);

         row = sheet.getRow(0);
         for (int i = 0; i < row.getLastCellNum(); i++) {
             if (row.getCell(i).getStringCellValue().trim().equals(colName))
             {
                 col_Num = i;
             }
         }

         sheet.autoSizeColumn(col_Num);
         row = sheet.getRow(rowNum - 1);
         if(row==null)
             row = sheet.createRow(rowNum - 1);

         cell = row.getCell(col_Num);
         if(cell == null)
             cell = row.createCell(col_Num);

         cell.setCellValue(value);

         fos = new FileOutputStream(xlFilePath);
         workbook.write(fos);
         fos.close();
     }
     catch (Exception ex)
     {
         ex.printStackTrace();
         return  false;
     }
     return true;
 }
*/
	
	

}