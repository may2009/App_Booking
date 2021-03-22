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
                <h2>Users</h2>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html"><i class="zmdi zmdi-home"></i> App</a></li>
                        <li class="breadcrumb-item active">Users</li>
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
                    <button type="button" class="btn btn-success"
                            onclick="addmodal()">Ajouter User</button>
                </c:if>


               <%-- <a type="button" href="/admin/addBooking" class="btn btn-info">Ajouter Booking</a>--%>

                            <div class="table-responsive">
                                <table class="table table-bordered table-striped table-hover dataTable js-exportable">
                                    <thead>
                                    <tr>
                                        <th>Nom</th>
                                        <th>Prénom</th>
                                        <th>Paye</th>
                                        <th>Date Naissance</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                     <c:forEach items="${All}" var="v">
                                        <tr>
                                            <td>${v.name}</td>
                                            <td>${v.lastName}</td>
                                            <td>${v.paye}</td>
                                            <td>${v.dateNaissance}</td>
                                            <td>
                                                <c:if test="${permission.modifier==1}">
                                                    <button type="button" class="btn btn-primary"
                                                            onclick="modifmodal('${v.id}')">Modifier</button>
                                                </c:if>
                                                <c:if test="${permission.supprimer==1}">
                                                    <a href="/admin/deleteUser?id=${v.id}" style="color: white"
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
                <form method="POST"  action="/admin/add" id="formget">
                    <div class="modal-body">
                        <input type="hidden" class="form-control"  id="idinput">
                        <div class="form-group">
                            <label>Nom :</label>
                            <input type="text" class="form-control" name="name"
                                   id="nominput">
                        </div>
                        <div class="form-group">
                            <label>Prénom :</label>
                            <input type="text" class="form-control" name="lastName"
                                   id="prenominput" >
                        </div>
                        <div class="form-group">
                            <label>Date de naissance :</label>
                            <input type="date" class="form-control" name="dateNaissance"
                                   id="dateNaissanceinput" >
                        </div>

                        <div class="form-group">
                            <label>Pays :</label>
                            <select class="form-control show-tick ms search-select select2"  name="paye" id="payeinput" style="width: 100% !important;">
                                <option value="">Choisir...</option>
                            </select>
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
        function modifmodal(id){
            $.ajax({
                type: "GET",
                url: '/admin/getOneUseser',
                data : 'id=' + id,
                success: function(response){

                        $("#dateNaissanceinput").val(response.dateNaissance);
                        $("#payeinput").val(response.paye);
                        $("#nominput").val(response.name);
                        $("#prenominput").val(response.lastName);
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


        //pays api

        $.get( "https://restcountries.eu/rest/v2/all", function( data ) {

            $.each(data, function (index, item) {
                $("#payeinput").append("<option value='"+item.name+"'>"+item.name+"</option>")
            });
        });





    </script>
    </body>

<jsp:include page="includes/footer.jsp" />