<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Speedyservice
  Date: 5/20/2022
  Time: 2:28 PM
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
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap"
          rel="stylesheet">

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
                            <a href="#" class="nav-link dropdown-toggle"
                               data-toggle="dropdown">Hello ${sessionScope.account.full_name}</a>
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
                <form action="/products?action=search" method="post">
                    <div class="search">
                        <input value="${txtS}" type="text" placeholder="Search" name="productName">
                        <button><i class="fa fa-search"></i></button>
                    </div>
                </form>
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
            <li class="breadcrumb-item active">Product List</li>
        </ul>
    </div>
</div>
<!-- Breadcrumb End -->

<!-- Product List Start -->
<div class="product-view">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-8">
                <div class="row">
                    <div class="col-md-12">
                        <div class="product-view-top">
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="product-search">
                                        <input type="email" value="Search">
                                        <button><i class="fa fa-search"></i></button>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="product-short">
                                        <div class="dropdown">
                                            <div class="dropdown-toggle" data-toggle="dropdown">Product short by</div>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a href="#" class="dropdown-item">Newest</a>
                                                <a href="#" class="dropdown-item">Popular</a>
                                                <a href="#" class="dropdown-item">Most sale</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="product-price-range">
                                        <div class="dropdown">
                                            <div class="dropdown-toggle" data-toggle="dropdown">Product price range
                                            </div>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a href="#" class="dropdown-item">$0 to $50</a>
                                                <a href="#" class="dropdown-item">$51 to $100</a>
                                                <a href="#" class="dropdown-item">$101 to $150</a>
                                                <a href="#" class="dropdown-item">$151 to $200</a>
                                                <a href="#" class="dropdown-item">$201 to $250</a>
                                                <a href="#" class="dropdown-item">$251 to $300</a>
                                                <a href="#" class="dropdown-item">$301 to $350</a>
                                                <a href="#" class="dropdown-item">$351 to $400</a>
                                                <a href="#" class="dropdown-item">$401 to $450</a>
                                                <a href="#" class="dropdown-item">$451 to $500</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <c:forEach items="${listProduct}" var="o">
                        <div class="col-md-4">
                            <div class="product-item">
                                <div class="product-title">
                                    <a href="/productDetails?action=productID&productId=${o.productId}">${o.productName}</a>
                                    <div class="ratting">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                </div>
                                <div class="product-image">
                                    <a href="#">
                                        <img src="${o.productImage}" alt="Product Image">
                                    </a>
                                    <div class="product-action">
                                        <a href="CartServlet?action=insert&productId=${o.productId}&session=${sessionScope.account.user_id}"><i class="fa fa-cart-plus"></i></a>
                                        <a href="#"><i class="fa fa-heart"></i></a>
                                        <a href="#"><i class="fa fa-search"></i></a>
                                    </div>
                                </div>
                                <div class="product-price"  style="text-align: center !important;">
                                    <h3>${o.productPrice} <span>$</span></h3>
