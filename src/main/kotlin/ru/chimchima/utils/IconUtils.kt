package ru.chimchima.utils

import org.apache.commons.imaging.formats.icns.IcnsImageParser
import java.awt.image.BufferedImage

object IconUtils {
    fun getImageFromIcns(icns: ByteArray): BufferedImage {
        return IcnsImageParser().getAllBufferedImages(icns).maxBy { it.width }
    }
}
