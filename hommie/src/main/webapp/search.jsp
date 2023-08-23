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
<!-- Search Start -->
	<form action="search">
		<div class="container-fluid booking pb-5 wow fadeIn"
			data-wow-delay="0.1s">
			<div class="container">
				<div class="bg-white shadow" style="padding: 35px;">
					<div class="row g-2">
						<div class="col-md-10">
							<div class="row g-2">
								<div class="col-md-3">
									<div class="date" id="date1" data-target-input="nearest">
										<input type="text" class="form-control datetimepicker-input"
											placeholder="Available date" data-target="#date1"
											data-toggle="datetimepicker" name="availableDate"
											value="${availableDate != null ? availableDate : 'Available date'}" />
									</div>
								</div>

								<div class="col-md-3">


									<select class="form-select" name="state" id="stateSelect"
										onchange="clearStateError()">
										<option selected disabled>State</option>
										<option value="NSW">New South Wales</option>
										<option value="VIC">Victoria</option>
										<option value="QLD">Queensland</option>
										<option value="WA">Western Australia</option>
										<option value="SA">South Australia</option>
										<option value="NT">Northern Territory</option>
										<option value="TAS">Tasmania</option>
									</select>
									<c:if test="${not empty param.errorMessage}">
										<p
											style="color: #ff385c; text-align: center; margin-top: 10px; font-size: 20px;">${param.errorMessage}</p>
									</c:if>

								</div>


								<script>
									const stateSelect = document
											.getElementById('stateSelect');
									const selectedState = '${state}'; // Replace with the actual selected state from the server-side

									// Set the selected state based on the value from the server-side
									if (selectedState) {
										for (let i = 0; i < stateSelect.options.length; i++) {
											if (stateSelect.options[i].value === selectedState) {
												stateSelect.selectedIndex = i;
												break;
											}
										}
									}
								</script>


								<div class="col-md-3">
									<select class="form-select" name="weeklyPrice"
										id="weeklyPriceSelect">
										<option value="0" selected disabled>Weekly price</option>
										<option value="200">$100-$200</option>
										<option value="300">$200-$300</option>
										<option value="400">$300-$400</option>
										<option value="2000">over $400</option>
									</select>
								</div>

								<script>
									const weeklyPriceSelect = document
											.getElementById('weeklyPriceSelect');
									const selectedWeeklyPrice = '${weeklyPrice}'; // Replace with the actual selected weekly price from the server-side

									// Set the selected weekly price based on the value from the server-side
									if (selectedWeeklyPrice) {
										for (let i = 0; i < weeklyPriceSelect.options.length; i++) {
											if (weeklyPriceSelect.options[i].value === selectedWeeklyPrice) {
												weeklyPriceSelect.selectedIndex = i;
												break;
											}
										}
									}
								</script>


								<div class="col-md-3">
									<input class="form-control" name="searchInput"
										value="${searchInput}" />
								</div>
							</div>
						</div>
						<div class="col-md-2">
							<button class="btn btn-primary w-100">Search</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- Search end -->
</body>
</html>