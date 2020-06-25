$(function() {
	//used for active menu
	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	case 'Shopping Cart':
		$('#userModel').addClass('active');
		break;		
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
		
	}
	
	//to tackle the csrf token
	var token = $('meta[name="_csrf"]').attr('content')
	var header = $('meta[name="_csrf_header"]').attr('content')
	
	if(token.length >0 && header.length>0){
		
		$(document).ajaxSend(function(e, xhr, options){
			xhr.setRequestHeader(header,token);
		});
	}
	

	//jquery datatable
	var $table = $('#productListTable');
	
	if($table.length){
		
		//console.log('Inside the table');
		var jsonUrl = '';
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}
		else{
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';

		}
		
		
		$table.DataTable({
			
			lengthMenu: [[3,5,10,-1],['3 Records','5 Records', '10 Records', 'ALL']],
			pageLength: 5,
			
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns : [
						{
							data: 'pk_prod_id',
							bSortable: false,
							mRender: function(data, type, row){
								return '<img src"'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>'
							}
						},
				
						{
							data: 'prod_name'
						},
						{
							data: 'prod_price',
							mRender: function(data, type, row){
								return '&#8377; ' + data
							}
						},
						
						{
							data: 'pk_prod_id',
							bSortable: false,
							mRender : function(data, type, row){
								
								var str = '';
								str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open">View</span></a> &#160;';
								
								if(row.quantity<1){
									str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon-shopping-cart"></span></a>';
									
								}
								
								else{
									if(userRole == 'ADMIN'){
										str += '<a href="'+ window.contextRoot+ '/manage/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart">Edit</span></a>';

									}
									else{
										str += '<a href="'+ window.contextRoot+ '/cart/add/'+ data+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart">Add To Cart</span></a>';

									}
									
									
									
								}
								
								
								return str;
							}
						}
						]
			
			
			
		});
	}
	
	
	//dismissing the alert after 3 seconds
//	var $alert = ${'.alert'};
//	
//	if($alert.length){
//		setTimeout(function(){
//			$alert.fadeOut('slow');
//		},3000)
//	}
	
	//------------------------------------
	
	
	//data table for admin
	//
	//
	var $adminProductsTable = $('#adminProductsTable');

	if($adminProductsTable.length){
		
		//console.log('Inside the table');
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
		
		
		$adminProductsTable.DataTable({
			
			lengthMenu: [[10,30,50,-1],['10 Records','30 Records', '50 Records', 'ALL']],
			pageLength: 30,
			
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns : [
				
						{
							data: 'pk_prod_id',
						},
				
						{
							data: 'prod_code',
							bSortable: false,
							mRender: function(data, type, row){
								
								return '<img src="' + window.contextRoot
								+ '/resources/images/' + data
								+ '.jpg" class="adminDataTableImg"/>';
							}
						},
						
						{
							data: 'prod_name'
						},
						{
							data: 'prod_price',
							mRender: function(data, type, row){
								return '&#8377; ' + data
							}
						},
						
						{
							data: 'prod_status',
							mRender: function(data,type,row){
								
								var str = '';
								
								str += '<label class="switch">';
								if(data){
									str += '<input type="checkbox" checked="checked" value="'+row.id+'" />';
								}
								else{
									str += '<input type="checkbox"  value="'+row.id+'" />';
								}
								str +=	'<div class="slider"></div></label>';
								
								return str;
							}
						
						}
						,
						{
							data: 'pk_prod_id',
							bSortable: false,
							mRender: function(data,type,row){
								
								var str = '';
								
								str += '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">';
								str +=	'<span class="glyphicon-pencil">Edit</span></a>';
								
								return str;
							}
						}
						],
						
					initComplete: function(){
						
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change', function() {
							
							var checkbox = $(this);
							var check = checkbox.prop('checked');
							var dMsg = (checked)? 'You want to activate the product?':
												  'You want to deactivate the product?';
							var value = checkbox.prop('value');
							
							bootbox.confirm({
								size: 'medium',
								title: 'Product Activation & Deactivation',
								message: dMsg,
								callback: function(confirmed){
									
									if(confirmed){
										console.log(value);
										
										var activationUrl = window.contextRoot + '/manage/product/'+value+'/activation';
										$.post(activationUrl, function(data){
											bootbox.alert({
												size: 'medium',
												title: 'Information',
												message: data
											});
										});
										
										
									}
									else {
										checkbox.prop('checked',!checked);
									}
									
								}
							});
							
						});
					}
			
			
		
				});
		}
	
	
	
	//validation code for category
	var $categoryForm = $('#categoryForm');
	if($categoryForm.length) {
		
		$categoryForm.validate({
			
			rules : {
				cat_name : {
					
					required: true,
					minlength: 2
				},
				
			},
			messages :{
				
				cat_name: {
					required: 'Please add the category name!',
					minlength: 'The category name should not be less than 2 characters'
				}
			},
			errorElement: 'em',
			errorPlacement: function(error, element) {
				
				error.addClass('help-block');
				
				error.inserAfter(element);
				
			}
			
		});
		
	}
	
	//----------------
	//
	//validation for login form
	
	var $loginForm = $('#loginForm');
	if($categoryForm.length) {
		
		$loginForm.validate({
			
			rules : {
				username : {
					
					required: true,
					u_emailid: true
				},
				password:{
					required: true
				}
				
			},
			messages :{
				
				username: {
					required: 'Please enter the username!',
					u_emailid: 'Please enter valid email address'
				},
				
				password: {
					required: 'Please enter the password'
				}
			},
			errorElement: 'em',
			errorPlacement: function(error, element) {
				
				error.addClass('help-block');
				
				error.inserAfter(element);
				
			}
			
		});
		
	}
	
	//----------------
	
	
	
	
	
	
	
});




