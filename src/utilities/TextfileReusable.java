package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextfileReusable {
	static String path;
	static File file;
	static FileWriter fwriter;
	static BufferedWriter bufferedwriter;
	static FileReader freader;
	static BufferedReader bufferedreader;
	
	TextfileReusable(String filepath){
		TextfileReusable.path=filepath;
	}
	public static void fileWriter() throws Exception {
		file=new File(path);
		file.createNewFile();
		fwriter=new FileWriter(file);
		bufferedwriter=new BufferedWriter(fwriter);
	}
	public static void FileReader() throws Exception {
		file=new File(path);
		freader=new FileReader(file);
		bufferedreader =new BufferedReader(freader);
		}
	public static void setStringData(String data) throws IOException {
		bufferedwriter.newLine();
		bufferedwriter.write(data);
		bufferedwriter.flush();
		
	}
	public static void setIntData(int data) throws Exception {
		bufferedwriter.newLine();
		bufferedwriter.write(data);
		bufferedwriter.flush();
	}
	public String readData() throws IOException{
		 String data=bufferedreader.readLine();
		 return data;
	 }
	
  }
