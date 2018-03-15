package various

fun isPlusOne(program: String): Boolean { return true }

fun halts(program: String): Boolean {
    fun stlah(a: Int): Int {
        exec(program);
        return a + 1
    }
    return isPlusOne("Rice.kt:stlah")
}

fun exec(program: String) {}