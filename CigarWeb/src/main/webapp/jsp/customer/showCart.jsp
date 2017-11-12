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
    
    <h:form>
     <h:messages style="color:red;margin:8px;" />
     <br/>
 
    
    
     <h:dataTable binding="#{manageCart.dataTable}" value="#{manageCart.listCartOrderLine}" var="cigarOrderLine">
	  
	  <h:column>
	    <h:outputText value="#{cigarOrderLine.cigar.cigarLabel}" />
	  </h:column>
	  
	  <h:column>
	    <h:outputText value="#{cigarOrderLine.cigar.amount}">
	      <f:convertNumber maxFractionDigits="2"
                       groupingUsed="true"
                       currencySymbol="$"
                       maxIntegerDigits="7"
                       type="currency"/>
	    </h:outputText>
	  </h:column>
	  
	  <h:column>	  
	    <h:inputText value="#{cigarOrderLine.quantity}" size="8" />
   	  </h:column>

	  <h:column>	  
	    <h:commandLink action ="#{manageCart.modifyQuantity}">
	        <h:outputText value="Update" />
	        <f:param name="cigarId" value="#{cigarOrderLine.cigar.idCigar}" />
	    </h:commandLink>
   	  </h:column>
   	 
   	  <h:column>	 
   	     <h:outputText value="#{cigarOrderLine.subTotal}">
   	       <f:convertNumber maxFractionDigits="2"
                       groupingUsed="true"
                       currencySymbol="$"
                       maxIntegerDigits="7"
                       type="currency"/>
   	     </h:outputText>
   	  </h:column>

	  <h:column>	  
	    <h:commandLink action ="#{manageCart.removeItemToCart}">
	        <h:outputText value="Remove" />
	        <f:param name="cigarId" value="#{cigarOrderLine.cigar.idCigar}" />
	    </h:commandLink>
   	  </h:column>

	
	</h:dataTable>
	
	<br/>
	<br/>
    
    </h:form>
    
    <br/>
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