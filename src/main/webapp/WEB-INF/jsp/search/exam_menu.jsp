<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   isELIgnored ="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default" role="navigation">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#">Exams</a>
  </div>

  <!-- Collect the nav links, forms, and other content for toggling -->
  <div id="dialog" class="collapse navbar-collapse navbar-ex1-collapse">
    <ul class="nav navbar-nav">
      <li class="dropdown">
        <a  id="ocja-test" href="#" class="dropdown-toggle" data-toggle="dropdown">OCJA 1.6<b class="caret"></b></a>
        <ul  class="dropdown-menu">
          <li><a  href="#">TEST 1</a></li>
          <li><a  href="#">TEST 2</a></li>
          <li><a href="#">TEST 3</a></li>
          <li><a href="#">TEST 4</a></li>
          <li><a href="#">TEST 5</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a  href="#" class="dropdown-toggle" data-toggle="dropdown">OCJP 1.6 <b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="${pageContext.request.contextPath}/ExamController?testNo=11">TEST 1</a></li>
          <li><a href="#">TEST 2</a></li>
          <li><a href="#">TEST 3</a></li>
          <li><a href="#">TEST 4</a></li>
          <li><a href="#">TEST 5</a></li>
        </ul>
      </li>
       <li class="dropdown">
        <a  id="ocewcd-test" href="#" class="dropdown-toggle" data-toggle="dropdown">OCEWCD 6  <b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#">TEST 1</a></li>
          <li><a href="#">TEST 2</a></li>
          <li><a href="#">TEST 3</a></li>
          <li><a href="#">TEST 4</a></li>
          <li><a href="#">TEST 5</a></li>
        </ul>
      </li>
       <li class="dropdown">
        <a  id="ocejpa-test" href="#" class="dropdown-toggle" data-toggle="dropdown">OCEJPA 6 <b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#">TEST 1</a></li>
          <li><a href="#">TEST 2</a></li>
          <li><a href="#">TEST 3</a></li>
          <li><a href="#">TEST 4</a></li>
          <li><a href="#">TEST 5</a></li>
        </ul>
      </li>
       <li class="dropdown">
        <a  id="ocewsd-test" href="#" class="dropdown-toggle" data-toggle="dropdown">OCEWSD 6 <b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#">TEST 1</a></li>
          <li><a href="#">TEST 2</a></li>
          <li><a href="#">TEST 3</a></li>
          <li><a href="#">TEST 4</a></li>
          <li><a href="#">TEST 5</a></li>
        </ul>
        
      </li>
       <li class="dropdown">
        <a  id="ocebcd-test" href="#" class="dropdown-toggle" data-toggle="dropdown">OCEBCD 6<b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#">TEST 1</a></li>
          <li><a href="#">TEST 2</a></li>
          <li><a href="#">TEST 3</a></li>
          <li><a href="#">TEST 4</a></li>
          <li><a href="#">TEST 5</a></li>
        </ul>
      </li>
    </ul>
    
  <form class="navbar-form navbar-right" role="search" action="SolrSearchController">
      <div class="form-group">
        <input type="text" name="text_search" class="form-control" placeholder="Search">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
  </div><!-- /.navbar-collapse -->
</nav>