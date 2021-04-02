package diego.guinea.preciojusto.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import androidx.core.graphics.drawable.toDrawable
import diego.guinea.preciojusto.R



fun Context.showLoadingDialog(): Dialog{
        val progressDialog = Dialog(this)
        progressDialog.let {
            it.show()
            it.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
            it.setContentView(R.layout.activity_game)
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
            return it
        }
    }



