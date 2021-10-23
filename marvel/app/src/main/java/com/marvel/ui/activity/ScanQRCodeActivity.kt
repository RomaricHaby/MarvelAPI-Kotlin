package com.marvel.ui.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.zxing.integration.android.IntentIntegrator
import com.marvel.R
import com.marvel.ui.fragment.comics.recyclerview.ComicsAdapter
import com.marvel.ui.series.SeriesAdapter
import com.marvel.ui.stories.StoriesAdapter
import com.marvel.usecase.character.GetCharacterComicsUseCase
import com.marvel.usecase.character.GetCharacterSeriesUseCase
import com.marvel.usecase.character.GetCharacterStoriesUseCase
import com.marvel.usecase.character.GetCharacterUseCase
import kotlinx.coroutines.*

class ScanQRCodeActivity : AppCompatActivity() {
    private lateinit var mQrResultLauncher : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Alternative to "onActivityResult", because that is "deprecated"
        mQrResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == Activity.RESULT_OK) {
                val result = IntentIntegrator.parseActivityResult(it.resultCode, it.data)

                if(result.contents != null) {
                    val intent = Intent(this, CharacterDetailActivity::class.java)

                    val response = runBlocking { GetCharacterUseCase(result.contents).execute().getOrThrow() }

                    intent.putExtra("character", response?.dataCharacter?.results?.get(0))
                    this.startActivity(intent)


                // Toast.makeText(this, result.contents, Toast.LENGTH_LONG).show()
                }
            }
        }

        // Starts scanner on Create of Overlay (you can also call this function using a button click)
        startScanner()
    }


    // Start the QR Scanner
    private fun startScanner() {
        val scanner = IntentIntegrator(this)
        // QR Code Format
        scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        // Set Text Prompt at Bottom of QR code Scanner Activity
        scanner.setPrompt("Scanner le Qr Code d'un héro")

        scanner.setOrientationLocked(true)

        // Start Scanner (don't use initiateScan() unless if you want to use OnActivityResult)
        mQrResultLauncher.launch(scanner.createScanIntent())
    }

//TODO check si sa passe
    override fun onBackPressed() {
        super.onBackPressed()

        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}