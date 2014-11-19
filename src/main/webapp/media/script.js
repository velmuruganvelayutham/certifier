$(document).ready(function(){
  console.log('Welcome to Certifier! Its free for taking mock exams');
  
//alert( $(' .active').length+' elements');
  //$('#user_dropdown a ').hide();
  $('#button1').show();
  $('#about-us-modal').modal('hide');
  $('#contact-us-modal').modal('hide');
  
 $('#button1').click(function() {
	// alert( $('#button1').length+' elements');
	$('#form_login').show();
	$('#div-signin').hide();
	 });
 $('#button2').click(function() {
	 //alert( $('#button1').length+' elements');
	$('#form_login').show();
	$('#div-signup').hide();
	 });
 
  $('.active a ').click(function() {

  //home page should be coming here.
  });
  
  $('#about-us').click(function() {
		// alert( $('.active a').length+' elements');
	  var options = {
			    "show" : "true",
			    "remote": "home.jsp"
			};
	  
		 $('#about-us-modal').modal(options);
	 });
  $('#contact-us').click(function() {
		 $('#contact-us-modal').modal('show');
	 });
  
  
  $('#button-right').click(function() {		
  var nextQuestionNo=  $('#inp-hidden-right').val();
  for(var i=1;i<6;i++){
	  var length=0;
	  console.log(length);
	 
		 if( $('#checkbox'+i).prop('checked')==false){
			 length++;
		 }
		 if(length==5){
			alert('Please select some options');
		 }
	  }
  
	  $.getJSON('http://localhost:8080/quiz-app/rest/tests/1/question/'+nextQuestionNo, 
			    function(data) {
		  
		  //update all the checkbox to false
		 
		  		$('#checkbox1').prop('checked', false);
		  		$('#checkbox2').prop('checked', false);
		  		$('#checkbox3').prop('checked', false);
		  		$('#checkbox4').prop('checked', false);
		  		$('#checkbox5').prop('checked', false);
		        $('.col-lg-12 p b').text(data.question+'Choose '+'Option[s]');
		        $('#label1').text(data.optionList[0].option);
		        $('#label2').text(data.optionList[0].option);
		        $('#label3').text(data.optionList[0].option);
		        $('#label4').text(data.optionList[0].option);
		        $('#label5').text(data.optionList[0].option);
		        $('#inp-hidden-right').val(data.nextQuestionNo);
		        $('#inp-hidden-left').val(data.nextPreviousNo);
			    //  alert('Fetched' + data.iTotalRecords + ' items!');
			    });
	  
		 });
  $('#button-submit').click(function() {	
	 alert('Are you sure to submit the quiz ?'); 
	  
  });
  
$('#button-left').click(function() {	
	 var previousQuestionNo=  $('#inp-hidden-left').val();
	 
	  console.log(previousQuestionNo);
		  $.getJSON('http://localhost:8080/quiz-app/rest/tests/1/question/'+previousQuestionNo, 
				    function(data) {
			        $('.col-lg-12 p b').text(data.question+ 'Choose '+'Option[s]');
			        $('#label1').text(data.optionList[0].option);
			        $('#label2').text(data.optionList[1].option);
			        $('#label3').text(data.optionList[0].option);
			        $('#label4').text(data.optionList[0].option);
			        $('#label5').text(data.optionList[0].option);
			        $('#inp-hidden-right').val(data.nextQuestionNo);
			        $('#inp-hidden-left').val(data.nextPreviousNo);
				    //  alert('Fetched' + data.iTotalRecords + ' items!');
				    });
	  
  });

$('#ocja-test ,#ocewcd-test,#ocejpa-test,#ocebcd-test,#ocewsd-test').click(function(e){
	 alert('Test is coming in the next release !.'); 
	 e.preventDefault();
});
  $('#form_submit').submit(function() {
		$.post('rest/users/add', $('#form_submit').serialize(),function (data, textStatus, jqXHR){
//		alert("User registration successful:"+$.cookie('Set-Cookie'));	
			  console.log(jqXHR.getResponseHeader('Set-Cookie'));
		if($.cookie('name')!=null){
			$('#user_dropdown a ').show();
			$('.jumbotron').hide();
		}
		
		});
		return false;
		
});
});