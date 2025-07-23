<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<table>
    <thead>
        <tr>
            <th>ID</th><th>Имя</th><th>Email</th><th>Действия</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>
                <a href="${pageContext.request.contextPath}/users/edit?id=${user.id}">Редактировать</a>
                <a href="${pageContext.request.contextPath}/users/delete?id=${user.id}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="${pageContext.request.contextPath}/users/add">Добавить нового</a>
