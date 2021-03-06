<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Speedyservice
  Date: 5/20/2022
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>E Store - eCommerce HTML Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="eCommerce HTML Template Free Download" name="keywords">
    <meta content="eCommerce HTML Template Free Download" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap" rel="stylesheet">

    <!-- CSS Libraries -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="lib/slick/slick.css" rel="stylesheet">
    <link href="lib/slick/slick-theme.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
<!-- Top bar Start -->
<div class="top-bar">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-6">
                <i class="fa fa-envelope"></i>
                support@email.com
            </div>
            <div class="col-sm-6">
                <i class="fa fa-phone-alt"></i>
                +012-345-6789
            </div>
        </div>
    </div>
</div>
<!-- Top bar End -->

<!-- Nav Bar Start -->
<div class="nav">
    <div class="container-fluid">
        <nav class="navbar navbar-expand-md bg-dark navbar-dark">
            <a href="#" class="navbar-brand">MENU</a>
            <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                <div class="navbar-nav mr-auto">
                    <a href="home" class="nav-item nav-link active">Home</a>
                    <a href="products" class="nav-item nav-link ">Products</a>
                    <%--                    <a href="product-detail.html" class="nav-item nav-link">Product Detail</a>--%>
                    <c:if test="${sessionScope.account.role == 1}">
                        <a href="/CartServlet" class="nav-item nav-link">Cart</a>
                        <a href="/CheckoutServlet" class="nav-item nav-link">Checkout</a>
                    </c:if>
                    <c:if test="${sessionScope.account.role == 2}">
                        <a href="/ProductMangerServlet" class="nav-item nav-link">Product manager</a>
                        <a href="/OrderManagerServlet" class="nav-item nav-link">Orders manager</a>
                        <%--                        <a href="my-account.html" class="nav-item nav-link">My Account</a>--%>
                    </c:if>
                    <c:if test="${sessionScope.account.role == 3}">
                        <a href="/UserManagementServlet" class="nav-item nav-link">Manage User</a>
                    </c:if>

                    <%--                    <div class="nav-item dropdown">--%>
                    <%--                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">More Pages</a>--%>
                    <%--                        <div class="dropdown-menu">--%>
                    <%--                            <a href="wishlist.html" class="dropdown-item">Wishlist</a>--%>
                    <%--                            <a href="login.html" class="dropdown-item">Login & Register</a>--%>
                    <%--                            <a href="contact.html" class="dropdown-item">Contact Us</a>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                </div>
                <c:if test="${sessionScope.account == null}">
                    <div class="navbar-nav ml-auto">
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Login Or Register</a>
                            <div class="dropdown-menu">
                                <a href="accounts" class="dropdown-item">Login</a>
                                <a href="accounts" class="dropdown-item">Register</a>
                            </div>
                        </div>
                    </div>
                </c:if>
                <c:if test="${sessionScope.account != null}">
                    <div class="navbar-nav ml-auto">
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Hello ${sessionScope.account.full_name}</a>
                            <div class="dropdown-menu">
                                <a href="/MyAccountServlet" class="dropdown-item">My account</a>
                                <a href="accounts?action=logout" class="dropdown-item">Logout</a>
                            </div>
                        </div>
                    </div>
                </c:if>

            </div>
        </nav>
    </div>
</div>
<!-- Nav Bar End -->

<!-- Bottom Bar Start -->
<div class="bottom-bar">
    <div class="container-fluid">
        <div class="row align-items-center">
            <div class="col-md-3">
                <div class="logo">
                    <a href="products">
                        <img src="img/logo.png" alt="Logo">
                    </a>
                </div>
            </div>
            <div class="col-md-6">
                <div class="search">
                    <input type="text" placeholder="Search">
                    <button><i class="fa fa-search"></i></button>
                </div>
            </div>
            <div class="col-md-3">
                <div class="user">
                    <a href="wishlist.html" class="btn wishlist">
                        <i class="fa fa-heart"></i>
                        <span>(0)</span>
                    </a>
                    <a href="/CartServlet" class="btn cart">
                        <i class="fa fa-shopping-cart"></i>
                        <span>(0)</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Bottom Bar End -->

<!-- Breadcrumb Start -->
<div class="breadcrumb-wrap">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Products</a></li>
            <li class="breadcrumb-item active">Login & Register</li>
        </ul>
    </div>
</div>
<!-- Breadcrumb End -->

