package com.news.di

//class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
//            val db = Room.databaseBuilder(context.applicationContext, NewsDatabase::class.java, "articles").build()
//            @Suppress("UNCHECKED_CAST")
////            return NewsViewModel(db.articleDao()) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//
//    }
//}