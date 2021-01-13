(()=>{
    let todoArr = [];
    let todoContainer = document.querySelector('.frm_to-do');
    let list = document.querySelector('.list');
    
    let saveTodo = () =>{
       let todo = document.querySelector('.to-do_add').value;
       if(todo){
          let todos = localStorage.getItem('todos');
          if(todos){
             todoArr = JSON.parse(todos);
             todoArr.push(todo);
          }else{
             todoArr.push(todo);
          }
          
          localStorage.setItem('todos', JSON.stringify(todoArr));
       }else{
          alert("할 일을 입력 해주세요.");
       }
    }
    
    let paintTodo = () => {
       todoArr.forEach((e,i) =>{
          let todoIdx = 'to-do-' + i;
          let deleteBtn = '<i class="fas fa-trash del_todo" data-id="'+todoIdx+'"></i>';
          list.innerHTML += '<li class="to-do" id="'+todoIdx+'">' + e + '</li>';
          document.querySelector('#'+todoIdx).innerHTML 
             = deleteBtn + document.querySelector('#'+todoIdx).innerHTML;
       })
    }
    
    todoContainer.addEventListener('submit',saveTodo);
    
    let init = ()=>{
       let todos = localStorage.getItem('todos');
       if(todos){
          //todo-list를 화면에 출력
          todoArr = JSON.parse(todos);
          paintTodo();
       }
    }   
    
    init();
    
 })();
 
 