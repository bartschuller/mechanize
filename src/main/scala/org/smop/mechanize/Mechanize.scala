/** A library for stateful programmatic web browsing,
  * used for automating interaction with websites.
  */
package org.smop.mechanize

import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.client.methods.{HttpUriRequest, HttpGet}
import org.apache.http.{HttpEntity, HttpResponse}
import java.io.InputStream
import xml.Node
import java.net.URI
import org.xml.sax.InputSource

/** The do-it-all class.
  * @param agent the HTTP User Agent */
class Mechanize(var agent: String = "org.smop.mechanize/0.1") {
  protected val _httpclient = new DefaultHttpClient

  protected var _request: HttpUriRequest = null
  protected var _uri: URI = null
  protected var _lastUri: URI = null
  protected var _response: HttpResponse = null
  protected var _status: Int = 0
  protected var _entity: HttpEntity = null
  protected var _ct: String = ""
  protected var _xml: Node = null

  /** Given a URL/URI, fetches it.
    * @return the HttpResponse */
  def get(uri: String) = request(new HttpGet(uri))
  /** Returns the current URI. This object stringifies to the URI itself. */
  def uri = _uri
  /** Return the current response. */
  def response = _response
  /** Returns the HTTP status code of the response. This is a 3-digit number like 200 for OK, 404 for not found, and so on. */
  def status = _status
  /** Returns a boolean telling whether the last request was successful. If there hasn't been an operation yet, returns false. */
  def isSuccess = _response != null && _status >= 200 && _status < 300
  /** Returns the content type of the response. */
  def ct = _ct
  /** Returns true/false on whether our content is HTML, according to the HTTP headers. */
  def isHtml = "text/html".r findPrefixOf _ct isDefined
  /** Lists all the links on the current page. */
  def links = null
  /** Returns the content that the mech uses internally for the last page fetched. */
  def content = _xml
  /** Performs the actual request. */
  def request(req: HttpUriRequest) = updatePage(req, _httpclient.execute(req))

  protected def updatePage(req: HttpUriRequest, res: HttpResponse): HttpResponse = {
    _request = req
    _response = res
    _status = res.getStatusLine.getStatusCode
    _entity = res.getEntity
    _ct = _entity.getContentType.getValue
    if (isSuccess) {
      _uri = req.getURI
      _lastUri = _uri
    }
    resetPage()
    if (isHtml)
      updateHtml(_entity.getContent)

    res
  }
  protected def resetPage() {
  }
  protected def updateHtml(is: InputStream) {
    val parser = new HTML5Parser
    _xml = parser.loadXML(new InputSource(is))
  }
}

object Mechanize {
  def apply(agent: String = "org.smop.mechanize/0.1") = new Mechanize(agent)
}
