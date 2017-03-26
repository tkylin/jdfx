<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
$(document).ready(function() {
	$("#file").bind("chang", function() {
		//判断上传的文件的格式是否正确  
		var file = $("#file").val();
		var fileType = file.substring(file.lastIndexOf(".") + 1);
		if (fileType != "png" && fileType != "jpg") {
			alert("上传文件格式错误");
			return;
		}
		$.ajaxFileUpload({
			url : "${ctx}/upload.do",
			secureuri : false,
			fileElementId : "file", //file的id  
			dataType : "json", //返回数据类型为文本  
			success : function(data) {
				if(data.status==200){
					$("#upload_img")[0].src=data.url+"_s100";
					$("#icon").val(data.url);
				}else{
					$.messager.alert("提示", "上传失败!" + data.message);
				}
				$("#file").val("");
			}
		});
	});
});
</script>
<input id="file" name="file" type="file" />
<input id="icon" name="icon" type="hidden" >
<img id="upload_img" alt="icon" src="" style="width:60px;">
