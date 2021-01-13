(()=>{
    let todoArr= [];
    let list = document.querySelector(".list");
    let todoContainer = document.querySelector('.frm_to-do');

    let saveTodo = () => {
        let todo = document.querySelector(".to-do_add").value;
        if(todo){
            let todos = localStorage.getItem("todos");
            if(todos){
                todoArr = JSON.parse(todos);
                //객체 형식으로 넣어줌 index를 넣어줘야 하기 때문에
                let todoObj = {idx:todoArr.length, todoStr:todo}
                todoArr.push(todoObj);
            }else{
                let todoObj = {idx:0, todoStr:todo}
                todoArr.push(todoObj);
            }
            localStorage.setItem('todos',JSON.stringify(todoArr));
        }else{
            alert("할 일을 입력해주세요");
        }
    }

    let paintTodo = () => {
        todoArr.forEach((e,i)=>{
            let deleteBtn = document.createElement("i");
            deleteBtn.className = "fas fa-trash-alt";
            deleteBtn.style.margin = "0 1vw";

            deleteBtn.addEventListener("click",()=>{
                deleteBtn.parentElement.outerHTML = "";   
                let idx = todoArr.indexOf(e); 
                todoArr.splice(idx,1); //삭제하기
                localStorage.setItem('todos',JSON.stringify(todoArr)); //문자열로 변환해 삽입
            })
            let li = document.createElement("li");
            li.className = "to-do";
            let todoText = document.createElement("span");
            todoText.innerHTML = e.todoStr;
            
            li.append(todoText);
            li.prepend(deleteBtn);
            list.appendChild(li);
        })
    }

    todoContainer.addEventListener("submit", saveTodo);

    let init = () => {
        let todos = localStorage.getItem('todos');
        if(todos){
            todoArr = JSON.parse(todos);
            paintTodo();
        }else{

        }
    }

    init();

})();









