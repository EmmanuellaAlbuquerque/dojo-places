<%--
  Created by IntelliJ IDEA.
  User: emmanuella-albuquerque
  Date: 23/01/2025
  Time: 15:59
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>
<head>
    <title>Listagem de todos os Locais</title>
</head>
<body>

    <h1>Todos os Locais</h1>

    <c:if test="${not empty places}">
        <c:forEach items="${places}" var="place">
            <li>
                <h3>${place.name()}</h3>
                <p>
                    <strong>Código</strong>:
                    ${place.code()}
                </p>
                <p>
                    <strong>Bairro</strong>:
                        ${place.neighborhood()}
                </p>
                <p>
                    <strong>Cidade</strong>:
                        ${place.city()}
                </p>
                <p>
                    <strong>Data de Criação</strong>:
                        ${place.createdAt()}
                </p>
                <p>
                    <strong>Data de Atualização</strong>:
                        ${place.updatedAt()}
                </p>
            </li>
        </c:forEach>
    </c:if>
</body>
</html>
