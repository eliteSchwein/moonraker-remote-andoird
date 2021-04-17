package de.eliteschw31n.moonrakerremote.ui.settings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import de.eliteschw31n.moonrakerremote.MainActivity
import de.eliteschw31n.moonrakerremote.R
import de.eliteschw31n.moonrakerremote.utils.LocalDatabase
import de.eliteschw31n.moonrakerremote.utils.NavTitles
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import org.json.JSONObject
import java.io.IOException
import java.net.*
import java.util.*

class SettingsFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_settings, container, false)


        return root
    }

    private fun setSaved(textlayout: TextInputLayout, saveMessage: String) {
        MainActivity.runUiUpdate(Runnable {
            textlayout.helperText = saveMessage
            textlayout.isHelperTextEnabled = true
        })
        Timer().schedule(object : TimerTask() {
            override fun run() {
                MainActivity.runUiUpdate(Runnable {
                    textlayout.helperText = null
                    textlayout.isHelperTextEnabled = false
                })
            }
        }, 2000)
    }
    private fun setError(textlayout: TextInputLayout, errorReason: String) {
        MainActivity.runUiUpdate(Runnable {
            textlayout.error = errorReason
            textlayout.isErrorEnabled = true
        })
        Timer().schedule(object : TimerTask() {
            override fun run() {
                MainActivity.runUiUpdate(Runnable {
                    textlayout.error = null
                    textlayout.isErrorEnabled = false
                })
            }
        }, 2000)
    }
}