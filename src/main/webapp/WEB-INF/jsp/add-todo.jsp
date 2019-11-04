<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>First Web Application</title>
    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form:form method="post" modelAttribute="addToDo">
        <form:hidden path="id"/>
        <fieldset class="form-group">
            <form:label cssStyle="font-size: large; font-weight: bold" path="desc">Description: </form:label>
            <form:input path="desc" type="text" class="form-control" required="required"/>
            <form:errors path="desc" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="form-group">
            <form:label cssStyle="font-size: large; font-weight: bold" path="deadline">Deadline: </form:label>
            <form:input path="deadline" type="text" class="form-control" required="required"/>
            <form:errors path="deadline" cssClass="text-warning"/>
        </fieldset>
        <button type="submit" class="btn btn-success">Add ToDo</button>
    </form:form>
</div>
<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>

<script>
    $('#deadline').datepicker({
        format : 'dd/mm/yyyy'
    });
</script>

</body>
</html>