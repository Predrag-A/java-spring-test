<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User ${user.id}</title>
</head>
<body>
    <h2>${user.name}</h2>       
    <p>${user.id} | 
 		<span>
 			<c:if test="${user.alive}">Alive</c:if>
 			<c:if test="${!user.alive}">Dead</c:if>
 		</span>
    </p>
    <a href="/SpringBootDemo/users">Back</a>
    <jsp:include page="footer.jsp" />
</body>
</html>