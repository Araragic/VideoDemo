<%--
  User: Administrator
  Date: 2015/1/29 0029
  Time: 15:50
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>test for hibernate</title>
</head>
<body>
<div>
<table>
  <thead>
    <tr>
      <th>名称</th>
      <th>密码</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="list" items="${list}">
    <tr>
      <td>${list.userName}</td>
      <td>${list.password}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>
<div></div>
  <form method="POST" action="/vw/user/insert">
    <label>
      <input id="userName" name="userName" type="text">
    </label>
    <label>
      <input id="password" name="password" type="password">
    </label>
    <label>
    <input type="submit" name="submit" value="新增"/>
    <input type="reset" name="reset" value="重置"/>
    </label>
  </form>
</body>
</html>
