
import kotlin.system.measureTimeMillis

fun main(){
    val lista= intArrayOf(20,18,24,12,17,21,15)
    burbuja(lista);
}
fun burbuja(listanumeros:IntArray){
    var cantidad=listanumeros.size
    var temporal= -1

    imprimirArrayAscendente(listanumeros, cantidad)
    for(i in (0 until cantidad -1)){
        for(j in (0 until cantidad -1)){
            if(listanumeros[j]>listanumeros[j+1]){
                temporal=listanumeros[j]
                listanumeros[j] =listanumeros[j+1]
                listanumeros[j+1]=temporal
            }
        }
    }
    println()
    imprimirArrayAscendente(listanumeros, cantidad)
}
fun imprimirArrayAscendente (listanumeros: IntArray,cantidad: Int){
    for(i in (0 until cantidad)){
        print("${listanumeros[i]} ")
    }
}
fun imprimirArrayDescendente(listanumeros: IntArray,cantidad: Int){
    for(i in (cantidad -1 downTo 0)){
        print("${listanumeros[i]} ")
    }
}
fun imprimirListas(lista: List<Int>) {

    lista.forEach {
        println(it)
    }
}

fun ordenamientoKotlin(lista: List<String>): List<String> {

    return lista.sorted()
}

fun tiempoQuicksort(items: List<String>) {

    var lista: List<String>

    var tiempo = measureTimeMillis {

        lista = quicksort(items)

    }

    println("DEMORO $tiempo MILI SEGUNDOS")

    lista.forEach {
        println(it)
    }
}

fun <T : Comparable<T>> quicksort(items: List<T>): List<T> {
    if (items.count() < 1) return items
    val pivot = items[items.count() / 2]
    val equal = items.filter { it == pivot }
    val less = items.filter { it < pivot }
    val greater = items.filter { it > pivot }
    return quicksort(less) + equal + quicksort(greater)
}


fun tiempoMergeSort(elementos: List<String>) {

    var lista: MutableList<String>

    var tiempo = measureTimeMillis {

        lista = mergesort(elementos.toMutableList())
    }

    println("DEMORO $tiempo MILI SEGUNDOS")

    lista.forEach {
        println("asdasd $it")
    }

}


fun <T : Comparable<T>> mergesort(items: MutableList<T>): MutableList<T> {
    if (items.isEmpty()) {
        return items
    }

    fun merge(left: MutableList<T>, right: MutableList<T>): MutableList<T> {
        var merged: MutableList<T> = arrayListOf<T>()
        while (!left.isEmpty() && !right.isEmpty()) {
            val temp: T
            if (left.first() < right.first()) {
                temp = left.removeAt(0)
            } else {
                temp = right.removeAt(0)
            }
            merged.add(temp)
        }
        if (!left.isEmpty()) merged.addAll(left)
        if (!right.isEmpty()) merged.addAll(right)

        return merged
    }

    val pivot = items.count() / 2

    var left = mergesort(items.subList(0, pivot))
    var right = mergesort(items.subList(pivot, items.count() - 1))

    return merge(left, right)
}

