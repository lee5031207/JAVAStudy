const API_KEY = "3016b549f7ccf0b15f8387144db4f6ac";
const WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?";
const weather = document.querySelector(".weather-text");


let letlng = () => {
    return new Promise((resolve,reject)=>{
        let coord = {};
        navigator.geolocation.getCurrentPosition((position)=>{
            //위도 경도 좌표를 받아옴
            coord.lat = position.coords.latitude; 
            coord.lng = position.coords.longitude;
            resolve(coord);
        })
    })
};

function loadWeather() {
    letlng()
    .then((coord)=>{
        let url = `${WEATHER_URL}lat=${coord.lat}&lon=${coord.lng}&appid=${API_KEY}&units=metric`;
        fetch(url)
        .then(response => response.json())
        .then(json => {
            let location = json.name;
            let temp = json.main.temp;
            weather.innerHTML = `${temp}℃ ${location}`;
        })
    })    
}

loadWeather();
