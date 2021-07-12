<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Логин</title>
</head>
<body>

<h1>Логин User</h1>
<br><br>
<form name="user" method="post" action="/user/user_login">

    <label for="username" >Имя пользователя</label>
    <input type="email" id="username" name="username" value="user" autofocus>

    <br>

    <label for="password">Пароль</label>
    <input type="password" id="password" name="password" value="user" autofocus>

    <br>

    <#--noinspection FtlReferencesInspection-->
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <br>
    <br>


    <button type="submit" id="submit">Войти</button>


</form>

<br><br>


</body>
</html>