# tika-server

It serves tika applied on an URL for webhooks (Celery).

## Usage

server:

    lein run

client (HTTP GET):

    http://IP_SERVICE:9998/?doc=URLENCODED_URL_FOR_TIKA_TO_PARSE

do not forgot the `?`


for instance test:

    lein run
    curl -X GET http://127.0.0.1:9998/?doc=https%3A%2F%2Fgithub.com%2Fring-clojure%2Fring%2Fwiki%2FGetting-Started

## License

Copyright (C) 2012 Gabriel Synnaeve / Cloverfeed

Distributed under the Eclipse Public License, the same as Clojure.
