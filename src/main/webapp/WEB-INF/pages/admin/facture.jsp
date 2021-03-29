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
                <h2>Facture</h2>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html"><i class="zmdi zmdi-home"></i> App</a></li>
                    <li class="breadcrumb-item active">Facture</li>
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
            <div class="card widget_2">
                <div class="body">


                        <div class="col-lg-12 col-md-12 col-sm-12">

                <form method="GET"  action="/admin/facture" id="formget">
                        <div class="form-group">
                            <label>Clients :</label>
                            <select required class="form-control show-tick ms search-select select2"  name="client" id="client" style="width: 100% !important;">
                                <option value="">Choisir...</option>
                                <c:forEach items="${clients}" var="c">
                                    <option value="${c.id}">${c.name} ${c.lastName}</option>
                                </c:forEach>


                            </select>
                        </div>

                        <button type="submit" class="btn btn-success" id="submit"
                        >Rechercher</button>
                        <button type="button" class="btn btn-default"  data-dismiss="modal">Fermer</button>

                </form>
            </div>


                <%--    <div class="col-lg-12 col-md-12 col-sm-12">
                        <section class="file_manager" style="background-color: #eaeaea;padding-top: 3%">
                        <div class="body_scroll">
                            <div class="container-fluid">
                                <div class="row clearfix">
                                    <div class="col-lg-12">
                                        <div class="card">
                                            <div class="tab-content">
                                                <div class="tab-pane active" id="pdf">
                                                    <div class="row clearfix">
                                                        <div class="col-lg-3 col-md-4 col-sm-12">
                                                            <div class="card">
                                                                <div class="file">
                                                                    <a href="javascript:void(0);">
                                                                        <div class="hover">
                                                                            <button type="button" class="btn btn-icon btn-icon-mini btn-round btn-danger">
                                                                                <i class="zmdi zmdi-delete"></i>
                                                                            </button>
                                                                        </div>
                                                                        <div class="icon">
                                                                            <i class="zmdi zmdi-collection-pdf"></i>
                                                                        </div>
                                                                        <div class="file-name">
                                                                            <p class="m-b-5 text-muted">asdf  hhkj.pdf</p>
                                                                            <small>Size: 3MB <span class="date text-muted">Aug 18, 2019</span></small>
                                                                        </div>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-3 col-md-4 col-sm-12">
                                                            <div class="card">
                                                                <div class="file">
                                                                    <a href="javascript:void(0);">
                                                                        <div class="hover">
                                                                            <button type="button" class="btn btn-icon btn-icon-mini btn-round btn-danger">
                                                                                <i class="zmdi zmdi-delete"></i>
                                                                            </button>
                                                                        </div>
                                                                        <div class="icon">
                                                                            <i class="zmdi zmdi-collection-pdf"></i>
                                                                        </div>
                                                                        <div class="file-name">
                                                                            <p class="m-b-5 text-muted">asdf  hhkj.pdf</p>
                                                                            <small>Size: 3MB <span class="date text-muted">Aug 18, 2019</span></small>
                                                                        </div>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-3 col-md-4 col-sm-12">
                                                            <div class="card">
                                                                <div class="file">
                                                                    <a href="javascript:void(0);">
                                                                        <div class="hover">
                                                                            <button type="button" class="btn btn-icon btn-icon-mini btn-round btn-danger">
                                                                                <i class="zmdi zmdi-delete"></i>
                                                                            </button>
                                                                        </div>
                                                                        <div class="icon">
                                                                            <i class="zmdi zmdi-collection-pdf"></i>
                                                                        </div>
                                                                        <div class="file-name">
                                                                            <p class="m-b-5 text-muted">asdf  hhkj.pdf</p>
                                                                            <small>Size: 3MB <span class="date text-muted">Aug 18, 2019</span></small>
                                                                        </div>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-3 col-md-4 col-sm-12">
                                                            <div class="card">
                                                                <div class="file">
                                                                    <a href="javascript:void(0);">
                                                                        <div class="hover">
                                                                            <button type="button" class="btn btn-icon btn-icon-mini btn-round btn-danger">
                                                                                <i class="zmdi zmdi-delete"></i>
                                                                            </button>
                                                                        </div>
                                                                        <div class="icon">
                                                                            <i class="zmdi zmdi-collection-pdf"></i>
                                                                        </div>
                                                                        <div class="file-name">
                                                                            <p class="m-b-5 text-muted">asdf  hhkj.pdf</p>
                                                                            <small>Size: 3MB <span class="date text-muted">Aug 18, 2019</span></small>
                                                                        </div>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                    </div>--%>



                </div>
            </div>
        </div>
    </div>
</section>




<script>

    $( document ).ready(function() {
        $('#myModal').modal('show');
    });


</script>




<jsp:include page="includes/footer.jsp" />