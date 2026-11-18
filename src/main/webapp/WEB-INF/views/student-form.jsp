<%@ page contentType="text/html;charset=UTF-8" %><%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html><html lang="en"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1"><title>Student form | CampusFlow</title><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"></head><body>
<%@ include file="nav.jspf" %><main class="page-shell narrow"><div class="page-heading"><div><p class="eyebrow">STUDENT RECORD</p><h1><c:choose><c:when test="${student.id > 0}">Edit student</c:when><c:otherwise>Add student</c:otherwise></c:choose></h1><p class="muted">Enter accurate academic and contact information.</p></div></div>
<c:if test="${error != null}"><div class="alert"><c:out value="${error}"/></div></c:if>
<section class="panel"><form method="post" action="${pageContext.request.contextPath}/students" class="form-grid">
<input type="hidden" name="action" value="save"><input type="hidden" name="id" value="${student.id}">
<label>Enrollment number *<input name="enrollmentNo" value="<c:out value='${student.enrollmentNo}'/>" required maxlength="30"></label>
<label>Full name *<input name="fullName" value="<c:out value='${student.fullName}'/>" required maxlength="120"></label>
<label>Email address *<input type="email" name="email" value="<c:out value='${student.email}'/>" required maxlength="160"></label>
<label>Phone<input name="phone" value="<c:out value='${student.phone}'/>" maxlength="20"></label>
<label>Department *<input name="department" value="<c:out value='${student.department}'/>" required maxlength="100"></label>
<label>Semester *<select name="semester" required><option value="">Select semester</option><c:forEach begin="1" end="12" var="n"><option value="${n}" <c:if test="${student.semester == n}">selected</c:if>>Semester ${n}</option></c:forEach></select></label>
<div class="form-actions"><a class="button button-quiet" href="${pageContext.request.contextPath}/students">Cancel</a><button class="button button-primary" type="submit">Save student</button></div></form></section></main></body></html>