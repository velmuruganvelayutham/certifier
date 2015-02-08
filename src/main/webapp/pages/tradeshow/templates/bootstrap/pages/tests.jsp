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

<div id="custom-toolbar" class="btn-toolbar " role="toolbar">
  <div  class="btn-group"><button id="addBtn"  class="btn btn-default " type="button" data-toggle="modal" data-target="#addNewTestModal" > <span class="glyphicon glyphicon-plus"></span> Add </button> </div>
</div>


<table data-toggle="table" data-url="tests/data" data-toolbar="#custom-toolbar" data-click-to-select="true" data-height="400" data-side-pagination="server" data-pagination="true" data-page-list="[5, 10, 20, 50, 100, 200]" data-search="true">
    <thead>
    <tr>
        <th data-field="state" data-checkbox="true"></th>
        <th data-field="id" data-align="right" data-sortable="true">Test Name</th>
        <th data-field="name" data-align="center" data-sortable="true">Category</th>
        <th data-field="price" data-sortable="true" data-formatter="operateFormatter" data-events="operateEvents" >Action</th>
    </tr>
    </thead>
</table> 




   <!-- Modal  for adding new Settings -->
<div class="modal fade" id="addNewTestModal" tabindex="-1" role="dialog" aria-labelledby="addNewTestLabel" aria-hidden="true" data-toggle="validator" >
  <div class="modal-dialog ">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="addNewTestLabel">Add New Test </h4>
      </div>
<!--       <div class="modal-body" id="editModal"> </div> -->
      <div class="modal-body" >
				<form  id="ajaxform" role="form" method="post"  action="<c:url value="/tests/add" > </c:url>"
				data-bv-message="This value is not valid"
    			data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
   				data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
    			data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
				<div class="row">
					  <div class="col-xs-24 col-md-12"> 
					  	  <div class="form-group">
						    <input type="hidden" class="form-control" id="testid" name ="test_id" >
						  </div>
						  <div class="form-group">
						    <label for="name">name</label>
						    <input type="text" class="form-control" id="testName" name ="name" placeholder="Enter Test Name" 
						    data-bv-notempty="true"
                			data-bv-notempty-message="The test name is required and cannot be empty" >
						  </div>
						  <div class="form-group">
						    <label for="category">Category</label>
						    <input type="text" class="form-control" id="category" name="category" placeholder="Enter Category" 
						    data-bv-notempty="false">
						  </div>
						   <div class="form-group">
						    <label for="file">csv file</label>
						    <input type="file" class="form-control" id="file" name ="file" placeholder="browse file" 
						    data-bv-notempty="true"
                			data-bv-notempty-message="The file is required and cannot be empty" >
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
                '<i class="glyphicon glyphicon-export"></i>',
            '</a>',
            '<a class="edit ml10" href="javascript:void(0)" title="Edit">',
                '<i class="glyphicon glyphicon-edit"></i>',
            '</a>',
            '<a class="remove ml10" href="javascript:void(0)" title="Remove">',
                '<i class="glyphicon glyphicon-remove"></i>',
            '</a>'
        ].join('');
    }

    window.operateEvents = {
        'click .like': function (e, value, row, index) {
            alert('You click like icon, row: ' + JSON.stringify(row));
            console.log(value, row, index);
        },
        'click .edit': function (e, value, row, index) {
            alert('You click edit icon, row: ' + JSON.stringify(row));
            console.log(value, row, index);
        },
        'click .remove': function (e, value, row, index) {
            alert('You click remove icon, row: ' + JSON.stringify(row));
            console.log(value, row, index);
        }
    };
    
 /*    
    //callback handler for form submit
    $("#ajaxform").submit(function(e)
    {
         var postData = $(this).serializeArray();
         var formURL = $(this).attr("action");
         $.ajax(
         {
            url : formURL,
             type: "POST",
            data : postData,
            beforeSend:function(){
            	
            },
            success:function(data, textStatus, jqXHR) 
            {
                //data: return data from server
             	 console.log(JSON.stringify(data));
            	 $('#addNewTestModal').modal('hide');
            },
            error: function(jqXHR, textStatus, errorThrown) 
            {
            	alert(errorThrown);     
            }
        });
        e.preventDefault(); //STOP default action
      //  e.unbind(); //unbind. to stop multiple form submit.
    });
     
    // click of save button on the modal.
     
  $('#saveFormBtn').click(function(e){
  	console.log(e);
  	$('#ajaxform').submit();            	
}); */


$('#addNewTestModal').on('hide.bs.modal', function() {
    $('#ajaxform').bootstrapValidator('resetForm', true);
});
//Bootstrap validator for add vendor modal form.
$('#ajaxform').bootstrapValidator().on('success.form.bv', function(e) {
    // Prevent form submission
    e.preventDefault();
  
    // Get the form instance
    var $form = $(e.target);

    // Get the BootstrapValidator instance
    var bv = $form.data('bootstrapValidator');

    $.ajax({
              url : $form.attr('action'),
              type: "POST",
              data :  $form.serialize(),
              beforeSend:function(){
            	  $('#statusbar').empty();
            	  $("#addNewVendorLabel").html("<font color='black'>"+ "Adding Vendor . Please wait!. "  +"</font>");
              },
              success:function(data, textStatus, jqXHR) 
              {
                  //data: return data from server
              	 console.log(JSON.stringify(data));
            	 $('#addNewTestModal').modal('hide');
              	 $('#addNewSetting').modal('hide');
              	 $('#statusbar').append(' <div align="middle" > <strong> done successfully!. </strong> </div>').show();
              	 
              },
              error: function(jqXHR, textStatus, errorThrown) 
              {
              	alert(errorThrown);     
              }
          });
});

</script>

 <link href="<c:url value="/resources/css/bootstrap-table.css" />" rel="stylesheet">
 <script src="<c:url value="/resources/js/bootstrap-table.js" />"></script>
 
 
 

    
