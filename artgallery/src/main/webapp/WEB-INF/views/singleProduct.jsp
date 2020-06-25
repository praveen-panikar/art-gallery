<div class="container">

	<!-- Breadcrumb -->
	<div class="row">
		
		<div class="col-xs-12">
		
			
			<ol class="breadcrumb">
			
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">/ Products</a></li>
				<li class="active">/ ${product.prod_name}</li>
			
			</ol>
		
		
		</div>
		
	<div class="row">
	
		<!-- Display the product image -->
		<div class="col-xs-12 col-sm-4">
		
			<div class="thumbnail">
							
				<img src="${images}/${product.pk_prod_id}.jpg" class="img img-responsive"/>
						
			</div>
		
		</div>
	
		
		<!-- Display the product description -->	
		<div class="col-xs-12 col-sm-8">
		
			<h3>${product.prod_name}</h3>
			<hr/>
			
			<p>${product.prod_description}</p>
			<hr/>
			
			<h4>Price: <strong> &#8377; ${product.prod_price} /-</strong></h4>
			<hr/>
			
			<security:authorize access="hasAuthority('USER')">
			<a href="${contextRoot}/cart/add/${product.pk_prod_id}/product" class="btn btn-success">
				<span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</a>
			</security:authorize>
				
				
			<security:authorize access="hasAuthority('ADMIN')">
				<a href="${contextRoot}/manage/${product.pk_prod_id}/product" class="btn btn-success">
				<span class="glyphicon glyphicon-shopping-pencil"></span> Edit</a>
			
			</security:authorize>
		</div>
	
	
	</div>
	
</div>