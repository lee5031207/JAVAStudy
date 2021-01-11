
// Promise : 자바스크립트 내장 객체
// 비동기적인 것을 처리할때 콜백 함수 대신 사용
// 상태(state)
// 1. pending : Promise의 연산이 완료되지 않은 상태.
// 2. fullfilled : Promise의 연산이 성공적으로 완료된 상태. / resolve() 메서드가 호출된 상태
// 3. rejected : Promise의 연산이 실패한 상태 

// 1.Producer
// !!새로운 프로미스가 만들어질때 executer가 바로 실행된다.
const promise = new Promise((resolve, reject) =>{
    //비동기적인 행동(시간이 조금 걸리는 일, ex.네트워크, 파일 읽기 등)
    console.log("doing something");
    setTimeout(()=>{
        //resolve('성욱');
        reject(new Error('no network'));
    },2000)
})

// 2.Consumers : then, catch, finally
promise.then((value)=>{ //value : resolve에서 전달한 값 (성욱)
    console.log(value);
}).catch(error =>{
    console.log(error);
}).finally(()=>{
    //무조건 실행되는 finally
    console.log('finally');
})


// 3. Promise 체이닝
const fetchNumber = new Promise((resolve,reject) =>{
    setTimeout(()=>{
        resolve(1);
    },1000)
})

fetchNumber.then(num => num * 2)
.then(num => num * 3)
.then(num =>{
    return new Promise((resolve, reject)=>{
        setTimeout(()=>{
            resolve(num-1)
        },1000)
    })
})
.then(num => console.log(num));