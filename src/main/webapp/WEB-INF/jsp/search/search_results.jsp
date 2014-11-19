<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored ="false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 	
<link rel="shortcut icon" href="media/bootstrap/assets/ico/favicon.png">
<title>search results</title>
<link href="media/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
 <script src="media/jquery-1.7.1.min.js" type="text/javascript" charset="utf-8"></script>
  <script type="text/javascript" src="media/script.js"></script>
<link href="media/bootstrap/signin.css" rel="stylesheet">
</head>
<body>

 <jsp:include page="navigation.jsp">
 <jsp:param value="${pageContext.request.contextPath}" name="app_path"/>
 <jsp:param value="${user}" name="user_name"/>
 </jsp:include>
 
 <jsp:include page="exam_menu.jsp"> 
  <jsp:param value="value" name="name"/>
 </jsp:include>
 <table class="table table-hover">
    <thead>
        <tr>
            <th> No</th>
            <th>Question</th>
            <th>Category</th>
           
        </tr>
    </thead>

    <tbody>
    <c:forEach var="item" items="${results}">
   
        <tr>
            <td> <a href="#" > <c:out value="${item.id}"/> </a> </td>
            <td> <a href="#" > <pre> <code><c:out value="${item.question}"/> </code> </pre> </a> </td>
            <td> <a href="#" ><c:out value="${item.category}"/> </a> </td>
        
        </tr>
        
        </c:forEach> 

    </tbody>
    
</table>
  <script src="media/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>