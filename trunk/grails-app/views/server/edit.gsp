
<%@ page import="com.brightdome.tattletale.domain.Server" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Server</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Server List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Server</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Server</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${server}">
            <div class="errors">
                <g:renderErrors bean="${server}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${server?.id}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="activity">Activity:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:server,field:'activity','errors')}">
                                    <input type="text" id="activity" name="activity" value="${fieldValue(bean:server,field:'activity')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name">Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:server,field:'name','errors')}">
                                    <input type="text" id="name" name="name" value="${fieldValue(bean:server,field:'name')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="status">Status:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:server,field:'status','errors')}">
                                    <input type="text" id="status" name="status" value="${fieldValue(bean:server,field:'status')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="url">Url:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:server,field:'url','errors')}">
                                    <input type="text" id="url" name="url" value="${fieldValue(bean:server,field:'url')}"/>
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
