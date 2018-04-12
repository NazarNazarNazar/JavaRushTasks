package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "shop")
@XmlRootElement
public class Shop {

    public Goods goods = new Goods();
    public int count = 12;
    public double profit = 123.4;
    public String[] secretData = new String[]{
            "String1", "String2", "String3", "String4", "String5"
    };

    @XmlType(name = "goods")
    static class Goods {
        @XmlElement(name = "names")
        public List<String> names = new ArrayList<>();
        {
            names.add("S1");
            names.add("S2");
        }
    }


}
