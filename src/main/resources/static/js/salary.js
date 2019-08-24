$(document).ready(function () {
    var tableHead = '<>' +
        '<th> # </th>' +
        '<th> Tháng </th>' +
        '<th> Mã Nhân Viên </th>' +
        '<th> Họ Và Tên </th>' +
        '<th> Khen Thưởng & Kỷ Luật</th>' +
        '<th> Thực Lĩnh</th>' +
        '<th colspan="3" > Hành Động </th>' +
        '</>';

    $('#salariesTable thead').append(tableHead);

    $('.table .viewBtn').on('click',function(event){
        validator.resetForm();
        $('#myForm .form-control').removeClass('error');
        $('.salary-form #contract').empty();
        $('#editBtn').show();
        $('#exitscodeEmp, #exitsmonth ').hide();
        var href = $(this).attr('href');
        console.log(href)
        $.get(href, function(map, status){
            console.log(map)
            $('.salary-form #nameEmp').val(map.employee.employeeName)
            $('.salary-form #codeEmp').val(map.employee.businessName)
            $('.salary-form #employee').val(map.employee.id)
            $('.salary-form #contract').append($('<option>', {
                value: map.contract.id,
                text: map.contract.code
            }));
            $('.salary-form #id').val(map.salary.id)
            $('.salary-form #month').val(map.salary.month)
            $('.salary-form #year').val(map.salary.year)
            $('.salary-form #baseSalary').val(map.contract.baseSalary)
            $('.salary-form #subsidiesSalary').val(map.contract.subsidiesSalary)
            $('.salary-form #socialSecurity').val(map.salary.socialSecurity)
            $('.salary-form #healthInsurance').val(map.salary.healthInsurance)
            $('.salary-form #personalIncomeTax').val(map.salary.personalIncomeTax)
            $('.salary-form #achievement').val(map.salary.achievement)
            $('.salary-form #commission').val(map.salary.commission)
        })
    });

    $('.table .viewBtn').on('click',function(event){
        $('#nameEmp, #codeEmp, #contract, #baseSalary, #subsidiesSalary, #month, #year, #socialSecurity, #healthInsurance, ' +
            '#personalIncomeTax, #achievement, #commission').attr("readonly", "readonly")
    });

    $('#editBtn').on('click',function(event){
        $('#month, #year, #socialSecurity, #healthInsurance, #personalIncomeTax, #commission').removeAttr("readonly");
        $('#month').focus();
    });

    $('.table .dBtn').on('click',function(event){
        var href = $(this).attr('href');
        $('#deleteModal #delBtn').attr('href',href);
    });

    $('.aBtn').on('click',function(event){
        validator.resetForm();
        $('.salary-form #contract').empty();
        $('#nameEmp, #baseSalary, #subsidiesSalary, #achievement').attr("readonly", "readonly");
        $('#codeEmp, #contract, #month, #year, #socialSecurity, #healthInsurance, #personalIncomeTax, #commission').removeAttr("readonly");
        $('.salary-form #codeEmp').focus()
        $('.salary-form #nameEmp').val('')
        $('.salary-form #employee').val('')
        $('.salary-form #codeEmp').val('')
        $('.salary-form #id').val('')
        $('.salary-form #month').val('')
        $('.salary-form #year').val('')
        $('.salary-form #baseSalary').val('')
        $('.salary-form #subsidiesSalary').val('')
        $('.salary-form #socialSecurity').val('')
        $('.salary-form #healthInsurance').val('')
        $('.salary-form #personalIncomeTax').val('')
        $('.salary-form #achievement').val('')
        $('.salary-form #commission').val('')
        $('#editBtn').hide();
    });

    $('input[name=codeEmp]').blur(function(e) {
        $('.salary-form #contract').empty();
        var codeEmp = $('#codeEmp').val();
        var href = '/hrm/admin/employee/findEmp/?businessName='+ codeEmp;
        $.get(href, function(employee, status) {
            console.log(employee)
            if(employee !== '' && employee !== null){
                $('.salary-form #exitscodeEmp').hide();
                $('.salary-form #nameEmp').val(employee.employeeName)
                $('.salary-form #employee').val(employee.id)
                var href = '/hrm/admin/contract/findByEmployee/?id='+ employee.id;
                $.get(href, function (contracts, status) {
                    console.log(contracts)
                    $('.salary-form #contract').append($('<option>', {
                        value: '',
                        text: 'Lựa chọn'
                    }));
                    contracts.forEach(function(item) {
                        $('.salary-form #contract').append($('<option>', {
                            value: item.id,
                            text: item.code
                        }));
                    })
                })
            }else {
                console.log('Null')
                if (codeEmp.length <2){
                    $('.contract-form #exitscodeEmp').hide();
                } else {
                    $('.salary-form #exitscodeEmp').show();
                    $('.salary-form #exitscodeEmp').text('Mã nhân viên không tồn tại!');
                    $('.salary-form #codeEmp').focus();
                }
            }
        })
    })

    $('input[name=month], input[name=year]').blur(function(e) {
        var employeeId = $('#employee').val();
        var month = $('#month').val();
        var year = $('#year').val();
        var count = 0;
        if(employeeId !== '' && month !== '' && year !== ''){
            var href = '/hrm/admin/salary/findByEmployee/?id='+ employeeId;
            $.get(href, function(salaries, status) {
                salaries.forEach(function(salary) {
                    if (year.trim() == salary.year  && month.trim() == salary.month){
                        count ++;
                    }
                });
                console.log(count)
                if(count > 0) {
                    $('#exitsmonth').show();
                    $('#exitsmonth').text('Tháng lương đã tồn tại!');
                    $('#exitsmonth').focus();
                }else {
                    $('#exitsmonth').hide()
                }
            })
        }
    });
    $('select[name=contract]').change(function(e) {
        var contractId = $('#contract').val();
        if(contractId !== ''){
            var href = '/hrm/admin/contract/find/?id='+ contractId;
            $.get(href, function(map, status) {
                $('.salary-form #baseSalary').val(map.contract.baseSalary)
                $('.salary-form #subsidiesSalary').val(map.contract.subsidiesSalary)
            })
        }else {
            $('.salary-form #baseSalary').val('')
            $('.salary-form #subsidiesSalary').val('')
        }

    })

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
            month: {
                required: true,
                min: 1,
                max: 12,
                number: true
            },
            year: {
                required: true,
                min: 2019,
                number: true
            },
            contract: {
                required: true
            },
            personalIncomeTax: {
                required: true,
                number:true
            },
            socialSecurity: {
                required: true,
                number: true
            },
            healthInsurance: {
                required: true,
                number: true
            },
            commission: {
                required: true,
                number: true
            }
        },
        messages: {
            codeEmp: {
                required: 'Mã nhân viên không được để trống!',
                minlength: 'Mã nhân viên tối thiểu 2 ký tự!',
                noSpace: 'Mã nhân viên không hợp lệ!'
            },
            month: {
                required: 'Tháng không được để trống!',
                min: 'Tháng từ 1 - 12',
                max: 'Tháng từ 1 - 12',
                number: 'Tháng không hợp lệ'
            },
            year: {
                required: 'Năm không được để trống!',
                min: 'Năm nhỏ hơn hiện tại!',
                maxlength: 'Năm không hợp lệ!',
                number: 'Năm không hợp lệ!'
            },
            contract: {
                required: 'Bạn chưa lựa chọn hợp đồng!'
            },
            personalIncomeTax: {
                required: 'Thuế TNCN không được để trống!',
                number: 'Thuế TNCN không hợp lệ!'
            },
            socialSecurity: {
                required: 'BHXH không được để trống!',
                number: 'BHXH không hợp lệ!'
            },
            healthInsurance: {
                required: 'BHYT không được để trống!',
                number: 'BHYT không hợp lệ!'
            },
            commission: {
                required: 'Lương thưởng không được để trống!',
                number: 'Lương thưởng không hợp lệ!'
            }
        }})

    $('#salaryFilters').hide();
    $('#salaryFilters thead').append(tableHead);

    $("#filter").on("keyup", function() {
        var inputValue = $(this).val().toLowerCase();

        $("#salaryFilters tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(inputValue) > -1)
        });
        if(inputValue.length > 0){
            $('#salariesTable').hide();
            $('#salaryFilters').show();
            $(".pagination").hide();
        }else{
            $('#salariesTable').show();
            $('#salaryFilters').hide();
            $(".pagination").show();
        }
    });
})