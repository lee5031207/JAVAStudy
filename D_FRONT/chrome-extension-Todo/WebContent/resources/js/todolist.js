(()=>{
	/*
		1. 사용자가 이전에 저장한 todolist가 localStorage 이미 있을 경우 화면에 출력
		2. 사용자가 todolist를 작성했을 때 localStorage 저장한 후 작성한 todolist를 화면에 출력
				todoList는 객체배열 형태로 저장
		3. 사용자가 지우개 아이콘을 클릭하면 해당 todolist를 삭제하고, localStorage에서도 삭제
	*/
	
	let todoArr = [];
	let todoContainer = document.querySelector('.frm_to-do');
	let list = document.querySelector('.list');
	
	let persistTodo = (todo) =>{
		let todoObj = {};
		let todos = localStorage.getItem('todos');

		if(todos){
			todoArr = JSON.parse(todos);
			//고유한 인덱스를 가지는 객체를 넣어준다.
			todoObj.idx = todoArr.length;
		}else{
			todoObj.idx = 0;
		}
		
		todoObj.todoStr = todo;
        todoArr.push(todoObj);
        localStorage.setItem('todos', JSON.stringify(todoArr));
	}
	
	let saveTodo = (event) =>{ //event 객체를 매개변수로 받아 
        //event가 발생한 요소의 기본 동작을 취소 시키키는 메서드
        //submit이벤트가 발생했을때 기본 동작인 데이터 전송(새로고침)을 막아준다.
        event.preventDefault();
		let todo = document.querySelector('.to-do_add').value;
		if(todo){
            persistTodo(todo);			
            paintTodo();
		}else{
			alert("할 일을 입력 해주세요.");
        }
	}
	
	let paintTodo = () => {
        list.innerHTML = "";  //list클래스 초기화
		todoArr.forEach((e) =>{
			let li = document.createElement('li');
			li.className = 'to-do';
			
			let deleteBtn = document.createElement('i');
			deleteBtn.className = "fas fa-eraser btn_del";
			deleteBtn.style.margin = '0 1vw';
			deleteBtn.addEventListener('click',()=>{
				li.outerHTML = "";
				//indexOf로 요소의 인덱스를 가져와서
				let idx = todoArr.indexOf(e);	
				//splice로 삭제
				todoArr.splice(idx,1);		
				localStorage.setItem('todos',JSON.stringify(todoArr));	
			});
			
			let todoText = document.createElement('span');
			todoText.innerHTML = e.todoStr;
			
			li.append(deleteBtn);
			li.append(todoText);
            list.appendChild(li);
            
            //입력창 초기화
            document.querySelector(".to-do_add").value = "";
		})
	}
	
	let init = ()=>{
		let todos = localStorage.getItem('todos');
		if(todos){
			//todo-list를 화면에 출력
            todoArr = JSON.parse(todos);
            paintTodo();
		}
	}	
	
	todoContainer.addEventListener('submit',saveTodo);
	init();
	
})();

