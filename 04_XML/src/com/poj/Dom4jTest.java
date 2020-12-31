package com.poj;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class Dom4jTest {
    @Test
    public void test1() throws Exception {
        //创建一个SaxReader 输入流，去读取xml配置文件， 生成document对象
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        System.out.println(document);
    }
    /*
    读取books.xml文件生成Book类
     */
    @Test
    public void test2() throws Exception{
        //1、读取books.xml文件
        SAXReader reader = new SAXReader();
        //2、获取Document对象获取根元素
        Document document = reader.read("src/books.xml");
        //3、通过根元素获取book标签对象
        Element rootElement = document.getRootElement();
//        System.out.println(rootElement);
        //element()  和 elements() 都是通过标签名查找子元素
        List<Element> books = rootElement.elements("book");
        //4、遍历，处理每个book标签转换为Book类
        for (Element book: books){
//            System.out.println(book.asXML());//asXML() 把标签对象转换为标签字符串
            Element name = book.element("name");
            Element author = book.element("author");
            Element price = book.element("price");
            Attribute sn = book.attribute("sn");
            //getText()可以获取标签中的文本内容
//            book.elementText("name") //直接获取指定子元素标签名的文本内容
            Book b = new Book(sn.getValue(), name.getText(), new BigDecimal(price.getText()),author.getText());
            System.out.println(b);
//            System.out.println(name.getText() + " " + author.getText() + " " + price.getText() + " " + sn.getValue());
        }
    }
}
