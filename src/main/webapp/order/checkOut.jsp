<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Speedyservice
  Date: 5/21/2022
  Time: 11:27 PM
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
                    <a href="index.html">
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
            <li class="breadcrumb-item active">Checkout</li>
        </ul>
    </div>
</div>
<!-- Breadcrumb End -->

<!-- Checkout Start -->
<div class="checkout">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-8">
                <div class="checkout-inner">
                    <div class="billing-address">
                        <h2>Billing Address</h2>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Full Name</label>
                                <input value="${user.full_name}" class="form-control" type="text" placeholder="Full Name">
                            </div>
                            <div class="col-md-6">
                                <label>E-mail</label>
                                <input value="${user.email}" class="form-control" type="text" placeholder="E-mail">
                            </div>
                            <div class="col-md-6">
                                <label>Phone</label>
                                <input value="${user.phone}" class="form-control" type="text" placeholder="Phone">
                            </div>
                            <div class="col-md-6">
                                <label>Address</label>
                                <input value="${user.address}" class="form-control" type="text" placeholder="Address">
                            </div>
                        </div>
                    </div>

                    <div class="shipping-address">
                        <h2>Shipping Address</h2>
                        <div class="row">
                            <div class="col-md-6">
                                <label>First Name</label>
                                <input class="form-control" type="text" placeholder="First Name">
                            </div>
                            <div class="col-md-6">
                                <label>Last Name"</label>
                                <input class="form-control" type="text" placeholder="Last Name">
                            </div>
                            <div class="col-md-6">
                                <label>E-mail</label>
                                <input class="form-control" type="text" placeholder="E-mail">
                            </div>
                            <div class="col-md-6">
                                <label>Mobile No</label>
                                <input class="form-control" type="text" placeholder="Mobile No">
                            </div>
                            <div class="col-md-12">
                                <label>Address</label>
                                <input class="form-control" type="text" placeholder="Address">
                            </div>
                            <div class="col-md-6">
                                <label>Country</label>
                                <select class="custom-select">
                                    <option selected>United States</option>
                                    <option>Afghanistan</option>
                                    <option>Albania</option>
                                    <option>Algeria</option>
                                </select>
                            </div>
                            <div class="col-md-6">
                                <label>City</label>
                                <input class="form-control" type="text" placeholder="City">
                            </div>
                            <div class="col-md-6">
                                <label>State</label>
                                <input class="form-control" type="text" placeholder="State">
                            </div>
                            <div class="col-md-6">
                                <label>ZIP Code</label>
                                <input class="form-control" type="text" placeholder="ZIP Code">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="checkout-inner">
                    <div class="checkout-summary">
                        <h1>Cart Total</h1>
                        <c:forEach items="${cartList}" var="cart">
                            <p>${cart.productName}<span>${cart.priceTotal}</span></p>
                        </c:forEach>
                        <p class="sub-total">Sub Total<span>${subTotal}</span></p>
                        <p class="ship-cost">Shipping Cost<span>$1</span></p>
                        <h2>Grand Total<span>${subTotal + 1}</span></h2>
                    </div>

                    <div class="checkout-payment">
                        <div class="payment-methods">
                            <h1>Payment Methods</h1>
                            <div class="payment-method">
                                <div class="custom-control custom-radio">
                                    <input type="radio" class="custom-control-input" id="payment-1" name="payment">
                                    <label class="custom-control-label" for="payment-1">Paypal</label>
                                </div>
                                <div class="payment-content" id="payment-1-show">
                                    <p>
                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras tincidunt orci ac eros volutpat maximus lacinia quis diam.
                                    </p>
                                </div>
                            </div>
                            <div class="payment-method">
                                <div class="custom-control custom-radio">
                                    <input type="radio" class="custom-control-input" id="payment-2" name="payment">
                                    <label class="custom-control-label" for="payment-2">Payoneer</label>
                                </div>
                                <div class="payment-content" id="payment-2-show">
                                    <p>
                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras tincidunt orci ac eros volutpat maximus lacinia quis diam.
                                    </p>
                                </div>
                            </div>
                            <div class="payment-method">
                                <div class="custom-control custom-radio">
                                    <input type="radio" class="custom-control-input" id="payment-3" name="payment">
                                    <label class="custom-control-label" for="payment-3">Check Payment</label>
                                </div>
                                <div class="payment-content" id="payment-3-show">
                                    <p>
                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras tincidunt orci ac eros volutpat maximus lacinia quis diam.
                                    </p>
                                </div>
                            </div>
                            <div class="payment-method">
                                <div class="custom-control custom-radio">
                                    <input type="radio" class="custom-control-input" id="payment-4" name="payment">
                                    <label class="custom-control-label" for="payment-4">Direct Bank Transfer</label>
                                </div>
                                <div class="payment-content" id="payment-4-show">
                                    <p>
                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras tincidunt orci ac eros volutpat maximus lacinia quis diam.
                                    </p>
                                </div>
                            </div>
                            <div class="payment-method">
                                <div class="custom-control custom-radio">
                                    <input type="radio" class="custom-control-input" id="payment-5" name="payment">
                                    <label class="custom-control-label" for="payment-5">Cash on Delivery</label>
                                </div>
                                <div class="payment-content" id="payment-5-show">
                                    <p>
                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras tincidunt orci ac eros volutpat maximus lacinia quis diam.
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="checkout-btn">
                            <a href="CheckoutServlet?action=insertOrder"><button>Place Order</button></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Checkout End -->

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

