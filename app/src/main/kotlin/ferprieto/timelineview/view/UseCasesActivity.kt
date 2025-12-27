package ferprieto.timelineview.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ferprieto.timelineview.R
import ferprieto.timelineview.TimelineView

class UseCasesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimelineViewAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UseCasesScreen()
                }
            }
        }
    }
}

@Composable
fun UseCasesScreen() {
    val context = LocalContext.current
    
    val timelineUseCases = listOf(
        TimelineUseCase(
            titleRes = R.string.podcast_chapters_title,
            descriptionRes = R.string.podcast_chapters_description,
            drawableRes = R.drawable.waveform_podcast_chapters,
            invertedDrawableRes = R.drawable.waveform_podcast_chapters_inverted,
        ),
        TimelineUseCase(
            titleRes = R.string.voice_messages_title,
            descriptionRes = R.string.voice_messages_description,
            drawableRes = R.drawable.waveform_voice_message,
            invertedDrawableRes = R.drawable.waveform_voice_message_inverted,
        ),
        TimelineUseCase(
            titleRes = R.string.music_creation_title,
            descriptionRes = R.string.music_creation_description,
            drawableRes = R.drawable.waveform_music_creation,
            invertedDrawableRes = R.drawable.waveform_music_creation_inverted,
        ),
        TimelineUseCase(
            titleRes = R.string.video_timeline_title,
            descriptionRes = R.string.video_timeline_description,
            drawableRes = R.drawable.waveform_video_timeline,
            invertedDrawableRes = R.drawable.waveform_video_timeline_inverted,
        ),
        TimelineUseCase(
            titleRes = R.string.audiobooks_title,
            descriptionRes = R.string.audiobooks_description,
            drawableRes = R.drawable.waveform_audiobooks,
            invertedDrawableRes = R.drawable.waveform_audiobooks_inverted,
        ),
        TimelineUseCase(
            titleRes = R.string.meditation_title,
            descriptionRes = R.string.meditation_description,
            drawableRes = R.drawable.waveform_meditation,
            invertedDrawableRes = R.drawable.waveform_meditation_inverted,
        ),
        TimelineUseCase(
            titleRes = R.string.data_sonification_title,
            descriptionRes = R.string.data_sonification_description,
            drawableRes = R.drawable.waveform_data_sonification,
            invertedDrawableRes = R.drawable.waveform_data_sonification_inverted,
        ),
        TimelineUseCase(
            titleRes = R.string.interactive_stories_title,
            descriptionRes = R.string.interactive_stories_description,
            drawableRes = R.drawable.waveform_interactive_storytelling,
            invertedDrawableRes = R.drawable.waveform_interactive_storytelling_inverted,
        ),
        TimelineUseCase(
            titleRes = R.string.game_soundtrack_title,
            descriptionRes = R.string.game_soundtrack_description,
            drawableRes = R.drawable.waveform_game_soundtrack,
            invertedDrawableRes = R.drawable.waveform_game_soundtrack_inverted,
        )
    )
    
    Column {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shadowElevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        (context as? ComponentActivity)?.finish()
                    }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                Text(
                    text = stringResource(R.string.timeline_view_use_cases),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
        
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(timelineUseCases) { useCase ->
                UseCaseCard(useCase = useCase)
            }
        }
    }
}



@Composable
fun UseCaseCard(useCase: TimelineUseCase) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(useCase.titleRes),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            Text(
                text = stringResource(useCase.descriptionRes),
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            TimelineView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                height = 80.dp,
                pastContent = useCase.drawableRes,
                futureContent = useCase.invertedDrawableRes
            )
        }
    }
}

data class TimelineUseCase(
    val titleRes: Int,
    val descriptionRes: Int,
    val drawableRes: Int,
    val invertedDrawableRes: Int
)
