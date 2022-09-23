<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
	<link rel="icon" type="image/png" sizes="16x16" href="./images/favicon.png">
	<link rel="stylesheet" href="./css/w3schools.css">
	   <!-- Bootstrap Core CSS -->
	<link href="./css/lib/bootstrap/bootstrap.min.css" rel="stylesheet">
	<!-- Custom CSS -->
	<link href="./css/helper.css" rel="stylesheet">
	<link href="./css/style.css" rel="stylesheet">
	<style>
		.panel-body{padding:45px;}
		.address-name{font-size:8pt;}
		.color-primary, .removebtn, .id-text, .num-text{font-size:9pt;}
	</style>
	<script src="./js/jquery-3.3.1.js"></script>

	<script>
		var monthVt = new Array();
		var monthWr = new Array();
		var i = 0, j = 0;
		<c:forEach var="monthVtcount" items="${monthVtCount}">
			var monthVtCount = ${monthVtcount};
			monthVt[i] = monthVtCount;
			i = i + 1;
		</c:forEach>
		<c:forEach var="monthWrcount" items="${monthWrCount}">
			var monthWrCount = ${monthWrcount};
			monthWr[j] = monthWrCount;
			j = j + 1;
		</c:forEach>
	</script>
	<script>
		var ageTotal = new Array();
		var ageVt = new Array();
		var ageWr = new Array();
		var l = 0; m = 0, n = 0;
		<c:forEach var="ageTotalper" items="${ageTotalPer}">
			ageTotal[l] = ${ageTotalper};
			l = l + 1;
		</c:forEach>
		<c:forEach var="ageVtper" items="${ageVtPer}">
			ageVt[m] = ${ageVtper};
			m = m + 1;
		</c:forEach>
		<c:forEach var="ageWrper" items="${ageWrPer}">
			ageWr[n] = ${ageWrper};
			n = n + 1;
		</c:forEach>
	</script>
</head>
<c:if test="${sessionScope.id == 'admin'}">
<body class="fix-header fix-sidebar">
	<%@ include file="../../header/Header.jsp" %>
    <!-- Preloader - style you can find in spinners.css -->
    <div class="preloader">
        <svg class="circular" viewBox="25 25 50 50">
			<circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" /> </svg>
    </div>
    <!-- Main wrapper  -->
    <div id="main-wrapper">
        <div class="page-wrapper">
            <!-- End Bread crumb -->
            <!-- Container fluid  -->
            <div class="container-fluid">
                <!-- Start Page Content -->
                <div class="row">
                	<div class="col-lg-6">
                        <div class="card">
                            <div class="card-title">
                                <h4>Team Total Completed </h4>
                            </div>
                            <div class="sales-chart">
                                <canvas id="user-chart"></canvas>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="card">
                            <div class="card-title">
                                <h4>월 방문자 수 </h4>
                            </div>
                            <div class="sales-chart">
                                <canvas id="team-chart"></canvas>
                            </div>
                        </div>
                    </div>
                  	<!-- /# column -->
                    <div class="col-lg-6" style="display:none;">
                        <div class="card sale-card">
                            <div class="card-title sale-title">
                                <h4> 월 방문자수 </h4>
                            </div>
                            <div class="sales-chart">
                                <canvas id="sales-chart"></canvas>
                            </div>
                        </div>
                    </div>
                 </div>
                 <div class="row">
                 	<div class="col-sm-6 col-md-4">
                        <div class="card panel-card">
                            <div class="panel-heading">
                                <div class="panel-title">
                                    <h4>사용자 나이대 비율</h4>
                                </div>
                            </div>
                            <div class="panel-body">
                                <canvas id="totalPieChart"></canvas>
                            </div>
                        </div>
                    </div>
                 <!-- Pie Chart -->
                    <div class="col-sm-6 col-md-4">
                        <div class="card panel-card">
                            <div class="panel-heading">
                                <div class="panel-title">
                                    <h4>봉사자 나이대 비율</h4>
                                </div>
                            </div>
                            <div class="panel-body">
                                <canvas id="vtPieChart"></canvas>
                            </div>
                        </div>
                    </div>
                    <!-- Pie Chart -->
                    <div class="col-sm-6 col-md-4">
                        <div class="card panel-card">
                            <div class="panel-heading">
                                <div class="panel-title">
                                    <h4>복지자 나이대 비율</h4>
                                </div>
                            </div>
                            <div class="panel-body">
                                <canvas id="wrPieChart"></canvas>
                            </div>
                        </div>
                    </div>
                 	<!-- Bar Chart -->
                    <div class="col-sm-12 col-md-6" style="display:none;">
                        <div class="card panel-chart">
                            <div class="panel-heading">
                                <div class="panel-title">
                                    <h4>Bar chart</h4>
                                </div>
                            </div>
                            <div class="panel-body" style="height: 300px">
                                <canvas id="barChart"></canvas>
                            </div>
                        </div>
                    </div>
                 	
                 </div>
                 <div class="row">
                    <div class="col-lg-6">
                        <div class="card">
                            <div class="card-title">
                                <h4>봉사자 명단</h4>

                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>아이디</th>
                                                <th>이름</th>
                                                <th>주소</th>
                                                <th>가입일</th>
                                                <th>삭제</th>
                                            </tr>
                                        </thead>
                                        <tbody class="vtListInfo">
                                            <c:forEach var="list" items="${vtList}">
                                        	<tr>
												<td class="num-text" scope="row">${list.num}</td>
												<td class="id-text"><a href="#">${list.id}</a></td>
												<td><span class="badge badge-primary">${list.name}</span></td>
												<td class="address-name">${list.address}</td>
												<td class="color-primary">${list.date}</td>
												<td class="removebtn"><a href="vtDeleteProcess.net?userId=${list.id}&userPass=${list.pass}">삭제</a></td>
											</tr>
											</c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="card">
                            <div class="card-title">
                                <h4>복지자 명단</h4>

                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>아이디</th>
                                                <th>이름</th>
                                                <th>주소</th>
                                                <th>가입일</th>
                                                <th>삭제</th>
                                            </tr>
                                        </thead>
                                        <tbody class="wrListInfo">
                                        	<c:forEach var="list" items="${wrList}">
                                        	<tr>
												<td class="num-text" scope="row">${list.num}</td>
												<td class="id-text"><a href="#">${list.id}</a></td>
												<td><span class="badge badge-primary">${list.name}</span></td>
												<td class="address-name">${list.address}</td>
												<td class="color-primary">${list.date}</td>
												<td class="removebtn"><a href="wrDeleteProcess.net?userId=${list.id}&userPass=${list.pass}">삭제</a></td>
											</tr>
											</c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Page wrapper  -->
    </div>
    <!-- End Wrapper -->
    <script src="./js/lib/bootstrap/js/popper.min.js"></script>
    <script src="./js/lib/bootstrap/js/bootstrap.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="./js/jquery.slimscroll.js"></script>
    <!--Menu sidebar -->
    <script src="./js/sidebarmenu.js"></script>
    <!--stickey kit -->
    <script src="./js/lib/sticky-kit-master/dist/sticky-kit.min.js"></script>

    <script src="./js/lib/chart-js/Chart.bundle.js"></script>
    <script src="./js/lib/chart-js/chartjs-init.js"></script>

    <!--Custom JavaScript -->
    <script src="./js/scripts.js"></script>
</body>
</c:if>
<c:if test="${sessionScope.id != 'admin'}">
	<script>
		alert("관리자만 사용가능합니다.");
		history.go(-1);
	</script>
</c:if>
</html>