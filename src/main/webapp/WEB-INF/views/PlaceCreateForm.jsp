<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Página de Cadastro de Local</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>

    <body>
        <tags:navbar />

        <div class="place-form-container container mt-5 col col-md-4 mx-auto mb-5">
            <a href="/places" class="fs-4 link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-left" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0"/>
                </svg> Voltar
            </a>

            <h1 class="mt-5">Cadastre um Local</h1>

            <form:form modelAttribute="placeCreateDTO" method="post" action="/places/create" class="form-container" id="placeForm">

                <label>Nome<span class="form-required">*</span>:</label>
                <form:errors path="name" class="form-error" />
                <form:input path="name" class="form-control" placeholder="Digite o nome do Local" />
                <br/>

                <label>Código<span class="form-required">*</span>:</label>
                <form:errors path="code" class="form-error" />
                <form:input path="code" class="form-control" placeholder="Digite o código do Local" />
                <br/>

                <label>CEP</span>:</label>
                <form:errors path="cep" class="form-error" />
                <form:input path="cep" class="form-control" placeholder="Digite o CEP do Local" id="cep" />
                <br/>

                <label>Bairro<span class="form-required">*</span>:</label>
                <form:errors path="neighborhood" class="form-error" />
                <form:input path="neighborhood" class="form-control" placeholder="Digite o bairro do Local" id="neighborhood" />
                <br/>

                <label>Cidade<span class="form-required">*</span>:</label>
                <form:errors path="city" class="form-error" />
                <form:input path="city" class="form-control" placeholder="Digite a cidade do Local" id="city" />
                <br/>

                <form:button type="submit" class="btn btn-secondary fw-bold" id="create-place">CADASTRAR</form:button>
            </form:form>
        </div>

        <script src="${pageContext.request.contextPath}/assets/js/ViaCepApi.js"></script>
        <script src="/assets/js/Theme.js"></script>
        <script>
            let viaCepApi = new ViaCepApi();
            let theme = new Theme();
        </script>
    </body>
</html>

