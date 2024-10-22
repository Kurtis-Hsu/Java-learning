package xml;

import javax.xml.parsers.DocumentBuilderFactory;

/// 创建 xml 时设置命名空间
public class XmlDemo4
{
    public static final String svg_ns = "http://www.w3.org/2000/svg";

    public static void main(String... args) throws Exception
    {
        var factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        var builder = factory.newDocumentBuilder();
        var document = builder.newDocument();

        document.createElementNS(svg_ns, "svg");
    }
}
