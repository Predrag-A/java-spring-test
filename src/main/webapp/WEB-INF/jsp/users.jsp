<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
	<fmt:setLocale value="${locale}"/>	
	<fmt:setBundle basename="messages" var="lang"/>		
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://pay.sandbox.datatrans.com/upp/payment/js/datatrans-2.0.0.min.js"></script>
</head>
<body>
    <h2><fmt:message key="users" bundle="${lang}"/><br/></h2>       
    <ul>
	    <c:forEach items="${userList}" var="user"> 
		  <li>
		    ${user.id}  <a href="users/user?id=${user.id-1}">${user.name}</a>
		  </li>
		</c:forEach>
	</ul>
	<h1><fmt:message key="add" bundle="${lang}"/></h1>
	<form action="/users" method="post">
	  	Name:<br>
	  	<input type="text" name="name">
	 	<br>
	  	Alive:<br>
	  	<input type="radio" name="alive" value="yes" checked> Yes<br>
 		<input type="radio" name="alive" value="no"> No
  		<input type="submit" value="Submit">
	</form> 
	
	<form action="/payment" method="post">
	  	Amount:<br>
	  	<input type='number' step='0.01' value='0.00' placeholder='0.00' name="amount"/>
  		<input type="submit" value="Pay amount">
	</form>
		
    <jsp:include page="footer.jsp" />
    <script type="text/javascript">
	    $("#paymentButton").click(function () {
	        Datatrans.startPayment({'form': '#paymentForm'});
	    });
	</script>
</body>
</html>