<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ include file = "header.html" %>
<!DOCTYPE html>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  

<title>Insert title here</title>
<style>

body{

color:white;
background-image:url("images/back.jpg") ;
opacity:5;
	background-repeat: no-repeat;
	background-size:cover;
	background-position:center;
}
img{
opacity:0.5;
filter:alpha(opacity=50);}

</style>
 <script type="text/javascript">

 
 $(document).ready(function() {        
     $(".chkEdit").click(function(event) {
         var total = 0;
         $(".chkEdit:checked").each(function() {
             total += parseInt($(this).val());
         });
         
         if (total == 0) {
             $('#amount').val('');
         } else {                
             $('#amount').val(total);
         }
     });
 });    


 $(document).on('change', '.chkView', function() {
     $(this).closest('tr').find('.chkEdit').prop('disabled', !this.checked);
 })

 </script>



  
</head>
<body>


<div class="container-fluid">

 
 <table class="table table-bordered">
    <thead>
      <tr>
<th></th>
<th>SERVICE ID</th>
<th   width="500px"  align="center">CENTER NAME</th>
<th  width="300px" align="center">WASHING COST</th>
<th   width="300px"  align="center">OILING COST</th>
<th   width="300px" align="center">REPAIRING COST</th>
<th    align="center">AVAILABILITY</th>
<th   align="center">RATING</th>
<th   align="center">START DATE</th>
<th    align="center">END DATE</th>



</tr>
 
    </thead>
    <tbody>
    <c:forEach items="${serList}" var="ser">
    
      <tr>

<td><input type="radio" class="chkView"/>Request</td>
<td   align="center">${ser.serviceId } </td>
<td   align="center">${ser.centerName}</td>
<td  align="center">${ser.cost}&nbsp;&nbsp;&nbsp;<input type="checkbox" class="chkEdit"  name="type" value="${ser.cost}"  onClick="test(this);" disabled /></td>
<td   align="center">${ser.cost1}&nbsp;&nbsp;&nbsp;<input type="checkbox" name="type" class="chkEdit" value="${ser.cost1}"  onClick="test(this);" disabled/></td>
<td   align="center">${ser.cost2}&nbsp;&nbsp;&nbsp;<input type="checkbox" name="type" class="chkEdit" value="${ser.cost2}"  onClick="test(this);" disabled/></td>

<td  align="center">${ser.availability}</td>
<td   align="center">${ser.rating}</td>
<td> <input type="date" id="start" name="start"
       value="2018-07-22"
       min="2019-01-01" max="2020-12-31"></td>
<td><input type="date" id="end" name="end"
       value="2018-07-22"
       min="2019-01-01" max="2020-12-31"></td>
       <td></td><th>AMOUNT</th>
<td><input type="text" name="amount" id="amount" /></td>
<td></td>
<td> <a href="<c:url value='/status/${ser.serviceId}'/>">GENERATE REQUEST</a></td>
<td></td>
</tr>
</c:forEach>
</tbody>
</table>

 
 
</div>
</body>
</html>