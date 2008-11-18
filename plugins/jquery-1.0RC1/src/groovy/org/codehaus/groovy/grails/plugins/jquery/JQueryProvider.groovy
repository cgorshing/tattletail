package org.codehaus.groovy.grails.plugins.jquery

import org.codehaus.groovy.grails.plugins.web.taglib.JavascriptProvider

/**
 * TODO: write javadoc
 *
 * 1.2.6
 *  - Changed $ into jQuery to prevent problems with prototype and his friends
 *  - Added prepareAjaxForm-code
 *
 * @author Sergey Nebolsin (nebolsin@prophotos.ru)
 */
class JQueryProvider implements JavascriptProvider {
    /**
     * @param taglib
     * @param attrs
     * @param out
     *
     * @return the jQuery-like formatted code for an AJAX-request
     */
    def doRemoteFunction(taglib, attrs, out) {
        if(attrs.onLoading) {
            out << "${attrs.onLoading};"
        }

        out << /jQuery.ajax({/

        def method = (attrs.method ? attrs.remove('method') : 'POST')
        out << "type:'$method'"

        if("false" == attrs.asynchronous) {
            out << ",async:false"
            attrs.remove('asynchronous')
        }

        if(attrs.dataType) {
            // Error Fix : instead of =
            out << ",dataType: '${attrs.remove('dataType')}'"
        }

        if (attrs.params || attrs.jsParams) {
            if(attrs.params && !(attrs.params instanceof Map)) {
                // tags like remoteField deliver
                out << ",data: ${attrs.remove('params')}"

            } else {
                out << ",data:{"

                def hasParams
                if(attrs.params) {
                    if(attrs.params instanceof Map) {
                        hasParams = true
                        out << attrs.remove('params').collect{k,v -> "${k}:".encodeAsJavaScript() + "\"" + "${v}".encodeAsJavaScript() + "\""}.join(",")
                    }
                }

                if(attrs.jsParams && attrs.jsParams instanceof Map) {
                    if(hasParams) out << ","
                    out << attrs.remove('jsParams').collect{k,v -> "${k}:${v}"}.join(",")

                }
                out << "}"
            }
        }

        // build url
        def url = attrs.url ? taglib.createLink(attrs.remove('url')) : taglib.createLink(attrs);
        out << ", url:'${url}'"


        buildCallback(attrs, out)

        // remove all onX callback events
        def callbacks = attrs.findAll { k, v ->
            k ==~ /on(\p{Upper}|\d){1}\w+/
        }
        callbacks.each { k, v ->
            attrs.remove(k)
        }

        out << "});"
    }

    // helper method to create callback object
    def buildCallback(attrs, out) {

        // success
        out << ',success:function(data,textStatus){'
        if (attrs.onLoaded) {
            out << "${attrs.onLoaded};"
        }
        if (attrs.update instanceof Map) {
            if (attrs.update?.success) {
                out << "jQuery('#${attrs.update.success}').html(data);"
            }
        } else if (attrs.update) {
            out <<  "jQuery('#${attrs.update}').html(data);"
        }

        if(attrs.onSuccess) {
            out << "${attrs.onSuccess};"
        }
        out << '}'

        // failure
        out << ',error:function(XMLHttpRequest,textStatus,errorThrown){'
        if (attrs.update instanceof Map) {
            if (attrs.update?.failure) {
                out << "jQuery('#${attrs.update?.failure}').html(textStatus);"
            }
        }
        if (attrs.onFailure) {
            out << "${attrs.onFailure};"
        }
        out << '}'

        if(attrs.onComplete) {
            out << ",complete:function(XMLHttpRequest,textStatus){${attrs.onComplete}}"
        }
    }

    def prepareAjaxForm(attrs) {
        attrs.params = "jQuery(this).serialize()".toString()
    }
}