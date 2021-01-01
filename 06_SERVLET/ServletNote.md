## Servlet 技术
* 什么是Servlet  
    > 1、Servlet是JavaEE规范之一。规范就是接口  
    2、Servlet 是JavaWeb三大组件之一。三大组件分别是Servlet 程序、Filter 过滤器、 Listener 监听器。  
    3、Servlet 试运行在服务器上的一个java程序，他可以接收客户端发送过来的请求，并响应数据给客户端。
    
* 手动实现Servlet 程序
    > 1、编写一个类实现Servlet接口  
    2、实现service方法，处理请求，并响应数据  
    3、到web.xml中去配置servlet程序的访问地址