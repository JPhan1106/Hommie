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

.button-container {
	display: flex;
	justify-content: center; /* Center the buttons horizontally */
}

.button-container a {
	margin: 10px;
	margin-bottom: 100px;
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

<style>
.update-button {
	display: inline-block;
	padding: 12px 24px;
	font-size: 18px;
	background-color: orange;
	color: white;
	text-decoration: none;
	border: none;
	border-radius: 4px;
	margin-right: 10px;
}
</style>

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
		<jsp:include page="landlord-header.jsp">
			<jsp:param name="landlordId" value="${sessionScope.landlordId}" />
			<jsp:param name="firstName" value="${sessionScope.user.firstName}" />
			<jsp:param name="lastName" value="${sessionScope.user.lastName}" />
		</jsp:include>
		<!-- Header End -->

		<!-- Room Image Start -->
		<div class="container-fluid">
			<div class="row">
				<div
					class="col-md-6 d-flex align-items-center justify-content-center"
					style="background-color: rgb(240, 244, 248);">
					<div id="myCarousel" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<img class="img-fluid" src="${availableRoom.image1Url}"
									style="width: 500px; height: 500px">>
							</div>

							<div class="item">
								<img class="img-fluid" src="${availableRoom.image2Url}"
									style="width: 500px; height: 500px">>
							</div>

							<div class="item">
								<img class="img-fluid" src="${availableRoom.image3Url}"
									style="width: 500px; height: 500px">>
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
				<div class="col-md-6" style="background-color: rgb(240, 244, 248);">
					<c:if test="${not empty updateRoomSuccessfulMessage}">
						<p
							style="color: red; font-weight: bold; text-align: center; margin-top: 20px;">${updateRoomSuccessfulMessage}</p>
					</c:if>
					<div class="d-flex justify-content-between mb-3"
						style="margin-top: 30px;">
						<h3 class="mb-0">${availableRoom.address}
							<br>${availableRoom.state} ${availableRoom.postcode}
						</h3>

						<div class="ps-2"></div>
					</div>
					<div class="d-flex mb-3">
						<small class="border-end me-3 pe-3"><i
							class="fa fa-bed text-primary me-2"></i>${availableRoom.countBed}
							Bed</small> <small class="border-end me-3 pe-3"><i
							class="fa fa-bath text-primary me-2"></i>${availableRoom.countBath}
							Bath</small> <small><i class="fa fa-wifi text-primary me-2"></i>Wifi</small>
					</div>
					<div>
						<h4>
							<strong>$${availableRoom.price} Weekly</strong>
						</h4>
						<p>
							<strong>Bond </strong>$${availableRoom.bond}
						</p>
						<p>
							<strong>Available </strong>${availableRoom.availableDate}
						</p>
					</div>
					<div data-wow-delay="0.1s">
						<iframe class="position-relative rounded w-100 h-100"
							src="https://www.google.com/maps/embed/v1/place?key=AIzaSyDme-55i5yxxsYP3sd3Ev-E82qi27MQc8s
							&q=${availableRoom.lat}, ${availableRoom.lng}"
							frameborder="0" style="min-height: 350px; border: 0;"
							allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="row g-3" style="margin: 30px; margin-left: 50px;">
						<h3>${availableRoom.title}</h3>
						<p>${availableRoom.description}</p>
						<h3>Property features</h3>
						<p>Room size: ${availableRoom.squareArea} m2</p>
						<p>Suitable for ${availableRoom.capacity} person(s)</p>
					</div>
				</div>
			</div>
		</div>

		<!-- Room Image End -->

		<!-- Buttons For Available Room Start -->
		<div class="container-xxl py-5" style="margin-bottom: 100px;">
			<div class="container">
				<div class="button-container text-center wow fadeInUp row"
					data-wow-delay="0.1s">
					<form action="landlordRoom" id="updateRoom"
						class="col-md-3" style="margin-bottom: 8px;">
						<input type="hidden" name="TYPE" value="UPDATE"> <input
							type="hidden" name="roomId" value="${availableRoom.id}">
						<button type="submit" class="update-button">Update this
							room</button>
					</form>

					<form action="landlordInspectionView" method="post" id="inspection" class="col-md-3" style="margin-bottom: 8px;">
						<input
							type="hidden" name="roomId" value="${availableRoom.id}">
						<button type="submit" class="update-button">Check
						inspection history</button>
					</form>
					
					<script>
						function confirmMakeRoomOccupied(event) {
							const confirmation = window
									.confirm("Are you sure you want to make this room occupied?");
							var form = document
									.getElementById("confirmMakeRoomOccupied");
							if (confirmation) {
								form.submit();
							} else {
								event.preventDefault();
							}
						}
					</script>
					<form action="landlordRoom" id="confirmMakeRoomOccupied"
						 class="col-md-3" style="margin-bottom: 8px;">
						<input type="hidden" name="TYPE" value="MAKE_OCCUPIED"> <input
							type="hidden" name="roomId" value="${availableRoom.id}">
						<button type="submit" onClick="confirmMakeRoomOccupied()"
							class="update-button">Make this room occupied</button>
					</form>

					<script>
						function confirmDeleteRoom(event) {
							const confirmation = window
									.confirm("Are you sure you want to delete this room?");
							var form = document
									.getElementById("confirmDeleteRoom");
							if (confirmation) {
								form.submit();
							} else {
								event.preventDefault();
							}
						}
					</script>
					<form action="landlordRoom" id="confirmDeleteRoom"
						 class="col-md-3" style="margin-bottom: 8px;">
						<input type="hidden" name="TYPE" value="DELETE"> <input
							type="hidden" name="roomId" value="${availableRoom.id}">
						<button type="submit" onClick="confirmDeleteRoom()"
							class="update-button">Delete this room</button>
					</form>

				</div>
			</div>
		</div>

		<!-- Buttons For Available Room End -->


		<!-- Footer Start -->
		<jsp:include page="footer.jsp"></jsp:include>
		<!-- Footer End -->