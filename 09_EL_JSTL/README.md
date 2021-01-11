## EL 表达式  
* 什么是EL表达式， EL表达式的作用  
    EL表达式的全称是：Expression Language， 是表达式语言  
    EL表达式的作用：主要是代替jsp页面中的表达式脚本在jsp页面中进行数据的输出。  
    因为EL表达式在输出数据的时候，要比jsp的表达式脚本简洁很多  
    
    EL 表达式的格式是: ${expression}  
    EL 表达式在输出null值的时候， 输出的是空串， jsp表达式脚本输出null值的时候，输出的是null字符串  
* EL表达式搜索域数据的顺序  
     EL表达式主要是在jsp页面中输出的数据  
     主要输出域对象中的数据.  
     当四个域中都有相同的key的数据的时候，EL表达式会按照四个域的从小到大的顺序去进行搜索，找到就输出。  
* EL 表达式输出Bean的普通属性，数组属性。List集合属性，map集合属性  
    ```
    output Person: ${person}<br>
    Person.name: ${person.name}<br>
    Person.phone: ${person.phones[0]},${person.phones[1]},${person.phones[2]}<br>
    Person.cities(List): ${person.cities}<br>
    Person.cities(List): ${person.cities[1]}<br>
    Person.map: ${person.map}<br>
    Person.map: ${person.map["key1"]}<br>
    ```
* EL表达式---运算
    * 关系运算： <, >, >=, <=, ==, !=, eq, ne, lt, gt, le, ge  
    * Logic operators: ||, &&, !, and, or, not  
    * 算数运算： +， -， *， / ( or div), % ( or mod)  
    * empty 运算：  
        empty运算可以判断一个数据是否为空，如果为空，则输出true，不为空输出false  
        一下几种情况为空： 
        > 1、值为null的时候，为空  
        2、值为空串的时候，为空  
        3、值是Object类型数组，长度为零的时候，为空  
        4、list集合，元素个数为零的时候，为空  
        4、Map集合，元素个数为零的时候，为空  
    * 三元运算： 表达式1 ？ 表达式2 ： 表达式3  
    * "." 点运算 和 "[]" 中括号运算  
        点运算可以输出Bean对象中某个属性的值  
        [] 中括号运算，可以输出有序集合中某个元素的值  
        并且[] 中括号运算，还可以输出map集合中key里含有特殊字符的key的值  
        
    