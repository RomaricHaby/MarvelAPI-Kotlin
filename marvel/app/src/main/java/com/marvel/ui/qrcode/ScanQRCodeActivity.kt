package com.marvel.ui.qrcode

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.budiyev.android.codescanner.*
import com.marvel.R
import com.marvel.ui.detail.CharacterDetailActivity
import com.marvel.usecase.character.GetCharacterUseCase
import kotlinx.coroutines.runBlocking

class ScanQRCodeActivity : AppCompatActivity() {
    private lateinit var codeScanner: CodeScanner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_qrcode)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 123)
        } else {
            startScanning()
        }
    }

    private fun startScanning() {
        val scannerView: CodeScannerView = findViewById(R.id.scanner_view)
        codeScanner = CodeScanner(this, scannerView)
        codeScanner.camera = CodeScanner.CAMERA_BACK
        codeScanner.formats = CodeScanner.ALL_FORMATS

        codeScanner.autoFocusMode = AutoFocusMode.SAFE
        codeScanner.scanMode = ScanMode.SINGLE
        codeScanner.isAutoFocusEnabled = true
        codeScanner.isFlashEnabled = false

        codeScanner.decodeCallback = DecodeCallback {
            runOnUiThread {
                val intent = Intent(this, CharacterDetailActivity::class.java)

                val response = runBlocking { GetCharacterUseCase(it.text).execute().getOrThrow() }

                intent.putExtra("character", response?.dataCharacter?.results?.get(0))
                this.startActivity(intent)
            }
        }

        codeScanner.errorCallback = ErrorCallback {
            runOnUiThread {
                Toast.makeText(
                    this,
                    getString(R.string.cameraError) + it.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        }


        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 123) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, getString(R.string.cameraGranted), Toast.LENGTH_LONG).show()
                startScanning()
            } else {
                Toast.makeText(this, getString(R.string.cameraNotGranted), Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (::codeScanner.isInitialized) {
            codeScanner.startPreview()
        }
    }

    override fun onPause() {
        if (::codeScanner.isInitialized) {
            codeScanner.releaseResources()
        }
        super.onPause()
    }
}


/* private lateinit var mQrResultLauncher: ActivityResultLauncher<Intent>

 override fun onCreate(savedInstanceState: Bundle?) {
     super.onCreate(savedInstanceState)
     setContentView(com.marvel.R.layout.activity_scan_qrcode)



 }*/


/*try {
       val barcodeEncoder = BarcodeEncoder()
       val bitmap = barcodeEncoder.encodeBitmap("1009368", BarcodeFormat.QR_CODE, 400, 400)
       val imageViewQrCode = findViewById<View>(com.marvel.R.id.qrCode) as ImageView
       imageViewQrCode.setImageBitmap(bitmap)

   } catch (e: Exception) {
   }*/

//setUPForScan()
