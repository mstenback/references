package com.markstenback.numbersgame

import com.markstenback.numbersgame.utils.Constant
import groovy.cli.picocli.CliBuilder
import groovy.cli.picocli.OptionAccessor
import org.slf4j.Logger
import org.slf4j.LoggerFactory


/**
 *
 */
class NumbersGame {
    private static final Logger log = LoggerFactory.getLogger(NumbersGame.class)

    def static engine

    static void main (String[] args) {
        log.info ("Number Game - Initializing")

        OptionAccessor options = parseCli(args)
        engine = new NumbersGameEngine(options.getProperty("range") == false ? Constant.DEFAULT_RANGE : options.getProperty("range") as Integer)

        Boolean isCorrectGuess = false

        while (!isCorrectGuess) {
            isCorrectGuess = engine.guess()
        }

        System.println("You completed the game in ${engine.guesses} guesses.")
    }


    /**
     *
     * @param args
     * @return cli
     */
    private static OptionAccessor parseCli (String[] args) {
        CliBuilder cli = new CliBuilder(name: 'NumbersGame')
        cli.help('Print this message.')
        cli.range (type: Integer, argName: 'range=value', "Range of numbers in the game starting from 1 to [range]. Default is 100.")
        def options = cli.parse(args)

        log.info ("Command line input parsed.")

        return options
    }
}
