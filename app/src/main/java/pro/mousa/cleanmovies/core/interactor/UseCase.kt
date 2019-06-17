package pro.mousa.cleanmovies.core.interactor

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import pro.mousa.cleanmovies.core.exception.Failure
import pro.mousa.cleanmovies.core.functional.Either

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
        val job = GlobalScope.async { run(params) }
        GlobalScope.launch(/*How to set UI thread?*/) { onResult(job.await()) }
    }

    class None
}
