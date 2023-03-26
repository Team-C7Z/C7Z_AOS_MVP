package com.c7z.myapplication.group.model

data class GroupItem(
    val groupImage: Int?,
    val groupCategory: String,
    val groupName: String,
    val groupMemberProfile: MutableList<String>?,
    val groupMemberCount: String,
)
