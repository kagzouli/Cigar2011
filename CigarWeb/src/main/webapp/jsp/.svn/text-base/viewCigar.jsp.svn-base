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
    <h:form>
    
    <br/>
    <br/>
    
    <h:messages style="color:red;margin:8px;" />
    
    <br/>
	<table cellspacing="15">
	  <colgroup>
        <col width="150" />
        <col width="50" />
        <col width="250" />
      </colgroup>
	  <tr>
		<td> <span class="labelfield">Label</span></td>
		<td>:</td>
		<td>
		   <h:outputText value="#{viewCigar.cigar.cigarLabel}" />
		</td>
	 </tr>
     <tr>
		<td> <span class="labelfield">Description</span></td>
		<td>:</td>
		<td>
		   <h:outputText value="#{viewCigar.cigar.description}" />
		</td>
	 </tr>
     <tr>
		<td> <span class="labelfield">Creation Date</span></td>
		<td>:</td>
		<td>
		   <h:outputText value="#{viewCigar.cigar.creationDate}">
		      <f:convertDateTime pattern="dd/MM/yyyy" /> 
		   </h:outputText>
		</td>
	 </tr>
	  <tr>
		<td> <span class="labelfield">Amount</span></td>
		<td>:</td>
		<td>
		 <h:outputText value="#{viewCigar.cigar.amount}">
	      <f:convertNumber maxFractionDigits="2"
                       groupingUsed="true"
                       currencySymbol="$"
                       maxIntegerDigits="7"
                       type="currency"/>
	    </h:outputText>
		</td>
	 </tr>
	  <tr>
		<td> <span class="labelfield">Left cigar</span></td>
		<td>:</td>
		<td>
		   <h:outputText value="#{viewCigar.cigar.leftCigar}" />
		</td>
	 </tr>


	</table>
	
	<br/>
	</br>
	<center>
	   <h:commandLink action="#{manageCart.addItemToCart}"> 
	       Add Cigar to cart
	       <f:param name="cigarId" value="#{viewCigar.cigar.idCigar}" />
	    </h:commandLink>
	</center>
	
	</h:form>

         
  </div>
  <div style="clear: both;"> </div>
  </div>

   <%@ include file="common/footer.jsp" %>


 </div>
</f:view>

</body>

</html>     