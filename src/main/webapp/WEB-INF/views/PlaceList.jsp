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
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Listagem de todos os Locais</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="../../css/styles.css">
</head>
    <body>
        <tags:navbar />

        <div class="container">
            <tags:alert/>

            <h1 class="mt-5 ms-2">Todos os Locais</h1>

            <div class="d-flex flex-wrap">
                <c:if test="${not empty places}">
                    <c:forEach var="place" items="${places}">
                        <li style="list-style: none; padding: 1rem">

                            <div class="card" style="width: 18rem;">
                                <div class="card-body">
                                    <h5 class="card-title">ID ${place.id()}: ${place.name()}</h5>
                                    <h6 class="card-subtitle mb-2 text-body-secondary">Código: ${place.code()}</h6>
                                    <p class="card-text">
                                    <p>
                                        <strong>Cep</strong>:
                                            ${place.cep()}
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
                                    </p>
                                    <div class="d-flex flex-row">
                                        <a href="/places/edit/${place.id()}" class="link-warning link-underline link-underline-opacity-0 me-3">Editar Local</a>

                                        <form class="removeButton" action="/places/${place.id()}/delete" method="post">
                                            <input class="placeName" style="display: none;" type="text" value="${place.name()}" />
                                            <button style="background: transparent;" class="border border-0 link-danger" type="submit">
                                                Deletar Local
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </c:if>
            </div>
        </div>

        <script src="/assets/js/DeleteButton.js"></script>
        <script src="/assets/js/Theme.js"></script>
        <script>
            let deleteButton = new DeleteButton();
            deleteButton.listeners();

            let theme = new Theme();
        </script>
    </body>
</html>
