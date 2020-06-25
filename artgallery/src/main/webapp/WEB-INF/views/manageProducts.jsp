<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">

	<div class="row">
	
		<c:if test="${not empty message}">
		<div class="col-xs-12">
			<div class="alert alert-success alert-dismissible">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				
				${message}
				
			</div>
		</div>
		</c:if>

		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">
				<br>
				<hr>

					<h4>Product Management</h4>
				
				<hr>

				</div>

				<div class="panel-body">
					<!-- FORM ELEMENTS -->
					
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products"
						method="POST"
						enctype="multipart/form-data"
					>
					
					
						<div class="form-group">
						
							<label class="control-label col-md-4" for="prod_name">Enter Product Name:</label>
							<div class="col-md-8">
							
								<sf:input type="text" path="prod_name" id="prod_name" placeholder="Product Name" class="form-control" />
							
								<sf:errors path="prod_name" cssClass="help-block" element="em"></sf:errors>
							</div>
							
						</div>
						
						<div class="form-group">
						
							<label class="control-label col-md-4" for="prod_description">Product Description:</label>
							<div class="col-md-8">
							
								<sf:textarea type="text" path="prod_description" id="prod_description" placeholder="write a description" class="form-control"></sf:textarea>
								<sf:errors path="prod_description" cssClass="help-block" element="em"></sf:errors>
							
							</div>
							
						</div>
						
						<div class="form-group">
						
							<label class="control-label col-md-4" for="prod_price">Product Price:</label>
							<div class="col-md-8">
							
								<sf:input type="number" path="prod_price" id="prod_price" placeholder="Unit Price" class="form-control" />
								<sf:errors path="prod_price" cssClass="help-block" element="em"></sf:errors>
							
							</div>
							
						</div>
						
						<div class="form-group">
						
							<label class="control-label col-md-4" for="fk_cat_id">Select Category:</label>
							<div class="col-md-8">
							
								<sf:select class="form-control" id="fk_cat_id" path="fk_cat_id" 
									items="${categories}"
									itemLable="cat_name"
									itemValue="pk_cat_id"
								
								/>
								
								<c:if test="${product.pk_prod_id ==0}">
								
									<div class="text-right">
									<br/>
									<button type="button" data-toggle="modal" data-target="#myCategoryModal" class= btn btn-warning btn-xm>Add Category</button>
									</div>
								</c:if>
								
								
							</div>
							
						</div>
						
						<!-- FILE ELEMENT -->
						<div class="form-group">
						
							<label class="control-label col-md-4" for="file">Select and Image:</label>
							<div class="col-md-8">
							
								<sf:input type="file" path="file" id="file" class="form-control" />		
								<sf:errors path="file" cssClass="help-block" element="em"></sf:errors>
								
							</div>
							
						</div>
						
						
						
						<div class="form-group">
						
							<div class="col-md-offset-4 col-md-8">
							
								<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary" />
							
							<!-- Hidden fields for products -->
							<sf:hidden path="pk_prod_id"/>
							<sf:hidden path="prod_code"/>
							<sf:hidden path="prod_status"/>
							<sf:hidden path="fk_u_id"/>
							</div>
							
						</div>
					
					</sf:form>

				</div>
			</div>
		</div>
	</div>

<div class="row">

	<div class="col-xs-12">
		
		<h3>Available Products</h3>
		<hr/>
		<br>
	</div>
	<br>
	<div class="col-xs-12">
		<div style="overflow:auto">
				<table id="adminProductsTable" class="table table-striped table-bordered">
							
				<thead>					
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>					
				</thead>

				
				<tfoot>
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>									
				</tfoot>
				
							
			</table>
		
		</div>
	</div>

</div>

<div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">

	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class-"modal-title">Add New Category</h4>
				<button type="button" class="close" data-dismiss="modal">
					<span>&times;</span>
				</button>
				
			</div>
		
			<div class="modal-body">
				<!-- Category form -->
				<sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category"
					method="POST" class="form-horizontal">
					
					<div class="form-group">
						<label for="category_name" class="control-label col-md-4">Category Name</label>
						<div class="col-md-8">
							<sf:input type="text" path="cat_name" id="category_name" class="form-control"/>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-md-offset-4 col-md-8">
							<input type="submit" value="Add Category" class="btn btn-primary" />
						</div>
					</div>
					
					
				</sf:form>
				
				
			</div>
		</div>
	
	</div>
</div>

</div>