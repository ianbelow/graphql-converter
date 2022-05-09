package com.ianbialou.graphqlconverter

import android.content.Context
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

const val MEDIA_TYPE = "application/json; charset=UTF-8"

class GraphqlConverter(context: Context) : Converter.Factory() {

    private val processor = GraphqlProcessor(context)

    override fun requestBodyConverter(
        type: Type,
        parameterAnnotations: Array<out Annotation>,
        methodAnnotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<GraphqlQuery, RequestBody>? = when (methodAnnotations.any { it is GraphQL }) {
        true -> GraphRequestConverter(methodAnnotations)
        else -> null
    }

    private inner class GraphRequestConverter(val methodAnnotations: Array<out Annotation>) :
        Converter<GraphqlQuery, RequestBody> {

        override fun convert(value: GraphqlQuery): RequestBody {
            value.query = processor.getFileContent(methodAnnotations)
            return RequestBody.create(MediaType.parse(MEDIA_TYPE), Gson().toJson(value))
        }
    }
}
