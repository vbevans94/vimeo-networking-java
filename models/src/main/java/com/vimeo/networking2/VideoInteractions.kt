package com.vimeo.networking2

data class VideoInteractions(

    /**
     * The Buy interaction for a On Demand video.
     */
    val buy: BuyInteraction? = null,

    /**
     * When a video is referenced by a channel URI, if the user is a moderator of the
     * channel, include information about removing the video from the channel.
     */
    val channel: Interaction? = null,

    /**
     * Information about whether the authenticated user has liked this video.
     */
    val like: LikeInteraction? = null,

    /**
     * The Rent interaction for an On Demand video.
     */
    val rent: RentInteraction? = null,

    /**
     * Information about where and how to report a video.
     */
    val report: Interaction? = null,

    /**
     * Subscription information for an On Demand video.
     */
    val subscribe: SubscribeInteraction? = null,

    /**
     * Information about removing this video from the user's list of watched videos.
     */
    val watched: WatchedInteraction? = null,

    /**
     * Information about whether this video appears on the authenticated user's Watch Later list.
     */
    val watchlater: WatchLaterInteraction? = null
)
