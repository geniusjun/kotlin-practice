package lotto.config

import lotto.application.LottoFactory
import lotto.application.LottoService
import lotto.application.RandomLottoFactory
import lotto.controller.LottoController
import lotto.view.ui.InputView
import lotto.view.ui.OutputView
import lotto.view.util.InputLoop

/**
 * 애플리케이션 객체의 의존 관계를 설정하고 조립하는 DI 컨테이너
 */
object AppConfig {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val lottoFactory: LottoFactory = RandomLottoFactory()
    private val lottoService = LottoService(lottoFactory)
    private val inputLoop = InputLoop(outputView)

    fun lottoController(): LottoController =
        LottoController(outputView, inputView, lottoService, inputLoop)
}
