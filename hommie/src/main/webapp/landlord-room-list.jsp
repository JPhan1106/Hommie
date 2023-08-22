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
		<jsp:include page="landlord-header.jsp">
			<jsp:param name="landlordId" value="${sessionScope.landlordId}" />
			<jsp:param name="firstName" value="${sessionScope.user.firstName}" />
			<jsp:param name="lastName" value="${sessionScope.user.lastName}" />
		</jsp:include>
		<!-- Header End -->


		<!-- Page Header Start -->
		<div class="container-fluid page-header mb-5 p-0"
			style="background-image: url(img/carousel-1.jpeg);">
			<div class="container-fluid page-header-inner py-5">
				<div class="container text-center pb-5">
					<h1 class="display-3 text-white mb-3 animated slideInDown">${sessionScope.user.firstName}'s
						listings</h1>
					<a href="landlordRoomList?TYPE=AVAILABLE&landlordId"
						class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft">Available</a>
					<a href="landlordRoomList?TYPE=RENTED&landlordId"
						class="btn btn-light py-md-3 px-md-5 animated slideInRight">Rented</a>
					<nav aria-label="breadcrumb"></nav>
				</div>
			</div>
		</div>
		<!-- Page Header End -->

		<c:if test="${not empty createRoomSuccessfulMessage}">
			<p
				style="color: red; font-weight: bold; text-align: center; margin-top: 20px;">${createRoomSuccessfulMessage}</p>
		</c:if>

		<!-- Room List Start -->
		<div class="container-xxl py-5">
			<c:if test="${not empty availableRoomList}">
				<div class="container">
					<div class="text-center wow fadeInUp" data-wow-delay="0.1s">
						<h1 class="mb-5">
							<span class="text-primary text-uppercase">Available </span>Rooms
						</h1>
					</div>
					<div class="row g-4">
						<c:forEach var="room" items="${availableRoomList}">
							<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
								<div class="room-item shadow rounded overflow-hidden">
									<div class="position-relative">
										<img class="img-fluid" style="height: 260px; width: 450px"
											src="${room.image1Url}" alt="image-room"> <small
											class="position-absolute start-0 top-100 translate-middle-y bg-primary text-white rounded py-1 px-3 ms-4">$${room.price}/Week</small>
									</div>
									<div class="p-4 mt-2">
										<div class="d-flex justify-content-between mb-3"
											style="height: 40px">
											<h5 class="mb-0">${room.title}</h5>
											<div class="ps-2"></div>
										</div>
										<div class="d-flex mb-3">
											<small class="border-end me-3 pe-3"><i
												class="fa fa-bed text-primary me-2"></i>${room.countBed} Bed</small>
											<small class="border-end me-3 pe-3"><i
												class="fa fa-bath text-primary me-2"></i>${room.countBath}
												Bath</small> <small><i class="fa fa-wifi text-primary me-2"></i>Wifi</small>
										</div>
										<p class="text-body mb-3" style="height: 200px;">${room.description}</p>
										<div class="d-flex justify-content-between">
											<a class="btn btn-sm btn-primary rounded py-2 px-4"
												href="landlordRoom?TYPE=AVAILABLE&roomId=${room.id}">View
												& Update Details</a>

										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
			</c:if>
			<br> <br> <br>
			<div class="container">
				<c:if test="${not empty rentedRoomList}">
					<div class="text-center wow fadeInUp" data-wow-delay="0.1s">
						<h1 class="mb-5">
							<span class="text-primary text-uppercase">Rented </span>Rooms
						</h1>
					</div>
					<div class="row g-4">
						<c:forEach var="room" items="${rentedRoomList}">
							<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
								<div class="room-item shadow rounded overflow-hidden">
									<div class="position-relative">
										<img class="img-fluid" style="height: 260px; width: 450px"
											src="${room.image1Url}" alt="image-room"> <small
											class="position-absolute start-0 top-100 translate-middle-y bg-primary text-white rounded py-1 px-3 ms-4">$${room.price}/Week</small>
									</div>
									<div class="p-4 mt-2">
										<div class="d-flex justify-content-between mb-3"
											style="height: 40px">
											<h5 class="mb-0">${room.title}</h5>
											<div class="ps-2"></div>
										</div>
										<div class="d-flex mb-3">
											<small class="border-end me-3 pe-3"><i
												class="fa fa-bed text-primary me-2"></i>${room.countBed} Bed</small>
											<small class="border-end me-3 pe-3"><i
												class="fa fa-bath text-primary me-2"></i>${room.countBath}
												Bath</small> <small><i class="fa fa-wifi text-primary me-2"></i>Wifi</small>
										</div>
										<p class="text-body mb-3" style="height: 200px;">${room.description}</p>
										<div class="d-flex justify-content-between">
											<a class="btn btn-sm btn-primary rounded py-2 px-4"
												href="landlordRoom?TYPE=RENTED&roomId=${room.id}">View
												Details</a>

										</div>
									</div>
								</div>
							</div>
						</c:forEach>
				</c:if>
			</div>

		</div>
	</div>
	<!-- Create listing Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center wow fadeInUp" data-wow-delay="0.1s">
				<h1 class="mb-5">
					Click <a href="landlord-listing.jsp"
						class="text-primary text-uppercase">here</a> to create new listing
				</h1>
			</div>
		</div>
		<!--Create listing End-->

		<!-- Testimonial Start -->
		<jsp:include page="testimonial.jsp"></jsp:include>
		<!-- Testimonial End -->

		<!-- Footer Start -->
		<jsp:include page="footer.jsp"></jsp:include>
		<!-- Footer End -->

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
</body>

</html>

