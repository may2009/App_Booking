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
                <h2>Hotels</h2>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/admin/home"><i class="zmdi zmdi-home"></i> App</a></li>
                    <li class="breadcrumb-item active">Hotels</li>
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

                    <c:if test="${permission.ajouter==1}">
                        <button type="button" onclick="addmodal()" class="btn btn-info">Ajouter Hotel</button>
                    </c:if>

                        <div class="table-responsive">
                                <table class="table table-bordered table-striped table-hover dataTable js-exportable">
                                    <thead>
                                        <tr>
                                            <th>Hotel</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${hotel}" var="h">
                                        <tr>
                                            <td>${h.name}</td>

                                            <td>
                                                <c:if test="${permission.modifier==1}">
                                                    <button type="button" class="btn btn-primary"
                                                            onclick="modifmodalhotel('${h.id}')">Modifier</button>
                                                </c:if>
                                                <c:if test="${permission.supprimer==1}">
                                                    <a href="/admin/deleteHotel?id=${h.id}" style="color: white"
                                                       class="btn btn-sm btn-danger" type="button" id="SupBtn" >
                                                        Supprimer
                                                    </a>
                                                </c:if>
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

<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <form method="POST"  action="/admin/addHotel" id="formget">
                <div class="modal-body">
                    <input type="hidden" class="form-control"  id="idinput">
                    <div class="form-group">
                        <label>Hotel :</label>
                        <input type="text" class="form-control" name="name"
                               id="nominput">
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success" id="submit"
                    >Ajouter</button>
                    <button type="button" class="btn btn-default"  data-dismiss="modal">Close</button>
                </div>
            </form>
        </div>
    </div>
</div>


<script>
    function modifmodalhotel(id){
        $.ajax({
            type: "GET",
            url: '/admin/getOneHotel',
            data : 'id=' + id,
            success: function(response){

                $("#nominput").val(response.name);
                $("#idinput").val(response.id);
                $("#idinput").attr("name","id");

                /*   $.each(JSON.parse(response), function(i, item) {
                   });*/

                $("#submit").text("Modifier");
                $('#myModal').modal('show');
            }
        });
    }

    function addmodal(){
        /* $('input').val("");*/
        $("#submit").text("Ajouter");
        $('#myModal').modal('show');
    }

</script>

<jsp:include page="includes/footer.jsp" />