<!-- Login Start -->
<div class="login">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6">
                <form action="accounts?action=register" method="post">
                    <div class="register-form">
                        <p class="text-danger">${error}${error1}</p>
                        <p class="text-success">${success}</p>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Full name</label>
                                <input class="form-control" type="text" placeholder="Full name" name="fullName">
                            </div>
                            <div class="col-md-6">
                                <label>Email</label>
                                <input class="form-control" type="email" placeholder="Email" name="userName">
                            </div>
                            <div class="col-md-6">
                                <label>Address</label>
                                <input class="form-control" type="text" placeholder="Address" name="address">
                            </div>
                            <div class="col-md-6">
                                <label>Mobile No</label>
                                <input class="form-control" type="text" placeholder="Mobile No" name="phone">
                            </div>
                            <div class="col-md-6">
                                <label>Password</label>
                                <input class="form-control password-field" type="password" placeholder="Password" name="password">
                            </div>
                            <div class="col-md-6">
                                <label>Retype Password</label>
                                <input class="form-control" type="password" placeholder="Password" name="rePassword">
                            </div>
                            <div class="form-group col-md-12">
                                <label for="exampleFormControlSelect1">Role select</label>
                                <select class="form-control" id="exampleFormControlSelect1" name="role">
                                    <option>Buyer</option>
                                    <option>Seller</option>
                                </select>
                            </div>
                            <div class="col-md-12">
                                <button class="btn">Submit</button>
                            </div>

                        </div>
                    </div>
                </form>

            </div>
            <div class="col-lg-6">
                <form action="accounts?action=login" method="post">
                    <p class="text-danger">${mess}</p>
                    <div class="login-form">
                        <div class="row">
                            <div class="col-md-6">
                                <label>Email</label>
                                <input class="form-control" type="email" name="name" placeholder="Email">
                            </div>
                            <div class="col-md-6">
                                <label>Password</label>
                                <input class="form-control" type="password" name="pass" placeholder="Password">
                            </div>
                            <div class="col-md-12">
                                <div class="custom-control custom-checkbox">
                                    <input type="checkbox" class="custom-control-input" id="newaccount">
                                    <label class="custom-control-label" for="newaccount">Keep me signed in</label>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <button class="btn">Submit</button>
                            </div>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
<!-- Login End -->

<!-- Footer Start -->
<div class="footer">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-3 col-md-6">
                <div class="footer-widget">
                    <h2>Get in Touch</h2>
                    <div class="contact-info">
                        <p><i class="fa fa-map-marker"></i>123 E Store, Los Angeles, USA</p>
                        <p><i class="fa fa-envelope"></i>email@example.com</p>
                        <p><i class="fa fa-phone"></i>+123-456-7890</p>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-6">
                <div class="footer-widget">
                    <h2>Follow Us</h2>
                    <div class="contact-info">
                        <div class="social">
                            <a href=""><i class="fab fa-twitter"></i></a>
                            <a href=""><i class="fab fa-facebook-f"></i></a>
                            <a href=""><i class="fab fa-linkedin-in"></i></a>
                            <a href=""><i class="fab fa-instagram"></i></a>
                            <a href=""><i class="fab fa-youtube"></i></a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-6">
                <div class="footer-widget">
                    <h2>Company Info</h2>
                    <ul>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Terms & Condition</a></li>
                    </ul>
                </div>
            </div>

            <div class="col-lg-3 col-md-6">
                <div class="footer-widget">
                    <h2>Purchase Info</h2>
                    <ul>
                        <li><a href="#">Pyament Policy</a></li>
                        <li><a href="#">Shipping Policy</a></li>
                        <li><a href="#">Return Policy</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="row payment align-items-center">
            <div class="col-md-6">
                <div class="payment-method">
                    <h2>We Accept:</h2>
                    <img src="img/payment-method.png" alt="Payment Method" />
                </div>
            </div>
            <div class="col-md-6">
                <div class="payment-security">
                    <h2>Secured By:</h2>
                    <img src="img/godaddy.svg" alt="Payment Security" />
                    <img src="img/norton.svg" alt="Payment Security" />
                    <img src="img/ssl.svg" alt="Payment Security" />
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer End -->

<!-- Footer Bottom Start -->
<div class="footer-bottom">
    <div class="container">
        <div class="row">
            <div class="col-md-6 copyright">
                <p>Copyright &copy; <a href="https://htmlcodex.com">HTML Codex</a>. All Rights Reserved</p>
            </div>

            <div class="col-md-6 template-by">
                <p>Template By <a href="https://htmlcodex.com">HTML Codex</a></p>
            </div>
        </div>
    </div>
</div>
<!-- Footer Bottom End -->

<!-- Back to Top -->
<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/slick/slick.min.js"></script>

<!-- Template Javascript -->
<script src="js/main.js"></script>
</body>
</html>
