# Welcome to GiphyApp!
## Description
This application will help you to find gifs you want. 


## Files
#### Retrofit folder

Interaction with Giphy API was implemented in [Retrofit folder](app/src/main/java/com/example/gifsearch/Retrofit). [DataClaasses.kt](app/src/main/java/com/example/gifsearch/Retrofit/DataClaasses.kt) comprises of Data classes responsible for the structure of the JSON file and the transition through it.
`@GET query` had written in [GetData interface](app/src/main/java/com/example/gifsearch/Retrofit/GetData.kt). 

#### [GifsAdapter.kt](app/src/main/java/com/example/gifsearch/GifsAdapter.kt)
All logic of RecyclerView is here.

#### [Show1Gif.kt](app/src/main/java/com/example/gifsearch/Show1Gif.kt)
It's a screen that shows gif and its information.
