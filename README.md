<p align="center">
<img src="/images/banner.png"/>
</p>
<p align="center">  
A banking app demonstrates modern Android development using Hilt, Coroutines, Jetpack Compose, Room, ViewModel, MVVM architecture.dark and ligth theme, offline support.
</p>
<p align="center">    
Based on https://developer.android.com/topic/architecture?hl=es-419
</p>
</br>

## Features
* Home, Cards, Transactions.
* Light and Dark theme
* Offline support
* Error handling

<img src="/images/demo.gif" align="right" width="320"/>

## Stack
- Minimum SDK level 24
- Kotlin
- MVVM
- Coroutines
- Jetpack Compose
- Room
- Hilt
- Architecture
  - MVVM Architecture + full  Repository Pattern
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit): Construct the REST APIs and paging network data.
- [Moshi](https://github.com/square/moshi/): A modern JSON library for Kotlin and Java.
- [Material-Components](https://github.com/material-components/material-components-android): Material design components for building ripple animation, and CardView.
- Coil,


## Architecture
**DroidBank** has three main features home, cards, transactions.
Each of them is based on the MVVM architecture and the Repository pattern, which follows the [Google's official architecture guidance](https://developer.android.com/topic/architecture).

<img src="/images/arquitecture_layer.jpg" align="center" width="550"/>

The overall architecture is composed of three layers; the UI layer, domain layer and data layer.
Each layer has dedicated components and they have each different responsibilities, as defined below:

### Architecture Overview

- Each layer follows [unidirectional event/data flow](https://developer.android.com/topic/architecture/ui-layer#udf); the UI layer emits user events to the data layer, and the data layer exposes data as a stream to other layers.
- The data layer is designed to work independently from other layers and must be pure, which means it doesn't have any dependencies on the other layers.

With this loosely coupled architecture, you can increase the reusability of components and scalability of your app.

### UI Layer

The UI layer is based on Jetpack Compoase consists the screens interacract with [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) that holds app states and restores data when configuration changes.

### Domain Layer
The Viewmodel from ui layer interact with the uses cases where the business logic is present it take data from the data layer.

### Data Layer

The data Layer consists of repositories, who query data from the local database or requesting remote data from the network depends the cache state.
DroidBank is an offline app so the app could display information without internet access depeding the stored data.

There are a validation by time stamp and eexpiration time where depending the expiration value the app will get data from db or api rest.

ie: cards feature

![image](https://github.com/sebacipolat/DroidBank/assets/1523404/b4c3b0f7-8f03-459c-b868-63b69d5f55c0)

Into the repository there are the logic to give the domain layer the data from the local db o api rest 

## Cache Control

The first purpose is to avoid heavy use of the  backend this will be called only when the data is expired.

Card table content:
![image](https://github.com/sebacipolat/DroidBank/assets/1523404/ce3770e6-027b-4df7-a78e-0055710e1b9d)

We use last_update (timestamp on miliseconds) value to check the expiration.
The search is based on this query timeLimit is the expiration time on minutes

"SELECT * FROM user_cards WHERE (:timeStamp - last_update) / 60000 <= :timeLimit"

![control de cache_droid_bank](https://github.com/sebacipolat/DroidBank/assets/1523404/1d2d61e7-61e0-41cc-a403-10b3fe8dd0bd)

## Testing
Unit test using jUnit + mockK


# License
```xml
Designed and developed by 2023 Sebastian Cipolat

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
