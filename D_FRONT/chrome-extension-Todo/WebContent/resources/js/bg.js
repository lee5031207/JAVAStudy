(()=>{
    const UNSPLASH_API_KEY = "P48sIBFRsCEXX2TqRu-QFGGcI3IArUqCsPZ47Tazjns"; //UNSPLASH API키
    const UNSPLASH_URL = "https://api.unsplash.com/photos/random"; //UNSPLASH API키 url (document참고)
    const body = document.querySelector("body"); 
    const locationContainer = document.querySelector(".location-text");
    
    let getBackground = () =>{ //API 통신하고 화면에 보여주는 함수
        let url = `${UNSPLASH_URL}?client_id=${UNSPLASH_API_KEY}&query=landscape&orientation=landscape`;
        fetch(url)
        .then(response => response.json())
        .then(json => {
            let imgUrl = json.urls.full;
            let desc = json.alt_description;
            if(desc){
                saveBackground(imgUrl,desc); 
                paintBackground(imgUrl,desc);
            }else{
                getBackground();
            }
            
        })
    }
    
    let paintBackground = (url, desc) =>{
        body.style.backgroundImage = `url(${url})`;
        locationContainer.innerHTML = desc;
    }
    
    let saveBackground = (imgurl, desc) => { //localStorage에 저장 하는 함수
        let maxDate = new Date();
        maxDate.setDate(maxDate.getDate() + 1);
        const imageObject = {
            url : imgurl,
            maxDate : maxDate,
            desc : desc
        }
        localStorage.setItem("bg",JSON.stringify(imageObject));
    }
    
    let loadBackground = (parsedImg) =>{
        let today = new Date(); //오늘 날짜 
        //만기일자가 지남
        if(today > parsedImg.maxDate){ //오늘이 maxDate를 지났다면 
            getBackground(); 
        }else{ //그렇지 않다면 local저장소에 저장된 url,desc를 화면에 표시
            paintBackground(parsedImg.url, parsedImg.desc);
        }
    }
    
    let init = () => {
        let parsedImg = JSON.parse(localStorage.getItem("bg")); 
        if(parsedImg){ //lovalStoragr에 'bg'라는 키값이 있다
            loadBackground(parsedImg);
        }else{ //lovalStoragr에 'bg'라는 키값이 없다
            getBackground();
        }
    }
    init();
})();
