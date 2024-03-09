<%-- 
    Document   : Home
    Created on : 20 thg 2, 2024, 21:10:06
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
              rel="stylesheet">

        <title>WEB GAME</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


        <!-- Additional CSS Files -->
        <link rel="stylesheet" href="assets/css/fontawesome.css">
        <link rel="stylesheet" href="assets/css/templatemo-cyborg-gaming.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
        <!--
      
      TemplateMo 579 Cyborg Gaming
      
      https://templatemo.com/tm-579-cyborg-gaming
      
        -->
    </head>

    <body>

        <jsp:include page="Menu.jsp" ></jsp:include>
        <!-- ***** Header Area End ***** -->

        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="page-content">

                        <!-- ***** Banner Start ***** -->
                        <div class="main-banner">
                            <div class="row">
                                <div class="col-lg-7">
                                    <div class="header-text">
                                        <h6>Welcome To WEB GAME</h6>
                                        <h4><em>Browse</em> Our Popular Games Here</h4>
                                        <div class="main-button">
                                            <a href="games.html">Browse Now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- ***** Banner End ***** -->

                        <!-- ***** Most Popular Start ***** -->
                        <div class="most-popular">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="heading-section">
                                        <h4>Most Popular Right Now</h4>
                                    </div>   
                                    <div class="row">
                                        <c:forEach items="${list}" var="o">
                                            <div class="col-lg-3 col-sm-6">
                                                <div class="item">
                                                    <!-- <img src="img/Game/${o.image1}" alt="alt"/> -->
                                                    <img src="${o.image1}" alt=""><div class="game-info d-flex">
                                                    <h4 class="container-fluid item-info-left">${o.gameName}<br><span>${o.gameGenre}</span></h4>
                                                    <ul class="item-info-right">
                                                        <li><i class="fa fa-star"></i> 4.8</li>
                                                        <li><i class="fa fa-money-bill-1-wave"></i> ${o.price}</li>
                                                    </ul></div>
                                                </div>
                                            </div> 
                                        </c:forEach>
                                        <div class="col-lg-12">
                                            <div class="main-button">
                                                <a href="Detail.jsp">Discover Popular</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- ***** Most Popular End ***** -->

                        <!-- ***** Gaming Library Start ***** -->
                        <div class="gaming-library">
                            <div class="col-lg-12">
                                <div class="heading-section">
                                    <h4>VIP Member Benefits</h4>
                                </div>
                                <div class="item">
                                    abc
                                </div>
                                <div class="item">
                                    xyz
                                </div>
                                <div class="item last-item">
                                    123
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="main-button">
                                    <a href="profile.html">START MEMBERSHIP NOW!</a>
                                </div>
                            </div>
                        </div>
                        <!-- ***** Gaming Library End ***** -->
                    </div>
                </div>
            </div>
        </div>

        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright © 2024 <a href="#">Game Hub</a> Company. All rights reserved.

                            <br>Design: Distributed By <a>Group 3</a>
                        </p>
                    </div>
                </div>
            </div>
        </footer>


        <!-- Scripts -->
        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

        <script src="assets/js/isotope.min.js"></script>
        <script src="assets/js/owl-carousel.js"></script>
        <script src="assets/js/tabs.js"></script>
        <script src="assets/js/popup.js"></script>
        <script src="assets/js/custom.js"></script>


    </body>

</html>

