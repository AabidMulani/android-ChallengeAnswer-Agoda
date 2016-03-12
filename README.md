# Android Challenge Improvement (Agoda)

[Source Code Zip](https://drive.google.com/file/d/0BxJ0KCoLDAvndnFzN0ozank0YjA/view?usp=sharing)

[Download APK](https://drive.google.com/file/d/0BxJ0KCoLDAvncjZlZmItUHN1SmM/view?usp=sharing)


###1) Code Project Structure:
	- activities : All activitites are listed here
	- adapters
	- enums
	- fragments : All fragments used in the application
	- interfaces : WebInterface for Retrofit and other communicating interfaces
	- models 
	- database
	- utils
	- webAsyncs
	- widgets


###2) App Architecture:
The targetted application uses a single activity to hold both the News List and the Details News List in a fragment

###3) 3rd Party Libraries:
	- AppCompat
	- Design Library
	- Recycler View
	- Card View
	- Retrofit (Not used in targetted application)
	- Gson
	- OkHttp (Not used in targetted application)
	- Butterknife
	- Universal Image Loader

###4) JsonDeserializer 
The data provided in the news_list.json has an inconsistency for the parameter named `multimedia`.

Please go throught [THIS FILE](https://github.com/AabidMulani/android-ChallengeAnswer-Agoda/blob/master/app/src/main/java/news/agoda/com/technewssample/utils/NullStringToEmptyAdapterFactory.java) to see a basic implementation to handle such scenario.


