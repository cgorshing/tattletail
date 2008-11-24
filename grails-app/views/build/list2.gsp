
<%@ page import="com.brightdome.tattletale.domain.Build" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Build List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Build</g:link></span>
        </div>
        <div class="body">
            <h1>Build List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="activity" title="Activity" />
                        
                   	        <g:sortableColumn property="alias" title="Alias" />
                        
                   	        <th>Build Server</th>
                   	    
                   	        <g:sortableColumn property="name" title="Name" />
                        
                   	        <g:sortableColumn property="sequence" title="Sequence" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${buildInstanceList}" status="i" var="buildInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${buildInstance.id}">${fieldValue(bean:buildInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:buildInstance, field:'activity')}</td>
                        
                            <td>${fieldValue(bean:buildInstance, field:'alias')}</td>
                        
                            <td>${fieldValue(bean:buildInstance, field:'buildServer')}</td>
                        
                            <td>${fieldValue(bean:buildInstance, field:'name')}</td>
                        
                            <td>${fieldValue(bean:buildInstance, field:'sequence')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${Build.count()}" />
            </div>
        </div>
    </body>
</html>
