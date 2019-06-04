 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       <%@ include file = "adheader.html" %>
  <!--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >

<center>
<div class="container "  >
  
  <form action=" /car-service/add" method="post">
    <div class="form-group">
      <label for="email">Center Name:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter service center name"  name="centerName ">
    </div>
     <br/> <br/>
     
   
    <div class="form-group">
     <label for="email">Type:</label>
      <label><input type="checkbox" value="Washing" name="type">Washing  <input type="email" class="form-control" id="email"   name="centerName "></label>
    </div>
     <br/> <br/>
    <div class="form-group">
      <label><input type="checkbox" value="Oiling" name="type">Oiling  <input type="email" class="form-control" id="email"   name="centerName "></label>
    </div>
     <br/> <br/>
    <div class="form-group ">
      <label><input type="checkbox" value="Repairing" name="type" >Repairing  <input type="email" class="form-control" id="email"    name="centerName "></label>
    </div>
     <br/> <br/>
    <div class="form-group">
      <label for="pwd"> Availablity:</label>
      <input type="date" class="form-control" id="pwd" placeholder="Enter availablity" name="trip-start">
    </div>
     <br/> <br/>
     <div class="form-group">
      <label for="email">Rating:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter rating" name="rating">
    </div>
     <br/> <br/>
    <button type="submit" class="btn btn-default" name="ADD">Submit</button>
     <br/> <br/>
  </form>
</div>
</center>
</body>
</html>  -->

<!DOCTYPE html>
<html lang="en">

<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container "  >
 <div class="row"> 
 <div class="col-sm-4"></div>
 <div class="col-sm-4">
  <form action=" ">
    <div class="form-group">
      <label for="email">Center Name:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter service center name"  name="centerName " style="width:317px">
    </div>
   
  <b> Type:</b>   <div class="checkbox">
      <label><input type="checkbox" value="Washing" name="type">Washing  <input type="email" class="form-control" id="email"   name="centerName " style="width:300px"></label>
    </div>
    <div class="checkbox">
      <label><input type="checkbox" value="Oiling" name="type">Oiling  <input type="email" class="form-control" id="email"   name="centerName " style="width:300px"></label>
    </div>
    <div class="checkbox  ">
      <label><input type="checkbox" value="Repairing" name="type" >Repairing  <input type="email" class="form-control" id="email"    name="centerName " style="width:300px"></label>
    </div>
    <div class="form-group">
      <label for="pwd"> Availablity:</label>
      <input type="date" class="form-control" id="pwd" placeholder="Enter availablity" name="trip-start" style="width:317px">
    </div>
     <div class="form-group">
      <label for="email">Rating:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter rating" name="rating" style="width:317px">
    </div>
    
    <button type="submit" class="btn btn-default" name="ADD">Submit</button>
    
    <a href="<c:url value='/viewRequests'/>">View Requests</a>
  </form>
  </div>
 <div class="col-sm-4"></div>
  </div>
  
</div>

</body>
</html>



