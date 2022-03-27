class Solver {
    var words: HashSet<String> = HashSet()
    fun addWord(word: String) {
        words.add(word)
    }

    fun addResult(word: String, result: Int): String? {
        when(result) {
            0 -> {
                words.remove(word)
                val removalList = HashSet<String>()
                words.forEach { it ->
                    it.forEachIndexed{i,e->
                        if (word[i] == e) {
                            removalList.add(it)
                        }
                    }
                }
                words.removeAll(removalList)
                if (words.size == 1) {
                    return words.first()
                }
                println(words)
            }
            else -> {
                val removalList = HashSet<String>()
                words.forEach {
                    var match = 0
                    it.forEachIndexed { i, c ->
                        if (word[i] == c) {
                            match++
                        }
                    }
                    if (match < result) {
                        removalList.add(it)
                    }
                }
                words.removeAll(removalList)
                words.remove(word)
                if (words.size == 1) {
                    return words.first()
                }
                println(words)
            }
        }
        return null
    }
}