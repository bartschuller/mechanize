# Mechanize

Mechanize for Scala is a programmable web robot, useful for testing and scraping websites. It understands both the HTTP protocol and HTML, thanks to [Apache HttpClient](http://hc.apache.org/httpcomponents-client-ga/) and [the Validator.nu HTML Parser](http://about.validator.nu/htmlparser/).

## Building

There are no prebuilt jars available at this time. To build it yourself you have to use [sbt](http://code.google.com/p/simple-build-tool/) (highly recommended!)

    sbt update publish-local

and add the following dependency to your project:

    "org.smop" %% "mechanize" % "0.1-SNAPSHOT"

## Contact

The project is currently hosted at [GitHub](https://github.com/bartschuller/mechanize) and the usual github tools can be used to communicate with the author. Other means of contact include Twitter [@BartSchuller](http://twitter.com/BartSchuller) and email [mechanize@smop.org](mailto:mechanize@smop.org).

## License

The *org.smop mechanize* library is published under the [Simplified BSD License](http://www.opensource.org/licenses/bsd-license):

Copyright © 2011, Bart Schuller  
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

  * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
  * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.