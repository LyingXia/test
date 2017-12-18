<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.io.File"%>
<%
    //先判断是否是文件上传类型enctype="multipart/form-data"
    boolean isFileUpload = ServletFileUpload.isMultipartContent(request);
//如果是文件上传类型
    if(isFileUpload){
//得到文件上传工厂
        FileItemFactory factory = new DiskFileItemFactory();
        //处理文件上传核心类
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        //设置文件上传类的编码格式
        fileUpload.setHeaderEncoding("UTF-8");
        // 集合数据 :  FileItem对象 注意: 每一个表单域 对应一个 FileItem对象(封装)
        List<FileItem> fileItemList = fileUpload.parseRequest(request);
        //遍历fileItemList
        for(FileItem item: fileItemList){
            //如果这个文本域是文件类型的
            if(!item.isFormField()){
                //得到文本域的value值，即 路径+文件名
                String value = item.getName();
                //得到文件名
                String fileName = value.substring(value.lastIndexOf("\\")+1);
                //得到上传的文件类型
//String fileType = fileName.substring(fileName.lastIndexOf("."));
                //给文件重新命名 日期+文件名
                fileName = new Date().getTime() + fileName;
                //得到服务器的根路径
                String rootPath = request.getRealPath("/");
                //指定文件存放路径
                String realPath = rootPath+"/"+"upload";
                //定义文件存放的目录，注意 目录也是文件

                File file = new File(realPath);
                //如果目录不存在
                if(!file.isDirectory()){
                    //创建文件上传目录
                    file.mkdirs();
                }
                File newFile = new File(realPath+"/"+fileName);
                //向newFile文件中写入数据
                item.write(newFile);
            }else {//如果不是文件上传的文本域，把输入的内容显示在页面上
                out.print("name=" + new String(
                        item.getFieldName().getBytes("ISO-8859-1"),"utf-8")
                        +",value="+ new String(
                        item.getString().getBytes("ISO-8859-1"),"utf-8"));
            }
        }

    }
%>