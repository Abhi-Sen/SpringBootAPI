1. How to run?
    Run this as SpringrestApplication
    Here is the sample reference: https://www.jetbrains.com/help/idea/spring-boot.html

2. How to test?

step1: POST
curl --location 'localhost:8080/load' \
--header 'Content-Type: application/json' \
--data '{
    "loadingPoint": "alwar",
    "unloadingPoint": "jaipur",
    "productType": "chemicals",
    "truckType": "canter",
    "noOfTrucks": 1,
    "weight": 110.0,
    "comment": "testing8",
    "shipperId": "128",
    "date": "01-01-2004"
}'

Step2 : GET the loadId using below curl
curl --location --request GET 'localhost:8080/load?shipperId=128' \
--header 'Content-Type: application/json' 

Step3: from the step2 copy the loadId and use it to get load
curl --location --request GET 'localhost:8080/load/{loadId}' \
--header 'Content-Type: application/json' 


Step4: If you want to update use the below curl and set your desirable fields which you want to update
curl --location --request PUT 'localhost:8080/load/{loadId}' \
--header 'Content-Type: application/json' \
--data '{
    "loadingPoint": "alwar",
    "unloadingPoint": "jaipur",
    "productType": "chemicals",
    "truckType": "canter",
    "noOfTrucks": 1,
    "weight": 110.0,
    "comment": "testing8",
    "shipperId": "128",
    "date": "01-01-2004"
}'

Step5 : Delete
curl --location --request DELETE 'localhost:8080/load/{loadId}' \
--header 'Content-Type: application/json' 

