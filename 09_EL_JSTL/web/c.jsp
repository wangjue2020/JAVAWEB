<%@ page import="com.bean.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Wangjue
  Date: 2021-01-10
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person = new Person();
    person.setName("Lucy");
    person.setPhones(new String[]{"1213", "234123421","23412412341"});
    List<String> cities = new ArrayList<>();
    cities.add("CSX");
    cities.add("PEK");
    cities.add("PVG");
    person.setCities(cities);
    Map<String, Object> map = new HashMap<>();
    map.put("key1", "val1");
    map.put("key2", "val2");
    map.put("key3", "val3");
    person.setMap(map);

    pageContext.setAttribute("person", person);
%>

output Person: ${person}<br>
Person.name: ${person.name}<br>
Person.phone: ${person.phones[0]},${person.phones[1]},${person.phones[2]}<br>
Person.cities(List): ${person.cities}<br>
Person.cities(List): ${person.cities[1]}<br>
Person.map: ${person.map}<br>
Person.map: ${person.map["key1"]}<br>
</body>
</html>
