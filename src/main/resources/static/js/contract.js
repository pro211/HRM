$(document).ready(function() {
    var tableHead = '<>' +
        '<th> # </th>' +
        '<th> Mã Hợp Đồng </th>' +
        '<th> Loại Hợp Đồng </th>' +
        '<th> Mã Nhân Viên </th>' +
        '<th> Họ Và Tên </th>' +
        '<th> Chức Vụ </th>' +
        '<th> Ngày Bắt Đầu </th>' +
        '<th> Ngày Kết Thúc </th>' +
        '<th colspan="2" > Hành Động </th>' +
        '</>';
    $('#contractsTable thead').append(tableHead);

    $('.table .eBtn').on('click',function(event){
        validator.resetForm();
        $('#myForm .form-control').removeClass('error');
        var href = $(this).attr('href');
        console.log(href)
        $.get(href, function(map, status){
            console.log(map)
            $('.contract-form #nameEmp').val(map.employee.employeeName)
            $('.contract-form #codeEmp').attr("readonly","readonly");
            $('.contract-form #codeEmp').val(map.employee.businessName)
            $('.contract-form #employee').val(map.employee.id)
            $('.contract-form #id').val(map.contract.id)
            $('.contract-form #code').val(map.contract.code)
            $('.contract-form #baseSalary').val(map.contract.baseSalary)
            $('.contract-form #bonusSalary').val(map.contract.bonusSalary)
            $('.contract-form #subsidiesSalary').val(map.contract.subsidiesSalary)
            $('.contract-form #startDate').val(map.contract.startDate)
            $('.contract-form #endDate').val(map.contract.endDate)
            $('#position').val(map.position.id)
            $('#type').val(map.type.id)
        })
    });

    $('.aBtn').on('click',function(event){
        validator.resetForm();
        $('#myForm .form-control').removeClass('error');
        $('.contract-form #nameEmp').val('')
        $('.contract-form #codeEmp').removeAttr("readonly");
        $('.contract-form #codeEmp').val('')
        $('.contract-form #employee').val('')
        $('.contract-form #id').val('')
        $('.contract-form #code').val('')
        $('.contract-form #baseSalary').val('')
        $('.contract-form #bonusSalary').val('')
        $('.contract-form #subsidiesSalary').val('')
        $('.contract-form #startDate').val('')
        $('.contract-form #endDate').val('')
        $('#position').val('')
        $('#type').val('')
    });

    $('.table .dBtn').on('click',function(event){
        var href = $(this).attr('href');
        $('#deleteModal #delBtn').attr('href',href);
    });

    $( "#codeEmp" ).keyup(function() {
        var codeEmp = $('#codeEmp').val();
        if(codeEmp.length<2){
            $('.contract-form #exitscodeEmp').hide();
        }
    });

    $('input[name=codeEmp]').blur(function(e) {
        var codeEmp = $('#codeEmp').val();
        console.log(codeEmp);
        var href = '/hrm/admin/employee/findEmp/?businessName='+ codeEmp;
        $.get(href, function(employee, status) {
            console.log(employee)
            if(employee !== '' && employee !== null){
                $('.contract-form #nameEmp').val(employee.employeeName)
                $('.contract-form #employee').val(employee.id)
            }else {
                console.log('Null')
                if (codeEmp.length <2){
                    $('.contract-form #exitscodeEmp').hide();
                } else {
                    $('.contract-form #exitscodeEmp').show();
                    $('.contract-form #exitscodeEmp').text('Mã nhân viên không tồn tại!');
                    $('.contract-form #codeEmp').focus();
                }
            }
        })
    });

    jQuery.validator.addMethod('lettersonly', function(value, element) {
        return this.optional(element) || /^[a-z àáâãèéêếìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởụủứừửữự]+$/i.test(value);
    }, "Letters and spaces only please");

    jQuery.validator.addMethod("noSpace", function(value, element) {
        return value.indexOf(" ") < 0 && value != "";
    }, "No space please and don't leave it empty");


    $('#startDate').datepicker({ dateFormat: "dd-mm-yy" }).val();
    $('#endDate').datepicker({ dateFormat: "dd-mm-yy" }).val();

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
            position: {
                required: true
            },
            type: {
                required: true
            },
            baseSalary: {
                required: true,
                number: true
            },
            bonusSalary: {
                required: true,
                number: true
            },
            subsidiesSalary: {
                required: true,
                number: true
            },
            startDate: {
                required: true,
            },
            endDate: {
                required: true,
            }
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
            position: {
                required: 'Bạn chưa lựa chọn chức vụ!'
            },
            type: {
                required: 'Bạn chưa lựa chọn loại hợp đồng!'
            },
            baseSalary: {
                required: 'Lương không được để trống!',
                number: 'Lương không hợp lệ!'
            },
            bonusSalary: {
                required: 'Lương không được để trống!',
                number: 'Lương không hợp lệ!'
            },
            subsidiesSalary: {
                required: 'Lương không được để trống!',
                number: 'Lương không hợp lệ!'
            },
            startDate: {
                required: 'Bạn chưa lựa chọn ngày!',
            },
            endDate: {
                required: 'Bạn chưa lựa chọn ngày!',
            }
        }
    });

    $('#contractFilters').hide();
    $('#contractFilters thead').append(tableHead);

    $("#filter").on("keyup", function() {
        var inputValue = $(this).val().toLowerCase();

        $("#contractFilters tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(inputValue) > -1)
        });
        if(inputValue.length > 0){
            $('#contractsTable').hide();
            $('#contractFilters').show();
            $(".pagination").hide();
        }else{
            $('#contractsTable').show();
            $('#contractFilters').hide();
            $(".pagination").show();
        }
    });
})