<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
	<div>
		<table class="table table-striped">
			<caption>Your List ToDos </caption>
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>is it Done?</th>
					<th colspan="2"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.desc}</td>
						<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
						<td>${todo.isDone}</td>
						<td><a type="button" href="/update-todo/?id=${todo.id}" class="btn-success">Update</a></td>
						<td><a type="button" href="/delete-todo/?id=${todo.id}" class="btn-warning">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<a class="button" href="add-todo">Click here </a> to add ToDo !...
	</div>	
</div>

<%@ include file="common/footer.jspf" %>