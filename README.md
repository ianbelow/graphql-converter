# GraphqlConverter

Simple .graphql converter for Retrofit. Adds ability to specify .graphql file with schema for POST request instead of storing query in strings, etc.

    @GraphQL("filename")
    @Headers(NetworkHeaders.HEADER_JSON, NetworkHeaders.HEADER_GRAPHIQL)
    @POST(NetworkUtils.BASE_GQL_URL)
    suspend fun getRegionDetailsById(@Body body: GraphqlQuery): RegionDetailsData


To start using this converter, just provide GraphqlConverter to Retrofit Builder:

    Retrofit.Builder()
            .baseUrl(NetworkUtils.BASE_GQL_URL)
            .addConverterFactory(GraphqlConverter>(context))
            .build

Graphql files should be stored in assets/graphql directory. 

![image](https://user-images.githubusercontent.com/43182055/167597512-c9530347-642f-4304-9977-20de19a5d973.png)


To add variables to query just specify this parameter for GraphqlQuery data class. 

    regionService.getRegionDetailsById(GraphqlQuery(variables = mapOf("id" to id)))
    
### Download

In the root build.gradle add Jitpack repository:

    allprojects {
      repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
      }
    }

And in the module build.gradle add dependency:

    implementation("com.github.ianbelov:graphqlconverter:0.0.1")

[![](https://jitpack.io/v/ianbelow/GraphqlConverter.svg)](https://jitpack.io/#ianbelow/GraphqlConverter)

### License
    MIT License

    Copyright (c) 2022 Ivan Bialou

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
