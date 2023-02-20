package com.example.flixster2project4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import kotlinx.serialization.json.Json
import okhttp3.Headers
import org.json.JSONException



fun createJson() = Json {
    isLenient = true
    ignoreUnknownKeys = true
    useAlternativeNames = false
}

private const val TAG = "MainActivity/"
private val PERSON_SEARCH_URL = "https://api.themoviedb.org/3/person/popular?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed"
class MainActivity : AppCompatActivity() {
    private lateinit var peoplesRecyclerView: RecyclerView

    private val people = mutableListOf<TopPeople>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        peoplesRecyclerView = findViewById(R.id.rv_topPeople)


        peoplesRecyclerView.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            peoplesRecyclerView.addItemDecoration(dividerItemDecoration)
        }
        val peopleAdapter = TopPeopleAdapter(this, people)
        peoplesRecyclerView.adapter = peopleAdapter

        val client = AsyncHttpClient()

        client.get(PERSON_SEARCH_URL, object : JsonHttpResponseHandler() {

            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.i(TAG, "Successfully fetched People: $json")
                try {
                       Log.v(TAG, "Success!!!!!!!")

                    val parsedJson = createJson().decodeFromString(
                        SearchResponse.serializer(),
                        json.jsonObject.toString()
                    )
                    parsedJson.results?.let { list ->
                        people.addAll(list)
                        peopleAdapter.notifyDataSetChanged()
                    }

                } catch (e: JSONException) {
                    Log.e(TAG, "Exception: $e")
                }
            }
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Log.e(TAG, "Failed to fetch pesons: $statusCode")
                //Log.e(TAG, response.toString())
            }

        })

    }

}






