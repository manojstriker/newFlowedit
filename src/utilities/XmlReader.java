package utilities;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
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
  Attr attr;
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
   public void writedata(String datasetname,String keyValue,String data) throws Exception {
	   DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
	   DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
	   Document document = documentBuilder.newDocument();

	   Element testdata = document.createElement("Testdata");
	   document.appendChild(testdata);
	   
	   Element dataset = document.createElement("datasetname");
	   testdata.appendChild(dataset);
	   Attr attr = document.createAttribute(keyValue);
	   attr.setValue(data);
	   dataset.setAttributeNode(attr);
	   TransformerFactory  transformerFactory = TransformerFactory.newInstance();
	   Transformer    transformer = transformerFactory.newTransformer();
	   DOMSource   source = new DOMSource(doc);
	   StreamResult result = new StreamResult(new File(filepath));
	  transformer.transform(source, result);

			  
   }
   
}
