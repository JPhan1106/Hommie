<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

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

<!-- Image template from W3.school-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
/* Add custom styles here */
.carousel {
	max-width: 500px; /* Adjust the maximum width as desired */
	margin: auto;
}

.carousel-inner .item img {
	max-height: 500px; /* Adjust the maximum height as desired */
	width: auto;
	margin: 0 auto;
}

.bold {
	font-weight: bold;
}
</style>

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

<!-- Image template from w3-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

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
		<jsp:include page="header.jsp">
			<jsp:param name="user" value="${sessionScope.user}" />
			<jsp:param name="firstName" value="${sessionScope.user.firstName}" />
			<jsp:param name="lastName" value="${sessionScope.user.lastName}" />
		</jsp:include>
		<!-- Header End -->


		<!-- Room Image Start -->

		<div class="container-fluid">
			<div class="row">
				<div
					class="col-md-6 d-flex align-items-center justify-content-center"
					style="background-color: rgb(240, 244, 248);" >
					<div id="myCarousel" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="1" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
							<li data-target="#myCarousel" data-slide-to="3"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<img class="img-fluid" src="${room.image1Url}"
									style="width: 500px;height:500px">>
							</div>

							<div class="item">
								<img class="img-fluid" src="${room.image2Url}"
									style="width: 500px;height:500px">>
							</div>

							<div class="item">
								<img class="img-fluid" src="${room.image3Url}"
									style="width: 500px;height:500px">>
							</div>

						</div>
						<!-- Left and right controls -->
						<a class="left carousel-control" href="#myCarousel"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="right carousel-control" href="#myCarousel"
							data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
				</div>
				<div class="col-sm-6" style="background-color: rgb(240, 244, 248);">
					<div class="d-flex justify-content-between mb-3" style="margin-top:30px;">
						<h3 class="mb-0">${room.address}
							<br>${room.state} ${room.postcode}
						</h3>

						<div class="ps-2"></div>
					</div>
					<div class="d-flex mb-3">
						<small class="border-end me-3 pe-3"><i
							class="fa fa-bed text-primary me-2"></i>${room.countBed} Bed</small> <small
							class="border-end me-3 pe-3"><i
							class="fa fa-bath text-primary me-2"></i>${room.countBath} Bath</small> <small><i
							class="fa fa-wifi text-primary me-2"></i>Wifi</small>
					</div>
					<div>
						<h4>
							<strong>$${room.price} Weekly</strong>
						</h4>
						<p>
							<strong>Bond </strong>$${room.bond}
						</p>
						<p>
							<strong>Available </strong>${room.availableDate}
						</p>
					</div>
					<div data-wow-delay="0.1s">
						<iframe class="position-relative rounded w-100 h-100"
							src="https://www.google.com/maps/embed/v1/place?key=AIzaSyDme-55i5yxxsYP3sd3Ev-E82qi27MQc8s
							&q=${room.lat}, ${room.lng}"
							frameborder="0" style="min-height: 350px; border: 0;"
							allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
					</div>
				</div>
			</div>
		</div>

		<!-- Room Image End -->


		<!-- Booking Start -->
		<div class="container-xxl py-5">
			<div class="container">
				<div class="text-center wow fadeInUp pb-5" data-wow-delay="0.1s">
					<h1 class="mb-5">
						Get In Touch, <span class="text-primary text-uppercase">Hommie</span>
					</h1>
				</div>
				<div class="row g-5 bold">
					<div class="col-lg-6">
						<div class="row g-3">
							<h3>${room.title}</h3>
							<p>${room.description}</p>
							<h3>Property features</h3>
							<p>Room size: ${room.squareArea} m2</p>
							<p>Suitable for ${room.capacity} person(s)</p>
						</div>
					</div>
					<div class="col-lg-6" style="margin-bottom: 150px;">
						<div class="wow fadeInUp" data-wow-delay="0.2s">
							<c:if test="${not empty errorMessage}">
								<c:forEach var="error" items="${errorMessage}">
									<p
										style="color: red; font-weight: bold; text-align: center; margin-top: 20px;">${error}</p>
								</c:forEach>
							</c:if>
							<form action="inspection" method="post">
								<!-- Use method="post" to send form data securely -->
								<input type="hidden" name="roomId" value="${room.id}">
								<!-- Hidden input to pass roomId to the servlet -->
								<div class="row g-3">
									<h3 class="text-center bold">
										Book an inspection/ <br> Send a private message to
										Landlord
									</h3>
									<div class="col-12">
										<div class="form-floating">
											<select class="form-select" id="select3" name="enquiryType">
												<option value="Length of lease">Length of lease</option>
												<option value="Arrange private inspection">Arrange
													private inspection</option>
												<option value="Rental application">Rental
													application</option>
												<option value="Other">Other</option>
											</select> <label for="select3">What's your enquiry about?</label>
										</div>
									</div>
									<div class="col-12">
										<div class="form-floating">
											<textarea class="form-control" placeholder="Special Request"
												name="message" id="message" style="height: 100px"></textarea>
											<label for="message">Message (maximum 300 words)</label>

										</div>
									</div>
									<div class="col-12">
										<button class="btn btn-primary w-100 py-3" type="submit">Send</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Booking End -->

		<!-- Footer Start -->
		<jsp:include page="footer.jsp"></jsp:include>
		<!-- Footer End -->