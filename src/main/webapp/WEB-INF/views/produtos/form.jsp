<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Cadastro de Produto</h1>
	<form:form action="${s:mvcUrl('PC#gravar').build()}" method="post"
		commandName="produto" enctype="multipart/form-data">
		<div>
			<label>Título</label></br>
			<form:input path="titulo" />
			</br> <font size="2" color="red"><form:errors path="titulo" /></font>
		</div>
		<div>
			<label>Descrição</label></br>
			<form:textarea rows="10" cols="20" path="descricao" />
			</br> <font size="2" color="red"><form:errors path="descricao" /></font>
		</div>
		<div>
			<label>Páginas</label></br>
			<form:input path="paginas" />
			</br> <font size="2" color="red"><form:errors path="paginas" /></font>
		</div>
		<div>
			<label>Data de Lançamento</label></br>
			<form:input path="dataLancamento" />
			<font size="2" color="red"><form:errors path="dataLancamento" /></font>
		</div>
		<div>
			<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
				<div>
					<label>${tipoPreco}</label>
					<form:input path="precos[${status.index}].valor" />
					<form:hidden path="precos[${status.index}].tipo"
						value="${tipoPreco}" />
				</div>
			</c:forEach>
		</div>
		<div>
			<label>Sumário</label> <input name="sumario" type="file" />
		</div>
		<button type="submit">Salvar</button>
	</form:form>
</body>
</html>