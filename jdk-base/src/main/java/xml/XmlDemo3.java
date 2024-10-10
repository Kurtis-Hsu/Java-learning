package xml;

import javax.xml.parsers.DocumentBuilderFactory;

public class XmlDemo3
{
    public static void main(String... args) throws Exception
    {
        var factory = DocumentBuilderFactory.newInstance();
        var builder = factory.newDocumentBuilder();

        var document = builder.newDocument();
        var root = document.createElement("root");
        var child = document.createElement("child");

        var text = document.createTextNode("contents");
    }
}
