//
//  SuspendToCombine.swift
//  iosApp
//
//  Created by 양윤재 on 2023/03/03.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import Combine
import shared

class SharedError: LocalizedError {
    let throwable: KotlinThrowable
    init(_ throwable: KotlinThrowable) {
        self.throwable = throwable
    }
    var errorDescription: String? {
        get { throwable.message }
    }
}

func createPublisher<T>(
    wrapper: KoruSuspendWrapper<T>
) -> AnyPublisher<T?, Error> {
    var job: Kotlinx_coroutines_coreJob? = nil
    return Deferred {
        Future<T?, Error> { promise in
            job = wrapper.subscribe(
                onSuccess: { item in promise(.success(item)) },
                onThrow: { error in promise(.failure(SharedError(error))) }
            )
        }.handleEvents(receiveCancel: { job?.cancel(cause: nil) })
    }.eraseToAnyPublisher()
}
