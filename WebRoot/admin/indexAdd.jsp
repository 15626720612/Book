<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
            $(document).ready(function(){
                var date=new Date();//创建日期对象
                var year=date.getFullYear();//获取当前年份
                for(var i=year-10;i<=year+10;i++){//在id为year的selector附加option选项
                    $("#year").append("<option value=\""+i+"\">"+i+"</option>");//append函数附加html到元素结尾处
                }
                for(var i=1;i<=12;i++){
                    $("#month").append("<option value=\""+i+"\">"+i+"</option>");//为Id为month的selector附加option选项
                }
                getDays($("#month").val(),$("#year").val());//执行函数getDays()，传参year和month，初始化day selector
            });

            function getDays(){
                var days;
                var year = $("#year").val();
                var month = $("#month").val();
                //alert(year);
                if (month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) {
                days=31;//固定31
                }else if (month==4 || month==6 || month==9 || month==11){
                days=30;//固定30
                }else{
	                if ((year%4 == 0 && year%100 != 0) || (year%400 == 0)) {     //排除百年，每四年一闰；每四百年一闰；
	                	days=29; //闰年29
	                }else { 
	                	days=28; //平年28
	                }
                }
                for(var i=1;i<=days;i++){
                $("#day").append("<option value=\""+i+"\">"+i+"</option>");
                }
            }
            $("#month").change(function(){
    			getDays();
			});
			$("#year").change(function(){
    			getDays();
			});
</script>

<body>
	<div>
		<form name="reg_testdate">
			标题：<input name = "title"><br>
			日期：<select name="YYYY" id="year">
			        <option value="2000">请选择 年</option>
			    </select>
			    <select name="MM" id="month">
			        <option value="1">选择 月</option>
			    </select>
			    <select name="DD" id="day">
			        <option value="1">选择 日</option>
			    </select><br>
			    上传图片：<input type="file">
		</form>
	</div>
</body>
</html>

