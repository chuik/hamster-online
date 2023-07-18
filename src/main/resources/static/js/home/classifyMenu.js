$(function() {
    initClassifyMenu();
})



function initClassifyMenu(){
    $.ajax({
        url:"/classify/getMenus",
        type:"get",
        dataType:"json",
        success(res){
            if(res.code == 200){
                let menuArray = res.data;
                let menu_ul = document.getElementById("classIfyMenuBox");
                for (let menu of menuArray) {
                    let liEl = document.createElement("li");
                    let imgEl  = document.createElement("img");
                    imgEl.setAttribute("src",menu.img);
                    let  titleEl = document.createElement("p");
                    titleEl.innerText = menu.name;
                    liEl.appendChild(imgEl);
                    liEl.appendChild(titleEl);
                    menu_ul.appendChild(liEl);
                }
            }else{
                alert(res.message)
            }
        }
    })
}