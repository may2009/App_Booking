<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><%@ taglib
        prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url value="/resources/" var="resources" />

<jsp:include page="includes/head.jsp" />

<section class="content">
    <div class="block-header">
        <div class="row">
            <div class="col-lg-7 col-md-6 col-sm-12">
                <h2>Bookings</h2>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/admin/home"><i class="zmdi zmdi-home"></i> App</a></li>
                    <li class="breadcrumb-item active">Bookings</li>
                </ul>
                <button class="btn btn-primary btn-icon mobile_menu" type="button"><i class="zmdi zmdi-sort-amount-desc"></i></button>
            </div>
            <div class="col-lg-5 col-md-6 col-sm-12">
                <button class="btn btn-primary btn-icon float-right right_icon_toggle_btn" type="button"><i class="zmdi zmdi-arrow-right"></i></button>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12">
                <div class="card widget_2">
                    <div class="body">

                        <a type="button" href="/admin/addBooking" class="btn btn-info">Ajouter Booking</a>

                            <div class="table-responsive">
                                <table class="table table-bordered table-striped table-hover dataTable js-exportable">
                            <thead>
                            <tr>
                                <th>Titre</th>
                                <th>Booking Time</th>
                                <th>User</th>
                                <th>hotel</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${booking}" var="b">
                                <tr>
                                    <td>${b.titre}</td>
                                    <td>${b.booking_time}</td>
                                    <td>${b.user.name} ${b.user.lastName}</td>
                                    <td>${b.hotel.name}</td>
                                    <td>
                                        <a type="button" class="btn btn-primary" style="color: white"
                                                href="/admin/editBooking?id=${b.id}">Modifier</a>
                                        <a href="/admin/deleteBooking?id=${b.id}" style="color: white"
                                           class="btn btn-sm btn-danger" type="button" id="SupBtn" >
                                            Supprimer
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="includes/footer.jsp" />