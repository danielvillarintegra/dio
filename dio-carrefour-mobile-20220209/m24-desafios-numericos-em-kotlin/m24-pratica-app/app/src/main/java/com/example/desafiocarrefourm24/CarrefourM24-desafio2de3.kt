package com.example.desafiocarrefourm24

import java.util.Scanner

fun main() {
    val scan = Scanner(System.`in`)
    val n: Int
    var n1: Int
    var d1: Int
    var n2: Int
    var d2: Int
    var nf = 0
    var df = 0
    var ns: Int
    var ds: Int
    var aux0: String

    n = scan.nextInt()
    for (i in 1..n) {
        n1 = scan.nextInt()
        scan.next() // Lê o caractere. Mas nesse programa não precisamos usar, por isso não foi atribuido uma variável
        d1 = scan.nextInt()
        aux0 = scan.next()
        n2 = scan.nextInt()
        scan.next() // Lê o caractere. Mas nesse programa não precisamos usar, por isso não foi atribuido uma variável
        d2 = scan.nextInt()
        when (aux0) {
            "+" -> { //Soma: (N1*D2 + N2*D1) / (D1*D2)
                //nf = ((n1.times(d2)).plus(n2.times(d1))).div((d1.times(d2)))
                nf = ((n1.times(d2)).plus(n2.times(d1)))
                //nf =(n1*d2 + n2*d1)
                df = d1.times(d2)
            }
            "-" -> { //Subtração: (N1*D2 - N2*D1) / (D1*D2)
                nf = (n1.times(d2) - n2.times(d1))
                df = d1.times(d2)
            }
            "*" -> {//Multiplicação: (N1*N2) / (D1*D2)
                nf = (n1.times(n2))
                df = d1.times(d2)
            }
            "/" -> {//Divisão: (N1/D1) / (N2/D2), ou seja (N1*D2)/(N2*D1)
                nf = n1.times(d2)
                df = n2.times(d1)
            }
        }

       var divisor : Int = 2
       var divisorGeral : Int = 1
        var restoDs : Int
       var restoNs : Int
       val listaDivisorComum = mutableListOf<Int>()
        ds = df
        ns = nf

        if (ns<0) {
            ns = ns.times(-1)
        }

        while ((ds > 1) && (ns > 1)) {
            restoDs = ds.mod(divisor)
            restoNs = ns.mod(divisor)

            if (restoDs==0) {
                ds = ds.div(divisor)
            }

            if (restoNs==0) {
                ns = ns.div(divisor)
            }

            if ((restoDs == 0)&&(restoNs == 0)) {
                listaDivisorComum.add(divisor)
                divisorGeral = divisorGeral * divisor
            } else divisor ++

        }
        divisor = 1
        //listaDivisorComum.forEach{ divisor = divisor *it }
        //ns = nf.div(divisor)
        ns = nf.div(divisorGeral)
        //ds = df.div(divisor)
        ds = df.div(divisorGeral)
        println("$nf/$df = $ns/$ds")
    }
}

private fun mdc( d1 : Int, d2 : Int) : Int {
    var a = d1
    var b = d2
    var r: Int
    while (b != 0) {
        r = a.div(b)
        a = b
        b = r
    }
    println("$a")
    return a;
}

private fun mdcRecursive(a: Int, b: Int): Int {
    return if (b == 0) a else mdcRecursive(b, a.div(b))
}

//Algoritmo de Euclides iterativo
fun mdcIterative(d1: Int, d2: Int): Int {
    var a = d1
    var b = d2
    while (b != 0) {
        val r = a % b // val r = a.div(b)
        a = b
        b = r
    }
    return a
}
