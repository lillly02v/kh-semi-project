<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
* {box-sizing: border-box;}

body { 
  margin: 0;
  font-family: Arial;
}

.header {

  height: 90px;
  overflow: hidden;
  background-color: dodgerblue;
  padding: 20px 10px;
  box-sizing: border-box;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19); 
}

.header div{
  align: center;
}

.header a {
  float: left;
  color: white;
  text-align: center;
  padding: 10px;
  text-decoration: none;
  font-size: 15px; 
  line-height: 20px;
  border-radius: 4px;
}

.header a.logo {
  font-size: 25px;
  font-weight: bold;
  background-color: dodgerblue;
  color: white;
}

.header a.logo:hover {
  font-size: 25px;
  background-color: dodgerblue;
  text-decoration: none;
  border-top: 0px;
  border-bottom: 0px;
  color: white;
  transition-duration: 0.5s;
}

.header a:hover {
  color: white;
  transition-duration: 0.5s;
  line-decoration: none;
  border-bottom: 3px solid white;
  border-top: 3px solid white;
  margin: 20px, 0px;
}

.header-right {
  float: right;
}

@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
  }
  .header-right {
    float: none;
  }
}
</style>
</head>
<body>

<div class="header" id="myHeader">
  <a class="logo">DABONG.</a>
  <div class="header-right">
    <a href="#home">HOME</a>
    <a href="#">공지사항</a>
    <a href="#">복지자참여</a>
    <a href="#">봉사자참여</a>
    <a href="#">정보마당</a>
    <a href="#">문의사항</a>
  </div>
</div>
</body>
</html>

