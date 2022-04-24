/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bugsnax Server API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package hu.bme.aut.bugsnaxapp.client.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property bugsnax
 */
@JsonClass(generateAdapter = true)
data class InlineResponse200(
    @Json(name = "bugsnax") @field:Json(name = "bugsnax") var bugsnax: List<Bugsnak>? = null
)