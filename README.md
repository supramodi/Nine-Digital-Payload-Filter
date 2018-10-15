# Nine-Digital-Payload-Filter
Json based web service, which will accept Json payload with array of shows and filter and produce response.

Json Request should contains array of show objects.

Json Response contains show objects which satisfy DRM enabled (drm: true) and at least one episode (episodeCount > 0).

For all success secnarios, status code 200 is returned with response data.
For invalid Json request/else, bad request details message is returned with status 400.
Resource path is root/payload and payload is the main resource.
POST method is accepting and precess the Jason payloads.
GET method is used as health end point.

Source code contains, java resources and pom.xml.
Maven is used as the build tool.
