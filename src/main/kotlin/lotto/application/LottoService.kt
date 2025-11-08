package lotto.application

import lotto.domain.Cost
import lotto.domain.Lottos

class LottoService(private val lottoFactory: LottoFactory) {
    fun buyLottos(cost: Cost): Lottos {
        val lottos = buildList {
            repeat(cost.count) {
                add(lottoFactory.create())
            }
        }
        return Lottos.from(lottos)
    }
}
