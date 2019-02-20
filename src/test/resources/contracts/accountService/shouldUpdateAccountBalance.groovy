package contracts.accountService

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("When a PUT request with a valid User id, account id and amount is made, the updated balance is returned")
    request {
        method 'PUT'
        url '/accounts/12/10'
        body(
                amount: 1250
        )
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body(
                balance: 1500,
                ownerId: 12,
                id: 10
        )
        headers {
            contentType(applicationJson())
        }
    }
}