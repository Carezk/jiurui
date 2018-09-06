package com.jiurui;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**    
* @author zk  
* @date 2018年9月6日  
*/
public class GetSource {
	public  ArrayList<Student> getStudent() {
		    ArrayList<Student> list = new ArrayList<>();
		    
		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder;
		    try {
				builder = factory.newDocumentBuilder();
				Document doc;
				doc = builder.parse(new File("src\\file\\Student.xml"));
				//得到一个element根元素,获得根节点
				Element root = doc.getDocumentElement();
				System.out.println("根元素: "+root.getNodeName());
				
				//子节点
				NodeList studentNodes = root.getElementsByTagName("student");
				for (int i = 0; i < studentNodes.getLength(); i++) {
					Element studentElement = (Element)studentNodes.item(i);
					Student student = new Student();
					NodeList childNodes = studentElement.getChildNodes();
					
					for (int j = 0; j < childNodes.getLength(); j++) {
						if(childNodes.item(j).getNodeType()==Node.ELEMENT_NODE){
							if("name".equals(childNodes.item(j).getNodeName())){
								student.setName(childNodes.item(j).getFirstChild().getNodeValue());
							}else if("sex".equals(childNodes.item(j).getNodeName())){
								student.setSex(childNodes.item(j).getFirstChild().getNodeValue());
							}else if ("idcard".equals(childNodes.item(j).getNodeName())) {
								student.setIdcard(childNodes.item(j).getFirstChild().getNodeValue());
							}
						}
					}
					list.add(student);
				}
				for (Student student : list) {
					System.out.println(student.getName()+" "+student.getSex()+" "+student.getIdcard());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;
	}
}
