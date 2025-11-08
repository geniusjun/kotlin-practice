import lotto.config.AppConfig

fun main() {
    val lottoController = AppConfig.lottoController()
    lottoController.play()
}