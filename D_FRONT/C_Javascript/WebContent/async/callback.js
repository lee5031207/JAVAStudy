//JavaScript는 동기적인 언어(Synchronous)
//호이스팅이 된 이후 부터 코드가 하나하나씩 동기적으로 실행
//Hoisting : var, function등을 먼저 선언 실행 

// Synchronous : 동기적 
// Asynchronous : 비동기적

//Callback : 나중에 다시 불러 들이는 함수 (지금 당장 실행하는 함수가 아니란 의미)
//           보통 화살표 함수 (Arrow function)


console.log(1); //동기
setTimeout(()=>{
    console.log(2) //비동기
},1000)
console.log(3); //동기


// Synchronous callback

// 1-1. printImmediately함수 선언은 호이스팅 된다
function printImmediately(print){ 
    print(); 
}
// 1-2. 함수 실행
printImmediately(()=>console.log("Hello")); //동기


// Asynchronous callback

// 2-1. printWithDelay함수 선언은 호이스팅 된다.
function printWithDelay(print, timeout){
    setTimeout(print,timeout);
}
// 2-2. 함수 실행
printWithDelay(()=>console.log("async callback"),2000); //비동기


/*============================= 1. 콜백 지옥================================== */
class UserStorage{
    loginUser(id, password, onSuccess, onError){
        setTimeout(()=>{
            if(
                (id === 'lee5031207' && password === '1234') ||
                (id === '4n0523' && password === '1234')
            ){
                onSuccess(id);
            }else{
                onError(new Error('not found'));
            }
        },2000)
    }

    getRoles(user, onSuccess, onError){
        setTimeout(()=>{
            if(user === 'lee5031207'){
                onSuccess({name:'lee5031207', role : 'admin'});
            }else{
                onError(new Error('no access'));
            }
        },1000)
    }
}

const userStorage = new UserStorage();
const id = prompt("enter your id");
const password = prompt("enter your pw");
userStorage.loginUser(
    id, 
    password,
    user=>{
        userStorage.getRoles(
            user, 
            userWithRole=>{
                alert(`Hello ${userWithRole.name}, you have a ${userWithRole.role} role`);
            },
            error=>{console.log(error)}
        )
    },
    error=>{console.log(error)}
);


