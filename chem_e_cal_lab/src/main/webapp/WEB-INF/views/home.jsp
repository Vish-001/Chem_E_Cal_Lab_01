<%@ page import="java.util.List" %>
<%@ page import="com.vishal.chemlab.chem_e_cal_lab.model.Compound" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Chemical Lab</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1, h2, h3 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        form {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h1>Online Chemical Lab</h1>

    <!-- Table of Compounds -->
    <h2>Available Compounds</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Formula</th>
                <th>Color</th>
                <th>Odor</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Compound> compounds = (List<Compound>) request.getAttribute("compounds");
                if (compounds != null && !compounds.isEmpty()) {
                    for (Compound compound : compounds) {
            %>
                <tr>
                    <td><%= compound.getId() %></td>
                    <td><%= compound.getName() %></td>
                    <td><%= compound.getFormula() != null ? compound.getFormula() : "N/A" %></td>
                    <td><%= compound.getColor() != null ? compound.getColor() : "N/A" %></td>
                    <td><%= compound.getOdor() != null ? compound.getOdor() : "N/A" %></td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr><td colspan="5">No compounds available</td></tr>
            <% } %>
        </tbody>
    </table>

    <!-- Form for Selecting Compounds -->
    <h3>Select Compounds for Reaction</h3>
    <form action="/getReaction" method="post">
        <label for="compound1Id">Enter Compound 1 ID:</label>
        <input type="text" id="compound1Id" name="compound1Id" required>

        <label for="compound2Id">Enter Compound 2 ID:</label>
        <input type="text" id="compound2Id" name="compound2Id" required>

        <button type="submit">Get Reaction</button>
    </form>
</body>
</html>
