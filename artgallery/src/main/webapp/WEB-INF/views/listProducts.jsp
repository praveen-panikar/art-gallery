<div class="container">
	<div class="row">

		<!-- To display side bar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- to display actual products -->
		<div class="col-md-9">

			<div class="row">

				<div class="col-lg-12">

					<c:if test="${userClickAllProducts == true}">
					
						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">/ All Products</li>

						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts == true}">
					
						<script>
							window.categoryId = '${category.pk_cat_id}';
						</script>
						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">/ Category</li>
							<li class="active">/ ${category.cat_name}</li>

						</ol>
					</c:if>
				</div>

			</div>
			
			<div class="row">
			
				<div class="col-xs-12">
				
					
					<table id="productListTable" class="table table-striped table-borderd">
					
					
						<thead>
						
							<tr>
								<th></th>
								<th>Name</th>
								<th>Price</th>
								<th></th>
							</tr>
						
						</thead>
						
						<tfoot>
						
							<tr>
								<th></th>
								<th>Name</th>
								<th>Price</th>
								<th></th>
							</tr>
						
						</tfoot>
					
					</table>
				
				</div>
			
			</div>
			

		</div>

	</div>

</div>