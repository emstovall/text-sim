package org.elst.server

import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import groovy.json.JsonSlurper
import org.elst.ml.TextSimilarity

class TextSimilarityHandler implements HttpHandler {
	@Override
	void handle(HttpExchange exchange) throws IOException {
		println("got a request")
		if(exchange.requestMethod == 'POST') {

			// get texts from body
			def body = exchange.requestBody
			def contents = body.readLines()

			JsonSlurper jsonSlurper = new JsonSlurper()
			def json = jsonSlurper.parseText(contents)
			String firstString = json.text1.toString()
			String secondString = json.text2.toString()

			//return cosine similarity
			def result = TextSimilarity.cosineSimilarityScore(firstString, secondString)

			body.close()

			//respond with score
			exchange.sendResponseHeaders(200,0)
			exchange.responseBody.write("score: $result".bytes);
			exchange.responseBody.close()



		} else if (exchange.requestMethod == "GET") {
			exchange.sendResponseHeaders(200,0)
			exchange.responseBody.write("please use POST".bytes);
			exchange.responseBody.close()
		}
	}
}
