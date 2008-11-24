
<%@ page import="com.brightdome.tattletale.domain.Build" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Build</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Build List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Build</g:link></span>
        </div>
        <div class="body">
            <h1>Show Build</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:buildInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Activity:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:buildInstance, field:'activity')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Alias:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:buildInstance, field:'alias')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Build Server:</td>
                            
                            <td valign="top" class="value"><g:link controller="buildServer" action="show" id="${buildInstance?.buildServer?.id}">${buildInstance?.buildServer?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Name:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:buildInstance, field:'name')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Sequence:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:buildInstance, field:'sequence')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Status:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:buildInstance, field:'status')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${buildInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
