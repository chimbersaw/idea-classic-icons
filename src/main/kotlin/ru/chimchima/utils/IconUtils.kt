package ru.chimchima.utils

import org.apache.commons.imaging.formats.icns.IcnsImageParser
import java.awt.image.BufferedImage

object IconUtils {
    private val icnsParser by lazy {
        IcnsImageParser()
    }

    fun getImageFromIcns(icns: ByteArray): BufferedImage {
        return icnsParser.getAllBufferedImages(icns).maxBy { it.width }
    }
}
