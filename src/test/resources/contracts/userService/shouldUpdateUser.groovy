package contracts.userservice

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("When a PUT request with a valid User and id is made, the updated user id is returned")
    request {
        method 'PUT'
        url '/users/12'
        body(
                firstName: "John",
                lastName: "Smith"
        )
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body(
                id: 12,
                firstName: "John",
                lastName: "Smith"
        )
        headers {
            contentType(applicationJson())
        }
    }
}