package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParserFactory;

public class SAXDemo
{
    public static void main(String... args) throws Exception
    {
        var factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true); // 开启命名空间处理
        var parser = factory.newSAXParser();

        var handler = new DefaultHandler()
        {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)
            {
                System.out.printf(
                        "URI: %s, localName: %s, qName: %s, attributes: %s%n",
                        uri, localName, qName, attributes
                );
            }
        };

        parser.parse("example.xml", handler);
    }
}
