package jp.ac.asojuku.revquizsound

import android.app.Activity
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {

    private lateinit var soundPool: SoundPool
    private var soundResIdC = 0
    private var soundResIdW = 0
    private var soundResIdQ = 0
    private var soundResIdE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        correctButton.setOnClickListener {
            soundPool.play(soundResIdC, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        wrongButton.setOnClickListener {

            soundPool.play(soundResIdW, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        questionButton.setOnClickListener {

            soundPool.play(soundResIdQ, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        exciteButton.setOnClickListener {

            soundPool.play(soundResIdE, 1.0f, 1.0f, 0, 0, 1.0f)
        }

    }

    override fun onResume() {
        super.onResume()
        this.soundPool =
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
                SoundPool(5, AudioManager.STREAM_ALARM,0)
            }else{
                val audioAttributes = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(audioAttributes)
                    .build()

            }
        this.soundResIdC = soundPool.load(this, R.raw.quiz1, 1)
        this.soundResIdW = soundPool.load(this, R.raw.quiz2, 1)
        this.soundResIdQ = soundPool.load(this, R.raw.quiz5, 1)
        this.soundResIdE = soundPool.load(this, R.raw.quiz4, 1)


        goToAnswerButton.setOnClickListener {
            finish()
        }

    }
}
