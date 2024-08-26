/*
 * Copyright 2019 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.uamp.media.library

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaBrowserCompat.MediaItem
import android.support.v4.media.MediaMetadataCompat
import android.util.Log
import android.util.LogPrinter
import com.example.android.uamp.media.MusicService
import com.example.android.uamp.media.R
import com.example.android.uamp.media.SavedMusic
import com.example.android.uamp.media.Situation
import com.example.android.uamp.media.extensions.album
import com.example.android.uamp.media.extensions.albumArt
import com.example.android.uamp.media.extensions.albumArtUri
import com.example.android.uamp.media.extensions.artist
import com.example.android.uamp.media.extensions.flag
import com.example.android.uamp.media.extensions.id
import com.example.android.uamp.media.extensions.title
import com.example.android.uamp.media.extensions.trackNumber
import com.example.android.uamp.media.extensions.urlEncoded
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.UUID

/**
 * Represents a tree of media that's used by [MusicService.onLoadChildren].
 *
 * [BrowseTree] maps a media id (see: [MediaMetadataCompat.METADATA_KEY_MEDIA_ID]) to one (or
 * more) [MediaMetadataCompat] objects, which are children of that media id.
 *
 * For example, given the following conceptual tree:
 * root
 *  +-- Albums
 *  |    +-- Album_A
 *  |    |    +-- Song_1
 *  |    |    +-- Song_2
 *  ...
 *  +-- Artists
 *  ...
 *
 *  Requesting `browseTree["root"]` would return a list that included "Albums", "Artists", and
 *  any other direct children. Taking the media ID of "Albums" ("Albums" in this example),
 *  `browseTree["Albums"]` would return a single item list "Album_A", and, finally,
 *  `browseTree["Album_A"]` would return "Song_1" and "Song_2". Since those are leaf nodes,
 *  requesting `browseTree["Song_1"]` would return null (there aren't any children of it).
 */
