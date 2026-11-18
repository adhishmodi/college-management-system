<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html><html lang="en"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1"><title>Sign in | CampusFlow</title><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"></head>
<body class="auth-page"><main class="auth-card"><div class="brand-mark">C</div><p class="eyebrow">CAMPUSFLOW · COLLEGE PORTAL</p><h1>Welcome back</h1><p class="muted">Sign in to manage your campus workspace.</p>
<% if (request.getAttribute("error") != null) { %><div class="alert"><%= request.getAttribute("error") %></div><% } %>
<form method="post" action="${pageContext.request.contextPath}/login" class="form-stack">
<label>Email address<input type="email" name="email" placeholder="you@college.edu" required autocomplete="username"></label>
<label>Password<input type="password" name="password" placeholder="Enter your password" required autocomplete="current-password"></label>
<button class="button button-primary button-full" type="submit">Sign in <span>→</span></button></form>
<div class="demo-note"><strong>Demo access</strong><br>Admin: admin@example.com / Admin@123<br>Student: student@example.com / Student@123</div>
</main></body></html>