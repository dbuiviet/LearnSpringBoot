<html>
<head>
    <title>First Web Application</title>
</head>
<body>
<span style="color: red; ">${errorMessage}</span>
<form method="post">
    Name: <input type="text" name="name"/>
    Password: <input type="password" name="password"/>
    <input type="submit" />
</form>
<label><span style="color: red; font-size: 16px">${invalidMsg}</span> </label>
</body>
</html>