package racingcar.model

data class RaceSetting(val racingCarSettings: List<RacingCarSetting>, val totalStep: Int) {
    companion object {
        fun from(userInput: UserInput): RaceSetting {
            val racingCarSettings = userInput.getEntries().map { RacingCarSetting(it) }

            return RaceSetting(racingCarSettings, userInput.getTotalStep())
        }
    }
}
