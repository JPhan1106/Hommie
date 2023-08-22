<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Hommie - Where you find your best roommie</title>
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
<script src="lib/md5/md5.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/blueimp-md5/2.18.0/js/md5.min.js"></script>

<!-- Template Javascript -->
<script src="js/main.js"></script>

</head>

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
		<jsp:include page="header.jsp" >
		<jsp:param name="user" value="${sessionScope.user}"/>
		<jsp:param name="firstName" value="${sessionScope.user.firstName}"/>
		<jsp:param name="lastName" value="${sessionScope.user.lastName}"/>
		</jsp:include>
		<!-- Header End -->



		<!-- Page Header Start -->
		<div class="container-fluid page-header mb-5 p-0"
			style="background-image: url(https://i.pinimg.com/236x/09/80/52/09805251e8b42816ec721609d0e1c263.jpg);">
			<div class="container-fluid page-header-inner py-5">
				<div class="container text-center pb-5">
					<h1 class="display-3 text-white mb-3 animated slideInDown">Login</h1>
				</div>
			</div>
		</div>
		<!-- Page Header End -->


		<!-- Login Start -->
		<c:if test="${not empty loginAsLandlordMessage}">
			<p
				style="color: red; font-weight: bold; text-align: center; margin-top: 20px;">${loginAsLandlordMessage}</p>
		</c:if>

		<c:if test="${not empty errorMessage}">
			<p
				style="color: red; font-weight: bold; text-align: center; margin-top: 20px;">${errorMessage}</p>
		</c:if>


	<div class="container-xxl py-5 w-50">
		<div class="container">
			<div class="text-center wow fadeInUp" data-wow-delay="0.1s">
				<h1 class="mb-5">
					<span class="text-primary text-uppercase">Login</span> To Explore
					Our Services
				</h1>
			</div>
			<div class="center-form">
				<script>
					function encryptThenSubmitForm() {
					    var password = document.getElementById("password").value;
					    var encryptedPassword = md5(password);
					    document.getElementById("password").value = encryptedPassword;
					    var form = document.getElementById("loginForm");
						form.submit();
					}
				</script>

				<form action ="login" id="loginForm" method="post" style="align-content: center">
					<div class="col-md-6 w-100">
						<div class="form-floating">
							<input type="email" name="email" value="${param.email}"
								class="form-control" id="email" placeholder="email"> <label
								for="email"><i class="fa fa-user-circle m-2"
								aria-hidden="true"></i>Email</label>
						</div>
					</div>
					<br>
					<div class="col-md-6 w-100">
						<div class="form-floating">
							<input type="password" name="password" value="${param.password}"
								class="form-control" id="password" placeholder="password">
							<label for="password"><i class="fa fa-key m-2"
								aria-hidden="true"></i>Password</label>
						</div>
					</div>
					<br>
					<div class="col-md-6 w-100">
						<button class="btn btn-primary w-100 py-3" type="submit"
							onClick="encryptThenSubmitForm()">Login</button>
					</div>
				</form>

				<br>
				<h5>
					Don't have an account? Click <a href="register.jsp">
						here </a> to register
				</h5>
			</div>
			
			
		</div>
	</div>

	<!-- Login End -->


	<!-- Newsletter Start -->
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
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