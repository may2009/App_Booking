<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><%@ taglib
        prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url value="/resources/" var="resources" />

<jsp:include page="includes/head.jsp" />


<section class="content page-calendar">
    <div class="body_scroll">
        <div class="block-header">
            <div class="row">
                <div class="col-lg-7 col-md-6 col-sm-12">
                    <h2>Calendar</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="javascript:void(0);">App</a></li>
                        <li class="breadcrumb-item active">Calendar</li>
                    </ul>
                    <button class="btn btn-primary btn-icon mobile_menu" type="button"><i class="zmdi zmdi-sort-amount-desc"></i></button>
                </div>
                <div class="col-lg-5 col-md-6 col-sm-12">
                    <button class="btn btn-primary btn-icon float-right right_icon_toggle_btn" type="button"><i class="zmdi zmdi-arrow-right"></i></button>
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 col-lg-8 col-xl-8">
                    <div class="card">
                        <div class="body">
                            <div  class="calendarysn"></div>
                        </div>
                    </div>
                </div>
                <div class="col-md-12 col-lg-4 col-xl-4">
                    <div class="card">
                        <div class="event_list" style="overflow: scroll;height: 800px;">
                            <a href="/admin/addBooking" type="button" class="btn btn-info btn-block waves-effect" >Ajouter Réservation</a>
                        <c:forEach items="${bookings}" var="b">
                            <div class="e_list">
                                <h5 class="e_name">${b.titre} <span class="badge badge-primary float-right">${b.booking_time}</span></h5>
                                <address><i class="zmdi zmdi-pin"></i> ${b.hotel.name} - ${b.room.name}</address>
                                <p class="e_details"><strong style="color: red">Client : </strong> ${b.client.name} ${b.client.lastName} </p>
                                <p class="e_details"><strong style="color: green">Nuits : </strong> ${b.night}</p>
                                <p class="e_details"><strong style="color: #117a8b">Invité : </strong> ${b.invite}</p>
                                <c:if test="${b.invite<=2}">
                                <p class="e_details"><strong style="color: #f6bb0d">Prix : </strong> ${b.night*b.room.prix}</p>
                                </c:if>
                                <c:if test="${b.invite>2}">
                                    <p class="e_details"><strong style="color: #f6bb0d">Prix : </strong> ${b.night*b.invite*0.5*b.room.prix}</p>
                                </c:if>
                            </div>

                        </c:forEach>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="includes/footer.jsp" />