<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register</title>
</head>
<body>

<form action="/users/{user-id}/articles" method="post">
    <label>Title</label>
    <input name="name" placeholder="Article's name here">
    <label>Content</label>
    <input name="text" placeholder="The beginning of the...">

    <input type="submit" value="Publish">
</form>

<div>
    <table>
        <tr>
            <th>id</th>
            <th>email</th>
        </tr>
        <#list articles as article>
            <tr>
                <td>${article.text}</td>
                <td>${article.authorName}</td>
                <td>${article.likesCount}</td>
            </tr>
        </#list>
    </table>
</div>

</body>
</html>