class BrowseTree(
    val context: Context,
    musicSource: MusicSource,
    val recentMediaId: String? = null
) {
    //앨범 id를 키로 저장하여 해당 앨범 곡 리스트 의미.
    private val mediaIdToChildren = mutableMapOf<String, MutableList<MediaMetadataCompat>>()

    /**
     * Whether to allow clients which are unknown (not on the allowed list) to use search on this
     * [BrowseTree].
     */
    //모든 클라이언트 검색 가능
    val searchableByUnknownCaller = true

    /**
     * In this example, there's a single root node (identified by the constant
     * [UAMP_BROWSABLE_ROOT]). The root's children are each album included in the
     * [MusicSource], and the children of each album are the songs on that album.
     * (See [BrowseTree.buildAlbumRoot] for more details.)
     *
     * TODO: Expand to allow more browsing types.
     */

    val situationList = listOf(
        Situation(DOROROK_DAILY, "일상", "daily", R.drawable.musicmode_daily),
        Situation(DOROROK_GO_WORK, "출근","toWork", R.drawable.musicmode_go_to_work),
        Situation(DOROROK_OUT_WORK, "퇴근", "leaveWork",R.drawable.musicmode_get_off_work),
        Situation(DOROROK_TRAVEL, "여행", "travel",R.drawable.musicmode_travel),
        Situation(DOROROK_DRIVE, "드라이브", "drive",R.drawable.musicmode_drive),
        Situation(DOROROK_PICK, "도로록 Pick!", "dororok",R.drawable.musicmode_dororok_pick),
        Situation(DOROROK_DATE, "데이트", "withLover",R.drawable.musicmode_date),
        Situation(DOROROK_FRIENDS,"친구들과","withFriends",R.drawable.musicmode_friends),
        )

    private val situationLists = SituationLists()

    //저장된 음악
//    val savedMusicList = listOf(
//        SavedMusic(R.string.dance_title.toString(), R.string.dance_singer.toString(), R.drawable.genre_dance),
//        SavedMusic(R.string.balad_title.toString(), R.string.balad_singer.toString(), R.drawable.genre_dance),
//        SavedMusic(R.string.indi_title.toString(), R.string.indi_singer.toString(), R.drawable.genre_dance),
//        SavedMusic(R.string.trot_title.toString(), R.string.trot_singer.toString(), R.drawable.genre_dance),
//        SavedMusic(R.string.ost_title.toString(), R.string.ost_singer.toString(), R.drawable.genre_dance),
//        SavedMusic(R.string.pop_title.toString(), R.string.pop_singer.toString(), R.drawable.genre_dance),
//        SavedMusic(R.string.band_title.toString(), R.string.band_singer.toString(), R.drawable.genre_dance),
//        SavedMusic(R.string.hiphop_title.toString(), R.string.hiphop_singer.toString(), R.drawable.genre_dance),
//    )

    init {
        val rootList = mediaIdToChildren[UAMP_BROWSABLE_ROOT] ?: mutableListOf()

        val recommendedMetadata = MediaMetadataCompat.Builder().apply {
            id = UAMP_RECOMMENDED_ROOT
            //title = context.getString(R.string.recommended_title)
            albumArtUri = RESOURCE_ROOT_URI +
                    context.resources.getResourceEntryName(R.drawable.ic_recommended)
            flag = MediaBrowserCompat.MediaItem.FLAG_BROWSABLE
        }.build()

        val recentMetaData = MediaMetadataCompat.Builder().apply {
            id = UAMP_RECENT_ROOT
            //title = context.getString(R.string.recent_title)
            albumArtUri = RESOURCE_ROOT_URI +
                    context.resources.getResourceEntryName(R.drawable.ic_recents)
            flag = MediaBrowserCompat.MediaItem.FLAG_BROWSABLE
        }.build()

        val myMetaData = MediaMetadataCompat.Builder().apply {
            id = UAMP_MY_ROOT
            //title = context.getString(R.string.my_title)
            albumArtUri = RESOURCE_ROOT_URI +
                    context.resources.getResourceEntryName(R.drawable.ic_my)
            flag = MediaBrowserCompat.MediaItem.FLAG_BROWSABLE
        }.build()

        val moreMetaData = MediaMetadataCompat.Builder().apply {
            id = UAMP_MORE_ROOT
            //title = context.getString(R.string.my_title)
            albumArtUri = RESOURCE_ROOT_URI +
                    context.resources.getResourceEntryName(R.drawable.ic_more)
            flag = MediaBrowserCompat.MediaItem.FLAG_BROWSABLE
        }.build()

        rootList += recommendedMetadata
        rootList += recentMetaData
        rootList += myMetaData
        rootList += moreMetaData
        mediaIdToChildren[UAMP_BROWSABLE_ROOT] = rootList

        // Convert situationList to a list of MediaMetadataCompat
        val situationMetadataList = situationList.map { situation ->
            convertToMediaMetadataCompat(situation)
        }
        Log.d("browseTree","init - ${situationMetadataList}")

// Update mediaIdToChildren with the converted list
        mediaIdToChildren[UAMP_RECOMMENDED_ROOT] = situationMetadataList.toMutableList()

        // MusicList 객체를 생성
        val musicList = MusicList()

// 모든 MusicList 항목을 순회하면서 'My' 카테고리에 추가
        val allMusicItems = listOf(
            musicList.daily,
            musicList.dororok,
            musicList.drive,
            musicList.leaveWork,
            musicList.toWork,
            musicList.travel,
            musicList.withFriends,
            musicList.withLover
        ).flatten() // flatten을 사용하여 리스트들을 하나의 리스트로 병합

        allMusicItems.forEach { mediaItem ->
            // 'My' 카테고리에 추가
            val myItems = mediaIdToChildren[UAMP_MY_ROOT] ?: mutableListOf()
            myItems += mediaItem
            mediaIdToChildren[UAMP_MY_ROOT] = myItems
            Log.d("BrowseTree", "Added item to UAMP_MY_ROOT: $mediaItem")

            // If this was recently played, add it to the recent root.
            if (mediaItem.id == recentMediaId) {
                mediaIdToChildren[UAMP_RECENT_ROOT] = mutableListOf(mediaItem)
                Log.d("BrowseTree", "Added item to UAMP_RECENT_ROOT: $mediaItem")
            }
        }

        Log.d("BrowseTree", "Root List Items: $rootList")
    }

    /**
     * Provide access to the list of children with the `get` operator.
     * i.e.: `browseTree\[UAMP_BROWSABLE_ROOT\]`
     */
    operator fun get(mediaId: String) = mediaIdToChildren[mediaId]

    /**
     * Builds a node, under the root, that represents an album, given
     * a [MediaMetadataCompat] object that's one of the songs on that album,
     * marking the item as [MediaItem.FLAG_BROWSABLE], since it will have child
     * node(s) AKA at least 1 song.
     */

    private fun convertToMediaMetadataCompat(situation: Situation): MediaMetadataCompat {
        // Convert resource ID to Bitmap
        val bitmap = try {
            BitmapFactory.decodeResource(context.resources, situation.image)
        } catch (e: Exception) {
            Log.e("MediaMetadata", "Error decoding resource to Bitmap", e)
            null
        }

        // Convert Bitmap to Uri
        val bitmapUri = bitmap?.let { bitmapToUri(context, it) }

        return MediaMetadataCompat.Builder()
            .putString(MediaMetadataCompat.METADATA_KEY_TITLE, situation.title)
            .putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID, situation.id.toString())
            .apply {
                // Only add Bitmap if it is not null
                if (bitmap != null) {
                    putBitmap(MediaMetadataCompat.METADATA_KEY_ALBUM_ART, bitmap)
                }
            }
            .apply {
                // Only add URI if it is not null
                if (bitmapUri != null) {
                    putString(MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI, bitmapUri.toString())
                }
            }
            .build()
    }

    fun bitmapToUri(context: Context, bitmap: Bitmap): Uri? {
        val filename = "${UUID.randomUUID()}.png"
        val file = File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), filename)

        try {
            FileOutputStream(file).use { out ->
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
            }
            return Uri.fromFile(file)
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
    }

    /*private fun buildAlbumRoot(mediaItem: MediaMetadataCompat): MutableList<MediaMetadataCompat> {
        // MusicList 인스턴스를 생성합니다.
        val musicList = MusicList()

        // 특정 앨범에 해당하는 리스트를 MusicList에서 가져옵니다.
        val albumTracks = when (mediaItem.album) {
            "daily" -> musicList.daily
            "dororok" -> musicList.dororok
            "drive" -> musicList.drive
            "leaveWork" -> musicList.leaveWork
            "toWork" -> musicList.toWork
            "travel" -> musicList.travel
            "withFriends" -> musicList.withFriends
            "withLover" -> musicList.withLover
            else -> emptyList()
        }

        // 앨범에 해당하는 메타데이터를 생성합니다.
        val albumMetadata = MediaMetadataCompat.Builder().apply {
            id = mediaItem.album.urlEncoded
            title = mediaItem.album
            artist = mediaItem.artist
            albumArt = mediaItem.albumArt
            albumArtUri = mediaItem.albumArtUri.toString()
            flag = MediaItem.FLAG_BROWSABLE
        }.build()

        // 앨범을 'Albums' 카테고리에 추가합니다.
        val rootList = mediaIdToChildren[UAMP_MY_ROOT] ?: mutableListOf()
        rootList += albumMetadata
        mediaIdToChildren[UAMP_MY_ROOT] = rootList

        // 앨범의 트랙 리스트를 반환할 리스트에 추가합니다.
        val trackList = mutableListOf<MediaMetadataCompat>().also {
            it.addAll(albumTracks)
            mediaIdToChildren[albumMetadata.id!!] = it
        }

        // 트랙 리스트를 반환합니다.
        return trackList
    }*/

    fun getRecentItems(): List<MediaMetadataCompat> {
        return mediaIdToChildren[UAMP_RECENT_ROOT] ?: emptyList()
    }

    @Synchronized
    fun updateRecentItems(recentItems: List<MediaMetadataCompat>) {
        mediaIdToChildren[UAMP_RECENT_ROOT] = recentItems.toMutableList()
    }

    operator fun set(uampMyRoot: String, value: List<Any>) {

    }
}

