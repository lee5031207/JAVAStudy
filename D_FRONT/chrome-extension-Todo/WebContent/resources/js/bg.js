const UNSPLASH_API_KEY = "P48sIBFRsCEXX2TqRu-QFGGcI3IArUqCsPZ47Tazjns";
const UNSPLASH_URL = "https://api.unsplash.com/photos/random";
const body = document.querySelector("body");
const locationContainer = document.querySelector(".location-text");

let getBackground = () =>{
    let url = `${UNSPLASH_URL}?client_id=${UNSPLASH_API_KEY}&query=landscape&orientation=landscape`;
    fetch(url)
    .then(response => response.json())
    .then(json => {
        saveBackground(json.urls.full, json.alt_description);
        body.style.backgroundImage = `url(${json.urls.full})`;
        locationContainer.innerHTML = json.alt_description;
    })
}

let saveBackground = (imgurl, desc) => {
    let maxDate = new Date();
    maxDate.setDate(maxDate.getDate() + 1);
    const imageObject = {
        url : imgurl,
        maxDate : maxDate,
        desc : desc
    }
    localStorage.setItem("bg",JSON.stringify(imageObject));
}

//만약 최근 api통신으로 부터 하루가 지난 상황이면 새롭게 통신을 해서
//새 이미지를 불러오고
//그렇지 않다면 localStorage에 저장한 이미지로 배경이미지를 사용한다.
let loadBackground = () => {
    let savedImage = localStorage.getItem("bg");

    if(savedImage){
        let parsedImg = JSON.parse(savedImage);
        let today = new Date();
        //만기일자가 지남
        if(today > parsedImg.maxDate){
            getBackground();
        }else{
            body.style.backgroundImage = `url(${parsedImg.url})`;
            locationContainer.innerHTML = parsedImg.desc;
        }
    }else{
        getBackground();
    }
}

loadBackground();