<%--                                    <a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy Now</a>--%>
                                    <h5 style="color: white">Available: ${o.quantityProduct}</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>


                    <%--                    <div class="col-md-4">--%>
                    <%--                        <div class="product-item">--%>
                    <%--                            <div class="product-title">--%>
                    <%--                                <a href="#">Product Name</a>--%>
                    <%--                                <div class="ratting">--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                </div>--%>
                    <%--                            </div>--%>
                    <%--                            <div class="product-image">--%>
                    <%--                                <a href="product-detail.html">--%>
                    <%--                                    <img src="img/product-2.jpg" alt="Product Image">--%>
                    <%--                                </a>--%>
                    <%--                                <div class="product-action">--%>
                    <%--                                    <a href="#"><i class="fa fa-cart-plus"></i></a>--%>
                    <%--                                    <a href="#"><i class="fa fa-heart"></i></a>--%>
                    <%--                                    <a href="#"><i class="fa fa-search"></i></a>--%>
                    <%--                                </div>--%>
                    <%--                            </div>--%>
                    <%--                            <div class="product-price">--%>
                    <%--                                <h3><span>$</span>99</h3>--%>
                    <%--                                <a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy Now</a>--%>
                    <%--                            </div>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="col-md-4">--%>
                    <%--                        <div class="product-item">--%>
                    <%--                            <div class="product-title">--%>
                    <%--                                <a href="#">Product Name</a>--%>
                    <%--                                <div class="ratting">--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                </div>--%>
                    <%--                            </div>--%>
                    <%--                            <div class="product-image">--%>
                    <%--                                <a href="product-detail.html">--%>
                    <%--                                    <img src="img/product-3.jpg" alt="Product Image">--%>
                    <%--                                </a>--%>
                    <%--                                <div class="product-action">--%>
                    <%--                                    <a href="#"><i class="fa fa-cart-plus"></i></a>--%>
                    <%--                                    <a href="#"><i class="fa fa-heart"></i></a>--%>
                    <%--                                    <a href="#"><i class="fa fa-search"></i></a>--%>
                    <%--                                </div>--%>
                    <%--                            </div>--%>
                    <%--                            <div class="product-price">--%>
                    <%--                                <h3><span>$</span>99</h3>--%>
                    <%--                                <a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy Now</a>--%>
                    <%--                            </div>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="col-md-4">--%>
                    <%--                        <div class="product-item">--%>
                    <%--                            <div class="product-title">--%>
                    <%--                                <a href="#">Product Name</a>--%>
                    <%--                                <div class="ratting">--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                </div>--%>
                    <%--                            </div>--%>
                    <%--                            <div class="product-image">--%>
                    <%--                                <a href="product-detail.html">--%>
                    <%--                                    <img src="img/product-4.jpg" alt="Product Image">--%>
                    <%--                                </a>--%>
                    <%--                                <div class="product-action">--%>
                    <%--                                    <a href="#"><i class="fa fa-cart-plus"></i></a>--%>
                    <%--                                    <a href="#"><i class="fa fa-heart"></i></a>--%>
                    <%--                                    <a href="#"><i class="fa fa-search"></i></a>--%>
                    <%--                                </div>--%>
                    <%--                            </div>--%>
                    <%--                            <div class="product-price">--%>
                    <%--                                <h3><span>$</span>99</h3>--%>
                    <%--                                <a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy Now</a>--%>
                    <%--                            </div>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="col-md-4">--%>
                    <%--                        <div class="product-item">--%>
                    <%--                            <div class="product-title">--%>
                    <%--                                <a href="#">Product Name</a>--%>
                    <%--                                <div class="ratting">--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                </div>--%>
                    <%--                            </div>--%>
                    <%--                            <div class="product-image">--%>
                    <%--                                <a href="product-detail.html">--%>
                    <%--                                    <img src="img/product-5.jpg" alt="Product Image">--%>
                    <%--                                </a>--%>
                    <%--                                <div class="product-action">--%>
                    <%--                                    <a href="#"><i class="fa fa-cart-plus"></i></a>--%>
                    <%--                                    <a href="#"><i class="fa fa-heart"></i></a>--%>
                    <%--                                    <a href="#"><i class="fa fa-search"></i></a>--%>
                    <%--                                </div>--%>
                    <%--                            </div>--%>
                    <%--                            <div class="product-price">--%>
                    <%--                                <h3><span>$</span>99</h3>--%>
                    <%--                                <a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy Now</a>--%>
                    <%--                            </div>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="col-md-4">--%>
                    <%--                        <div class="product-item">--%>
                    <%--                            <div class="product-title">--%>
                    <%--                                <a href="#">Product Name</a>--%>
                    <%--                                <div class="ratting">--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                </div>--%>
                    <%--                            </div>--%>
                    <%--                            <div class="product-image">--%>
                    <%--                                <a href="product-detail.html">--%>
                    <%--                                    <img src="img/product-6.jpg" alt="Product Image">--%>
                    <%--                                </a>--%>
                    <%--                                <div class="product-action">--%>
                    <%--                                    <a href="#"><i class="fa fa-cart-plus"></i></a>--%>
                    <%--                                    <a href="#"><i class="fa fa-heart"></i></a>--%>
                    <%--                                    <a href="#"><i class="fa fa-search"></i></a>--%>
                    <%--                                </div>--%>
                    <%--                            </div>--%>
                    <%--                            <div class="product-price">--%>
                    <%--                                <h3><span>$</span>99</h3>--%>
                    <%--                                <a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy Now</a>--%>
                    <%--                            </div>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="col-md-4">--%>
                    <%--                        <div class="product-item">--%>
                    <%--                            <div class="product-title">--%>
                    <%--                                <a href="#">Product Name</a>--%>
                    <%--                                <div class="ratting">--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                </div>--%>
                    <%--                            </div>--%>
                    <%--                            <div class="product-image">--%>
                    <%--                                <a href="product-detail.html">--%>
                    <%--                                    <img src="img/product-7.jpg" alt="Product Image">--%>
                    <%--                                </a>--%>
                    <%--                                <div class="product-action">--%>
                    <%--                                    <a href="#"><i class="fa fa-cart-plus"></i></a>--%>
                    <%--                                    <a href="#"><i class="fa fa-heart"></i></a>--%>
                    <%--                                    <a href="#"><i class="fa fa-search"></i></a>--%>
                    <%--                                </div>--%>
                    <%--                            </div>--%>
                    <%--                            <div class="product-price">--%>
                    <%--                                <h3><span>$</span>99</h3>--%>
                    <%--                                <a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy Now</a>--%>
                    <%--                            </div>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="col-md-4">--%>
                    <%--                        <div class="product-item">--%>
                    <%--                            <div class="product-title">--%>
                    <%--                                <a href="#">Product Name</a>--%>
                    <%--                                <div class="ratting">--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                </div>--%>
                    <%--                            </div>--%>
                    <%--                            <div class="product-image">--%>
                    <%--                                <a href="product-detail.html">--%>
                    <%--                                    <img src="img/product-8.jpg" alt="Product Image">--%>
                    <%--                                </a>--%>
                    <%--                                <div class="product-action">--%>
                    <%--                                    <a href="#"><i class="fa fa-cart-plus"></i></a>--%>
                    <%--                                    <a href="#"><i class="fa fa-heart"></i></a>--%>
                    <%--                                    <a href="#"><i class="fa fa-search"></i></a>--%>
                    <%--                                </div>--%>
                    <%--                            </div>--%>
                    <%--                            <div class="product-price">--%>
                    <%--                                <h3><span>$</span>99</h3>--%>
                    <%--                                <a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy Now</a>--%>
                    <%--                            </div>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="col-md-4">--%>
                    <%--                        <div class="product-item">--%>
                    <%--                            <div class="product-title">--%>
                    <%--                                <a href="#">Product Name</a>--%>
                    <%--                                <div class="ratting">--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                    <i class="fa fa-star"></i>--%>
                    <%--                                </div>--%>
                    <%--                            </div>--%>
                    <%--                            <div class="product-image">--%>
                    <%--                                <a href="product-detail.html">--%>
                    <%--                                    <img src="img/product-9.jpg" alt="Product Image">--%>
                    <%--                                </a>--%>
                    <%--                                <div class="product-action">--%>
                    <%--                                    <a href="#"><i class="fa fa-cart-plus"></i></a>--%>
                    <%--                                    <a href="#"><i class="fa fa-heart"></i></a>--%>
                    <%--                                    <a href="#"><i class="fa fa-search"></i></a>--%>
                    <%--                                </div>--%>
                    <%--                            </div>--%>
                    <%--                            <div class="product-price">--%>
                    <%--                                <h3><span>$</span>99</h3>--%>
                    <%--                                <a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy Now</a>--%>
                    <%--                            </div>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                    <%--                </div>--%>

                    <!-- Pagination Start -->
                    <div class="col-md-12">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination justify-content-center">
                                <li class="page-item disabled">
                                    <a class="page-link" href="#" tabindex="-1">Previous</a>
                                </li>
