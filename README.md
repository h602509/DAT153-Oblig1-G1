
> Task :app:connectedDebugAndroidTest
Caching disabled for task ':app:connectedDebugAndroidTest' because:
  Build cache is disabled
Task ':app:connectedDebugAndroidTest' is not up-to-date because:
  Task.upToDateWhen is false.
Executing java process: 
Starting process 'command '/Users/hanshammersland/Applications/Android Studio.app/Contents/jbr/Contents/Home/bin/java''. Working directory: /Users/hanshammersland/AndroidStudioProjects/DAT153Oblig1java/app Command: /Users/hanshammersland/Applications/Android Studio.app/Contents/jbr/Contents/Home/bin/java -Djava.awt.headless=true -Djava.util.logging.config.file=/Users/hanshammersland/.android/utp/logging9130171923327731092properties -Dfile.encoding=UTF-8 -Duser.country=NO -Duser.language=en -Duser.variant -cp /Users/hanshammersland/.gradle/caches/modules-2/files-2.1/com.google.testing.platform/launcher/0.0.8-alpha08/de8664b74f9b70fea224c610fd41b802805c72ab/launcher-0.0.8-alpha08.jar com.google.testing.platform.launcher.Launcher /Users/hanshammersland/.gradle/caches/modules-2/files-2.1/com.google.testing.platform/core/0.0.8-alpha08/762b033d6dcf24e44af8ccc5428ceb3eef540e37/core-0.0.8-alpha08.jar --proto_config=/Users/hanshammersland/.android/utp/runnerConfig6372531745583403620.pb --proto_server_config=/Users/hanshammersland/.android/utp/serverConfig13988571423730334352.pb
Successfully started process 'command '/Users/hanshammersland/Applications/Android Studio.app/Contents/jbr/Contents/Home/bin/java''
Starting 5 tests on Pixel_3a_API_34_extension_level_7_arm64-v8a(AVD) - 14

com.example.dat153_oblig1_java.MainActivityTest > goToGalleryActivity[Pixel_3a_API_34_extension_level_7_arm64-v8a(AVD) - 14] SUCCESS 

com.example.dat153_oblig1_java.MainActivityTest > goToQuizActivity[Pixel_3a_API_34_extension_level_7_arm64-v8a(AVD) - 14] SUCCESS 

com.example.dat153_oblig1_java.QuizActivityTest > goToResultActivityAfterQuiz[Pixel_3a_API_34_extension_level_7_arm64-v8a(AVD) - 14] SUCCESS 

com.example.dat153_oblig1_java.QuizActivityTest > testResultValuesAllRight[Pixel_3a_API_34_extension_level_7_arm64-v8a(AVD) - 14] SUCCESS 

com.example.dat153_oblig1_java.QuizActivityTest > testResultValuesAllWrong[Pixel_3a_API_34_extension_level_7_arm64-v8a(AVD) - 14] SUCCESS 

[XmlResultReporter]: XML test result file generated at /Users/hanshammersland/AndroidStudioProjects/DAT153Oblig1java/app/build/outputs/androidTest-results/connected/debug/TEST-Pixel_3a_API_34_extension_level_7_arm64-v8a(AVD) - 14-_app-.xml. Total tests 5, passed 5, 

> Task :app:connectedDebugAndroidTest
May 05, 2024 9:15:37 PM com.google.testing.platform.server.strategy.NonInteractiveServerStrategy run
INFO: Constructing runner from config.
May 05, 2024 9:15:37 PM com.google.testing.platform.runtime.android.driver.AndroidInstrumentationDriver configure
INFO: Configuring Android Instrumentation driver: android_instrumentation_runtime {
  instrumentation_info {
    app_package: "com.example.dat153_oblig1_java"
    test_package: "com.example.dat153_oblig1_java.test"
    test_runner_class: "androidx.test.runner.AndroidJUnitRunner"
  }
  instrumentation_args {
    args_map {
      key: "additionalTestOutputDir"
      value: "/sdcard/Android/media/com.example.dat153_oblig1_java/additional_test_output"
    }
  }
}
am_instrument_timeout: 31536000
