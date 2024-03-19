package com.example.assignment1

object BookRepository {
    private val books = listOf(
        Book(1, "Harry Potter 1", "J. K. Rowling", "The first Harry P"),
        Book(2, "Goosebumps", "R. L. Stine", "Horror book thriller thing"),
        Book(3, "The Witcher", "Marcus N. J.", "Witching time"),
        Book(4, "The Martian", "Martin L. K.", "Martianing on Mars!")

    )

    fun getBooks(): List<Book> = books

    fun getBookById(id: Int): Book? = books.find { it.id == id }
}