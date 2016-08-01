package cn.saymagic.bluefin

import okhttp3.MediaType
import okhttp3.OkHttpClient
import org.gradle.api.Plugin
import org.gradle.api.Project
import static cn.saymagic.bluefin.Constant.*

/**
 * Created by saymagic on 16/7/31.
 */
class BluefinPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        project.extensions.create("bluefin", BluefinPluginExtension)

        project.task(UPLOAD_TASK_NAME, type: UploadTask)

    }

}
