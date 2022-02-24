package com.wilma.jobhunt.ending;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.File;

//Using this class to store the different endings
public class Ending {

    //this is the ending we'll use when the user explores the glowing rock
    public static void alienMessage() throws InterruptedException {

        String art =
                        " ██████╗  █████╗ ███╗   ███╗███████╗     ██████╗ ██╗   ██╗███████╗██████╗ \n" +
                        "██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██╔═══██╗██║   ██║██╔════╝██╔══██╗\n" +
                        "██║  ███╗███████║██╔████╔██║█████╗      ██║   ██║██║   ██║█████╗  ██████╔╝\n" +
                        "██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗\n" +
                        "╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║\n" +
                        " ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝     ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝\n" +
                        "                                                                          ";

        System.out.print(art);
        String art2 = "\t\n" +
                ".     .       .  .   . .   .   . .    +  .\n" +
                "  .     .  :     .    .. :. .___---------___.\n" +
                "       .  .   .    .  :.:. _\".^ .^ ^.  '.. :\"-_. .\n" +
                "    .  :       .  .  .:../:            . .^  :.:\\.\n" +
                "        .   . :: +. :.:/: .   .    .        . . .:\\\n" +
                " .  :    .     . _ :::/:               .  ^ .  . .:\\\n" +
                "  .. . .   . - : :.:./:                        .  .:\\\n" +
                "  .      .     . :..|:                    .  .  ^. .:|\n" +
                "    .       . : : ..||        .                . . !:|\n" +
                "  .     . . . ::. ::\\(                           . :)/\n" +
                " .   .     : . : .:.|. ######              .#######::|\n" +
                "  :.. .  :-  : .:  ::|.#######           ..########:|\n" +
                " .  .  .  ..  .  .. :\\ ########          :######## :/\n" +
                "  .        .+ :: : -.:\\ ########       . ########.:/\n" +
                "    .  .+   . . . . :.:\\. #######       #######..:/\n" +
                "      :: . . . . ::.:..:.\\           .   .   ..:/\n" +
                "   .   .   .  .. :  -::::.\\.       | |     . .:/\n" +
                "      .  :  .  .  .-:.\":.::.\\             ..:/\n" +
                " .      -.   . . . .: .:::.:.\\.           .:/\n" +
                ".   .   .  :      : ....::_:..:\\   ___.  :/\n" +
                "   .   .  .   .:. .. .  .: :.:.:\\       :/\n" +
                "     +   .   .   : . ::. :.:. .:.|\\  .:/|\n" +
                "     .         +   .  .  ...:: ..|  --.:|\n" +
                ".      . . .   .  .  . ... :..:..\"(  ..)\n";

        System.out.print(art2 + "\n");

        System.out.println("Silly human, you foolishly inspected the glowing rock.\nYou are now a puppet of the Glore Gax alien race....\n\n");//character name getter will be added into with this statement

        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(
                    new File("resources/alienmessage.wav")));
            Thread.sleep(1500);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}