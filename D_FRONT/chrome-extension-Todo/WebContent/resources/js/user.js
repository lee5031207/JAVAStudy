const nameContainer = document.querySelector(".name");

let paintName = name =>{
    let nameText = `<span class="name-text">Hello ${name}!</span>`
    nameContainer.innerHTML = nameText;
}

let paintInput = () =>{
    let input = document.createElement("input");
    input.placeholder = "Write your name here";
    input.type = "text";
    input.className = "inp_name";
    let form = document.createElement("form");
    form.addEventListener("submit", handleSubmit);
    form.appendChild(input);
    nameContainer.appendChild(form); 
}
let init = () => {
    let name = localStorage.getItem("userName");
    if(name){
        paintName(name);
    }else{
        paintInput();
    }
}

let handleSubmit = () =>{
    let nameText = document.querySelector(".inp_name").value;
    localStorage.setItem("userName",nameText);
}


//localStorage에서 "userName" 이라는 키 값을 가진 데이터가 
//존재하면 Welecome 이름!! 출력
//존재하지 않으면 이름을 입력하기 위한 창을 출력
init();

