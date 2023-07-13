<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Hotelier - Hotel HTML Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&family=Montserrat:wght@400;500;600;700&display=swap" rel="stylesheet">  

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <div class="container-xxl bg-white p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->

        <!-- Header Start -->
        <div class="container-fluid bg-dark px-0">
            <div class="row gx-0 justify-content-between p-4">
                <div class="col-lg-3 bg-dark d-none d-lg-block">
                    <a href="home.jsp" class="navbar-brand w-100 h-100 m-0 p-0 d-flex align-items-center justify-content-center">
                        <h1 class="m-0 text-primary text-uppercase">Hommie</h1>
                    </a>
                </div>
                <div class="col-lg-5 px-5 text-end">
                    <nav class="navbar navbar-expand-lg bg-dark navbar-dark p-3 p-lg-0">
                        <a href="home.jsp" class="navbar-brand d-block d-lg-none">
                            <h1 class="m-0 text-primary text-uppercase">Hommie</h1>
                        </a>
                        <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                            <div class="navbar-nav mr-auto py-0">
                                <a href="home.jsp" class="nav-item nav-link active">Home</a>
                                <a href="about.html" class="nav-item nav-link">Rooms</a>
                                <a href="service.html" class="nav-item nav-link">Landlord</a>
                                <div class="nav-item dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Account</a>
                                    <div class="dropdown-menu rounded-0 m-0">
                                        <a href="booking.html" class="dropdown-item">Register</a>
                                        <a href="team.html" class="dropdown-item">Login</a>
                                        <a href="testimonial.html" class="dropdown-item">Logout</a>
                                    </div>
                                </div>
                                <a href="contact.html" class="nav-item nav-link">Hi!Luv</a>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Header End -->
               <!-- Page Header Start -->
               <div class="container-fluid page-header mb-5 p-0" style="background-image: url(https://i.pinimg.com/564x/b0/6b/59/b06b59ae4ce0b72518f5b010100ff46e.jpg);">
                <div class="container-fluid page-header-inner py-5">
                    <div class="container text-center pb-5">
                        <h1 class="display-3 text-white mb-3 animated slideInDown">Landlord</h1>
                    </div>
                </div>
            </div>
            
            <!-- Page Header End -->
    
    
    
            <!-- Listing Start -->
            <div class="container-xxl py-5">
                <div class="container w-50">
                    <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                        <h1 class="mb-5"><span class="text-primary text-uppercase">List your vacant room</span>
                    </div>
                    <div class="center-form">
                        <form style="align-content: center">
                            <div class="col-md-6 w-100">
                                <div class="form-floating">
                                    <input type="email" class="form-control" id="email" placeholder="Tittle">
                                    <label for="email"><i class="fa fa-home" aria-hidden="true"></i> Tittle</label>
                                </div>
                            </div>
                            <br>
                            <div class="col-md-6 w-100">
                                <div class="form-floating">
                                    <input type="email" class="form-control" id="email" placeholder="Your Email">
                                    <label for="email"><i class="fa fa-location-arrow" aria-hidden="true"></i> Address</label>
                                </div>
                            </div>
                            <br>
                            <div class="col-md-6 w-100">
                                <div class="form-floating">
                                    <input type="email" class="form-control" id="email" placeholder="Your Email">
                                    <label for="email"><i class="fa fa-credit-card" aria-hidden="true"></i> Weekly Price</label>
                                </div>
                            </div>
                            <br>
                            <div class="col-md-6 w-100">
                                <div class="form-floating">
                                    <input type="email" class="form-control" id="email" placeholder="Your Email">
                                    <label for="email"><i class="fa fa-calendar" aria-hidden="true"></i>  Minimum Stay</label>
                                </div>
                            </div>
                            <br>
                            <div class="col-md-6 w-100">
                                <div class="form-floating">
                                    <input type="email" class="form-control" id="email" placeholder="Your Email">
                                    <label for="email"><i class="fa fa-university" aria-hidden="true"></i> Bond</label>
                                </div>
                            </div>
                            <br>
                            <div class="col-12">
                                    <input type="checkbox" id="wifi" name="wifi" value="Wifi">
                                    <label for="wifi"> <i class="fa fa-wifi" aria-hidden="true"></i> Wifi</label><br>
                                    <input type="checkbox" id="study-desk" name="study-desk" value="study-desk">
                                    <label for="study-desk"> <i class="fa fa-laptop" aria-hidden="true"></i> Study Desk</label><br>
                                    <input type="checkbox" id="AC" name="AC" value="AC">
                                    <label for="AC"> <i class="fa fa-thermometer-three-quarters" aria-hidden="true"></i> Air Conditioner</label><br>
                                    <input type="checkbox" id="pet" name="pet" value="pet">
                                    <label for="pet"> <i class="fa fa-paw" aria-hidden="true"></i> Pet</label><br>
                                    <input type="checkbox" id="parking" name="parking" value="parking">
                                    <label for="parking"> <i class="fa fa-car" aria-hidden="true"></i> Car Park</label><br>
                                    <input type="checkbox" id="bills-included" name="bills-included" value="bills-included">
                                    <label for="bills-included"><i class="fa fa-check" aria-hidden="true"></i> Bills Included</label><br>
                            </div>
                            <br>
                            <div class="col-12">
                                <div>
                                    <label for="message"><i class="fa fa-pencil" aria-hidden="true"></i> Description</label>
                                    <textarea class="form-control" id="message" style="height: 100px"></textarea>
                                </div>
                                </div>
                            <br>
                            <div class="col-12">
                                <div>
                                    <p><i class="fa fa-file-image-o" aria-hidden="true"></i> Upload photos of your listing</p>
                                    <form action="/action_page.php">
                                        <input type="file" id="myFile" name="filename">
                                        <input type="submit">
                                    </form>
                                    <br>
                                    <br>
                                    <form action="/action_page.php">
                                        <input type="file" id="myFile" name="filename">
                                        <input type="submit">
                                    </form>
                                    <br>
                                    <form action="/action_page.php">
                                        <input type="file" id="myFile" name="filename">
                                        <input type="submit">
                                    </form>
                                    <br>
                                    <form action="/action_page.php">
                                        <input type="file" id="myFile" name="filename">
                                        <input type="submit">
                                    </form>
                                </div>
                            </div>
                            <br>
                            <div class="col-md-6 w-100 pt-4">
                                <button class="btn btn-primary w-100 py-3" type="submit">List Your Room</button>
                            </div>
                            </div>
                        </form>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
            <!-- Listing End -->
    
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
    
            
    
             <!-- Footer Start -->
             <div class="container-fluid bg-dark text-light footer wow fadeIn" data-wow-delay="0.1s">
                <div class="container pb-5">
                    <div class="row g-5">
                        <div class="col-md-6 col-lg-4">
                            <div class="bg-primary rounded p-4">
                                <a href="index.html"><h1 class="text-white text-uppercase mb-3">Hommie</h1></a>
                                <p class="text-white mb-0">
                                    Download <a class="text-dark fw-medium" href="https://htmlcodex.com/hotel-html-template-pro">Hommie</a>, ultimate platform for students in search of their ideal living companion. Find harmony in shared living and unlock the doors to lifelong friendships.
                                </p>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-3">
                            <h6 class="section-title text-start text-primary text-uppercase mb-4">Contact</h6>
                            <p class="mb-2"><i class="fa fa-map-marker-alt me-3"></i>123 Beauty Street, Sydney, NSW</p>
                            <p class="mb-2"><i class="fa fa-phone-alt me-3"></i>+61 2 8123 4567</p>
                            <p class="mb-2"><i class="fa fa-envelope me-3"></i>info@hommie.com.au</p>
                            <div class="d-flex pt-2">
                                <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-twitter"></i></a>
                                <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-facebook-f"></i></a>
                                <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-youtube"></i></a>
                                <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-linkedin-in"></i></a>
                            </div>
                        </div>
                        <div class="col-lg-5 col-md-12">
                            <div class="row gy-5 g-4">
                                <div class="col-md-6">
                                    <h6 class="section-title text-start text-primary text-uppercase mb-4">Company</h6>
                                    <a class="btn btn-link" href="">About Us</a>
                                    <a class="btn btn-link" href="">Contact Us</a>
                                    <a class="btn btn-link" href="">Privacy Policy</a>
                                    <a class="btn btn-link" href="">Terms & Condition</a>
                                    <a class="btn btn-link" href="">Support</a>
                                </div>
                                <div class="col-md-6">
                                    <h6 class="section-title text-start text-primary text-uppercase mb-4">Services</h6>
                                    <a class="btn btn-link" href="">Landlords</a>
                                    <a class="btn btn-link" href="">Students</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="copyright">
                        <div class="row">
                            <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                                &copy; <a class="border-bottom" href="#">Hommie Australia</a>, All Right Reserved. 
                                
                                <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                                Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML Codex</a>
                            </div>
                            <div class="col-md-6 text-center text-md-end">
                                <div class="footer-menu">
                                    <a href="">Home</a>
                                    <a href="">Cookies</a>
                                    <a href="">Help</a>
                                    <a href="">FQAs</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Footer End -->
    
    
            <!-- Back to Top -->
            <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
        </div>
    
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
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