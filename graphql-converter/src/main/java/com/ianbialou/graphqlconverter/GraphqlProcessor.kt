package com.ianbialou.graphqlconverter

import android.content.Context
import android.util.Log
import java.util.*

private const val qualifier = ".graphql"
private const val rootFolder = "graphql"
private const val TAG = "GraphqlProcessor"

class GraphqlProcessor(context: Context) {

    private val filesWithContents = HashMap<String, String>()

    init {
        findAllFiles(rootFolder, context)
    }

    fun getFileContent(annotations: Array<out Annotation>): String =
        (annotations.find { it is GraphQL } as GraphQL).let { annotation ->
            val fileName = "${annotation.fileName}$qualifier"
            filesWithContents[fileName] ?: "".also {
                Log.e(TAG, "Cannot find file ${annotation.fileName}")
            }
        }

    private fun findAllFiles(parentPath: String, context: Context) {
        val paths = context.assets
        if (paths.list(parentPath)!!.isNotEmpty()) {
            paths.list(parentPath)!!.forEach { path ->
                val absolute = "$parentPath/$path"
                when (path.endsWith(qualifier)) {
                    true -> filesWithContents[path] =
                        paths.open(absolute).bufferedReader().use { it.readText() }
                    false -> findAllFiles(absolute, context)
                }
            }
        }
    }

}