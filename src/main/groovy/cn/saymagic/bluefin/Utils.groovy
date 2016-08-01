package cn.saymagic.bluefin

import static cn.saymagic.bluefin.Constant.CAN_NOT_FIND_APK_PATH
import static cn.saymagic.bluefin.Constant.NO_HOST
import static cn.saymagic.bluefin.Constant.NO_HOST
import static cn.saymagic.bluefin.Constant.UNKNOW_ERROR
import static cn.saymagic.bluefin.Constant.UNKNOW_ERROR
import static cn.saymagic.bluefin.Constant.UPLOAD_PATH

/**
 * Created by saymagic on 16/8/1.
 */
public class Utils {

    public static Map<Integer, String> EXCAPTION_MAP = new HashMap<Integer, String>(){{
        put(UNKNOW_ERROR, "unknow error occur")
        put(NO_HOST, "no host statement, do you forget to declare it in bluefin closure")
        put(CAN_NOT_FIND_APK_PATH, "can not find apk path, do you forget to declare it in bluefin closure")
    }};


    public static boolean isEmpty(String str){
        return str == null || str.isEmpty()
    }

    public static void createException(int type) {
        if (EXCAPTION_MAP.containsKey(type)) {
            throw new RuntimeException(EXCAPTION_MAP.get(type))
        }
        throw new RuntimeException(EXCAPTION_MAP.get(UNKNOW_ERROR))
    }


    public static String getUploadUrl(String host) {
        if (isEmpty(host)) {
            createException(NO_HOST)
        }
        if (host.endsWith("/")) {
            host = host.substring(0, host.length() - 2)
        }
        return host + UPLOAD_PATH
    }
}
