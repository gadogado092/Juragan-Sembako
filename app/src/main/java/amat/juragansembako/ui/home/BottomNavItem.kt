package amat.juragansembako.ui.home

import amat.juragansembako.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {

    object Home : BottomNavItem("Home", R.drawable.ic_baseline_home_24, "home")
    object Transaction : BottomNavItem("Transaksi", R.drawable.ic_baseline_payment_24, "transaction")
    object Other : BottomNavItem("Lainnya", R.drawable.ic_baseline_menu_24, "Other")
//    object AddPost: BottomNavItem("Post",R.drawable.ic_post,"add_post")
//    object Notification: BottomNavItem("Notification",R.drawable.ic_notification,"notification")
//    object Jobs: BottomNavItem("Jobs",R.drawable.ic_job,"jobs")
}