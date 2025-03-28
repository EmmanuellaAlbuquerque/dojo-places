<%--
  Created by IntelliJ IDEA.
  User: emmanuella-albuquerque
  Date: 23/01/2025
  Time: 15:59
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Listagem de todos os Locais</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
    <body class="container">

        <h1 class="mt-5">Todos os Locais</h1>

        <a href="/places/new">Crie um novo Local</a>

        <c:if test="${not empty places}">
            <c:forEach var="place" items="${places}">
                <hr/>

                <li style="list-style: none; padding: 1rem">
                    <p>
                        <strong>Id</strong>:
                            ${place.id()}
                    </p>

                    <a href="/places/edit/${place.id()}">
                        <h3>${place.name()}</h3>
                    </a>

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

                    <form class="removeButton" action="/places/${place.id()}/delete" method="post">
                        <input class="placeName" style="display: none;" type="text" value="${place.name()}" />
                        <button class="btn btn-danger" type="submit">DELETAR</button>
                    </form>
                </li>
            </c:forEach>
        </c:if>

        <script src="/assets/js/DeleteButton.js"></script>
        <script>
            let deleteButton = new DeleteButton();
            deleteButton.listeners();
        </script>
    </body>
</html>
