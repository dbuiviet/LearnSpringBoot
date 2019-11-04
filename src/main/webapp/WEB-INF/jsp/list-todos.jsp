<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>


<div class="container">
<H1><b>${name} ToDo's</b></H1>
    <caption align="center"><b>Your ToDos are</b></caption>
<table class="table table-striped">

    <thead>
        <tr>
            <th>Description</th>
            <th>Deadline</th>
            <th>Is it Finished</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
    </thead>
    <tbody>
        <core:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.desc}</td>
                <td> <fmt:formatDate pattern="dd/MM/yyyy" value="${todo.deadline}"/></td>
                <td>${todo.finished}</td>
                <td><a type="button" class="btn btn-success" href="/update-todo?id=${todo.id}">Update</a> </td>
                <td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">Delete</a> </td>
            </tr>
        </core:forEach>
    </tbody>
</table>

    <div><a class="button" href="/add-todo">Add a ToDo</a></div>
    <script src="webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</div>

<%@include file="common/footer.jspf"%>