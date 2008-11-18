<%@ page import="com.brightdome.tattletale.domain.Server" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Server</g:link></span>
        </div>
        <div class="body">
            <h1>Server List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="activity" title="Activity" />
                        
                   	        <g:sortableColumn property="name" title="Name" />
                        
                   	        <g:sortableColumn property="status" title="Status" />
                        
                   	        <g:sortableColumn property="url" title="Url" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${serverList}" status="i" var="server">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${server.id}">${fieldValue(bean:server, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:server, field:'activity')}</td>
                        
                            <td>${fieldValue(bean:server, field:'name')}</td>
                        
                            <td>${fieldValue(bean:server, field:'status')}</td>
                        
                            <td>${fieldValue(bean:server, field:'url')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${Server.count()}" />
            </div>
        </div>
    </body>
</html>
