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
<h1>User page</h1>
<p>User id: ${user.id}</p>
<p>User name: ${user.username}</p>
<ul>
<#list user.products as product>
    <li>${product.name}</li>
</#list>
</ul>
</body>
</html>