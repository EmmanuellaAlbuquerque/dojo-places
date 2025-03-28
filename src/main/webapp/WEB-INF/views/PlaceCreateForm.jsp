<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<head>
    <title>Página de Cadastro de Local</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">

            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>

<div class="place-form-container container mt-5">
    <a href="/places">Voltar</a>

    <h1 class="mt-5">Cadastre o Local</h1>

    <form:form modelAttribute="placeCreateDTO" method="post" action="/places/create" class="form-container">

        <label>Nome<span class="form-required">*</span>:</label>
        <form:errors path="name" class="form-error" />
        <form:input path="name" class="form-control" />
        <br/>

        <label>Código<span class="form-required">*</span>:</label>
        <form:errors path="code" class="form-error" />
        <form:input path="code" class="form-control" />
        <br/>

        <label>Bairro<span class="form-required">*</span>:</label>
        <form:errors path="neighborhood" class="form-error" />
        <form:input path="neighborhood" class="form-control" />
        <br/>

        <label>Cidade<span class="form-required">*</span>:</label>
        <form:errors path="city" class="form-error" />
        <form:input path="city" class="form-control" />
        <br/>

        <form:button type="submit" class="btn btn-primary">CADASTRAR</form:button>

    </form:form>
</div>

<script src="/assets/js/locais/buscarLocal.js"></script>
