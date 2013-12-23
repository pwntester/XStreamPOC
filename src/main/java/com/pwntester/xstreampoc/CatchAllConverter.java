package com.pwntester.xstreampoc;

/**
 * Created with IntelliJ IDEA.
 * User: alvaro
 * Date: 23/12/13
 * Time: 14:29
 * To change this template use File | Settings | File Templates.
 */
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class CatchAllConverter implements Converter {

    public boolean canConvert(Class clazz) {
        return true;
    }

    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
       return null;
    }

}
