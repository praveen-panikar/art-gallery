<%@include file="../shared/flows-header.jsp" %>
	
	<div class="row">
	
	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Personal Details</h4>
			</div>
			<div class="panel-body">
				
				<div class="text-center">
					<h4>${registerModel.user.u_name} ${registerModel.user.u_username}</h4>
					<h5>Email: ${registerModel.user.u_emailid}</h5>
					<h5>Contact Number: ${registerModel.user.u_contact_number}</h5>
					<h5>Address: ${registerModel.user.u_address}</h5>
					<h5>Role: ${registerModel.user.u_role}</h5>
					
				</div>
				
				
				
			</div>
			
			<div class="panel-footer">
			
				<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary" >Edit</a>
			</div>
		
		</div>
	
	</div>
	
	</div>
		
		
		
	<div class="row">
		<div class="col-sm-4 col-sm-offset-4">
		
			<div class="text-center">
				<!--  -->
				<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-primary" >Confirm</a>
			</div>
		</div>
	
	</div>	
<%@include file="../shared/flows-footer.jsp" %>