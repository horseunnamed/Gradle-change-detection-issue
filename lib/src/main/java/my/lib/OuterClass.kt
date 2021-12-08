package my.lib

import android.util.Log
import toothpick.InjectConstructor


@InjectConstructor
class OuterClass {

    @InjectConstructor
    class NestedClass {
        fun myMethod() {
            Log.d("Repro status", "No repro :(")
        }
    }

}

