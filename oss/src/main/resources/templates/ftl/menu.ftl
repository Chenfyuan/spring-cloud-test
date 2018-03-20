<!--功能菜单-->
<#macro menu nodes>
    <#list nodes as nodeList>
       <#if nodeList.children?? &&nodeList.children?size gt 0>
           <!--当有下一级菜单时输出-->
           <li>
               <a href="javascript:;">
                   <i class="iconfont">${nodeList.menuIcon}</i>
                   <cite>${nodeList.funcName}</cite>
                   <i class="iconfont nav_right">&#xe697;</i>
               </a>
               <ul class="sub-menu">
                   <@menu nodeList.children/><!--递归输出-->
               </ul>
           </li>
       </a>
           <#else>
             <li>
                 <a _href="<@path/>/${nodeList.linkPage}">
                     <i class="iconfont">&#xe6a7;</i>
                     <cite>${nodeList.funcName}</cite>
                 </a>
             </li >
       </#if>
    </#list>
</#macro>