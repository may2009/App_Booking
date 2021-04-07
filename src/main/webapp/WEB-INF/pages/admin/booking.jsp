
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
                        <label>Date Début:</label>
                        <input onchange="gethotelNoReserve()" type="date" required class="form-control" value="${booking.date_debut}" name="date_debut"
                               id="date_debut">
                    </div>

                <div class="form-group">
                    <label>Date Fin:</label>
                    <input onchange="gethotelNoReserve()" required type="date" class="form-control" value="${booking.date_fin}" name="date_fin"
                           id="date_fin">
                </div>
                    <div class="form-group">
                        <label>Client :</label>
                        <select class="form-control show-tick ms search-select select2" name="client" id="client">
                            <option value="">Choisir...</option>
                            <c:forEach items="${clients}" var="u">
                                <option value="${u.id}" <c:if test="${u.id==booking.client.id}" > selected </c:if>  >${u.name} ${u.lastName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Hotel :</label>

                        <select disabled required onchange="getRoom(this)" class="form-control show-tick ms search-select select2" name="hotel" id="hotel">

                        </select>
                    </div>

                    <div class="form-group">
                        <label>Room :</label>
                        <select disabled required class="form-control show-tick ms search-select select2" name="room" id="room">


                        </select>
                    </div>

                <div class="form-group" hidden>
                        <label>Nuits :</label>
                    <input type="number" value="${booking.night}"  name="night" class="form-control" id="night">
                </div>

                <div class="form-group">
                    <label>Nombre du personnel :</label>
                    <input type="number" min="1" max="5" value="${booking.invite}" required name="invite" class="form-control" id="invite">
                </div>

                    <button type="submit"  class="btn btn-success" id="submit">${submit}</button>
            </form>

                       <%-- <button  class="btn btn-raised btn-primary waves-effect" data-type="confirm" id="warning">CLICK ME</button>--%>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script>
    function getRoom(id){
        $.ajax({
            type: "GET",
            url: '/admin/getRoomHotel',
            data : 'id=' + id.value,
            success: function(response){

                $("#room").html("");
                $("#room").append('<option selected value="">Choisir...</option>')

                $.each(response, function(i, item) {
                    $("#room").append('<option value="'+item.id+'">'+item.name+'</option>')
                });
                $("#room").select2();
                $("#room").prop('disabled', false);
            }
        });
    }

    function gethotelNoReserve(){


        var date_debut = $("#date_debut").val();
        var date_fin = $("#date_fin").val();

        var d1 = Date.parse(date_debut);
        var d2 = Date.parse(date_fin);

        if(date_debut!="" && date_fin!="" && d1< d2){
        $.ajax({
            type: "GET",
            url: '/admin/gethotelNoReserve',
            data : {date_debut: date_debut,date_fin:date_fin},
            success: function(response){

                $("#hotel").html("");
                $("#hotel").append('<option selected value="">Choisir...</option>')

                $.each(response, function(i, item) {
                    $("#hotel").append('<option value="'+item.id+'">'+item.name+'</option>')
                });
                $("#hotel").select2();
                $("#room").select2();
                $("#hotel").prop('disabled', false);

            }
        });

            const date1 = new Date(d1);
            const date2 = new Date(d2);
            const diffTime = Math.abs(date2 - date1);
            const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));

            $("#night").val(diffDays);

        }else{
            $("#warning").click();
            $("#hotel").prop('disabled', true);
            $("#hotel").prop('disabled', true);
        }
    }

</script>


<jsp:include page="includes/footer.jsp" />