<%--                                <c:forEach begin="1" end="${endPage}" var="i">--%>
<%--                                    <li class="page-item ${tag == i? "active":""}"><a class="page-link" href="/products?index=${i}">${i}</a></li>--%>
<%--                                </c:forEach>--%>
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item">
                                    <a class="page-link" href="#">Next</a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                    <!-- Pagination Start -->
                </div>

                <!-- Side Bar Start -->
                <div class="col-lg-4 sidebar">
                    <div class="sidebar-widget category">
                        <h2 class="title">Category</h2>
                        <nav class="navbar bg-light">
                            <ul class="navbar-nav">
                                <c:forEach items="${categoryList}" var="o">
                                    <li class="nav-item">
                                        <a class="nav-link"
                                           href="/categorys?action=cateID&categoryId=${o.categoryId}"><i
                                                class="fa fa-male"></i>${o.cateName}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </nav>
                    </div>

                    <div class="sidebar-widget widget-slider">
                        <div class="sidebar-slider normal-slider">
                            <c:forEach items="${topProduct}" var="o">
                                <div class="product-item">
                                    <div class="product-title">
                                        <a href="#">${o.productName}</a>
                                        <div class="ratting">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="product-image">
                                        <a href="product-detail.html">
                                            <img src="${o.productImage}" alt="Product Image">
                                        </a>
                                        <div class="product-action">
                                            <a href="#"><i class="fa fa-cart-plus"></i></a>
                                            <a href="#"><i class="fa fa-heart"></i></a>
                                            <a href="#"><i class="fa fa-search"></i></a>
                                        </div>
                                    </div>
                                    <div class="product-price">
                                        <h5>${o.productPrice} <span>VND</span></h5>
                                        <a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy Now</a>
                                    </div>
                                </div>
                            </c:forEach>

                            <%--                        <div class="product-item">--%>
                            <%--                            <div class="product-title">--%>
                            <%--                                <a href="#">Product Name</a>--%>
                            <%--                                <div class="ratting">--%>
                            <%--                                    <i class="fa fa-star"></i>--%>
                            <%--                                    <i class="fa fa-star"></i>--%>
                            <%--                                    <i class="fa fa-star"></i>--%>
                            <%--                                    <i class="fa fa-star"></i>--%>
                            <%--                                    <i class="fa fa-star"></i>--%>
                            <%--                                </div>--%>
                            <%--                            </div>--%>
                            <%--                            <div class="product-image">--%>
                            <%--                                <a href="product-detail.html">--%>
                            <%--                                    <img src="img/product-9.jpg" alt="Product Image">--%>
                            <%--                                </a>--%>
                            <%--                                <div class="product-action">--%>
                            <%--                                    <a href="#"><i class="fa fa-cart-plus"></i></a>--%>
                            <%--                                    <a href="#"><i class="fa fa-heart"></i></a>--%>
                            <%--                                    <a href="#"><i class="fa fa-search"></i></a>--%>
                            <%--                                </div>--%>
                            <%--                            </div>--%>
                            <%--                            <div class="product-price">--%>
                            <%--                                <h3><span>$</span>99</h3>--%>
                            <%--                                <a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy Now</a>--%>
                            <%--                            </div>--%>
                            <%--                        </div>--%>
                            <%--                        <div class="product-item">--%>
                            <%--                            <div class="product-title">--%>
                            <%--                                <a href="#">Product Name</a>--%>
                            <%--                                <div class="ratting">--%>
                            <%--                                    <i class="fa fa-star"></i>--%>
                            <%--                                    <i class="fa fa-star"></i>--%>
                            <%--                                    <i class="fa fa-star"></i>--%>
                            <%--                                    <i class="fa fa-star"></i>--%>
                            <%--                                    <i class="fa fa-star"></i>--%>
                            <%--                                </div>--%>
                            <%--                            </div>--%>
                            <%--                            <div class="product-image">--%>
                            <%--                                <a href="product-detail.html">--%>
                            <%--                                    <img src="img/product-8.jpg" alt="Product Image">--%>
                            <%--                                </a>--%>
                            <%--                                <div class="product-action">--%>
                            <%--                                    <a href="#"><i class="fa fa-cart-plus"></i></a>--%>
                            <%--                                    <a href="#"><i class="fa fa-heart"></i></a>--%>
                            <%--                                    <a href="#"><i class="fa fa-search"></i></a>--%>
                            <%--                                </div>--%>
                            <%--                            </div>--%>
                            <%--                            <div class="product-price">--%>
                            <%--                                <h3><span>$</span>99</h3>--%>
                            <%--                                <a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy Now</a>--%>
                            <%--                            </div>--%>
                            <%--                        </div>--%>
                        </div>
                    </div>

