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

  <%@ include file="../common/header.jsp" %>

   <%@ include file="../common/menu.jsp" %>


<div id="wrapper">
  <div id="content">

    <br/>
    Bonjour <h:outputText value="#{searchCategory.identifier}" />

    <br/>
    <br/>
    Your order id is     <h:outputText value="#{manageCart.idOrder}" />
    <br/>
 
    <center>Amount Total :
          <h:outputText value="#{manageCart.total}">
   	       <f:convertNumber maxFractionDigits="2"
                       groupingUsed="true"
                       currencySymbol="$"
                       maxIntegerDigits="7"
                       type="currency"/>
   	     </h:outputText>
   	</center>
  </div>
  <div style="clear: both;"> </div>
  </div>

   <%@ include file="../common/footer.jsp" %>


 </div>

</f:view>
</body>

</html>     