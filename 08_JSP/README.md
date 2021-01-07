## JSP  
* 什么是jsp， 有什么用？  

    JSP的全称是 Java Server Pages. Java的服务器页面。  
    JSP的主要作用是代替Servlet程序回传html页面的数据。  
    因为Servlet程序回传html数据是一件非常繁琐的事情。开发成本和维护成本都极高。  

* JSP 如何访问：  
    JSP页面和HTML页面一样，都是存放在web目录下。访问也跟访问html页面一样。  

## JSP 的本质是什么： 
   JSP页面本质上是一个Servlet程序。  
    当我们第一次访问JSP页面的时候， Tomcat 服务器会帮我们把jsp页面翻译成一个java源文件。并且对他进行编译成.class字节码程序
    打开生成的java源文件就会发现其中HttpJspBase类直接地继承了HttpServlet类。 也就是说，jsp翻译出来的java类，间接地继承了HttpServlet类。 也就是说，翻译出来的是一个servlet程序。 
    总结： 通过翻译的java源代码我们可以得到的结果就是： jsp就是servlet程序。  
    
   观察翻译出来的Servlet程序的源代码，不难发现。其底层实现，也是通过输出流。把html页面数据回传给客户端。  
    
## JSP 的三种语法  
```
<%@ page contentType="text/html;charset=UTF-8" language="java"
            errorPage="/error.jsp"
            import="java.util.Map" %>
 ```  
1. language 属性:  表示 jsp 翻译后是什么语言文件。暂时只支持 java。
1. contentType 属性:   表示 jsp 返回的数据类型是什么。也是源码中 response.setContentType()参数值   
1. pageEncoding 属性 : 表示当前 jsp 页面文件本身的字符集。
1. import 属性 属性: 跟 java 源代码中一样。用于导包，导类。  

  ========================两个属性是给输出流使用=============================
1.  autoFlush属性   设置当输出流缓冲区满了之后,是否自动刷新冲级区,默认值是true  
1.  buffer属性  设置out缓冲区的大小。默认是8kb  

========================两个属性是给 out 输出流使用=============================  
1. errorPage 属性 设置当 jsp 页面运行时出错，自动跳转去的错误页面路径。
   \<!--errorPage表示错误后自动跳转去的路径 <br/> 这个路径一般都是以斜杠打头，它表示请求地址为 http://ip:port/工程路径/   映射到代码的web目录--\>
1. isErrorPage 属性 设置当前jsp页面是否是错误信息页面。默认是false。如果是true可以获取异常信息。 
1. session 属性  设置访问当前jsp页面，是否会创建HttpSession对象。默认是true。  
1. extends 属性 设置jsp翻译出来的java类默认继承谁



