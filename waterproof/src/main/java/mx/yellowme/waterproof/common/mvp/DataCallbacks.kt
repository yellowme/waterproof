package mx.yellowme.waterproof.common.mvp

interface DataCallbacks {

    interface BaseCallback {

        fun onNetwork(error: String)

        fun onServer(error: String)

        fun onAuthentication(error: String)
    }

    interface SimpleCallback : BaseCallback {
        fun onSuccess()
    }

    interface ListAllCallback<in Item> : BaseCallback {
        fun onLoad(items: List<Item>)
    }

    interface SingleItemCallback<in Item> : BaseCallback {
        fun onLoad(item: Item)
    }

}