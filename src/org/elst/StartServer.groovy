package org.elst

import org.elst.server.TextSimilarityHandler

InetSocketAddress addr = new InetSocketAddress(8000)
httpServer = com.sun.net.httpserver.HttpServer.create(addr, 0)
httpServer.with {
	createContext('/similarity', new TextSimilarityHandler())
	//setExecutor(Executors.newCachedThreadPool())
	start()
}