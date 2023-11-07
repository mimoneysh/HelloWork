<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		hiiii
		
		<h1>Add Two Numbers</h1>

<form action="#">
<input type="number" id="firstNumber" placeholder="Enter first number">
<input type="number" id="secondNumber" placeholder="Enter second number">
<button type="button" onclick="addNumbers()">Add</button>
</form>

<div id="result"></div>

<script>
function addNumbers() {
  var firstNumber = document.getElementById("firstNumber").value;
  var secondNumber = document.getElementById("secondNumber").value;
  var sum = firstNumber + secondNumber;

  document.getElementById("result").innerHTML = "The sum is: " + sum;
}
</script>

</body>
</html>
localhost:8080/home