<#import "parts/common.ftlh" as c>

<@c.page>
    <h1>User Create</h1>
    <form name="user" action="/user/new" method="post">
        <p>Username</p>
        <input title="Username" type="text" name="username">
        <p>Password</p>
        <input title="Password" type="text" name="password">
        <p>First Name</p>
        <input type="text" name="firstName">
        <p>Last Name</p>
        <input type="text" name="lastName">
        <p><input type="submit" value="Submit"></p>
    </form>

    <br>
    <a href="/user">Back</a>
</@c.page>