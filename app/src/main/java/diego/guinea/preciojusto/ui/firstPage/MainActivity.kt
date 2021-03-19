package diego.guinea.preciojusto.ui.firstPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import diego.guinea.preciojusto.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSplash()

    }

    private fun setSplash() {
        val animationTop = AnimationUtils.loadAnimation(this, R.anim.animacion_top)
        val animationBottom = AnimationUtils.loadAnimation(this, R.anim.animacion_bottom)

        val imageTop = findViewById<ImageView>(R.id.imageTopView)
        val imageBottom = findViewById<ImageView>(R.id.imageBottomView)
        val title = findViewById<TextView>(R.id.textTitle)

        imageTop.animation = animationTop
        imageBottom.animation = animationBottom
        title.animation = animationTop

        Handler().postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        },4000)
    }


}