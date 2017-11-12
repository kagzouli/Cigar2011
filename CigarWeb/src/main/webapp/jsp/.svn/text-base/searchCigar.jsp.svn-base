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
	<table cellspacing="15">
	  <colgroup>
        <col width="100" />
        <col width="50" />
        <col width="150" />
        <col width="100" />
      </colgroup>
	  <tr>
		<td> <span class="labelfield">Category</span></td>
		<td>:</td>
		<td>
		  <h:selectOneMenu id="categoryId" value="#{searchCategory.categorySelected}">
		       <f:selectItems value="#{searchCategory.listCategory}"/>
			</h:selectOneMenu>
		</td>
		<td><h:commandButton value="Search" action="#{searchCategory.doSearch}" type="submit"/>
		</td>
	 </tr>
	</table>
	
	
	<br/>
	<br/>
	
	
	<h:dataTable value="#{searchCategory.listCigar}" var="cigar">
	  
	  <h:column>
	    <h:outputText value="#{cigar.cigarLabel}" />
	  </h:column>
	  
	  <h:column>
	    <h:outputText value="#{cigar.amount}">
	      <f:convertNumber maxFractionDigits="2"
                       groupingUsed="true"
                       currencySymbol="$"
                       maxIntegerDigits="7"
                       type="currency"/>
	    </h:outputText>
	  </h:column>
	  
	  <h:column>	  
	    <h:outputText value="#{cigar.leftCigar}" />
   	  </h:column>
   	 
   	  <h:column>	 
   	    <h:commandLink action="#{viewCigar.selectCigar}"> 
	       Select
	       <f:param name="cigarId" value="#{cigar.idCigar}" />
	    </h:commandLink>
   	  </h:column>
	
	</h:dataTable>
	
	</h:form>

         
  </div>
  <div style="clear: both;"> </div>
  </div>

   <%@ include file="common/footer.jsp" %>


 </div>
</f:view>

</body>

</html>     