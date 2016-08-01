package cn.saymagic.bluefin

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction

import static cn.saymagic.bluefin.Constant.CAN_NOT_FIND_APK_PATH
import static cn.saymagic.bluefin.Constant.NO_HOST
import static cn.saymagic.bluefin.Constant.UPLOAD_APK_PARAMETER_NAME
import static cn.saymagic.bluefin.Constant.UPLOAD_MAPPING_PARAMETER_NAME

/**
 * Created by saymagic on 16/8/1.
 */
public class UploadTask extends DefaultTask {


    private final OkHttpClient client = new OkHttpClient();

    private final static MediaType MEDIA_TYPE_TXT = MediaType.parse("text/txt; charset=utf-8");

    private final static MediaType MEDIA_TYPE_APK = MediaType.parse("application/vnd.android.package-archive");

    @TaskAction
    public void doUpload() {
        String host = getUploadUrl(project)
        String apkPath = getApkPath(project)
        String mappingPath = getMappingPath(project)

        if (Utils.isEmpty(host)) {
            Utils.createException(NO_HOST)
        }

        if (Utils.isEmpty(apkPath)) {
            Utils.createException(CAN_NOT_FIND_APK_PATH)
        }

        println("host: " + host)
        println("apkPath: " + apkPath)
        println("mappingPath: " + mappingPath)

        MultipartBody.Builder builder = new MultipartBody.Builder()

        File apkFile = new File(apkPath)
        RequestBody apkBody = RequestBody.create(MEDIA_TYPE_APK, apkFile)
        MultipartBody.Part apkPart = MultipartBody.Part.createFormData(UPLOAD_APK_PARAMETER_NAME, apkFile.getName(), apkBody)
        builder.addPart(apkPart)
        println("add apk part: " + String.valueOf(apkFile))

        if (!Utils.isEmpty(mappingPath)) {
            File mappingFile = new File(mappingPath)
            RequestBody mappingBody = RequestBody.create(MEDIA_TYPE_TXT, mappingFile)
            MultipartBody.Part mappingPart = MultipartBody.Part.createFormData(UPLOAD_MAPPING_PARAMETER_NAME, mappingFile.getName(), mappingBody)
            builder.addPart(mappingPart)
            println("add mapping part: " + String.valueOf(mappingFile))
        }

        MultipartBody body = builder.build()

        Request request = new Request.Builder()
                .url(host)
                .post(body)
                .build();

        Response response = client.newCall(request).execute()
        if (response.isSuccessful()) {
            println("[SUCCESS]: " + response.body().string())
        } else {
            println("[ERROR]: " + response.body().string())
        }
    }


    private String getUploadUrl(Project project) {
        return Utils.getUploadUrl(project.bluefin.host)
    }

    private String getApkPath(Project project) {
        return project.bluefin.apkPath
    }

    private String getMappingPath(Project project) {
        return project.bluefin.mappingPath
    }
}
