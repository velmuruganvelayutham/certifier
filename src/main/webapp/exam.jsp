<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   isELIgnored ="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exam</title>
<link href="media/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
<link href="media/css/timeTo.css" type="text/css" rel="stylesheet"/>
<!-- <script src="media/jquery-1.7.1.min.js" type="text/javascript" charset="utf-8"></script> -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="media/jquery.timeTo.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#countdown').timeTo({
	    seconds: 100
	  });

     if(parseInt( $('#button-right').val()) > parseInt($('#maximumQuestion').val())){
	 $('#button-right').hide();
     }

     if(parseInt( $('#button-right').val()) ==2 ){
    	 $('#button-left').hide();
     }
         
     
     $("#button-right").click(function (event){

    	 var selected = [];
         $('.col-lg-12 input:checked').each(function() {
             selected.push($(this).attr('name'));
         });

    	if(selected.length===0) {
    		alert("Choose atleast one answer before going to the next questions");
    		 event.preventDefault();
    	}    
    	
         });
     
     $("#button-submit").click(function(event) {
	        if( !confirm('Are you sure that you want to submit the form') ) 
	            event.preventDefault();
	});

// 	$(".form-signin").submit(function() {
// 		console.log( " submit value is " + $("#button-submit").val());
// 	    if ($("#button-submit").val() === "submit") {
// 	        alert("Please confirm if everything is correct");
// 	        $("#button-submit").val("text 2");
// 	        return false;
// 	    }
// 	});
});
</script>
</head>
<body>
<div id="countdown" align="right"></div>
 <div class="container">
   <div class="row">
   
    <form class="form-signin" action=ExamController method="post">
        <div class="col-lg-12">
          <h3>Questions</h3>
          <pre> <code><b>  <c:out value="(${sessionScope.next} / ${sessionScope.totalNoQuestions})"/> <c:out value=" ${sessionScope.question.question}  [Choose all that apply. ]"/></b></code> </pre>
			<fieldset>
<!-- 			<legend>Reasons to be happy</legend> -->
				<c:forEach var="option" items="${sessionScope.question.COptions}" varStatus="theCount">
				<input name="checkboxNo${theCount.count}" id="checkbox4" type="checkbox" value="checkboxNo${theCount.count}" 
				<c:set var="contains" value="false" />
				<c:set var="myvalue" value="checkboxNo${theCount.count}" />
				<c:forEach var="item" items="${sessionScope.list}">
 					 <c:if test="${item eq myValue}">
  			 			checked="checked"
 					 </c:if>
				</c:forEach>
				/>
     			<label for="family" id="label4"><c:out value="${option.choices}"/></label></br>
		         </c:forEach>
			</fieldset>
<!--       <button id="button-left" type="button" class="btn btn-default navbar-btn">Previous</button> -->
			<input name="pageNumber" id="pageNumber" type="hidden" value="${sessionScope.next}">
			<input name="maximumQuestion" id="maximumQuestion" type="hidden" value="${sessionScope.totalNoQuestions}">
           <a id="button-left" class="btn btn-default" href="${pageContext.request.contextPath}/ExamController?pageNumber=${sessionScope.previous}" role="button">Previous</a>
           <button id="button-submit" type="submit" name="submit" class="btn btn-default navbar-btn" value="submit">submit</button>
           <button id="button-right" type="submit" name ="next" class="btn btn-default navbar-btn" value="${sessionScope.next}">Next</button>
<%--             <a class="btn btn-default" href="${pageContext.request.contextPath}/ExamController?pageNumber=${sessionScope.next}" role="button">Next</a> --%>
        </div>
        </form>
      </div>
    </div>
<%--     <pre><code>function Panel(element, canClose, closeHandler) { --%>
<!--   this.element = element; -->
<!--   this.canClose = canClose; -->
<!--   this.closeHandler = function () { if (closeHandler) closeHandler() }; -->
<%-- }</code></pre> --%>
</body>
</html>