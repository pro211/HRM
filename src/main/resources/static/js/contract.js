$(document).ready(function() {
    var tableHead = '<>' +
        '<th> # </th>' +
        '<th> Mã Hợp Đồng </th>' +
        '<th> Loại Hợp Đồng </th>' +
        '<th> Mã Nhân Viên </th>' +
        '<th> Họ Và Tên </th>' +
        '<th> Chức Vụ </th>' +
        '<th> Thời Gian </th>' +
        '<th colspan="2" > Hành Động </th>' +
        '</>';
    $('#contractsTable thead').append(tableHead);
})