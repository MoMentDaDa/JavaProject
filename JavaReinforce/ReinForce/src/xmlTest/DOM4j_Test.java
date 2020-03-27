package xmlTest;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class DOM4j_Test {
	@Test
	public void testGetALL() throws Exception {
		File f = new File("C:\\Users\\汪哒哒\\Documents\\JavaProject\\JavaReinforce\\ReinForce\\resources\\Students.xml");
		SAXReader r = new SAXReader();
		Document doc = r.read(f);
		Element rootEle = doc.getRootElement();
		// 获取linkman的list数组
		List<Element> list = rootEle.elements("linkman");
		for (Element E : list) {
			// 根据元素名称获取元素
			// Element nameE1=E.element("name");
			// String aString=nameE1.getText();
			String id = E.attributeValue("id");
			System.out.println(id);
			String name = E.elementText("name");
			System.out.println(name);
			String email = E.elementText("email");
			System.out.println(email);
			String add = E.elementText("address");
			System.out.println(add);
			String group = E.elementText("group");
			System.out.println(group);
			System.out.println("===============");
		}
	}

	@Test
	public void testSetDocument() throws Exception {
		File f = new File("C:\\Users\\汪哒哒\\Documents\\JavaProject\\JavaReinforce\\ReinForce\\resources\\Students.xml");
		SAXReader r = new SAXReader();
		Document doc = r.read(f);
		Element rootEle = doc.getRootElement();
		// 创建linkman元素，并把linkman元素设置为根元素的子元素
		Element linkmanE = rootEle.addElement("linkman").addAttribute("id", "4");
		// 创建各个子元素
		linkmanE.addElement("name").setText("西门");
		linkmanE.addElement("email").setText("ximen@qq");
		linkmanE.addElement("address").setText("万梅血装");
		linkmanE.addElement("group").setText("xiaogag");
		// 同步操作,使用格式化输出
		FileWriter outFileWriter = new FileWriter(f);
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(outFileWriter, format);
		writer.write(doc);
		outFileWriter.close();
	}
}
