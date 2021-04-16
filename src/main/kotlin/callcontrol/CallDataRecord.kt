package callcontrol

import java.time.LocalDateTime

class CallDataRecord(var callingParty : PhoneNumber, var calledParty : PhoneNumber) {
    var startTime : LocalDateTime? = null
    var endTime : LocalDateTime? = null

    fun establish() {
        if (startTime == null) startTime = LocalDateTime.now()
    }

    fun disconnect() {
        if (startTime != null && endTime == null) endTime = LocalDateTime.now()
    }

    override fun toString(): String {
        val callingPartyString = "calling: $callingParty"
        val calledPartyString = "called: $calledParty"
        val startString = "start: " + if (startTime == null) "not yet established" else "$startTime"
        var endString = ""
        if (startTime != null) endString = ", end: " + if (endTime == null) "still established" else "$endTime"
        return "$callingPartyString, $calledPartyString, $startString$endString"
    }
}