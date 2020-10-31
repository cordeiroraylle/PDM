ESP8266, Firebase e Android Studio.

## ESP8266, Firebase e Android Studio.

Neste projeto estarei medindo a umidade do solo de uma planta e enviando esses dados em tempo real para a plataforma firebase, através de uma ESP8266, onde serão resgatados para exibição em um aplicativo android.

A ideia desse projeto é que o usuário possa fazer a leitura contínua da umidade do solo de uma planta e visualizar o estado dela via aplicativo, ou seja, saber se o solo se encontra seco, com uma umidade boa ou encharcado. A partir desses dados o usuário poderá tomar uma decisão mais consciente quanto ao cuidado de sua planta. 

O primeiro passo é a configuração da ESP8266 para que ela possa ler os dados corretamente e enviá-los para o firebase. Precisaremos de algumas bibliotecas para isso: