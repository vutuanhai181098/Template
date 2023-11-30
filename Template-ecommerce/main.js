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