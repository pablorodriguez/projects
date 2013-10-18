<%@ page contentType="text/html" isELIgnored="false" %>
<script type="text/javascript" src='<%=request.getContextPath()+ "/js/backbone/underscore.js"%>'></script>
<script type="text/javascript" src='<%=request.getContextPath()+ "/js/backbone/backbone.js"%>'></script>
<script type="text/javascript" src='<%=request.getContextPath()+ "/js/backbone/products.js"%>'></script>
<link href='http://fonts.googleapis.com/css?family=Montserrat+Alternates|Julius+Sans+One' rel='stylesheet' type='text/css'>

<portlet:defineObjects/>

<style>

	ul {
		margin: 0px;
	}
	
	ul li{
		list-style: none outside none;
	}
	
	.product {
	  	border-bottom: thin double #CCCCCC;
    	height: 25px;
    	margin-top: 5px;
	}
	
	.product:hover{
		background-color: #CFCDFF;
		color: white;
    	border-radius: 5px 5px 5px 5px;
    	box-shadow: 0 1px 2px rgba(0, 0, 0, 0.5);
    	font-weight: bold;
	}
	
	.products-list{
		background-color: #E8FFFF;
    	border-radius: 5px 5px 5px 5px;
    	box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.5);
    	padding: 5px;
	}
	
	.products-list h1{
		background-color: #CFCDFF;
		font-weight: bold;
		font-family: Montserrat Alternates;
    	border-radius: 5px 5px 5px 5px;
    	box-shadow: 0 1px 2px rgba(0, 0, 0, 0.5);
    	margin: 0 0 30px;
    	padding: 5px;
    	text-align: center;    	
	}
	
	.product span {
	}
	
	.product .name {
		font-family: verdana;
	    font-size: large;
	    font-style: italic;
	    margin: 5px 10px;
	}
	
	.product .brand{
		font-family: verdana;
	    font-size: medium;
	    font-style: italic;	    
	}
	
	.product .price{
		font-family: verdana;
	    font-size: medium;
	    float: right;	    
	    margin-right: 5px;	    
	}
	
</style>

<script type="text/template" id="product-template">
	<span class="name"><#= name #></span>
	<span class="brand"><#= brand #></span>
	<span class="price"><#= price #></span>
</script>

<script type="text/template" id="products-template">
	<h1>Product List</h1>
	<ul class="products"></ul>
</script>

<div id="portlet-container">	
	<div id="product-container">
	</div>
</div>
