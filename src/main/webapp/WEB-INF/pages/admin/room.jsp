<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><%@ taglib
        prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url value="/resources/" var="resources" />

<jsp:include page="includes/head.jsp" />

<style>
    @media (min-width: 576px){
        .modal-dialog {
            max-width: 1200px !important;
        }
</style>

<section class="content">
    <div class="block-header">
        <div class="row">
            <div class="col-lg-7 col-md-6 col-sm-12">
                <h2>Hotels</h2>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/admin/home"><i class="zmdi zmdi-home"></i> App</a></li>
                    <li class="breadcrumb-item active">Chambres</li>
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
                        <button type="button" onclick="addmodal()" class="btn btn-info">Ajouter Chambre</button>
                    </c:if>

                        <div class="table-responsive">
                                <table class="table table-bordered table-striped table-hover dataTable js-exportable">
                                    <thead>
                                        <tr>
                                            <th>Chambre</th>
                                            <th>Prix</th>
                                            <th>Hotel</th>
                                            <th>Image & info</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${room}" var="r">
                                        <tr>
                                            <td>${r.name}</td>
                                            <td>${r.prix}</td>
                                            <td>${r.hotel.name}</td>
                                            <td><button class="btn btn-success"><i class=""></i></button></td>

                                            <td>
                                                <c:if test="${permission.modifier==1}">
                                                    <button type="button" class="btn btn-primary"
                                                            onclick="modifmodalhotel('${r.id}')">Modifier</button>
                                                </c:if>
                                                <c:if test="${permission.supprimer==1}">
                                                    <a href="/admin/deleteRoom?id=${r.id}" style="color: white"
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
            <form method="POST"  action="/admin/addRoom" id="formget">
                <div class="modal-body">
                    <input type="hidden" class="form-control"  id="idinput">
                    <div class="row col-lg-12 col-md-12 col-sm-12 ">
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="form-group">
                                <label>Room :</label>
                                <input type="text" class="form-control" name="name"
                                       id="nominput">
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                        <div class="form-group">
                            <label>Hotel :</label>
                            <select class="form-control select2" name="hotel" id="selecthotel" >
                                <option value="" >Choisir...</option>
                                <c:forEach items="${hotel}" var="h">
                                    <option value="${h.id}" > ${h.name} </option>
                                </c:forEach>

                            </select>
                        </div>
                    </div>
                    </div>

                    <div class="row col-lg-12 col-md-12 col-sm-12 ">
                        <div class="col-lg-6 col-md-6 col-sm-6 ">
                            <div class="form-group">
                                <label>Prix :</label>
                                <input type="text" class="form-control" name="prix"
                                       id="prixinput">
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6 ">
                            <div class="form-group">
                                <label>Images :</label>
                                <input type="file" multiple class="dropify-fr">
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <label>Info :</label>
                        <textarea id="ckeditor" name="description">
                                <h2>WYSIWYG Editor</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam ullamcorper sapien non nisl facilisis bibendum in quis tellus. Duis in urna bibendum turpis pretium fringilla. Aenean neque velit, porta eget mattis ac, imperdiet quis nisi. Donec non dui et tortor vulputate luctus. Praesent consequat rhoncus velit, ut molestie arcu venenatis sodales.</p>
                                <h3>Lacinia</h3>
                                <ul>
                                    <li>Suspendisse tincidunt urna ut velit ullamcorper fermentum.</li>
                                    <li>Nullam mattis sodales lacus, in gravida sem auctor at.</li>
                                    <li>Praesent non lacinia mi.</li>
                                    <li>Mauris a ante neque.</li>
                                    <li>Aenean ut magna lobortis nunc feugiat sagittis.</li>
                                </ul>
                                <h3>Pellentesque adipiscing</h3>
                                <p>Maecenas quis ante ante. Nunc adipiscing rhoncus rutrum. Pellentesque adipiscing urna mi, ut tempus lacus ultrices ac. Pellentesque sodales, libero et mollis interdum, dui odio vestibulum dolor, eu pellentesque nisl nibh quis nunc. Sed porttitor leo adipiscing venenatis vehicula. Aenean quis viverra enim. Praesent porttitor ut ipsum id ornare.</p>
                            </textarea>
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
    function modifmodalroom(id){
        $.ajax({
            type: "GET",
            url: '/admin/getOneRoom',
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