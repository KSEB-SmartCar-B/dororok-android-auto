package com.example.android.uamp.media.library

import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.MediaBrowserCompat.MediaItem
import com.example.android.uamp.media.extensions.album
import com.example.android.uamp.media.extensions.albumArtUri
import com.example.android.uamp.media.extensions.artist
import com.example.android.uamp.media.extensions.duration
import com.example.android.uamp.media.extensions.flag
import com.example.android.uamp.media.extensions.id
import com.example.android.uamp.media.extensions.mediaUri
import com.example.android.uamp.media.extensions.title
import com.example.android.uamp.media.extensions.trackNumber

class MusicList {
    val daily: List<MediaMetadataCompat> = listOf(
        MediaMetadataCompat.Builder().apply {
            id = "1"
            title = "폰서트"
            artist = "10cm"
            album = "daily"
            duration = 198
            mediaUri = "http://20.41.105.73/media/daily/10cm.mp3"
            albumArtUri = "http://20.41.105.73/media/daily/10cm.jpg"
            trackNumber = 1
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "2"
            title = "REALLY REALLY"
            artist = "WINNER"
            album = "daily"
            duration = 203
            mediaUri = "http://20.41.105.73/media/daily/winner.mp3"
            albumArtUri = "http://20.41.105.73/media/daily/winner.jpg"
            trackNumber = 2
            flag = MediaItem.FLAG_PLAYABLE
        }.build()
    )

    val dororok: List<MediaMetadataCompat> = listOf(
        MediaMetadataCompat.Builder().apply {
            id = "3"
            title = "Summer Rain"
            artist = "GFRIEND"
            album = "dororok"
            duration = 201
            mediaUri = "http://20.41.105.73/media/dororok/gf.mp3"
            albumArtUri = "https://i.scdn.co/image/gf.jpg"
            trackNumber = 1
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "4"
            title = "비도 오고 그래서"
            artist = "헤이즈"
            album = "dororok"
            duration = 206
            mediaUri = "http://20.41.105.73/media/dororok/heize.mp3"
            albumArtUri = "http://20.41.105.73/media/dororok/heize.jpg"
            trackNumber = 2
            flag = MediaItem.FLAG_PLAYABLE
        }.build()
    )

    val drive: List<MediaMetadataCompat> = listOf(
        MediaMetadataCompat.Builder().apply {
            id = "5"
            title = "마지막처럼"
            artist = "BLACKPINK"
            album = "drive"
            duration = 214
            mediaUri = "http://20.41.105.73/media/drive/bpink.mp3"
            albumArtUri = "http://20.41.105.73/media/drive/bpink.jpg"
            trackNumber = 1
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "6"
            title = "D (half moon)"
            artist = "DEAN"
            album = "drive"
            duration = 195
            mediaUri = "http://20.41.105.73/media/drive/D.mp3"
            albumArtUri = "http://20.41.105.73/media/drive/D.jpg"
            trackNumber = 2
            flag = MediaItem.FLAG_PLAYABLE
        }.build()
    )

    val leaveWork: List<MediaMetadataCompat> = listOf(
        MediaMetadataCompat.Builder().apply {
            id = "7"
            title = "어젯밤 이야기"
            artist = "아이유(IU)"
            album = "leaveWork"
            duration = 234
            mediaUri = "http://20.41.105.73/media/leave_work/iu.mp3"
            albumArtUri = "http://20.41.105.73/media/leave_work/iu.jpg"
            trackNumber = 1
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "8"
            title = "BLUE MOON (Prod. GroovyRoom)"
            artist = "효린, 창모 (CHANGMO)"
            album = "leaveWork"
            duration = 204
            mediaUri = "http://20.41.105.73/media/leave_work/bluemoon.mp3"
            albumArtUri = "http://20.41.105.73/media/leave_work/bluemoon.jpg"
            trackNumber = 2
            flag = MediaItem.FLAG_PLAYABLE
        }.build()
    )

    val toWork: List<MediaMetadataCompat> = listOf(
        MediaMetadataCompat.Builder().apply {
            id = "9"
            title = "New Face"
            artist = "싸이 (PSY)"
            album = "toWork"
            duration = 191
            mediaUri = "http://20.41.105.73/media/to_work/newface.mp3"
            albumArtUri = "http://20.41.105.73/media/to_work/newface.jpg"
            trackNumber = 1
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "10"
            title = "얼굴 찌푸리지 말아요"
            artist = "하이라이트 (Highlight)"
            album = "toWork"
            duration = 186
            mediaUri = "http://20.41.105.73/media/to_work/face.mp3"
            albumArtUri = "http://20.41.105.73/media/to_work/face.jpg"
            trackNumber = 2
            flag = MediaItem.FLAG_PLAYABLE
        }.build()
    )

    val travel: List<MediaMetadataCompat> = listOf(
        MediaMetadataCompat.Builder().apply {
            id = "11"
            title = "LIKEY"
            artist = "TWICE (트와이스)"
            album = "travel"
            duration = 208
            mediaUri = "http://20.41.105.73/media/travel/likey.mp3"
            albumArtUri = "http://20.41.105.73/media/travel/likey.jpg"
            trackNumber = 1
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "12"
            title = "고민보다 Go"
            artist = "방탄소년단"
            album = "travel"
            duration = 236
            mediaUri = "http://20.41.105.73/media/travel/go.mp3"
            albumArtUri = "http://20.41.105.73/media/travel/go.jpg"
            trackNumber = 2
            flag = MediaItem.FLAG_PLAYABLE
        }.build()
    )

    val withFriends: List<MediaMetadataCompat> = listOf(
        MediaMetadataCompat.Builder().apply {
            id = "13"
            title = "노땡큐 (Feat. MINO 사이먼 도미닉 더콰이엇)"
            artist = "에픽 하이 (EPIK HIGH)"
            album = "withFriends"
            duration = 278
            mediaUri = "http://20.41.105.73/media/with_friends/nothanks.mp3"
            albumArtUri = "http://20.41.105.73/media/with_friends/nothanks.jpg"
            trackNumber = 1
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "14"
            title = "Artist"
            artist = "지코 (ZICO)"
            album = "withFriends"
            duration = 193
            mediaUri = "http://20.41.105.73/media/with_friends/artist.mp3"
            albumArtUri = "http://20.41.105.73/media/with_friends/artist.jpg"
            trackNumber = 2
            flag = MediaItem.FLAG_PLAYABLE
        }.build()
    )

    val withLover: List<MediaMetadataCompat> = listOf(
        MediaMetadataCompat.Builder().apply {
            id = "15"
            title = "all of my life"
            artist = "박원"
            album = "withLover"
            duration = 250
            mediaUri = "http://20.41.105.73/media/with_lover/allofmylife.mp3"
            albumArtUri = "http://20.41.105.73/media/with_lover/allofmylife.jpg"
            trackNumber = 1
            flag = MediaBrowserCompat.MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "16"
            title = "썸 탈거야"
            artist = "볼빨간사춘기"
            album = "withLover"
            duration = 182
            mediaUri = "http://20.41.105.73/media/with_lover/some.mp3"
            albumArtUri = "http://20.41.105.73/media/with_lover/some.jpg"
            trackNumber = 2
            flag = MediaBrowserCompat.MediaItem.FLAG_PLAYABLE
        }.build()
    )

}