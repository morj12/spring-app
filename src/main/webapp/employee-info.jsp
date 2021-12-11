<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Add employee</title>

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

    <div class="text-center py-4">
        <h2>Employee Info</h2>
    </div>

    <div class="text-center">

        <form:form action="saveEmployee" modelAttribute="employee">
            <div class="form-row">
                <form:hidden path="id"/>
                <div class="form-group col-md-6">
                    <label for="name_form">Name: </label>
                    <form:input id="name_form" path="name"/>

                </div>
                <div class="form-group col-md-6">
                    <label for="surname_form">Surname: </label>
                    <form:input id="surname_form" path="surname"/>

                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="department_form">Department: </label>
                    <form:input id="department_form" path="department"/>

                </div>
                <div class="form-group col-md-6">
                    <label for="salary_form">Salary: </label>
                    <form:input id="salary_form" path="salary"/>

                </div>
            </div>
            <input type="submit" class="btn btn-secondary btn-block" value="OK">
        </form:form>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>

</div>
</body>
</html>