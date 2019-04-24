<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Payment</title>
    <link href="css/styles.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://pay.sandbox.datatrans.com/upp/payment/js/datatrans-2.0.0.min.js"></script>
</head>
<body>
	
	<h2>Amount:</h2>
	
	<form id="paymentForm"
      data-merchant-id="${merchantID}"
      data-amount="${amount}"
      data-currency="CHF"
      data-refno="${refno}"
      data-sign="${sign}">
    <button id="paymentButton" type="button" class="btn">Pay CHF ${displayAmount}</button>
	</form>
    <jsp:include page="footer.jsp" />
    <script type="text/javascript">
	    $("#paymentButton").click(function () {
	        Datatrans.startPayment({'form': '#paymentForm'});
	    });
	</script>
</body>
</html>