package utilities;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelReusables {
         static XSSFSheet sheet =null;
	     static XSSFCell cell;
	     static XSSFRow row;
	     static XSSFWorkbook wrokbook;
	     static String filename;
	     static XSSFFormulaEvaluator evaluator;
	   
  public ExcelReusables(String filename) throws Exception{
		   ExcelReusables.filename=filename;
		   FileInputStream fis=new FileInputStream(new File(filename));
		   wrokbook=new XSSFWorkbook(fis);
	   }
  public static int getlastrow(String sheetname) {
 	 sheet =wrokbook.getSheet(sheetname);
 	 int rowcount=sheet.getLastRowNum();
 	 System.out.println(rowcount);
 	 return rowcount;
  }
 
 public static int getlastcellvalue(String sheetname,int rownum) {
     sheet=wrokbook.getSheet(sheetname);
 	row=sheet.getRow(rownum);
 	int cellcount=row.getLastCellNum();
 	System.out.println(cellcount);
 	return cellcount;
 }
 public static String getCellvalue(String Sheetname,int rownum,int cellnum) {
 	sheet=wrokbook.getSheet(Sheetname);
     cell=sheet.getRow(rownum).getCell(cellnum);
     String celldata=null;
     if(cell.getCellType()==cell.CELL_TYPE_NUMERIC) {
     	celldata=String.valueOf(cell.getNumericCellValue());
     	return celldata;
     	
     }
     else if(cell.getCellType()==cell.CELL_TYPE_STRING) {
     	celldata=cell.getStringCellValue();
     	return celldata;
     }
     else if(cell.getCellType()==Cell.CELL_TYPE_BOOLEAN){
    	 celldata=String.valueOf(cell.getBooleanCellValue());
    	 return celldata;
		    }
		return celldata;
 	
 }
 public static void setcelldata(String data,String sheetname,int rownum,int cellnum) throws Exception {
 	sheet=wrokbook.getSheet(sheetname);
 	row=sheet.getRow(rownum);
 	cell=row.getCell(cellnum);
 	if(cell==null) {
 		cell=row.createCell(cellnum);
 		cell.setCellValue(data);
 		System.out.println("given "+data +"is created");
 	}
 	else {
 		cell.setCellValue(data);
 	}
 	FileOutputStream fos=new FileOutputStream(filename);
 	wrokbook.write(fos);
 	fos.close();
 }
 
 public static void creaexlSheet(String sheetname) throws Exception{
     FileInputStream fileinput=new FileInputStream(filename);
       sheet=wrokbook.getSheet(sheetname);
     if(sheet==null){
    	 sheet=wrokbook.createSheet(sheetname);
	         System.out.println(sheetname+" is created..");
         }
     else{
    	 System.out.println(sheetname+"is allredy exist");
         }
     FileOutputStream fileout=new FileOutputStream(filename);
     wrokbook.write(fileout);
       fileout.close();
 }   
	   
 public static void getTotalData(String sheetname) throws Exception{
	  FileInputStream fileinput=new FileInputStream(filename);
	  wrokbook=new XSSFWorkbook(fileinput);
      sheet=wrokbook.getSheet(sheetname);
      String datas=null;
      for(int i=0;i<sheet.getLastRowNum();i++){
          row=sheet.getRow(i);
   	   for(int j=0;j<row.getLastCellNum();j++){
   	   cell=row.getCell(j);
       if(cell.getCellType()==cell.CELL_TYPE_STRING){
    	   datas=cell.getStringCellValue();
    	   System.out.println(datas);
	       
	       }
  else if(cell.getCellType()==cell.CELL_TYPE_BOOLEAN){
	       datas=String.valueOf( cell.getBooleanCellValue());
	       System.out.println(datas);
	       }
  else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC){
	  
	  datas=String.valueOf(cell.getNumericCellValue());
	  System.out.println(datas);
      
	       }
  else if(cell==null) {
	  
	    
	
	  datas="";
	
	  System.out.println(datas);
	   
	  
	    
	  
  }
   	   }
   	   }
	
          }
 public static XSSFSheet SetActiveSheet(String SheetName){
		
			sheet=wrokbook.getSheet(SheetName);
			return sheet;
		
	}
 public static int getColumnNumber(String ColumnName){
		int ColumnPosition=0;
		try{
			Cell cell;
			CellValue cellValue;
			do{
				Row row=sheet.getRow(0);
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
}
