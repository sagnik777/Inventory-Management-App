package com.example.inventorymanager

object Constants {

    object loginUsernames {
        val listUsername = listOf("sagnik", "pramod", "martunjai")
        val listAdminNames = listOf("srinivas", "john")
    }

    object loginPasswords {
        const val userPassword = "abc123"
        const val adminPassword = "def456"
    }

    object userData {
        const val dataInventoryType = "inventoryType"
        const val dataSerialId = "serialId"
        const val dataModelName = "modelName"
        const val dataOwnerName = "ownerName"
        const val dataOwnerContact = "ownerContact"
        const val dataOwnerKUID = "owner"
    }
}