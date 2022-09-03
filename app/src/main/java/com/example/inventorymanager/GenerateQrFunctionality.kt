package com.example.inventorymanager

import android.graphics.Bitmap
import android.widget.EditText
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix
import com.journeyapps.barcodescanner.BarcodeEncoder
import org.json.JSONObject

object GenerateQrFunctionality {

    fun readUserData(
        etInventoryType: EditText,
        etSerialId: EditText,
        etModelName: EditText,
        etOwnerName: EditText,
        etOwnerContact: EditText,
        etOwnerKUID: EditText, ): JSONObject {

        val userDataJson = JSONObject()
        userDataJson.put(Constants.userData.dataInventoryType, etInventoryType.text.toString())
        userDataJson.put(Constants.userData.dataSerialId, etSerialId.text.toString())
        userDataJson.put(Constants.userData.dataModelName, etModelName.text.toString())
        userDataJson.put(Constants.userData.dataOwnerName, etOwnerName.text.toString())
        userDataJson.put(Constants.userData.dataOwnerContact, etOwnerContact.text.toString())
        userDataJson.put(Constants.userData.dataOwnerKUID, etOwnerKUID.text.toString())

        return userDataJson
    }

    fun generateQrCode(qrText: String): Bitmap {
        val writer = MultiFormatWriter()
        val encoder = BarcodeEncoder()

        val bitMatrix: BitMatrix = writer.encode(qrText, BarcodeFormat.QR_CODE, 750, 750)
        return encoder.createBitmap(bitMatrix)
    }

    fun resetInputFields(
        etInventoryType: EditText,
        etSerialId: EditText,
        etModelName: EditText,
        etOwnerName: EditText,
        etOwnerContact: EditText,
        etOwnerKUID: EditText
    ) {
        etInventoryType.text.clear()
        etModelName.text.clear()
        etOwnerContact.text.clear()
        etOwnerKUID.text.clear()
        etSerialId.text.clear()
        etOwnerName.text.clear()
    }
}