# TimelineView

A synchronized dual-view timeline visualization component for Android with native Compose support.

## Overview

TimelineView provides a synchronized scrolling experience with two content views that move in complementary directions. The component is built with Jetpack Compose for modern Android development and is perfect for timeline-based applications like audio/video editing, progress visualization, and data browsing.

## Features

- **Native Compose Implementation**: Pure Compose implementation without XML dependencies
- **Synchronized Scrolling**: Perfect offset synchronization between past and future content
- **Customizable Offset**: Configure the scroll offset as a fraction of screen width
- **Material 3 Support**: Built-in Material 3 styling variants
- **Modern Architecture**: Uses Compose's declarative UI paradigm
- **Flexible Content**: Support for any drawable resources as timeline content

## API Reference

### TimelineView

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | The modifier to be applied to the view |
| `height` | `Dp` | `200.dp` | Height of the timeline view |
| `pastContent` | `Int?` | `null` | Resource ID for the past content drawable |
| `futureContent` | `Int?` | `null` | Resource ID for the future content drawable |
| `offsetFraction` | `Float` | `1f/12f` | Scroll offset as fraction of screen width |
| `dividerWidth` | `Dp` | `2.dp` | Width of the center divider |
| `dividerColor` | `Color` | `Color.Transparent` | Color of the center divider |

### TimelineViewSimple

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | The modifier to be applied to the view |
| `height` | `Dp` | `120.dp` | Height of the timeline view |
| `pastContent` | `Int?` | `null` | Resource ID for the past content drawable |
| `futureContent` | `Int?` | `null` | Resource ID for the future content drawable |

## Use Cases

### Audio/Video Editing
Perfect for media editing applications where you need to show the played portion vs remaining content.

### Progress Visualization
Great for showing progress in long-running tasks, data processing, or multi-step workflows.

### Data Timeline
Ideal for data visualization where you need to show historical vs future data points.

### Reading Progress
Excellent for e-readers, articles, or documentation where you want to show reading progress.

## Implementation Details

### Synchronization Algorithm

The component uses a sophisticated scroll synchronization mechanism:

1. **Offset Calculation**: The left view is initialized with an offset of `screenWidth * offsetFraction`
2. **Bidirectional Sync**: Changes in either scroll view trigger updates in the other
3. **Smooth Scrolling**: Uses Compose's `LaunchedEffect` for smooth state updates
4. **Preventing Loops**: Synchronization flags prevent infinite update loops

### Performance Optimizations

- **Native Compose**: No XML inflation or View interop overhead
- **Efficient Recomposition**: Optimized state management to minimize recompositions
- **Memory Efficient**: Uses Compose's built-in memory management

## Default Content

The component includes default timeline content drawables:
- `soundwave_first_default_0` - Default past content (waveform visualization)
- `soundwave_second_default_0` - Default future content (waveform visualization)

## Contributing

When contributing to this component:

1. Follow Material 3 design principles
2. Ensure smooth performance on all screen sizes
3. Add appropriate tests for new features
4. Maintain the native Compose approach
5. Consider various use cases beyond audio waveforms

#  License

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
