(()=>{

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
    
    let saveWeather = (location,temp) => {
        let weatherObj = {};
        let maxAge = new Date();
        maxAge = maxAge.setHours(maxAge.getHours()+1);
        weatherObj.loc = location;
        weatherObj.temp = temp;
        weatherObj.maxAge = maxAge;
        localStorage.setItem("weather", JSON.stringify(weatherObj));
    }

    let getWeather = () => {
        letlng()
        .then((coord)=>{
            let url = `${WEATHER_URL}lat=${coord.lat}&lon=${coord.lng}&appid=${API_KEY}&units=metric`;
            fetch(url)
            .then(response => response.json())
            .then(json => {
                saveWeather(json.name,json.main.temp);
                loadWeather(json.name,json.main.temp);
            })
        })
    }
    
    function loadWeather(parsedWeather) {
        let now = new Date();
        if(now>parsedWeather.maxAge){
            getWeather();
        }else{
            weather.innerHTML = `${parsedWeather.temp}℃ ${parsedWeather.loc}`;
        }
        
    }
    
    let init = () => {
        let parsedWeather = JSON.parse(localStorage.getItem("weather"));
        if(parsedWeather){
            loadWeather(parsedWeather);
        }else{
            getWeather();
        }
    }
    
    init();

})();