package contracts.userservice

import org.springframework.cloud.contract.spec.Contract

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