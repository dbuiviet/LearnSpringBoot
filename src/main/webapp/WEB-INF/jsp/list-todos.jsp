<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>ToDo's for ${name}</title>
    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<H1><b>${name} ToDo's</b></H1>
    <caption align="center"><b>Your ToDos are</b></caption>
<table class="table table-striped">

    <thead>
        <tr>
            <th>Description</th>
            <th>Deadline</th>
            <th>Is it Finished</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.desc}</td>
                <td>${todo.deadline}</td>
                <td>${todo.finished}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

    <div><a class="button" href="/add-todo">Add a ToDo</a></div>
    <script src="webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</div>
</body>
</html>