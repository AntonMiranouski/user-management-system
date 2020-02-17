<#import "parts/common.ftlh" as c>

<@c.page>
    <h1>User Edit</h1>
    <form name="user" action="/user/${user.id}/edit" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <p>Username</p>
        <input title="Username" type="text" name="username" value="${user.username}">
        <p>Password</p>
        <input title="Password" type="text" name="password" value="${user.password}">
        <p>First Name</p>
        <input title="FirstName" type="text" name="firstName" value="${user.firstName}">
        <p>Last Name</p>
        <input title="LastName" type="text" name="lastName" value="${user.lastName}">
        <p>
            <label for="active">State</label>
            <select id="active" name="active">
                <option value="true">ACTIVE</option>
                <option value="false">INACTIVE</option>
            </select>
        </p>
        <p>
            <label for="role">Role</label>
            <select id="role" name="roles">
                <option value="ROLE_USER">USER</option>
                <option value="ROLE_ADMIN">ADMIN</option>
            </select>
        </p>
        <input type="submit" value="Submit">
    </form>
    <br>
    <a href="/user">Back</a>
</@c.page>