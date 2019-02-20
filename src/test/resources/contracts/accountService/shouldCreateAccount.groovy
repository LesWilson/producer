package contracts.accountService

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("When a POST request with a valid User id and account name, the created account id and balance is returned")
    request {
        method 'POST'
        url '/accounts/12'
        body(
                accountName: "John's Current Account",
                balance: 250
        )
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 201
        body(
                id: 10,
                balance: 250,
                ownerId: 12,
                accountName: "John's Current Account"
        )
        headers {
            contentType(applicationJson())
        }
    }
}
