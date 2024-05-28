<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>New User Registration</title>
        <link rel="stylesheet" type="text/css" href="CSS/Home.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <header>
            <script>
                function openNav(){
                    document.getElementById("sidenav").style.width="250px";
                    document.getElementById("newMain").style.marginLeft="250px";
                    document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
                }
                function closeNav(){
                    document.getElementById("sidenav").style.width="0";
                    document.getElementById("newMain").style.marginLeft= "0";
                    document.body.style.backgroundColor = "white";
                }
            </script>
            
            <%//Uppar Side bar %>
            <div class="main" id="newMain">
                <div class="navigation">
                    <nav class="navbartop">
                        <span style="font-size: 30px; cursor: pointer; margin-left: 20px; margin-right: 20px;" onclick="openNav()" >&#9776</span>
                        <a href="Login.jsp"><i class="fa fa-fw fa-user"></i> Login</a>
                        <a href=getEmail.jsp><i class="fa fa-address-card-o"></i> Register</a>
                        <a href=Add_Items.jsp><i class="fa fa-money"></i> Pay Bill</a>
                        <a href=cart.jsp><i class="fa fa-shopping-cart" aria-hidden="true"></i> Cart</a>
                    </nav>  
                </div>
            </div>
        </header>
        <div>
            <div id="sidenav" class="sidebar">
                <h1>Go To <i class="fa fa-arrow-circle-right"></i></h1>
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                <a href="Add_Items.jsp"><i class="fa fa-home"></i> Make Payment</a>
                <a href="Login.jsp"><i class="fa fa-address-card-o"></i> Login</a>
                <a href="getEmail.jsp"><i class="fa fa-address-card-o"></i> New Register</a>
            </div>
        </div>

    </body>
</html>
