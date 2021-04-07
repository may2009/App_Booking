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




<script>

 function getAllMenu(){

  $("#menulist").html("");
  $("#menulist").append("<span id='spanhome'></span>");
  $("#menulist").append("<span id='spancalendar'></span>");
  $("#menulist").append("<span id='spancalendar'></span>");
  $("#menulist").append("<span id='spanclient'></span>");
  $("#menulist").append("<span id='spanhotel'></span>");
  $("#menulist").append("<span id='spanbookings'></span>");
  $("#menulist").append("<span id='spanmessages'></span>");
  $("#menulist").append("<span id='spanchat'></span>");
  $("#menulist").append("<span id='spanfacture'></span>");
  $("#menulist").append("<span id='spansettings'></span>");
  $.get("/admin/getAllMenu", function (data) {

   $.each(data, function (index, item) {
    if(item.page.id==5 && item.afficher==1){
     $("#spanhome").prepend('<li ><a href="/admin/home"><i class="zmdi zmdi-home"></i><span>Dashboard</span></a></li>');
    }
    if(item.page.id==4 && item.afficher==1){
     $("#spancalendar").append('<li ><a href="/admin/calendar"><i class="zmdi zmdi-calendar"></i><span>Clendar</span></a></li>');
    }
    if(item.page.id==1 && item.afficher==1){
     $("#spanclient").append('<li><a href="/admin/clients"><i class="zmdi zmdi-account"></i><span>Clients</span></a></li>');
    }
    if(item.page.id==3 && item.afficher==1){
     $("#spanhotel").append('<li><a href="javascript:void(0);"  class="menu-toggle"><i class="zmdi zmdi-hotel"></i><span>Hotel & Chambres</span></a>' +
             '<ul class="ml-menu">' +
             '<li><a href="/admin/hotel">Hotel</a></li>' +
             '<li><a href="/admin/room">Chambres</a></li>' +
             '</ul>' +
             '</li>');
    }
    if(item.page.id==2 && item.afficher==1){
     $("#spanbookings").append('<li><a href="/admin/listBooking"><i class="zmdi zmdi-bookmark"></i><span>Bookings</span></a></li>');
    }
    if(item.page.id==7 && item.afficher==1){
     $("#spanmessages").append('<li><a href="/admin/SendMail"><i class="zmdi zmdi-mail-send"></i><span>Messages</span></a></li>');
    }
    if(item.page.id==8 && item.afficher==1){
     $("#spanchat").append('<li><a href="/admin/chat"><i class="zmdi zmdi-tag-more"></i><span>Chat</span></a></li>');
    }
    if(item.page.id==9 && item.afficher==1){
     $("#spanfacture").append('<li><a href="/admin/client_facture"><i class="zmdi zmdi-format-list-bulleted"></i><span>Facture</span></a></li>');
    }
    if(item.page.id==6 && item.afficher==1){
     $("#spansettings").append('<li><a href="/admin/permissions"><i class="zmdi zmdi-settings"></i><span>Settings</span></a></li>');
    }



   });


   $('.menu-toggle').on('click', function(e) {
    var $this = $(this);
    var $content = $this.next();

    if ($($this.parents('ul')[0]).hasClass('list')) {
     var $not = $(e.target).hasClass('menu-toggle') ? e.target : $(e.target).parents('.menu-toggle');

     $.each($('.menu-toggle.toggled').not($not).next(), function(i, val) {
      if ($(val).is(':visible')) {
       $(val).prev().toggleClass('toggled');
       $(val).slideUp();
      }
     });
    }

    $this.toggleClass('toggled');
    $content.slideToggle(320);
   });

  });
 }

 $(document).ready(function(e) {
  getAllMenu();
 });



</script>