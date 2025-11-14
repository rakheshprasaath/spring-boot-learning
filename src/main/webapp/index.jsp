<%@page language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Add Two Numbers</title>
  <link rel="stylesheet" href="style.css" />
</head>
<body>
  <form action="result">
    <h2>Add Two Numbers</h2>
    <label for="num1">Enter first number</label>
    <input type="number" id="num1" name="num1"><br>
    <label for="num2">Enter second number</label>
    <input type="number" id="num2" name="num2"><br>
    <input type="submit">
  </form>
<%--
  <script>
    function addNumbers() {
      const num1 = parseFloat(document.getElementById('num1').value) || 0;
      const num2 = parseFloat(document.getElementById('num2').value) || 0;
      const sum = num1 + num2;
      console.log(sum)

      document.getElementById('result').innerText = `Result: `+ sum;
    }
  </script>
--%>
</body>
</html>
