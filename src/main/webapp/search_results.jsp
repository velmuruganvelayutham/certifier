<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored ="false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="header.jsp" %>
<body>
<div class="container">
 <jsp:include page="navigation.jsp">
 <jsp:param value="${pageContext.request.contextPath}" name="app_path"/>
 <jsp:param value="${user}" name="user_name"/>
 </jsp:include>
 </div>
 <jsp:include page="exam_menu.jsp"> 
  <jsp:param value="value" name="name"/>
 </jsp:include>
 <div class="container">
 <div class="row">
  <div class="col-md-8">
  <c:choose>
      <c:when test="${empty results}"> No results found Try with Advanced Search !.
      </c:when>
       <c:otherwise>
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
            <td>  <a href="QuestionController?qno=${item.id}"   data-toggle="modal" data-target="#myModal${item.id}"  class="btn btn-primary" > <c:out value="${item.id}"/> </a> </td>
            <td> <a href="QuestionController?qno=${item.id}"   data-toggle="modal" data-target="#myModal${item.id}"  class="btn btn-primary"  > <pre> <code><c:out value="${item.question}"/> </code> </pre> </a> </td>
            <td> <a href="QuestionController?qno=${item.id}"   data-toggle="modal" data-target="#myModal${item.id}"  class="btn btn-primary"  ><c:out value="${item.category}"/> </a> </td>
         <td>  
            <!-- Modal -->
				<div class="modal fade" id="myModal${item.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel${item.id}" aria-hidden="true"> </div>
            </td>
        </tr>
    </c:forEach> 
    </tbody>
</table>
<div align="right">
<ul class="pagination">
  <li><a href="SolrSearchController?p_No=1&text_search=${text_search}">&laquo;</a></li>
  <c:forEach begin="1" end="${noOfPages}" var="val">
   <li><a href="SolrSearchController?p_No=${val}&text_search=${text_search}"><c:out value="${val}"/></a></li> 
</c:forEach>
<li><a href="SolrSearchController?p_No=${noOfPages}&text_search=${text_search}">&raquo;</a></li>
</ul>
</div>
</c:otherwise>
</c:choose>
</div>
  <div class="col-md-4">
  <c:if test="${facets!= null}"> 
  <h3> filter your search by category </h3>
  </c:if>
  <c:forEach items="${facets.values}" var="item">
   <a  class="btn btn-primary"  href="SolrSearchController?text_search=${text_search}&category=${item.name}">${item.name} (${item.count})</a> <br>
  </c:forEach>

  </div>
</div>
 
</div>
 <%@ include file="javascript.jsp" %>
</body>
</html>