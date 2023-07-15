
$(function () {
    lodeLives();
})

function lodeLives() {

    $.ajax({
        url: "/live/getLives",
        type: "get",
        dataType: "json",
        success(res) {

            if (res.code == 200) {
                let lives = res.data;
                let livesBox = document.getElementById("lives");
                for (let life of lives) {
                    livesBox.appendChild(addlive(life));
                }
            } else {
                alert(res.message);
            }
        }
    })

}



// function loadliveInfo(){
//     $.ajax({
//         url: "live/getLive",
//         type: "get",
//         dataType: "json",
//         success(res){
//             if (res.code == 200){
//                 let liveInfos= res.data;
//                 let live_ul = document.getElementById("lives");
//                 for (let liveInfo of liveInfos) {
//
//                     //图片
//                     let liveEl = document.createElement("li");
//                     let divEl = document.createElement("div");
//                     divEl.setAttribute("class", "img");
//                     let imgEl = document.createElement("img");
//                     imgEl.setAttribute("src",liveInfo.thumbnail);
//                     // imgEl.appendChild(imgEl);
//
//
//                     //直播状态
//                     let liveStatusEl = document.createElement("div");
//                     liveStatusEl.setAttribute("class", "tips");
//                     let spanEl = document.createElement("span");
//                     spanEl.setAttribute("class", "l");
//                     spanEl.innerText = liveInfo.live_status;
//                     liveStatusEl.appendChild(spanEl);
//
//
//
//                     // 标签
//                     let tagEl = document.createElement("div");
//                     tagEl.setAttribute("class", "desc");
//                     let titleEl = document.createElement("div");
//                     titleEl.setAttribute("class", "t");
//                     titleEl.innerText=liveInfo.tag;
//                     tagEl.appendChild(titleEl);
//
//                     //图片
//                     liveEl.appendChild(imgEl);
//                     //直播状态
//                     liveEl.appendChild(liveStatusEl);
//                     //标签
//                     liveEl.appendChild(tagEl);
//                     live_ul.appendChild(liveEl);
//                 }
//             }else {
//                 alert(res.message);
//             }
//         }
//
//     })
// }



function addlive(live) {
    let li = document.createElement("li");
    var flag;
    var type;
    var money;
    if (live.liveStatus==1) {
        flag="直播";
        type="eye";
    }else if (live.liveStatus==2){
        flag="回放";
        type="play"
    }
    li.innerHTML='      <div class="img">\n' +
        '        <img src="'+live.thumbnail+'">\n' +
        '      </div>\n' +
        '      <div class="desc">\n' +
        '        <div class="t">'+live.liveTitle+'</div>\n' +
        '        <div class="info">\n' +
        '          <span>酷酷炫炫、</span>\n' +
        '          <span><i class="eye"></i>1.2万</span>\n' +
        '        </div>\n' +
        '      </div>\n' +
        '      <div class="tips">\n' +
        '        <span class="l">'+flag+'</span>\n' +
        '        <span class="r">'+live.tag+'</span>\n' +
        '      </div>';




    return li;
}

// <div className="img">\n' +
//     // '<img src="'+live.thumbnail+'">\n' +
//         //
//         //
//         // '</div>
// \n' +
// // '
// <div className="desc">\n' +
//     // '
//     <div className="t">'+live.liveTitle+'</div>
//     \n' +
//     // '
//     <div className="info">\n' +
//         // '
//     </div>
//     \n' +
//     // '</div>
// \n' +
// // '
// <div className="tips">\n' +
//     //
//     // '<span className="l">'+flag+'</span>\n' +
//     // '<span className="r">'+live.tag+'</span>\n' +
//     // '</div>
// '
//
// '
// <img src="'+live.thumbnail+'">'+
//
//     <div className="desc">
//         <div className="t">'+live.liveTitle+'</div>
//         <div className="info">
//             <span></span>
//             <span><i className="eye"></i></span>
//         </div>
//     </div>
//     <div className="tips">
//         <span className="l">'+flag+'</span>
//         <span className="r">'+live.tag+'</span>
//     </div>