class Number(val value: Double) {

    constructor(strValue: String) : this(
        value = strValue.toDouble()
    )

    operator fun plus(other: Number): Number {
        return Number(this.value + other.value)
    }

    operator fun minus(other: Number): Number {
        return Number(this.value - other.value)
    }

    operator fun times(other: Number): Number {
        return Number(this.value * other.value)
    }

    operator fun div(other: Number): Number {
        return Number(this.value / other.value)
    }
}