package cn.edu.kmust.flst.service.util

/**
 * Created by zbeboy 2017-11-30 .
 **/
class SQLQueryUtils {
    companion object {
        /**
         * 组装likeAll全匹配参数
         *
         * @param param 参数
         * @return like '%{param}%'
         */
        @JvmStatic
        fun likeAllParam(param: String): String {
            return "%$param%"
        }

        /**
         * 右 like
         *
         * @param param 参数
         * @return like '{param}%'
         */
        @JvmStatic
        fun rightLikeParam(param: String): String {
            return param + "%"
        }
    }
}