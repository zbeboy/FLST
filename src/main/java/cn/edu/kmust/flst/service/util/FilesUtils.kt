package cn.edu.kmust.flst.service.util

import java.io.File
import java.io.IOException
import java.util.*

/**
 * Created by zbeboy 2017-11-30 .
 **/
class FilesUtils {
    companion object {
        /**
         * 删除硬盘上的文件
         *
         * @param path 文件路径
         * @return true 删除成功，false 删除失败或路径为空，文件不存在
         * @throws IOException
         */
        @JvmStatic
        @Throws(IOException::class)
        fun deleteFile(path: String): Boolean {
            if (!Objects.isNull(path) && "" != path.trim { it <= ' ' }) {
                val file = File(path)
                if (file.exists()) {
                    return file.delete()
                }
            }
            return false
        }

        /**
         * 转换文件单位
         *
         * @param size 文件大小
         * @return 文件尺寸
         */
        @JvmStatic
        fun transformationFileUnit(size: Long): String {
            return if (size < 1024) {
                size.toString() + "B"
            } else if (size >= 1024 && size < 1024 * 1024) {
                (size / 1024).toString() + "KB"
            } else if (size >= 1024 * 1024 && size < 1024 * 1024 * 1024) {
                (size / (1024 * 1024)).toString() + "MB"
            } else {
                (size / (1024 * 1024 * 1024)).toString() + "GB"
            }
        }
    }
}