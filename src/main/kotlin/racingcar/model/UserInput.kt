package racingcar.model

data class UserInput(val entries: EntryInput, val totalStep: TotalStepInput) {
    fun getEntries(): List<String> {
        return entries.value
    }

    fun getTotalStep(): Int {
        return totalStep.value
    }
}
