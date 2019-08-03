$(document).ready(function() {
    var tableHead = '<>' +
        '<th> # </th>' +
        '<th> Họ Và Tên </th>' +
        '<th> Phân Loại </th>' +
        '<th> Ngày Áp Dụng </th>' +
        '<th> Lý Do </th>' +
        '<th colspan="2" > Hành Động </th>' +
        '</>';
    $('#achievementsTable thead').append(tableHead);
})