<div class="container">
<div class="row">  
  <div class="col-lg-4">
   <!-- <button onclick="loadPage('createorder_product_detail.ejs');" class="btn btn-primary">Back</button>  -->
    <a href="#" onclick="loadPage('createorder_product_detail.ejs');"><img src="images/back_btn.png" /></a>
  </div>
  <div class="col-lg-4"><span class="label label-default">SKU Selected: JA0001 </span></div>
  
  <div class="col-lg-4 "><button class="btn btn-primary">Complete</button></div>
  </div>
</div>

<div class="container">

<div class="row">
  <% console.log(' selected Product is '+ selectedProduct.sku); %>
<div class="tabbable">
  <ul class="nav nav-tabs">

  <% var sections=[]; %>
   <% for(i=0;i<selectedProduct.custom_option.length;i++){ %>
   <% var secName=selectedProduct.custom_option[i].section_name.split(' ').join('-'); %>
   <% console.log(' section name '+ selectedProduct.custom_option[i].section_name); %>
   
   <% if (sections.indexOf(selectedProduct.custom_option[i].section_name) != -1)continue; %>
   <%sections.push(selectedProduct.custom_option[i].section_name);%>

    <li id="nav<%=i %>" ><a href="#tab-<%=secName %>" data-toggle="tab"> <%= selectedProduct.custom_option[i].section_name%></a></li>
    <%}%>

  </ul>

  <div class="tab-content">
   <% for(var i=0; i < sections.length; i++) { %>
         <% var secName=sections[i].split(' ').join('-'); %>
          <div class="tab-pane" id="tab-<%= secName %>">
          <div class="row">
            <div class="col-lg-6">
              <div class="mygrid-wrapper-div pre-scrollable">

       <% var count=0 %>
       <% for(var j=0; j < selectedProduct.custom_option.length; j++) { %>
       <% if(sections[i] ===  selectedProduct.custom_option[j].section_name){ %>
        <% if(selectedProduct.custom_option[j].is_dependent==="1") { %>
           <span class="label label-default "><%=selectedProduct.custom_option[j].title %> * </span>
           <hr> </hr>
        <% } %>
       
        <% if($.isArray(selectedProduct.custom_option[j].values)) { %>
          <% for(var k=0; k < selectedProduct.custom_option[j].values.length; k++) { %>
                 
                <div class="row"> 
                 <div class="col-lg-12">
                      <div class="radio">
                        <label>
                          <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                          <%= selectedProduct.custom_option[j].values[k].title %>
                        </label>
                        <img src="img/image1.png">
                      </div>
                 </div>    
                 </div>                
                 
         <%}%> 
         
                 

            <% } else { %>

            <div class="row"> 
                             <div class="col-lg-12">
                                  <div class="radio">
                                    <label>
                                      <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                                      it is not an array so it has to be displayed as text box.
                                    </label>
                                    <img src="img/image1.png">
                                  </div>
                             </div>
            </div>

             <% } %>                           
           <% } %>              
         <% } %>
       

       </div>   
      </div>

      <div class="col-lg-6">
        <div class="row top-buffer">
          <div class="col-lg-offset-6 col-lg-3 "> <span class="label label-default ">Base MRP:</span></div>
          <div class="col-lg-3"><span class="label label-default">590.00</span> </div>
        </div>
        <div class="row top-buffer">
          <div class="col-lg-offset-6 col-lg-3 "> <span class="label label-default ">Total Upcharge: </span></div>
          <div class="col-lg-3"><span class="label label-default">10000.00</span> </div>
        </div>
        <div class="row top-buffer">
        <div class=" col-lg-offset-6 col-lg-6"> <img src="img/image1.png"></div>       
        </div>
       <div class="row top-buffer">
        <div class=" col-lg-offset-6 col-lg-6"> <span class="label label-default">Styling Comment: </span> </div>       
        </div>
        <div class="row top-buffer">
        <div class=" col-lg-offset-6 col-lg-6"> <textarea> </textarea> </div>       
        </div>
       
       </div>

        </div>
      
      </div>
    <% } %>

    </div> 
  </div> 
 </div> 
</div>


  <script>
  $(document).ready(function(){  
  $('.nav').eq(0).children().eq(0).addClass('active')
  $('.tab-pane').eq(0).addClass('active');
  });
  </script>
