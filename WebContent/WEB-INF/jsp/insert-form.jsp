<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
<link rel="stylesheet" href="decorate/css/insert-product.css" type="text/css">
<script type="text/javascript" src="decorate/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<form action="insertProduct.do" method="post">
		<table>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name"> </td>
			</tr>
				
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price"> </td>
			</tr>
			
			<tr>
				<td>发布时间</td>
				<td><input type="text" name="createtime" onclick="WdatePicker()"> </td>
			</tr>
			
			<tr>
				<td>商品描述</td>
				<td><input type="text" name="detail"> </td>
			</tr>
			<tr>
				<td>商品分类</td>
				<!-- <td><input name="cids" type="checkbox" value="手机" />手机
					<input name="cids" type="checkbox" value="数码" />数码
					<input name="cids" type="checkbox" value="耳机" />耳机  
				</td> -->
				<td>
					<c:forEach items="${categories}" var="c">
						<input type="checkbox" name="cids" value="${c.cid}">${c.cname}
					</c:forEach>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="提交"> </td>
			</tr>
			
		</table>
	</form>
</body>
</html>