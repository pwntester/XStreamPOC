package com.pwntester.xstreampoc;

import java.io.IOException;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.beans.EventHandler;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: alvaro
 * Date: 23/12/13
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(Contact.class);
        xstream.registerConverter(new ContactConverter());
        xstream.registerConverter(new CatchAllConverter(), XStream.PRIORITY_VERY_LOW);

        Contact c = new Contact();
        c.setName("Alvaro");
        String sc = xstream.toXML(c);
        System.out.println(sc);

        //Set<Comparable> set = new TreeSet<Comparable>();
        //set.add("foo");
        //set.add(EventHandler.create(Comparable.class, new ProcessBuilder("/Applications/Calculator.app/Contents/MacOS/Calculator"), "start"));
        //String payload2 = xstream.toXML(set);
        //System.out.println(payload2);

        String payload = "<sorted-set>" +
                "<string>foo</string>" +
                "<dynamic-proxy>" +
                "<interface>java.lang.Comparable</interface>" +
                "<handler class=\"java.beans.EventHandler\">" +
                " <target class=\"java.lang.ProcessBuilder\">" +
                " <command>" +
                " <string>/Applications/Calculator.app/Contents/MacOS/Calculator</string>" +
                " </command>" +
                " </target>" +
                " <action>start</action>" +
                "</handler>" +
                "</dynamic-proxy>" +
                "</sorted-set>";

        try {
            Contact expl = (Contact) xstream.fromXML(payload);
        } catch (com.thoughtworks.xstream.converters.ConversionException ex) {
            System.out.println("Trying to deserialize null object. Make sure the input is not null and that your custom converters have higher priority than the Catch-All converter");
        }
    }
}
