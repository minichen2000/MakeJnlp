del q3neusm.jar
jar cfmv q3neusm.jar mymanifest.txt -C ../target/classes com/nsb/jnlp/usmjnlp/Main.class
jarsigner -keystore myKeys q3neusm.jar jdc