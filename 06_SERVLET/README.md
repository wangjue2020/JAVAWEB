## Servlet 技术
* 什么是Servlet  
    > 1、Servlet是JavaEE规范之一。规范就是接口  
    2、Servlet 是JavaWeb三大组件之一。三大组件分别是Servlet 程序、Filter 过滤器、 Listener 监听器。  
    3、Servlet 试运行在服务器上的一个java程序，他可以接收客户端发送过来的请求，并响应数据给客户端。
    
* 手动实现Servlet 程序
    > 1、编写一个类实现Servlet接口  
    2、实现service方法，处理请求，并响应数据  
    3、到web.xml中去配置servlet程序的访问地址
* url 地址到Servlet程序的访问  
    http://ip:port/06_SERVLET/hello
    > http:// 表示http协议  
    通过ip地址定位服务器，再通过port（端口号）定位服务器地址下的指定程序  
    通过/06_SERVLET （工程路径） 确定访问哪一个project或者工程  
    /hello 首先先访问web.xml 找到其中 <url-pattern>...</url-pattern>的内容是/hello 的<servlet-mapping>...</servlet-mapping>标签，  
    和他所对应的servlet-name， 再去所有<servlet>...</servlet>标签里找到指定servlet-name的标签，查询所对应的全类名，以此获得servlet程序并访问执行service方法
    
* Servlet 的生命周期
    > 1、执行Servlet 构造器方法（第一次访问的时候创建Servlet程序会调用）  
    2、执行init初始化方法（第一次访问的时候创建Servlet程序会调用）  
    3、执行service方法（每次访问对应url都会调用）  
    4、执行destroy销毁方法（在web工程停止的时候调用） 
* 通过继承HttpServlet 实现Servlet 程序  
    一般在实际项目开发中，都是使用继承HttpServlet类的方式去实现Servlet程序
    > 1、编写一个类去继承HttpServlet类  
    2、根据业务需要重写doGet或者doPost方法  
    3、到web.xml中配置Servlet程序的访问地址
* 使用IDEA 创建Servlet程序
    right click package -> new -> servlet
    创建时的选项：
    > Name: 对应servlet标签里，servlet-name的名字  
    Package: 这个servlet程序所在package name  
    class： 这个servlet程序的全类名  
    不要选择"Create Java EE 6 annotated class"，否则会使用注解来配置
* 整个Servlet类的继承体系
    > Interface Servlet:  
    Servlet接口，只负责定义Servlet程序的访问规范  
    
    > Class GenericServlet implements Servlet:  
     GenericServlet类实现了Servlet接口。做了很多空实现。并持有一个ServletConfig类的引用。并对ServletConfig的使用做一些方法。
      
    > Class HttpServlet extends GenericServlet:  
    HttpServlet抽取类实现了service()方法，并实现了请求的分发处理。通过HttpServletRequest.getMethod()获取不同的请求，来进行分类处理，有了doGet() 和 doPost(),  
    doGet() 和doPost()里面的内容是负责抛出异常，说不支持GET/POST请求
    
    > 自定义的Servlet程序：  
    只需要根据自己的业务需要去重写doGet(), doPost() 即可

## ServletConfig 类  
ServletConfig类从类名上来看，就知道是Servlet程序的配置信息类。

* ServletConfig 类的三大作用
    >  1、可以获取Servlet程序的别名servlet-name的值  
    2、获取初始化init-param  
    3、获取servletContext对象  
    ```
    <servlet>
        <!--servlet-name 标签 servlet程序起一个别名（一般是类名）-->
        <servlet-name>HelloServlet</servlet-name>
        <!--servlet-class 是Servlet程序的全类名-->
        <servlet-class>com.servlet.HelloServlet</servlet-class>
        <!--init-param是初始化参数-->
        <init-param>
            <!--参数名-->
            <param-name>url</param-name>
            <!--参数值-->
            <param-value>jdbc:mysql://localhost:3306/test</param-value>
        </init-param>
        <init-param>
            <param-name>username</param-name>
            <param-value>root</param-value>
        </init-param>
        <init-param>
            <param-name>password</param-name>
            <param-value>admin</param-value>
        </init-param>
    </servlet>
    ``` 
    
## ServletContext 类
  * 什么事ServletContext？
    > 1、ServletContext 是一个接口，它表示Servlet上下文对象
    2、一个web工程，只有一个ServletContext对象实例  
    3、ServletContext对象是一个域对象。    
    + 什么是域对象？  
    域对象，是可以像map一样存取数据的对象，叫域对象。这里的域指的是存取数据的操作范围, 整个web工程  
    map：用put()存数据、 get()获取数据、remove()删除数据
    域对象：用setAttribute()存数据、getAttribute()获取数据、removeAttribute()删除数据
  * ServletContext类的四个作用
    > 1、获取web.xml中配置的上下文参数context-param  
    2、获取当前的工程路径，格式:/工程路径  
    3、获取工程部署后在服务器硬盘上的绝对路径  
    4、像Map一样存取数据  
## HttpServletRequest 类  
  * HttpServletRequest 类有什么作用  
       每次只要有请求进入Tomcat服务器，Tomcat服务器就会把请求过来的HTTP协议信息解析好封装到Request对象中。然后传递到Service方法（doGet和doPost） 中给我们使用。我们可以通过HttpServletRequest 对象，获取到所有请求的信息。