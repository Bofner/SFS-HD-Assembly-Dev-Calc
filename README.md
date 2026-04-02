# Steelfinger Studios Hexadecimal to Decimal Multi-Base Calculator
This is a multipurpose base conversion calculator for those developing on older systems where manipulating binary and hexadecimal numbers is necesary. 

![](https://github.com/Bofner/SFS-HD-Assembly-Dev-Calc/blob/main/AssetIdeas/sfs.png)

## Conversion

The SFS-HD supports converting decimal, hexadecimal and binary numbers. Simply input the number you want converted. Decimal numbers are written with no prefix. 

![](https://github.com/Bofner/SFS-HD-Assembly-Dev-Calc/blob/main/AssetIdeas/30.png)

Hexadecimal numbers can be written with a leading $, # or 0x.

![](https://github.com/Bofner/SFS-HD-Assembly-Dev-Calc/blob/main/AssetIdeas/bof.png)

Binary numbers can be written with a leading % or 0b.

![](https://github.com/Bofner/SFS-HD-Assembly-Dev-Calc/blob/main/AssetIdeas/1001.png)

Viable commands for the SFS-HD
- ADD
- SUB
- MULT
- DIV
- AND
- OR
- XOR
- MODE

These commands take in 2 parameters, for example if you want to perform 1 + 2 you would write:

ADD 1, 2

![](https://github.com/Bofner/SFS-HD-Assembly-Dev-Calc/blob/main/AssetIdeas/1and2.png)

And the calculator will display your answer in decimal, hexadecimal and binary. 

![](https://github.com/Bofner/SFS-HD-Assembly-Dev-Calc/blob/main/AssetIdeas/1and2is3.png)

You can even mix and match values so long as you give them the appropriate prefix when using the commands.

![](https://github.com/Bofner/SFS-HD-Assembly-Dev-Calc/blob/main/AssetIdeas/mix.png)


~~The current version only supports 16-bit numbers, though 8-bit support may be added in the future.~~

If you have any concerns, please feel free to reach out!

## Updates:

#### Update: 2026/03/25
- Added support for 16-bit mode and 8-bit mode using the opcode MODE with valid operands being 8 or 16 (ie. "MODE 8" will change from the default 16-bit mode to 8-bit mode).

- Added functionality to the TAB key so that it will immediately write the currently displayed answer to the command line in decimal. Useful for doing continuous operations. Bases can be mixed during operations, so even if you are doing binary or hex exclusive operations, all other Opcodes will work just fine with the decimal representation being used. 

- Updated the project to be self contained in a .jar (Sorry about the previous version, this is my first real Java project). 

