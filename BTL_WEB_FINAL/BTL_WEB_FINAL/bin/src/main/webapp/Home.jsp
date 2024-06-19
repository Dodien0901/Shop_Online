<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home Page</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <style>
        body {
            background-color: #f8f9fa;
            color: #343a40;
        }
        .breadcrumb {
            background-color: #ffffff;
        }
        .breadcrumb-item a {
            color: #007bff;
        }
        .breadcrumb-item.active {
            color: #6c757d;
        }
        .card {
            margin-bottom: 20px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        .card-img-top {
            height: 200px;
            object-fit: cover;
        }
        .card-title a {
            color: #343a40;
            text-decoration: none;
        }
        .card-title a:hover {
            color: #007bff;
        }
        .btn-danger {
            background-color: #dc3545;
            border-color: #dc3545;
        }
        .btn-success {
            background-color: #28a745;
            border-color: #28a745;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
    </style>
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>
<div class="container mt-3">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="Home.jsp">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Category</a></li>
            <li class="breadcrumb-item active" aria-current="page">Sub-category</li>
        </ol>
    </nav>
    <div class="row">
        <jsp:include page="Left.jsp"></jsp:include>
        <div class="col-sm-9">
            <div id="content" class="row">
                <c:forEach items="${product_list}" var="o">
                    <div class="product col-12 col-md-6 col-lg-4 mb-4">
                        <div class="card">
                            <img class="card-img-top" src="${o.image}" alt="${o.name}">
                            <div class="card-body">
                                <h5 class="card-title"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h5>
                                <p class="card-text">${o.title}</p>
                                <div class="d-flex justify-content-between">
                                    <p class="btn btn-danger">${o.price} $</p>
                                    <a href="#" class="btn btn-success">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <button onclick="loadMore()" class="btn btn-primary mt-3">Load more</button>
        </div>
    </div>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
<script>
    function loadMore() {
        var amount = document.getElementsByClassName("product").length;
        $.ajax({
            url: "/Project_banhang/load",
            type: "get",
            data: {
                exits: amount
            },
            success: function (data) {
                var row = document.getElementById("content");
                row.innerHTML += data;
            },
            error: function (xhr) {
                console.error("Error loading more products");
            }
        });
    }
    function searchByName(param) {
        var txtSearch = param.value;
        $.ajax({
            url: "/Project_banhang/searchAjax",
            type: "get",
            data: {
                txt: txtSearch
            },
            success: function (data) {
                var row = document.getElementById("content");
                row.innerHTML = data;
            },
            error: function (xhr) {
                console.error("Error searching products");
            }
        });
    }
</script>
</body>
</html>
