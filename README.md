# Spring-XML-processor-demo
This is a sample Spring REST project that consumes XML request body and validates the body.

## Sample Request

    curl --location --request POST 'http://localhost:8080/xml/insert' \
    --header 'Content-Type: application/xml' \
    --data-raw '<person>
        <name>Petabyte</name>
        <nid>1234567890</nid>
        <email>em@i.l</email>
    </person>'
