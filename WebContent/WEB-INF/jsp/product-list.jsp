<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品列表</title>
<link rel="stylesheet" href="decorate/css/index.css" type="text/css">
</head>
<body>
	<div>
		<center>魅族商城</center>
	</div>
	<table border="1">
		<tr>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>入库时间</td>
			<td>商品描述</td>
			<td>商品分类</td>
			<td>操作  <a href="toinsert.do">添加</a></td>
		</tr>
		<c:forEach items="${products}" var="product">
		<tr>
			<td>${product.name }</td>
			<td>${product.price }</td>
			<td>${product.createtime }</td>
			<td>${product.detail }</td>
			<td>
				<%-- ${product.categories.cname } --%>
				<c:forEach items="${product.categories }" var="c">
					${c.cname }
				</c:forEach>
			<%-- 	${product.cids } --%>
			</td>
			<td><a href="deleteProduct.do?id=${product.id}">删除</a> <a href="editProduct.do?id=${product.id }">修改</a></td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>