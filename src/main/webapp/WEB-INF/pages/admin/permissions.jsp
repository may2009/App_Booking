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
                <h2>Settings</h2>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html"><i class="zmdi zmdi-home"></i> App</a></li>
                    <li class="breadcrumb-item active">Settings</li>
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
                            <div class="table-responsive">
                                <table class="table table-bordered table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <th>Menu</th>
                                            <th>Ajouter</th>
                                            <th>Modifier</th>
                                            <th>Supprimer</th>
                                            <th>Afficher</th>
<%--
                                            <th>All</th>
--%>
                                        </tr>
                                    </thead>
                                    <tbody id="tbody">
                                    <c:forEach items="${page}" var="p">
                                            <tr id="tr${p.id}">
                                                <td>

                                                    <select class="form-control show-tick ms search-select select2" id="page${p.id}" onchange="checkPage(${page})"  data-placeholder="Select">
                                                                <option selected readonly value="${p.id}">${p.name}</option>
                                                        </select>
                                                </td>
                                                <td><input type="checkbox" onclick="checkaction(${p.id})" style="width: 100%" data_name="${p.id}"  class="actionadd" name="add" ></td>
                                                <td><input type="checkbox" onclick="checkaction(${p.id})" style="width: 100%" data_name="${p.id}" class="actionedit" name="edit" ></td>
                                                <td><input type="checkbox" onclick="checkaction(${p.id})" style="width: 100%" data_name="${p.id}" class="actiondelete" name="delete" ></td>
                                                <td><input type="checkbox" onclick="checkaction(${p.id})" style="width: 100%" data_name="${p.id}" class="actionafficher" name="affich" ></td>
    <%--
                                                <td><input type="checkbox" name="all" class="form-control actionall" data_name="${p.id}" onclick="checkAll(this,${p.id})" ></td>
    --%>
                                            </tr>
                                    </c:forEach>
                                    </tbody>


                                    </table>

                                <nav aria-label="...">
                                    <ul class="pagination">
                                        <li class="page-item">
                                            <span class="page-link">First</span>
                                        </li>
                                        <c:forEach  var="s"  begin = "1" end = "${size}">
                                            <li class="page-item ${s==1?"active":""}"><a class="page-link" href="#">${s}</a></li>
                                        </c:forEach>
                                        <li class="page-item">
                                            <a class="page-link" href="#">Last</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>

                    </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>




<script>
    function checkAll(o,id) {
        var boxes = document.getElementsByTagName("input");
        for (var x = 0; x < boxes.length; x++) {
            var obj = boxes[x];
            if (obj.type == "checkbox" && obj.class == "ckbx"+id) {
                if (obj.name != "check")
                    obj.checked = o.checked;
            }
        }
        checkaction(id);
    }


    function checkaction(id){

        var actionadd = "";
        var actionedit = "";
        var actiondelete = "";
        var actionafficher = "";


        $("#tr"+id+" .actionadd").is(":checked")?actionadd="1":actionadd="0";
        $("#tr"+id+" .actionedit").is(":checked")?actionedit="1":actionedit="0";
        $("#tr"+id+" .actiondelete").is(":checked")?actiondelete="1":actiondelete="0";
        $("#tr"+id+" .actionafficher").is(":checked")?actionafficher="1":actionafficher="0";


        var pageParam = $("#page"+id).val();

        if(pageParam != "") {
            $.post("/admin/addpermission", {
                    ajouter: actionadd,
                    modifier: actionedit,
                    supprimer: actiondelete,
                    afficher: actionafficher,
                    page: pageParam,
                    tout: '',
                },
                function (data) {
                    getAllMenu();
                });
        }else{
            alert("Choisir la page");
        }

    }



    function checkedaction(){
        $.get("/admin/get_checked_action", function (data) {


            $.each(data, function (index, item) {




                if(item.ajouter==1){$('#tr'+item.page.id+' .actionadd').prop('checked', true);}else{$('#tr'+item.page.id+' .actionadd').prop('checked', false);}
                if(item.modifier==1){$('#tr'+item.page.id+' .actionedit').prop('checked', true);}else{$('#tr'+item.page.id+' .actionedit').prop('checked', false);}
                if(item.supprimer==1){$('#tr'+item.page.id+' .actiondelete').prop('checked', true);}else{$('#tr'+item.page.id+' .actiondelete').prop('checked', false);}
                if(item.afficher==1){$('#tr'+item.page.id+' .actionafficher').prop('checked', true);}else{$('#tr'+item.page.id+' .actionafficher').prop('checked', false);}

                if(item.ajouter==1 && item.modifier==1 && item.supprimer==1 && item.afficher==1 )
                {
                    $('#tr'+item.page.id+' .actionall').prop('checked', true);
                }else{
                    $('#tr'+item.page.id+' .actionall').prop('checked', false);

                }

            });

         /*   $( "#menulist" ).load( " #menulist" );*/



        });
    }


        $(document).ready(function(e){
            checkedaction();
        });


</script>

<script>
    $(".page-item").click(function(){

        $(".page-item").removeClass("active");
        $(this).addClass("active");
       var pagination = $(this).text();

        $.get( "/admin/getAllPermission", { page: pagination.trim() , limit : "6"  } , function( data ) {

            $("#tbody").html("");

            $.each(data.pages, function (index, item) {
            $("#tbody").append('<tr id="tr'+item.id+'">' +
                '<td><select class="form-control show-tick ms search-select select2" id="page'+item.id+'" onchange="checkPage('+item.id+')"  data-placeholder="Select"> <option selected readonly value="'+item.id+'">'+item.name+'</option> </select> </td>' +
                '<td><input type="checkbox" onclick="checkaction('+item.id+')" style="width: 100%" data_name="'+item.id+'"  class="actionadd" name="add" ></td>' +
                '<td><input type="checkbox" onclick="checkaction('+item.id+')" style="width: 100%" data_name="'+item.id+'"  class="actionedit" name="add" ></td>' +
                '<td><input type="checkbox" onclick="checkaction('+item.id+')" style="width: 100%" data_name="'+item.id+'"  class="actiondelete" name="add" ></td>' +
                '<td><input type="checkbox" onclick="checkaction('+item.id+')" style="width: 100%" data_name="'+item.id+'"  class="actionafficher" name="add" ></td>' +
                '</tr>');
            });

            $('select').select2();
            checkedaction();
            getAllMenu();
        });
    });
</script>



<jsp:include page="includes/footer.jsp" />