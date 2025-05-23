package mikaojk.github.io

import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
import io.ktor.server.application.*
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.ByteArrayOutputStream

fun Application.configureRouting() {
    routing {
        post("/generate-qr") {
            val qrCodeRequest: QRCodeRequest = call.receive()
            val qrCode = generateQRCode(qrCodeRequest.text)
            call.respondBytes(qrCode, contentType = io.ktor.http.ContentType.Image.PNG)
        }
    }
}

fun generateQRCode(text: String): ByteArray {
    val writer = QRCodeWriter()
    val bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, 200, 200)

    ByteArrayOutputStream().use { outputStream ->
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream)
        return outputStream.toByteArray()
    }
}

data class QRCodeRequest(val text: String)