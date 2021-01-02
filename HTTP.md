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
        * 请求行  
            1. 请求的方式：   POST
            1. 请求的资源路径[+?+请求参数]  
            1. 请求的协议的版本号       HTTP/1.1 
        * 请求头  
        key:value   组成， 不同的键值对，表示不同的含义
        空行
        * 请求体 =====>>> 就是发送给服务器的数据

    
        