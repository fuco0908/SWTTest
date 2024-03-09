<%-- 
    Document   : GameList
    Created on : 21 thg 2, 2024, 13:57:46
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

        <title>WEB GAME</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


        <!-- Additional CSS Files -->
        <link rel="stylesheet" href="assets/css/fontawesome.css">
        <link rel="stylesheet" href="assets/css/templatemo-cyborg-gaming.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet"href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>
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

                        <!-- ***** Featured Games Start ***** -->
                        <div class="row">
                            <div class="col-lg-8">
                                <div class="featured-games header-text">
                                    <div class="heading-section">
                                        <h4>Featured Games</h4>
                                    </div>
                                    <div class="owl-features owl-carousel">
                                        <c:forEach items="${listN}" var="n">
                                            <div class="item">
                                                <div class="thumb">
                                                    <img src="${n.image1}" alt="">
                                                    <div class="hover-effect">
                                                        <h6>2.4K Streaming</h6>
                                                    </div>
                                                </div>
                                                    <h4 class="container-fluid item-info-left">${n.gameName}<br><span>${n.gameGenre}</span></h4>
                                                <ul>
                                                    <li><i class="fa fa-star"></i> 4.8</li>
                                                    <li><i class="fa fa-download"></i> ${n.price}</li>
                                                </ul>
                                            </div> 
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="top-downloaded">
                                    <div class="heading-section">
                                        <h4>Top Downloaded</h4>
                                    </div>
                                    <ul>
                                        <li>
                                            <img src="assets/images/game-01.jpg" alt="" class="templatemo-item">
                                            <h4>Fortnite</h4>
                                            <h6>Sandbox</h6>
                                            <span><i class="fa fa-star" style="color: yellow;"></i> 4.9</span>
                                            <span><i class="fa fa-download" style="color: #ec6090;"></i> 2.2M</span>
                                            <div class="download">
                                                <a href="#"><i class="fa fa-download"></i></a>
                                            </div>
                                        </li>
                                        <li>
                                            <img src="assets/images/game-02.jpg" alt="" class="templatemo-item">
                                            <h4>CS-GO</h4>
                                            <h6>Legendary</h6>
                                            <span><i class="fa fa-star" style="color: yellow;"></i> 4.9</span>
                                            <span><i class="fa fa-download" style="color: #ec6090;"></i> 2.2M</span>
                                            <div class="download">
                                                <a href="#"><i class="fa fa-download"></i></a>
                                            </div>
                                        </li>
                                        <li>
                                            <img src="assets/images/game-03.jpg" alt="" class="templatemo-item">
                                            <h4>PugG</h4>
                                            <h6>Battle Royale</h6>
                                            <span><i class="fa fa-star" style="color: yellow;"></i> 4.9</span>
                                            <span><i class="fa fa-download" style="color: #ec6090;"></i> 2.2M</span>
                                            <div class="download">
                                                <a href="#"><i class="fa fa-download"></i></a>
                                            </div>
                                        </li>
                                    </ul>
                                    <div class="text-button">
                                        <a href="game">View All Games</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- ***** Featured Games End ***** -->

                        <!-- ***** Start Stream Start ***** -->
                        <div class="most-popular">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="row">
                                        <c:forEach items="${listL}" var="l">
                                            <div class="col-lg-3 col-sm-6">
                                                <div class="item">
                                                    <img src="${l.image1}" alt="">
                                                    <a href="detail?gid=${l.gameID}"><h4 class="container-fluid item-info-left">${l.gameName}<br><span>${l.gameGenre}</span></h4></a>
                                                    <ul>
                                                        <li><i class="fa fa-star"></i> 4.8</li>
                                                        <li><i class="fa fa-download"></i> ${l.price}</li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </c:forEach>
                                        <div class="col-lg-12">
                                            <div class="main-button">
                                                <a href="game">Discover Popular</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- ***** Start Stream End ***** -->

                        <!-- ***** Live Stream End ***** -->

                    </div>
                </div>
            </div>
        </div>

        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright © 2036 <a href="#">Cyborg Gaming</a> Company. All rights reserved. 

                            <br>Design: <a href="https://templatemo.com" target="_blank" title="free CSS templates">TemplateMo</a> Distributed By <a href="https://themewagon.com" target="_blank" >ThemeWagon</a>
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

