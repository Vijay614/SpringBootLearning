<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	<div class="container">
		<form:form method="post" modelAttribute="todo">
			<form:hidden path="id"/>
			<fieldset class="form-group">
				<form:label path="desc">Enter Description:</form:label> 
				<form:input path="desc" maxlength="30" type="text" name="desc" class="form-control" required="required" />
				<form:errors path="desc" cssClass="text-warning"/>
			</fieldset>
			<fieldset class="form-group">
				<form:label path="targetDate">Enter Target Date:</form:label> 
				<form:input path="targetDate" maxlength="30" type="text" name="targetDate" class="form-control" required="required" />
				<form:errors path="targetDate" cssClass="text-warning"/>
			</fieldset>
			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
	</div>
	<script type="text/javascript">
		$('#targetDate').datepicker({
			format : 'dd/mm/yyyy'
		});
	</script>


<%@ include file="common/footer.jspf" %>