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

            <a type="button" href="/admin/listBooking" class="btn btn-info">List Booking</a>

            <form method="POST"  action="/admin/saveBooking" id="formBooking">

                    <input type="hidden" class="form-control" value="${booking.id}" name="${booking.id}" id="idBooking">


                <div class="form-group">
                    <label>Titre :</label>
                    <input type="text" class="form-control" value="${booking.titre}" name="titre"
                           id="titreinput">
                </div>
                <div class="form-group">
                        <label>Booking Time :</label>
                        <input type="date" class="form-control" value="${booking.booking_time}" name="booking_time"
                               id="booking_time">
                    </div>
                    <div class="form-group">
                        <label>User :</label>
                        <select class="form-control show-tick ms search-select select2" name="user" id="user">
                            <option value="">Choisir...</option>
                            <c:forEach items="${user}" var="u">
                                <option value="${u.id}" <c:if test="${u.id==booking.user.id}" > selected </c:if>  >${u.name} ${u.lastName}</option>
                            </c:forEach>
                        </select>
                    </div>

                <div class="form-group">
                        <label>Hotel :</label>
                        <select class="form-control show-tick ms search-select select2" name="hotel" id="hotel">
                            <option value="">Choisir...</option>
                            <c:forEach items="${hotel}" var="h">
                                <option value="${h.id}">${h.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                <div class="form-group">
                        <label>Prix (MAD) :</label>
                    <input type="number" name="prix" class="form-control" id="prixinput">
                </div>

                    <button type="submit" class="btn btn-success" id="submit">${submit}</button>
            </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="includes/footer.jsp" />