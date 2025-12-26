<img src="art/TimelineView-Banner.png" alt="TimelineView Banner" title="Banner" align="right" />

# TimelineView 〰️

TimelineView provides a synchronized scrolling experience with two content views that move in complementary directions. Originally designed for audio waveform visualization, it's now a versatile component perfect for any timeline-based application.

## Inspiration

<div align="center">
  <img src="art/inspiration.gif" alt="Soundcloud Inspiration" width="500"/>
  
  This is the original Soundcloud wave scroll view that inspired this project.
</div>

## Features

- **Native Compose Implementation**: Pure Compose implementation without XML dependencies
- **Synchronized Scrolling**: Perfect offset synchronization between past and future content
- **Customizable Offset**: Configure the scroll offset as a fraction of screen width
- **Material 3 Support**: Built-in Material 3 styling variants
- **Flexible Content**: Support for any drawable resources as timeline content

## Installation

### 1. Add this dependency in `build.gradle` (app-level)

Kotlin: 

```kotlin
implementation("com.github.ferPrieto:timelineview:LATEST_VERSION_NUMBER")
```

Groovy:

```groovy
implementation 'com.github.ferPrieto:timelineview:LATEST_VERSION_NUMBER'
```

If you are using a Gradle version catalog through a `libs.versions.toml` file:

1. Add `timelineview = "LATEST_VERSION_NUMBER"` in the `[versions]` section.
2. Add `timelineview = { group = "com.github.ferPrieto", name = "timelineview", version.ref = "timelineview" }` in the `[libraries]` section
3. Add `implementation(libs.timelineview)` in the app-level `build.gradle` file

### 2. Include Jitpack repository

You must include `jitpack.io` in your `settings.gradle` file because it's a public dependency

Kotlin:

```kotlin
dependencyResolutionManagement {
   ...
    repositories {
      ...
      maven("https://jitpack.io")
    }
}
```

Groovy:

```groovy
dependencyResolutionManagement {
   ...
    repositories {
      ...
      maven { url "https://jitpack.io" }
    }
}
```

## Usage

### Basic Implementation

```kotlin
@Composable
fun MyScreen() {
    TimelineView(
        height = 120.dp
    )
}
```

### With Custom Content

```kotlin
@Composable
fun MyScreen() {
    TimelineView(
        height = 120.dp,
        pastContent = R.drawable.my_past_content,
        futureContent = R.drawable.my_future_content
    )
}
```

### Advanced Configuration

```kotlin
@Composable
fun MyScreen() {
    TimelineView(
        height = 120.dp,
        pastContent = R.drawable.my_past_content,
        futureContent = R.drawable.my_future_content,
        offsetFraction = 1f/8f, // Custom offset
        dividerWidth = 1.dp,
        dividerColor = Color.Gray
    )
}
```

### Simplified Version

```kotlin
@Composable
fun MyScreen() {
    TimelineViewSimple(
        height = 120.dp
    )
}
```

### Material 3 Styled

```kotlin
@Composable
fun MyScreen() {
    TimelineViewMaterial3(
        height = 120.dp
    )
}
```

## Demo

<table align="center">
  <tr>
    <td align="center">
      <img src="art/main_screen_light.gif" alt="Main Screen Light" width="300"/>
      <br>
      <em>Main Screen - Light Mode</em>
    </td>
    <td align="center">
      <img src="art/main_screen_dark.gif" alt="Main Screen Dark" width="300"/>
      <br>
      <em>Main Screen - Dark Mode</em>
    </td>
  </tr>
  <tr>
    <td align="center">
      <img src="art/usecases_light.gif" alt="Use Cases Light" width="300"/>
      <br>
      <em>Use Cases - Light Mode</em>
    </td>
    <td align="center">
      <img src="art/usecases_dark.gif" alt="Use Cases Dark" width="300"/>
      <br>
      <em>Use Cases - Dark Mode</em>
    </td>
  </tr>
</table>

## Structure

- **`timelineview/`**: Core TimelineView library module
- **`app/`**: Demo application showcasing various use cases

## Documentation

For detailed API documentation, see [timelineview/README.md](timelineview/README.md)

## License

Copyright 2025 Fernando Prieto Moyano

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


