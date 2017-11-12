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
    
     <h:messages id="messageError" style="color:red;margin:8px;" />
     <br/>

    <h:form id="idForm">
 
    
     <h:dataTable id="dataTableId" binding="#{manageCart.dataTable}" value="#{manageCart.listCartOrderLine}" var="cigarOrderLine">
	  
	  <h:column id="cigarLabelId">
	    <h:outputText value="#{cigarOrderLine.cigar.cigarLabel}" />
	  </h:column>
	  
	  <h:column id="amountId">
	    <h:outputText value="#{cigarOrderLine.cigar.amount}">
	      <f:convertNumber maxFractionDigits="2"
                       groupingUsed="true"
                       currencySymbol="$"
                       maxIntegerDigits="7"
                       type="currency"/>
	    </h:outputText>
	  </h:column>
	  
	  <h:column id="quantityId">	  
	    <h:inputText value="#{cigarOrderLine.quantity}" size="8" />
   	  </h:column>

	  <h:column id="modifyQuantityId">	  
	    <h:commandLink action ="#{manageCart.modifyQuantity}">
	        <h:outputText value="Update" />
	        <f:param name="cigarId" value="#{cigarOrderLine.cigar.idCigar}" />
	    </h:commandLink>
   	  </h:column>
   	 
   	  <h:column id="subTotalId">	 
   	     <h:outputText value="#{cigarOrderLine.subTotal}">
   	       <f:convertNumber maxFractionDigits="2"
                       groupingUsed="true"
                       currencySymbol="$"
                       maxIntegerDigits="7"
                       type="currency"/>
   	     </h:outputText>
   	  </h:column>

	</h:dataTable>
	
	<br/>
    <br/>
    <center>Sub amount Total :
          <h:outputText value="#{manageCart.subTotal}">
   	       <f:convertNumber maxFractionDigits="2"
                       groupingUsed="true"
                       currencySymbol="$"
                       maxIntegerDigits="7"
                       type="currency"/>
   	     </h:outputText>
   	</center>
	
	<br/>
	
	<h:selectOneMenu id="selectCodeId" value="#{manageCart.shippingCode}"  onchange="submit()">
	  <f:selectItem itemValue="-1" itemLabel="" />
	  <f:selectItem itemValue="FM" itemLabel="Freight Movers" />
	  <f:selectItem itemValue="IS" itemLabel="International Shipping" />
	</h:selectOneMenu>
	
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
	
	
	<br/>
	<br/>
	
	<center><h1>Customer</h1></center>
	
	<br/>
	
	Nom     : <h:inputText value="#{manageCart.customer.nom}" readonly="true" />
	<br/>
	Prenom  : <h:inputText value="#{manageCart.customer.prenom}" readonly="true" />
	<br/>
	Address : <h:inputText value="#{manageCart.customer.address.adress}" readonly="true" />
	<br/>
	City    : <h:inputText value="#{manageCart.customer.address.city}" readonly="true" />
    
    <br/>
    <br/>
    <center><h1>Credit Card</h1></center>
    <br/>
	Type     : <h:selectOneMenu id="creditCardTypeId" value="#{manageCart.creditCard.creditCardType}" >
	           
	              <f:selectItem itemValue="visa" itemLabel="Visa" />
	              <f:selectItem itemValue="visa_gold" itemLabel="Visa Gold" />
	              <f:selectItem itemValue="master" itemLabel="Master Card" />
	              <f:selectItem itemValue="american" itemLabel="American Express" />	              
	           </h:selectOneMenu>
	<br/>
	Number   : <h:inputText id="creditCardNumberId" value="#{manageCart.creditCard.creditCardNumber}" />
	<br/>
	Exp Date : <h:inputText id="expirationDateId" value="#{manageCart.creditCard.expirationDate}" />
    
    <br/>
    <br/>
    <center><h:commandButton id="sendOrderId" value="Send order" action="#{manageCart.sendOrder}" type="submit" /></center>
    
    </h:form>
    
   </div>
  <div style="clear: both;"> </div>
  </div>

   <%@ include file="../common/footer.jsp" %>


 </div>

</f:view>
</body>

</html>     