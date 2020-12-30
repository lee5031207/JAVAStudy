let board = new Array(19);
for (let i = 0; i < board.length; i++) {
    board[i] = new Array(19);
}

for(let i=0; i<19; i++){
    let line = document.createElement("div");
    line.className = "line";
    for(let j=0; j<19; j++){
        let img = document.createElement("img");
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

document.querySelectorAll("img").forEach((e)=>{
    let originalSrc = e.src;
    e.addEventListener("mouseenter",(e)=>{
        console.log(originalSrc.slice(0,-4));
        e.target.src = originalSrc.slice(0,-4)+"Mouse.JPG";
    })
    
    e.addEventListener("mouseleave",(e)=>{
        e.target.src = originalSrc;
    })
})

document.querySelectorAll("img").forEach((img)=>{
    img.addEventListener("click",(e)=>{
        e.target.src = "resources/image/board/boardBlack.JPG";
    })
})
//돌 놓는거 문제 해결해야함

