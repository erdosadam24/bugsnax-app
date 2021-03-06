/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bugsnax Server API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package hu.bme.aut.bugsnaxapp.client.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property grumpuses
 */
@JsonClass(generateAdapter = true)
data class InlineResponse2002(
    @Json(name = "grumpuses") @field:Json(name = "grumpuses") var grumpuses: List<Grumpus>? = null
)
