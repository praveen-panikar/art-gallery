	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <!-- Brand/logo -->
	  <a class="navbar-brand" href="${contextRoot}/home">Art Gallery</a>
	 
	  <!-- Links -->
	  <ul class="navbar-nav">
	    <li class="nav-item" id="home">
	      <a class="nav-link" href="${contextRoot}/home">Home</a>
	    </li>
	    <li class="nav-item" id="listProducts">
	      <a class="nav-link" href="${contextRoot}/show/all/products">Arts</a>
	    </li>
	    
	    <security:authorize access="hasAuthority('ADMIN')">
	    <li class="nav-item" id="manageProducts">
	      <a class="nav-link" href="${contextRoot}/manage/products">Manage Products</a>
	    </li>
	    
	    </security:authorize>
	    
	    <li class="nav-item" id="about">
	      <a class="nav-link" href="${contextRoot}/about">About Us</a>
	    </li>
	    <li class="nav-item" id="contact">
	      <a class="nav-link" href="${contextRoot}/contact">Contact Us</a>
	    </li>
	  </ul>
	  
	  <!-- nav navbar-nav navbar-right -->
	 
	  <ul class="nav navbar-nav ml-auto">
	  	<security:authorize access="isAnonymous()">
	  		<li  id="register">
	      		<a class="nav-link" href="${contextRoot}/register">Sign Up</a>
	    	</li>
	    	
	    	<li id="login">
	      		<a class="nav-link" href="${contextRoot}/login">Login</a>
	    	</li>
	    	</security:authorize>
	    	
	    	
	    	<security:authorize access="isAuthenticated()" >
	    	<li class="dropdown">
	    		<a href="javascript:void(0)"
	    		class="btn btn-default dropdown-toggle nav-link"
	    		id="dropdownMenu1"
	    		data-toggle="dropdown"
	    		>
	    		${userModel.fullName}
	    			<span class="caret"></span>
	    		</a>
	    		
	    		<ul class="dropdown-menu">
	    		
	    			<security:authorize access="hasAuthority('USER')">
	    			<li>
	    			<a href="${contextRoot}/cart/show">
	    				<span class="glyphicon glyphicon-shopping-cart">Cart</span>
	    				<span class="badge">${userModel.cart.cartLines}</span>
	    				-&#8377; ${userModel.cart.grandTotal}
	    			</a>
	    			</li>
	    			<li class="divider" role="seperator"></li>
	    			</security:authorize>
	    			
	    			<li>
	    			
	    				<a href="${contextRoot}/perform-logout">Logout</a>
	    			
	    			</li>
	    		
	    		</ul>
	    	</li>
	    	</security:authorize>
	  </ul>
	</nav>
	
	<script>
		window.userRole = '${userModel.role}';
	</script>