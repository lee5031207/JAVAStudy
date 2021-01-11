class UserStorage{
    loginUser(id, password){
        return new Promise((resolve, reject)=>{
            setTimeout(()=>{
                if(
                    (id === 'lee5031207' && password === '1234') ||
                    (id === '4n0523' && password === '1234')
                ){
                    resolve(id);
                }else{
                    reject(new Error('not found'));
                }
            },2000)
        });
    }

    getRoles(user){
        return new Promise((resolve,reject)=>{
            setTimeout(()=>{
                if(user === 'lee5031207'){
                    resolve({name:'lee5031207', role : 'admin'});
                }else{
                    reject(new Error('no access'));
                }
            },1000)
        })
    }
}

const userStorage = new UserStorage();
const id = prompt("enter your id");
const password = prompt("enter your pw");

userStorage.loginUser(id,password)
.then(user=>userStorage.getRoles(user))
.then(user => alert(`Hello ${user.name}, you have a ${user.role} role`))
.catch(console.log());





