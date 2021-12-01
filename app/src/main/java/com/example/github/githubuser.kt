package com.example.github

data class githubuser(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)