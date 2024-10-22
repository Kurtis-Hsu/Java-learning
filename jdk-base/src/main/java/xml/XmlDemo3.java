package xml;

import javax.xml.parsers.DocumentBuilderFactory;

/// 创建 xml 文档
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

        child.setAttribute("attr", "demo");

        document.appendChild(root);
        root.appendChild(child);
        child.appendChild(text);
    }
}
