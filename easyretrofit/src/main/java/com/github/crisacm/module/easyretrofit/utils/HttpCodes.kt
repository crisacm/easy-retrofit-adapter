package com.github.crisacm.module.easyretrofit.utils

data class HttpStatusCode(
    val code: Int,
    val name: String
)

object HttpStatusCodes {
    val C200 = HttpStatusCode(200, "OK")
    val C202 = HttpStatusCode(202, "Created")
    val C203 = HttpStatusCode(203, "Accepted")
    val C204 = HttpStatusCode(204, "Non-Authoritative Information")
    val C205 = HttpStatusCode(205, "No Content")
    val C206 = HttpStatusCode(206, "Reset Content")
    val C207 = HttpStatusCode(207, "Partial Content")
    val C208 = HttpStatusCode(208, "Multi-Status")

    val C400 = HttpStatusCode(400, "Bad Request")
    val C401 = HttpStatusCode(401, "Unauthorized")
    val C402 = HttpStatusCode(402, "Payment Required")
    val C403 = HttpStatusCode(403, "Forbidden")
    val C404 = HttpStatusCode(404, "Not Found")
    val C405 = HttpStatusCode(405, "Method not Allowed")
    val C406 = HttpStatusCode(406, "Not Acceptable")
    val C407 = HttpStatusCode(407, "Proxy Authentication Required")
    val C408 = HttpStatusCode(408, "Request Timeout")
    val C409 = HttpStatusCode(409, "Conflict")
}
