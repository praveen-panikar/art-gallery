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
						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>

						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts == true}">
						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">/ Category</li>
							<li class="active">/ ${category.cat_name}</li>

						</ol>
					</c:if>
				</div>

			</div>

		</div>

	</div>

</div>