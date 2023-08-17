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

## Tradeoffs:
- No real theme was designed. My weather "widgets" provide some UI separation, however having a defined Design System would be a great improvement. I know Klarna has a big focus on design systems.
- Data mapping hidden in extension functions. Network data is directly mapped to UI state. And it would need more effort to make it testable and decoupled from the rest of the code.
- There is no good city / location provider. The list of cities is hardcoded and Berlin is default. Ideally I would need some provider for the city. Maybe by using local Data source for configuration storage. Same for locale and units.
- UI is not optimised for smalled or larger screens (like fold-ables)

## Architecture: MVVM 
Since app is simple I tried to minimise unnecessary layers like (data source / use cases / e.t.c) and focused on minimum necessary packages to keep domain separation.

## Demo


https://github.com/ivanfenenko/KlarnaWeatherApp/assets/10911644/b9ee6931-07aa-4fe8-aff8-c51eb8756a9c

