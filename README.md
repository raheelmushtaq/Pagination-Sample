# Pagination Sample

**This Project is implemented using.**
* Android Studio.
* Kotlin
* Compose

**Architecture of Project:**
* MVVM with Jetpack Compose.

**Api Calling Libraries**

* Api
* Free APi: https://public.opendatasoft.com/explore/dataset/all-vehicles-model/api/

* Retrofit.
* implementation 'com.squareup.retrofit2:retrofit:2.9.0'
* implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
* implementation 'com.squareup.retrofit2:adapter-rxjava2:2.9.0'
* implementation 'com.squareup.okhttp3:logging-interceptor:4.7.2'

**Storage**

* Room
* implementation("androidx.room:room-runtime:2.6.1")
* kapt("androidx.room:room-compiler:2.6.1")
* implementation("androidx.room:room-ktx:2.6.1")
* implementation("androidx.room:room-paging:2.6.1")

**Navigation**
* Compose Destinations (https://github.com/raamcosta/compose-destinations)
* implementation("io.github.raamcosta.compose-destinations:core:${raamCastaComposeVersion}")
* implementation("io.github.raamcosta.compose-destinations:animations-core:${raamCastaComposeVersion}")
* implementation("io.github.raamcosta.compose-destinations:wear-core:${raamCastaComposeVersion}")
* ksp("io.github.raamcosta.compose-destinations:ksp:${raamCastaComposeVersion}")



**All Libraries**

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    //navigation
    val raamCastaComposeVersion = "1.9.57"
    implementation("io.github.raamcosta.compose-destinations:core:${raamCastaComposeVersion}")
    implementation("io.github.raamcosta.compose-destinations:animations-core:${raamCastaComposeVersion}")
    implementation("io.github.raamcosta.compose-destinations:wear-core:${raamCastaComposeVersion}")
    ksp("io.github.raamcosta.compose-destinations:ksp:${raamCastaComposeVersion}")

    // splash screen
    implementation("androidx.core:core-splashscreen:1.1.0-alpha02")

    // Compose dependencies
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    //Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.48.1")
    kapt("com.google.dagger:hilt-compiler:2.48.1")
    kapt("androidx.hilt:hilt-compiler:1.1.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    
    // Room
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    implementation("androidx.room:room-paging:2.6.1")

    // Paging
    implementation("androidx.paging:paging-runtime-ktx:3.2.1")
    implementation("androidx.paging:paging-compose:1.0.0-alpha18")

    // Testing
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

Developer.
Raheel Mushtaq raheelmushtaq41@gmail.com
