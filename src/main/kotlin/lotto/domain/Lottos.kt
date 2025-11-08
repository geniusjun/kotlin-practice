package lotto.domain

class Lottos private constructor(lottos: List<Lotto>) {

    private val lottos: List<Lotto> = lottos.toList()

    companion object {
        fun from(lottos: List<Lotto>): Lottos {
            return Lottos(lottos)
        }
    }

    fun size(): Int = lottos.size

    fun asList(): List<Lotto> = lottos

    fun asSequence(): Sequence<Lotto> = lottos.asSequence()
}
