# producer
Play project for Spring Cloud Contract

#### Consumer Contract Tests
Groovy consumer contract tests reside in src/test/resources/contracts

**Example Contract Test**

    Contract.make {
        description("When a POST request with a valid User is made, the created user id is returned")
        request {
            method 'POST'
            url '/users'
            body(
                    firstName: "Ian",
                    lastName: "Jones"
            )
            headers {
                contentType(applicationJson())
            }
        }
        response {
            status 201
            body(
                    id: 12
            )
            headers {
                contentType(applicationJson())
            }
        }
    }
#### Project Setup

You also have to define a test setup class for each set of tests.  These are standard java test classes that tell the system how to respond when certain requests are made.  These are found in the src/test/java/com/example/contract/controller directory.

You then tie these base test classes to the groovy test cases in the build.gradle as below

    contracts {
        baseClassMappings {
            baseClassMapping(".*userService.*", "com.example.contract.controller.UserServiceBase")
            baseClassMapping(".*accountService.*", "com.example.contract.controller.AccountServiceBase")
        }
    }



#### Generate and run the Tests

To generate and run the tests, type:
  ./gradlew build
  
  This will generate standard JUnit tests in the build directories - you can debug these in your IDE if any problems.


