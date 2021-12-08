package my.cache_issue_repro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import my.lib.OuterClass
import toothpick.Toothpick

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toothpick.openScope("TestScope").getInstance(OuterClass.NestedClass::class.java).myMethod()
    }
}