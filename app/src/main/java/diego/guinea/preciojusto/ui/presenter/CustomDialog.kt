package diego.guinea.preciojusto.ui.presenter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import diego.guinea.preciojusto.R
import diego.guinea.preciojusto.ui.gamePage.WinPage
import diego.guinea.preciojusto.utils.Monedas
import diego.guinea.preciojusto.utils.contError
import diego.guinea.preciojusto.utils.contWins
import kotlinx.android.synthetic.main.fragmen_custom_dialog.view.*

class CustomDialog: DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View =  inflater.inflate(R.layout.fragmen_custom_dialog, container, false)

        rootView.btn_cancel.setOnClickListener {
           dismiss()
        }
        rootView.btn_less_coins.setOnClickListener {
            if (Monedas >= 2){
                Monedas -= 2
                contError += 1
                dismiss()
            }else{
               dismiss()
            }
        }
        return rootView
    }
    override fun onStop() {
        if(contError == 0){
            intentWin()
        }
        super.onStop()
    }

    private fun intentWin() {
        val intent = Intent(context, WinPage::class.java)
        intent.putExtra("numCont", "$contWins")
        intent.putExtra("numLives", "$contError")
        startActivity(intent)
    }
}