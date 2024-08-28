package com.example.android.uamp.media.library

import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.MediaBrowserCompat.MediaItem
import com.example.android.uamp.media.BuildConfig.BASE_URL
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
            title = "Supernova"
            artist = "aespa"
            album = "daily"
            duration = 180
            mediaUri = "${BASE_URL}media/daily/supernova.mp3"
            albumArtUri = "${BASE_URL}media/daily/supernova.jpg"
            trackNumber = 1
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "2"
            title = "Sticky"
            artist = "KISS OF LIFE"
            album = "daily"
            duration = 158
            mediaUri = "${BASE_URL}media/daily/sticky.mp3"
            albumArtUri = "${BASE_URL}media/daily/sticky.jpg"
            trackNumber = 2
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "17"
            title = "Small girl (feat. 도경수(D.O.))"
            artist = "이영지"
            album = "daily"
            duration = 190
            mediaUri = "${BASE_URL}media/daily/smallgirl.mp3"
            albumArtUri = "${BASE_URL}media/daily/smallgirl.jpg"
            trackNumber = 3
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "18"
            title = "Welcome to the Show"
            artist = "DAY6(데이식스)"
            album = "daily"
            duration = 218
            mediaUri = "${BASE_URL}media/daily/welcometotheshow.mp3"
            albumArtUri = "${BASE_URL}media/daily/welcometotheshow.jpg"
            trackNumber = 4
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "19"
            title = "고민중독"
            artist = "QWER"
            album = "daily"
            duration = 176
            mediaUri = "${BASE_URL}media/daily/gmjd.mp3"
            albumArtUri = "${BASE_URL}media/daily/gmjd.jpg"
            trackNumber = 5
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "20"
            title = "SPOT! (feat. JENNIE)"
            artist = "지코 (ZICO)"
            album = "daily"
            duration = 168
            mediaUri = "${BASE_URL}media/daily/spot.mp3"
            albumArtUri = "${BASE_URL}media/daily/spot.jpg"
            trackNumber = 6
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "21"
            title = "Love wins all"
            artist = "아이유(IU)"
            album = "daily"
            duration = 272
            mediaUri = "${BASE_URL}media/daily/lovewinsall.mp3"
            albumArtUri = "${BASE_URL}media/daily/lovewinsall.jpg"
            trackNumber = 7
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "22"
            title = "주저하는 연인들을 위해"
            artist = "잔나비"
            album = "daily"
            duration = 266
            mediaUri = "${BASE_URL}media/daily/jnb.mp3"
            albumArtUri = "${BASE_URL}media/daily/jnb.jpg"
            trackNumber = 8
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "23"
            title = "사건의 지평선"
            artist = "윤하"
            album = "daily"
            duration = 301
            mediaUri = "${BASE_URL}media/daily/yh.mp3"
            albumArtUri = "${BASE_URL}media/daily/yh.jpg"
            trackNumber = 9
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
            mediaUri = "${BASE_URL}media/dororok/gf.mp3"
            albumArtUri = "${BASE_URL}media/dororok/gf.jpg"
            trackNumber = 1
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "4"
            title = "비도 오고 그래서"
            artist = "헤이즈"
            album = "dororok"
            duration = 206
            mediaUri = "${BASE_URL}media/dororok/heize.mp3"
            albumArtUri = "${BASE_URL}media/dororok/heize.jpg"
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
            mediaUri = "${BASE_URL}media/drive/bpink.mp3"
            albumArtUri = "${BASE_URL}media/drive/bpink.jpg"
            trackNumber = 1
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "6"
            title = "D (half moon)"
            artist = "DEAN"
            album = "drive"
            duration = 195
            mediaUri = "${BASE_URL}media/drive/D.mp3"
            albumArtUri = "${BASE_URL}media/drive/D.jpg"
            trackNumber = 2
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "24"
            title = "한 페이지가 될 수 있게"
            artist = "Day6(데이식스)"
            album = "drive"
            duration = 206
            mediaUri = "${BASE_URL}media/drive/1page.mp3"
            albumArtUri = "${BASE_URL}media/drive/1page.jpg"
            trackNumber = 3
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "25"
            title = "Square (2017)"
            artist = "백예린 (Yerin Baek)"
            album = "drive"
            duration = 262
            mediaUri = "${BASE_URL}media/drive/square.mp3"
            albumArtUri = "${BASE_URL}media/drive/square.jpg"
            trackNumber = 4
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "26"
            title = "All I Wanna Do (feat. Hoody & Loco)"
            artist = "Jay Park(박재범)"
            album = "drive"
            duration = 215
            mediaUri = "${BASE_URL}media/drive/alliwannado.mp3"
            albumArtUri = "${BASE_URL}media/drive/alliwannado.jpg"
            trackNumber = 5
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "27"
            title = "Peaches (feat. Daniel Caesar, Giveon)"
            artist = "Justin Bieber"
            album = "drive"
            duration = 199
            mediaUri = "${BASE_URL}media/drive/peaches.mp3"
            albumArtUri = "${BASE_URL}media/drive/peaches.jpg"
            trackNumber = 6
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "28"
            title = "Drive (feat. GRAY)"
            artist = "Jay Park(박재범)"
            album = "drive"
            duration = 213
            mediaUri = "${BASE_URL}media/drive/drive.mp3"
            albumArtUri = "${BASE_URL}media/drive/drive.jpg"
            trackNumber = 7
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "29"
            title = "흔들리는 꽃들 속에서 네 샴푸향이 느껴진거야"
            artist = "장범준"
            album = "drive"
            duration = 169
            mediaUri = "${BASE_URL}media/drive/jbj.mp3"
            albumArtUri = "${BASE_URL}media/drive/jbj.jpg"
            trackNumber = 8
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "30"
            title = "어푸"
            artist = "아이유(IU)"
            album = "drive"
            duration = 201
            mediaUri = "${BASE_URL}media/drive/ahpuh.mp3"
            albumArtUri = "${BASE_URL}media/drive/ahpuh.jpg"
            trackNumber = 9
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "31"
            title = "그라데이션"
            artist = "10cm"
            album = "drive"
            duration = 202
            mediaUri = "${BASE_URL}media/drive/gradation.mp3"
            albumArtUri = "${BASE_URL}media/drive/gradation.jpg"
            trackNumber = 10
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
            mediaUri = "${BASE_URL}media/leave_work/iu.mp3"
            albumArtUri = "${BASE_URL}media/leave_work/iu.jpg"
            trackNumber = 1
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "8"
            title = "BLUE MOON (Prod. GroovyRoom)"
            artist = "효린, 창모 (CHANGMO)"
            album = "leaveWork"
            duration = 204
            mediaUri = "${BASE_URL}media/leave_work/bluemoon.mp3"
            albumArtUri = "${BASE_URL}media/leave_work/bluemoon.jpg"
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
            mediaUri = "${BASE_URL}media/to_work/newface.mp3"
            albumArtUri = "${BASE_URL}media/to_work/newface.jpg"
            trackNumber = 1
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "10"
            title = "얼굴 찌푸리지 말아요"
            artist = "하이라이트 (Highlight)"
            album = "toWork"
            duration = 186
            mediaUri = "${BASE_URL}media/to_work/face.mp3"
            albumArtUri = "${BASE_URL}media/to_work/face.jpg"
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
            mediaUri = "${BASE_URL}media/travel/likey.mp3"
            albumArtUri = "${BASE_URL}media/travel/likey.jpg"
            trackNumber = 1
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "12"
            title = "고민보다 Go"
            artist = "방탄소년단"
            album = "travel"
            duration = 236
            mediaUri = "${BASE_URL}media/travel/go.mp3"
            albumArtUri = "${BASE_URL}media/travel/go.jpg"
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
            mediaUri = "${BASE_URL}media/with_friends/nothanks.mp3"
            albumArtUri = "${BASE_URL}media/with_friends/nothanks.jpg"
            trackNumber = 1
            flag = MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "14"
            title = "Artist"
            artist = "지코 (ZICO)"
            album = "withFriends"
            duration = 193
            mediaUri = "${BASE_URL}media/with_friends/artist.mp3"
            albumArtUri = "${BASE_URL}media/with_friends/artist.jpg"
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
            mediaUri = "${BASE_URL}media/with_lover/allofmylife.mp3"
            albumArtUri = "${BASE_URL}media/with_lover/allofmylife.jpg"
            trackNumber = 1
            flag = MediaBrowserCompat.MediaItem.FLAG_PLAYABLE
        }.build(),
        MediaMetadataCompat.Builder().apply {
            id = "16"
            title = "썸 탈거야"
            artist = "볼빨간사춘기"
            album = "withLover"
            duration = 182
            mediaUri = "${BASE_URL}media/with_lover/some.mp3"
            albumArtUri = "${BASE_URL}media/with_lover/some.jpg"
            trackNumber = 2
            flag = MediaBrowserCompat.MediaItem.FLAG_PLAYABLE
        }.build()
    )

}