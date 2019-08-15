$(document).ready(function() {
    var tableHead = '<>' +
        '<th> # </th>' +
        '<th> Mã Nhân Viên </th>' +
        '<th> Họ Và Tên </th>' +
        '<th> Loại </th>' +
        '<th> Ngày Áp Dụng </th>' +
        '<th> Lý Do </th>' +
        '<th> Số Tiền (VND) </th>' +
        '<th colspan="2" > Hành Động </th>' +
        '</>';
    $('#achievementsTable thead').append(tableHead);

    $('.table .eBtn').on('click',function(event){
        validator.resetForm();
        $('#myForm .form-control').removeClass('error');
        var href = $(this).attr('href');
        console.log(href)
        $.get(href, function(map, status){
            console.log(map)
            $('.achievement-form #nameEmp').val(map.employee.employeeName)
            $('.achievement-form #codeEmp').attr("readonly","readonly");
            $('.achievement-form #codeEmp').val(map.employee.businessName)
            $('.achievement-form #employee').val(map.employee.id)
            $('.achievement-form #id').val(map.achievement.id)
            $('.achievement-form #type').val(map.achievement.type ? 1 : 0)
            $('.achievement-form #applyDate').val(map.achievement.applyDate)
            $('.achievement-form #amount').val(map.achievement.amount)
            $('.achievement-form #reason').val(map.achievement.reason)
        })
    });

    $('.aBtn').on('click',function(event){
        validator.resetForm();
        $('#myForm .form-control').removeClass('error');
        $('.achievement-form #nameEmp').val('')
        $('.achievement-form #codeEmp').removeAttr("readonly");
        $('.achievement-form #codeEmp').val('')
        $('.achievement-form #employee').val('')
        $('.achievement-form #id').val('')
        $('.achievement-form #type').val(1)
        $('.achievement-form #applyDate').val('')
        $('.achievement-form #amount').val('')
        $('.achievement-form #reason').val('')
    });

    $('.sBtn').on('click',function(event){
        var codeEmp = $('#codeEmp').val();
        console.log(codeEmp);
        var href = '/hrm/admin/employee/findEmp/?businessName='+ codeEmp;
        $.get(href, function(employee, status) {
            console.log(employee)
            if(employee !== '' && employee !== null){
                $('.achievement-form #nameEmp').val(employee.employeeName)
                $('.achievement-form #employee').val(employee.id)
            }else {
                console.log('Null')
                if (codeEmp.length <2){
                    $('.achievement-form #exitscodeEmp').hide();
                } else {
                    $('.achievement-form #exitscodeEmp').show();
                    $('.achievement-form #exitscodeEmp').text('Mã nhân viên không tồn tại!');
                    $('.achievement-form #codeEmp').focus();
                }
            }
        })
    });

    $('.table .dBtn').on('click',function(event){
        var href = $(this).attr('href');
        $('#deleteModal #delBtn').attr('href',href);
    });

    $('#applyDate').datepicker({ dateFormat: "dd-mm-yy" }).val();

    var validator = $('#myForm').validate({
        rules: {
            codeEmp: {
                required: true,
                minlength: 2
            },
            reason: {
                required: true,
            },
            amount: {
                required: true,
                number: true
            },
            applyDate: {
                required: true,
            }
        },
        messages: {
            codeEmp: {
                required: 'Mã nhân viên không được để trống!',
                minlength: 'Mã nhân viên tối thiểu 2 ký tự!'
            },
            reason: {
                required: 'Bạn chưa nhập lý do!',
            },
            amount: {
                required: 'Lương không được để trống!',
                number: 'Lương không hợp lệ!'
            },
            applyDate: {
                required: 'Bạn chưa lựa chọn ngày!',
            },
        }
    });
    $('#achievementFilters').hide();
    $('#achievementFilters thead').append(tableHead);

    $("#filter").on("keyup", function() {
        var inputValue = $(this).val().toLowerCase();

        $("#achievementFilters tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(inputValue) > -1)
        });
        if(inputValue.length > 0){
            $('#achievementsTable').hide();
            $('#achievementFilters').show();
            $(".pagination").hide();
        }else{
            $('#achievementsTable').show();
            $('#achievementFilters').hide();
            $(".pagination").show();
        }
    });
})