#!/bin/bash
mvn jacoco:prepare-agent test install jacoco:report
rm -rf target/jacoco
mkdir -p ./target/jacoco/

items=""
ELM=$(cat pom.xml | grep "module" | cut -d'>' -f2 | cut -d'<' -f1)
while IFS= read -r line ; do
    if [ -d "$line" ]; then
        if [ -d "$line/target/site" ]; then
            cp -r ./$line/target/site/jacoco/ ./target/jacoco/$line/
            items+="<div><a href='${line}/index.html'>${line}</a>  <iframe src='${line}' width='100%' height='500px'></iframe></div>"
            echo "$finded"
            echo "Copied $line"
        else
            echo "No coverage for $line"
        fi
    fi
done <<< "$ELM"

echo $ITEM > ./target/jacoco/index.html
cat > ./target/jacoco/index.html << EOF
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FourTeam-Jacoco</title>
</head>
<body>
    <h1>Fourteam - JACOCO</h1>
    ${items}

</body>
</html>
EOF
