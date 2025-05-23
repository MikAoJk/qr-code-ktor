package mikaojk.github.io

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.http.HttpHeaders.Accept as AcceptHeader
import io.ktor.http.HttpHeaders.ContentType as ContentTypeHeader
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    private val objectMapper: ObjectMapper =
        ObjectMapper()
            .registerKotlinModule()
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)


    @Test
    fun testGenerateQr() = testApplication {
        application {
            module()
        }

        val response =
            client.post("/generate-qr") {
                setBody(objectMapper.writeValueAsString(QRCodeRequest("www.google.com")))
            }

        assertEquals(HttpStatusCode.OK, response.status)

    }

}
