var ApplicationClass = {
    logicMethod1:function (successFunction, oneId, twoId) {
        $.ajax({
            type:'POST',
            dataType:"json",
            url:APPLICATION_ROOT + 'json/endpoint/',
            data:"oneId=" + oneId + "&twoId=" + twoId,
            success:function (data) {
                successFunction();
            }
        });
    }
}