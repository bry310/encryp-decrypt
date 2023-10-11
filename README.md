# BEncrypt-Decrypt

# Table of Contents
[Introduction](#introduction)
1. [Stage 1/6: Encrypted!](#stage-1)
2. [Stage 4/6: I command you](#stage-4)


## Introduction <a name="introduction"></a>
Privacy is an important matter is the realm of the Internet. When sending a message, you want to be sure that no-one but the addressee with the key can read it. The entirety of the modern Web is encrypted - take https for example! Don’t stay behind: hop on the encryption/decryption train and learn the essential basics while implementing this simple project.




## Stage 1/6: Encrypted! <a name="stage-1"></a>
* ## `Description`
    Today, encryption and decryption algorithms are everywhere to protect our data. They are vital for sites that handle sensitive data, such as e-commerce sites that accept online card payments and login areas that require users to enter their credentials. Complex encryption algorithms are behind the scenes to ensure the security of data.

    In this project, you will learn how to encrypt and decrypt messages and texts using simple algorithms. We should note that such algorithms are not suitable for industrial use because they can easily be cracked, but these algorithms illustrate general ideas of encryption.

* ## `Objectives`
    In the first stage, you need to manually encrypt the message we found a treasure! and print only the ciphertext (in lower case).

    To encrypt a message, replace each letter with the letter that is in the corresponding position from the end of the English alphabet (a→z, b→y, c→x, ... x→c, y →b, z→a). Do not replace spaces or exclamation marks.

    Use the given template to your program to print the ciphertext instead of the original message.

    The output should look like ## ##### # ########! where # is a lower-case English letter.


## Stage 4/6: I command you <a name="stage-4"></a>
* ## `Description`
    Modify the previous program to work with command-line arguments instead of the standard input.

    You need to put it in quotes to pass an argument that contains spaces as a single argument. So "Welcome to hyperskill!" becomes a single Welcome to hyperskill! argument without quotes. You need quotes to pass this argument, but you don't need to remove these quotes in the actual code!

* ## `Objectives`
    The program must parse three arguments: -mode, -key, and -data. The first argument should determine the program's mode (enc for encryption, dec for decryption). The second argument is an integer key to modify the message, and the third is a text or ciphertext to encrypt/decrypt.

    Arguments are guaranteed to be passed to the program. If, for some reason, they turn out to be wrong:

         1. If there is no -mode, the program should work in the enc mode;
        2. If there is no -key, the program should consider that it is 0;
        3. If there is no -data, the program should assume that data is an empty string.

    Keep in mind that the order of the arguments might be different. For example, -mode enc maybe at the end, at the beginning, or in the middle of the array.

* ## `Examples`
    Example 1: encryption; the arguments are: -mode enc -key 5 -data "Welcome to hyperskill!"

        \jqhtrj%yt%m~ujwxpnqq&

    Example 2: decryption; the arguments are: -key 5 -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec

        Welcome to hyperskill!

