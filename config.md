# 1.环境：studio版本3.4.1
   Gradle plugin version: classpath 'com.android.tools.build:gradle:3.4.1'  
   Gradle Version: 5.1.1
# 2.project 下的 build.gradle 配置
   classpath 'com.novoda:bintray-release:0.9'    // novada plugin 快速配置工具
# 3.library 下的 build.gradle 配置
   apply plugin: 'com.novoda.bintray-release'
# 4.上传github命令
   gradlew clean build bintrayUpload -PbintrayUser=fish -PbintrayKey=86dc41aa041a5a9e00295650f013910e343a88ae -PdryRun=false
# 注意的地方
  /gradle/wrapper 文件夹必须有，不然上传不了

   