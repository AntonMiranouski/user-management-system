<#import "parts/common.ftlh" as c>
<#import "parts/logout.ftlh" as lo>

<@c.page>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th><a href="/user/new">New User</a></th>
        </tr>
        </thead>
        <tbody>
            <#list users as u>
                <tr>
                    <td>${u.id}</td>
                    <td>${u.username}</td>
                    <td><a href="/user/${u.id}"/>Info</td>
                    <td><a href="/user/${u.id}/edit"/>Edit</td>
                </tr>
            </#list>
        </tbody>
    </table>
    <hr>
        <@lo.logout/>
</@c.page>