<!DOCTYPE html>
<html>
    <head>
        <title>Making DataTable fully editable</title>
      <link href="media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <link href="media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />
        <script src="scripts/jquery-1.4.4.min.js" type="text/javascript"></script>
        <script src="scripts/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="scripts/jquery.dataTables.editable.js" type="text/javascript"></script>
        <script src="scripts/jquery.jeditable.js" type="text/javascript"></script>
        <script src="scripts/jquery.validate.js" type="text/javascript"></script>
        <script src="scripts/jquery-ui.js" type="text/javascript"></script>
        <script type="text/javascript">
        $(document).ready(function () {
            $("#companies").dataTable({
                "bServerSide": true,
                "sAjaxSource": "/quiz-app/rest/users",
                "bProcessing": true,
                "sPaginationType": "full_numbers",
                "bJQueryUI": true,
                "aoColumns": [
                      { "sName": "id" },
                      { "sName": "emailid" },
                      { "sName": "password" },
                      { "sName": "role" }
                     ]
         }).makeEditable({
        	 sUpdateURL: "/quiz-app/rest/users/update",
        	 sAddURL: "/quiz-app/rest/users/add",
        	 sDeleteURL: "/quiz-app/rest/users/delete",
        	             
        	    "aoColumns": [
        	          	    {
    							cssclass: "required"
							},
							{
    							//DEFAULT SETTINGS FOR THIS COLUMN
							},
							{
								    indicator: 'Saving...',
							        tooltip: 'Click to select town',
							        loadtext: 'loading...',
							        type: 'textarea',
							        onblur: 'submit'
							},
        	                  null  //null for read-only columns
        	              ]
        	              });
            
        });
        </script>
    </head>
    <body id="dt_example">
    
    <div id="container">
    
        <h1>Upload Test</h1> 
				<form action="rest/tests" method="post" enctype="multipart/form-data">
	   <p>
	    <label for="name">Select a file </label><input type="file" name="file" size="45" />
	    <br />
	     <label for="name">Test Name</label><input type="text" name="testname" id="testname" />
	    <br />
		
	   </p>
 
	   <input type="submit" value="Upload It" />
	</form>
        </div>
    
        <div id="container">
            <div id="demo_jui">
            <button id="btnAddNewRow" value="Ok">Add User</button> 
    		<button id="btnDeleteRow" value="cancel">Delete User</button>
		        <table id="companies" class="display">
		            <thead>
		                <tr>
		                	<th>id</th>
		                    <th>emailid</th>
		                    <th>Password</th>
		                    <th>role</th>
		                </tr>
		            </thead>
		            <tbody>
		          
		            </tbody>
		        </table>
		    </div>          
            
            <form id="formAddNewRow" action="#" title="Add new User">
			    <input type="hidden" id="id" name="id" value="-1" rel="0" />
			    <label for="name">Email Id</label><input type="text" name="emailid" id="emailid" rel="1" />
			    <br />
			    <label for="name">password</label><input type="password" name="password" id="password"  rel="2"/>
			    <br />
			    <label for="name">role</label><select name="role" id="role" rel="3">
			                                        <option value="1">Admin</option>
			                                        <option value="2">Guest</option>
			                                        <option value="3">Member</option>
			                                        </select> 
			    <br />      
			</form>

        </div>
        
        
        
        
    </body>
</html>

<!-- 

  <tr>
                    <td>Emkay Entertainments</td>
                    <td>Nobel House, Regent Centre</td>
                    <td>Lothian</td>
                </tr>
                <tr>
                    <td>The Empire</td>
                    <td>Milton Keynes Leisure Plaza</td>
                    <td>Buckinghamshire</td>
                </tr>
                <tr>
                    <td>Asadul Ltd</td>
                    <td>Hophouse</td>
                    <td>Essex</td>
                </tr>
                <tr>
                    <td>Ashley Mark Publishing Company</td>
                    <td>1-2 Vance Court</td>
                    <td>Tyne &amp; Wear</td>
                </tr>
                <tr>
                    <td>MuchMoreMusic Studios</td>
                    <td>Unit 29</td>
                    <td>London</td>
                </tr>
                <tr>
                    <td>Audio Records Studios</td>
                    <td>Oxford Street</td>
                    <td>London</td>
                </tr>


 -->
