package at.htl.htlleondinginfoapp

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://www.htl-leonding.at/wp-json/wp/v2/";
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build();
private val retrofit = Retrofit.Builder().
    addConverterFactory(MoshiConverterFactory.create(moshi)).
    baseUrl(BASE_URL).build();

interface WordpressApiService
{

    // https://htl-leonding.ac.at/wordpress/?rest_route=/wp/v2/posts
    // ?after=2021-02-01T00:00:00
    @GET("posts")
    suspend fun getPosts(@Query("after") after: String): List<Post>;

}

object WordpressApi
{
    val retrofitService: WordpressApiService by lazy {
        retrofit.create(WordpressApiService::class.java);
    }
}