<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<head>
    <title>Página de Cadastro de Local</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>

<div class="place-form-container">
    <a href="/places">Voltar</a>

    <h1>Cadastre o Local</h1>

    <c:forEach var="status" items="${statusList}">
        <p class="form-error">
            <strong>
                    ${status.name()}:
            </strong>
                ${status.error()}
        </p>
    </c:forEach>

    <form:form modelAttribute="placeCreateDTO" method="post" action="/places/create" class="form-container">

        <label>Nome<span class="form-required">*</span>:</label>
        <form:errors path="name" class="form-error" />
        <form:input path="name" class="form-input" />
        <br/>

        <label>Código<span class="form-required">*</span>:</label>
        <form:errors path="code" class="form-error" />
        <form:input path="code" class="form-input" />
        <br/>

        <label>Bairro<span class="form-required">*</span>:</label>
        <form:errors path="neighborhood" class="form-error" />
        <form:input path="neighborhood" class="form-input" />
        <br/>

        <label>Cidade<span class="form-required">*</span>:</label>
        <form:errors path="city" class="form-error" />
        <form:input path="city" class="form-input" />
        <br/>

        <form:button type="submit" class="form-button">CADASTRAR</form:button>

    </form:form>
</div>

<script src="/assets/js/locais/buscarLocal.js"></script>
