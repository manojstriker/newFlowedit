package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertiesReusabuls {
	  String Filename;
	  Properties prop;
	  File file;
	  FileInputStream fis;
	  String value;
      public PropertiesReusabuls(String Fileneme) throws FileNotFoundException{
		  this.Filename=Fileneme;
		  prop=new Properties();
		  file=new File(Fileneme);
		  fis=new FileInputStream(file);
		}
      
      public  String getProperty(String key) throws IOException {
    	  prop.load(fis);
    	  return prop.getProperty(key);
        }
       
      public void setProperty(String key,String value) throws IOException {
    	  prop.load(fis);
    	  prop.setProperty(key, value);
    	  prop.store(new FileOutputStream(file), null);
    	  
        }
	  public void removeProperty(String key) throws IOException {
		 prop.load(fis);
		 prop.remove(key);
		 prop.store(new FileOutputStream(file), null);
	   }
	   }
