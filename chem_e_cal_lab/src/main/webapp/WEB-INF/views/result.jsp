<%@ page import="com.vishal.chemlab.chem_e_cal_lab.model.Reaction" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reaction Result</title>
</head>
<body>
    <h1>Reaction Result</h1>

    <%
        Reaction reaction = (Reaction) request.getAttribute("reaction");
        String message = (String) request.getAttribute("message");
    %>

    <% if (reaction != null) { %>
        <h2>Reaction Details</h2>
        <p><strong>Reaction ID:</strong> <%= reaction.getId() %></p>
        <p><strong>Compound 1 ID:</strong> <%= reaction.getCompound1Id() %></p>
        <p><strong>Compound 2 ID:</strong> <%= reaction.getCompound2Id() %></p>
        <p><strong>Reaction Formula:</strong> <%= reaction.getReactionFormula() != null ? reaction.getReactionFormula() : "N/A" %></p>
        <p><strong>Resultant Compound ID:</strong> <%= reaction.getResultantCompoundId() != null ? reaction.getResultantCompoundId() : "N/A" %></p>
    <% } else if (message != null) { %>
        <p><%= message %></p>
    <% } else { %>
        <p>No reaction information available.</p>
    <% } %>

    <a href="/home">Go Back</a>
</body>
</html>
