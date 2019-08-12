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

    $('.table .eBtn').on('click',function(event){
        validator.resetForm();
        $('#myForm .form-control').removeClass('error');
        var href = $(this).attr('href');
        $.get(href, function(employee,status){
            console.log(employee)
            $('.employee-form #id').val(employee.id)
            $('.employee-form #avatar').val(employee.avatar)
            $('.employee-form #isAdmin').val(employee.admin ? 1 : 0)
            $('.employee-form #password').val(employee.password)
            $('.employee-form #businessName').val(employee.businessName)
            $('.employee-form #employeeName').val(employee.employeeName)
            $('.employee-form #active').val(employee.active ? 1 : 0)
        })
    });

    $('.aBtn').on('click',function(event){
        validator.resetForm();
        $('.employee-form #id').val('')
        $('.employee-form #avatar').val('employee1.png')
        $('.employee-form #isAdmin').val(0)
        $('.employee-form #password').val('$2a$10$SeeV7hqcxuSn6zzPsF32pOa8NM.KCWAOeyCfGy94qBVlnWz2OS3S6')
        $('.employee-form #businessName').val('')
        $('.employee-form #employeeName').val('')
        $('.employee-form #active').val(1)
    });

    $('.table .dBtn').on('click',function(event){
        var href = $(this).attr('href');
        console.log(href);
        $('#deleteModal #delBtn').attr('href',href);
    });

    // validate
    jQuery.validator.addMethod('lettersonly', function(value, element) {
        return this.optional(element) || /^[a-z àáâãèéêếìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởụủứừửữự]+$/i.test(value);
    }, "Letters and spaces only please");

    var validator = $('#myForm').validate({
        rules: {
            businessName: {
                required: true,
                minlength: 2
            },
            employeeName: {
                required: true,
                lettersonly: true
            },
            department: {
                required: true
            }
        },
        messages: {
            businessName: {
                required: 'Mã phòng ban không được để trống!',
                minlength: 'Mã phòng ban tối thiểu 2 ký tự!'
            },
            employeeName: {
                required: 'Tên phòng ban không được để trống!',
                lettersonly: 'Tên không hợp lệ!'
            },
            department: {
                required: 'Bạn chưa lựa chọn phòng ban!'
            }
        }
    });
})