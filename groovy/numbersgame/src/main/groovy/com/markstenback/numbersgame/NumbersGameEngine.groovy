package com.markstenback.numbersgame

import com.markstenback.numbersgame.data.Number
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 *
 */
class NumbersGameEngine {
    private static final Logger log = LoggerFactory.getLogger(NumbersGameEngine.class)
    HashMap <Integer, Number> registry
    Integer secretNumber
    Integer guesses
    Integer valHigh
    Integer valLow

    /**
     * Constructor.
     */
    NumbersGameEngine(int numberRange) {
        registry = new HashMap <Integer, Number> (numberRange)
        guesses = new Integer(0)
        valHigh = numberRange
        valLow = 1

        for (int i = 1; i <= numberRange; i++) {
            registry.put(i, new Number(i))
        }

        Random rnd = new Random()
        secretNumber = rnd.nextInt(numberRange + 1)
        registry.get(secretNumber).isSecretNumber = true

        log.debug("Registry size is ${registry.size()}")

        for (int i = 1; i <= 100; i++) {
            log.debug("${registry.get(i).value}, ${registry.get(i).isChecked}, ${registry.get(i).isSecretNumber}")
        }
    }


    /**
     *
     * @return
     */
    Boolean guess () {
        Boolean isCorrectGuess = false
        StringBuilder sb = new StringBuilder(100)

        System.println("[${guesses}] Pick a number between 1 and ${registry.size()}) (${progressBar()}")
        def guess = System.in.newReader().readLine() as Integer

        if (registry.get(guess).isSecretNumber) {
            sb.append("CONGRATULATIONS! You found the secret number!")
            isCorrectGuess = true
        }
        else {


            if (secretNumber > guess) {
                sb.append("Wrong. Your guess was low.")

                if (guess > valLow)
                    valLow = guess
            }
            else {
                sb.append("Wrong. Your guess was high.")

                if (guess < valHigh)
                    valHigh = guess
            }

            if (registry.get(guess).isChecked)
                sb.append(" Besides you have already tried this number!")
            else
                registry.get(guess).isChecked = true
        }

        guesses++
        System.println(sb.toString())

        return isCorrectGuess
    }


    /**
     *
     * @return
     */
    private String progressBar() {
        def barLength = (valHigh - valLow) / 10
        def sb = new StringBuffer()
        sb.append("${valLow} <")
        for (int i = 0; i <= barLength; i++) {
            sb.append("=")
        }
        sb.append("> ${valHigh}")

    }
}
