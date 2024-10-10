package xml;

import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilderFactory;

public class XmlDemo1
{
    public static void main(String... args) throws Exception
    {
        var factory = DocumentBuilderFactory.newInstance();
        var builder = factory.newDocumentBuilder();

        var doc = builder.parse("example.xml");

        var root = doc.getDocumentElement(); // 获取根元素
        System.out.println(root.getTagName());

        System.out.println("=====");
        var children = root.getChildNodes();
        for (var i = 0; i < children.getLength(); i++)
        {
            var item = children.item(i);
            if (item instanceof Element e)
                System.out.println(((Text) e.getFirstChild()).getData().trim());
        }

        System.out.println("=====");
        for (var item = root.getFirstChild(); item != null; item = item.getNextSibling())
            if (item instanceof Element e)
                System.out.println(((Text) e.getFirstChild()).getData().trim());
    }
}
