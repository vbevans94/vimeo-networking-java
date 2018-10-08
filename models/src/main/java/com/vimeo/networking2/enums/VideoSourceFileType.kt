package com.vimeo.networking2.enums

import com.vimeo.networking2.VideoLog
import java.util.*

data class VideoSourceFileType(

    /**
     * The time in ISO 8601 format when the video file was created.
     */
    val createdTime: Date? = null,

    /**
     * The time in ISO 8601 format when the video file expires.
     */
    val expires: Date? = null,

    /**
     * The FPS of the video.
     */
    val fps: Int? = null,

    /**
     * The height of the video in pixels.
     */
    val height: Int? = null,

    /**
     * The direct link to this video file.
     */
    val link: String? = null,

    /**
     * Video log.
     */
    val log: VideoLog? = null,

    /**
     * The MD5 hash of the video file.
     */
    val md5: String? = null,

    /**
     * The video quality (as determined by height and width).
     */
    val quality: VideoQualityType? = null,

    /**
     * The file size of the video.
     */
    val siz: Int? = null,

    /**
     * The source link for the video file.
     */
    val sourceLink: String? = null,

    /**
     * The type of the video file.
     */
    val type: VideoSourceType? = null,

    /**
     * The width of the video in pixels.
     */
    val width: Int?

)
