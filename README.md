This is the Android application developed in Kotlin and folows MVVM architechture. Dagger is used for dependency injection. Retrofit is used for REST API call handling.
On the home screen you will see two tabs named Sources and All News both has the listing of contents.
On the Sources screen you will see the list of sources on tapping any of the source in the list you will see the list of news w.r.t that source.
On the All News screen you will see all the list of news from News api, and pagination is added here.
On clicking of the new item weather from the Sources news or from the All News screen you will navigate to the News details screen where all the details like description,
author url link etc is been mentioned.
This is the single activity application with multiple fragments. So you will find HomeActivity as single activity in it there are different fragments.
Splash actiivty is created for performing startup things. For navigation here I have used fragment navigation component.
