$(document).ready(function() {
    var tableHead = '<>' +
        '<th> # </th>' +
        '<th> Mã Chức Danh </th>' +
        '<th> Tên Chức Danh </th>' +
        '<th> Phòng Ban </th>' +
        '<th colspan="2" > Hành Động </th>' +
        '</>';
    $('#jobtitlesTable thead').append(tableHead);

    $('.table .eBtn').on('click',function(event){
        // validator.resetForm();
        $('#myForm .form-control').removeClass('error');
        var href = $(this).attr('href');
        $.get(href, function(map,status){
            console.log(map)
            $('.jobtitle #id').val(map.jobtitle.id)
            $('.jobtitle #code').val(map.jobtitle.code)
            $('.jobtitle #name').val(map.jobtitle.name)
            $('.jobtitle #department').val(map.department.name)
            $('.jobtitle #note').val(map.jobtitle.note)
        })
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
            },
            department: {
                required: true
            }
        },
        messages: {
            businessName: {
                required: 'Mã chức vụ không được để trống!',
                minlength: 'Mã chức vụ tối thiểu 2 ký tự!'
            },
            employeeName: {
                required: 'Tên chức vụ không được để trống!',
                lettersonly: 'Tên không hợp lệ!'
            },
            department: {
                required: 'Bạn chưa lựa chọn phòng ban!'
            }
        }
    });

    $('#jobtitlefilters').hide();
    $('#jobtitlefilters thead').append(tableHead);
    $("#filter").on("keyup", function() {
        var inputValue = $(this).val().toLowerCase();

        $("#jobtitlefilters tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(inputValue) > -1)
        });
        if(inputValue.length > 0){
            $('#jobtitlesTable').hide();
            $('#jobtitlefilters').show();
            $(".pagination").hide();
        }else{
            $('#jobtitlesTable').show();
            $('#jobtitlefilters').hide();
            $(".pagination").show();
        }
    });
})