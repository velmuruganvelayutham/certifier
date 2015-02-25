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
  <li> <a href="<c:url value="/tests" />">tests</a></li>
  <li class="active"><c:out value="${id}"/> </li> 
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
        <th data-field="question" data-align="center" data-sortable="true" data-formatter="codeFormatter"   >Question Name</th>
        <th data-field="options" data-align="center" data-sortable="true">Options</th>
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
        <h4 class="modal-title" id="addNewTestLabel">Add New Question </h4>
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
						  
						  <!--  wysiwyg editor toolbar button -->
						  <!-- <div>
<div class="btn-toolbar" data-role="editor-toolbar" data-target="#editor">
      <div class="btn-group">
        <a class="btn dropdown-toggle" data-toggle="dropdown" title="" data-original-title="Font"><i class="icon-font"></i><b class="caret"></b></a>
          <ul class="dropdown-menu">
          <li><a data-edit="fontName Serif" style="font-family:'Serif'">Serif</a></li><li><a data-edit="fontName Sans" style="font-family:'Sans'">Sans</a></li><li><a data-edit="fontName Arial" style="font-family:'Arial'">Arial</a></li><li><a data-edit="fontName Arial Black" style="font-family:'Arial Black'">Arial Black</a></li><li><a data-edit="fontName Courier" style="font-family:'Courier'">Courier</a></li><li><a data-edit="fontName Courier New" style="font-family:'Courier New'">Courier New</a></li><li><a data-edit="fontName Comic Sans MS" style="font-family:'Comic Sans MS'">Comic Sans MS</a></li><li><a data-edit="fontName Helvetica" style="font-family:'Helvetica'">Helvetica</a></li><li><a data-edit="fontName Impact" style="font-family:'Impact'">Impact</a></li><li><a data-edit="fontName Lucida Grande" style="font-family:'Lucida Grande'">Lucida Grande</a></li><li><a data-edit="fontName Lucida Sans" style="font-family:'Lucida Sans'">Lucida Sans</a></li><li><a data-edit="fontName Tahoma" style="font-family:'Tahoma'">Tahoma</a></li><li><a data-edit="fontName Times" style="font-family:'Times'">Times</a></li><li><a data-edit="fontName Times New Roman" style="font-family:'Times New Roman'">Times New Roman</a></li><li><a data-edit="fontName Verdana" style="font-family:'Verdana'">Verdana</a></li></ul>
        </div>
      <div class="btn-group">
        <a class="btn dropdown-toggle" data-toggle="dropdown" title="" data-original-title="Font Size"><i class="icon-text-height"></i>&nbsp;<b class="caret"></b></a>
          <ul class="dropdown-menu">
          <li><a data-edit="fontSize 5"><font size="5">Huge</font></a></li>
          <li><a data-edit="fontSize 3"><font size="3">Normal</font></a></li>
          <li><a data-edit="fontSize 1"><font size="1">Small</font></a></li>
          </ul>
      </div>
      <div class="btn-group">
        <a class="btn btn-info" data-edit="bold" title="" data-original-title="Bold (Ctrl/Cmd+B)"><i class="icon-bold"></i></a>
        <a class="btn" data-edit="italic" title="" data-original-title="Italic (Ctrl/Cmd+I)"><i class="icon-italic"></i></a>
        <a class="btn" data-edit="strikethrough" title="" data-original-title="Strikethrough"><i class="icon-strikethrough"></i></a>
        <a class="btn" data-edit="underline" title="" data-original-title="Underline (Ctrl/Cmd+U)"><i class="icon-underline"></i></a>
      </div>
      <div class="btn-group">
        <a class="btn" data-edit="insertunorderedlist" title="" data-original-title="Bullet list"><i class="icon-list-ul"></i></a>
        <a class="btn" data-edit="insertorderedlist" title="" data-original-title="Number list"><i class="icon-list-ol"></i></a>
        <a class="btn" data-edit="outdent" title="" data-original-title="Reduce indent (Shift+Tab)"><i class="icon-indent-left"></i></a>
        <a class="btn" data-edit="indent" title="" data-original-title="Indent (Tab)"><i class="icon-indent-right"></i></a>
      </div>
      <div class="btn-group">
        <a class="btn btn-info" data-edit="justifyleft" title="" data-original-title="Align Left (Ctrl/Cmd+L)"><i class="icon-align-left"></i></a>
        <a class="btn" data-edit="justifycenter" title="" data-original-title="Center (Ctrl/Cmd+E)"><i class="icon-align-center"></i></a>
        <a class="btn" data-edit="justifyright" title="" data-original-title="Align Right (Ctrl/Cmd+R)"><i class="icon-align-right"></i></a>
        <a class="btn" data-edit="justifyfull" title="" data-original-title="Justify (Ctrl/Cmd+J)"><i class="icon-align-justify"></i></a>
      </div>
      <div class="btn-group">
		  <a class="btn dropdown-toggle" data-toggle="dropdown" title="" data-original-title="Hyperlink"><i class="icon-link"></i></a>
		    <div class="dropdown-menu input-append">
			    <input class="span2" placeholder="URL" type="text" data-edit="createLink">
			    <button class="btn" type="button">Add</button>
        </div>
        <a class="btn" data-edit="unlink" title="" data-original-title="Remove Hyperlink"><i class="icon-cut"></i></a>

      </div>
      
      <div class="btn-group">
        <a class="btn" title="" id="pictureBtn" data-original-title="Insert picture (or just drag &amp; drop)"><i class="icon-picture"></i></a>
        <input type="file" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" style="opacity: 0; position: absolute; top: 0px; left: 0px; width: 41px; height: 30px;">
      </div>
      <div class="btn-group">
        <a class="btn" data-edit="undo" title="" data-original-title="Undo (Ctrl/Cmd+Z)"><i class="icon-undo"></i></a>
        <a class="btn" data-edit="redo" title="" data-original-title="Redo (Ctrl/Cmd+Y)"><i class="icon-repeat"></i></a>
      </div>
      <input type="text" data-edit="inserttext" id="voiceBtn" x-webkit-speech="" style="display: none;">
    </div>
    </div> -->
						  
						  
						  <div class="form-group">
						   <!--  <label class="col-xs-6 control-label" for="name">Problem Statement</label> -->
						    <div id="editor" class="editor  col-xs-12"> 
						     Problem Statement
						    <input type="hidden" class="form-control" id="testName" name ="question" placeholder="Question" >
                			</div>
						  </div>

						  <div class="form-group">
						    <!-- <label class="col-xs-1 control-label" for="option">Option</label> -->
						    <div class="editor col-xs-6" id="option" >
						     Option
						    <input type="hidden" class="form-control" id="option" name="option1" placeholder="Option">
						    </div>
						  
						  <div class="checkbox col-xs-1">
						    <label>
						      <input type="checkbox" name="isCorrect1" > isCorrect ?
						    </label>
						  </div>
						   <!-- <label class="col-xs-2 control-label" for="explanation">Explanation</label> -->
						   <div class="col-xs-4">
						    <textarea class="form-control" name="description1" rows="4" placeholder="Explanation"></textarea>
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
$(document).ready(function() {	
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
	  $('.editor').wysiwyg();
});



  

    
    function codeFormatter(value, row, index) {
        return [
            '<pre>',
            	value,              
            '</pre>'            
        ].join('');
    }
    
    
</script>

 <script src="<c:url value="/resources/js/bootstrap-wysiwyg.js" />"></script>
 <script src="<c:url value="/resources/js/jquery.hotkeys.js" />"></script>
 <link href="<c:url value="/resources/css/bootstrap-table.css" />" rel="stylesheet">
 <script src="<c:url value="/resources/js/bootstrap-table.js" />"></script>
 <script src="<c:url value="/resources/js/certifier-test-detail.js" />"></script>
 
 
 

    
