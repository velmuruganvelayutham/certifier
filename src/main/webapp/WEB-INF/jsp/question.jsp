<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   isELIgnored ="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<!--  <div class="container"> -->
<!--    <div class="row"> -->
   
<!--         <div class="col-lg-12"> -->
<!--           <h3>Questions</h3> -->
<%--           <p><b>  <c:out value=" ${question.question}  [Choose all that apply. ]"/></b> </p> --%>
<!-- 			<fieldset> -->
<!-- <!-- 			<legend>Reasons to be happy</legend> --> -->
<%-- 				<c:forEach var="option" items="${question.COptions}" varStatus="theCount"> --%>
<%-- 				<input name="checkboxNo${theCount.count}" id="checkbox4" type="checkbox" value="checkboxNo${theCount.count}"/> --%>
<%--      			<label for="family" id="label4"><c:out value="${option.choices}"/></label></br> --%>
<%-- 		         </c:forEach> --%>
<!-- 			</fieldset> -->

<!--         </div> -->
<!--       </div> -->
<!--     </div> -->
    
     <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				        <h4 class="modal-title" id="myModalLabel">Question.</h4>
				      </div>
				      <div class="modal-body">
				      
				       <div class="row">
   
        <div class="col-lg-12">
          <pre> <code><b>  <c:out value=" ${question.question}  [Choose all that apply. ]"/></b> </code> </pre>
			<fieldset>
<!-- 			<legend>Reasons to be happy</legend> -->
				<c:forEach var="option" items="${question.COptions}" varStatus="theCount">
				<input name="checkboxNo${theCount.count}" id="checkbox4" type="checkbox" value="checkboxNo${theCount.count}"/>
     			<label for="family" id="label4"><c:out value="${option.choices}"/></label></br>
		         </c:forEach>
			</fieldset>

        </div>
      </div>
      
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				        <button type="button" class="btn btn-primary">Save changes</button>
				      </div>
				    </div>
 </div>
 
 
</body>
</html>