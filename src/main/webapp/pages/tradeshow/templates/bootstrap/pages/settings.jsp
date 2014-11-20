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

     <!-- <c:out value="${requestScope.message} "></c:out> --> 
            
<div id="settingsContainer" class="container">

<!-- Nav tabs -->
<ul class="nav nav-tabs" role="tablist">
  <li class="active"><a href="#scrap" role="tab" data-toggle="tab">Scrap</a></li>
  <sec:authorize access="hasRole('ROLE_ADMIN')"> 
  <li><a href="#websites" role="tab" data-toggle="tab">Websites</a></li>
  </sec:authorize>
  <li><a href="#history" role="tab" data-toggle="tab">History</a></li>
   <li><a href="#dropbox-api-keys" role="tab" data-toggle="tab">Dropbox API Keys</a></li>
</ul>


<!-- Tab panes -->
<div class="tab-content">
  <div class="tab-pane active" id="scrap">
  		<div class="row spacer">
  		     <div id="extractStatusbar" class="alert alert-success alert-dismissible" role="alert" style="display:none">
				  <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	 		 </div>
  			 <div class="col-xs-8 col-md-4">
				<div class="input-group">
					 <span class="input-group-addon">
				        Name:
				     </span>
				     <input type="hidden" id="hiddenUrlId" value="${option.settings_id}">
					 <select id="urlDropDown" class="form-control">
					 <c:forEach var="option" items="${settings}">
					 <c:set var="id" value="${option.settings_id}" > </c:set>
					  <option data-urlid="${id}"><c:out value="${option.websiteName}"></c:out></option>
					 </c:forEach>
					</select>
				</div>
			</div>
			 <div class="col-xs-4 col-md-2">
				<button type="button" onclick='submit("/settings/extract","${id}")' class="btn btn-default" data-dismiss="modal">Execute</button>
			 </div>
		</div>
  </div>
  <div class="tab-pane" id="websites">
  
  				<div class="row row spacer">
<div class="col-xs-2 ">
    <input id="filter" type="text" class="form-control" placeholder="Search ">
</div>

<div class="btn-toolbar " role="toolbar">
  <div  class="btn-group"><button id="settingAddBtn"  class="btn btn-default " type="button" data-toggle="tooltip" data-placement="left" title="ADD" > <span class="glyphicon glyphicon-plus"></span> Add </button> </div>
  <div  class="btn-group"><button id="settingEditBtn" class="btn btn-default disabled" type="button" data-toggle="tooltip" data-placement="left" title="EDIT" > <span class="glyphicon glyphicon-pencil"></span> Edit </button> </div>
  <div  class="btn-group"><button id="settingDeleteBtn" class="btn btn-default disabled" type="button" data-toggle="tooltip" data-placement="left" title="DELETE" ><span class="glyphicon glyphicon-trash"></span> Delete </button> </div>
  <div  class="btn-group"><button id="exportBtn" class="btn btn-default " type="button" data-toggle="tooltip" data-placement="left" title="Export CSV" > <span class="glyphicon glyphicon-export"></span> CSV Export </button> </div>
  <div  class="btn-group"><button id="refreshBtn" class="btn btn-default " type="button" data-toggle="tooltip" data-placement="left" title="Refresh" > <span class="glyphicon glyphicon-refresh"></span> Refresh </button> </div>
</div>
 <div id="statusbar" class="alert alert-success alert-dismissible" role="alert" style="display:none">
	  <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
 </div>
<table class="table table-bordered table-striped table-hover" data-filter="#filter" data-sort="true" data-page-size="5" >
      <thead>
        <tr>
          <th></th>
          <th>Name</th>
          <th>URL</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="setting" items="${settings}" varStatus="status">
       <tr>
          <td>
           <input id="checkbox" type="checkbox" value="${setting.settings_id}" >
          </td>
          <td id="websiteName${setting.settings_id}"><c:out value="${setting.websiteName}"/></td>
          <td id="url${setting.settings_id}"><c:out value="${setting.url}"/></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
    </div> <!-- table container ends here -->
 </div>
	  <div class="tab-pane" id="history">This table will hold the status of the scraping process !. </div>
	  <div class="tab-pane" id="dropbox-api-keys"> 
	  
	  <div class="container">
  <div class="row row spacer">
  
  <form class="form-horizontal" role="form">
 <div class="form-group">
 <label for="inputEmail1" class="col-lg-2 control-label">App key</label>
 <div class="col-lg-10">
   <input type="text" class="form-control" id="inputEmail1" placeholder="App key" value="gw4w14qy8129lpi">
 </div>
 </div>
 <div class="form-group">
 <label for="inputPassword1" class="col-lg-2 control-label">App Secret</label>
 <div class="col-lg-10">
   <input type="text" class="form-control" id="inputPassword1" placeholder="App Secret" value="hpycgtegwghz183">
 </div>
 </div>
 
 <div class="form-group">
 <label for="inputPassword1" class="col-lg-2 control-label">Access Token</label>
 <div class="col-lg-10">
   <input type="text" class="form-control" id="inputPassword1" placeholder="Access Token" value="vmWxWONh_7gAAAAAAAAAE3egnyeHlXJ3EEHBLo8rFv6FU3IGil1Ps9zwGpNlpE5Z">
 </div>
 </div>
</form>
  </div></div>
	  
	  </div>
	  </div>



<!-- <button class="btn btn-primary" data-toggle="modal" data-target="#myModal"> -->
<!--   Add New  -->
<!-- </button> -->

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Extracting vendor details ...</h4>
      </div>
      <div class="modal-body">
			<div  class="form-group" id="progress"> 
				<img alt="progress image " align="middle" src="<c:url value="/resources/image/progress.gif"></c:url>">
			</div>	
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
<!--    <button type="button" class="btn btn-primary">Save</button> -->
      </div>
    </div>
  </div>
</div>
</div>
        		
 
   <!-- Modal  for adding new Settings -->
<div class="modal fade" id="addNewSetting" tabindex="-1" role="dialog" aria-labelledby="addNewSettingLabel" aria-hidden="true" data-toggle="validator" >
  <div class="modal-dialog ">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="addNewVendorLabel">Add New Setting Details.</h4>
      </div>
<!--       <div class="modal-body" id="editModal"> </div> -->
      <div class="modal-body" >
				<form  id="ajaxform" role="form" method="post"  action="<c:url value="/settings/add" > </c:url>"
				data-bv-message="This value is not valid"
    			data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
   				data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
    			data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
				<div class="row">
					  <div class="col-xs-24 col-md-12"> 
					  	  <div class="form-group">
						    <input type="hidden" class="form-control" id="settingid" name ="settings_id" >
						  </div>
						  <div class="form-group">
						    <label for="websiteName">WebsiteName</label>
						    <input type="text" class="form-control" id="websiteName" name ="websiteName" placeholder="Enter Website Name" 
						    data-bv-notempty="true"
                			data-bv-notempty-message="The website name is required and cannot be empty" >
						  </div>
						  <div class="form-group">
						    <label for="url">URL</label>
						    <input type="url" class="form-control" id="url" name="url" placeholder="Enter URL" 
						    data-bv-notempty="true"
               				data-bv-notempty-message="The URL is required and cannot be empty"
               				data-bv-uri-message="Enter a Valid URL ">
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
 
 

    
