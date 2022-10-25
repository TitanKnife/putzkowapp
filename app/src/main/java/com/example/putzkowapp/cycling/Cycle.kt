package com.example.putzkowapp.cycling

import java.util.Collections
import java.util.LinkedList
class Cycle(
    var itemsToRotate: List<TextHandler>,
    private val usersToIgnore: List<String>? = null
) {
    fun moveCycle(distance: Int){
        // remove all elements from list that are ignored
        val validSpotsToRotate = LinkedList<TextHandler>();
        for (item in this.itemsToRotate){
            if (this.usersToIgnore === null || !this.usersToIgnore.contains(item.getUser())){
                validSpotsToRotate.add(item)
            }
        }

        // rotate list of values of valid text fields
        val nextSpotsUsers = validSpotsToRotate.map { it.getUser() };
        Collections.rotate(nextSpotsUsers, distance);

        // write shifted users back to valid text fields
        validSpotsToRotate.forEachIndexed {
            index, textHandler -> textHandler.setUser(nextSpotsUsers[index])
        }
    }
}