function pagination(currentPage, totalPage) {
    let current = currentPage,
        last = totalPage,
        delta = 2,
        left = current - delta,
        right = current + delta,
        range = [],
        rangeWithDots = [],
        prevPage;
    /*
        current: Trang hiện tại,
        last : Trang cuối cùng,
        delta : Khoảng cách giữa các trang được hiển thị bên trái và bên phải trang hiện tại,
        left : Trang bắt đầu của khoảng hiển thị bên trái trang hiện tại,
        right : Trang kết thúc của khoảng hiển thị bên phải trang hiện tại,
        range : Mảng lưu trữ các trang được hiển thị,
        rangeWithDots : Mảng lưu trữ các trang với dấu "..." để biểu thị các trang bị ẩn đi,
        prevPage : lưu giá trị trang trước đó
    */

    for (let i = 1; i <= last; i++) {
        if (i == 1 || i == last || (i >= left && i <= right)
            || ((current == 1 || current == 2) && (i == 4 || i == 5))) {
            range.push(i);
        }
    }

    for (let i of range) {
        if (prevPage) {
            if (i - prevPage === 2) {
                // có 1 trang giữa i và prevPage
                rangeWithDots.push(prevPage + 1);
            } else if (i - prevPage !== 1) {
                // có nhiều hơn 1 trang giữa i và prevPage
                rangeWithDots.push("...");
            }
        }
        rangeWithDots.push(i);
        prevPage = i;
    }

    return rangeWithDots;
}

// JQuery
/*
    function renderPagination(currentPage, totalPage) {
    const paginationEl = $(".pagination");
    paginationEl.html("");
    const page = pagination(currentPage, totalPage);
    let html = `<li class="page-item ${currentPage === 1 ? "disabled" : ""}">
                <a class="page-link" href="#" aria-label="Previous" onclick="renderPagination(${currentPage - 1}, ${totalPage})">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>`;
    for (const i of page) {
        html += `<li class="page-item ${currentPage === i ? "active" : ""}"><a class="page-link" href="#" onclick="renderPagination(${i}, ${totalPage})">${i}</a></li>`
    }
    html += `<li class="page-item ${currentPage === totalPage ? "disabled" : ""}">
            <a class="page-link" href="#" aria-label="Next" onclick="renderPagination(${currentPage + 1}, ${totalPage})">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>`
    paginationEl.html(html);
}
*/

function renderPagination(currentPage, totalPage){
    const paginationEl = document.getElementById("pagination-container");
    paginationEl.innerHTML="";
    const page = pagination(currentPage, totalPage);
    let html = `<button class="btn" ${currentPage === 1 ? "disabled" : ""} onclick="renderPagination(${currentPage - 1}, ${totalPage})" type="button">&laquo;</button>`;
    for (const i of page) {
        html += `<button class="btn ${currentPage === i ? "custom-active" : ""}" onclick="renderPagination(${i}, ${totalPage})" type="button">${i}</button>`
    }
    html += `<button class="btn" ${currentPage === totalPage ? "disabled" : ""} onclick="renderPagination(${currentPage + 1}, ${totalPage})" type="button">&raquo;</button>`
    paginationEl.innerHTML = html;
}
renderPagination(1, 20);
