<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><%@ taglib
        prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url value="/resources/" var="resources" />




<!doctype html>
<html class="no-js " lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <meta name="description" content="Responsive Bootstrap 4 and web Application ui kit.">

    <title>:: Aero Bootstrap4 Admin :: Sign In</title>
    <!-- Favicon-->
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <!-- Custom Css -->
    <link rel="stylesheet" href="/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/style.min.css">
</head>

<body class="theme-blush">

<div class="authentication">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-sm-12">



                <form  action="/registration" method="post" class="form-horizontal"
                                  role="form">
                                <h2>Registration Form</h2>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <%--<label th:if="${#fields.hasErrors('name')}" th:errors="*{name}"
                                               class="validation-message"></label>--%>
                                        <input type="text" placeholder="Name" name="name"
                                               class="form-control"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-sm-12">
                                      <%--  <label th:if="${#fields.hasErrors('lastName')}" th:errors="*{lastName}"
                                               class="validation-message"></label>--%>
                                        <input type="text"
                                               placeholder="Last Name" class="form-control" name="lastName"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <input type="text" placeholder="Email"
                                               class="form-control" name="email"/>
                                        <%--<label
                                            th:if="${#fields.hasErrors('email')}" th:errors="*{email}"
                                            class="validation-message"></label>--%>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <input type="text" placeholder="User Name"
                                               class="form-control" name="userName"/>
                                        <%--<label
                                            th:if="${#fields.hasErrors('userName')}" th:errors="*{userName}"
                                            class="validation-message"></label>--%>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <input type="password"
                                               placeholder="Password" class="form-control" name="password"/>
                                        <%--<label
                                            th:if="${#fields.hasErrors('password')}" th:errors="*{password}"
                                            class="validation-message"></label>--%>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn btn-primary btn-block">Register User</button>
                                    </div>
                                </div>

                                <h2><span class="text-success" th:utext="${successMessage}"></span></h2>

                            </form>

                <form action="/" method="get">
                    <button class="btn btn-md btn-warning btn-block" type="Submit">Go To Login Page</button>
                </form>
                <div class="copyright text-center">
                    &copy;
                    <script>document.write(new Date().getFullYear())</script>
                </div>
            </div>
            <div class="col-lg-8 col-sm-12">
                <div class="card">
                    <img src="/assets/images/signup.svg" alt="Sign In"/>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Jquery Core Js -->
<script src="/assets/bundles/libscripts.bundle.js"></script>
<script src="/assets/bundles/vendorscripts.bundle.js"></script> <!-- Lib Scripts Plugin Js -->
</body>
</html>