// 상황에 대한 리스트 매핑 구조
class SituationLists {
    private val musicLists = mapOf(
        "일상" to MusicList().daily,
        "출근" to MusicList().toWork,
        "퇴근" to MusicList().leaveWork,
        "여행" to MusicList().travel,
        "드라이브" to MusicList().drive,
        "도로록 Pick!" to MusicList().dororok,
        "데이트" to MusicList().withLover,
        "친구들과" to MusicList().withFriends
    )

    fun getListForSituation(title: String): List<MediaMetadataCompat>? {
        return musicLists[title]
    }
}

const val UAMP_BROWSABLE_ROOT = "/"
const val UAMP_EMPTY_ROOT = "@empty@"
const val UAMP_RECOMMENDED_ROOT = "__RECOMMENDED__"
const val UAMP_RECENT_ROOT = "__RECENT__"
const val UAMP_MY_ROOT = "__MY__"
const val UAMP_MORE_ROOT = "__MORE__"

const val DOROROK_DAILY="daily"
const val DOROROK_GO_WORK="toWork"
const val DOROROK_OUT_WORK="leaveWork"
const val DOROROK_TRAVEL="travel"
const val DOROROK_DRIVE="drive"
const val DOROROK_PICK="dororok"
const val DOROROK_DATE="withLover"
const val DOROROK_FRIENDS="withFriends"

const val MEDIA_SEARCH_SUPPORTED = "android.media.browse.SEARCH_SUPPORTED"

const val RESOURCE_ROOT_URI = "android.resource://com.example.android.uamp.next/drawable/"
