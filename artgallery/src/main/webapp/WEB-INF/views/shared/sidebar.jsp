<p class="lead">Shop Name</p>
<div class="list-group">

	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/show/category/${category.cat_id}/products" class="list-group-item">${category.cat_name}</a>
	</c:forEach>

</div>