/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name   : dummy.js
 * Purpose     : Checks if the program is in text file format
 * Author      : Alejandra Vasquez
 * Date        : 01/15/2018
 * Description : None
 * Notes       : None
 * Warnings    : None
 * Exceptions  : None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
let play = confirm("Do you want to flip a coin?");
let x = "";
let playerchoice = "";

while (play == 1 ) {
   playerchoice =  (prompt("Choose heads or tails")).toLowerCase();
   x = Math.floor(Math.random() * 2 + 1);
   if (x == 1) {
     x = "heads";
   } else {
     x = "tails";
   }
    if (playerchoice == x ) {
     alert(`Player guessed right! ${x} was flipped.` );
   } else {
     alert(`${x} was flipped. Maybe next time!`);
   }
   play = confirm("Do you want to flip a coin again? ")
}
alert("Good job playing!");
