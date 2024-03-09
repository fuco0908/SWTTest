<%-- 
    Document   : Login
    Created on : 23 thg 2, 2024, 14:53:13
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css"/>


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
        <!-- ***** Header Area End ***** -->
        <link rel="stylesheet" href="assets/css/login-style.css">
        <main>
            <div class="container" id ="main" style="margin-top: -100px">
<!--                <div class="sign-up">
                     ***** sign up ***** 
                    <form action="register" method="post">
                        <h1>Create Account</h1>
                        <div class="social-container">
                            <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                            <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                        </div>
                        <p>or use your email for registration</p>
                        <c:if test="${not empty mess}">
                            <div>${mess}</div>
                        </c:if>
                        <c:if test="${not empty error}">
                            <div>${error}</div>
                        </c:if>
                        <input type="text" name="user" placeholder="Name" required="">
                        <input type="number" name="number" placeholder="Number" required="">
                        <input type="email" name="email" placeholder="Email" required="">
                        <input type="password" name="pwd" placeholder="Password" required="">
                        <button>Sign Up</button>
                    </form>
                </div>-->
                <!-- ***** Login ***** -->        
                <div class="sign-in">
                    <form action="login" method="post">
                        <h1>Sign In</h1>
                        <div class="social-container">
                            <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                            <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                            <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                        </div>
                        <p>or use your account</p>
                        <input type="text" name="user" placeholder="Email" required="">
                        <input type="password" name="pwd" placeholder="Password" required="">
                        <p class="text-danger">${mess}</p>
                        <a href="#">Forget your Password?</a>
                        <button>Sign In</button>
                    </form>
                </div>
                <div class="overlay-container">
                    <div class="overlay">
<!--                        <div class="overlay-left">
                            <h1>Wellcome Back!</h1>
                            <p>To keep connected with us please login with your personal info!</p>
                            <button id="signIn">Sign In</button>
                        </div>-->
                        <div class="overlay-right">
                            <h1>Hello, Friend!</h1>
                            <p>Enter your personal details and start journey with us!</p>
                            <button id="signUp"><a href="Register.jsp">Sign Up</a></button>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <footer>
            <div class="container-footer" style="margin-top: -90px">
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright © 2024 <a href="#">Game Hub</a> Company. All rights reserved. 

                            <br>Design: Distributed By <a>Group 3</a></p>
                    </div>
                </div>
            </div>
        </footer>


        <!-- Scripts -->
        <!-- Bootstrap core JavaScript -->
<!--        <script type="text/javascript">
            const signUpButton = document.getElementById('signUp');
            const signInButton = document.getElementById('signIn');
            const main = document.getElementById('main');

            signUpButton.addEventListener('click', () => {
                main.classList.add("right-panel-active");
            });
            signInButton.addEventListener('click', () => {
                main.classList.remove("right-panel-active");
            });
        </script>-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

        <script src="assets/js/isotope.min.js"></script>
        <script src="assets/js/owl-carousel.js"></script>
        <script src="assets/js/tabs.js"></script>
        <script src="assets/js/popup.js"></script>
        <script src="assets/js/custom.js"></script>


    </body>

</html>
