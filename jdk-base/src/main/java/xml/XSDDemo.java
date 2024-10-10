package xml;

import javax.xml.parsers.DocumentBuilderFactory;

public class XSDDemo
{
    public static void main(String... args)
    {
        var jaxpSchemaLang = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
        var w3cXMLSchema = "http://www.w3.org/2001/XMLSchema";
        var factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setAttribute(jaxpSchemaLang, w3cXMLSchema);
    }
}
