package racingcar.model

data class RaceSetting(val racingcarSettings: List<RacingCarSetting>, val totalStep: Int) {
    companion object {
        fun from(userInput: UserInput): RaceSetting {
            val racingcarSettings = userInput.entries.map { RacingCarSetting(it) }

            return RaceSetting(racingcarSettings, userInput.totalStep)
        }
    }
}
