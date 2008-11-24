
<%@ page import="com.brightdome.tattletale.domain.Build" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Build</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Build List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Build</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Build</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${buildInstance}">
            <div class="errors">
                <g:renderErrors bean="${buildInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${buildInstance?.id}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="activity">Activity:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:buildInstance,field:'activity','errors')}">
                                    <input type="text" id="activity" name="activity" value="${fieldValue(bean:buildInstance,field:'activity')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="alias">Alias:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:buildInstance,field:'alias','errors')}">
                                    <input type="text" id="alias" name="alias" value="${fieldValue(bean:buildInstance,field:'alias')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="buildServer">Build Server:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:buildInstance,field:'buildServer','errors')}">
                                    <g:select optionKey="id" from="${com.brightdome.tattletale.domain.BuildServer.list()}" name="buildServer.id" value="${buildInstance?.buildServer?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name">Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:buildInstance,field:'name','errors')}">
                                    <input type="text" id="name" name="name" value="${fieldValue(bean:buildInstance,field:'name')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="sequence">Sequence:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:buildInstance,field:'sequence','errors')}">
                                    <input type="text" id="sequence" name="sequence" value="${fieldValue(bean:buildInstance,field:'sequence')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="status">Status:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:buildInstance,field:'status','errors')}">
                                    <input type="text" id="status" name="status" value="${fieldValue(bean:buildInstance,field:'status')}"/>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
