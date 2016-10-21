#!/bin/sh
rm -rf q3neusm.jar
jar cfmv q3neusm.jar mymanifest.txt -C ../target/classes com/nsb/jnlp/usmjnlp/Main.class -C ../target/classes com/nsb/jnlp/usmjnlp/Utils.class
jarsigner -keystore nsbENMSKeys q3neusm.jar enmskey