window.onload = function () {
    var selectFile = document.getElementById("selectFile");
    var uploadFile = document.getElementById("uploadFile");
    uploadFile.onclick = function(){
        var file = selectFile.files[0];
        //获取文件的filename，文件名
        var filename = selectFile.files[0].name;
        //获取文件的filepath，文件路径
        var filepath = selectFile.value;
        var form = new FormData();
        form.append("file", file);
    }
}
