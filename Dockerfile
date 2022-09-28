FROM openjdk:8
EXPOSE 8080
ADD target/BitCoinService.jar BitCoinService.jar
ENTRYPOINT ["java","-jar","BitCoinService.jar"]