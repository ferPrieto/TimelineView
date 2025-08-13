<div align="center">
  <img src="art/banner.jpg" alt="TimelineView Banner"/>
  
  A synchronized dual-view UI component library for Android, inspired by the Soundcloud wave scroll view.
</div>

## Overview

TimelineView provides a synchronized scrolling experience with two content views that move in complementary directions. Originally designed for audio waveform visualization, it's now a versatile component perfect for any timeline-based application.

## Features

- **Native Compose Implementation**: Pure Compose implementation without XML dependencies
- **Synchronized Scrolling**: Perfect offset synchronization between past and future content
- **Customizable Offset**: Configure the scroll offset as a fraction of screen width
- **Material 3 Support**: Built-in Material 3 styling variants
- **Flexible Content**: Support for any drawable resources as timeline content

## Quick Start

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

## Demo

<table>
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


