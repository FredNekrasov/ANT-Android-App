package com.alexander_nevsky_temple.ui.navigation

sealed class ScreenRoute(val route: String) {
    data object Main : ScreenRoute(TitleStrings.MAIN)
    data object Life : ScreenRoute(TitleStrings.LIFE)
    data object Schedule : ScreenRoute(TitleStrings.SCHEDULE)
    data object Conversation : ScreenRoute(TitleStrings.CONVERSATION)
    data object Club : ScreenRoute(TitleStrings.CLUB)
    data object Priesthood : ScreenRoute(TitleStrings.PRIESTHOOD)
    data object Priests : ScreenRoute(TitleStrings.PRIESTS)
    data object History : ScreenRoute(TitleStrings.HISTORY)
    data object Chants : ScreenRoute(TitleStrings.CHANTS)
    data object Contacts : ScreenRoute(TitleStrings.CONTACTS)
    data object Information : ScreenRoute(TitleStrings.INFORMATION)
}