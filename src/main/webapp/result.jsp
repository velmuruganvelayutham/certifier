<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored ="false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
<html>
<%@ include file="header.jsp" %>
<body>
<h1 align="center">The Exam Summary Report</h1>

<table class="table table-hover">
    <thead>
        <tr>
            <th>Question No</th>
            <th>result</th>
            <th>Score</th>
            <th>Link</th>
        </tr>
    </thead>

    <tbody>
    <c:forEach var="item" items="${sessionScope.summary}">
        <tr class=<c:out value="${item.cssClass}"/>>
            <td>  <c:out value="${item.questionNo}"/> </td>
            <td> <c:out value="${item.result}"/>  </td>
            <td> <c:out value="${item.score}"/>  </td>
            <td>   <a href="QuestionController?qno=${item.questionNo}"   data-toggle="modal" data-target="#myModal${item.questionNo}"  class="btn btn-primary" ><c:out value="${item.link}"/> </a>
            
            
            <!-- Modal -->
				<div class="modal fade" id="myModal${item.questionNo}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel${item.questionNo}" aria-hidden="true"> </div>
            
            
             </td>
        </tr>
</c:forEach> 
    </tbody>
    
</table>
<%@ include file="javascript.jsp" %>
</body>
</html>