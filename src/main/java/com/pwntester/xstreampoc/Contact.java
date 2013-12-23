package com.pwntester.xstreampoc;

/**
 * Created with IntelliJ IDEA.
 * User: alvaro
 * Date: 23/12/13
 * Time: 13:37
 * To change this template use File | Settings | File Templates.
 */



import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("contact")
public class Contact {
    @XStreamAlias("name")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}



