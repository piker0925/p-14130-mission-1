package com

data class WiseSaying(val id: Int, var content: String, var author: String)

fun main() {

    var index = 1
    val wiseSayingList = mutableListOf<WiseSaying>()

    println("== 명언 앱 ==")

    while(true){
        print("명령) ")

        val command = readln()

        when {
            command == "종료" -> break

            command == "등록" -> {
                print("명언: ")
                val content = readln()

                print("작가: ")
                val author = readln()

                wiseSayingList.add(WiseSaying(index, content, author))

                println("$index 번 명언이 등록되었습니다.")

                index++
            }

            command == "목록" -> {
                println("번호 / 작가 / 명언")
                println("----------------------")
                wiseSayingList.reversed().forEach {
                    println("${it.id} / ${it.author} / ${it.content}")
                }
            }

            command.startsWith("삭제?id=") -> {
                val id = command.substringAfter("id=").toIntOrNull() ?: continue

                val found = wiseSayingList.removeIf { it.id == id }
                if (found)
                    println("$id 번 명언이 삭제되었습니다. ")
                else
                    println("$id 번 명언은 존재하지 않습니다.")
            }

            command.startsWith("수정?id=") -> {
                val id = command.substringAfter("id=").toIntOrNull() ?: continue

                val found = wiseSayingList.find { it.id == id }
                if (found == null) {
                    println("$id 번 명언은 존재하지 않습니다.")
                } else {
                    println("명언(기존) : ${found.content}")
                    print("명언 : ")
                    val newContent = readln()
                    found.content = newContent

                    println("작가(기존) : ${found.author}")
                    print("작가 : ")
                    val newAuthor = readln()
                    found.author = newAuthor
                }

            }

        }
    }
}