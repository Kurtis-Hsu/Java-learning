package xml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import java.io.FileInputStream;

public class StAXDemo
{
    public static void main(String... args) throws Exception
    {
        var factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, false); // 命名空间处理是默认开启的
        var parser = factory.createXMLStreamReader(new FileInputStream("example.xml"));

        while (parser.hasNext())
        {
            var event = parser.next();
            if (event == XMLStreamConstants.START_ELEMENT)
            {
                var value = parser.getAttributeValue(null, "unit");
                if (value != null) System.out.println(value);
            }
        }
    }
}
