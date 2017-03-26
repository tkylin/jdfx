<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	request.setAttribute("path", path);
	request.setAttribute("basePath", basePath);
%>
<%
	response.setHeader("Cache-Control", "no-store"); //HTTP 1.1 
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<c:set var="ctx" value="${path}" scope="request" />
<c:set var="theme" value="gray" scope="request" />
<c:set var="appPath" value="${basePath}" scope="request"/>
<c:set var="timestamp" value="20160129110200" scope="request" />
<c:set var="easyUIVersion" value="1.5.1" scope="request" />
<script type="text/javascript">
var ctx="${ctx}";
</script>
