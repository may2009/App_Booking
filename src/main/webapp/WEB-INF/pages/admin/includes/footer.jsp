<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><%@ taglib
        prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url value="/resources/" var="resources" />



<!-- Jquery Core Js -->

<script src="/assets/bundles/vendorscripts.bundle.js"></script> <!-- slimscroll, waves Scripts Plugin Js -->

<script src="/assets/bundles/jvectormap.bundle.js"></script> <!-- JVectorMap Plugin Js -->
<script src="/assets/bundles/sparkline.bundle.js"></script> <!-- Sparkline Plugin Js -->
<script src="/assets/bundles/c3.bundle.js"></script>

<%--Upload--%>
<script src="/assets/plugins/dropify/js/dropify.min.js"></script>
<script src="/assets/plugins/sweetalert/sweetalert.min.js"></script>

<script src="/assets/bundles/mainscripts.bundle.js"></script>
<script src="/assets/js/pages/index.js"></script>
<script src="/assets/plugins/select2/select2.min.js"></script> <!-- Select2 Js -->
 <!--datatable-->


<!-- Jquery Core Js -->

<!-- Jquery DataTable Plugin Js -->
<script src="/assets/bundles/datatablescripts.bundle.js"></script>
<script src="/assets/plugins/jquery-datatable/buttons/dataTables.buttons.min.js"></script>
<script src="/assets/plugins/jquery-datatable/buttons/buttons.bootstrap4.min.js"></script>
<script src="/assets/plugins/jquery-datatable/buttons/buttons.colVis.min.js"></script>
<script src="/assets/plugins/jquery-datatable/buttons/buttons.flash.min.js"></script>
<script src="/assets/plugins/jquery-datatable/buttons/buttons.html5.min.js"></script>
<script src="/assets/plugins/jquery-datatable/buttons/buttons.print.min.js"></script>
<script src="/assets/js/pages/tables/jquery-datatable.js"></script>


<script src="/assets/bundles/fullcalendarscripts.bundle.js"></script><!--/ calender javascripts -->
<%--<script src="/assets/bundles/"></script>--%>
<!-- Custom Js -->
<script src="/assets/js/pages/calendar/calendar.js"></script>


<script src="/assets/js/sockjs.min.js"></script>
<script src="/assets/js/stomp.min.js"></script>
<script src="/assets/js/main.js"></script>



<script src="/assets/plugins/ckeditor/ckeditor.js"></script> <!-- Ckeditor -->
<script src="/assets/js/pages/forms/editors.js"></script>

 <%--upload file--%>
<script src="/assets/js/pages/forms/dropify.js"></script>


<!-- SweetAlert Plugin Js -->
<script src="/assets/js/pages/ui/sweetalert.js"></script>

<script>
    $(document).ready(function() {
        $('.select2').select2();
    });
</script>


</body>
</html>