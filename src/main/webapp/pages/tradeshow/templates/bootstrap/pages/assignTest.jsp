
<%
	response.setCharacterEncoding("UTF-8");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", -1);
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>



<div class="container">
	<div class="row">
		<div class="row">
			<span class="label label-success text-center"><c:out
					value="${requestScope.message} "></c:out></span>
		</div>

		<form class="form-horizontal" role="form"
			action='<c:url value="/assignTest" />' method="post">
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Available
					Tests:</label>
				<div class="col-lg-10">
					<select class="form-control" multiple="multiple"
						name="selectedTests">
						<c:forEach items="${availableTests}" var="item">
							<option value="${item.cTestsId}">${item.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword1" class="col-lg-2 control-label">Available
					Users: </label>
				<div class="col-lg-10">
					<select class="form-control" name="selectedUser">
						<c:forEach items="${availableUsers}" var="item">
							<option value="${item.username}">${item.username}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label for="inputPassword1" class="col-lg-2 control-label">CC
					List: </label>
				<div class="col-lg-10">
					<input type="text" class="form-control input-lg"
						placeholder="optional">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword1" class="col-lg-2 control-label">Description:
				</label>
				<div class="col-lg-10">
					<input type="text" class="form-control input-lg"
						placeholder="Large">
				</div>
			</div>

			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<button type="submit" class="btn btn-default">Assign</button>
				</div>
			</div>
		</form>
	</div>

</div>


