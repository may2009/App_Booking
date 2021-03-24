<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><%@ taglib
        prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url value="/resources/" var="resources" />

<jsp:include page="includes/head.jsp" />

<%--<section class="content page-calendar">
    <div class="body_scroll">
        <div id="username-page">
            <div class="username-page-container">
                <h1 class="title">Type your username</h1>
                <form id="usernameForm" name="usernameForm">
                    <div class="form-group">
                        <input type="text" id="name" placeholder="Username" autocomplete="off" class="form-control" />
                    </div>
                    <div class="form-group">
                        <button type="submit" class="accent username-submit">Start Chatting</button>
                    </div>
                </form>
            </div>
        </div>

        <div id="chat-page" class="hidden">
            <div class="chat-container">
                <div class="chat-header">
                    <h2>Spring WebSocket Chat Demo</h2>
                </div>
                <div class="connecting">
                    Connecting...
                </div>
                <ul id="messageArea">

                </ul>
                <form id="messageForm" name="messageForm">
                    <div class="form-group">
                        <div class="input-group clearfix">
                            <input type="text" id="message" placeholder="Type a message..." autocomplete="off" class="form-control"/>
                            <button type="submit" class="primary">Send</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>--%>
<section class="content">
    <div class="body_scroll">
        <div class="block-header">
            <div class="row">
                <div class="col-lg-7 col-md-6 col-sm-12">
                    <h2>Chat</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.html"><i class="zmdi zmdi-home"></i> App Réservation</a></li>
                        <li class="breadcrumb-item active">Chat</li>
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
                <div class="col-lg-12">
                    <div class="card">
                        <div class="chat_list">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="zmdi zmdi-search"></i></span>
                                </div>
                                <input type="text" class="form-control" placeholder="Search..." required>
                            </div>
                            <ul class="user_list list-unstyled mb-0 mt-3">

                                <c:forEach items="${users}" var="u">
                                    <li class="">
                                        <a href="javascript:void(0);">
                                            <img src="/assets/images/user.png" alt="avatar" />
                                            <div class="about">
                                                <div class="name">${u.name} ${u.lastName}</div>
                                                <div class="status me"> <i class="zmdi zmdi-circle"></i> online </div>
                                            </div>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="chat_window body">
                            <%--<div class="chat-header">
                                <div class="user">
                                    <img src="/assets/images/user.png" alt="avatar" />
                                    <div class="chat-about">
                                        <div class="chat-with">Aiden Chavez</div>
                                        <div class="chat-num-messages">already 8 messages</div>
                                    </div>
                                </div>
                                <div class="setting">
                                    <a href="javascript:void(0);" class="btn btn-sm btn-warning"><i class="zmdi zmdi-camera"></i></a>
                                    <a href="javascript:void(0);" class="btn btn-sm btn-info"><i class="zmdi zmdi-file-text"></i></a>
                                </div>
                                <a href="javascript:void(0);" class="list_btn btn btn-info btn-round float-md-right"><i class="zmdi zmdi-comments"></i></a>
                            </div>
                            <hr>
                            <ul class="chat-history">
                                <li class="clearfix">
                                    <div class="status online message-data text-right">
                                        <span class="time">10:10 AM, Today</span>
                                        <span class="name">Michael</span>
                                        <i class="zmdi zmdi-circle me"></i>
                                    </div>
                                    <div class="message other-message float-right"> Hi Aiden, how are you? How is the project coming along? </div>
                                </li>
                                <li>
                                    <div class="status message-data">
                                        <span class="name">Aiden</span>
                                        <span class="time">10:12 AM, Today</span>
                                    </div>
                                    <div class="message my-message">
                                        <p>Are we meeting today? Project has been already finished and I have results to show you.</p>
                                        <div class="attachment">
                                            <a class="w200" href="javascript:void(0);"><img src="/assets/images/image-gallery/2.jpg" alt="" class="img-fluid img-thumbnail"></a>
                                            <a class="w200" href="javascript:void(0);"><img src="/assets/images/image-gallery/5.jpg" alt="" class="img-fluid img-thumbnail"></a>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="status message-data">
                                        <span class="name">Aiden</span>
                                        <span class="time">10:31 AM, Today</span>
                                    </div>
                                    <i class="zmdi zmdi-circle" style="color: #04BE5B; font-size: 10px;"></i>
                                    <i class="zmdi zmdi-circle" style="color: #83d0a7; font-size: 10px;"></i>
                                    <i class="zmdi zmdi-circle" style="color:#DAE9DA; font-size: 10px;"></i>
                                </li>
                            </ul>
                            <div class="chat-box">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="zmdi zmdi-mail-send"></i></span>
                                    </div>
                                    <input type="text" class="form-control" placeholder="Enter text here..." required>
                                </div>
                            </div>--%>



                                    <div id="chat-page" >

                                            <ul id="messageArea">
                                                <c:forEach items="${chatMessage}" var="c" >
                                                    <c:if test="${c.sender == userConnect}">
                                                      <li class="chat-message"><i style="background-color: rgb(255, 86, 82);">${c.sender.charAt(0)}</i><span>${c.sender}</span><p>${c.content}</p></li>
                                                    </c:if>
                                                    <c:if test="${c.sender != userConnect}">
                                                        <li class="chat-message"><i style="background-color: rgb(255, 152, 0);">${c.sender.charAt(0)}</i><span>${c.sender}</span><p>${c.content}</p></li>
                                                    </c:if>
                                                </c:forEach>
                                            </ul>
                                            <form id="messageForm" name="messageForm">
                                                <div class="form-group">
                                                    <div class="input-group clearfix">
                                                        <input type="text" id="name" value="${userConnect}" hidden placeholder="Username" autocomplete="off" class="form-control" />
                                                        <input type="text" id="message" placeholder="Type a message..." autocomplete="off" class="form-control"/>
                                                        <button type="submit" class="btn btn-primary">Send</button>
                                                    </div>
                                                </div>
                                            </form>
                                    </div>


                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="includes/footer.jsp" />

<script>
    $( document ).ready(function() {
        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    });

</script>