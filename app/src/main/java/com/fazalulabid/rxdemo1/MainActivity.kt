package com.fazalulabid.rxdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "myApp"
    }

    private val greeting = "Hello from RxJava"
    private lateinit var myObservable: Observable<String>
    private lateinit var myObserver: Observer<String>

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.tvGreeting)
        myObservable = Observable.just(greeting)

        myObserver = object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                Log.i(TAG, "onSubscribe: onSubscribe invoked")
            }

            override fun onError(e: Throwable) {
                Log.i(TAG, "onError: onError invoked")
            }

            override fun onComplete() {
                Log.i(TAG, "onComplete: onComplete invoked")
            }

            override fun onNext(t: String) {
                Log.i(TAG, "onNext: onNext invoked")
                textView.text = t
            }

        }

        myObservable.subscribe(myObserver)
    }
}