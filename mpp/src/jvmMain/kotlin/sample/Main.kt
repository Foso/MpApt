package sample

import annotation.Component
import annotation.Module
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

@Module
class Server{

    val server = embeddedServer(Netty, 8080) {
        routing {



            @Hello
            get("/") {
                call.respondText("Hello, world!", ContentType.Text.Html)
            }
        }
    }


}