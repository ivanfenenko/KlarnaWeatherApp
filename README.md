# Klarna Weather App

# Idea:
I wanted to use technologies I am comfortable with but at the same time create a challenge for myself by picking something new.
Technologies I was comfortable with:
- mvvm
- dagger / hilt
- retrofit
- lottie

Technologies I am less comfortable with:
- compose


## Data:
I created a simple api provider using retrofit and simple repository using SharedFlow as caching mechanism. Im this was the app can be further developed to be reactive.

## UI :
I used single viewmodel for multiple views. However If it had more functionality I would build 3 different view-models for each widget on the main screen.
I used lottie lib to have some fun animations for current weather. 
Icons for weather forecast were provided by weather service. However I am not very happy how they look and finding new bundle was taking too much time. 

# Architecture: MVVM 
Since app is simple I tried to minimise unnecessary layers like (data source / use cases / e.t.c) and focused on minimum necessary packages to keep domain separation.

# Demo