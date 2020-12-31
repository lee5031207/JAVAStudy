//===================바둑판 그리기===================
let board = new Array(19);
for (let i = 0; i < board.length; i++) {
    board[i] = new Array(19);
}

for(let i=0; i<19; i++){
    let line = document.createElement("div");
    line.className = "line";
    for(let j=0; j<19; j++){
        let img = document.createElement("img");
        img.className = "none";
        if(i==0 && j==0){ //좌상단
            img.src = "resources/image/board/leftTop.JPG";
            board[i][j] = img;
            line.append(img);
        }else if(i==0 && j==18){  //우상단
            img.src = "resources/image/board/rightTop.JPG";
            board[i][j] = img;
            line.append(img);
        }else if(i==18 && j==0){ //좌하단
            img.src = "resources/image/board/leftBottom.JPG";
            board[i][j] = img;
            line.append(img);
        }else if(i==18 && j==18){ //우하단
            img.src = "resources/image/board/rightBottom.JPG";
            board[i][j] = img;
            line.append(img);
        }else if(i==0){
            img.src = "resources/image/board/top.JPG";
            board[i][j] = img;
            line.append(img);
        }else if(i==18){
            img.src = "resources/image/board/bottom.JPG";
            board[i][j] = img;
            line.append(img);
        }else if(j==0){
            img.src = "resources/image/board/left.JPG";
            board[i][j] = img;
            line.append(img);
        }else if(j==18){
            img.src = "resources/image/board/right.JPG";
            board[i][j] = img;
            line.append(img);
        }else{
            img.src = "resources/image/board/board.JPG";
            board[i][j] = img;
            line.append(img);
        }
        document.querySelector(".board").append(line);        
    }
}

// ===================돌 놓기===================
let turn = "black";
document.querySelectorAll("img").forEach((img)=>{
    img.addEventListener("click",(e)=>{
        if(img.src.slice(-9,-4) == "Black" || img.src.slice(-9,-4) == "White"){
            alert("잘못클릭하셨습니다");
        }else{
            if(turn == "black"){
                e.target.src = e.target.src.slice(0,-4)+"Black.JPG";
                e.target.className = "Black";
                turn = "white";
            }else if(turn == "white"){
                e.target.src = e.target.src.slice(0,-4)+"White.JPG";
                e.target.className = "White";
                turn = "black";
            }
        }
        console.log(turn + "차례 입니다");
    })
})









