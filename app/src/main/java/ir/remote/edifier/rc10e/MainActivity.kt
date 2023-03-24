package ir.remote.edifier.rc10e

import android.hardware.ConsumerIrManager
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{
    private fun nec(data: Int): IntArray
    {
        val zero = intArrayOf(562, 562)
        val one = intArrayOf(562, 1687)
        val end = 562

        var result = intArrayOf(9000, 4500)

        for(i in 0..31)
        {
            result += when(data and (1 shl i)) {
                0 -> zero
                else -> one
            }
        }

        result += end

        return result
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val irManager = getSystemService(CONSUMER_IR_SERVICE) as ConsumerIrManager
        val hasIr: Boolean = irManager.hasIrEmitter()

        if(hasIr)
        {
            val power = findViewById<ImageButton>(R.id.power)
            power.setOnClickListener{
                irManager.transmit(38028, nec(0xFE01E710.toInt()))
            }
            power.isClickable = true

            val mute = findViewById<ImageButton>(R.id.mute)
            mute.setOnClickListener{
                irManager.transmit(38028, nec(0xFF00E710.toInt()))
            }
            mute.isClickable = true

            val volumeDown = findViewById<ImageButton>(R.id.volume_down)
            volumeDown.setOnClickListener{
                irManager.transmit(38028, nec(0xF30CE710.toInt()))
            }
            volumeDown.isClickable = true

            val volumeUp = findViewById<ImageButton>(R.id.volume_up)
            volumeUp.setOnClickListener{
                irManager.transmit(38028, nec(0xF609E710.toInt()))
            }
            volumeUp.isClickable = true

            val line1 = findViewById<ImageButton>(R.id.line1)
            line1.setOnClickListener{
                irManager.transmit(38028, nec(0xF50AE710.toInt()))
            }
            line1.isClickable = true

            val line2 = findViewById<ImageButton>(R.id.line2)
            line2.setOnClickListener{
                irManager.transmit(38028, nec(0xEA15E710.toInt()))
            }
            line2.isClickable = true

            val opt = findViewById<ImageButton>(R.id.opt)
            opt.setOnClickListener{
                irManager.transmit(38028, nec(0xF20DE710.toInt()))
            }
            opt.isClickable = true

            val cox = findViewById<ImageButton>(R.id.cox)
            cox.setOnClickListener{
                irManager.transmit(38028, nec(0xE916E710.toInt()))
            }
            cox.isClickable = true

            val bluetooth = findViewById<ImageButton>(R.id.bluetooth)
            bluetooth.setOnClickListener{
                irManager.transmit(38028, nec(0xF10EE710.toInt()))
            }
            bluetooth.isClickable = true

            val play = findViewById<ImageButton>(R.id.play)
            play.setOnClickListener{
                irManager.transmit(38028, nec(0xEB14E710.toInt()))
            }
            play.isClickable = true

            val prev = findViewById<ImageButton>(R.id.prev)
            prev.setOnClickListener{
                irManager.transmit(38028, nec(0xF906E710.toInt()))
            }
            prev.isClickable = true

            val next = findViewById<ImageButton>(R.id.next)
            next.setOnClickListener{
                irManager.transmit(38028, nec(0xF708E710.toInt()))
            }
            next.isClickable = true
        }
    }
}