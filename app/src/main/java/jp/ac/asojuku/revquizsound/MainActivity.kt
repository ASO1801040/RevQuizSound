package jp.ac.asojuku.revquizsound

import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var soundPool: SoundPool
    private var soundResId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        answerButton.setOnClickListener {
            soundPool.play(soundResId, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        questionButton.setOnClickListener { subAct(it) }



    }
    fun subAct(view: View?){
        val intent = Intent(this, SubActivity::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        this.soundPool =
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
                SoundPool(2, AudioManager.STREAM_ALARM,0)
            }else{
                val audioAttributes = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(audioAttributes)
                    .build()

            }

        this.soundResId = soundPool.load(this, R.raw.quiz3, 1)
    }
}
