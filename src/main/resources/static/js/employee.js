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
        $.get(href, function(map,status){
            console.log(map)
            $('.employee-form #id').val(map.employee.id)
            $('.employee-form #avatar').val(map.employee.avatar)
            $('.employee-form #isAdmin').val(map.employee.admin ? 1 : 0)
            $('.employee-form #password').val(map.employee.password)
            $('.employee-form #businessName').val(map.employee.businessName)
            $('.employee-form #employeeName').val(map.employee.employeeName)
            $('.employee-form #active').val(map.employee.active ? 1 : 0)
            $('#department').val(map.department.id)
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
        var begin = href.indexOf('=')+1;
        var id = href.slice(begin,href.length);

        var hrefx = '/hrm/admin/employee/find/?id='+ id;

        $.get(hrefx, function(map,status){
            if (map.employee.contracts.length > 0 ||
                map.employee.achievements.length > 0 ||
                map.employee.salaries.length > 0 ||
                map.employee.leave.length > 0
            ) {
                $('#deleteModal #delBtn').attr('href','#');
                $('#deleteModal #delBtn').attr('data-dismiss','modal');
                $('#haveData').show();
                $('#haveData').text('Nhân viên này có dữ liệu, không thể xóa!')
            }else{
                $('#deleteModal #delBtn').removeAttr('data-dismiss','modal');
                $('#haveData').hide();
                $('#deleteModal #delBtn').attr('href',href);
            }
        })
    });

    // validate
    jQuery.validator.addMethod('lettersonly', function(value, element) {
        return this.optional(element) || /^[a-z àáâãèéêếìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởụủứừửữự]+$/i.test(value);
    }, "Letters and spaces only please");

    jQuery.validator.addMethod("noSpace", function(value, element) {
        return value.indexOf(" ") < 0 && value != "";
    }, "No space please and don't leave it empty");

    var validator = $('#myForm').validate({
        rules: {
            businessName: {
                required: true,
                minlength: 2,
                noSpace: true
            },
            employeeName: {
                required: true,
                lettersonly: true,
                noSpace: true
            },
            department: {
                required: true
            }
        },
        messages: {
            businessName: {
                required: 'Mã nhân viên không được để trống!',
                minlength: 'Mã nhân viên tối thiểu 2 ký tự!',
                noSpace: 'Mã nhân viên không hợp lệ!'
            },
            employeeName: {
                required: 'Tên nhân viên không được để trống!',
                lettersonly: 'Tên không hợp lệ!',
                noSpace: 'Tên nhân viên không hợp lệ!'
            },
            department: {
                required: 'Bạn chưa lựa chọn phòng ban!'
            }
        }
    });

    $('#employeeFilters').hide();
    $('#employeeFilters thead').append(tableHead);
    $("#filter").on("keyup", function() {
        var inputValue = $(this).val().toLowerCase();

        $("#employeeFilters tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(inputValue) > -1)
        });
        if(inputValue.length > 0){
            $('#employeesTable').hide();
            $('#employeeFilters').show();
            $(".pagination").hide();
        }else{
            $('#employeesTable').show();
            $('#employeeFilters').hide();
            $(".pagination").show();
        }
    });
})