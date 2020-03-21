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
	case 'Product Management':
		$('#manageProduct').addClass('active');
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
								str += '<a href="'+ window.contextRoot+ '/cart/add/'+ data+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart">Add To Cart</span></a>';

								return str;
							}
						}
						]
			
			
			
		});
	}
	
	
})