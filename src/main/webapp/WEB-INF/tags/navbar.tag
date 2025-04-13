<%@ tag description="Navbar" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<nav class="navbar navbar-expand-lg border-bottom border-body ps-5">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">
            <i class="bi bi-cup-hot-fill me-2"></i>
           DOJO PLACES
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">
                        <i class="bi bi-house"></i> Home
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/places/new">
                        <i class="bi bi-plus-circle"></i>
                        Criar um novo Local
                    </a>
                </li>

                <li class="nav-item">
                    <button class="nav-link" id="theme-toggle">
                    </button>
                </li>
            </ul>
<%--            <form class="d-flex" role="search">--%>
<%--                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">--%>
<%--                <button class="btn btn-outline-success" type="submit">Search</button>--%>
<%--            </form>--%>
        </div>
    </div>
</nav>
