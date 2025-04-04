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
    <body>
        <nav class="navbar navbar-expand-lg bg-dark border-bottom border-body" data-bs-theme="dark">
          <div class="container-fluid">
            <a class="navbar-brand" href="/">DOJO PLACES</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>

                <li class="nav-item">
                  <a class="nav-link" aria-current="page" href="/places/new">Criar um novo Local</a>
                </li>
              </ul>
              <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
              </form>
            </div>
          </div>
        </nav>

        <div class="container">
            <h1 class="mt-5">Todos os Locais</h1>

            <c:if test="${not empty places}">
                <c:forEach var="place" items="${places}">
                    <li style="list-style: none; padding: 1rem">

                        <div class="card" style="width: 18rem;">
                          <div class="card-body">
                            <h5 class="card-title">${place.name()}</h5>
                            <h6 class="card-subtitle mb-2 text-body-secondary">Código: ${place.code()}</h6>
                            <p class="card-text">
                                <p>
                                    <strong>Id</strong>:
                                        ${place.id()}
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
                                <a href="/places/edit/${place.id()}" class="link-warning link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover me-3">Editar Local</a>

                                <form class="removeButton" action="/places/${place.id()}/delete" method="post">
                                    <input class="placeName" style="display: none;" type="text" value="${place.name()}" />
                                    <button style="background: transparent;" class="border border-0 link-danger link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover" type="submit">
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

        <script src="/assets/js/DeleteButton.js"></script>
        <script>
            let deleteButton = new DeleteButton();
            deleteButton.listeners();
        </script>
    </body>
</html>
