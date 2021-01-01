# Tomcat 

## 1、JavaWeb的概念
* 什么是JavaWeb
    > JavaWeb是指，所有通过Java语言编写可以通过浏览器访问的程序的总称，叫JavaWeb。  
    JavaWeb是指基于请求和响应来开发的。
    
* 什么是请求
    > 请求是指客户端给服务其发送数据，叫请求Request
    
* 什么是响应
    > 响应是指服务器给客户端回传数据，叫Response
    
* 请求和响应的关系
    > 请求和响应是成对出现，有请求就有响应
## 2、Web资源的分类  
web资源按实现的技术和呈现的效果的不同，又分为静态资源和动态资源两种。  
静态资源： html, css, js, txt, mp4, jpg, etc.  
动态资源：jsp页面、 Servlet程序

## 3、Tomcat 安装
* 解压压缩包
* 目录介绍  
    > bin 存放Tomcat 服务器的可执行程序  
    conf  存放Tomcat服务器的配置文件  
    lib  存放Tomcat服务器的jar包  
    log  存放Tomcat服务器运行时输出的日记信息  
    temp 存放Tomcat运行时产生的临时数据  
    webapps 存放部署的web工程  
    work  是Tomcat工作时的目录，用来存放tomcat运行时jsp翻译为Servlet的圆满，和Session钝化的目录
    
 * 如何启动Tomcat服务器
    > [Mac Tomcat 教程](https://blog.csdn.net/qq_35106903/article/details/78860121?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-7&spm=1001.2101.3001.4242)  
    启动：/usr/local/Tomcat/bin/startup.sh 
    停止：/usr/local/Tomcat/bin/shutdown.sh 
 * 如何修改Tomcat默认端口号
    > mysql默认的端口号：3306  
    Tomcat默认的端口号：8080  
    找到Tomcat目录下的conf 目录， 找到server.xml配置文件——> 修改connect标签，修改port属性的值  
    ```
    <Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" />  
    ```  
    > 修改完端口号，一定要重启Tomcat服务器才能生效
  * 如何部署web工程到Tomcat中
    > 第一种方法：  
    只需要把web工程的目录拷贝到Tomcat的webapps目录下即可  
    如何访问：  
    只需要在浏览器中输入访问地址，格式如下：  
    http://ip:port/工程名/目录1/目录2/.../文件名  
    
    > 第二种方法： 
    找到Tomcat下的conf目录\Catalina\localhost\下，创建如下的配置文件 
    ```
    <!-- 这个文件的文件名字与path里面的value一致，文件名为bookSystem.xml
    Context表示一个工程上下文， 
    	path表示工程的访问路径
    	docBase 表示你的工程目录在哪里
    	即用path的value代表reach到docBase的文件， 在浏览器输入地址时用path的value
    -->
    <Context path="/bookSystem" docBase="/Users/Wangjue/IdeaProjects/JAVAWEB/04_Static_Book_System" />
    ```
    
  * ROOT 的工程的访问，以及默认index.html页面的访问
    > 当我们在浏览器地址栏中输入访问地址如下：  
      http://ip:port/    -------> 没有工程名的时候，默认访问的是root工程  
      
    > 当我们在浏览器地址栏中输入的可访问地址如下：  
      http://ip:port/工程名/       -------> 没有资源名，默认访问index.html页面
      
## 4、IDEA整合Tomcat服务器
    * File | Setting | Build, Execution, Deployment | Application Servers
    添加并输入tomcat所在文件目录
    
## 动态web工程目录介绍
* src 目录存自己编写的java源代码
* web 目录专门用来存放web工程的资源文件。如：html页面、css文件、js文件等等
* WEB-INF 目录是一个受服务器保护的目录，浏览器无法直接访问到此目录的内容
* lib 目录用来存放第三方的jar包。（IDEA还需要自己配置导包）
* web.xml 是整个动态web工程的配置部署描述文件， 可以在这里配置很多工程的组件， 比如：
    > Servlet 程序  
    Filter 过滤器  
    Listener 监听器  
    Session 超时，...等等