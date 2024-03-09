# This project attempts to implement a `Quiz` monolithic application and then convert it to a microservice application.

## Monolothic structure
        
        └───src
            └───main
                ├───java                         
                │   └───com
                │       └───quiz
                │           └───quizapp
                │               ├───controller
                │               ├───dto
                │               ├───enums
                │               ├───mapper
                │               ├───model
                │               ├───repository
                │               └───service
                │                   └───impl
                └───resources
                    ├───static
                    └───templates


## Microservice structure:

        ├───api-gateway
        │   └───src
        │       └───main
        │           ├───java
        │           │   └───com
        │           │       └───example
        │           │           └───apigateway
        │           └───resources
        ├───question-service
        │   └───src
        │       └───main
        │           ├───java
        │           │   └───com
        │           │       └───microservice
        │           │           └───questionservice
        │           │               ├───controller
        │           │               ├───dto
        │           │               ├───enums
        │           │               ├───mapper
        │           │               ├───model
        │           │               ├───repository
        │           │               └───service
        │           │                   └───impl
        │           └───resources
        │               ├───static
        │               └───templates
        ├───quiz-service
        │   └───src
        │       └───main
        │           ├───java
        │           │   └───com
        │           │       └───microservice
        │           │           └───quizservice
        │           │               ├───config
        │           │               ├───controller
        │           │               ├───dto
        │           │               ├───enums
        │           │               ├───mapper
        │           │               ├───model
        │           │               ├───repository
        │           │               └───service
        │           │                   └───impl
        │           └───resources
        │               ├───static
        │               └───templates
        └───registry-service
            └───src
                └───main
                    ├───java
                    │   └───com
                    │       └───microservice
                    └───resources
                        ├───static
                        └───templates
        

