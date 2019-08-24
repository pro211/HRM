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

    $('.table .eBtn').on('click',function(event){
        // validator.resetForm();
        $('#myForm .form-control').removeClass('error');
        var href = $(this).attr('href');
        console.log(href)
        $.get(href, function(map, status){
            console.log(map)
            $('.leave-form #nameEmp').val(map.employee.employeeName)
            $('.leave-form #codeEmp').attr("readonly","readonly");
            $('.leave-form #codeEmp').val(map.employee.businessName)
            $('.leave-form #employee').val(map.employee.id)
            $('.leave-form #id').val(map.leave.id)
            $('.leave-form #applyDate').val(map.leave.applyDate)
            $('.leave-form #fromDate').val(map.leave.fromDate)
            $('.leave-form #toDate').val(map.leave.toDate)
            $('.leave-form #reason').val(map.leave.reason)
            $('.leave-form #status').val(map.status.id)
        })
    });

    $('.sBtn').on('click',function(event){
        var codeEmp = $('#codeEmp').val();
        console.log(codeEmp);
        var href = '/hrm/admin/employee/findEmp/?businessName='+ codeEmp;
        $.get(href, function(employee, status) {
            console.log(employee)
            if(employee !== '' && employee !== null){
                $('.leave-form #nameEmp').val(employee.employeeName)
                $('.leave-form #employee').val(employee.id)
            }else {
                console.log('Null')
                if (codeEmp.length <2){
                    $('.leave-form #exitscodeEmp').hide();
                } else {
                    $('.leave-form #exitscodeEmp').show();
                    $('.leave-form #exitscodeEmp').text('Mã nhân viên không tồn tại!');
                    $('.leave-form #codeEmp').focus();
                }
            }
        })
    });

    $('#applyDate').datepicker({ dateFormat: "dd-mm-yy" }).val();
    $('#fromDate').datepicker({ dateFormat: "dd-mm-yy" }).val();
    $('#toDate').datepicker({ dateFormat: "dd-mm-yy" }).val();

    $('.table .dBtn').on('click',function(event){
        var href = $(this).attr('href');
        $('#deleteModal #delBtn').attr('href',href);
    });

    $('.aBtn').on('click',function(event){
        // validator.resetForm();
        $('#myForm .form-control').removeClass('');
        $('.leave-form #nameEmp').val('');
        $('.leave-form #codeEmp').removeAttr("readonly");
        $('.leave-form #codeEmp').val('');
        $('.leave-form #employee').val('');
        $('.leave-form #id').val('');
        $('.leave-form #applyDate').val('');
        $('.leave-form #fromDate').val('');
        $('.leave-form #toDate').val('');
        $('.leave-form #reason').val('');
        $('.leave-form #status').val('');
    });

    jQuery.validator.addMethod("noSpace", function(value, element) {
        return value.indexOf(" ") < 0 && value != "";
    }, "No space please and don't leave it empty");

    var validator = $('#myForm').validate({
        rules: {
            codeEmp: {
                required: true,
                minlength: 2,
                noSpace: true
            },
            code: {
                required: true,
                minlength: 2
            },
            employeeName: {
                required: true,
                lettersonly: true
            },
            applyDate: {
                required: true
            },
            fromDate: {
                required: true
            },
            toDate: {
                required: true,
            },
            reason: {
                required: true,
            },
            status: {
                required: true,
            },
        },
        messages: {
            codeEmp: {
                required: 'Mã nhân viên không được để trống!',
                minlength: 'Mã nhân viên tối thiểu 2 ký tự!',
                noSpace: 'Mã nhân viên không hợp lệ!'
            },
            code: {
                required: 'Mã hợp đồng không được để trống!',
                minlength: 'Mã nhân viên tối thiểu 2 ký tự!'
            },
            employeeName: {
                required: 'Tên phòng ban không được để trống!',
                lettersonly: 'Tên không hợp lệ!'
            },
            applyDate: {
                required: 'Bạn chưa lựa chọn ngày!',
            },
            fromDate: {
                required: 'Bạn chưa lựa chọn ngày!',
            },
            toDate: {
                required: 'Bạn chưa lựa chọn ngày!',
            },
            reason: {
                required: 'Bạn chưa nhập lý do!',
            },
            status: {
                required: 'Bạn chưa chọn trạng thái!',
            }
        }
    });

    $('#leaveFilters').hide();
    $('#leaveFilters thead').append(tableHead);

    $("#filter").on("keyup", function() {
        var inputValue = $(this).val().toLowerCase();

        $("#leaveFilters tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(inputValue) > -1)
        });
        if(inputValue.length > 0){
            $('#leavesTable').hide();
            $('#leaveFilters').show();
            $(".pagination").hide();
        }else{
            $('#leavesTable').show();
            $('#leaveFilters').hide();
            $(".pagination").show();
        }
    });
})