<%--                    <div class="sidebar-widget brands">--%>
<%--                        <h2 class="title">Our Brands</h2>--%>
<%--                        <ul>--%>
<%--                            <li><a href="#">Nulla </a><span>(45)</span></li>--%>
<%--                            <li><a href="#">Curabitur </a><span>(34)</span></li>--%>
<%--                            <li><a href="#">Nunc </a><span>(67)</span></li>--%>
<%--                            <li><a href="#">Ullamcorper</a><span>(74)</span></li>--%>
<%--                            <li><a href="#">Fusce </a><span>(89)</span></li>--%>
<%--                            <li><a href="#">Sagittis</a><span>(28)</span></li>--%>
<%--                        </ul>--%>
<%--                    </div>--%>

<%--                    <div class="sidebar-widget tag">--%>
<%--                        <h2 class="title">Tags Cloud</h2>--%>
<%--                        <a href="#">Lorem ipsum</a>--%>
<%--                        <a href="#">Vivamus</a>--%>
<%--                        <a href="#">Phasellus</a>--%>
<%--                        <a href="#">pulvinar</a>--%>
<%--                        <a href="#">Curabitur</a>--%>
<%--                        <a href="#">Fusce</a>--%>
<%--                        <a href="#">Sem quis</a>--%>
<%--                        <a href="#">Mollis metus</a>--%>
<%--                        <a href="#">Sit amet</a>--%>
<%--                        <a href="#">Vel posuere</a>--%>
<%--                        <a href="#">orci luctus</a>--%>
<%--                        <a href="#">Nam lorem</a>--%>
<%--                    </div>--%>
                </div>
                <!-- Side Bar End -->
            </div>
        </div>
    </div>
    <!-- Product List End -->

    <!-- Brand Start -->
    <div class="brand">
        <div class="container-fluid">
            <div class="brand-slider">
                <div class="brand-item"><img src="img/brand-1.png" alt=""></div>
                <div class="brand-item"><img src="img/brand-2.png" alt=""></div>
                <div class="brand-item"><img src="img/brand-3.png" alt=""></div>
                <div class="brand-item"><img src="img/brand-4.png" alt=""></div>
                <div class="brand-item"><img src="img/brand-5.png" alt=""></div>
                <div class="brand-item"><img src="img/brand-6.png" alt=""></div>
            </div>
        </div>
    </div>
    <!-- Brand End -->

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
                        <img src="img/payment-method.png" alt="Payment Method"/>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="payment-security">
                        <h2>Secured By:</h2>
                        <img src="img/godaddy.svg" alt="Payment Security"/>
                        <img src="img/norton.svg" alt="Payment Security"/>
                        <img src="img/ssl.svg" alt="Payment Security"/>
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
</div></body>
</html>

