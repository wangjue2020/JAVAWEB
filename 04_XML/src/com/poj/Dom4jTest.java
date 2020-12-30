package com.poj;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Dom4jTest {
    @Test
    public void test1() throws Exception {
        //创建一个SaxReader 输入流，去读取xml配置文件， 生成document对象
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        System.out.println(document);
    }
}
