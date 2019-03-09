<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
<form action="login" method="post">
<h4 style="color: red">${err_msg}</h4>
<input type="text" placeholder="Username" name="user"><br>
<input type="password" name="pwd" placeholder="Password"><br>
<input type="submit" value="Login">
</form>
</div>
<%@ include file="common/footer.jspf" %>