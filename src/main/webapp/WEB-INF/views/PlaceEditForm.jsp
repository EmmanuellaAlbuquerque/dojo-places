<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<head>
    <title>Página de Edição de Local</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>

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

<div class="place-form-container container mt-5 col col-md-4 mx-auto">
    <a href="/places" class="fs-4 link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-left" viewBox="0 0 16 16">
          <path fill-rule="evenodd" d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0"/>
        </svg> Voltar
    </a>

    <h1 class="mt-5">Edite o Local</h1>

    <form:form modelAttribute="placeEditDTO" method="post" action="/places/update" class="form-container">

        <form:input path="id" style="display: none" />

        <label>Nome<span class="form-required">*</span>:</label>
        <form:errors path="name" class="form-error" />
        <form:input path="name" class="form-control" placeholder="Digite o nome do Local" />
        <br/>

        <label>Código<span class="form-required">*</span>:</label>
        <form:errors path="code" class="form-error" />
        <form:input path="code" class="form-control" placeholder="Digite o código do Local" />
        <br/>

        <label>Bairro<span class="form-required">*</span>:</label>
        <form:errors path="neighborhood" class="form-error" />
        <form:input path="neighborhood" class="form-control" placeholder="Digite o bairro do Local" />
        <br/>

        <label>Cidade<span class="form-required">*</span>:</label>
        <form:errors path="city" class="form-error" />
        <form:input path="city" class="form-control" placeholder="Digite a cidade do Local" />
        <br/>

        <form:button type="submit" class="btn btn-dark">EDITAR</form:button>

    </form:form>
</div>

<script src="/assets/js/locais/buscarLocal.js"></script>
