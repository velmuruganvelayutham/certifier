$(document).ready(function() {
	 var MAX_OPTIONS = 5;

	 
	 window.operateEvents = {
		        'click .like': function (e, value, row, index) {
		            alert('You click like icon, row: ' + JSON.stringify(row));
		            console.log(value, row, index);
		        },
		        'click .edit': function (e, value, row, index) {
		            console.log('You click edit icon, row: ' + JSON.stringify(row) + "index: "+ index);
		            $('#addNewTestModal').on('shown.bs.modal', function (e) {
		            	if(	$('#addNewTestModal').data('action')=="edit"){
		            	 console.log('You click edit icon, row: inside show.bs.modal ' + JSON.stringify(row));
		            	 $.each($('#addNewTestModal').find('input'),function(i,v){
		                     console.log(row[$(v).attr('name')])
		                     $(v).val(row[$(v).attr('name')]);
		          })}
		            })
		            $('#addNewTestModal').find('form').attr('action',ctx+"/tests"+ $('#question-table').data('testid')+ "/edit").data('index',index);
		            $('#addNewTestModal').data('action','edit')
		            $('#addNewTestModal').modal('show');
		            $('#ajaxform').bootstrapValidator('resetForm',true);
		            
		        },
		        'click .remove': function (e, value, row, index) {
		            alert('You click remove icon, row: ' + JSON.stringify(row));
		            console.log(value, row, index);
		        }
		    };

 $('#addBtnDetail').click(function(e){
   	$('#addNewTestModal').data('action','add')
 	console.log('action is changed to tests/add: ');
   	$('#ajaxform').attr('action',ctx+"/tests/"+ $('#question-table').data('testid')+ "/add");  
 });
 
$('#addNewTestModal').on('shown.bs.modal', function() {
	
	if(	$('#addNewTestModal').data('action')=="add"){
		$('#ajaxform').bootstrapValidator('resetForm',true);
		console.log('Form is reset: ');
	}
});

//Bootstrap validator for add vendor modal form.
$('#ajaxform').bootstrapValidator({
	excluded:[':disabled', ':hidden', ':not(:visible)'],
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        question: {
            validators: {}
        },
        'option1': {
            validators: {}
        } 
        
    }
}).on('success.form.bv', function(e) {
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
              },
              success:function(data, textStatus, jqXHR) 
              {
                  //data: return data from server
              	 console.log(JSON.stringify(data));
            	 $('#addNewTestModal').modal('hide');
            	 console.log(this.url);
            	 if(this.url=="/certifier/tests/"+$('#question-table').data('testid')+ "/add"){
            		 $('#question-table').bootstrapTable('append', data);
             		 $('#statusbar').append(' <div align="middle" > <strong> Record saved successfully!. </strong> </div>').show();
            	 }
            	 else{
            		 $('#question-table').bootstrapTable('updateRow', {"index":$form.data('index'),"row":JSON.parse(data)});
            		 $('#statusbar').append(' <div align="middle" > <strong> Record updated successfully!. </strong> </div>').show();
            	 }
            	 
              },
              error: function(jqXHR, textStatus, errorThrown) 
              {
              	alert(errorThrown);     
              }
          });
})      //Add button click handler
        .on('click', '.addButton', function() {
            var $template = $('#optionTemplate'),
                $clone    = $template
                                .clone()
                                .removeClass('hide')
                                .removeAttr('id')
                                .removeAttr('style')
                                .insertBefore($template);
          var length=$('#ajaxform').find(':visible[name^="option"]').length
              $clone.find('[name="option"]').removeAttr('name').attr('name','option'+ (length));
	          $clone.find('[name="isCorrect"]').removeAttr('name').attr('name','isCorrect'+ (length));
	          $clone.find('[name="description"]').removeAttr('name').attr('name','description'+ (length));
            $option=$clone.find('[name="option'+(length)+'"]');
            $clone.find('[name="isCorrect'+(length)+'"]').removeAttr('disabled');
            $clone.find('[name="description'+(length)+'"]').removeAttr('disabled');
            $option.removeAttr('disabled ');
               
            // Add new field
                var option='option'+ (length);
          
            $('#ajaxform').bootstrapValidator('addField', $option);
        })

        // Remove button click handler
        .on('click', '.removeButton', function() {
            var $row    = $(this).parents('.form-group'),
                $option = $row.find('[name^="option"]');
            
            // Remove element containing the option
            $row.remove();
             
            // Remove field
            $('#ajaxform').bootstrapValidator('removeField', $option);
        })

        // Called after adding new field
        .on('added.field.bv', function(e, data) {
            // data.field   --> The field name
            // data.element --> The new field element
            // data.options --> The new field options  
        	 var length=$('#ajaxform').find(':visible[name^="option"]').length;
        	  $('#totalOptions').val(length);
                if (length >= MAX_OPTIONS) {
                    $('#ajaxform').find('.addButton').attr('disabled', 'disabled');
                }
            
        })

        // Called after removing the field
        .on('removed.field.bv', function(e, data) {
          
        	 var length=$('#ajaxform').find(':visible[name^="option"]').length;
        	 $('#totalOptions').val(length);
                if (length < MAX_OPTIONS) {
                    $('#ajaxform').find('.addButton').removeAttr('disabled');
                }
            
        });
});
