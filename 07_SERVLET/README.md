## HTTP 协议
* 什么是HTTP协议
    > 协议： 协议是指双方、或多方，相互约定好，大家都需要遵守的规则，叫协议  
    所谓HTTP协议，就是指，客户端和服务器端之间通信时，发送的数据，需要遵守的规则，叫HTTP协议。  
    HTTP协议中的数据又叫报文。  
* 请求的HTTP协议格式  
    客户端给服务器发送数据叫请求。
    服务器给客户端回传数据叫响应。  
    请求又分为GET请求，和POST请求两种  
    * GET请求：
        ```
        GET /06_SERVLET/a.html HTTP/1.1
        Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
        Upgrade-Insecure-Requests: 1
        Host: localhost:8080
        User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.1.3 Safari/605.1.15
        Accept-Language: zh-cn
        Accept-Encoding: gzip, deflate
        Connection: keep-alive
         ```  
        * 请求行  
            ```GET /06_SERVLET/a.html HTTP/1.1```
            1. 请求的方式：   GET
            1. 请求的资源路径[+?+请求参数]  
            1. 请求的协议的版本号       HTTP/1.1  
        * 请求头  
            key:value   组成， 不同的键值对，表示不同的含义
            ```
            Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
           Upgrade-Insecure-Requests: 1
           Host: localhost:8080
           User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.1.3 Safari/605.1.15
           Accept-Language: zh-cn
           Accept-Encoding: gzip, deflate
           Connection: keep-alive
           ```
           1. Accept: 告诉服务器，客户端可以接受的数据类型   
           1. Accept-Language：告诉服务器客户端可以接受的语言类型， zh_CN for Chinese, en_US for English  
           1. User-Agent: 就是浏览器的信息
           1. Accept-Encoding: 告诉服务器，客户端可以接收的数据编码（压缩）格式
           1. Host：表示请求的服务器ip和端口号  
           1. Connection：告诉服务器请求连接如何处理
                > keep-alive 告诉服务器回传数据不要马上关闭，保持一小段时间的连接  
                closed  马上关闭
    * POST请求： 
        ```
        POST /06_SERVLET/hello3 HTTP/1.1
        Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
        Origin: http://localhost:8080
        Content-Type: application/x-www-form-urlencoded
        Content-Length: 7
        Accept-Language: zh-cn
        Upgrade-Insecure-Requests: 1
        Host: localhost:8080
        User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.1.3 Safari/605.1.15
        Referer: http://localhost:8080/06_SERVLET/a.html
        Accept-Encoding: gzip, deflate
        Connection: keep-alive
        ``` 
        * 请求行  
            `POST /06_SERVLET/hello3 HTTP/1.1`
            1. 请求的方式：   POST
            1. 请求的资源路径[+?+请求参数]  
            1. 请求的协议的版本号       HTTP/1.1 
        * 请求头  
            key:value   组成， 不同的键值对，表示不同的含义
            ```
            Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
            Origin: http://localhost:8080
            Content-Type: application/x-www-form-urlencoded
            Content-Length: 11
            Accept-Language: zh-cn
            Upgrade-Insecure-Requests: 1
            Host: localhost:8080
            User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.1.3 Safari/605.1.15
            Referer: http://localhost:8080/06_SERVLET/a.html
            Accept-Encoding: gzip, deflate
            Connection: keep-alive
            ```
            1. Accept： 表示客户端可以接受的数据类型  
            1. Accept-Language: 表示客户端可以接受的语言类型  
            1. Referer： 表示请求发起式，浏览器地址栏中的地址（从哪里来）  
            1. User-Agent：表示浏览器的信息  
            1. Content-Type：表示发送的数据的类型  
                > application/x-www-form-urlencoded： 表示提交的数据格式是：name=value&name=value, 然后对其进行url编码  
                url编码是吧非英文内容转换成：%xx%xx  
                
                > multipart/form-data：
                 表示以多段的形式提交数据给服务器（以流的形式提交，用于上传）  
            1. Content-Length： 表示发送的数据的长度  
            1. Cache-Control 表示如何控制缓存  "no-cache"表示不缓存  
           
        * 请求体 =====>>> 就是发送给服务器的数据
            ```gender: 1213```
* 常用请求头的说明  
    * Accept：表示客户端可以接收的数据类型  
    * Accept-Language：表示客户端可以接收的语言类型  
    * User-Agent： 表示客户端浏览器的信息  
    * Host： 表示请求时的服务器ip和端口号  
* 哪些是GET请求，哪些是POST请求  
    * GET请求：
        1. form标签 method="get"  
        1. \<a> tag  
        1. \<link> to import css files  
        1. \<script> to import js file  
        1. \<img> to load pictures  
        1. \<iframe> to import a html page  
        1. 在浏览器地址栏中输入地址后敲回车键  
    * POST 请求：  
        \<form ..... method="post">
