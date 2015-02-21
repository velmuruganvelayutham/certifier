<%
response.setCharacterEncoding("UTF-8");
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", -1);
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
 
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<ol class="breadcrumb">
  <li><a href="#"> <span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
  <li class="active">users</li>
</ol>

<div id="custom-toolbar" class="btn-toolbar " role="toolbar">
  <div  class="btn-group"><button id="addBtnDetail"  class="btn btn-default " type="button" data-toggle="modal" data-target="#addNewTestModal" > <span class="glyphicon glyphicon-plus"></span> Add </button> </div>
</div>
 <div id="statusbar" class="alert alert-success alert-dismissible" role="alert" style="display:none">
	  <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
 </div>

<table data-testId="${id}" id="question-table" data-toggle="table" data-url="${id}/data" data-toolbar="#custom-toolbar" data-click-to-select="true" data-height="525" data-side-pagination="server" data-pagination="true" data-page-list="[5, 10, 20, 50, 100, 200]" data-search="true">
    <thead>
    <tr>
        <th data-field="radio" data-radio="true"></th>
        <th data-field="cQuestionsId"  data-visible="true" >ID </th>
        <th data-field="question" data-align="center" data-sortable="true" >Email Address</th>
        <th data-field="question" data-align="center" data-sortable="true" >Password</th>
        <th data-field="question" data-align="center" data-sortable="true" >Enabled</th>
        <th data-field="options" data-align="center" data-sortable="true">ROLES</th>
        <th data-field="action" data-align="center" data-sortable="true" data-formatter="operateFormatter" data-events="operateEvents" >Action</th>
    </tr>
    </thead>
</table> 




   <!-- Modal  for adding new Settings -->
<div class="modal fade" id="addNewTestModal" tabindex="-1" role="dialog" aria-labelledby="addNewTestLabel" aria-hidden="true" data-toggle="validator" >
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="addNewTestLabel">Add New Test </h4>
      </div>
<!--       <div class="modal-body" id="editModal"> </div> -->
      <div class="modal-body" >
				<form  id="ajaxform" role="form" method="post" class="form-horizontal"  action="<c:url value="/tests/add" > </c:url>"
				data-bv-message="This value is not valid"
    			data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
   				data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
    			data-bv-feedbackicons-validating="glyphicon glyphicon-refresh"
    			data-bv-excluded=":disabled" >
				<div class="row">
					  <div class="col-xs-24 col-md-12"> 
					  	  <div class="form-group">
						    <input type="hidden" class="form-control" id="testid" name ="cTestsId" >
						  </div>
						   <div class="form-group">
						    <input type="hidden" class="form-control" id="totalOptions" name ="totalOptions" >
						  </div>
						  <div class="form-group">
						    <label class="col-xs-1 control-label" for="name">Question</label>
						    <div class="col-xs-11">
						    <input type="text" class="form-control" id="testName" name ="question" placeholder="Question" >
                			</div>
						  </div>

						  <div class="form-group">
						    <label class="col-xs-1 control-label" for="option">Option</label>
						    <div class="col-xs-3">
						    <input type="text" class="form-control" id="option" name="option1" placeholder="Option">
						    </div>
						  
						  <div class="checkbox col-xs-1">
						    <label>
						      <input type="checkbox" name="isCorrect1" > isCorrect ?
						    </label>
						  </div>
						   <label class="col-xs-2 control-label" for="explanation">Explanation</label>
						   <div class="col-xs-4">
						    <textarea class="form-control" name="description1" rows="4"></textarea>
						    </div>
						    <div class="col-xs-1">
					            <button type="button" class="btn btn-default addButton"><i class="glyphicon glyphicon-plus"></i></button>
					        </div>
						  </div>
						  
						   <div id="optionTemplate" class="form-group hide" style="display: none; width: 0px; height: 0px;">
						    <label class="col-xs-1 control-label" for="option">Option</label>
						    <div class="col-xs-3">
						    <input type="text" class="form-control" id="option" name="option" placeholder="Option" disabled="disabled" data-bv-notempty data-bv-notempty-message="This option is required and can not be left empty">
						    </div>
						  
						  <div class="checkbox col-xs-1">
						    <label>
						      <input type="checkbox" name="isCorrect" disabled="disabled" > isCorrect ?
						    </label>
						  </div>
						   <label class="col-xs-2 control-label" for="explanation">Explanation</label>
						   <div class="col-xs-4">
						    <textarea class="form-control" name="description" disabled="disabled" rows="4" ></textarea>
						    </div>
						    <div class="col-xs-1">
					            <button type="button" class="btn btn-default removeButton"><i class="glyphicon glyphicon-minus"></i></button>
					        </div>
						  </div>
						  
						  
				  </div>
					 
				</div>
				<div class="row">
					<div class="col-xs-12 col-md-6">
						<div class="form-group"  align="center">
							     <button id="saveFormBtn" type=submit class="btn btn-primary btn-lg" >Save</button> 
					    </div>
					</div>
					<div class="col-xs-12 col-md-6" align="center">
						<div class="form-group">
								 <button type="button" class="btn btn-default btn-lg" data-dismiss="modal">Cancel</button>
					    </div>
				   </div>
      			     
				</div>
			</form>	
      </div>
    </div>
  </div>
</div>   

<script>
    function operateFormatter(value, row, index) {
        return [
            '<a class="like" href="javascript:void(0)" title="Like">',
                '<i class="glyphicon glyphicon-heart"></i>',
            '</a>',
            '<a class="edit ml10" href="javascript:void(0)" title="Edit">',
                '<i class="glyphicon glyphicon-edit"></i>',
            '</a>',
            '<a class="remove ml10" href="javascript:void(0)" title="Remove">',
                '<i class="glyphicon glyphicon-remove"></i>',
            '</a>'
        ].join('');
    }

    
</script>

 <link href="<c:url value="/resources/css/bootstrap-table.css" />" rel="stylesheet">
 <script src="<c:url value="/resources/js/bootstrap-table.js" />"></script>
 <script src="<c:url value="/resources/js/certifier-user.js" />"></script>
 
 
 

    
