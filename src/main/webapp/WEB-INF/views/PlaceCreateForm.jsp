<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h1>Cadastre o Local</h1>

<br/>
<br/>

<form:form modelAttribute="PlaceCreateDTO" method="post" action="/places/new">

    <label>Nome:</label>
    <form:input path="name"/>
    <form:errors path="name" cssStyle="color: red"/>
    <br/>

    <label>Código:</label>
    <form:input path="code"/>
    <form:errors path="code" cssStyle="color: red"/>
    <br/>

    <label>Bairro:</label>
    <form:input path="neighborhood"/>
    <form:errors path="neighborhood" cssStyle="color: red"/>
    <br/>

    <label>Cidade:</label>
    <form:input path="city"/>
    <form:errors path="city" cssStyle="color: red"/>
    <br/>

    <form:button type="submit">Cadastrar</form:button>

</form:form>

<script src="/assets/js/locais/buscarLocal.js"></script>
