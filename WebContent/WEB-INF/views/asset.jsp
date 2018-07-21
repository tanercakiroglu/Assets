<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false" %>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/data-table.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/pages/asset.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/data-table.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form>
  <div class="form-row">
    <div class="form-group col-md-3">
      <label for="plate">Plate</label>
      <input type="text" class="form-control" id="plate" placeholder="35GA5544" maxlength="10">
    </div>
    <div class="form-group col-md-3">
      <label for="nick_name">Nick Name</label>
      <input type="text" class="form-control" id="nick_name" placeholder="Karşıyaka">
    </div>
  </div>
    <div class="form-row">
     <div class="form-group col-md-3">
    <label for="inputAddress">Model</label>
    <input type="text" class="form-control" id="model" placeholder="Focus">
  </div>
  <div class="form-group col-md-3">
    <label for="inputState">Model Year</label>
      <select id="model_year" class="form-control">
        <option value="0" selected>Choose...</option>
        <option value="2015" >2015</option>
        <option value="2016" >2016</option>
        <option value="2017" >2017</option>
      </select>
  </div>
    </div>
  
 
  <div class="form-row">
    <div class="form-group col-md-3">
      <label for="inputCity">Color</label>
      <input type="text" class="form-control" id="color" placeholder="Red">
    </div>
    <div class="form-group col-md-3">
      <label for="inputState">Type of Vehicle</label>
      <select id="tov" class="form-control">
			<option value="0" selected>Choose...</option>
          <c:forEach items="${tovList}" var="tov"  varStatus="loop">
          		<option value="${tov.id}" >${tov.value}</option>
          </c:forEach>
      </select>
    </div>
  
  </div>
  <div class="form-group">
   <div class="form-group col-md-3">
      <label for="inputCity">Brand</label>
      <input type="text" class="form-control" id="brand" placeholder="Ford">
    </div>
  <div class="form-group col-md-3">
    <div class="form-check">
      <input class="form-check-input" type="checkbox" id="active">
      <label class="form-check-label" for="gridCheck">
       Active
      </label>
    </div>
    </div>
  </div>
</form>
  <button type="button" id="btnSbmt" class="btn ">Save</button>


	<div class="form-group"></div>
	<table id="vehicle_table" class="display">
		<thead>
			<tr>
				<th>Plate</th>
				<th>Nick Name</th>
				<th>Brand</th>
				<th>Model</th>
				<th>Model Year</th>
				<th>Color</th>
				<th>Type of Vehicle</th>
				<th>Active</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${vechList}" var="vech"  varStatus="loop">
			<tr>
				<td>${vech.plateNumber}</td>
				<td>${vech.nickName}</td>
				<td>${vech.brand}</td>
				<td>${vech.model}</td>
				<td>${vech.modelYear}</td>
				<td>${vech.color}</td>
				<td>${vech.typeOfVehicle}</td>
				<td>${vech.active}</td>
				<td> <button type="button" id="${vech.plateNumber}" class="close" aria-label="Close">
  				<span aria-hidden="true">&times;</span>
  				</button>
  				</td>
  			</tr>
  </c:forEach>
		
		</tbody>
	</table>
</body>
</html>