* 响应的HTTP协议格式 
    ```
    HTTP/1.1 200 OK
    Content-Type: text/html
    Last-Modified: Mon, 04 Jan 2021 17:06:16 GMT
    Accept-Ranges: bytes
    Date: Mon, 04 Jan 2021 17:37:59 GMT
    Content-Length: 289
    ETag: W/"289-1609779976000"
    Server: Apache-Coyote/1.1  
    //此处应该空一行
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
    <body>
        <form action="http://localhost:8080/06_SERVLET/hello3" method="post">
            Gender: <input type="text" name="gender"/>
            <input type="submit">
        </form>
    </body>
    </html> 
    ``` 
    * 响应行  
        ```HTTP/1.1 200 OK```
        1. 响应的协议和版本号  
        1. 响应的状态码  
        1. 响应状态描述符  
    * 响应头  
        key：value 不同的响应头，有其不同含义  
        空行  
         ``` 
            Content-Type: text/html
            Last-Modified: Mon, 04 Jan 2021 17:06:16 GMT
            Accept-Ranges: bytes
            Date: Mon, 04 Jan 2021 17:37:59 GMT
            Content-Length: 289
            ETag: W/"289-1609779976000"
            Server: Apache-Coyote/1.1  
        ```
        1. Server: 表示服务器的信息  
        1. Content-Type：表示响应体的数据类型  
        1. Content-Length： 响应题的数据类型  
        1. Date：请求响应的时间（格林时间）
    * 响应体 ---->>> 就是回传给客户端的数据
        ```
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Title</title>
        </head>
        <body>
            <form action="http://localhost:8080/06_SERVLET/hello3" method="post">
                Gender: <input type="text" name="gender"/>
                <input type="submit">
            </form>
        </body>
        </html> 
        ```
* 常用的响应码说明  
    200：表示请求成功  
    302：表示请求重定向  
    404：表示请求服务器收到了，但是你要的数据不存在（请求地址错误）  
    500：表示服务器已经收到请求，但是服务器内部错误（代码错误）  

## HttpServletRequest 类  
  * HttpServletRequest 类有什么作用  
       每次只要有请求进入Tomcat服务器，Tomcat服务器就会把请求过来的HTTP协议信息解析好封装到Request对象中。然后传递到Service方法（doGet和doPost） 中给我们使用。我们可以通过HttpServletRequest 对象，获取到所有请求的信息。  
  
  * servlet请求转发  
      请求转发的特点：
     >1、浏览器地址栏没有变化，不会变到转发后的地址
      2、他们是一次请求
      3、他们共享Request域中的数据
      4、可以转发到WEB-INFO目录下
      5、不能访问工程以外的资源
  * web中 "/" 斜杠的不同意义   
    在web中， "/" 斜杠 是一种绝对路径。   
      * "/" 斜杠 如果被浏览器解析，得到的地址是：http://ip:port/  
        > \<a href="/">斜杠\</a>  
      
      * "/" 斜杠 如果被服务器解析，得到的地址是：http://ip:port/工程路径  
        1. <url-pattern>/servlet1</url-pattern>  
        2. servletContext.getRealPath("/");  
        3. request.getRequestDispatcher("/");  
      * 特殊情况：response.sendRedirect("/"); 把斜杠发送给浏览器解析，得到http://ip:port/  
## HttpServletResponse 类  
* HttpServletResponse类的作用  
    HttpServletResponse 和 HttpServletRequest 类一样。 每次请求进来，Tomcat服务器都会创建一个Response 对象传递给Servlet程序去使用。HttpServletRequest 表示请求过来的信息，HttpServletResponse表示所有相遇的信息， 我们如果需要设置返回给客户端的信息，都可以通过HttpServletResponse对象来进行设置  
    
* 两个输出流的说明  
    字节流：     getOutPutStream()   常用于下载（传递二进制数据）  
    字符流：    getWriter（）        常用语回传字符串（常用）  
    两个流同时只能使用一个。使用了字节流，就不能再使用字符流，反之亦然， 否则就会报错  
* 请求重定向  
    请求重定向，是指客户端给服务器发请求，然后服务器告诉客户端说。我给你一些地址，你去新的地址访问。叫请求重定向（因为之前的地址可能已经被废弃）。  
    请求重定向的特点：  
    > 1、浏览器地址栏会发生变化  
    2、两次请求  
    3、不共享Request域中的数据  
    4、不能访问WEB-INF下的资源  
    5、可以访问工程外的资源  
    
    方式一：
    ```
    resp.setStatus(302);
   //set response header to declare the new location
   resp.setHeader("Location", "http://localhost:8080/07_SERVLET/redirectto");
     ```
    方式二：
    ```
    resp.sendRedirect("http://localhost:8080/07_SERVLET/redirectto");
    ```