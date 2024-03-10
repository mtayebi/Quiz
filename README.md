# This project aims to develop a Quiz application as a monolithic application and then transform it into a microservice application.

## Thechnologies
- Java (lombock, mapstruct, ...)
- Spring (MVC, JPA, boot, ...)
- Postgresql
- Eureka Client/Server (registry service)
- Swagger
- Other Minimmum Requierments

## Monolothic structure:
        
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
        
## Demo:

### Demo of project and related service paths in swagger 

## Registry Service

![eureka-registered-services](https://github.com/mtayebi/Quiz/assets/96329796/db417188-f437-4916-a58e-d77fadb26b72)

## Question Service

![question-service](https://github.com/mtayebi/Quiz/assets/96329796/5e28e9ec-c67a-415a-98bc-2305dff2e297)

## Quiz Service

![quiz-service](https://github.com/mtayebi/Quiz/assets/96329796/6b4a4a88-7c9e-42c9-8a46-ced72eedd60c)

## Api Gateway

![user-api-gateway](https://github.com/mtayebi/Quiz/assets/96329796/0570e266-1f78-42e2-a8e6-0f3a6fb2c4ff)
