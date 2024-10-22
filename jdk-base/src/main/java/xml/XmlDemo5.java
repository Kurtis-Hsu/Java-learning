package xml;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/// 写出文档
public class XmlDemo5
{
    public static void main(String... args) throws Exception
    {
        var doc = createDocument();

        System.out.println("===== Transformer =====");

        var transformer = TransformerFactory.newInstance().newTransformer();

        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "win 11");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "public");

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        transformer.transform(new DOMSource(doc), new StreamResult(System.out));

        System.out.println();
        System.out.println("===== DOMImplementation =====");

        var impl = doc.getImplementation();
        var implLS = (DOMImplementationLS) impl.getFeature("LS", "3.0");
        var ser = implLS.createLSSerializer();

        ser.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);
        System.out.println(ser.writeToString(doc));
    }

    public static Document createDocument() throws Exception
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


        return document;
    }
}
