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
 
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<div class="container"> 

<c:if test="${message == 'uploadDropbox'}">
	<form id="uploadFileToDropbox" role="form" method="post" action="uploadDropbox" enctype="multipart/form-data">
		<div class="form-group"> 
		<strong><label for="csvInputFile">UPLOAD FILES TO DROPBOX</label> </strong>
		    <input type="file" id="csvInputFile" name="dropbox-file">
		    <p class="help-block"> Upload the files from your computer.</p>
		</div>
		<div  class="form-group" id="progress" style="display: none"> 
		<img alt="progress image " src="<c:url value="/resources/image/progress.gif"></c:url>">
		</div>
		<div  class="form-group" id="message"> 
		 <button type="submit" class="btn btn-default">Submit</button>
		 </div>
		 <div  class="form-group" > 
		 <c:if test="${not empty dropboxLink}">
		 <span class="label label-success"><c:out value="${dropboxLink}"></c:out> </span>
		 <a href="${dropboxLink}" target="_blank">Click here to Open a dropbox folder: </a>
		 </c:if>
		 </div>
	</form>
	
</c:if>
<c:if test="${message == 'import'}">
	<form id="importCSV" role="form" method="post" action="import/csv" enctype="multipart/form-data">
		<div class="form-group"> 
		<label for="csvInputFile">CSV File</label>
		    <input type="file" id="csvInputFile" name="csv-file">
		    <p class="help-block"> Upload the CSV file from your computer.</p>
		</div>
		<div  class="form-group" id="progress" style="display: none"> 
		<img alt="progress image " src="<c:url value="/resources/image/progress.gif"></c:url>">
		</div>
		<div  class="form-group" id="message"> </div>
		 <button type="submit" class="btn btn-default">Submit</button>
	</form>
	
</c:if>
<c:if test="${message == 'list'}">
<div class="row">
<div class="col-xs-2">
    <input id="filter" type="text" class="form-control" placeholder="Search ">
</div>

<div class="btn-toolbar " role="toolbar">
  <div  class="btn-group"><button id="addBtn"  class="btn btn-default " type="button" data-toggle="tooltip" data-placement="left" title="ADD" > <span class="glyphicon glyphicon-plus"></span> Add </button> </div>
  <div  class="btn-group"><button id="editBtn" class="btn btn-default disabled" type="button" data-toggle="tooltip" data-placement="left" title="EDIT" > <span class="glyphicon glyphicon-pencil"></span> Edit </button> </div>
  <div  class="btn-group"><button id="deleteBtn" class="btn btn-default disabled" type="button" data-toggle="tooltip" data-placement="left" title="DELETE" ><span class="glyphicon glyphicon-trash"></span> Delete </button> </div>
  <div  class="btn-group"><button id="exportBtn" class="btn btn-default " type="button" data-toggle="tooltip" data-placement="left" title="Export CSV" > <span class="glyphicon glyphicon-export"></span> CSV Export </button> </div>
  <div  class="btn-group"><button id="refreshBtn" class="btn btn-default " type="button" data-toggle="tooltip" data-placement="left" title="Refresh" > <span class="glyphicon glyphicon-refresh"></span> Refresh </button> </div>
 
<!--    <div class="col-xs-2 col-md-1"> -->
<!--     <div class="input-group"> -->
<!--      <button  type="button" class="form-control"data-toggle="tooltip" data-placement="left" title="ADD" > Insert </button> -->
<!--     </div>/input-group -->
<!--   </div>/.col-lg-2 -->
  
<!--    <div class="col-xs-2 col-md-1"> -->
<!--     <div class="input-group"> -->
<!--      <button  type="button" class="form-control"data-toggle="tooltip" data-placement="left" title="EDIT" > Update </button> -->
<!--     </div>/input-group -->
<!--   </div>/.col-lg-2 -->
<!--   <div class="col-xs-2 col-md-1"> -->
<!--     <div class="input-group"> -->
<!--      <button type="button" class="form-control" data-toggle="tooltip" data-placement="left" title="REMOVE"> Remove </button> -->
<!--     </div>/input-group -->
<!--   </div>/.col-lg-2 -->
</div>
 <div id="statusbar" class="alert alert-success alert-dismissible" role="alert" style="display:none">
	  <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
 </div>
