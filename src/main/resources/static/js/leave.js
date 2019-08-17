$(document).ready(function() {
    var tableHead = '<>' +
        '<th> # </th>' +
        '<th> Mã Nhân Viên </th>' +
        '<th> Họ Và Tên </th>' +
        '<th> Lý do </th>' +
        '<th> Ngày Xin Nghỉ </th>' +
        '<th> Ngày Bắt Đầu </th>' +
        '<th> Ngày Kết Thúc </th>' +
        '<th> Trạng Thái </th>' +
        '<th colspan="2" > Hành Động </th>' +
        '</>';
    $('#leavesTable thead').append(tableHead);
})