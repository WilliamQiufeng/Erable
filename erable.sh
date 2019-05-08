mvn clean antlr4:antlr4  package install shade:shade
java -Xmx500M -cp "target/erable-1.0-SNAPSHOT.jar:$CLASSPATH" com.qiufeng.erable.Main $*