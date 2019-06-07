# exercise-api

curl --user alejandroc_89@hotmail.com:password http://localhost:8080/

curl --user alejandroc_89@hotmail.com:password http://localhost:8080/notes

curl --user alejandroc_89@hotmail.com:password -d "{\"title\":\"titulo\",\"note\":\"testNote\"}" -H "Content-Type: application/json" http://localhost:8080/notes

curl --user alejandroc_89@hotmail.com:password -X DELETE http://localhost:8080/notes/1
