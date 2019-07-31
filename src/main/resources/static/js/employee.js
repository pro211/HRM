$(document).ready(function(){
    var tableHead = '<>' +
        '<th> # </th>' +
        '<th> Hình Ảnh </th>' +
        '<th> Mã Nhân Viên </th>' +
        '<th> Họ Và Tên </th>' +
        '<th> Mã Phòng Ban </th>' +
        '<th> Trạng Thái </th>' +
        '<th colspan="2" > Hành Động </th>' +
        '</>';
    $('#employeesTable thead').append(tableHead);
})