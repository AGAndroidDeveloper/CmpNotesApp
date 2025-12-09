package org.ankit.mycmpnotes

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform