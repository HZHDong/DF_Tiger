<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/index.css" type="text/css" />
<title>INDEX</title>
</head>
<body>
	<div class="top">
        <div class="logo">
            <h1><a href="index.jsp?id=<%=(String)session.getAttribute("id")%>">b<span>Books</span></a></h1>
        </div>
        <div class="right">
            <a href="login.jsp">登录</a> &nbsp; ● &nbsp; <a href="register.jsp">注册</a> &nbsp; ● &nbsp; <a href='./cancellation.jsp'>退出</a>
        </div>
    </div>
    <div class="topnav">
        <nav>
          <ul>
            <li> &nbsp;  &nbsp; </li>
            <li><a href="index.jsp?id=<%=(String)session.getAttribute("id")%>">首页</a></li>
            <li><a href="QueryMyBooksServlet?id=<%=(String)session.getAttribute("id")%>">商铺页面</a></li>
            <li><a href="QueryMyCartByIdServlet?id=<%=(String)session.getAttribute("id")%>">购物车</a></li>
            <li><a href="QueryMyUserByIdServlet?id=<%=(String)session.getAttribute("id")%>">个人信息</a></li>
          </ul>
        </nav>
    </div>

    <script language =javascript >
        var curIndex=0;
        //时间bai间隔(单位毫秒)，每秒钟显示一张，数du组共有5张图片zhi放在Photos文件夹下。
        var timeInterval=10000;
        var arr=new Array();
        arr[0]="images/slide-1.jpg";
        arr[1]="images/slide-2.jpg";
        arr[2]="images/slide-3.jpg";
        setInterval(changeImg,timeInterval);
        function changeImg(){
            var obj=document.getElementById("obj");
            if (curIndex==arr.length-1){
                curIndex=0;
            }else{
                curIndex+=1;
            }
            obj.src=arr[curIndex];
        }
    </script>
    <div class="slide">
        <img id=obj src ="images/slide-1.jpg" width=100%>
        <div class="idom">
            <p>举一纲而万目张，解一卷而众篇明。　——郑玄</p>
            <p>书籍是在时代的波涛中航行的思想之船，它小心翼翼地把珍贵的货物运送给一代又一代。　——弗·培根</p>
            <p>读书有三种方法：一种是读而不懂，另一种是既读也懂，还有一种是读而懂得书上所没有的东西。　——克尼雅日宁</p>
            <p>当我们第一遍读一本好书的时候，我们仿佛觉得找到了一个朋友；当我们再一次读这本书的时候，仿佛又和老朋友重逢。——伏尔泰</p>
            <p>立身以立学为先，立学以读书为本——欧阳修</p>
        </div>
    </div>
</body>
</html>