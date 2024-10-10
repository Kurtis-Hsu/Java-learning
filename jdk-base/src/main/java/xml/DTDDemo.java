package xml;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilderFactory;

public class DTDDemo
{
    public static void main(String... args) throws Exception
    {
        var factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true); // 开启验证
        factory.setIgnoringElementContentWhitespace(true); // 忽略 DTD 中未定义的无效文本

        var builder = factory.newDocumentBuilder();
        builder.setErrorHandler(new CustomHandler());
        var root = builder.parse("dtd-example.xml").getDocumentElement();
        for (var node = root.getFirstChild(); node != null; node = node.getNextSibling())
            System.out.println(node.getNodeName());
    }

    private static class CustomHandler implements ErrorHandler
    {
        @Override public void warning(SAXParseException exception) { System.out.println("warning..."); }

        @Override public void error(SAXParseException exception) { System.out.println("error..."); }

        @Override public void fatalError(SAXParseException exception) { System.out.println("fatalError..."); }
    }
}
