<#macro path>
    <#compress>
        ${request.contextPath}
    </#compress>
</#macro>
<#macro header>
<meta name="renderer" content="webkit"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
<meta name="apple-mobile-web-app-status-bar-style" content="black"/>
<meta name="apple-mobile-web-app-capable" content="yes"/>
<meta name="format-detection" content="telephone=no"/>
 <link rel="shortcut icon" href="<@path/>/favicon.ico" type="image/x-icon" />
 <link rel="stylesheet" href="<@path/>/css/font.css">
	<link rel="stylesheet" href="<@path/>/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="<@path/>/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<@path/>/js/xadmin.js"></script>

</#macro>

