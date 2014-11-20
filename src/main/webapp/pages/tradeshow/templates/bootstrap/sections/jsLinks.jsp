<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page session="false" %>


    <script>var ctx = "${pageContext.request.contextPath}"</script>
      <!-- Jquery latest version -->
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/templates/bootstrap/js/bootstrap.min.js" />"></script>
    <!-- bootstrap  css -->
    <link href="<c:url value="/resources/templates/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
	<!--bootstrap theme      -->
<%--     <link href="<c:url value="/resources/templates/bootstrap/css/bootstrap-theme.min.css" />" rel="stylesheet"> --%>
    
     <!-- Jquery Form plugin -->
    <script src="<c:url value="/resources/js/jquery.form.js" />"></script>
    
      <!-- Jquery AJAX Autocomplete  plugin -->
<%--     <script src="<c:url value="/resources/js/jquery.autocomplete.js" />"></script> --%>
    <!--   Bootstrap typeahead javascript  -->
    <script src="<c:url value="/resources/js/typeahead.bundle.js" />"></script>
    <script src="<c:url value="/resources/js/hogan.js" />"></script>
<!--     form validator -->
<%--     <script src="<c:url value="/resources/js/bootstrapValidator.js" />"></script> --%>
     <link href="<c:url value="/resources/css/bootstrapValidator.css" />" rel="stylesheet">
	<!--     lavish-bootstrap custom css  -->
<%--     <link href="<c:url value="/resources/css/lavish-bootstrap.css" />" rel="stylesheet"> --%>
  <link href="<c:url value ="/resources/css/footable.core.css?v=2-0-1"/>" rel="stylesheet" type="text/css"/>
  <script src="<c:url value="/resources/js/footable.js?v=2-0-1" />" type="text/javascript"></script>
  <script src="<c:url value="/resources/js/footable.sort.js?v=2-0-1"/>" type="text/javascript"></script> 
  <script src="<c:url value="/resources/js/footable.filter.js?v=2-0-1"/>" type="text/javascript"></script>
<%--    <script src="<c:url value="resources/js/footable.paginate.js?v=2-0-1"/>" type="text/javascript"></script> --%>
<%--     <script src="<c:url value="resources/js/footable.bookmarkable.js?v=2-0-1"/>" type="text/javascript"></script> --%>
<%--   <script src="<c:url value="resources/js/jquery.marcopolo.js" />" type="text/javascript"></script> --%>
     
<!--     tradeshow custom css  -->
  <link href="<c:url value="/resources/css/tradeshow.css" />" rel="stylesheet">
   
     <!-- Custom javascript:  -->
  <script src="<c:url value="/resources/js/tradeshow.js" />"></script>
    