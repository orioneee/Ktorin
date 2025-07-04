package io.github.orioneee.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import java.util.Locale

actual object LocalAppLocale {
    private var default: Locale? = null
    actual val current: String @Composable get() = Locale.getDefault().toString()

    @Composable
    actual infix fun provides(value: String?): ProvidedValue<*> {
        val configuration = LocalConfiguration.current
        if (default == null) default = Locale.getDefault()
        val new = value?.let { Locale(it) } ?: default!!
        Locale.setDefault(new)
        configuration.setLocale(new)
        LocalContext.current.resources.updateConfiguration(
            configuration,
            LocalContext.current.resources.displayMetrics
        )
        return LocalConfiguration.provides(configuration)
    }
}
