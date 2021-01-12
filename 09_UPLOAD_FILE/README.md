##文件上传和下载
* 文件的上传介绍  
    1. 要有一个form标签，method=post请求
    1. form标签的encType属性值必须为multipart/form-data值
    1. 在from标签中使用input type=file添加上传的文件  
    1. 编写服务器代码接收，处理上传的数据。 
    
    encType=multipart/form-data 表示提交的数据，以多段（每一个表单）的形式进行拼接，然后以二进制流的形式发送给服务器