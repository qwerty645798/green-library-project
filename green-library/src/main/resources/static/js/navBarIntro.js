

let navRouteli = document.querySelectorAll('.navList li');
navRouteli = Array.from(navRouteli);

let imHere = window.location.href.split("/");

//도서관 이용. 바로가기 리스트
navRouteli[0].onclick = () => window.location.href = "/vision";
navRouteli[1].onclick = () => window.location.href = "/wayToCome";
navRouteli[2].onclick = () => window.location.href = "/facilityInfo";

if(imHere[3]=="vision"){
	navRouteli[0].classList.add("curPlace");
}
if(imHere[3]=="wayToCome"){
	navRouteli[1].classList.add("curPlace");
}
if(imHere[3]=="facilityInfo"){
	navRouteli[2].classList.add("curPlace");
}


