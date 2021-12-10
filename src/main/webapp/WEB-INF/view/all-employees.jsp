<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>All employees</title>

    <style>
        @media (min-width: 576px) {
            .container {
                max-width: 100%;
            }
        }

        @media (min-width: 1200px) {
            .container {
                max-width: 1170px;
            }
        }
    </style>
</head>

<body>
<div class="container py-3">
    <jsp:include page="nav.jsp"></jsp:include>
    <div class="text-center">
        <h2>All employees</h2>
    </div>

    <table class="table text-center table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Surname</th>
            <th scope="col">Department</th>
            <th scope="col">Salary</th>
            <th scope="col">Operations</th>
        </tr>
        </thead>
        <tbody>
        <% int counter = 0; %>
        <c:forEach var="emp" items="${allEmps}">
            <% counter++; %>
            <c:url var="updateButton" value="/updateInfo">
                <c:param name="empId" value="${emp.id}"/>
            </c:url>

            <c:url var="deleteButton" value="/deleteEmployee">
                <c:param name="empId" value="${emp.id}"/>
            </c:url>

            <tr>
                <th scope="row"><%=counter%>
                </th>
                <td>${emp.name}</td>
                <td>${emp.surname}</td>
                <td>${emp.department}</td>
                <td>${emp.salary}</td>
                <td>
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <input type="button" value="Update" class="btn btn-secondary"
                                       onclick="window.location.href = '${updateButton}'"/>
                            </div>
                            <div class="col">
                                <input type="button" value="Delete" class="btn btn-secondary"
                                       onclick="window.location.href = '${deleteButton}'"/>
                            </div>
                        </div>


                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
    <div class="text-center">
        <input type="button" class="btn btn-secondary btn-block" value="Add" onclick="window.location.href = 'addNewEmployee'"/>
    </div>


</div>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>


</body>
</html>