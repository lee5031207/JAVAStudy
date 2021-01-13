const clockContainer = document.querySelector(".clock-text");

let getTime = () =>{
    let now = new Date();
    let hours = now.getHours();
    let minutes = now.getMinutes();
    let seconds = now.getSeconds();

    hours = hours < 10 ? "0"+hours : hours;
    minutes = minutes < 10 ? "0"+minutes : minutes;
    seconds = seconds < 10 ? "0"+seconds : seconds;
    clockContainer.innerHTML = `${hours}:${minutes}:${seconds}`;
}
getTime();
setInterval(getTime,1000);