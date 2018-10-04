package utilities;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
 public class XmlReader {
String filepath;
  DocumentBuilderFactory dbFactory;
 DocumentBuilder dBuilder;
  Document doc;
  String value;
 static NodeList nlist;
 public XmlReader(String filepath) {
	   this.filepath=System.getProperty("user.dir")+"//src//testData//"+filepath;
   }
   public  String getdata(String datasetname,String keyValue) throws Exception{
   dbFactory=DocumentBuilderFactory.newInstance();
   dBuilder=  dbFactory.newDocumentBuilder();
   doc=dBuilder.parse(this.filepath=filepath);
   nlist=doc.getElementsByTagName("dataset");
   for(int imp=0; imp<nlist.getLength();imp++){
	   Node nNode =  nlist.item(imp);
	   Element eElement= (Element) nNode;
	   if (eElement.getAttribute("name").equalsIgnoreCase(datasetname)) 
		  {	
	       value=eElement.getElementsByTagName(keyValue).item(0).getTextContent();
	       return value;
		   }
 	   } return null;
}
}
