package com.example.characterapp.data.remote.network.wire


import com.google.gson.annotations.SerializedName

data class MetaModel(
    @SerializedName("attribution")
    val attribution: AnyModel? = AnyModel(),
    @SerializedName("blockgroup")
    val blockgroup: AnyModel? = AnyModel(),
    @SerializedName("created_date")
    val createdDate: AnyModel? = AnyModel(),
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("designer")
    val designer: AnyModel? = AnyModel(),
    @SerializedName("dev_date")
    val devDate: AnyModel? = AnyModel(),
    @SerializedName("dev_milestone")
    val devMilestone: String? = "",
    @SerializedName("developer")
    val developer: List<DeveloperModel?>? = listOf(),
    @SerializedName("example_query")
    val exampleQuery: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("is_stackexchange")
    val isStackexchange: AnyModel? = AnyModel(),
    @SerializedName("js_callback_name")
    val jsCallbackName: String? = "",
    @SerializedName("live_date")
    val liveDate: AnyModel? = AnyModel(),
    @SerializedName("maintainer")
    val maintainer: MaintainerModel? = MaintainerModel(),
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("perl_module")
    val perlModule: String? = "",
    @SerializedName("producer")
    val producer: AnyModel? = AnyModel(),
    @SerializedName("production_state")
    val productionState: String? = "",
    @SerializedName("repo")
    val repo: String? = "",
    @SerializedName("signal_from")
    val signalFrom: String? = "",
    @SerializedName("src_domain")
    val srcDomain: String? = "",
    @SerializedName("src_id")
    val srcId: Int? = 0,
    @SerializedName("src_name")
    val srcName: String? = "",
    @SerializedName("src_options")
    val srcOptions: SrcOptionsModel? = SrcOptionsModel(),
    @SerializedName("src_url")
    val srcUrl: AnyModel? = AnyModel(),
    @SerializedName("status")
    val status: String? = "",
    @SerializedName("tab")
    val tab: String? = "",
    @SerializedName("topic")
    val topic: List<String?>? = listOf(),
    @SerializedName("unsafe")
    val unsafe: Int? = 0
)