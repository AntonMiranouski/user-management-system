<#import "parts/common.ftlh" as c>

<@c.page>
    <h1>User info</h1>
    <table>
        <tr>
            <td>Id</td>
            <td>${user.id}</td>
        </tr>
        <tr>
            <td>Username</td>
            <td>${user.username}</td>
        </tr>
        <tr>
            <td>State</td>
            <td>${user.active?string('ACTIVE', 'INACTIVE')}</td>
        </tr>
        <tr>
            <td>Role</td>
            <td>
                <#list user.roles>
                    <#items as role>
                        ${role}
                    </#items>
                </#list>
            </td>
        </tr>
        <tr>
            <td>Created At</td>
            <td>${user.createdAt?datetime}</td>
        </tr>
        <tr>
            <td><a href="/user/${user.id}/edit"/>Edit</td>
        </tr>
    </table>
    <br>
    <a href="/user">Back</a>
</@c.page>