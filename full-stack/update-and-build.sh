
cd todo-backend
rm -rf /target
mvn clean install -DskipTests=true

cd ..

docker-compose up -d