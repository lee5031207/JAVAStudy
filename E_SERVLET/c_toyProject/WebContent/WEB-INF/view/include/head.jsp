<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 모든 페이지에서 공통적으로 사용할 head 정보를 담는 페이지 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
				<!-- ContextPath 동적으로 가져오기 -->
<c:set var="context" value="${pageContext.request.contextPath}" /> 
</head>

