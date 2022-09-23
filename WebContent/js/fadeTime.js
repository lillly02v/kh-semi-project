var myVar;
function myFunction() {
	myVar = setTimeout(showPage, 3500);
}
function showPage() {
	document.getElementById("load").style.display = "none";
	document.getElementById("myDiv").style.display = "block";
}