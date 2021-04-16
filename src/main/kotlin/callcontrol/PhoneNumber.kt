package callcontrol

class PhoneNumber(private var countryCode : String, private var areaCode : String, private var subscriberNumber : String) {
    init {
        countryCode = countryCode.trim('0')
        if (!countryCode.startsWith("+")) countryCode = "+$countryCode"
        areaCode = areaCode.trim('0')
        if (!subscriberNumber.get(4).isWhitespace()) subscriberNumber = subscriberNumber.slice(0..2) + " " + subscriberNumber.slice(3..subscriberNumber.length-1)
    }

    override fun toString(): String = "$countryCode $areaCode/$subscriberNumber";
}