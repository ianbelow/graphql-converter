package com.ianbialou.graphqlconverter

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class GraphQL(val fileName: String)