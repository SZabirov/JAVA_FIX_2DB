<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>username</th>
        <th>count of products</th>
    </tr>

    <#list usersWithProductCountsList as userWithProductCount>
        <tr>
            <td>${userWithProductCount.getUser().id}</td>
            <td>${userWithProductCount.getUser().username}</td>
            <td>${userWithProductCount.getCount()}</td>
        </tr>
    </#list>
</table>
</body>
</html>









