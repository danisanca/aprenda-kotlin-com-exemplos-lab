data class Usuario(val nome: String, val email:String)

enum class NivelFormacao { BASICO, INTERMEDIARIO, AVANÇADO, EXPERT }
data class Aulas(val nome: String, val urlVideo:String?, val urlConteudoLeitura:String?)
data class ConteudoEducacional(val nome: String, val duracaoMinutos: Int?, val aulas: List<Aulas>)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>,val nivel:NivelFormacao) {

    val inscritos: MutableList<Usuario> = mutableListOf()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {

    val daniel:Usuario = Usuario("daniel","dani@hotmail.com")
    val aula1:Aulas = Aulas("Declarando Variaveis No Kotlin","http://videoaula1.mp4","http://github.com/doc1.md")
    val aula2:Aulas = Aulas("Declarando Funções No Kotlin","http://videoaula2.mp4","http://github.com/doc2.md")
    val kotlinModulo1:ConteudoEducacional = ConteudoEducacional("Modulo 1",1200,aulas= listOf(aula1))
    val kotlinModulo2:ConteudoEducacional = ConteudoEducacional("Modulo 2",2400,aulas= listOf(aula2))
    val formacaoKotlin:Formacao = Formacao("Aprendendo Kotlin Na Pratica", listOf(kotlinModulo1,kotlinModulo2),NivelFormacao.BASICO)

    formacaoKotlin.matricular(daniel)

    println(formacaoKotlin)

}
