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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--Google Maps javaScript API-->
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDme-55i5yxxsYP3sd3Ev-E82qi27MQc8s&libraries=places&callback=initMap"
	async defer></script>


<script>
	function initMap() {
		var map = new google.maps.Map(document.getElementById('map'), {
			center : {
				lat : -33.8688,
				lng : 151.2195
			},
			zoom : 13
		});
		var input = document.getElementById('address');
		map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

		var autocomplete = new google.maps.places.Autocomplete(input);
		autocomplete.bindTo('bounds', map);

		var infowindow = new google.maps.InfoWindow();
		var marker = new google.maps.Marker({
			map : map,
			anchorPoint : new google.maps.Point(0, -29)
		});

		autocomplete
				.addListener(
						'place_changed',
						function() {
							infowindow.close();
							marker.setVisible(false);
							var place = autocomplete.getPlace();
							if (!place.geometry) {
								window
										.alert("Autocomplete's returned place contains no geometry");
								return;
							}

							// If the place has a geometry, then present it on a map.
							if (place.geometry.viewport) {
								map.fitBounds(place.geometry.viewport);
							} else {
								map.setCenter(place.geometry.location);
								map.setZoom(17);
							}
							marker.setIcon(({
								url : place.icon,
								size : new google.maps.Size(71, 71),
								origin : new google.maps.Point(0, 0),
								anchor : new google.maps.Point(17, 34),
								scaledSize : new google.maps.Size(35, 35)
							}));
							marker.setPosition(place.geometry.location);
							marker.setVisible(true);

							var address = '';
							if (place.address_components) {
								address = [
										(place.address_components[0]
												&& place.address_components[0].short_name || ''),
										(place.address_components[1]
												&& place.address_components[1].short_name || ''),
										(place.address_components[2]
												&& place.address_components[2].short_name || '') ]
										.join(' ');
							}

							infowindow.setContent('<div><strong>' + place.name
									+ '</strong><br>' + address);
							infowindow.open(map, marker);

							// Location details
							var state = '';
							for (var i = 0; i < place.address_components.length; i++) {
								if (place.address_components[i].types[0] === 'administrative_area_level_1') {
									state = place.address_components[i].long_name;
								}
								if (place.address_components[i].types[0] === 'postal_code') {
									document.getElementById('postcode').value = place.address_components[i].long_name;
								}
							}

							document.getElementById('state').value = state;
							document.getElementById('lat').value = place.geometry.location
									.lat();
							document.getElementById('lng').value = place.geometry.location
									.lng();
						});
	}
</script>
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

		<!-- Listing Start -->
		<div class="container-xxl py-5" style="margin-bottom: 50px;">
			<div class="container w-50">
				<div class="text-center wow fadeInUp" data-wow-delay="0.1s">
					<h1 class="mb-5">
						<span class="text-primary text-uppercase">List your vacant
							room</span>
				</div>
				<div class="center-form">
					<form action="newListing" id="listingForm" method="post"
						enctype="multipart/form-data" style="align-content: center">
						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="text" class="form-control" id="title" name="title"
									value="${param.title}" placeholder="Tittle"> <label
									for="title"><i class="fa fa-home" aria-hidden="true"></i>
									Title</label>
							</div>
						</div>
						<br>
						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="text" class="form-control" id="address"
									name="address" value="${param.address}" placeholder="Address">
								<label for="address"><i class="fa fa-location-arrow"
									aria-hidden="true"></i> Street Address and Suburb</label>
							</div>
						</div>
						<div id="map"></div>
						<br>
						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="text" class="form-control" id="state" name="state"
									value="${param.state}" placeholder="state"> <label
									for="state"><i class="fa fa-map-marker"
									aria-hidden="true"></i> State</label>
							</div>
						</div>
						<br>
						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="text" class="form-control" id="postcode"
									name="postcode" value="${param.postcode}"
									placeholder="postcode"> <label for="address"><i
									class="fa fa-map-pin" aria-hidden="true"></i> Postcode</label>
							</div>
						</div>
						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="hidden" class="form-control" id="lat" name="lat"
									value="${param.lat}" placeholder="latitude">
							</div>
						</div>

						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="hidden" class="form-control" id="lng" name="lng"
									value="${param.lng}" placeholder="longitude">
							</div>
						</div>
						<br>
						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="text" class="form-control" id="squareArea"
									name="squareArea" value="${param.squareArea}"
									placeholder="squareArea"> <label for="squareArea"><i
									class="fa fa-superscript" aria-hidden="true"></i> Room Size
									(m²)</label>
							</div>
						</div>
						<br>
						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="text" class="form-control" id="capacity"
									name="capacity" value="${param.capacity}"
									placeholder="capacity"> <label for="capacity"><i
									class="fa fa-male" aria-hidden="true"></i> Number of people</label>
							</div>
						</div>
						<br>
						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="number" class="form-control" id="price"
									name="price" value="${param.price}" placeholder="price">
								<label for="price"><i class="fa fa-credit-card"
									aria-hidden="true"></i> Weekly Price</label>
							</div>
						</div>
						<br>
						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="date" class="form-control" id="Available Date"
									name="availableDate" value="${param.availableDate}"
									placeholder="Available Date"> <label
									for="availableDate"><i class="fa fa-calendar"
									aria-hidden="true"></i> Available Date</label>
							</div>
						</div>
						<br>
						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="number" class="form-control" id="bond" name="bond"
									value="${param.bond}" placeholder="bond"> <label
									for="bond"><i class="fa fa-university"
									aria-hidden="true"></i> Bond</label>
							</div>
						</div>
						<br>
						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="number" class="form-control" id="countBed"
									name="countBed" value="${param.countBed}"
									placeholder="countBed"> <label for="countBed"><i
									class="fa fa-bed" aria-hidden="true"></i> Number of Bedrooms</label>
							</div>
						</div>
						<br>
						<div class="col-md-6 w-100">
							<div class="form-floating">
								<input type="number" class="form-control" id="countBed"
									name="countBath" value="${param.countBath}"
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
									style="height: 100px">${param.description}</textarea>
							</div>
						</div>

						<br>
						<div class="col-12">
							<div>
								<p>
									<i class="fa fa-file-image-o" aria-hidden="true"></i> Upload
									photos of your listing
								</p>

								<div class="form-floating">
									<input type="file" class="form-control" id="image1"
										name="image1" accept="image/*"> <label for="image1"><i
										class="fa fa-file-image-o" aria-hidden="true"></i>Image 1</label>
								</div>

								<div class="form-floating">
									<input type="file" class="form-control" id="image2"
										name="image2" accept="image/*"> <label for="image2"><i
										class="fa fa-file-image-o" aria-hidden="true"></i>Image 2</label>
								</div>

								<div class="form-floating">
									<input type="file" class="form-control" id="image3"
										name="image3" accept="image/*"> <label for="image3"><i
										class="fa fa-file-image-o" aria-hidden="true"></i>Image 3</label>
								</div>

								<div class="form-floating">
									<input type="file" class="form-control" id="image4"
										name="image4" accept="image/*"> <label for="image4"><i
										class="fa fa-file-image-o" aria-hidden="true"></i>Image 4</label>
								</div>
							</div>
						</div>

						<br>
						<div class="col-md-6 w-100 pt-4" style="margin-bottom: 50px">
							<button class="btn btn-primary w-100 py-3" type="submit">List
								Your Room</button>
						</div>
					</form>
				</div>
			</div>
		</div>

		<!-- Listing End -->

		<!-- Footer Start -->
		<jsp:include page="footer.jsp"></jsp:include>
		<!-- Footer End -->
	</div>

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