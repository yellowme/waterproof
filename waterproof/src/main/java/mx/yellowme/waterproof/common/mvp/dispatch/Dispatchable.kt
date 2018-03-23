package mx.yellowme.waterproof.common.mvp.dispatch

/**
 * Provides a helper definition to fetch data from a data source and
 * take action while the application is dispatching the userFrom to a specific view
 * depending on his application state.

 * @param <Data> to fetch from data source.
</Data> */
interface Dispatchable<Data> {

    fun begin(listener: DispatchListener<Data>)

    interface DispatchListener<Data> {
        fun onFetchData(data: Data)
        fun onError(error: String)
    }

}