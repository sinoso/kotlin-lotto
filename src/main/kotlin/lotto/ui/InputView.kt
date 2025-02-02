package lotto.ui

import lotto.domain.ExceptionType.INPUT_MUST_NOT_NULL
import lotto.domain.ExceptionType.INPUT_MUST_UNSIGNED_INT
import lotto.domain.ExceptionType.NUMBER_OF_MANUAL_SELECT_GAME_MUST_UNSIGNED_INT
import lotto.domain.LottoBudget
import lotto.domain.LottoGame
import lotto.domain.LottoNumber

object InputView {
    private const val delimiter = ","
    private val unsignedNumberRegex = "\\d*".toRegex()

    fun readInputForLottoGameBudget(): LottoBudget {
        val budgetInput = readLine()
        requireNotNull(budgetInput) { INPUT_MUST_NOT_NULL }
        require(isUnsignedInt(budgetInput)) { INPUT_MUST_UNSIGNED_INT }
        return LottoBudget(budgetInput)
    }

    fun readInputForNumberOfManualSelectGame(): Int {
        val numberOfManualSelectGame = readLine()
        requireNotNull(numberOfManualSelectGame) { INPUT_MUST_NOT_NULL }
        require(isUnsignedInt(numberOfManualSelectGame)) { NUMBER_OF_MANUAL_SELECT_GAME_MUST_UNSIGNED_INT }
        return numberOfManualSelectGame.toInt()
    }

    fun readInputNumbersForManualSelectGame(): LottoGame {
        val numbersForManualSelectGame = readLine()?.replace(" ", "")
        requireNotNull(numbersForManualSelectGame) { INPUT_MUST_NOT_NULL }
        return LottoGame.createWithNumberListString(numbersForManualSelectGame.split(delimiter))
    }

    fun readInputForLastWeekNumbers(): List<LottoNumber> {
        val numbersInput = readLine()?.replace(" ", "")
        requireNotNull(numbersInput) { INPUT_MUST_NOT_NULL }
        val numbersInString = numbersInput.split(delimiter)
        return numbersInString.map { LottoNumber(it) }
    }

    fun readInputForLastWeekBonusNumbers(): Int {
        val numbersInput = readLine()
        requireNotNull(numbersInput) { INPUT_MUST_NOT_NULL }
        return numbersInput.toInt()
    }

    private fun isUnsignedInt(numberOfString: String) = numberOfString.matches(unsignedNumberRegex)
}
