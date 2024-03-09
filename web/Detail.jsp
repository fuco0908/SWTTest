<%-- 
    Document   : Detail.jsp
    Created on : 21 thg 2, 2024, 15:30:39
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

                            <!-- ***** Featured Start ***** -->
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="feature-banner header-text">
                                        <div class="row">
                                            <div class="col-lg-4">
                                                <img src="${detail.image1}" alt="" style="border-radius: 23px;">
                                        </div>
                                        <div class="col-lg-8">
                                            <div class="thumb">
                                                <img src="${detail.image3}" alt="" style="border-radius: 23px;">
                                                <a href="${detail.link}" target="_blank"><i class="fa fa-play"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- ***** Featured End ***** -->

                        <!-- ***** Details Start ***** -->
                        <div class="game-details">
                            <div class="row">
                                <div class="col-lg-12">
                                    <h2>${detail.gameName}</h2>
                                </div>
                                <div class="col-lg-12">
                                    <div class="content">
                                        <div class="row">
                                            <div class="col-lg-6">
                                                <div class="left-info">
                                                    <div class="left">
                                                        <h4>${detail.gameName}</h4>
                                                        <span>${detail.gameGenre}</span>
                                                    </div>
                                                    <ul>
                                                        <li><i class="fa fa-star"></i> ${detail.publisher}</li>
                                                        <li><i class="fa fa-download"></i> ${detail.price}</li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="right-info">
                                                    <ul>
                                                        <li><i class="fa fa-star"></i> ${detail.os}</li>
                                                        <li><i class="fa fa-download"></i> ${detail.processor}</li>
                                                        <li><i class="fa fa-server"></i> ${detail.storage}</li>
                                                        <li><i class="fa fa-gamepad"></i> ${detail.memory}</li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="col-lg-4">
                                                <img src="${detail.image2}" alt="" style="border-radius: 23px; margin-bottom: 30px;">
                                            </div>
                                            <div class="col-lg-4">
                                                <img src="${detail.image3}" alt="" style="border-radius: 23px; margin-bottom: 30px;">
                                            </div>
                                            <div class="col-lg-4">
                                                <img src="${detail.image4}" alt="" style="border-radius: 23px; margin-bottom: 30px;">
                                            </div>
                                            <div class="col-lg-12">
                                                <p>${detail.description}</p>
                                            </div>
                                            <div class="col-lg-12">
                                                <div class="main-border-button">
                                                    <a href="#">Download Fortnite Now!</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- ***** Details End ***** -->
                        <div class="user-comments">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="heading-section">
                                        <h4><em>User Comments</em></h4>
                                    </div>
                                </div>
                            </div>
                            <!-- Single Comment -->
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="comment-list">
                                        <div class="single-comment">
                                            <div class="comment-content">
                                                <h5>User 1</h5>
                                                <span class="comment-date">January 1, 2024</span>
                                                <p>This game is amazing! I love the graphics and gameplay.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- ***** Other Start ***** -->
                        <div class="other-games">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="heading-section">
                                        <h4><em>Other Related</em> Games</h4>
                                    </div>
                                </div>
                                <c:forEach items="${listL}" var="n">
                                    <div class="col-lg-6">
                                        <div class="item">
                                            <a href="detail?gid=${n.gameID}"><img src="${n.image1}" alt="" class="templatemo-item">
                                                <h4>${n.gameName}</h4><span>${n.gameGenre}</span></a>
                                            <ul>
                                                <li><i class="fa fa-star"></i> 4.8</li>
                                                <li><i class="fa fa-download"></i> ${n.price}</li>
                                            </ul>
                                        </div>
                                    </div> 
                                </c:forEach>  
                            </div>
                        </div>
                        <!-- ***** Other End ***** -->

                    </div>
                </div>
            </div>
        </div>

        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright © 2036 <a href="#">Cyborg Gaming</a> Company. All rights reserved. 

                            <br>Design: <a href="https://templatemo.com" target="_blank" title="free CSS templates">TemplateMo</a>  Distributed By <a href="https://themewagon.com" target="_blank" >ThemeWagon</a></p>
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

