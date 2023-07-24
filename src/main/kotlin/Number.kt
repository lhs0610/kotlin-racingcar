class Number(val value: Double) {

    constructor(strValue: String) : this(
        value = strValue.toDouble()
    )
}