 $(document).ready(function() { 
	 var options = { 
			    contentType:"multipart/form-data",
			    beforeSend: function() 
			    {
			   	 $("#progress").show();
			   	 $("#message").html("");
			      
			    },
			    uploadProgress: function(event, position, total, percentComplete) 
			    {
			 
			    },
			    success: function() 
			    {
			    	 $("#progress").hide();
			    },
			    complete: function(response) 
			    {
			    	var str="uploaded successfully";
			        $("#message").html("<font color='green'>"+ str  +"</font>");
			    },
			    error: function()
			    {
			        $("#message").html("<font color='red'> ERROR: unable to upload files</font>");
			    }
			}; 
	 
	  // bind to the form's submit event 
	    $('#importCSV').submit(function() { 
	        // inside event callbacks 'this' is the DOM element so we first 
	        // wrap it in a jQuery object and then invoke ajaxSubmit 
	    	 // bind 'myForm' and provide a simple callback function 
            $('#importCSV').ajaxForm(options); 
	        // !!! Important !!! 
	        // always return false to prevent standard browser submit and page navigation 
	        return false; 
	    });
	 
	      
            
            $(function () {
     		   $('table').footable({ bookmarkable: { enabled: true }}).bind({
                 'footable_filtering': function (e) {
                     var selected = $('.filter-status').find(':selected').text();
                     if (selected && selected.length > 0) {
                         e.filter += (e.filter && e.filter.length > 0) ? ' ' + selected : selected;
                         e.clear = !e.filter;
                     }
                 },
                 'footable_filtered': function() {
                     var count = $('table.demo tbody tr:not(.footable-filtered)').length;
                     $('.row-count').html(count + ' rows found');
                 }
             });

             $('.clear-filter').click(function (e) {
                 e.preventDefault();
                 $('.filter-status').val('');
                 $('table.demo').trigger('footable_clear_filter');
                 $('.row-count').html('');
             });

             $('.filter-status').change(function (e) {
                 e.preventDefault();
                 $('table.demo').data('footable-filter').filter( $('#filter').val() );
             });
         });
            
//            $('#search').marcoPolo({
//            	  url: getContextPath()+ "/search",
//            	  minChars: 3,
//            	  required: true,
//            	  formatItem: function (data, $item) {
//            	    return data.first_name + ' ' + data.last_name;
//            	  },
//            	  onSelect: function (data, $item) {
//            	    window.location = data.profile_url;
//            		  alert(data.profile_url);
//            	  },
//            	  formatData:function (data){
//            		  return data.first_name + ' ' + data.last_name;
//            	  }
//            	});
            
            

            
//            $('#search').autocomplete({
//                serviceUrl: getContextPath()+ "/search",
//                paramName:'q',
//                dataType:'json',
//                minChars:3,
//                onSelect: function (suggestion) {
//                    alert('You selected: ' + suggestion.value + ', ' + suggestion.data);
//                },
//                onSearchComplete: function (query, suggestions) {
//                	
//                	console.log(suggestions);
//                	
//                }
//            });
          
            
            $('#newURLSave').click(function(){
             	var text= $('#newURLText').val();
             	$.ajax({
             		  type: "POST",
             		  url:  getContextPath()+ "/settings/save",
             		  data: { "url": text}
             		})
             		  .done(function( msg ) {
             			location.reload();
             		    alert(msg );
             		  }).fail(function( msg ) {
             		    alert(msg );
             		  });

             	console.log('newurl save is clicked !'+ text);
             	
             });
            
            
            var bestPictures = new Bloodhound({
                datumTokenizer: Bloodhound.tokenizers.obj.whitespace('first_name'),
                queryTokenizer: Bloodhound.tokenizers.whitespace,
                remote: getContextPath()+'/search?q=%QUERY'
            });

            bestPictures.initialize();
            var compiledTemplate = Hogan.compile('<p  class="repo-language" ><strong>{{first_name}}</strong></p>');
            $('#bloodhound .typeahead').typeahead(null, {
                name: 'best-pictures',
                displayKey: 'first_name',
                source: bestPictures.ttAdapter(),
                templates: {
                    empty: [
                      '<div class="empty-message">',
                      'unable to find any results !',
                      '</div>'
                    ].join('\n'),
                    suggestion: compiledTemplate.render.bind(compiledTemplate)
                  }
               
            });
            
            // enable and disable buttons:
            $(':checkbox').click(function(){
            	var n = $( "input:checked" ).length;
            	console.log('length is '+ n);
            	if(n!==0){
	               	 $("#deleteBtn").removeClass('disabled');
	               	 $("#editBtn").removeClass('disabled');
	               	 $("#settingEditBtn").removeClass('disabled');
	               	 $("#settingDeleteBtn").removeClass('disabled');
            	 }
            	else{
                   	 $("#deleteBtn").addClass('disabled');
                   	 $("#editBtn").addClass('disabled');
                   	 $("#settingEditBtn").addClass('disabled');
                   	 $("#settingDeleteBtn").addClass('disabled');
            	}
             });
            
            // click of Add button , show a modal with id "addNewVendor"
            $('#addBtn').click(function(){
            	$('#ajaxform').attr('action',getContextPath()+'/exhibitors/add');
            	$('#addNewVendor').modal('show');
            });
            
            // click of Add button , show a modal with id "addNewVendor"
            $('#editBtn').click(function(){
            	var selected=$( "input:checked" );
            	var id=selected[0].value;
            	$('#vendorid').val(id);
            	$('#showName').val($('#showName'+id).text());
            	$('#showDate').val($('#showDate'+id).text());
            	$('#vendorName').val($('#vendorName'+id).text());
            	$('#boothNo').val($('#boothNo'+id).text());
            	$('#address').val($('#address'+id).text());
            	$('#phone').val($('#phone'+id).text());
            	$('#fax').val($('#fax'+id).text());
            	$('#email').val($('#email'+id).text());
            	$('#website').val($('#email'+id).text());
            	$('#productCategory').val($('#productCategory'+id).text());
            	$('#products').val($('#products'+id).html());
            	$('#ajaxform').attr('action',getContextPath()+'/exhibitors/edit');
            	$('#addNewVendor').modal('show');
            	
            });
            
            // click of refresh button , show a modal with id "addNewVendor"
            $('#refreshBtn').click(function(){
            	location.reload();
            });
            
            // click of Delete button , show conform dialog and if yes, delete it.
            $('#deleteBtn').click(function(){
            	console.log('delete button is clicked');
            	$('#ajaxform').attr('action',getContextPath()+'/exhibitors/delete');
            	deleteRecord();
            });
            
            function deleteRecord(){
            	var selected=$( "input:checked" );
            	var parent=selected.parent().parent();
            	console.log('selected rows: '+ selected);
            	var ids=[];
            	for(i=0;i<selected.length;i++){
            		var id= {"id": selected[i].value};
            		ids.push(id);
            	}
            	console.log('ids: '+ ids);
            	 $.ajax(
                         {
                             //url : "exhibitors/delete",
                        	 url:$('#ajaxform').attr('action'),
                             type: "POST",
                             contentType:"application/json",
                             data :  JSON.stringify(ids),
                             beforeSend: function(){
                            	 $('#statusbar').empty();
                            	 $("#myModalLabel").html("<font color='black'>"+ "Deleting !. "  +"</font>");
                            	 $("#myModal").modal('show');
                             },
                             success:function(data, textStatus, jqXHR) 
                             {
                            	 parent.remove();
                            	 $("#myModal").modal('hide');
                			     $('#deleteBtn').addClass('disabled');
                			     $('#statusbar').append(' <div align="middle" > <strong> deleted successfully!. </strong> </div>').show();
                             	 console.log(textStatus);
                             },
                             error: function(jqXHR, textStatus, errorThrown) 
                             {
                             	alert(errorThrown);     
                             }
                         });
            }

            // click of Add button , show a modal with id "addNewVendor"
            $('#settingAddBtn').click(function(){
            	$('#ajaxform').attr('action',getContextPath()+'/settings/add');
            	$('#addNewSetting').modal('show');
            	
            });
            
            // click of Add button , show a modal with id "addNewVendor"
            $('#settingEditBtn').click(function(){
            	var selected=$( "input:checked" );
            	var id=selected[0].value;
            	$('#settingid').val(id);
            	$('#websiteName').val($('#websiteName'+id).text());
            	$('#url').val($('#url'+id).text());
            	$('#ajaxform').attr('action',getContextPath()+'/settings/edit');
            	$('#addNewSetting').modal('show');
            	
            });
            
            // click of Delete button , show conform dialog and if yes, delete it.
            $('#settingDeleteBtn').click(function(){
            	console.log('delete button is clicked');
            	$('#ajaxform').attr('action',getContextPath()+'/settings/delete');
            	deleteRecord();
            });
            
          //callback handler for form submit
//            $("#ajaxform").submit(function(e)
//            {
//                var postData = $(this).serializeArray();
//                var formURL = $(this).attr("action");
//                $.ajax(
//                {
//                    url : formURL,
//                    type: "POST",
//                    data : postData,
//                    beforeSend:function(){
//                    	
//                    },
//                    success:function(data, textStatus, jqXHR) 
//                    {
//                        //data: return data from server
//                    	 console.log(textStatus);
//                    	 $('#addNewVendor').modal('hide');
//                    },
//                    error: function(jqXHR, textStatus, errorThrown) 
//                    {
//                    	alert(errorThrown);     
//                    }
//                });
//                e.preventDefault(); //STOP default action
//              //  e.unbind(); //unbind. to stop multiple form submit.
//            });
//            
//            // click of save button on the modal.
//            
//            $('#saveFormBtn').click(function(e){
//            	alert(e);
//            	$('#ajaxform').submit();            	
//            });
            
            
//            Bootstrap validator for add vendor modal form.
            $('form').bootstrapValidator().on('success.form.bv', function(e) {
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
                          	 console.log(textStatus);
                          	 $('#addNewVendor').modal('hide');
                          	 $('#addNewSetting').modal('hide');
                          	 $('#statusbar').append(' <div align="middle" > <strong> done successfully!. </strong> </div>').show();
                          	 
                          },
                          error: function(jqXHR, textStatus, errorThrown) 
                          {
                          	alert(errorThrown);     
                          }
                      });
            });
            
            
            //reset the form in the model whenever is opened. 
            
            $('#addNewSetting').on('hide.bs.modal', function() {
                $('#ajaxform').bootstrapValidator('resetForm', true);
            });
            
            $('#addNewVendor').on('hide.bs.modal', function() {
                $('#ajaxform').bootstrapValidator('resetForm', true);
            });
            
            $("#urlDropDown").change(function(){
                var id= $('option:selected', this).attr('data-urlid');
                $('#hiddenUrlId').val(id);
            });
            
            $.fn.typeahead.Constructor.prototype.blur = function() {
                var that = this;
                setTimeout(function () { that.hide() }, 250);
            };
       }); 


 function submit(url,id){
 	var text = $('#'+id).val();
 	var id=$('#hiddenUrlId').val();
 	$.ajax({
 		  type: "POST",
 		  url:  getContextPath()+ url,
 		  beforeSend: function( xhr ) {
 			 $('#extractStatusbar').empty();
 			 $('#myModal').modal('show');
 			  },
 		  data: { "url": text,"id":id}
 		})
 		  .done(function( msg ) {
 			 $('#myModal').modal('hide');
 			 $('#extractStatusbar').append(' <div align="middle" > <strong> scraping done successfully!. </strong> </div>').show();
 		    console.log(msg );
 		  }).fail(function( msg ) {
 		    alert(msg );
 		  });
 }
        
 function getContextPath() {
	   return ctx;
	}
 
 