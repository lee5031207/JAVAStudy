(()=>{ 

document.querySelector(".btn_nav:first-child").style.backgroundColor = "red";

document.querySelectorAll(".btn_nav").forEach((e)=>{
    e.addEventListener("click",()=>{
        document.querySelectorAll(".btn_nav").forEach((btn)=>{
            btn.style.backgroundColor = "white";
            e.style.backgroundColor = "red";
            let slide = document.querySelector(".slide-contents");
            slide.style.transition = "1s";
            slide.style.transform = `translateX(-${e.dataset.slideIdx * 50}vw)`;
            //console.log(slide.style.transform);
        })
    })
})

let leftBtn = document.querySelector(".fa-chevron-left");
let rightBtn = document.querySelector(".fa-chevron-right");

leftBtn.addEventListener("click",(e)=>{
    //사진 옮기기
    let slide = document.querySelector(".slide-contents");
    let originTransform = slide.style.transform;
    let originVal = originTransform.replace(/[^0-9]/g,'');
    slide.style.transition = "1s";
    slide.style.transform = `translateX(-${Number(originVal)-50}vw)`;
    //red버튼 옮기기
    let arr = document.querySelectorAll(".btn_nav");
    let redIdx = 0;
    for(let i=0; i<arr.length; i++){
        if(arr[i].style.backgroundColor == "red"){
            redIdx = i;
        }
    }
    document.querySelector("#idx"+redIdx).style.backgroundColor = "white";
    document.querySelector("#idx"+(redIdx-1)).style.backgroundColor = "red";
})

rightBtn.addEventListener("click",(e)=>{
    //사진 옮기기
    let slide = document.querySelector(".slide-contents");
    if(slide.style.transform.replace(/[^0-9]/g,'')>=150){
        slide.style.transform = "translateX(-150vw)";
    }else{
        let originTransform = slide.style.transform;
        let originVal = originTransform.replace(/[^0-9]/g,'');
        slide.style.transition = "1s";
        slide.style.transform = `translateX(-${Number(originVal)+50}vw)`;
    }
    //red버튼 옮기기
    let arr = document.querySelectorAll(".btn_nav");
    let redIdx = 0;
    for(let i=0; i<arr.length; i++){
        if(arr[i].style.backgroundColor == "red"){
            redIdx = i;
        }
    }
    document.querySelector("#idx"+redIdx).style.backgroundColor = "white";
    document.querySelector("#idx"+(redIdx+1)).style.backgroundColor = "red";
})

})();

//즉시 실행 함수 IIFE
//전역변수를 보호? 하기 위해 서 자바 스크립트에서 사용하는 함수
//   (()=>{
    //여기에 코드를 작성하자
//      })()