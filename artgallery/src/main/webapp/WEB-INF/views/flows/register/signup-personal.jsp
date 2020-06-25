<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../shared/flows-header.jsp" %>

		<div class="content">
			<div class="container">
			
			<div class="row">
			
			<div class="col-md-6 col-md-offset-3">
				
				<div class="panel panel-primary">
				
					<div class="panel-heading">
						<h4>Sign Up - Personal</h4>
					</div>
					
					<div class="panel-body">
										
						<sf:form
							method="POST"
							modelAttribute="user"
							class="form-horizontal"
							id="registerForm"
						>
						
							
							<div class="form-group">
								<label class="control-label col-md-4">Name</label>
								<div class="col-md-8">
									<sf:input type="text" path="u_name" class="form-control"
										placeholder="Name" />
									<sf:errors path="u_name" cssClass="help-block" element="em"></sf:errors>
								</div>
							</div>


							<div class="form-group">
								<label class="control-label col-md-4">User Name</label>
								<div class="col-md-8">
									<sf:input type="text" path="u_username" class="form-control"
										placeholder="User Name" />
									<sf:errors path="u_username" cssClass="help-block" element="em"></sf:errors>
									
								</div>
							</div>
						
							<div class="form-group">
								<label class="control-label col-md-4">Email</label>
								<div class="col-md-8">
									<sf:input type="text" path="u_emailid" class="form-control"
										placeholder="abc@zyx.com" />
									<sf:errors path="u_emailid" cssClass="help-block" element="em"></sf:errors>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Contact Number</label>
								<div class="col-md-8">
									<sf:input type="text" path="u_contact_number" class="form-control"
										placeholder="XXXXXXXXXX" maxlength="10" />
									<sf:errors path="u_contact_number" cssClass="help-block" element="em"></sf:errors>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4">Password</label>
								<div class="col-md-8">
									<sf:input type="password" path="u_password" class="form-control"
										placeholder="Password" />
									<sf:errors path="u_password" cssClass="help-block" element="em"></sf:errors>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4">Confirm Password</label>
								<div class="col-md-8">
									<sf:input type="password" path="confirmPassword class="form-control"
										placeholder="Re-enter Password" />
									<sf:errors path="confirmPassword" cssClass="help-block" element="em"></sf:errors>
								</div>
							</div>
							
							
							
							
							<div class="form-group">
								<label class="control-label col-md-4">Address</label>
								<div class="col-md-8">
									<sf:input type="text" path="u_address" class="form-control"
										placeholder="Address" />
									<sf:errors path="u_address" cssClass="help-block" element="em"></sf:errors>									 
								</div>
							</div>
							
							
							
							

<!-- Radio BUtton -->							
	<div class="form-group">
		<label class="control-label col-md-4">Select Role</label>
		<div class="col-md-8">
			<label class="radio-inline">
				<sf:radiobutton path="u_role" value="USER" checked="checked"/> User 				
			</label>
			<label class="radio-inline">
				<sf:radiobutton path="u_role" value="ARTIST"/> Artist
			</label>
		</div>
	</div>							

							<div class="form-group">
								<div class="col-md-offset-4 col-md-8">
									<button type="submit" name="_eventId_confirm" class="btn btn-primary">
										Next - Confirm <span class="glyphicon glyphicon-chevron-right"></span>
									</button>																	 
								</div>
							</div>
						
						
						</sf:form>					
					
					
					</div>
				
				
				</div>
			
			
			</div>
		
			
			
			</div>
			
		</div>

		
<%@include file="../shared/flows-footer.jsp" %>