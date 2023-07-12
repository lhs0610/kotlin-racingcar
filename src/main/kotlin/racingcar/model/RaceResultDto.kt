package racingcar.model

data class RaceResultDto(
    val stepResults: List<StepResultDto>,
    val winners: List<String>
)
