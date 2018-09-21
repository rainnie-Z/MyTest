<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改页面</title>
<link rel="stylesheet" href="decorate/css/index1.css" type="text/css">
<script type="text/javascript" src="decorate/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<form action="updateProduct.do" method="post">
		<table>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name" value="${product.name }"> </td>
			</tr>
				
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price" value="${product.price }"> </td>
			</tr>
			
			<tr>
				<td>发布时间</td>
				<td><input type="text" name="createtime" value="${product.createtime }" onclick="WdatePicker()"> </td>
			</tr>
			
			<tr>
				<td>商品描述</td>
				<td><input type="text" name="detail" value="${product.detail }"> </td>
			</tr>
			
			<tr>
				<td>商品分类</td>
				<!-- <td><input name="cids" type="checkbox" value="手机" />手机
					<input name="cids" type="checkbox" value="数码" />数码
					<input name="cids" type="checkbox" value="耳机" />耳机  </td> -->
				<td>
					<c:forEach items="${allCategories}" var="ac">
						<c:set var="checked" value=""></c:set>
						<c:forEach items="${product.categories}" var="c">
							<c:if test="${ac.cid==c.cid}">
								<c:set var="checked" value="checked"></c:set>
							</c:if>
						</c:forEach>
						<input type="checkbox" name="cids" value="${ac.cid}" ${checked}/>${ac.cname}
					</c:forEach>
				</td>
			</tr>
			
			<tr>
				<td><input type="hidden" name="id" value="${product.id}"></td>
				<td><input type="submit" value="提交"> </td>
			</tr>
			
		</table>
	</form>
</body>
</html>