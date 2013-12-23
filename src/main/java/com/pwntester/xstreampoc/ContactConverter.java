package com.pwntester.xstreampoc;

/**
 * Created with IntelliJ IDEA.
 * User: alvaro
 * Date: 23/12/13
 * Time: 14:22
 * To change this template use File | Settings | File Templates.
 */
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ContactConverter implements Converter {

    public boolean canConvert(Class clazz) {
        return clazz.equals(Contact.class);
    }

    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
        Contact contact = (Contact) value;
        writer.startNode("name");
        writer.setValue(contact.getName());
        writer.endNode();
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Contact contact = new Contact();
        reader.moveDown();
        contact.setName(reader.getValue());
        reader.moveUp();
        return contact;
    }

}
