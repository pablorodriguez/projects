<%@ page contentType="text/html" isELIgnored="false" %>

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
	
	.input{
		margin: 5px 0;
    	overflow: auto;
    }
    
    .input form{
    	margin: 0px 5px 0px 0px;
    	float:left;
    }
    
    .input select{
    	font-size: 17px;
    }
	
</style>


<script type="application/javascript">
	jQuery(function(){
			
	});
</script>

<div id="portlet-container" ng-app="product" id="product-container">

	<div ng-controller ="ProductCtrl">
		<div class="input">
			<form ng-submit="addProduct()">		
				<input type="text" ng-model="newProduct.name"></input><input type="submit" value="Add">
				<br>
				<strong>{{newProduct.name}}</strong>				
			</form>
			<select ng-model="orderProp">
			  <option value="age">Age</option>
			  <option value="name">Name</option>
			  <option value="brand">Brand</option>
			  <option value="price">Price</option>
			</select>			
		</div>
		
		
		<div class="products-list" ng-cloak>
			<h1>Product List</h1>
			<ul class="products">
				<li ng-repeat="product in products | orderBy:orderProp" class="product">
					<span class="age">{{product.age}}</span>
					<span class="name">{{product.name}}</span>
					<span class="brand">{{product.brand}}</span>					
					<span class="price">{{product.price | currency}}</span>					
				</li>
			</ul>
		</div>
	</div>
	
	<div ng-view></div>
	
</div>
<script type="text/javascript" src='<%=request.getContextPath()+ "/js/vendors/jquery/jquery.js"%>'></script>
<script type="text/javascript" src='<%=request.getContextPath()+ "/js/vendors/angular/angular.js"%>'></script>
<script type="text/javascript" src='<%=request.getContextPath()+ "/js/vendors/angular/angular-resource.js"%>'></script>
<script type="text/javascript" src='<%=request.getContextPath()+ "/js/main.js"%>'></script>

