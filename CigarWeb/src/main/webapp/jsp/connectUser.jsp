<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">  
 
<%@ page contentType="text/html; charset=UTF-8"%> 
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

 

 
<html>
<head>
<title>Cigar Store</title>	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css" media="screen" />

</head>
<body>

<f:view>
 <div id="page">

  <%@ include file="common/header.jsp" %>

   <%@ include file="common/menu.jsp" %>


<div id="wrapper">
  <div id="content">
   <form action="<%=request.getContextPath()%>/j_security_check" method="POST">


   <% // Si il y'a une erreur %>
<TABLE BORDER="0">
  <tr>
    <td class="tdmessagelogin"> 
    
	<%
		String authentificate = request.getParameter("authentificate");
			if ("false".equals(authentificate)){
			%>
       		<div id="idmessage" class="messageerreur">  
         		User with this login/password not found.
      		</div>  
    		<% } %>   
      
  		 </td>
  		</tr>
	</TABLE>

	<br/><br/>

	<table cellspacing="15">
	  <colgroup>
        <col width="100" />
        <col width="50" />
        <col width="150" />
      </colgroup>
	  <tr>
		<td> <span class="labelfield">User</span></td>
		<td>:</td>
		<td><input id="loginid" type="text" name="j_username" /></td>
	 </tr>
	 <tr>
		<td> <span class="labelfield">Password</span></td>
		<td>:</td>
		<td><input type="password" name="j_password" /></td>
	 </tr>
	 <tr>
		<td colspan="3"><center><input type="submit" value="Submit" class="styleButton" /></center></td>
	 </tr>	 
	</table>
	

	</form>

         
  </div>
  <div style="clear: both;"> </div>
  </div>

   <%@ include file="common/footer.jsp" %>


 </div>

</f:view>
</body>

</html>     