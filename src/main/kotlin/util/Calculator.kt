package util

import component.MathExpression

fun calculate(expression: MathExpression): Int {
    val numList = expression.numList
    val operatorList = expression.operatorList

    val size = operatorList.size

    var result = numList[0]

    for (i in 0 until size) {
        result = operatorList[i].apply(result, numList[i + 1])
    }
    return result
}
