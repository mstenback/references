package com.markstenback.numbersgame.data

/**
 *
 */
class Number {
    Integer value
    Boolean isChecked
    Boolean isSecretNumber

    Number (int val) {
        this.value = val
        this.isChecked = false
        this.isSecretNumber = false
    }
}
