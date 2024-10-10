package xml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

public class XPathDemo
{
    public static void main(String... args) throws Exception
    {
        var docFactory = DocumentBuilderFactory.newInstance();
        var builder = docFactory.newDocumentBuilder();
        var doc = builder.parse("example.xml");

        var pathFactory = XPathFactory.newInstance();
        var path = pathFactory.newXPath();

        var s = path.evaluate("/font/size/@unit", doc);
        System.out.println(s);

        var node = path.evaluate("/font/size/@unit", doc, XPathConstants.NODE);
        System.out.println(node);
    }
}
