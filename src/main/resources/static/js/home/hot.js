$(function () {
    initHotLive(1);
})

function initHotLive(pageIndex) {
    axios({
        method: "get",
        url: "/live/getLives/" + pageIndex,
        responseType: "json"
    }).then(res => {
        let data = res.data;
        if (data.code == 200) {
            //渲染数据
            console.log("开始渲染数据...")
            renderingLiveBox(data.data);
        } else {
            alert(data.message)
        }
    })
}

function renderingLiveBox(lives) {
    let UlBox = document.getElementById("hot-box");

    for (let live of lives) {
        let li = document.createElement("li");
        //设置 直播图片
        li.appendChild(renderingImg(live.thumbnail));
        li.appendChild(renderingDesc(live));
        li.appendChild(renderingTips(live.liveStatus));

        UlBox.appendChild(li);
    }
}

function renderingImg(thumbnail) {
    let imgDiv = document.createElement("div");

    imgDiv.setAttribute("class", "img");

    let img = document.createElement("img");
    img.setAttribute("src", thumbnail)

    imgDiv.appendChild(img);
    return imgDiv;
}

function renderingDesc(live) {
    let descDiv = document.createElement("div");
    descDiv.setAttribute("class", "desc");

    let tDiv = document.createElement("div");
    tDiv.setAttribute("class", "t");
    tDiv.innerText = live.tag;
    descDiv.appendChild(tDiv);


    let infoDiv = document.createElement("div");
    infoDiv.setAttribute("class", "info");
    let span1 = document.createElement("span");
    span1.innerText = live.nickName;
    infoDiv.appendChild(span1);

    let span2 = document.createElement("span");
    span2.innerHTML = "<i class='eye'></i>123";
    infoDiv.appendChild(span2);

    descDiv.appendChild(infoDiv);

    return descDiv;
}

function renderingTips(status) {
    let tipsDiv = document.createElement("div");
    tipsDiv.setAttribute("class","tips");
    let span1 = document.createElement("span");
    span1.setAttribute("class", "l");
    span1.innerText = status == 1 ? "直播" : "回放";
    tipsDiv.appendChild(span1)

    let span2 = document.createElement("span");
    span2.setAttribute("class", "r");
    span2.innerHTML="免费";
    tipsDiv.appendChild(span2);
    return tipsDiv;
}