<table class="table table-bordered table-striped table-hover" data-filter="#filter" data-sort="true" data-page-size="5" >
      <thead>
        <tr>
          <th>
			<!-- <input type="checkbox"> -->
          </th>
          <th>Show</th>
          <th  data-type="numeric" data-sort-initial="true" >Show Date</th>
          <th>Vendor Name</th>
           <th>Booth No</th>
          <th data-toggle="true">Address</th>
          <th data-hide="all">Website</th>
          <th data-hide="all">Phone</th>
          <th data-hide="all">Fax</th>
          <th data-hide="all">Email</th>
          <th data-hide="all">Product Lines</th>
          <th data-hide="all">Category</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="vendor" items="${vendors}">
      
       <tr>
          <td>
           <input id="checkbox" type="checkbox" value="${vendor.vendor_id}">
          </td>
          <td id="showName${vendor.vendor_id}"><c:out value="${vendor.showName}"/></td>
          <td id="showDate${vendor.vendor_id}"><c:out value="${vendor.showStartDate}"/></td>
          <td id="vendorName${vendor.vendor_id}"><c:out value="${vendor.vendorName}"/></td>
          <td id="boothNo${vendor.vendor_id}"><c:out value="${vendor.boothNo}"/></td>
          <td id="address${vendor.vendor_id}"><c:out value="${vendor.address}"/></td>
          <td id="phone${vendor.vendor_id}"><c:out value="${vendor.website}"/></td>
          <td id="website${vendor.vendor_id}"><c:out value="${vendor.phone}"/></td>
          <td id="fax${vendor.vendor_id}"><c:out value="${vendor.fax}"/></td>
          <td id="email${vendor.vendor_id}"><c:out value="${vendor.email}"/></td>
          <td id="products${vendor.vendor_id}"><c:out value=""/></td>
          <td id="productCategory${vendor.vendor_id}"><c:out value=""/></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
    </div> <!-- table container ends here -->
  <div class="container">
  <c:url var="firstUrl" value="/exhibitors" />
<c:url var="lastUrl" value="/exhibitors?page=${page.totalNoOfPages} & size=${page.pageSize}" />
<c:url var="prevUrl" value="/exhibitors?page=${currentIndex - 1} & size=${page.pageSize}" />
<c:url var="nextUrl" value="/exhibitors?page=${currentIndex + 1} & size=${page.pageSize}" />

<div class="pager">
    <ul>
        <c:choose>
            <c:when test="${currentIndex == 1}">
                <li class="disabled"><a href="#">&lt;&lt;</a></li>
                <li class="disabled"><a href="#">&lt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${firstUrl}">&lt;&lt;</a></li>
                <li><a href="${prevUrl}">&lt;</a></li>
            </c:otherwise>
        </c:choose>
        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
            <c:url var="pageUrl" value="/exhibitors?page=${i}& size=${page.pageSize}" />
            <c:choose>
                <c:when test="${i == currentIndex}">
                    <li class="active" ><a style="color:black;background-color:blue" href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${currentIndex == page.totalNoOfPages}">
                <li class="disabled"><a href="#">&gt;</a></li>
                <li class="disabled"><a href="#">&gt;&gt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${nextUrl}">&gt;</a></li>
                <li><a href="${lastUrl}">&gt;&gt;</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>
</div> <!-- Pagination container ends here,. -->
</c:if>
<c:if test="${message == 'export'}">
<c:out value="${requestScope.message} "></c:out>
</c:if>
</div> 

