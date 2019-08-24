$(document).ready(function(){
    $('#haveData').hide();
    $('.table .eBtn').on('click',function(event){
        validator.resetForm();
        $('#myForm .form-control').removeClass('error');
        var href = $(this).attr('href');
        $.get(href, function(department,status){
            console.log(department)
            $('.department-form #id').val(department.id)
            $('.department-form #code').val(department.code)
            $('.department-form #name').val(department.name)
            $('.department-form #active').val(department.active ? 1 : 0)
            $('.department-form #note').val(department.note)
        })
    });

    $('.table .dBtn').on('click',function(event){
        var href = $(this).attr('href');
        var begin = href.indexOf('=')+1;
        var id = href.slice(begin,href.length);

        var href2 = '/hrm/admin/employee/findByDep/?id='+ id;
        $.get(href2, function(employees,status){
            console.log('EmployeeNumber: '+ employees.length);
            if(employees.length > 0){
                $('#deleteModal #delBtn').attr('href','#');
                $('#deleteModal #delBtn').attr('data-dismiss','modal');
                $('#haveData').show();
                $('#haveData').text('Phòng ban này có nhân viên, không thể xóa!')
            }else {
                $('#deleteModal #delBtn').removeAttr('data-dismiss','modal');
                $('#haveData').hide();
                $('#deleteModal #delBtn').attr('href',href);
            }
        })
    });

    $('.aBtn').on('click',function(event){
        validator.resetForm();
        $('.department-form #id').val('')
        $('.department-form #code').val('')
        $('.department-form #name').val('')
        $('.department-form #active').val(1)
        $('.department-form #note').val('')
    });
    // validate
    jQuery.validator.addMethod('lettersonly', function(value, element) {
        return this.optional(element) || /^[a-z àáâãèéêếìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởụủứừửữự]+$/i.test(value);
    }, "Letters and spaces only please");

    var validator = $('#myForm').validate({
        rules: {
            code: {
                required: true,
                minlength: 2
            },
            name: {
                required: true,
                lettersonly: true
            }
        },
        messages: {
            code: {
                required: 'Mã phòng ban không được để trống!',
                minlength: 'Mã phòng ban tối thiểu 2 ký tự!'
            },
            name: {
                required: 'Tên phòng ban không được để trống!',
                lettersonly: 'Tên không hợp lệ!'
            }
        },
    });
    var tableHead = '<>' +
        '<th> # </th>' +
        '<th> Mã Phòng </th>' +
        '<th> Tên Phòng </th>' +
        '<th> Trạng Thái </th>' +
        '<th colspan="2" > Hành Động </th>' +
        '</>';
    $('#departmentsTable thead').append(tableHead);

    $('#departmentFilters thead').append(tableHead);

    $('#departmentFilters').hide();

    $("#filter").on("keyup", function() {
        var inputValue = $(this).val().toLowerCase();

        $("#departmentFilters tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(inputValue) > -1)
        });
        if(inputValue.length > 0){
            $('#departmentsTable').hide();
            $('#departmentFilters').show();
            $(".pagination").hide();
        }else{
            $('#departmentsTable').show();
            $('#departmentFilters').hide();
            $(".pagination").show();
        }
    });

})