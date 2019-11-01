<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>ToDo's for ${name}</title>
</head>
<body>
<H1><b>Your ToDo's</b></H1>
<table>
    <caption><b>Your ToDos</b></caption>
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

<br/><a href="/add-todo">Add a ToDo</a>
</body>
</html>