package gt.uvg.pokelist.model

data class PokeResponse(
    val count:Int,
    val next: String,
    val previous: Any?,
    val results:List<Pokemon>
)