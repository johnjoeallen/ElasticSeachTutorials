@Grapes([
	@Grab(group='net.sourceforge.nekohtml', module='nekohtml', version='1.9.21'),
	@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7' )
])

import groovy.util.XmlSlurper
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*

def indexTags = [
	"P":true,
	"TITLE":true,
	"LI":true,
]

new File("feed.txt").eachLine { url ->
	print "URL[$url]: "
	def html = new URL(url).getText()
	def slurper = new XmlSlurper(new org.cyberneko.html.parsers.SAXParser())

	def root = slurper.parseText(html)

	def tags = root."**".findAll {
		if (indexTags[it.name().toUpperCase()] && it.text().trim().length() > 0) {
			it
		}
	}

	def text = tags.collect { it.text().trim() }.join(" ")
	def elasticUrl = "http://localhost:9200/pgindex/page/" + url.hashCode().toString().replaceAll("[-]", "X")
	def http = new HTTPBuilder(elasticUrl)

	http.request(POST, JSON) { req ->
		body = [
		  url : url,
		  text : text
		]
 
		response.success = { resp, json ->
			// response handling here
			println "${resp.statusLine.statusCode}"
		}
 
		response.failure = { resp, json ->
			// response handling here
			println "${resp.statusLine.statusCode}"
		}
	}
}
