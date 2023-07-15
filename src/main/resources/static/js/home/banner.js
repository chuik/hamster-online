
//页面加载完毕立即触发
$(function (){
    //页面加载完毕之后,立刻触发一个异步请求，去获取轮播图  并渲染
    loadBannerList();
    bannerInit();
})


function loadBannerList(){
    $.ajax({
        url:"banner/list",
        type:"get",
        dataType:"json",
        async:false,
        success(res){
            if (res.code==200){
                let bannerArray=res.data;
                if (bannerArray.length>0){
                    //获取  承载banner 的盒子元素
                    let bannerBox=document.getElementById("banner-box");
                    for (let banner of bannerArray){
                        //创建一个元素  ，追加到bannerBox元素中去
                        let bannerItem = document.createElement("div");
                        bannerItem.setAttribute("class","swiper-slide");
                        let img = document.createElement("img");
                        img.setAttribute("src",banner.url);
                        bannerItem.appendChild(img);
                        bannerBox.appendChild(bannerItem);
                    }
                }

            }

        }
    })
}


function bannerInit(){
    //轮播图 用的是swiper组件
    swiper = new Swiper('.slider .swiper-container', {
        watchSlidesProgress: true,
        slidesPerView: 'auto',
        centeredSlides: true,
        loop: true,
        loopedSlides: 3,
        autoplay: true,
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
        pagination: {
            el: '.swiper-pagination'
        },
        observer:true,
        observeParents:true,
        on: {
            progress: function(progress) {
                for (i = 0; i < this.slides.length; i++) {
                    var slide = this.slides.eq(i);
                    var slideProgress = this.slides[i].progress;
                    modify = 1;
                    if (Math.abs(slideProgress) > 1) {
                        modify = (Math.abs(slideProgress) - 1) * 0.3 + 1;
                    }
                    translate = slideProgress * modify * 0.8 + 'rem';
                    scale = 1 - Math.abs(slideProgress) / 5;
                    zIndex = 999 - Math.abs(Math.round(10 * slideProgress));
                    slide.transform('translateX(' + translate + ') scale(' + scale + ')');
                    slide.css('zIndex', zIndex);
                    slide.css('opacity', 1);
                    if (Math.abs(slideProgress) > 3) {
                        slide.css('opacity', 0);
                    }
                }
            },
            setTransition: function(transition) {
                for (var i = 0; i < this.slides.length; i++) {
                    var slide = this.slides.eq(i)
                    slide.transition(transition);
                }

            }
        }
    })
}