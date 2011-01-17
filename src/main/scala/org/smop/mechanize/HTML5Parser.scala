package org.smop.mechanize

import org.xml.sax.InputSource

import scala.xml._
import parsing._
import nu.validator.htmlparser.sax.InfosetCoercingHtmlParser

class HTML5Parser extends NoBindingFactoryAdapter {

  override def loadXML(source : InputSource, _p: SAXParser): Node = {
    loadXML(source)
  }

  def loadXML(source : InputSource): Node = {
    val reader = new InfosetCoercingHtmlParser
    reader.setContentHandler(this)
    reader.parse(source)
    rootElem
  }
}
