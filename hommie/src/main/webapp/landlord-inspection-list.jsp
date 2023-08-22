<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hommie - Find roomate App</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&family=Montserrat:wght@400;500;600;700&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="lib/animate/animate.min.css" rel="stylesheet">
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">

<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="lib/wow/wow.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/waypoints/waypoints.min.js"></script>
<script src="lib/counterup/counterup.min.js"></script>
<script src="lib/owlcarousel/owl.carousel.min.js"></script>
<script src="lib/tempusdominus/js/moment.min.js"></script>
<script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
<script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

<!-- Template Javascript -->
<script src="js/main.js"></script>

<style>
.container1 {
	/* Add your custom styles for the inner container */
	/* For example: */
	background-color: #f7f7f7;
	padding: 20px;
	border-radius: 10px;
	border: 1px solid #ccc;
	padding: 20px;
	margin-bottom: 20px;
}

.text-primary {
	/* Add your custom styles for the primary text */
	/* For example: */
	color: #007bff;
}

.center-form1 {
	/* Add your custom styles for the form alignment */
	/* For example: */
	display: flex;
	flex-direction: column;
	align-items: right;
}

.contact-info {
	/* Add your custom styles for the contact info section */
	/* For example: */
	margin-bottom: 20px;
}

.contact-item1 {
	/* Add your custom styles for each contact item */
	/* For example: */
	display: flex;
	align-items: right;
	margin-bottom: 10px;
}

.contact-item1 i {
	/* Add your custom styles for the contact item icons */
	/* For example: */
	margin-right: 10px;
}
</style>
</head>



<body>
<body>
	<div class="container-xxl bg-white p-0">
		<!-- Spinner Start -->
		<div id="spinner"
			class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
			<div class="spinner-border text-primary"
				style="width: 3rem; height: 3rem;" role="status">
				<span class="sr-only">Loading...</span>
			</div>
		</div>
		<!-- Spinner End -->

		<!-- Header Start -->
		<jsp:include page="landlord-header.jsp" >
		<jsp:param name="landlordId" value="${sessionScope.landlordId}"/>
		<jsp:param name="firstName" value="${sessionScope.user.firstName}"/>
		<jsp:param name="lastName" value="${sessionScope.user.lastName}"/>
		</jsp:include>
		<!-- Header End -->


		<!-- Page Header Start -->
		<div class="container-fluid page-header mb-5 p-0"
			style="background-image: url(img/carousel-1.jpeg);">
			<div class="container-fluid page-header-inner py-5">
				<div class="container text-center pb-5">
					<h1 class="display-3 text-white mb-3 animated slideInDown">${sessionScope.user.firstName}'s
						rommie</h1>
					<nav aria-label="breadcrumb"></nav>
				</div>
			</div>
		</div>
		<!-- Page Header End -->

		<div class="container-xxl py-5 w-50">
			<c:forEach var="inspection" items="${list}">
				<div class="container1">
					<div class="text-center wow fadeInUp" data-wow-delay="0.1s">
						<h1 class="mb-5 text-center">
							<span class="text-primary text-uppercase">${inspection.studentFirstName}
								${inspection.studentLastName}</span>
						</h1>
					</div>
					<div class="center-form1">
						<div class="contact-info1">
							<div class="contact-item1">
								<i class="fa fa-user-circle" aria-hidden="true"></i> <span
									class="text-right">${inspection.studentPhoneNumber}</span>
							</div>
							<div class="contact-item1">
								<i class="fa fa-phone" aria-hidden="true"></i> <span
									class="text-right">${inspection.studentEmail}</span>
							</div>
							<div class="contact-item1">
								<i class="fa fa-clock" aria-hidden="true"></i> <span
									class="text-right">${inspection.requestTime}</span>
							</div>
							<div class="contact-item1">
								<i class="fa fa-envelope" aria-hidden="true"></i> <span
									class="text-right">${inspection.message}</span>
							</div>
						</div>
					</div>
					<br>
				</div>
			</c:forEach>
		</div>


		<!-- Newsletter Start -->
		<br> <br> <br> <br>
		<!-- Newsletter Start -->


		<!-- Footer Start -->
<jsp:include page="footer.jsp"></jsp:include>
	<!-- Footer End -->


		<!-- Back to Top -->
		<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i
			class="bi bi-arrow-up"></i></a>
	</div>


</body>

</html>

