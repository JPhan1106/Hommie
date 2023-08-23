<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

</head>

<style>
.image-upload-container {
	display: flex;
	align-items: center;
}

.image-preview {
	margin-right: 10px;
}
</style>

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
			style="background-image: url(https://i.pinimg.com/564x/b0/6b/59/b06b59ae4ce0b72518f5b010100ff46e.jpg);">
			<div class="container-fluid page-header-inner py-5">
				<div class="container text-center pb-5">
					<h1 class="display-3 text-white mb-3 animated slideInDown">Landlord</h1>
				</div>
			</div>
		</div>

		<!-- Page Header End -->


		<c:if test="${not empty updateRoomUnsuccessfulMessage}">
			<p
				style="color: red; font-weight: bold; text-align: center; margin-top: 20px;">${updateRoomUnsuccessfulMessage}</p>
		</c:if>

		<!-- Listing Start -->
		<div class="container-xxl py-5" style="margin-bottom: 50px">
			<div class="container w-50">
				<div class="text-center wow fadeInUp" data-wow-delay="0.1s">
					<h1 class="mb-5">
						<span class="text-primary text-uppercase">Update your
							vacant room</span>
				</div>
				<div class="center-form">
					<form action="updateListing" id="listingForm" method="post"
						enctype="multipart/form-data" style="align-content: center">
						<!-- Hidden input field for room.id -->
						<input type="hidden" id="id" name="id" value="${room.id}">

						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="text" class="form-control" id="title" name="title"
									value="${room.title}" placeholder="Tittle"> <label
									for="title"><i class="fa fa-home" aria-hidden="true"></i>
									Title</label>
							</div>
						</div>
						<br>
						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="text" class="form-control" id="squareArea"
									name="squareArea" value="${room.squareArea}"
									placeholder="squareArea"> <label for="squareArea"><i
									class="fa fa-superscript" aria-hidden="true"></i> Room Size
									(m²)</label>
							</div>
						</div>
						<br>
						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="text" class="form-control" id="capacity"
									name="capacity" value="${room.capacity}" placeholder="capacity">
								<label for="capacity"><i class="fa fa-male"
									aria-hidden="true"></i> Number of people</label>
							</div>
						</div>
						<br>
						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="number" class="form-control" id="price"
									name="price" value="${room.price}" placeholder="price">
								<label for="price"><i class="fa fa-credit-card"
									aria-hidden="true"></i> Weekly Price</label>
							</div>
						</div>
						<br>
						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="date" class="form-control" id="Available Date"
									name="availableDate" value="${room.availableDate}"
									placeholder="Available Date"> <label
									for="availableDate"><i class="fa fa-calendar"
									aria-hidden="true"></i> Available Date</label>
							</div>
						</div>
						<br>
						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="number" class="form-control" id="bond" name="bond"
									value="${room.bond}" placeholder="bond"> <label
									for="bond"><i class="fa fa-university"
									aria-hidden="true"></i> Bond</label>
							</div>
						</div>
						<br>
						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="number" class="form-control" id="countBed"
									name="countBed" value="${room.countBed}" placeholder="countBed">
								<label for="countBed"><i class="fa fa-bed"
									aria-hidden="true"></i> Number of Bedrooms</label>
							</div>
						</div>
						<br>
						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="number" class="form-control" id="countBed"
									name="countBath" value="${room.countBath}"
									placeholder="countBath"> <label for="countBath"><i
									class="fa fa-bath" aria-hidden="true"></i> Number of Bathrooms</label>
							</div>
						</div>
						<br>
						<div class="col-12">
							<div>
								<label for="message"><i class="fa fa-pencil"
									aria-hidden="true"></i> Description</label>
								<textarea class="form-control" id="message" name="description"
									style="height: 100px"> ${room.description}</textarea>
							</div>
						</div>
						<br>
						<div class="col-12">
							<div>
								<p>
									<i class="fa fa-file-image-o" aria-hidden="true"></i> Update
									photos of your listing
								</p>

								<div class="form-floating image-upload-container"
									style="margin-bottom: 20px;">
									<div class="image-preview">
										<img id="previewImage" src="${room.image1Url}" alt="Image 1"
											width="100" height="100">
									</div>
									<input type="file" class="form-control" id="image1"
										name="image1" accept="image/*"> <input type="hidden"
										name="initialImage1" value="${room.image1Url}">
								</div>

								<div class="form-floating image-upload-container"
									style="margin-bottom: 20px;">
									<div class="image-preview">
										<img id="previewImage" src="${room.image2Url}" alt="Image 2"
											width="100" height="100">
									</div>
									<input type="file" class="form-control" id="image1"
										name="image2" accept="image/*"> <input type="hidden"
										name="initialImage2" value="${room.image2Url}">
								</div>


								<div class="form-floating image-upload-container"
									style="margin-bottom: 20px;">
									<div class="image-preview">
										<img id="previewImage" src="${room.image3Url}" alt="Image 3"
											width="100" height="100">
									</div>
									<input type="file" class="form-control" id="image1"
										name="image3" accept="image/*"> <input type="hidden"
										name="initialImage3" value="${room.image3Url}">
								</div>

								<div class="form-floating image-upload-container"
									style="margin-bottom: 20px;">
									<div class="image-preview">
										<img id="previewImage" src="${room.image4Url}" alt="Image 4"
											width="100" height="100">
									</div>
									<input type="file" class="form-control" id="image1"
										name="image4" accept="image/*"> <input type="hidden"
										name="initialImage4" value="${room.image4Url}">
								</div>
							</div>
						</div>

						<br>
						<div class="col-md-6 w-100 pt-4" style="margin-bottom: 50px">
							<button class="btn btn-primary w-100 py-3" type="submit">Update
								Your Room</button>
						</div>
					</form>
					<div class="col-12" style="margin: 50px">
						<p style="color: orange; font-weight: bold ; ">
							*Due to our policies, please contact us if you wish you update your address.
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Listing End -->


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