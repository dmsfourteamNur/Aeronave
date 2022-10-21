#!/bin/bash
name=${PWD##*/}
mvn clean compile assembly:single
rm -fr ./bin
mkdir -pv ./bin
arr_jar=$(find . -name '*.jar')
cd bin
for obj in $arr_jar; do
    $(jar xf ../$obj)
done
rm -fr META-INF/*.SF
rm -fr META-INF/*.RSA
rm -fr META-INF/*.DSA
rm -fr META-INF/MANIFEST.MF
echo "Manifest-Version: 1.0" >> META-INF/MANIFEST.MF
echo "Main-Class: App" >> META-INF/MANIFEST.MF
echo "" >> META-INF/MANIFEST.MF
echo "" >> META-INF/MANIFEST.MF
cd ../
jar cfM "$name.jar" -C bin/ .  # //TODOD  -C classPath
rm -fr bin
bash ./jacoco.sh
