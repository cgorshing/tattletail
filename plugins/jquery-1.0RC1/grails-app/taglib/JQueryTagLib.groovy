import org.codehaus.groovy.grails.plugins.jquery.JQueryConfig
import org.springframework.context.ApplicationContextAware
import org.springframework.context.ApplicationContext

/**
 * TODO: write javadoc
 *
 * @author Sergey Nebolsin (nebolsin@prophotos.ru)
 */
class JQueryTagLib implements ApplicationContextAware {
    def jQueryConfig

    static namespace = "jq"

    def plugin = {attrs, body ->
        if(attrs.name) {
            jQueryConfig.plugins."${attrs.name}".each {
                out << '<script type="text/javascript" src="'
                out << createLinkTo(dir:'js/jquery', file:it)
                out << '"></script>'
            }
        }
    }

    def jquery = {attrs, body ->
        out << '<script type="text/javascript"> $().ready(function(){'
        out << body()
        out << '}); </script>'
    }

    def toggleelement = {attrs ->
        out << /$("#${attrs['linkId']}").${attrs['event']}(function(){ $("#${attrs['elementId']}").toggle("${attrs['speed']}"); return false; });/
    }

    def fieldValue = {attrs ->
        def selector
        if(attrs.selector) {
            selector = attrs['selector']
        } else if(attrs.elementId) {
            selector = /#${attrs['elementId']}/
        }
        out << /$('${selector}').fieldValue()[0]/
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        jQueryConfig = applicationContext.jQueryConfig
    }
}