const showLoginForm = () => {
    document.getElementById('login-form').style.display = 'block';
    document.getElementById('register-form').style.display = 'none';
    document.querySelector('#authModal .form-title').innerText = 'Đăng nhập';
}
const showRegisterForm = () => {
    document.getElementById('login-form').style.display = 'none';
    document.getElementById('register-form').style.display = 'block';
    document.querySelector('#authModal .form-title').innerText = 'Đăng ký';
}

const showHidePassEl = document.querySelectorAll('.show-hide-password');
showHidePassEl.forEach(e => {
    e.addEventListener('click', () => {
        const inputEl = e.previousElementSibling;
        if(inputEl.type === "password"){
            inputEl.setAttribute('type', 'text')
            e.innerHTML = '<i class="fa-regular fa-eye"></i>'
        } else {
            inputEl.setAttribute('type', 'password')
            e.innerHTML = '<i class="fa-regular fa-eye-slash"></i>'
        }
    })
})

// $(document).ready(function(){
//     $('.slick-list').slick({
//         slidesToShow: 4,
//         slidesToScroll: 1,
//         autoplay: true,
//         autoplaySpeed: 3000,
//         prevArrow: $('.slick-prev'),
//         nextArrow: $('.slick-next')
//     });
//   });

{/* <div class="grid__column product-loading" style="position: relative">
<div class="product-grid product">
<div class="product-grid__thumbnail">
<div class="product-grid__image"></div>
</div>
<div class="product-grid__content" data-collection-tag>
<h3 class="product-grid__title">
</h3>
<div class="product-grid__prices">
</div>
</div>
</div>
</div> */}
// document.addEventListener('DOMContentLoaded', function() {
//     let load = false;
//     function bannerSliderSlick() {
//         $(`[rel-script="product-slider"]`).slick({
//             slidesToShow: 5,
//             slidesToScroll: 5,
//             centerPadding: '30px',
//             arrows: true,
//             dots: false,
//             loop: true,
//             infinite: true,
//             speed: 300,
//             gap: 32,
//             autoplay: true,
//             autoplaySpeed: 4000,
//             pauseOnHover: true
//         });
//     }

//     function getProductByCollectionId(container,ids) {
//         if (!ids) return;
//         const API_URL =
//             `${window.location.origin}/get-product-by-collection-id?collections=${ids}`;
//         $.ajax({
//             url: API_URL,
//             type: "GET",
//             cache: false,
//         }).done(function (res) {
//             if (res.success) {
//                 if (res.html != '') {
//                     container.html(res.html);
//                     bannerSliderSlick();
//                 }
//             }
//         })
//     }


//     jQuery(document).ready(function($) {
//         let loading = `
//             <div class="grid__column product-loading" style="position: relative">
// <div class="product-grid product">
// <div class="product-grid__thumbnail">
//     <div class="product-grid__image"></div>
// </div>
// <div class="product-grid__content" data-collection-tag="">
//     <h3 class="product-grid__title">
//     </h3>
//     <div class="product-grid__prices">
//     </div>
// </div>
// </div>
// </div>
//             <div class="grid__column product-loading" style="position: relative">
// <div class="product-grid product">
// <div class="product-grid__thumbnail">
//     <div class="product-grid__image"></div>
// </div>
// <div class="product-grid__content" data-collection-tag="">
//     <h3 class="product-grid__title">
//     </h3>
//     <div class="product-grid__prices">
//     </div>
// </div>
// </div>
// </div>
//             <div class="grid__column product-loading" style="position: relative">
// <div class="product-grid product">
// <div class="product-grid__thumbnail">
//     <div class="product-grid__image"></div>
// </div>
// <div class="product-grid__content" data-collection-tag="">
//     <h3 class="product-grid__title">
//     </h3>
//     <div class="product-grid__prices">
//     </div>
// </div>
// </div>
// </div>
//             <div class="grid__column product-loading" style="position: relative">
// <div class="product-grid product">
// <div class="product-grid__thumbnail">
//     <div class="product-grid__image"></div>
// </div>
// <div class="product-grid__content" data-collection-tag="">
//     <h3 class="product-grid__title">
//     </h3>
//     <div class="product-grid__prices">
//     </div>
// </div>
// </div>
// </div>
//         `
//         let loadContent = false;
//         let seo_alias = 'san-pham-moi';
//         // $(window).on('scroll',function (e) {
//             // if(!loadContent) {
//                 indexLoadMoreCollections(seo_alias, ['sub_items=','limit=30','flatten=true','random_focus=true'], 1, function (res) {
//                     const {html, success, is_next_page} = res;
//                     if (success && html != '') {
//                         $('[rel-script="product-slider"]').html(html);
//                         bannerSliderSlick();
//                     }
//                 })
//                 loadContent = true
//             // }
//         // })


//         $(document).on('click','[rel-script="tab-featured-products"]',function (e){
//             e.preventDefault();
//             const _this = $(this);
//             const seo_alias = _this.attr('data-value');
//             _this.siblings().removeClass('active');
//             _this.addClass('active');
//             $(`[rel-script="product-slider"]`).slick('unslick');
//             $(`[rel-script="product-slider"]`).html(loading);
//             indexLoadMoreCollections(`${seo_alias}`, ['sub_items=','limit=15','flatten=true','random_focus=true'], 1, function (res) {
//                 const {html, success, is_next_page} = res;
//                 if (success && html != '') {
//                     $(`[rel-script="product-slider"]`).html(html);
//                     bannerSliderSlick();
//                 }
//             })
//         });
//     });
// });