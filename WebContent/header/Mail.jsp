<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
<style>
* {box-sizing: border-box;}

.slimScrollDiv {
  display: none;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

</style>
<body>
	<div class="dropdown-menu dropdown-menu-right mailbox animated zoomIn"
		aria-labelledby="2">
		<ul>
			<li>
				<div class="drop-title">You have 4 new messages</div>
			</li>
			<li style="overflow: visible;">
				<div class="slimScrollDiv"
					style="position: absolute; overflow-x: visible; overflow-y: hidden; width: auto; height: 250px;">
					<div class="message-center"
						style="overflow: hidden; width: auto; height: 250px;">
						<!-- Message -->
						<a href="#">
							<div class="mail-contnet">
								<h5>Michael Qin</h5>
								<span class="mail-desc">Just see the my admin!</span> <span
									class="time">9:30 AM</span>
							</div>
						</a>
						<!-- Message -->
						<a href="#">
							<div class="mail-contnet">
								<h5>John Doe</h5>
								<span class="mail-desc">I've sung a song! See you at</span> <span
									class="time">9:10 AM</span>
							</div>
						</a>
						<!-- Message -->
						<a href="#">
							<div class="mail-contnet">
								<h5>Mr. John</h5>
								<span class="mail-desc">I am a singer!</span> <span class="time">9:08
									AM</span>
							</div>
						</a>
						<!-- Message -->
						<a href="#">
							<div class="mail-contnet">
								<h5>Michael Qin</h5>
								<span class="mail-desc">Just see the my admin!</span> <span
									class="time">9:02 AM</span>
							</div>
						</a>
					</div>
					<div class="slimScrollBar"
						style="background: rgb(220, 220, 220); width: 5px; position: absolute; top: 0px; opacity: 0.4; display: block; border-radius: 7px; z-index: 99; right: 1px;"></div>
					<div class="slimScrollRail"
						style="width: 5px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 1px;"></div>
				</div>
			</li>
			<li><a class="nav-link text-center" href="javascript:void(0);">
					<strong>See all e-Mails</strong> <i class="fa fa-angle-right"></i>
			</a></li>
		</ul>
	</div>
</body>
</html>