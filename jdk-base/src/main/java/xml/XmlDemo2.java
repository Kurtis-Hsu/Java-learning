package xml;

import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;

public class XmlDemo2
{
    public static void main(String... args) throws Exception
    {
        var root = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse("example.xml")
                .getDocumentElement();

        for (var item = root.getFirstChild(); item != null; item = item.getNextSibling())
            if (item instanceof Element e)
            {
                var attributes = e.getAttributes();
                for (var i = 0; i < attributes.getLength(); i++)
                {
                    var attr = attributes.item(i);
                    System.out.printf("%s: %s%n", attr.getNodeName(), attr.getNodeValue());
                }
            }
    }
}
