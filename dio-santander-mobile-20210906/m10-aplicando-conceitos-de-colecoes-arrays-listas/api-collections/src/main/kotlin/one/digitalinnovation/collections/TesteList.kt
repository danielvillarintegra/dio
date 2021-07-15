package one.digitalinnovation.collections

fun main (){
    val joao = Funcionario("João", 2000.0, "CLT")
    val pedro = Funcionario("Pedro", 1500.0 , "PJ")
    val maria = Funcionario("Maria", 4000.0 , "CLT")

    val funcionarios1 = setOf(joao, pedro)
    val funcionarios2 = setOf(maria)

    val resultUnion = funcionarios1.union(funcionarios2)

    println("a) União dos conjuntos funcionarios1 e funcionarios2 -----------------")
    resultUnion.forEach { println(it)}




}

