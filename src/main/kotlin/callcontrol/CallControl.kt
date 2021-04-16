/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package callcontrol

class CallControl(var localParty : PhoneNumber) {
    var state : CallState = CallState.IDLE
    private var cdr : CallDataRecord? = null

    fun getCDR() : CallDataRecord? = cdr

    fun alert(callingParty : PhoneNumber) {
        if (state == CallState.IDLE) {
            state = CallState.ALERTING
            cdr = CallDataRecord(callingParty, localParty)
        }
    }

    fun alert() {
        if (state == CallState.DIALING) state = CallState.ALERTING
    }

    fun dial(calledParty : PhoneNumber) {
        if (state == CallState.IDLE) {
            cdr = CallDataRecord(localParty, calledParty)
            state = CallState.DIALING
        }
    }

    fun connect() {
        if (state == CallState.ALERTING) {
            cdr?.establish()
            state = CallState.CONNECTED
        }
    }

    fun disconnect() {
        if (state == CallState.CONNECTED) {
            cdr?.disconnect()
            state = CallState.DISCONNECTED
        }
    }

    fun release() {
        if (state != CallState.CONNECTED) state = CallState.RELEASED
    }

    enum class CallState {
        IDLE, ALERTING, DIALING, CONNECTED, DISCONNECTED, RELEASED;
    }
}
