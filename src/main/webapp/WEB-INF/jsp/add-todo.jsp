<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>

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

<%@include file="common/footer.jspf"%>