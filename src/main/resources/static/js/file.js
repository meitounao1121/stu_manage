layui.use(['layer','element', 'upload'], function() {
    var upload = layui.upload;
    var element = layui.element;
    element.init();

    var uploadInst = upload.render({
        elem : '#upload',
        url : 'http://localhost:8088/homework04/upload',
        method : 'POST',
        accept : 'file',
        size : 0,
        progress: function (e,percent) {
            console.log("进度：" + percent + '%');
            element.progress('stu_manage', percent + '%')
        },

        done : function(res, index, upload) {
            layer.closeAll('loading');
            if (res.code == 0) {
                return layer.msg("上传文件成功");
            }
        },
        error : function(index, upload) {
            layer.closeAll('loading');
            layer.msg('上传失败');
        }
    });
});