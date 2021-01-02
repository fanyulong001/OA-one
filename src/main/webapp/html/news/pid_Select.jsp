<%@ page import="com.abc.oa.desktop.news.newslabel.commons.beans.NewsLabel" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/12/27
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>栏目管理</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css">
    <script language="javascript" src="../../js/util.js"></script>
    <script>
        function shanchu()
        {
            var  str = confirm("是否确定删除上级栏目？");
            if(str == true)
            {
                alert("确定删除！");
            }
            else
            {
                alert("取消删除！");
            }
        }
        function submitForm(){
        //获取form表单对象
            var form = document.getElementById("form1");
            form.submit();//form表单提交
        }

    </script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<center>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td height="25" align="center" valign="bottom" class="td06"><table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="2%" valign="middle" background="../../images/bg_03.gif">&nbsp;</td>
                    <td width="2%" valign="middle" background="../../images/bg_03.gif"><img src="../../images/main_28.gif" width="9" height="9" align="absmiddle"></td>
                    <td height="30" valign="middle" background="../../images/bg_03.gif"><div align="left"><font color="#FFFFFF">栏目管理</font></div></td>
                </tr>
            </table></td>
        </tr>
    </table>
    <form name="form1" method="post" id="" action=""  >
        <%--<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">--%>
            <%--<tr>--%>
                <%--<td colspan="2" class="td_02"><SPAN class=td_title>根据栏目名称查询</SPAN></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td width="14%" class="td_02">栏目名称</td>--%>
                <%--<td width="86%" class="td_02">--%>
                    <%--<select name="select" class="input" onchange="submitForm();" style="width:99% ">--%>
                        <%--<option value="1" selected>--请选择--</option>--%>
                        <%--<c:forEach items="${page2.datas}" var="nl2">--%>
                            <%--<option value="${nl2.id}">${nl2.label_name}</option>--%>
                        <%--</c:forEach>--%>
                    <%--</select>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <%--<!--  <tr>--%>
               <%--<td class="td_02">二级栏目名称</td>--%>
               <%--<td class="td_02">--%>
                 <%--<select name="select" class="input" style="width:99% ">--%>
                   <%--<option value="1" selected>--请选择--</option>--%>
                   <%--<option value="2">天下足球</option>--%>
                   <%--<option value="3">我猜</option>--%>
                 <%--</select>--%>
               <%--</td>--%>
             <%--</tr> -->--%>
        <%--</table>--%>
        <%--<br>--%>
        <%--<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0">--%>
            <%--<tr>--%>
                <%--<td class="td_page" align="left">--%>
                    <%--<div align="right">--%>
                        <%--<input name="Submit" type="button" class="buttonface02" value="添加栏目" onClick="javascript:windowOpen('${pageContext.request.contextPath}/desktop/news/selectNewsLabelPid.do','','',700,300,'','','')">--%>
                    <%--</div></td>--%>
            <%--</tr>--%>
        <%--</table>--%>
        <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">

            <tr>
                <%--<td colspan="5" align="right" class="td07"><img src="../../images/1.gif" width="4" height="5" align="absmiddle"> <a href="${pageContext.request.contextPath}/desktop/news/queryNewLable.do?pageno=1">首页</a>　 <img src="../../images/2.gif" width="3" height="5" align="absmiddle"> <a href="${pageContext.request.contextPath}/desktop/news/queryNewLable.do?pageno=${page.pageno-1>1?page.pageno-1:1}">上一页</a>　 <img src="../../images/2-2.gif" width="3" height="5" align="absmiddle"> <a href="${pageContext.request.contextPath}/desktop/news/queryNewLable.do?pageno=${page.pageno+1<page.totalPages?page.pageno+1:page.totalPages}">下一页</a>　 <img src="../../images/3.gif" width="4" height="5" align="absmiddle"><a href="${pageContext.request.contextPath}/desktop/news/queryNewLable.do?pageno=${page.totalPages}"> 末页</a>　　共 ${page.totalPages} 页 ${page.totalRows} 条记录</td>--%>
            </tr>
            <tr>
                <td width="17%" class="td_top">栏目名称</td>
                <td width="15%" class="td_top">上级栏目名称</td>
                <td width="44%" class="td_top">栏目描述</td>
                <td width="12%" class="td_top">删除</td>
                <td width="12%" class="td_top">修改</td>
            </tr>
            <c:forEach items="${page.datas}" var="nl">
                <tr>
                    <td class="td07">${nl.label_name}</td>
                    <td class="td07">${nl.parent.label_name}</td>
                    <td class="td07">${nl.label_content}</td>
                    <td class="td07"><a href="${pageContext.request.contextPath}/desktop/news/deleteNewsLabel.do?id=${nl.id}&pageno=${page.pageno}" onClick="shanchu()">删除</a></td>
                    <td class="td07"><a href="${pageContext.request.contextPath}/desktop/news/selectNewsLabelId.do?id=${nl.id}&pageno=${page.pageno}" >修改</a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td class="td07">&nbsp;</td>
                <td class="td07">&nbsp;</td>
                <td class="td07">&nbsp;</td>
                <td class="td07">&nbsp;</td>
                <td class="td07">&nbsp;</td>
            </tr>
            <tr>
                <td class="td07">&nbsp;</td>
                <td class="td07">&nbsp;</td>
                <td class="td07">&nbsp;</td>
                <td class="td07">&nbsp;</td>
                <td class="td07">&nbsp;</td>
            </tr>
        </table>
        <p>&nbsp;</p>
    </form>
</center>
</body>
</html>

