package racingcar.validator

import racingcar.domain.StringSplitter

object EntryArgumentValidator : InputArgumentValidator {
    private const val BLANK = ""

    override fun validate(input: String): Boolean {
        val split = StringSplitter.split(input)

        if (!checkBlank(split)) {
            return false
        }

        if (!checkLengthExceed(split)) {
            return false
        }

        return checkDuplicate(split)
    }

    private fun checkBlank(split: List<String>): Boolean {
        return split.all { it != BLANK }
    }

    private fun checkLengthExceed(split: List<String>): Boolean {
        return split.map { it.length }.any { value -> value <= 5 }
    }

    private fun checkDuplicate(split: List<String>): Boolean {
        val originSize = split.size
        val distinctSize = split.distinct().size

        return originSize == distinctSize
    }


}
