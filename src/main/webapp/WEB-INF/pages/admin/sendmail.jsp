<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><%@ taglib
        prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url value="/resources/" var="resources" />

<jsp:include page="includes/head.jsp" />


<section class="content">
    <div class="block-header">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12">
            <div class="card">
                <div class="header">
                    <h2><strong>Boit</strong> Reception</h2>
                </div>
                <div class="body">

            <form  action="/admin/send" method="post">
                <div class="form-group">
                    <label>Email <strong style="color: red">*</strong></label>
                    <input type="email" name="toemail" required id="toemailSendMail" class="form-control" placeholder="Email">
                </div>
                <div class="form-group">
                    <label>Sujet <strong style="color: red">*</strong></label>
                    <input type="text" name="subject" required id="subjectSendMail" class="form-control" placeholder="Sujet">
                </div>
                    <div class="form-group">
                        <label>Message <strong style="color: red">*</strong></label>
                        <textarea name="message" required id="messageSendMail" class="form-control" placeholder="Message"></textarea>
                    </div>

                <button type="submit" class="btn btn-danger" > Envoyer </button>
            </form>
                </div>
            </div>
        </div>
        </div>
    </div>
</section>




<jsp:include page="includes/footer.jsp" />