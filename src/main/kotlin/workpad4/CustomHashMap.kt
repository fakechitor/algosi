package workpad4

import java.util.LinkedList

class CustomHashMap<T,K>(private val size: Int = 4) {

    private val map = Array<LinkedList<Pair<T,K>>>(size) {LinkedList()}

    private fun getHashKey(key : K)  : Int{
        //TODO check fun hashCode
        return key.hashCode() % size
    }

    //TODO add get/remove methods
}