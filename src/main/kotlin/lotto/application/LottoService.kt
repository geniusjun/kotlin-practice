package lotto.application

import lotto.domain.*
import lotto.global.Parser

class LottoService(
    private val lottoFactory: LottoFactory
) {
    /**
     * 검증된 Cost로부터 로또 여러 장 구매
     */
    fun buyLottos(cost: Cost): Lottos {
        val lottos = buildList {
            repeat(cost.count) {
                add(lottoFactory.create())
            }
        }
        return Lottos.from(lottos)
    }

    /**
     * 사용자가 입력한 문자열을 비용 도메인으로 변환
     */
    fun parseCost(input: String): Cost =
        Cost.from(input)

    /**
     * 당첨 번호(6개) 문자열을 Lotto로 변환
     */
    fun parseWinningLotto(input: String): Lotto =
        Lotto.from(Parser.stringToNumbers(input))

    /**
     * 보너스 번호 문자열을 Bonus로 변환
     */
    fun parseBonus(input: String, winning: Lotto): Bonus {
        val number = LottoNumber.valueOf(Parser.stringToInt(input))
        return Bonus.of(number, winning)
    }
}
