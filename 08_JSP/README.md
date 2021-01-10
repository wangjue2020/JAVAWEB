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
* JSP 头部的page指令
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
* JSP中的常用脚本  
    1. 声明脚本  
       声明脚本的格式是： <%!声明java代码 %>  
       作用： 可以给jsp翻译出来的java类定义属性和方法甚至是静态代码块、内部类等。
    1. 表达式脚本  
        表达式脚本的格式是： <%=表达式 %>  
        表达式脚本的作用是：在jsp页面上输出数据  
        
        表达式脚本的特点：  
          >所有的表达式脚本都会被翻译到_jspService()方法中  
          表达式脚本都会被翻译成为out.print()输出到页面上  
          由于表达式脚本的内容都在_jspService()方法中，所以_jspService()方法中的对象都可以直接使用。  
          表达式脚本中的表达式不能以分号结束  
          
    1. 代码脚本  
    代码脚本的格式是：<% codes %>   
    代码脚本的作用：可以在jsp页面中，编写我们需要的功能（写的是java语句）  
    代码脚本的特点是：  
        > 代码脚本翻译之后都在_jspService()方法中  
    代码脚本由于翻译到_jspService()方法中，所以在_jspService()方法中的现有现象都可以直接使用  
    代码脚本还可以由多个代码脚本快组合完成一个完成的java语句  
    代码脚本还可以和表达式脚本疫情组合使用。在jsp页面上输出数据  
    
 * jsp中的三种注释  
    1. html注释  
        `\<!-- This is html comment -->  `
        html注释会被翻译到java源代码中。在_jspService方法里，以out.writer输出到客户端
    1. java注释  
        ```
            <%
                 // comment for single line
                 /*
                 comment for multiple lines
                  */
             %>
        ```
        java 注释会被翻译到java源代码中。
    1. jsp注释  
        `<%--comment for jsp--%>`  
        jsp注释可以注释掉jsp页面中所有的代码  

## JSP九大内置对象
   jsp中的内置对象，是指Tomcat在翻译jsp页面成为Servlet源代码后，内部提供的九个对象，即为内置对象。
   1. request    请求对象  
   1. response 响应对象
   1. pageContext   jsp的上下文对象
   1. session   会话对象 
   1. application ServletContext对象
   1. config    ServletConfig对象
   1. out   jsp输出流对象
   1. page  指向当前jsp的对象
   1. exception 异常对象  
## jsp四大域对象  
  域对象是可以像Map一样存取数据的对象。四个域对象功能一样，不同的是他们的数据的存取范围
  分别为：  
  * pageContext （PageContextImpl类）  当前jsp页面范围类有效
  * request     （HttpServletRequest类） 一次请求内有效
  * session     （HttpSession类） 一次会话范围内有效（打开浏览器访问服务器，直到关闭浏览器）
  * application （ServletContext类）整个web工程范围内都有效（只要web工程不停止，数据都在）  
  
  虽然四个域兑现都可一存取数据。在使用上他们是有优先顺序的。四个域在使用的时候，优先顺序分别是，他们从小到大的范围的顺序。  
  pageContext ---> request ---> session ---> application  
  
## JSP 中的out输出和response.getWriter 输出的区别  
response中表示响应，我们经常用于设置返回给客户端的内容（输出）  
out也是给用户做输出使用。  
当jsp页面中所有代码执行完成后会做一下两个操作：  
1. 执行out.flush() 操作，会把out缓冲区的数据追加写入到response缓冲区末尾  
1. 会执行response的刷新操作。把全部数据写给客户端  

所以输出的顺序是根据out.flush()和response的顺序来决定  
由于jsp翻译之后，底层源代码都是使用out来进行输出，所以一般情况下，我们在jsp页面中统一使用out来进行输出。避免打乱页面输出内容的顺序  

out.write() VS out.print():  
    * out.write() 输出字符串没有问题  
    * out.print() 输出任意数据都没有问题（都转换成字符串后调用的write输出）  
基本统一使用out.print()做输出  

## JSP常用标签
* 静态包含  

     `<%@ include file="./header.jsp"%>` 
        file属性指定你要包含的jsp页面的路径
        地址中的斜杠/表示为http：//IP：port/工程路径/ 映射到代码的web目录
        静态包含的特点：
        1、静态包含不会翻译被包含的jsp页面。
        2、静态包含其实是把被包含的jsp页面的代码拷贝到包含的位置执行输出
        
* 动态包含  

    `<jsp:include page="./footer.jsp"></jsp:include>`
    page 属性指定你要包含的jsp页面的路径
    动态包含也可以像静态包含一样，把被包含的内容执行输出到包含的位置
    
     动态包含的特点：
        1、动太包含会把包含的jsp页面也翻译成java代码
        2、动态包含底层代码使用如下代码去调用被包含的jsp页面执行输出。
            JspRuntimeLibrary.include(request, response, "/include/footer.jsp", out, false);
        3、动态包含，还可以传递参数
* jsp标签-转发    

   `<jsp:forward page="/scope2.jsp"></jsp:forward>`
    是请求转发的标签， 他的功能就是请求转发  
    page 属性设置请求转发的路径