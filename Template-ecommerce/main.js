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

$(document).ready(function(){
    $('.slick-list').slick({
        slidesToShow: 4,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 3000,
        prevArrow: $('.slick-prev'),
        nextArrow: $('.slick-next')
    });
  });