package com.kangjj.kotlin.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        useSet();

        useMap();

        ergodicMap();

//        useSingleFunction();
    }

    fun useSet() {
        var set = setOf("Java","Kotlin","Go");//创建不可变集合，返回值是set
        Log.v(TAG,"${ set.all({it.length>4 })}");//判断是否所有元素都大于4
        Log.v(TAG,"${ set.any( {it.length>4})}")        //判断是否任意一个元素大于4
        val map = set.associateBy({"《疯狂"+it+"讲义》"})//以Lambda表达式，表达式的值为key，集合元素为value，组成Map集合
        Log.v(TAG,map.toString());              //{《疯狂Java讲义》=Java, 《疯狂Kotlin讲义》=Kotlin, 《疯狂Go讲义》=Go}
        Log.v(TAG,"${"Java" in set}")
        Log.v(TAG,"${"Go" !in set}")
        //dropedList删除前面两个，剩下“Go",注意 set没变
        val dropedList = set.drop(2);
        Log.v(TAG,dropedList.toString());
        val filteredList = set.filter({ "li" in it })//对集合
        Log.v(TAG,filteredList.toString());
        val find1 = set.find({ "lin" in it })
        val find2 = set.find({ "222" in it })
        Log.v(TAG,find1.toString()+"  "+find2.toString());//Kotlin  null
        val foldedList1 = set.fold("", { acc, e -> acc + e })//JavaKotlinGo
        Log.v(TAG,foldedList1.toString())

        val foldedList2 = set.fold("|", { acc, e -> acc + e })//|JavaKotlinGo
        Log.v(TAG,foldedList2.toString())

        val mappedList = set.map({ "《疯狂" + it + "讲义》" })
        Log.v(TAG,mappedList.toString())//[《疯狂Java讲义》, 《疯狂Kotlin讲义》, 《疯狂Go讲义》]
        Log.v(TAG,"${mappedList.javaClass}")//ArrayList
        Log.v(TAG,set.max());           //Kotlin
        Log.v(TAG,set.min());           //Go
        Log.v(TAG,"${set.reversed().toString()}")//反转集合顺序 [Go, Kotlin, Java]
        var bSet = setOf("Lua","Erlang","Kotlin")
        Log.v(TAG,(set intersect bSet).toString())//计算两个集合的交集[Kotlin]
        Log.v(TAG,(set union bSet).toString())//计算两个集合的并集[Java, Kotlin, Go, Lua, Erlang]
        Log.v(TAG,(set + bSet).toString())//集合相加，相当于并集[Java, Kotlin, Go, Lua, Erlang]
    }

    fun useMap(){
        val map = mapOf("Java" to 86, "Kotlin" to 76, "Go" to 92)
        Log.v(TAG,(map.all({ it.key.length >4 && it.value>80})).toString())
        Log.v(TAG,(map.any({ it.key.length>4 && it.value>80})).toString())
        Log.v(TAG, ("Java" in map).toString())
        Log.v(TAG, ("Go" !in map).toString())
        val filteredMap = map.filter({ "li" in it.key })
        Log.v(TAG,filteredMap.toString())
        val mappedList = map.map({ "《疯狂${it.key}讲义》价格为：${it.value}" })
        Log.v(TAG,mappedList.toString())
        Log.v(TAG,mappedList.javaClass.toString())//java.util.ArrayList
        Log.v(TAG,map.maxBy({it.key}).toString())
        Log.v(TAG,map.minBy({it.key}).toString())
        val bMap = mapOf("Lua" to 67, "Erlang" to 92, "Kotlin" to 88)
        Log.v(TAG, (map+bMap).toString())//{Java=86, Kotlin=88, Go=92, Lua=67, Erlang=92} 注意这里的key  "Kotlin"的value不同，使用后者的
        Log.v(TAG, (map-bMap).toString())//{Java=86, Kotlin=76, Go=92}          注意这里的key  "Kotlin"的value不同，使用前者的
    }

    private fun ergodicMap() {
        Log.v(TAG,"*********************************************************");
        val map = mapOf("Java" to 86, "Kotlin" to 76, "Go" to 92)
        for (en in map.entries) {//遍历Map的key-value对，entris元素返回key-value对组成的Set
            Log.v(TAG,"${en.key} -> ${en.value}");
        }
        Log.v(TAG,"*********************************************************");
        for (key in map.keys) { //先遍历Map的key，再通过key获取value
            Log.v(TAG,"${key} -> ${map[key]}")
        }
        Log.v(TAG,"*********************************************************");
        for((key,value) in map){//直接用for-in循环遍历Map
            Log.v(TAG,"${key} -> ${value}")
        }
        Log.v(TAG,"*********************************************************");
        //用Lambda表达式遍历Map
       map.forEach({ Log.v(TAG,"${it.key} -> ${it.value}")})

    }
    //使用单表达式函数
//    fun useSingleFunction(){
//        Log.v(TAG,"${area(2.0,5.0)}")
//    }
//
//    fun area(x:Double,y:Double):Double = x*y
}
