<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><%@ taglib
        prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url value="/resources/" var="resources" />

<jsp:include page="includes/head.jsp" />

<style>
    @media (min-width: 576px) {
        .modal-dialog {
            max-width: 1200px !important;
        }
    }


/*
    carousel
*/

</style>



<section class="content">
    <div class="block-header">
        <div class="row">
            <div class="col-lg-7 col-md-6 col-sm-12">
                <h2>Chambres</h2>
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
                                            <th hidden>Discription</th>
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
                                            <td hidden id="info${r.id}" >${r.description}</td>
                                            <td>${r.name}</td>
                                            <td>${r.prix}</td>
                                            <td>${r.hotel.name}</td>
                                            <td>
                                                <button type="button" onclick="detail(${r.id})" class="btn btn-succes">Images & info</button>
                                            </td>

                                            <td>
                                                <c:if test="${permission.modifier==1}">
                                                    <button type="button" class="btn btn-primary"
                                                            onclick="modifmodalroom('${r.id}')">Modifier</button>
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
<div class="modal fade" id="myModal" role="dialog" >
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <form method="POST"  action="/admin/addRoom" id="formget"  enctype="multipart/form-data">
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
                                <input type="file" name="imageFile" multiple class="dropify-fr">
                            </div>
                        </div>
                        <div class="row col-lg-12 col-md-12 col-sm-12 " id="imgroom">

                        </div>

                    </div>


                    <div class="form-group">
                        <label>Info :</label>
                        <textarea id="ckeditor" name="description"></textarea>
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


<!-- Modal Detail -->
<div class="modal fade" id="myModalDetail" role="dialog" >
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content" id="detailcontent">

            <h3 style="padding-top: 2%;padding-left: 2%"> Chambre images :</h3>
            <div class="row col-lg-12 col-md-12 col-sm-12 " style="padding-top: 2%;padding-left: 2%" id="imgcarousel">
            </div>


            <h3 style="padding-top: 2%;padding-left: 2%"> Chambre infos :</h3>
            <div class="row col-lg-12 col-md-12 col-sm-12 " style="padding-top: 2%;padding-bottom:2%;padding-left: 2%" id="detailinfo">

            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default"  data-dismiss="modal">Close</button>
            </div>

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
                $("#selecthotel").val(response.hotel.id).trigger('change');
                $("#prixinput").val(response.prix);
                CKEDITOR.instances['ckeditor'].setData(response.description);


/*
                CKEDITOR.instances.editor1.setData( response.description );
*/
/*
                $("body.cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders").html(response.description);
*/

                /*   $.each(JSON.parse(response), function(i, item) {
                   });*/


                $("#idinput").val(response.id);
                $("#idinput").attr("name","id");
                $("#submit").text("Modifier");
                $('#myModal').modal('show');
            }
        });


        $.ajax({
            type: "GET",
            url: '/admin/getImagesRoom',
            data : 'id=' + id,
            success: function(response){


                $("#imgroom").html("");

                   $.each(response, function(i, item) {
                       $("#imgroom").append(' <div class="col-lg-3 col-md-3 col-sm-3" id="imghtl'+item.id+'"> <img src="'+item.roomImagePath+'"> <a type="button" style="color: white"  class="btn btn-danger" onclick="deleteImage('+item.id+')">Supprimer</a> </div>');
                   });

                $("#submit").text("Modifier");
                $('#myModal').modal('show');
            }
        });
    }

    function deleteImage(id){

        $.ajax({
            type: "GET",
            url: '/admin/deleteImage',
            data : 'id=' + id,
            success: function(response){

                $("#imghtl"+id).hide();
            }
        });

    }

    function addmodal(){

        $("#idinput").val("");
        $("#idinput").removeAttr("id");
         $('input').val("");
        $("#selecthotel").val('').trigger('change');
        CKEDITOR.instances['ckeditor'].setData('');
        $("#submit").text("Ajouter");
        $('#myModal').modal('show');
    }


    function detail(id){


        $.ajax({
            type: "GET",
            url: '/admin/getDeatilRoom',
            data : 'id=' + id,
            success: function(response){


                $("#imgcarousel").html("");
                $("#currentsld").html("");

                $("#detailinfo").html("").append($("#info"+id).html());


                 $.each(response, function(i, item) {

                     $("#imgcarousel").append(' <div class="col-lg-3 col-md-3 col-sm-3"><div class="card"><div class="image"><img style="width: 150px" src="'+item.roomImagePath+'" alt="img" class="img-fluid"></div></div></div>');

                 });

                $('#myModalDetail').modal('show');
            }
        });

        $('#myModalDetail').modal('show');
    }

</script>





<jsp:include page="includes/footer.jsp" />