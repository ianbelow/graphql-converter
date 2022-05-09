package com.ianbialou.graphqlconverter

import com.google.gson.annotations.SerializedName

data class GraphqlQuery(
    @SerializedName("query") var query: String = "",
    @SerializedName("variables") var variables: Map<String, Any> = emptyMap()
)