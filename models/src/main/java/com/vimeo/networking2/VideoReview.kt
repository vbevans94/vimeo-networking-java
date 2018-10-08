package com.vimeo.networking2

data class VideoReview(

    /**
     * Setting to check if the review page is active for this video.
     */
    val active: Boolean? = null,

    /**
     * Link to the Vimeo review page.
     */
    val link: String? = null,

    /**
     * Setting to check if notes are enabled or disabled on the review page.
     * CAPABILITY_VIDEO_REVIEW.
     */
    val notes: Boolean? = null,

    /**
     * Setting to check if the vimeo logo should be displayed on the review page.
     * CAPABILITY_VIDEO_REVIEW.
     */
    val vimeo_logo: Boolean? = null

)
