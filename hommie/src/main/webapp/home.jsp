<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
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

</head>

<body>
	<div class="container-xxl bg-dark p-4">
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


		<!-- Carousel Start -->
		<jsp:include page="carousel.jsp"></jsp:include>
		<!-- Carousel End -->


		<!-- Search Start -->
		<jsp:include page="search.jsp"></jsp:include>
		<!-- Search end -->

		<!-- About Start -->
		<jsp:include page="about.jsp"></jsp:include>
		<!-- About End -->


		<!-- Room List Start -->
		<div class="container-xxl py-5">
			<div class="container">

				<div class="text-center wow fadeInUp" data-wow-delay="0.1s">
					<h6 class="section-title text-center text-primary text-uppercase">Home
						Tour</h6>
					<h1 class="mb-5">
						Explore Our <a href="roomList">Rooms</a>
					</h1>
				</div>

				<div class="row g-4">
					<c:forEach var="room" items="${roomList}">
						<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
							<div class="room-item shadow rounded overflow-hidden">
								<div class="position-relative">
									<img class="img-fluid" style="height: 250px; width: 450px"
										src="${room.image1Url}" alt="image-room"> <small
										class="position-absolute start-0 top-100 translate-middle-y bg-primary text-white rounded py-1 px-3 ms-4">$${room.price}/Week</small>
								</div>
								<div class="p-4 mt-2" style="height: 350px">
									<div class="d-flex justify-content-between mb-4"
										style="height: 40px">
										<h5 class="mb-0">${room.title}</h5>
										<div class="ps-2"></div>
									</div>
									<div class="d-flex mb-3">
										<small class="border-end me-3 pe-3"><i
											class="fa fa-bed text-primary me-2"></i>${room.countBed} Bed</small>
										<small class="border-end me-3 pe-3"><i
											class="fa fa-bath text-primary me-2"></i> ${room.countBath}
											Bath</small> <small><i class="fa fa-wifi text-primary me-2"></i>Wifi</small>
									</div>
									<p class="text-body mb-3" style="height: 140px">${room.description}</p>
									<div class="d-flex justify-content-between">
										<a class="btn btn-sm btn-primary rounded py-2 px-4"
											href="room?roomId=${room.id}">View Detail</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<!-- Room List End -->

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
