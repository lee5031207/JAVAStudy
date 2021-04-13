<%@page import="com.kh.toy.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%-- 모든 페이지에서 공통적으로 사용할 head를 작성한 페이지 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<script type="text/javascript" src="/resources/js/common/asyncResponseError.js"></script>
<script type="text/javascript" src="/resources/js/common/urlEncoder.js"></script>
<script type="text/javascript" src="/resources/js/socket.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">

	let socket = null;
	
	document.addEventListener("DOMContentLoaded", function(){
		connectWs();
	});
	
	function connectWs(){
		
		sock = new SockJS("<c:url value='/echo' />");
		socket = sock;
		
		sock.onopen = function(){
			console.log("info: connection opened");
		}
		
		
		sock.onclose = function(){
			console.log("info: connection closed");
		}
		
		
	}
	
	function sendMsg(){
		if(socket){
			console.log("test");
			console.log("test");
			socket.send("test");
		}
	}
	
</script>
</head>
