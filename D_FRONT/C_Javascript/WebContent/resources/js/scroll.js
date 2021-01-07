

document.addEventListener("wheel",(e)=>{
    let contendDiv = document.createElement("div");

    //document.querySelector("body").clientHeight : 내가 보고 있는 뷰의 높이
    console.dir(`scrollY : ${scrollY} / clientHeight : ${document.querySelector("body").clientHeight} / screen.availHeight : ${screen.availHeight}`);
    if(scrollY > document.querySelector("body").clientHeight - screen.availHeight){
        if(document.querySelector(".wrapper").lastElementChild.className == "scaii1 content"){
            contendDiv.className = "scaii2 content"    
        }else{
            contendDiv.className = "scaii1 content"
        }
        document.querySelector(".wrapper").appendChild(contendDiv);
    }
    
})