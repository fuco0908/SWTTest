<%-- 
    Document   : Menu
    Created on : 21 thg 2, 2024, 16:33:26
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- ***** Preloader Start ***** -->
<div id="js-preloader" class="js-preloader">
    <div class="preloader-inner">
        <span class="dot"></span>
        <div class="dots">
            <span></span>
            <span></span>
            <span></span>
        </div>
    </div>
</div>
<!-- ***** Preloader End ***** -->

<!-- ***** Header Area Start ***** -->
<header class="header-area header-sticky">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <nav class="main-nav">
                    <!-- ***** Logo Start ***** -->
                    <a href="homeservlet" class="logo">
                        <img src="assets/images/logo.png" alt="">
                    </a>
                    <!-- ***** Logo End ***** -->
                    <!-- ***** Search End ***** -->
                    <div class="search-input">
                        <form id="search" action="search" method="post">
                            <input type="text" placeholder="Search Games" id='searchText' name="searchKeyword"
                                   onkeypress="handle" />
                            <i class="fa fa-search"></i>
                        </form>
                    </div>
                    <!-- ***** Search End ***** -->
                    <!-- ***** Menu Start ***** -->
                    <ul class="nav">
                        <li><a href="homeservlet">Home</a></li>
                        <li><a href="game">Game Steam</a></li>
                        <li><a href="contact.html">Contact</a></li>
                            <c:choose>
                                <c:when test="${sessionScope.uc != null}">
                                <!-- Nếu đăng nhập rồi thì hiển thị Logout -->
                                <li><a href="logout">Logout</a></li>
                                <li><a href="profile.html">${sessionScope.uc.userName} <img src="assets/images/profile-header.jpg" alt=""></a></li>
                                </c:when>
                                <c:otherwise>
                                <!-- Nếu chưa đăng nhập thì hiển thị Login -->
                                <li><a href="Login.jsp">Login</a></li>
                                <li><a href="#">Profile <img src="assets/images/profile-header.jpg" alt=""></a></li>
                                </c:otherwise>
                            </c:choose>
                        
                    </ul>
                    <!-- ***** Menu End ***** -->
                </nav>
            </div>
        </div>
    </div>
</header>