<#import "parts/common.ftlh" as c>

<@c.page>
    <h1>User Edit</h1>
    <form name="user" action="/user/${user.id}/edit" method="post">
        <p>Username</p>
        <input title="Username" type="text" name="username" value="${user.username}">
        <p>Password</p>
        <input title="Password" type="text" name="password" value="${user.password}">
        <p>
            <label for="role">Role</label>
            <select id="role" name="roles">
                <option value="USER">USER</option>
                <option value="ADMIN">ADMIN</option>
            </select>
        </p>
        <p>
            <label for="status">Status</label>
            <select id="status" name="status">
                <option value="ACTIVE">ACTIVE</option>
                <option value="INACTIVE">INACTIVE</option>
            </select>
        </p>
        <input type="submit" value="Submit">
    </form>
    <br>
    <a href="/user">Back</a>
</@c.page>