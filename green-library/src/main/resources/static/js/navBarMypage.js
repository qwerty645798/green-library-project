

let navRouteli = document.querySelectorAll('.navList li');
navRouteli = Array.from(navRouteli);

let imHere = window.location.href.split("/");

//마이페이지. 바로가기 리스트
navRouteli[0].onclick = () => window.location.href = "/user/userInfo";
navRouteli[1].onclick = () => window.location.href = "/user/myWritten";
navRouteli[2].onclick = () => window.location.href = "/user/userInquiryCreate";

if(imHere[4]=="userInfo"){
	navRouteli[0].classList.add("curPlace");
}
if(imHere[4]=="myWritten"||
imHere[4].includes("userInquiryDetail")||
imHere[4].includes("wishBook"))
{
	navRouteli[1].classList.add("curPlace");
}
if(imHere[4]=="userInquiryCreate"
){
	navRouteli[2].classList.add("curPlace");
}


