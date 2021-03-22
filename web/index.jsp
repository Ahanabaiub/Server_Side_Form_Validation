<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Registration Form</title>
  <style>
    .error{
      color: red;
    }
    .main{
      text-align: center;
    }

    form{
      display: inline-block;
    }
    .success{
      color: green;
      font-weight: bold;
    }
  </style>
</head>
<body>
<div class="main">
  <h1>Registration Form</h1>
  <form action="${pageContext.request.contextPath}/validate" method="post">
    <table>
      <tr>
        <td>
          <c:if test="${success!=null}">
            <span class="success">${success}</span>
            <% request.removeAttribute("success");%>
          </c:if>
        </td>
      </tr>
      <tr>
        <td>First Name:</td>
        <td>
          <input type="text" name="fname" value="${userInfo.fname}">
        </td>
      </tr>
      <tr>
        <td></td>
        <td> <span class="error">${messages.fname}</span></td>
      </tr>
      <tr>
        <td>Last Name:</td>
        <td>
          <input type="text" name="lname" value="${userInfo.lname}">
        </td>
      </tr>
      <tr>
        <td></td>
        <td> <span class="error">${messages.lname}</span></td>
      </tr>
      <tr>
        <td>User Name:</td>
        <td>
          <input type="text" name="uname" value="${userInfo.uname}">
        </td>
      </tr>
      <tr>
        <td></td>
        <td> <span class="error">${messages.uname}</span></td>
      </tr>
      <tr>
        <td>Email:</td>
        <td>
          <input type="email" name="email" value="${userInfo.email}">
        </td>
      </tr>
      <tr>
        <td></td>
        <td><span class="error">${messages.email}</span></td>
      </tr>
      <tr>
        <td>Address:</td>
        <td>
          <input type="text" name="address" value="${userInfo.address}">
        </td>
      </tr>
      <tr>
        <td></td>
        <td> <span class="error">${messages.address}</span></td>
      </tr>
      <tr>
        <td>Password:</td>
        <td>
          <input type="password" name="password" value="${userInfo.password}">
        </td>
      </tr>
      <tr>
        <td></td>
        <td> <span class="error">${messages.password}</span></td>
      </tr>
      <tr>
        <td>Confirm Password:</td>
        <td>
          <input type="password" name="cfPassword">
        </td>
      </tr>
      <tr>
        <td></td>
        <td> <span class="error">${messages.cfPassword}</span></td>
      </tr>
      <tr>
        <td><input type="submit" value="submit"></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
