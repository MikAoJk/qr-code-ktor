package mikaojk.github.io

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import io.ktor.client.request.*
import io.ktor.client.statement.bodyAsBytes
import io.ktor.http.*
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
                header(ContentTypeHeader, ContentType.Application.Json)
                setBody(objectMapper.writeValueAsString(QRCodeRequest("www.google.com")))
            }

        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals(true, isPng(response.bodyAsBytes()))


    }
    fun isPng(byteArray: ByteArray): Boolean {
        if (byteArray.size < 8) {
            return false
        }
        val pngSignature = byteArrayOf(0x89.toByte(), 0x50, 0x4e, 0x47, 0x0d, 0x0a, 0x1a, 0x0a)
        for (i in 0..7) {
            if (byteArray[i] != pngSignature[i]) {
                return false
            }
        }
        return true
    }

}
