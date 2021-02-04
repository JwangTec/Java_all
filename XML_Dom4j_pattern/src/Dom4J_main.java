import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.Collections;
import java.util.List;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/4 下午2:40
 */
public class Dom4J_main {
    /**
     * 解析器
     *
     */
    public static void main(String[] args) throws DocumentException {
//        SAX_xml();

        final SAXReader saxReader = new SAXReader();
        final Document document = saxReader.read("XML_Dom4j_pattern/src/person.xml");

        //document对象api:selectSingleNode("Xpath语法")：获得一个节点

        System.out.println("-----绝对路径------");
        //Xpath使用绝对路径,获取第一个
        final Element node = (Element) document.selectSingleNode("/person/name");
        System.out.println(node.getText());

        System.out.println("-----------");
        //Xpath获取每个element
        final List<Element> list = document.selectNodes("/person/name");
        for (Element element : list) {
            System.out.println(element.getText());
        }
        System.out.println("-----相对路径获取------");

        // ./当前元素 ../上一个元素
        // //全文搜索路径
        // //元素[@attr1=""]

    }

    private static void SAX_xml() throws DocumentException {
        //创建解析器对象
        SAXReader sr = new SAXReader();

        //解析生成Document对象
        final Document document = sr.read("XML_Dom4j_pattern/src/person.xml");

        //element根元素
        final Element rootElement = document.getRootElement();
        //element子元素
        final List<Element> elements = rootElement.elements();

        //获取person第一个子标签name标签的文本，
        final String elementText = rootElement.elementText("name");
        System.out.println(elementText);

        for (Element element : elements) {
            //标签名
            final String name = element.getName();
            //标签文本内容
            final String text = element.getText();
        }
    }
}