<!-- loading modal for all the ajax calls. -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Extracting vendor details ...</h4>
      </div>
      <div class="modal-body">
			<div  class="form-group" id="progress"> 
				<img alt="progress image "  style="position: absolute; left: 30%; top: 50%; " src="<c:url value="/resources/image/progress.gif"></c:url>">
			</div>	
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
<!--    <button type="button" class="btn btn-primary">Save</button> -->
      </div>
    </div>
  </div>
</div>

  <!-- Modal  for adding new Vendors -->
<div class="modal fade" id="addNewVendor" tabindex="-1" role="dialog" aria-labelledby="addNewVendorLabel" aria-hidden="true" data-toggle="validator" >
  <div class="modal-dialog ">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="addNewVendorLabel">Add New Vendor Details.</h4>
      </div>
<!--       <div class="modal-body" id="editModal"> </div> -->
      <div class="modal-body" >
				<form  id="ajaxform" role="form" method="post"  action="<c:url value="/exhibitors/add"> </c:url>" 
				data-bv-message="This value is not valid"
    			data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
   				data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
    			data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
				<div class="row">
					  <div class="col-xs-12 col-md-6"> 
						    <input type="hidden" class="form-control" id="vendorid" name ="vendor_id" >
						  <div class="form-group">
						    <label for="showName">Show</label>
						    <input type="text" class="form-control" id="showName" name ="showName" placeholder="Enter Show Name" 
						    data-bv-notempty="true"
                			data-bv-notempty-message="The show name is required and cannot be empty" >
						  </div>
						  <div class="form-group">
						    <label for="showDate">Show Date</label>
						    <input type="text" class="form-control" id="showDate" placeholder="Enter Show Date">
						  </div>
						  <div class="form-group">
						    <label for="vendorName">Vendor Name</label>
						    <input type="text" class="form-control" id="vendorName" name="vendorName"  placeholder="Enter Vendor Name" required="required" 
						    data-bv-notempty="true"
                			data-bv-notempty-message="The vendor name is required and cannot be empty"> 
						  </div>
						  <div class="form-group">
						    <label for="boothNo">Booth No</label>
						    <input type="text" class="form-control" id="boothNo" name="boothNo" placeholder="Enter Booth No" 
						    data-bv-notempty="true"
                			data-bv-notempty-message="The boothno is required and cannot be empty">
						  </div>
						  <div class="form-group">
						    <label for="address">Address</label>
						    <input type="text" class="form-control" id="address" placeholder="Enter Address">
						  </div>
						  <div class="form-group">
						    <label for="phone">Phone</label>
						    <input type="text" class="form-control" id="phone" placeholder="Enter Phone">
						  </div>
						
				  </div>
					  <div class="col-xs-12 col-md-6">
					          <div class="form-group">
							    <label for="Fax">Fax</label>
							    <input type="text" class="form-control" id="fax" placeholder="Enter FAX">
							  </div>
					  		 <div class="form-group">
						        <label for="email">email</label>
						        <input type="text" class="form-control" id="email" placeholder="Enter Email">
						  	  </div>
							  <div class="form-group">
							    <label for="website">website</label>
							    <input type="text" class="form-control" id="website" placeholder="Enter website">
							  </div>
							  <div class="form-group">
							    <label for="productCategory">Product Category</label>
							    <input type="text" class="form-control" id="productCategory" placeholder="Enter Product Category">
							  </div>
							  <div class="form-group">
							    <label for="products">Products</label>
							    <input type="text" class="form-control" id="products" placeholder="Enter Products">
							  </div>
							  <div class="form-group">
							    <label for="description">Description</label>
							    <input type="text" class="form-control" id="description" placeholder="Enter Description">
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
<!--       <div class="modal-footer"> -->
<!--         <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button> -->
<!--         <button id="addFormBtn" type="button" class="btn btn-primary">Save</button>  -->
<!--       </div> -->
    </div>
  </div>
</div>

